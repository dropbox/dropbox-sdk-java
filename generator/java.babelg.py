from __future__ import absolute_import, division, print_function, unicode_literals

import os
import argparse
import types

from collections import defaultdict, OrderedDict, Sequence
from contextlib import contextmanager
from functools import partial, total_ordering
from itertools import chain

from babelapi.api import (
    Api,
    ApiNamespace,
    ApiRoute,
)
from babelapi.generator import CodeGenerator
from babelapi.data_type import (
    DataType,
    Field,
    is_boolean_type,
    is_bytes_type,
    is_composite_type,
    is_numeric_type,
    is_nullable_type,
    is_list_type,
    is_string_type,
    is_struct_type,
    is_timestamp_type,
    is_union_type,
    is_void_type,
    StructField,
    TagRef,
    Union,
    unwrap_nullable,
    Void,
)

def _fixreserved(s):
    if s in _RESERVED_KEYWORDS:
        s += '_'
    return s


def _capwords(s):
    words = s.replace('/', '_').split('_')
    return ''.join(w[:1].upper() + w[1:] for w in words)


def _camelcase(s):
    s = _capwords(s)
    return s[:1].lower() + s[1:]


def _allcaps(s):
    return s.replace('/', '_').upper()


def capwords(s):
    return _fixreserved(_capwords(s))


def camelcase(s):
    return _fixreserved(_camelcase(s))


def allcaps(s):
    return _fixreserved(_allcaps(s))


def collapse_whitespace(s):
    return "\n".join(
        line.strip() for line in s.strip().splitlines()
    )


def split_paragraphs(s):
    paragraph = []
    for line in s.splitlines():
        line = line.strip()
        if line == '':
            if paragraph:
                yield "\n".join(paragraph)
                del paragraph[:]
        else:
            paragraph.append(line)

    if paragraph:
        yield "\n".join(paragraph)


def sanitize_pattern(pattern):
    return pattern.replace('\\', '\\\\').replace('"', '\\"')


_JAVADOC_REPLACEMENT_CHARS = (
    ('&', '&amp;'),
    ('<', '&lt;'),
    ('>', '&gt;'),
)
def sanitize_javadoc(doc):
    # sanitize &, <, > characters
    for char, code in _JAVADOC_REPLACEMENT_CHARS:
        doc = doc.replace(char, code)
    return doc


def unsanitize_javadoc(doc):
    for char, code in _JAVADOC_REPLACEMENT_CHARS:
        doc = doc.replace(code, char)
    return doc


def oxford_comma_list(values, conjunction='and'):
    if not values:
        return None
    elif len(values) == 1:
        return values[0]
    elif len(values) == 2:
        return '%s %s %s' % (values[0], conjunction, values[1])
    else:
        return '%s, %s %s' % (', '.join(values[:-1]), conjunction, values[-1])


def classname(s):
    return capwords(s)


def get_auth_types_set(namespace, noauth_as_user=False):
    if isinstance(namespace, NamespaceWrapper):
        namespace = namespace.as_babel

    routes = namespace.routes
    if not routes:
        return set()

    def auth_replace_noauth(route):
        auth_type = route.attrs.get('auth', 'user')
        if noauth_as_user and auth_type == 'noauth':
            return 'user'
        else:
            return auth_type

    return {
        auth_replace_noauth(route)
        for route in routes
    }


def get_namespaces_by_auth_types(api, auth_types):
    auth_types_set = set(auth_types)
    return [
        ns for ns, ns_auth_types in
        ((ns, get_auth_types_set(ns)) for ns in api.namespaces.values())
        # filter out empty or non-matching auth types
        if ns_auth_types and ns_auth_types.issubset(auth_types)
    ]


def get_ancestors(data_type):
    """Return list of (tag, data_type) pairs.

    The first pair is the root and always has tag None.
    The last pair represents the argument.

    The tag is only present if the data_type in that pair has an
    ancestor and is a member of that ancestore's enumerated subtypes.

    Suppose we have the following tree:

      struct A
      struct B extends A
      struct C extends B

    Without enumerated subtypes:
    - get_ancestors(C) returns [(None, A), (None, B), (None, C)]
    - get_ancestors(B) returns [(None, A), (None, B)]
    - get_ancestors(A) returns [(None, A)]

    Now add enumerated subtypes, so the tree becomes:

    struct A
      union
        b B
    struct B extends A
      union
        c C
    struct C extends B

    Now the return values are:
    - get_ancestors(C) returns [(None, A), ('b', B), ('c', C)]
    - get_ancestors(B) returns [(None, A), ('b', B)]
    - get_ancestors(A) returns [(None, A)]
    """
    ancestors = []
    while data_type is not None:
        parent_type = data_type.parent_type
        tag = None
        if parent_type is not None and parent_type.has_enumerated_subtypes():
            for field in parent_type.get_enumerated_subtypes():
                if field.data_type is data_type:
                    tag = field.name
                    break
            else:
                assert False, "Type %s not found in subtypes of ancestor %s" % (data_type.name,
                                                                                parent_type.name)
        ancestors.append((tag, data_type))
        data_type = parent_type
    ancestors.reverse()
    return ancestors


def get_enumerated_subtypes_recursively(data_type):
    """
    Returns a list of (tag, DataTypeWrapper) pairs.

    This method searches for all possible enumerated subtypes of the given data type. In the
    example:

    struct A
      union
        b B
        c C
    struct B extends A
      union
        d D
        e E
    struct C extends A
      union
        f F
    struct D extends B
    struct E extends B
    struct F extends C

    The following value would be returned:
    - get_enumerated_subtypes_recursively(A): [('b', B), ('c', C), ('b.d', D), ('b.e', E), ('c.f', F)]
    - get_enumerated_subtypes_recursively(B): [('b.d', D), ('b.e', E)]
    - get_enumerated_subtypes_recursively(C): [('c.f', F)]
    - get_enumerated_subtypes_recursively(D): []
    """
    assert isinstance(data_type, DataTypeWrapper), repr(data_type)

    if not data_type.has_enumerated_subtypes:
        return []

    subtypes = []
    def add_subtype(data_type):
        subtypes.append(data_type)
        if data_type.has_enumerated_subtypes:
            for subtype in data_type.enumerated_subtypes:
                add_subtype(subtype.data_type)

    add_subtype(data_type)

    result = []
    for subtype in subtypes:
        tag = '.'.join(name for name, _ in get_ancestors(subtype.as_babel) if name)
        result.append((tag, subtype))

    return result


def get_underlying_type(data_type, allow_lists=True):
    while True:
        if allow_lists and is_list_type(data_type):
            data_type = data_type.data_type
        elif is_nullable_type(data_type):
            data_type = data_type.data_type
        else:
            return data_type

def get_routes_with_arg_type(data_type, allow_lists=True):
    assert isinstance(data_type, DataTypeWrapper), repr(data_type)

    ctx = data_type._ctx

    routes = []
    for babel_namespace in ctx.api.namespaces.values():
        for babel_route in babel_namespace.routes:
            arg_type = get_underlying_type(babel_route.arg_data_type, allow_lists)

            if arg_type == data_type.as_babel:
                routes.append(RouteWrapper(ctx, babel_namespace, babel_route))

    return routes


def get_routes_with_result_type(data_type, allow_lists=True):
    assert isinstance(data_type, DataTypeWrapper), repr(data_type)

    ctx = data_type._ctx

    routes = []
    for babel_namespace in ctx.api.namespaces.values():
        for babel_route in babel_namespace.routes:
            result_type = get_underlying_type(babel_route.result_data_type, allow_lists)

            if result_type == data_type.as_babel:
                routes.append(RouteWrapper(ctx, babel_namespace, babel_route))

    return routes


def get_routes_with_error_type(data_type, allow_lists=True):
    assert isinstance(data_type, DataTypeWrapper), repr(data_type)

    ctx = data_type._ctx

    routes = []
    for babel_namespace in ctx.api.namespaces.values():
        for babel_route in babel_namespace.routes:
            err_type = get_underlying_type(babel_route.error_data_type, allow_lists)

            if err_type == data_type.as_babel:
                routes.append(RouteWrapper(ctx, babel_namespace, babel_route))

    return routes


def get_fields_with_data_type(data_type):
    assert isinstance(data_type, DataTypeWrapper), repr(data_type)

    ctx = data_type._ctx

    fields = []
    for babel_namespace in ctx.api.namespaces.values():
        for babel_data_type in babel_namespace.data_types:
            if is_composite_type(babel_data_type):
                for babel_field in babel_data_type.all_fields:
                    field_type = babel_field.data_type
                    while is_list_type(field_type) or is_nullable_type(field_type):
                        field_type = field_type.data_type

                    if field_type == data_type.as_babel:
                        fields.append(FieldWrapper(ctx, babel_data_type, babel_field))

    return fields

def get_data_types_with_parent_type(data_type):
    assert isinstance(data_type, DataTypeWrapper), repr(data_type)

    ctx = data_type._ctx

    babel_parent_type = data_type.as_babel

    data_types = []
    for babel_namespace in ctx.api.namespaces.values():
        for babel_data_type in babel_namespace.data_types:
            if babel_data_type.parent_type == babel_parent_type:
                data_types.append(DataTypeWrapper(ctx, babel_data_type))

    return data_types


def is_data_type_serializer_required_outside_package(data_type):
    def has_other_namespace(wrappers):
        return any(w.namespace != data_type.namespace for w in wrappers)

    if has_other_namespace(get_routes_with_arg_type(data_type)):
        return True

    if has_other_namespace(get_routes_with_result_type(data_type)):
        return True

    if has_other_namespace(get_routes_with_error_type(data_type)):
        return True

    if has_other_namespace(get_fields_with_data_type(data_type)):
        return True

    if data_type.is_struct and data_type.has_enumerated_subtypes:
        subtypes = get_enumerated_subtypes_recursively(data_type)
        if has_other_namespace(st for _, st in subtypes):
            return True

    return False


def is_data_type_required_outside_package(data_type):
    # only structs can be flattened by routes. Unions must be passed explicitly as arguments.
    if not data_type.is_struct:
        return True

    # we can hide structs if they are only used by a single route. In these cases, we make all
    # references to the struct point to the route instead. Since we flatten the struct fields into
    # the route method call, the users don't have to be aware that we use a POJO in the background.
    #
    # Note, if no routes use this data type, then it may be used elsewhere and we will have to make
    # it public for references. This only works when exactly 1 routes uses it as an argument.
    routes_with_arg = get_routes_with_arg_type(data_type)
    if len(routes_with_arg) != 1:
        return True

    # make sure single route is in same namespace
    if routes_with_arg[0].namespace != data_type.namespace:
        return True

    # if we return this type in any of our routes, it must be made available outside the package
    if get_routes_with_result_type(data_type):
        return True

    # Routes will flatten struct fields so callers don't have to pass in an instance of the
    # struct. However, we must verify the struct is not a field of some other struct.
    fields_with_type = get_fields_with_data_type(data_type)
    if fields_with_type:
        return True

    # if any data types inherit form this data types, then make it public
    sub_data_types = get_data_types_with_parent_type(data_type)
    if sub_data_types:
        return True

    return False


def get_all_required_data_types_for_namespace(namespace):
    data_types = []
    seen_types = set()

    def add_data_type(data_type):
        if not data_type:
            return
        if data_type in seen_types:
            return
        if not (data_type.is_union or data_type.is_struct):
            return

        data_types.append(data_type)
        seen_types.add(data_type)

        add_data_type(data_type.parent)
        for field in data_type.all_fields:
            add_data_type(field.data_type)

    for data_type in namespace.data_types:
        add_data_type(data_type)

    return data_types


class GeneratorContext(object):
    """
    Context for a single execution of the JavaCodeGenerator.

    This class is used to reference the Babel tree being generated, along with information about the
    Java package of the currently open file and existing Java imports.

    :ivar :class:`babelapi.generator.CodeGenerator` code_generator: code generator instance created by Babel for generating the Java code
    :ivar :class:`babelapi.api.Api` api: Babel tree to generate into Java
    """

    def __init__(self, code_generator, api):
        assert isinstance(code_generator, CodeGenerator), repr(code_generator)
        assert isinstance(api, Api), repr(api)

        self._g = code_generator
        self._api = api
        self._current_class = None
        self._current_imports = set()

    @property
    def api(self):
        """
        The Babel Api tree being generated.

        :rtype: babelapi.api.Api
        """
        return self._api

    @property
    def g(self):
        """
        Reference to the JavaCodeGenerator instance. Useful for calling CodeGenerator methods like emit().

        :rtype: JavaCodeGenerator
        """
        return self._g

    @property
    def base_package(self):
        """
        The base Java package where generated classes should reside (configured by commandline
        argument). Note that classes may reside within subpackages of this base package.

        :rtype: str
        """
        return self._g.args.package

    @property
    def current_java_class(self):
        """
        Fully-qualified name of the Java class currently being generated, or ``None`` if no class
        file is open for generation.

        :rtype: str

        """
        return self._current_class

    @property
    def current_java_package(self):
        """
        Java package of the Java class currently being generated, or ``None`` if no class file is
        open for generation.

        :rtype: str

        """
        if self._current_class:
            return self._current_class.rsplit('.', 1)[0]
        else:
            return None

    @property
    def current_imports(self):
        """
        Set of fully-qualified Java class names imported by the class currently being generated.

        The set will never contain package-local imports since those classes do not require import
        statements.

        This set is empty if :field:`current_java_class` is ``None``.

        :rtype: set[str]

        """
        # filter out package-local imports
        local_package = self.current_java_package
        if local_package:
            local_prefix = local_package + '.'
            def is_local(import_):
                return import_.startswith(local_prefix) and '.' not in import_[len(local_prefix):]
            return frozenset(i for i in self._current_imports if not is_local(i))
        else:
            return frozenset(self._current_imports)

    def add_imports(self, *imports):
        """
        Adds the fully-qualified Java class names to the set of imports for the currently generated
        class.

        Imports may be fully-qualified class name strings (e.g. ``"com.foo.Bar"``) or :class:`JavaClass`
        instances.

        :field:`current_java_class` must not be ``None``. Use :meth:`scoped` to specify a current
        class if necessary.

        """
        assert self._current_class, "No Java class scoped for generation."

        get_name = lambda v: v.rsplit('.', 1)[-1]

        current_class_prefix = self._current_class + '.'

        existing_names = set(get_name(import_) for import_ in self._current_imports)

        # avoid issues where we import a class with the same name as us
        existing_names.add(get_name(self._current_class))

        for import_ in imports:
            if not isinstance(import_, JavaClass):
                java_class = JavaClass(self, import_)
            else:
                java_class = import_

            # already imported or local name (not fully qualified)
            if java_class.import_name in self._current_imports or not java_class.package:
                continue

            # ignore nested classes inside our current class
            if java_class.import_name == self._current_class:
                continue

            name = get_name(java_class.import_name)
            if name not in existing_names:
                existing_names.add(name)
                self._current_imports.add(java_class.import_name)

    @contextmanager
    def scoped(self, fq_class):
        """
        Scopes this context to the specified, fully-qualified Java class name. While within this
        context manager, calls to :field:`current_java_class` will return this class name.

        Use this method when generating a new class file to help organize imports.

        """
        assert fq_class
        assert '.' in fq_class, "Class must be fully qualified: %r" % fq_class

        prev_class = self._current_class
        prev_imports = self._current_imports
        try:
            self._current_class = fq_class
            self._current_imports = set()
            yield
        finally:
            self._current_class = prev_class
            self._current_imports = prev_imports


@total_ordering
class JavaClass(object):
    """
    Represents a Java class name.

    This class is a convenience for handling Java classes. This class lets you reference a Java
    class explicitly by its fully-qualified name or its short-name. You can also let the correct
    reference be automatically determined based on the current context and imports.

    Examples:

        ctx = # ... GeneratorContext
        ctx.current_imports => {"com.dropbox.common.A", "java.util.B"}
        ctx.current_java_class => "com.dropbox.files.C"
        ctx.current_java_package => "com.dropbox.files"

        str(JavaClass(ctx, "com.dropbox.files.D"))   => "D"                    # package local
        str(JavaClass(ctx, "com.dropbox.common.E"))  => "com.dropbox.common.E" # not imported
        str(JavaClass(ctx, "com.dropbox.common.A"))  => "Other"                # already imported
        str(JavaClass(ctx, "com.dropbox.files.C.X")) => "X"                    # nested inner class
        str(JavaClass(ctx, "java.util.B.Y"))         => "B.Y"                  # nested class outside current class

    :ivar :class:`GeneratorContext` ctx: context for current generation
    :ivar str fq_name: Fully-qualified Java class name
    """

    def __init__(self, ctx, fq_name):
        self._ctx = ctx
        self._fq_name = fq_name

        package_parts = fq_name.split('.')

        # Handle nested classes, like:
        #
        #  com.foo.Bar.Wop
        #
        #  name => Wop
        #  package => com.foo
        #  static_name => Bar.Wop
        #  import_name => com.foo.Bar
        #
        self._name = package_parts[-1]

        for i, part in enumerate(package_parts):
            is_last = i == len(package_parts) - 1
            is_class_name = (part and part[0].isupper())
            if is_last or is_class_name:
                self._package = '.'.join(package_parts[:i])
                self._static_name = '.'.join(package_parts[i:])
                self._import_name = '.'.join(package_parts[:i+1])
                break

    @property
    def fq(self):
        """
        Fully-qualified Java class name.

        Example: com.foo.Bar.Wop => com.foo.Bar.Wop

        :rtype: str
        """
        return self._fq_name

    @property
    def name(self):
        """
        Short name of Java class.

        Example: com.foo.Bar.Wop => Wop

        :rtype: str
        """
        return self._name

    @property
    def package(self):
        """
        Name of package containing this Java class.

        Example: com.foo.Bar.Wop => com.foo

        :rtype: str
        """
        return self._package

    @property
    def import_name(self):
        """
        Fully-qualified Java class name that should be imported to use this class. Note that this
        value will equal :field:`fq` unless this class is a nested class.

        Example: com.foo.Bar.Wop => com.foo.Bar
                 org.baz.Der => org.baz.Der

        :rtype: str
        """
        return self._import_name

    @property
    def is_nested(self):
        """
        Whether or not this class is nested within another Java class.

        :rtype: bool
        """
        return self._static_name != self._name

    def __repr__(self):
        return '%s(%s)' % (type(self), self._fq_name)

    def __str__(self):
        """
        Produces the appropriate string representation of this class depending on the current
        context (e.g. current imports and name of class currently being generated).
        """
        # no package, so just return the name
        if not self._package:
            return self._name

        # inner class? (e.g. com.foo.CommitInfo.Builder)
        current_class = self._ctx.current_java_class
        if current_class and self._fq_name.startswith(current_class + '.'):
            return self._fq_name[len(current_class) + 1:]

        # package-local class? we don't need to import these
        local_package = self._ctx.current_java_package
        if local_package == self._package:
            return self._static_name

        # check if we already imported this name into our current context
        if self._import_name in self._ctx.current_imports:
            return self._static_name

        # last resort, display fully-qualified name
        return self._fq_name

    def __hash__(self):
        return hash(self._fq_name)

    def __eq__(self, other):
        if isinstance(other, type(self)):
            return self._fq_name == other._fq_name
        return False

    def __lt__(self, other):
        assert isinstance(other, type(self)), repr(other)
        return self._fq_name < other._fq_name


class BabelWrapper(object):
    """
    Wrapper around a Babel object (e.g. ApiNamespace, ApiRoute, DataType, Field, etc).

    This wrapper provides convenience methods for converting Babel names and references to Java
    package, class, types, and methods names.

    :ivar :class:`GeneratorContext` ctx: context for current generation
    :ivar :class:`babelapi.api.ApiNamespace` namespace: Babel namespace of ``babel_ent``
    :ivar babel_ent: Babel entity to wrap (e.g. ApiNamespace, ApiRoute, etc)
    """

    def __init__(self, ctx, namespace, babel_ent):
        assert isinstance(ctx, GeneratorContext), repr(ctx)
        assert babel_ent is not None
        assert namespace is None or isinstance(namespace, ApiNamespace), repr(namespace)

        self._ctx = ctx
        self._babel_namespace = namespace
        self._babel_ent = babel_ent

    @property
    def namespace(self):
        """
        Namespace of the wrapped Babel entity, or ``None`` if entity has no namespace (e.g. primitive data type)

        :rtype: NamespaceWrapper
        """
        if self._babel_namespace:
            return NamespaceWrapper(self._ctx, self._babel_namespace)
        else:
            return None

    @property
    def babel_doc(self):
        """
        Babel documentation for wrapped Babel entity or empty string if entity has no documentation.

        :rtype: str
        """
        assert hasattr(self._babel_ent, "doc"), repr(self) + " has no doc"
        return self._babel_ent.doc or ""

    @property
    def babel_filename(self):
        """
        Base file name of babel spec file containing wrapped Babel entity definition.

        :rtype: str
        """
        assert hasattr(self._babel_ent, "_token"), repr(self) + " has no Babel token"
        return os.path.basename(self._babel_ent._token.path)

    @property
    def as_babel(self):
        """
        Wrapped Babel entity.
        """
        return self._babel_ent

    @property
    def babel_name(self):
        """
        Name of Babel entity.

        :rtype: str
        """
        return self._babel_ent.name

    @property
    def fq_babel_name(self):
        """
        Fully-qualified Babel entity name.

        :rtype: str
        """
        return '.'.join((self.namespace.babel_name, self.babel_name))

    @property
    def java_class(self):
        """
        Generated Java class that maps to the wrapped Babel entity. May not be implemented for
        entities that do not map to classes (e.g. fields).

        :rtype: :class:`JavaClass`
        """
        raise NotImplementedError("element has no Java class name")

    @property
    def java_field(self):
        """
        Java variable name to use for referencing this Babel entity in generated code.

        :rtype: str
        """
        return camelcase(self.babel_name)

    @property
    def java_package(self):
        """
        Java package that should contain the generated class for the wrapped Babel entity.

        May be ``None`` if the wrapped entity has no namespace (e.g. primitive type).

        :rtype: str
        """
        assert self._ctx.base_package, "No base package in context"
        if self._babel_namespace:
            name = self._babel_namespace.name.lower().replace('_', '')
            return '.'.join((self._ctx.base_package.rstrip('.'), name))
        else:
            return None

    def _as_java_class(self, name):
        """
        Converts a fully-qualified or short Java class name into a :class:`JavaClass` object using the
        current generator context.

        Methods returning Java class names should use this method to ensure they always return the
        correct :class:`JavaClass`.

        :param str name: fully-qualified or short Java class name

        :rtype: :class:`JavaClass`
        """
        assert isinstance(name, str), repr(name)
        package = self.java_package
        # only add package if we don't have one already. use
        # upper-casing of class names as indicator of whether this is
        # a class name like 'Foo.Builder' or a fq name like
        # 'com.foo.Bar'
        if package and name and name[0].isupper():
            fq_name = package + '.' + name
        else:
            fq_name = name
        return JavaClass(self._ctx, fq_name)

    def __str__(self):
        if self._babel_namespace:
            return '%s(%s.%s)' % (type(self).__name__, self._babel_namespace.name, self.babel_name)
        else:
            return '%s(%s)' % (type(self).__name__, self.babel_name)

    def __repr__(self):
        return '%s(%s)' % (type(self), repr(self.as_babel))

    def __eq__(self, other):
        if isinstance(other, type(self)):
            return self._babel_ent == other._babel_ent
        return False

    def __hash__(self):
        return hash(self._babel_ent)


class NamespaceWrapper(BabelWrapper):
    """
    Wrapper around a Babel namespace.

    :ivar :class:`GeneratorContext` ctx: context for current generation
    :ivar :class:`babelapi.api.ApiNamespace` namespace: Babel namespace
    """

    def __init__(self, ctx, namespace):
        super(NamespaceWrapper, self).__init__(ctx, namespace, namespace)

    @property
    def babel_filenames(self):
        """
        List of Babel spec base file names defining this namespace.

        :rtype: list[str]
        """
        filenames = OrderedDict() # use as ordered set
        # use first data type
        for data_type in self.data_types:
            filenames[data_type.babel_filename] = None
        # fallback to first route
        for route in self.routes:
            filenames[route.babel_filename] = None
        # TODO: fallback to aliases. enable assert after doing this
        #assert filenames, "namespace not associated with any babel files: %s" % self.babel_name

        return filenames.keys()

    @property
    def babel_filename(self):
        """
        Please use :field:`babel_filenames` for namespaces.
        """
        raise AssertionError("use babel_filenames for namespaces")

    @property
    def fq_babel_name(self):
        return self.babel_name

    @property
    def data_types(self):
        """
        Data types defined in this namespace.

        :rtype: tuple[:class:`DataTypeWrapper`]
        """
        return tuple(
            DataTypeWrapper(self._ctx, dt)
            for dt in self.as_babel.linearize_data_types()
        )

    @property
    def routes(self):
        """
        Routes defined in this namespace.

        :rtype: tuple[:class:`RouteWrapper`]
        """
        return tuple(
            RouteWrapper(self._ctx, self.as_babel, route)
            for route in self.as_babel.routes
        )

    def java_class(self, auth):
        return self._as_java_class(classname('dbx_' + auth + '_' + self.babel_name + '_requests'))

    @property
    def java_serializers_class(self):
        return self._as_java_class(classname('dbx_' + self.babel_name + '_serializers'))

    @property
    def java_getter(self):
        return camelcase(self.babel_name)

class RouteWrapper(BabelWrapper):
    """
    Wrapper around a Babel route.

    :ivar :class:`GeneratorContext` ctx: context for current generation
    :ivar :class:`babelapi.api.ApiNamespace` namespace: Babel namespace containing route
    :ivar :class:`babelapi.api.ApiRoute` route: Babel route to wrap
    """

    def __init__(self, ctx, namespace, route):
        assert isinstance(route, ApiRoute)
        super(RouteWrapper, self).__init__(ctx, namespace, route)

    @property
    def java_class(self):
        auth = self.auth_style if self.auth_style != 'noauth' else 'user'
        return self.namespace.java_class(auth)

    @property
    def arg(self):
        """
        Arg data type.

        :rtype: :class:`DataTypeWrapper`
        """
        return DataTypeWrapper(self._ctx, self.as_babel.arg_data_type)

    @property
    def result(self):
        """
        Result data type.

        :rtype: :class:`DataTypeWrapper`
        """
        return DataTypeWrapper(self._ctx, self.as_babel.result_data_type)

    @property
    def error(self):
        """
        Error data type.

        :rtype: :class:`DataTypeWrapper`
        """
        return DataTypeWrapper(self._ctx, self.as_babel.error_data_type)

    @property
    def has_arg(self):
        """
        Whether this route has a arg type.

        :rtype: bool
        """
        return not self.arg.is_void

    @property
    def has_result(self):
        """
        Whether this route has a result type.

        :rtype: bool
        """
        return not self.result.is_void

    @property
    def has_error(self):
        """
        Whether this route has an error type.

        :rtype: bool
        """
        return not self.error.is_void

    @property
    def has_optional_arg_fields(self):
        """
        Whether this route has a arg type containing optional fields.

        :rtype: bool
        """
        return self.arg.has_optional_fields

    @property
    def is_deprecated(self):
        return self.as_babel.deprecated is not None

    @property
    def deprecated_by(self):
        info = self.as_babel.deprecated
        if info is None:
            return None

        babel_route = info.by
        if babel_route is None:
            return None

        # must find namespace for this route
        for babel_namespace in self._ctx.api.namespaces.values():
            namespace_route = babel_namespace.route_by_name.get(babel_route.name, None)
            if namespace_route == babel_route:
                return RouteWrapper(self._ctx, babel_namespace, babel_route)

        assert False, "Failed to find namespace for route: %r" % babel_route

    @property
    def java_method(self):
        """
        Name of Java method that maps to this route.

        :rtype: str
        """
        return camelcase(self.babel_name)

    @property
    def supports_builder(self):
        """
        Whether this route supports using a builder pattern for building the request.

        :rtype: bool
        """
        return self.arg.supports_builder

    @property
    def java_builder_class(self):
        """
        Java class mapping to this route's request builder.

        :rtype: :class:`JavaClass`
        """
        assert self.supports_builder
        return self._as_java_class(classname(self.babel_name + '_builder'))

    @property
    def java_builder_class_with_inheritance(self):
        """
        Java class name mapping to this route's request builder, including inheritance
        (e.g. "FooBuilder extends BarBuilder").

        Class names will be formatted based on the current context (see :class:`JavaClass`)

        :rtype: str
        """
        class_name = self.java_builder_class
        request_style = self.request_style
        result_type = self.result.java_type()
        error_type = self.error.java_type()
        if self.has_error:
            exc_type = self.error.java_exception_class
        else:
            exc_type = JavaClass(self._ctx, 'com.dropbox.core.DbxException')

        if request_style == 'upload':
            return '%s extends %s<%s,%s,%s>' % (
                class_name,
                self._as_java_class('com.dropbox.core.v2.DbxUploadStyleBuilder'),
                result_type,
                error_type,
                exc_type,
            )
        elif request_style == 'download':
            return '%s extends %s<%s>' % (
                class_name,
                self._as_java_class('com.dropbox.core.v2.DbxDownloadStyleBuilder'),
                result_type,
            )
        else:
            return class_name

    @property
    def java_builder_method(self):
        """
        Name of Java method that maps to creating a request builder for this route.

        :rtype: str
        """
        assert self.supports_builder
        return camelcase(self.babel_name + '_builder')

    @property
    def java_uploader_class(self):
        """
        Java class mapping to this route's uploader, if the route is an `upload` style route.

        :rtype: :class:`JavaClass`
        """
        assert self.request_style == 'upload'
        return self._as_java_class(classname(self.babel_name + '_uploader'))

    @property
    def java_downloader_class(self):
        """
        Java class mapping to this route's downloader, if the route is an `download` style route.

        :rtype: :class:`JavaClass`
        """
        assert self.request_style == 'download'
        return self._as_java_class('com.dropbox.core.DbxDownloader')

    @property
    def request_style(self):
        """
        Route request style.

        :rtype: str
        """
        return self.as_babel.attrs.get('style', 'rpc')

    @property
    def auth_style(self):
        """
        Route auth style.

        :rtype: str
        """
        return self.as_babel.attrs.get('auth', 'user')

    @property
    def host(self):
        """
        Route host.

        :rtype: str
        """
        return self.as_babel.attrs.get('host', 'api')

    @property
    def url_path(self):
        """
        Server URL path associated with this route.

        :rtype: str
        """
        return '2/%s/%s' % (self.namespace.babel_name, self.babel_name)

    @property
    def java_exception_class(self):
        """
        Java class mapping to this route's error type, if the route has an error type.

        :rtype: :class:`JavaClass`
        """
        assert self.has_error, "This route has no error type"
        return self.error.java_exception_class

    @property
    def java_return_type(self):
        """
        Return type of Java method that issues this route (see :field:`java_method`).

        The return type classes will be formatted according to the current context (see
        :class:`JavaClass`)

        :rtype: str
        """
        style = self.request_style
        if style == 'upload':
            return str(self.java_uploader_class)
        elif style == 'download':
            return '%s<%s>' % (self.java_downloader_class, self.result.java_type())
        else:
            if self.has_result:
                return str(self.result.java_type())
            else:
                return 'void'

    @property
    def java_builder_return_type(self):
        """
        Return type of Java method that creates a builder for issuing requests for this route (see
        :field:`java_builder_method`).

        The return type classes will be formatted according to the current context (see
        :class:`JavaClass`)

        :rtype: str
        """
        assert self.supports_builder, "Route doesn't support builder-style requests"
        return str(self.java_builder_class)

    @property
    def java_throws(self):
        """
        List of exceptions thrown by issuing requests for this route.

        :rtype: tuple[:class:`JavaClass`]
        """
        dbx_exc = JavaClass(self._ctx, 'com.dropbox.core.DbxException')
        if self.has_error and self.request_style != 'upload':
            # upload routes don't receive the server response in this method call. The request is
            # completed with the uploader
            return (self.error.java_exception_class, dbx_exc)
        else:
            return (dbx_exc,)

class DataTypeWrapper(BabelWrapper):
    """
    Wrapper around a Babel data type.

    :ivar :class:`GeneratorContext` ctx: context for current generation
    :ivar :class:`babelapi.data_type.DataType` data_type: Babel data type to wrap
    """

    def __init__(self, ctx, data_type):
        assert isinstance(data_type, DataType)
        if is_nullable_type(data_type):
            ns_data_type = data_type.data_type
        else:
            ns_data_type = data_type
        namespace = getattr(ns_data_type, "namespace", None)
        super(DataTypeWrapper, self).__init__(ctx, namespace, data_type)

    @property
    def parent(self):
        if (self.is_struct or self.is_union) and self.as_babel.parent_type:
            return DataTypeWrapper(self._ctx, self.as_babel.parent_type)
        else:
            return None

    @property
    def subtypes(self):
        if self.is_union or self.is_struct:
            return tuple(
                DataTypeWrapper(self._ctx, subtype)
                for subtype in self.as_babel.subtypes
            )
        return ()

    @property
    def all_fields(self):
        if self.is_union:
            return tuple(FieldWrapper(self._ctx, self.as_babel, f) for f in self.as_babel.all_fields)
        elif self.is_struct:
            # properly handle inheritence of fields
            fields_by_name = {
                f.babel_name: f
                for f in self.all_parent_fields
            }
            fields_by_name.update(
                (f.name, FieldWrapper(self._ctx, self.as_babel, f))
                for f in self.as_babel.fields
            )

            # sanity check
            field_names = set(fields_by_name.keys())
            all_field_names = {f.name for f in self.as_babel.all_fields}
            missing_fields = field_names.symmetric_difference(all_field_names)
            assert not missing_fields, "Missing fields for %s: %s" % (self, missing_fields)

            return tuple(fields_by_name[f.name] for f in self.as_babel.all_fields)
        else:
            return ()

    @property
    def all_required_fields(self):
        return tuple(f for f in self.all_fields if f.is_required)

    @property
    def all_optional_fields(self):
        return tuple(f for f in self.all_fields if f.is_optional)

    @property
    def fields(self):
        if self.is_union or self.is_struct:
            return tuple(FieldWrapper(self._ctx, self.as_babel, f) for f in self.as_babel.fields)
        else:
            return ()

    @property
    def required_fields(self):
        return tuple(f for f in self.fields if f.is_required)

    @property
    def optional_fields(self):
        return tuple(f for f in self.fields if f.is_optional)

    @property
    def all_parent_fields(self):
        parent = self.parent
        if parent:
            return parent.all_fields
        else:
            return ()

    @property
    def all_required_parent_fields(self):
        return tuple(f for f in self.all_parent_fields if f.is_required)

    @property
    def catch_all_field(self):
        if self.is_union and self.as_babel.catch_all_field is not None:
            return FieldWrapper(self._ctx, self.as_babel, self.as_babel.catch_all_field)
        else:
            return None

    @property
    def has_optional_fields(self):
        if self.is_struct:
            return any(f.is_optional for f in self.all_fields)
        else:
            return False

    @property
    def list_data_type(self):
        assert self.is_list
        return DataTypeWrapper(self._ctx, self.as_babel.data_type)

    @property
    def nullable_data_type(self):
        assert self.is_nullable
        return DataTypeWrapper(self._ctx, self.as_babel.data_type)

    @property
    def supports_builder(self):
        if self.is_struct:
            n_optional = len(self.as_babel.all_optional_fields)
            return n_optional > 1
        else:
            return False

    @property
    def is_enum(self):
        if self.is_union:
            has_value_fields = any(f.has_value for f in self.all_fields)
            return not has_value_fields
        else:
            return False

    @property
    def is_union(self):
        return is_union_type(self.as_babel)

    @property
    def is_struct(self):
        return is_struct_type(self.as_babel)

    @property
    def is_list(self):
        return is_list_type(self.as_babel)

    @property
    def is_nullable(self):
        return is_nullable_type(self.as_babel)

    @property
    def is_primitive(self):
        if not self.is_nullable:
            return (
                is_boolean_type(self.as_babel) or
                is_numeric_type(self.as_babel) or
                is_void_type(self.as_babel)
            )
        return False

    @property
    def is_void(self):
        return is_void_type(self.as_babel)

    @property
    def is_enumerated_subtype(self):
        return self.as_babel.is_member_of_enumerated_subtypes_tree()

    @property
    def has_enumerated_subtypes(self):
        return self.as_babel.has_enumerated_subtypes()

    @property
    def enumerated_subtypes(self):
        assert self.has_enumerated_subtypes
        return tuple(
            FieldWrapper(self._ctx, self.as_babel, f)
            for f in self.as_babel.get_enumerated_subtypes()
        )

    @property
    def is_collapsible(self):
        if self.is_nullable:
            return self.nullable_data_type.is_collapsible
        else:
            return self.is_struct and not self.is_enumerated_subtype

    @property
    def requires_validation(self):
        babel_dt = self.as_babel
        if is_list_type(babel_dt):
            return True
        elif is_numeric_type(babel_dt):
            return any(r is not None for r in (
                babel_dt.min_value,
                babel_dt.max_value,
            ))
        elif is_string_type(babel_dt):
            return any(r is not None for r in (
                babel_dt.min_length,
                babel_dt.max_length,
                babel_dt.pattern,
            ))
        else:
            return False

    @property
    def java_class(self):
        assert not self.is_primitive, "primitive data types do not have custom classes"
        if self.is_struct or self.is_union:
            return self._as_java_class(classname(self.babel_name))
        else:
            return self.java_type(boxed=True, generics=False)

    @property
    def java_class_with_inheritance(self):
        if self.parent:
            return '%s extends %s' % (self.java_class, self.parent.java_class)
        else:
            return str(self.java_class)

    @property
    def java_builder_class(self):
        assert self.is_struct, "only structs have builder classes: %r" % self
        # builders are nested in their class (e.g. CommitInfo.Builder)
        return self._as_java_class(classname(self.babel_name) + '.Builder')

    @property
    def java_builder_class_with_inheritance(self):
        if self.parent and self.parent.supports_builder:
            return '%s extends %s' % (self.java_builder_class, self.parent.java_builder_class)
        else:
            return str(self.java_builder_class)

    @property
    def java_builder_field(self):
        return camelcase(self.babel_name + '_builder')

    @property
    def java_exception_class(self):
        assert not self.is_primitive, "primitive data types cannot have exception classes: %r" % self
        return self._as_java_class(classname(self.babel_name + '_exception'))

    @property
    def java_serializer_singleton(self):
        assert self.is_struct or self.is_union, repr(self)
        return _fixreserved('_' + self.babel_name + '_SERIALIZER');

    @property
    def java_serializer(self):
        core_serializers_class = JavaClass(self._ctx, 'com.dropbox.core.babel.BabelSerializers')
        if self.is_nullable:
            return '%s.nullable(%s)' % (core_serializers_class, self.nullable_data_type.java_serializer)
        elif self.is_list:
            return '%s.list(%s)' % (core_serializers_class, self.list_data_type.java_serializer)
        elif self.is_struct or self.is_union:
            return '%s.Serializer.INSTANCE' % self.java_class
        else:
            return '%s.%s()' % (core_serializers_class, camelcase(self.babel_name))

    def java_type(self, boxed=True, generics=True):
        if self.is_nullable:
            return self.nullable_data_type.java_type(boxed=True, generics=generics)

        elif self.is_list:
            java_list_class = JavaClass(self._ctx, 'java.util.List')
            if generics:
                return '%s<%s>' % (java_list_class, self.list_data_type.java_type())
            else:
                return java_list_class

        else:
            type_map = _TYPE_MAP_BOXED if boxed else _TYPE_MAP_UNBOXED
            if self.babel_name in type_map:
                return JavaClass(self._ctx, type_map[self.babel_name])
            else:
                assert is_composite_type(self.as_babel), repr(self)
                return self.java_class

    def java_value(self, babel_value):
        if isinstance(babel_value, bool):
            return 'true' if babel_value else 'false'
        if isinstance(babel_value, float):
            return repr(babel_value)  # Because str() drops the last few digits.
        if self.babel_name in ('Int64', 'UInt64', 'UInt32'):
            return str(babel_value) + 'L'  # Need exact type match for boxed values.
        if self.is_union:
            assert isinstance(babel_value, TagRef), (self, babel_value)
            assert self.as_babel is babel_value.union_data_type, (self, babel_value)
            for field in self.all_fields:
                if field.babel_name == babel_value.tag_name:
                    if self.is_enum:
                        return '%s.%s' % (field.containing_data_type.java_class, field.java_enum)
                    elif field.has_value:
                        return '%s.%s()' % (field.containing_data_type.java_class, field.java_factory_method)
                    else:
                        return '%s.%s' % (field.containing_data_type.java_class, field.java_singleton)
            else:
                assert False, "Could not find tag '%s' in '%s'" % (babel_value.tag_name, self)
        return str(babel_value)

    @property
    def java_name(self):
        return camelcase(self.babel_name)


class FieldWrapper(BabelWrapper):
    """
    Wrapper around a Babel field.

    :ivar :class:`GeneratorContext` ctx: context for current generation
    :ivar :class:`babelapi.data_type.DataType` data_type: Babel data type containing this field
    :ivar :class:`babelapi.data_type.Field` field: Babel field to wrap
    """

    def __init__(self, ctx, containing_data_type, field):
        assert isinstance(containing_data_type, DataType), repr(containing_data_type)
        assert hasattr(containing_data_type, "namespace"), repr(containing_data_type)
        assert isinstance(field, Field), repr(field)
        super(FieldWrapper, self).__init__(ctx, containing_data_type.namespace, field)
        self._containing_babel_data_type = containing_data_type

    @property
    def fq_babel_name(self):
        return '.'.join((self.namespace.babel_name, self.containing_data_type.babel_name, self.babel_name))

    @property
    def babel_doc(self):
        doc = super(FieldWrapper, self).babel_doc
        if self.is_catch_all and not doc:
            return """
            Catch-all used for unknown tag values returned by the Dropbox servers.

            Receiving a catch-all value typically indicates this SDK version is not up to
            date. Consider updating your SDK version to handle the new tags.
            """

        return doc

    @property
    def containing_data_type(self):
        return DataTypeWrapper(self._ctx, self._containing_babel_data_type)

    @property
    def data_type(self):
        return DataTypeWrapper(self._ctx, self.as_babel.data_type)

    @property
    def is_required(self):
        assert not self.containing_data_type.is_union, "unions don't have required fields"
        return self.as_babel in self.containing_data_type.as_babel.all_required_fields

    @property
    def is_optional(self):
        assert self.containing_data_type.is_struct, repr(self.containing_data_type)
        return self.as_babel in self.containing_data_type.as_babel.all_optional_fields

    @property
    def is_catch_all(self):
        catch_all_field = self.containing_data_type.catch_all_field
        return catch_all_field is not None and self.as_babel is catch_all_field.as_babel

    @property
    def is_enumerated_subtype(self):
        containing_dt = self.containing_data_type
        if containing_dt.has_enumerated_subtypes:
            return self.as_babel in tuple(subtype.as_babel for subtype in containing_dt.enumerated_subtypes)
        return False

    @property
    def is_deprecated(self):
        return getattr(self.as_babel, "deprecated", False)

    @property
    def has_default(self):
        return self.containing_data_type.is_struct and self.as_babel.has_default

    @property
    def has_value(self):
        return not self.data_type.is_void

    @property
    def is_collapsible(self):
        return self.containing_data_type.is_union and self.data_type.is_collapsible

    @property
    def default_value(self):
        assert self.containing_data_type.is_struct, "only structs have default values"
        assert self.has_default, "value has no default"
        return self.data_type.java_value(self.as_babel.default)

    def java_type(self, generics=True):
        return self.data_type.java_type(boxed=self.data_type.is_nullable, generics=generics)

    @property
    def java_name(self):
        babel_name = self.babel_name
        if self.containing_data_type.is_enum:
            return self.java_enum
        elif self.containing_data_type.is_union:
            return camelcase(babel_name + '_value')
        else:
            return camelcase(babel_name)

    @property
    def java_enum(self):
        return self.tag_name

    @property
    def tag_name(self):
        return allcaps(self.babel_name)

    @property
    def java_singleton(self):
        return allcaps(self.babel_name)

    def java_type_and_name(self, generics=True):
        return '%s %s' % (self.java_type(generics=generics), self.java_name)

    @property
    def java_is_union_type_method(self):
        assert not self.containing_data_type.is_enum, "enum fields don't have isType() methods: %s" % self.containing_data_type
        return camelcase('is_' + self.babel_name)

    @property
    def java_getter(self):
        assert not self.containing_data_type.is_enum, "enum fields don't have getter methods"
        return camelcase('get_' + self.java_name)

    @property
    def java_builder_setter(self):
        assert not self.containing_data_type.is_enum, "enum fields don't have setter methods"
        assert not self.data_type.is_list, "list fields use adders, not setters"
        return camelcase('with_' + self.java_name)

    @property
    def java_builder_list_add(self):
        assert not self.containing_data_type.is_enum, "enum fields don't have setter methods"
        assert self.data_type.is_list, "only list fields use adders, use setter instead."
        return camelcase('add_' + self.java_name)

    @property
    def java_builder_list_add_all(self):
        assert not self.containing_data_type.is_enum, "enum fields don't have setter methods"
        assert self.data_type.is_list, "only list fields use adders, use setter instead."
        return camelcase('add_all_' + self.java_name)

    @property
    def java_factory_method(self):
        assert not self.containing_data_type.is_enum, "enum fields don't have factory methods"
        assert self.has_value, "field does not have a value, so does not require a factory method"
        return camelcase(self.babel_name)

    def __str__(self):
        namespace = self.namespace.babel_name if self.namespace else ''
        data_type = self.containing_data_type.babel_name
        name = self.babel_name
        return '%s(%s)' % (type(self).__name__, '.'.join(filter(None, (namespace, data_type, name))))


class JavadocGenerator(object):
    """
    Javadoc generator that intelligently inspects Babel items to product appropriate Javadoc
    annotations.

    :ivar :class:`GeneratorContext` ctx: context for current generation
    """

    def __init__(self, ctx):
        assert isinstance(ctx, GeneratorContext), repr(ctx)
        self._ctx = ctx

    def lookup_babel_ref(self, tag, val, context=None):
        assert isinstance(tag, str), repr(tag)
        assert isinstance(val, str), repr(val)
        assert context is None or isinstance(context, BabelWrapper), repr(context)

        if tag == 'route':
            namespace, route = self._split_id(val, 2)
            return self._lookup_route(namespace, route, context)
        elif tag == 'type':
            namespace, data_type = self._split_id(val, 2)
            return self._lookup_data_type(namespace, data_type, context)
        elif tag == 'field':
            namespace, data_type, field = self._split_id(val, 3)
            return self._lookup_field(namespace, data_type, field, context)
        elif tag == 'link':
            return None
        elif tag == 'val':
            return None
        else:
            assert False, 'Unsupported tag (:%s:`%s`)' % (tag, val)

    def javadoc_ref(self, element, builder=False):
        assert isinstance(element, BabelWrapper), repr(element)

        if isinstance(element, RouteWrapper):
            ref = self._javadoc_route_ref(element, builder=builder)
        elif isinstance(element, DataTypeWrapper):
            ref = self._javadoc_data_type_ref(element, builder=builder)
        elif isinstance(element, FieldWrapper):
            ref = self._javadoc_field_ref(element)
        else:
            assert False, "Unsupported element type: %s" % repr(element)

        return sanitize_javadoc(ref)

    def javadoc_ref_handler(self, tag, val, context=None):
        element = self.lookup_babel_ref(tag, val, context)

        # use {@code ...} tag for unresolved references so we don't have broken links in our Javadoc
        if tag == 'route':
            if element:
                ref = self._javadoc_route_ref(element)
            else:
                self._ctx.g.logger.warn('Unable to resolve Babel reference (:%s:`%s`) [ctx=%s]' % (tag, val, context))
                ref = '{@code %s}' % camelcase(val)
        elif tag == 'type':
            if element:
                ref = self._javadoc_data_type_ref(element)
            else:
                self._ctx.g.logger.warn('Unable to resolve Babel reference (:%s:`%s`) [ctx=%s]' % (tag, val, context))
                ref = '{@code %s}' % classname(val)
        elif tag == 'field':
            if element:
                ref = self._javadoc_field_ref(element)
            else:
                self._ctx.g.logger.warn('Unable to resolve Babel reference (:%s:`%s`) [ctx=%s]' % (tag, val, context))
                ref = '{@code %s}' % camelcase(val)
        elif tag == 'link':
            anchor, link = val.rsplit(' ', 1)
            # unsanitize from previous sanitize calls
            anchor = unsanitize_javadoc(anchor)
            # do not sanitize this HTML
            return '<a href="%s">%s</a>' % (link, anchor)
        elif tag == 'val':
            # Note that all valid Babel literals happen to be valid Java literals.
            ref = '{@code %s}' % val
        else:
            assert False, 'Unsupported tag (:%s:`%s`)' % (tag, val)

        return sanitize_javadoc(ref)

    def translate_babel_doc(self, doc, context=None):
        if isinstance(doc, BabelWrapper):
            wrapper = doc
            doc = wrapper.babel_doc
            context = wrapper

        if doc:
            handler = lambda tag, val: self.javadoc_ref_handler(tag, val, context=context)
            return self._ctx.g.process_doc(sanitize_javadoc(doc), handler)
        else:
            return doc

    def generate_javadoc(self, doc, context=None, fields=(), params=(), returns=None, throws=(), deprecated=None, allow_defaults=True):
        # convenience for inferring various arguments from our wrapper objects
        if isinstance(doc, BabelWrapper):
            wrapper = doc
            doc = wrapper.babel_doc
            context = context or wrapper

        assert isinstance(doc, str), repr(doc)
        assert isinstance(context, BabelWrapper) or context is None, repr(context)
        assert isinstance(fields, (Sequence, types.GeneratorType)), repr(fields)
        assert isinstance(params, (Sequence, types.GeneratorType, OrderedDict)), repr(params)
        assert isinstance(returns, (str, BabelWrapper)) or returns is None, repr(returns)
        assert isinstance(throws, (Sequence, types.GeneratorType, OrderedDict)), repr(throws)
        assert isinstance(deprecated, (RouteWrapper, bool)) or deprecated is None, repr(deprecated)

        # look at context to determine if we are deprecated, unless explicitly specified
        if deprecated is None and context is not None:
            if isinstance(context, RouteWrapper):
                deprecated = context.deprecated_by or context.is_deprecated
            elif isinstance(context, FieldWrapper):
                deprecated = context.is_deprecated
            else:
                assert not hasattr(context, "is_deprecated"), repr(context)

        params_doc = self.javadoc_params(fields, allow_defaults=allow_defaults)
        params_doc.update(self._translate_ordered_collection(params, context))
        returns_doc = self.translate_babel_doc(returns, context)
        throws_doc = self._translate_ordered_collection(throws, context)
        deprecated_doc = self.javadoc_deprecated(deprecated)

        requires_validation = any(self._field_validation_requirements(f) for f in fields)
        if requires_validation:
            exception = "IllegalArgumentException"
            if exception in throws_doc:
                throws_doc[exception] += ". Also thrown if any argument does not meet its preconditions."
            else:
                throws_doc[exception] = "If any argument does not meet its preconditions."

        return self.generate_javadoc_raw(
            self.translate_babel_doc(doc, context),
            params=params_doc,
            returns=returns_doc,
            throws=throws_doc,
            deprecated=deprecated_doc,
        )

    def generate_javadoc_raw(self, doc, params=None, returns=None, throws=None, deprecated=None):
        # deprecated can be an empty str, which means no doc
        if not any((doc, params, returns, throws, deprecated is not None)):
            return

        out = self._ctx.g.emit
        prefix = ' * '
        attr_doc_prefix = prefix + (' ' * 4)

        def emit_attrs(tag, attrs):
            if attrs:
                out(prefix.rstrip())
                attr_prefix = ''.join((prefix, tag, ' '))

                for attr_name, attr_doc in attrs.items():
                    # Javadoc complains about tags that are missing documentation, except for
                    # @deprecated
                    if not attr_doc.strip():
                        if tag == '@deprecated':
                            self._ctx.g.emit_wrapped_text(
                                tag,
                                initial_prefix=prefix,
                                subsequent_prefix=attr_doc_prefix)
                        continue

                    if attr_name:
                        doc_text = '  '.join((attr_name, attr_doc))
                    else:
                        doc_text = attr_doc
                    self._ctx.g.emit_wrapped_text(
                        collapse_whitespace(doc_text),
                        initial_prefix=attr_prefix,
                        subsequent_prefix=attr_doc_prefix
                    )

        out('/**')

        if doc:
            first_paragraph = True
            for paragraph in split_paragraphs(doc.strip()):
                if not first_paragraph:
                    out(prefix.rstrip())
                    if paragraph:
                        paragraph = ''.join(('<p> ', paragraph, ' </p>'))
                else:
                    first_paragraph = False
                self._ctx.g.emit_wrapped_text(paragraph, initial_prefix=prefix, subsequent_prefix=prefix)

        emit_attrs('@param', params)
        emit_attrs('@return', { "": returns } if returns else None)
        emit_attrs('@throws', throws)
        # deprecated can be empty string, which still means we should emit
        emit_attrs('@deprecated', { "": deprecated } if deprecated is not None else None)

        out(' */')
        # compiler requires a separate annotation outside the javadoc to display warnings about
        # using obsolete APIs.
        if deprecated is not None:
            out('@Deprecated')

    def javadoc_params(self, fields, allow_defaults=True):
        assert isinstance(fields, (Sequence, types.GeneratorType)), repr(fields)
        for f in fields:
            assert isinstance(f, FieldWrapper), "fields must contain FieldWrapper instances, found: " + repr(f)

        params = OrderedDict()
        for field in fields:
            param_name = field.java_name
            param_babel_doc = field.babel_doc
            param_doc = self.translate_babel_doc(param_babel_doc, field)

            # add '.' at end of doc if we have a doc and its missing.
            if param_doc.strip() and not param_doc.endswith('.'):
                param_doc += '.'

            preconditions = self._field_validation_requirements(field)
            if preconditions:
                param_doc += " Must %s." % oxford_comma_list(preconditions, conjunction='and')

            if allow_defaults and field.has_default:
                param_doc += " Defaults to {@code %s} when set to {@code null}." % field.default_value

            param_doc = param_doc.strip()
            if param_doc:
                params[param_name] = param_doc

        return params

    def javadoc_throws(self, field, value_name=None):
        assert isinstance(field, FieldWrapper), repr(field)
        assert value_name is None or isinstance(value_name, str), repr(value_name)

        reasons = self._field_validation_requirements(field, as_failure_reasons=True)
        throws = OrderedDict()

        if reasons:
            reasons_list = oxford_comma_list(reasons, conjunction='or')
            throws["IllegalArgumentException"] = "if {@code %s} %s." % (value_name, reasons_list)

        return throws

    def javadoc_deprecated(self, deprecated):
        assert isinstance(deprecated, (RouteWrapper, bool)) or deprecated is None, repr(deprecated)

        if isinstance(deprecated, RouteWrapper):
            return 'use %s instead.' % self.javadoc_ref(deprecated)
        elif isinstance(deprecated, bool) and deprecated:
            return ''
        else:
            return None

    def _translate_ordered_collection(self, collection, context):
        assert isinstance(collection, (Sequence, types.GeneratorType, OrderedDict)), repr(collection)

        if isinstance(collection, OrderedDict):
            collection = collection.items()

        return OrderedDict(
            (k, self.translate_babel_doc(v, context))
            for k, v in collection
        )

    def _field_validation_requirements(self, field, as_failure_reasons=False):
        assert isinstance(field, FieldWrapper), repr(field)

        if not field.has_value:
            return None

        data_type = field.data_type
        nullable = data_type.is_nullable
        if nullable:
            data_type = data_type.nullable_data_type

        babel_dt = data_type.as_babel
        requirements = []
        def add_req(precondition, failure_reason):
            if as_failure_reasons:
                requirements.append(failure_reason)
            else:
                requirements.append(precondition)

        for condition, (precondition, failure_reason) in (
                ('min_items', ('contain at least %s items', 'has fewer than %s items')),
                ('max_items', ('contain at most %s items', 'has more than %s items')),
                ('min_value', ('be greater than or equal to %s', 'is less than %s')),
                ('max_value', ('be less than or equal to %s', 'is greater than %s')),
                ('min_length', ('have length of at least %s', 'is shorter than %s')),
                ('max_length', ('have length of at most %s', 'is longer than %s'))
        ):
            if hasattr(babel_dt, condition):
                val = getattr(babel_dt, condition)
                if val is not None:
                    add_req(precondition % val, failure_reason % val)

        if is_list_type(babel_dt):
            add_req('not contain a {@code null} item', 'contains a {@code null} item')
        elif is_string_type(babel_dt) and babel_dt.pattern is not None:
            pattern = sanitize_pattern(babel_dt.pattern)
            add_req('match pattern "{@code %s}"' % pattern, 'does not match pattern "{@code %s}"' % pattern)

        if not (nullable or data_type.is_primitive or field.has_default):
            add_req('not be {@code null}', 'is {@code null}')

        return requirements

    def _split_id(self, babel_id, max_parts):
        assert isinstance(babel_id, str), repr(babel_id)
        assert max_parts > 0, "max_parts must be positive"

        parts = babel_id.split('.')
        if len(parts) > max_parts:
            # mark tag as invalid... can't raise exception here since we don't validate babel docs
            self._ctx.g.logger.warn('Malformed Babel reference value: `%s`' % babel_id)
            return (None,) * max_parts
        else:
            filler = (None,) * (max_parts - len(parts))
            return filler + tuple(parts)

    def _lookup_babel_namespace(self, namespace, context):
        assert isinstance(namespace, str) or namespace is None, repr(namespace)
        assert isinstance(context, BabelWrapper) or context is None, repr(context)

        if namespace:
            return self._ctx.api.namespaces.get(namespace)
        elif context:
            namespace_element = context.namespace
            if namespace_element:
                return namespace_element.as_babel

        return None

    def _lookup_route(self, namespace, route, context):
        assert isinstance(route, str) or route is None, repr(route)
        if namespace: assert route, "Cannot specify namespace name without route name"

        babel_namespace = self._lookup_babel_namespace(namespace, context)

        if babel_namespace and route:
            babel_route = babel_namespace.route_by_name.get(route)
            return RouteWrapper(self._ctx, babel_namespace, babel_route)
        elif context and not route:
            if isinstance(context, RouteWrapper):
                return context

        # we don't keep track of datatype hierarchy within a route since a datatype may be used by
        # multiple routes.
        return None

    def _lookup_data_type(self, namespace, data_type, context):
        assert isinstance(data_type, str) or data_type is None, repr(data_type)
        if namespace: assert data_type, "Cannot specify namespace name without data_type name"

        babel_namespace = self._lookup_babel_namespace(namespace, context)

        if babel_namespace and data_type:
            babel_data_type = babel_namespace.data_type_by_name.get(data_type)
            return DataTypeWrapper(self._ctx, babel_data_type)
        elif context and not data_type:
            if isinstance(context, FieldWrapper):
                # we might be within a field, which has a containing data type
                return context.containing_data_type
            elif isinstance(context, DataTypeWrapper):
                return context

        return None

    def _lookup_field(self, namespace, data_type, field, context):
        assert isinstance(field, str) or field is None, repr(data_type)
        if data_type: assert field, "Cannot specify data_type name without field name"

        data_type = self._lookup_data_type(namespace, data_type, context)

        if data_type and field:
            for data_type_field in data_type.all_fields:
                if data_type_field.babel_name == field:
                    return data_type_field
        elif context and not field:
            if isinstance(context, FieldWrapper):
                return context

        # Field is the lowest you can go. No way to use context to derive field
        return None

    def _javadoc_route_ref(self, route, builder=False):
        assert isinstance(route, RouteWrapper), repr(route)

        class_name = route.java_class
        method_name = route.java_method
        arg_data_type = route.arg

        if not route.has_arg:
            args = ''
        elif arg_data_type.is_struct:
            if builder and route.supports_builder:
                method_name = route.java_builder_method
            types = (str(f.java_type(generics=False)) for f in arg_data_type.all_required_fields)
            args = ','.join(types)
        else:
            args = arg_data_type.java_type(generics=False)
        return '{@link %s#%s(%s)}' % (class_name, method_name, args)

    def _javadoc_data_type_ref(self, data_type, builder=False):
        assert isinstance(data_type, DataTypeWrapper), repr(data_type)
        if data_type.is_primitive:
            return '{@code %s}' % data_type.java_type(boxed=False, generics=False)
        elif builder and data_type.supports_builder:
            return '{@link %s}' % data_type.java_builder_class
        else:
            return '{@link %s}' % data_type.java_class

    def _javadoc_field_ref(self, field):
        assert isinstance(field, FieldWrapper), repr(field)

        # Address issue T76930:
        #
        # We want to avoid referencing to `RouteArg` struct classes that are never used in our
        # public route methods. When we generate routes with struct args, we generally do it like
        # so:
        #
        #   private RouteResult routeName(RouteArg);
        #   public RouteResult routeName(field1, field2, field3);
        #   public RouteResultBuilder routeNameBuilder(field1, field2, field3);
        #
        # So if the field's containing data type is a struct, try to find out if that struct is
        # uniqued used as a route argument and make the Javadoc reference point to the route method
        # instead of the struct class.
        containing_data_type = field.containing_data_type
        if containing_data_type.is_struct:
            routes = get_routes_with_arg_type(containing_data_type)

            # we only handle cases where the struct appears as the argument to a single route
            if len(routes) == 1:
                # the struct should not appear anywhere else besides as a route argument
                return 'the {@code %s} argument to %s' % (field.java_name, self._javadoc_route_ref(routes[0]))

        # can't reference a package-private data type.
        assert is_data_type_required_outside_package(containing_data_type), field.fq_babel_name

        # fallback to standard ref
        if field.containing_data_type.is_enum:
            field_name = field.java_enum
        elif field.containing_data_type.is_union:
            if field.has_value:
                field_name = field.java_factory_method
            else:
                field_name = field.java_singleton
        else:
            field_name = field.java_getter

        return '{@link %s#%s}' % (field.containing_data_type.java_class, field_name)


class JavaImportGenerator(object):
    def __init__(self, ctx):
        assert isinstance(ctx, GeneratorContext), repr(ctx)
        self._ctx = ctx
        # take first 2 components of base package as our corp prefix (e.g. com.dropbox.core -> com.dropbox)
        self._corp_package_prefix = '.'.join(self._ctx.base_package.split('.', 2)[:2])

    def generate_imports(self):
        out = self._ctx.g.emit

        imports = self._ctx.current_imports

        # group all our corp imports into one spot. use the first two package parts for root corp
        # package (e.g. com.dropbox.core.v2 -> com.dropbox)
        if self._corp_package_prefix:
            corp_imports = set(import_ for import_ in imports if import_.startswith(self._corp_package_prefix))
        else:
            corp_imports = set()
        imports = imports - corp_imports

        # now group the rest by the first package part
        grouped = defaultdict(set)
        for import_ in imports:
            root = import_.split('.', 1)[0]
            grouped[root].add(import_)

        # now write out the groups in this order:
        #
        #    corp packages
        #    3rd party packages
        #    java
        #    javax

        if corp_imports:
            out('')
            for import_ in sorted(corp_imports):
                out('import %s;' % import_)

        for root, imports in sorted(grouped.items(), key=lambda e: e[0]):
            if root in ('java', 'javax'):
                continue

            out('')
            for import_ in sorted(imports):
                out('import %s;' % import_)

        for root in ('java', 'javax'):
            imports = grouped.get(root)
            if imports:
                out('')
                for import_ in sorted(imports):
                    out('import %s;' % import_)

    def add_imports_for_namespace(self, namespace, auth):
        assert isinstance(namespace, NamespaceWrapper), repr(namespace)

        self._ctx.add_imports(
            'com.dropbox.core.DbxException',
            'com.dropbox.core.DbxWrappedException',
            'com.dropbox.core.http.HttpRequestor',
            'com.dropbox.core.v2.DbxRawClientV2',
            'java.util.HashMap',
            'java.util.Map',
        )
        for route in namespace.routes:
            route_auth = route.auth_style if route.auth_style != 'noauth' else 'user'
            if route_auth == auth:
                self.add_imports_for_route(route)

    def add_imports_for_route(self, route):
        self._add_imports_for_data_type(route.arg)
        self._add_imports_for_data_type(route.result)

        if route.has_error:
            self._ctx.add_imports(route.error.java_exception_class)
        else:
            self._ctx.add_imports('com.dropbox.core.DbxApiException')

        if route.request_style == 'upload':
            self._ctx.add_imports('com.dropbox.core.DbxUploader')
            if route.supports_builder:
                self._ctx.add_imports('com.dropbox.core.v2.DbxUploadStyleBuilder')
        elif route.request_style == 'download':
            self._ctx.add_imports('com.dropbox.core.DbxDownloader')
            if route.supports_builder:
                self._ctx.add_imports('com.dropbox.core.v2.DbxDownloadStyleBuilder')

    def add_imports_for_route_builder(self, route):
        route_auth = route.auth_style if route.auth_style != 'noauth' else 'user'
        self._ctx.add_imports(
            route.namespace.java_class(route_auth),
            route.arg.java_builder_class,
            'com.dropbox.core.DbxException',
        )
        for field in route.arg.all_optional_fields:
            self.add_imports_for_field(field)
        if route.has_error:
            self._ctx.add_imports(route.error.java_exception_class)
        else:
            self._ctx.add_imports('com.dropbox.core.DbxApiException')

    def add_imports_for_route_uploader(self, route):
        self._ctx.add_imports(
            'com.dropbox.core.DbxWrappedException',
            'com.dropbox.core.DbxUploader',
            'com.dropbox.core.http.HttpRequestor',
            'java.io.IOException',
        )
        if route.has_result:
            self._ctx.add_imports(route.result.java_class)
        if route.has_error:
            self._ctx.add_imports(
                route.error.java_class,
                route.error.java_exception_class,
            )
        else:
            self._ctx.add_imports('com.dropbox.core.DbxApiException')

    def add_imports_for_data_type(self, data_type, include_serialization=True):
        assert isinstance(data_type, DataTypeWrapper), repr(data_type)
        assert data_type.is_struct or data_type.is_union, repr(data_type)

        self._add_imports_for_data_type(data_type)

        if include_serialization:
            self._add_imports_for_data_type_serializers(data_type)

        for field in data_type.all_fields:
            self.add_imports_for_field(field)

        # check if we need to import parent type
        if data_type.is_struct and data_type.parent:
            self._ctx.add_imports(data_type.parent.java_class)

    def add_imports_for_exception_type(self, data_type):
        error_type_class = data_type.java_class
        self._ctx.add_imports(
            'com.dropbox.core.DbxApiException',
            'com.dropbox.core.LocalizedText',
            error_type_class,
        )

    def add_imports_for_field(self, field):
        self._add_imports_for_data_type(field.data_type)

    def _add_imports_for_data_type(self, data_type):
        if data_type.is_primitive:
            return

        elif data_type.is_list:
            self._ctx.add_imports(data_type.java_class)
            self._add_imports_for_data_type(data_type.list_data_type)

        elif data_type.is_nullable:
            self._add_imports_for_data_type(data_type.nullable_data_type)

        else:
            self._ctx.add_imports(data_type.java_class)

    def _add_imports_for_data_type_serializers(self, data_type):
        self._ctx.add_imports(
            'java.io.IOException',
            'com.fasterxml.jackson.core.JsonGenerationException',
            'com.fasterxml.jackson.core.JsonGenerator',
            'com.fasterxml.jackson.core.JsonParseException',
            'com.fasterxml.jackson.core.JsonParser',
            'com.fasterxml.jackson.core.JsonToken',
            'com.dropbox.core.babel.BabelSerializers',
        )
        if data_type.is_struct:
            self._ctx.add_imports('com.dropbox.core.babel.StructSerializer')
        elif data_type.is_union:
            self._ctx.add_imports('com.dropbox.core.babel.UnionSerializer')

    def __repr__(self):
        return '%s(imports=%s)' % (self.__class__.__name__, self._ctx.current_imports)


_CMDLINE_PARSER = argparse.ArgumentParser(prog='java-generator')
_CMDLINE_PARSER.add_argument('--package', type=str, help='base package name', required=True)

class JavaCodeGenerator(CodeGenerator):
    cmdline_parser = _CMDLINE_PARSER

    def generate(self, api):
        """
        Toplevel code generation method.

        This is called by babelapi.cli.
        """
        ctx = GeneratorContext(self, api)
        JavaCodeGenerationInstance(ctx).generate()


class JavaCodeGenerationInstance(object):
    """
    Java code generation instance for a particular Babel tree (:class:`babelapi.api.Api`).

    :ivar :class:`GeneratorContext` ctx: context for current generation
    """

    def __init__(self, ctx):
        assert isinstance(ctx, GeneratorContext), repr(ctx)
        self.ctx = ctx
        self.doc = JavadocGenerator(self.ctx)
        self.importer = JavaImportGenerator(self.ctx)

    @property
    def g(self):
        """
        Reference to the JavaCodeGenerator instance. Useful for calling CodeGenerator methods like emit().

        :rtype: JavaCodeGenerator
        """
        return self.ctx.g

    @contextmanager
    def new_file(self, element, class_name=None, package_doc=None):
        """
        Opens a new Java class file for writing and scopes the current generator context to that file.

        All generated Java classes should call this method to ensure imports are properly handled
        and Javadoc annotation references are correct.

        :param :class:`BabelWrapper` element: Babel wrapped element that maps to the new Java class file.
        :param str class_name: Name of new Java class, defaults to ``element.java_class.name``
        :param str package_doc: Documentation for package (if generating a ``package-info.java`` class file).
        """
        out = self.g.emit

        if package_doc:
            assert class_name == 'package-info', "Only package-info.java files can contain package Javadoc"

        # create a fully-qualified java class reference
        if isinstance(class_name, JavaClass):
            java_class = class_name
        elif class_name:
            if '.' in class_name:
                java_class = JavaClass(self.ctx, class_name)
            else:
                java_class = JavaClass(self.ctx, '.'.join((element.java_package, class_name)))
        else:
            java_class = element.java_class

        with self.ctx.scoped(java_class.fq):
            package_relpath = self.create_package_path(java_class.package)
            file_name = java_class.name + '.java'
            file_path = os.path.join(package_relpath, file_name)
            babel_filenames = element.babel_filenames if isinstance(element, NamespaceWrapper) else [element.babel_filename]

            with self.g.output_to_relative_path(file_path):
                self.generate_file_header(element)
                if package_doc:
                    self.doc.generate_javadoc(package_doc)
                out('package %s;' % java_class.package)

                yield

    def generate(self):
        self.generate_dbx_clients()

        for babel_namespace in self.ctx.api.namespaces.values():
            namespace = NamespaceWrapper(self.ctx, babel_namespace)
            self.generate_namespace(namespace)

    def generate_file_header(self, element=None):
        out = self.g.emit

        if isinstance(element, NamespaceWrapper):
            babel_filenames = element.babel_filenames
        elif isinstance(element, BabelWrapper):
            babel_filenames = (element.babel_filename,)
        else:
            assert element is None, repr(element)
            babel_filenames = None

        out('/* DO NOT EDIT */')
        if babel_filenames:
            out('/* This file was generated from %s */' % ', '.join(babel_filenames))
        else:
            out('/* This file was generated by Babel */')
        out('')

    def create_package_path(self, package_name):
        components = package_name.split('.')
        package_relpath = os.path.join(*components)
        package_fullpath = os.path.join(self.g.target_folder_path, package_relpath)
        if not os.path.isdir(package_fullpath):
            self.g.logger.info('Creating directory %s', package_fullpath)
            os.makedirs(package_fullpath)
        return package_relpath

    def generate_dbx_clients(self):
        out = self.g.emit

        self.generate_dbx_client(self.ctx.base_package, 'DbxClientV2Base', 'user')
        self.generate_dbx_client(self.ctx.base_package, 'DbxTeamClientV2Base', 'team')
        self.generate_dbx_client(self.ctx.base_package, 'DbxAppClientV2Base', 'app')

    def generate_dbx_client(self, package_name, class_name, auth):
        out = self.g.emit

        if auth == 'user':
            auth_types_filter = (auth, 'noauth')
        else:
            auth_types_filter = (auth,)

        namespaces = [
            NamespaceWrapper(self.ctx, ns)
            for ns in get_namespaces_by_auth_types(self.ctx.api, auth_types_filter)
        ]

        package_relpath = self.create_package_path(package_name)
        file_name = os.path.join(package_relpath, class_name + '.java')
        fq_class_name = package_name + '.' + class_name
        with self.g.output_to_relative_path(file_name), self.ctx.scoped(fq_class_name):
            self.generate_file_header()
            out('package %s;' % package_name)

            for namespace in namespaces:
                self.ctx.add_imports(namespace.java_class(auth))

            self.importer.generate_imports()

            out('')
            self.doc.generate_javadoc(
                """
                Base class for %s auth clients.
                """ % auth
            )
            with self.g.block('public class %s' % class_name):
                out('protected final DbxRawClientV2 _client;')
                out('')
                for namespace in namespaces:
                    out('private final %s %s;' % (namespace.java_class(auth), namespace.java_field))

                out('')
                self.doc.generate_javadoc(
                    """
                    For internal use only.
                    """,
                    params=(('_client', 'Raw v2 client to use for issuing requests'),)
                )
                with self.g.block('protected %s(DbxRawClientV2 _client)' % class_name):
                    out('this._client = _client;')
                    for namespace in namespaces:
                        out('this.%s = new %s(_client);' % (
                            namespace.java_field, namespace.java_class(auth)
                        ))

                for namespace in namespaces:
                    out('')
                    self.doc.generate_javadoc(
                        """
                        Returns client for issuing requests in the {@code "%s"} namespace.
                        """ % namespace.babel_name,
                        returns="Dropbox %s client" % namespace.babel_name
                    )
                    with self.g.block("public %s %s()" % (namespace.java_class(auth), namespace.java_getter)):
                        out('return %s;' % namespace.java_field)

    def generate_namespace(self, namespace):
        # create class files for all namespace data types in this package
        for data_type in namespace.data_types:
            self.generate_data_type(data_type)

        for route in namespace.routes:
            # generate exception classes for routes
            self.generate_exception_type(route)

            # generate per-route uploader helpers
            self.generate_uploader_type(route)

            # generate all necessary builder classes for routes that support it
            self.generate_builder_type(route)

        # add documentation to our packages
        self.generate_package_javadoc(namespace)

        for auth in get_auth_types_set(namespace, noauth_as_user=True):
            self.generate_namespace_for_auth(namespace, auth)

    def generate_namespace_for_auth(self, namespace, auth):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        with self.new_file(namespace, class_name=namespace.java_class(auth).fq):
            self.importer.add_imports_for_namespace(namespace, auth)
            self.importer.generate_imports()

            out('')
            javadoc('Routes in namespace "%s" that support %s auth.' % (namespace.babel_name, auth))
            with self.g.block('public final class %s' % namespace.java_class(auth)):
                out('// namespace %s' % namespace.babel_name)
                out('')
                out('private final DbxRawClientV2 client;')

                out('')
                with self.g.block('public %s(DbxRawClientV2 client)' % namespace.java_class(auth)):
                    out('this.client = client;')

                for route in namespace.routes:
                    route_auth = route.auth_style if route.auth_style != 'noauth' else 'user'
                    if route_auth != auth:
                        continue

                    out('')
                    out('//')
                    out('// route %s/%s' % (route.namespace.babel_name, route.babel_name))
                    out('//')
                    self.generate_route_base(route)
                    self.generate_route(route, required_only=True)
                    # we don't use builders if we have too few optional fields. Instead we just
                    # create another method call.
                    if route.has_optional_arg_fields and not route.supports_builder:
                        self.generate_route(route, required_only=False)
                    self.generate_route_builder(route)

    def generate_package_javadoc(self, namespace):
        classes = oxford_comma_list(tuple(
            "{@link %s}" % namespace.java_class(auth)
            for auth in get_auth_types_set(namespace, noauth_as_user=True)
        ), conjunction='and')
        package_doc = (
            """
            %s

            See %s for a list of possible requests for this namespace.
            """ % (namespace.babel_doc, classes)
        )

        with self.new_file(namespace, 'package-info', package_doc=package_doc):
            pass

    def generate_route_base(self, route):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        arg_type = route.arg
        result_type = route.result
        error_type = route.error

        if route.request_style == 'upload':
            returns="Uploader used to upload the request body and finish request."
        elif route.request_style == 'download':
            returns="Downloader used to download the response body and view the server response."
        elif route.has_result and (result_type.is_struct or result_type.is_union):
            returns=result_type
        else:
            returns=None

        return_type = route.java_return_type
        throws = ', '.join(map(str, route.java_throws))
        if route.has_arg:
            method_arg_type = arg_type.java_type()
            method_arg_name = arg_type.java_name
            if arg_type.is_union:
                deprecated = route.deprecated_by
                visibility = 'public'
            else:
                deprecated = None # Don't mark private methods deprecated since we don't care
                visibility = ''   # package private
            signature = '%s %s %s(%s %s) throws %s' % (
                visibility,
                return_type,
                route.java_method,
                method_arg_type,
                method_arg_name,
                throws,
            )
        else:
            method_arg_name = None
            deprecated = route.deprecated_by
            signature = 'public %s %s() throws %s' % (return_type, route.java_method, throws)

        out('')
        javadoc(route, returns=returns, deprecated=deprecated,
                params=((method_arg_name, arg_type),) if not route.arg.is_void else ())
        with self.g.block(signature.strip()):
            if route.request_style == 'rpc':
                self.generate_route_rpc_call(route, method_arg_name)
            elif route.request_style == 'upload':
                self.generate_route_upload_call(route, method_arg_name)
            elif route.request_style == 'download':
                self.generate_route_download_call(route, method_arg_name)
            else:
                assert False, "unrecognized route request style: %s" % route.request_style

    def generate_route(self, route, required_only=True):
        if not route.has_arg or route.arg.is_union:
            return

        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        arg_type = route.arg
        result_type = route.result
        return_type = route.java_return_type
        throws = ', '.join(map(str, route.java_throws))

        assert arg_type.is_struct, "Primitive arg types not supported: %s" % arg_type
        if not required_only:
            assert not route.supports_builder, "Route has builder, so unpacked method unnecessary."
            n_optional = len(arg_type.all_optional_fields)
            # we disable boxing for this method, which can be dangerous if we have more than one
            # optional argument. It will essentially prevent users from being able to use
            # default values for part of their request arguments. Consider updating code if
            # you want to support this.
            assert n_optional == 1, "More than one optional field should permit boxing!"


        if route.request_style == 'upload':
            returns="Uploader used to upload the request body and finish request."
        elif route.request_style == 'download':
            returns="Downloader used to download the response body and view the server response."
        elif route.has_result and (result_type.is_struct or result_type.is_union):
            returns=result_type
        else:
            returns=None

        if required_only:
            fields = arg_type.all_required_fields
        else:
            fields = arg_type.all_fields
        args = ', '.join(f.java_type_and_name() for f in fields)

        default_fields = tuple(f for f in arg_type.all_optional_fields if f.has_default)
        doc = route.babel_doc
        if required_only and default_fields:
            if route.supports_builder:
                doc += """

                The default values for the optional request parameters will be used. See {@link %s}
                for more details.""" % route.java_builder_class
            else:
                assert len(default_fields) == 1, default_fields
                default_field = default_fields[0]
                doc += """

                The {@code %s} request parameter will default to {@code %s} (see {@link #%s(%s)}).""" % (
                    default_field.java_name,
                    default_field.default_value,
                    route.java_method,
                    ','.join(str(f.data_type.java_type(boxed=False, generics=False)) for f in arg_type.all_fields),
                )

        out('')
        javadoc(doc, fields=fields, returns=returns, context=route, allow_defaults=False)
        with self.g.block('public %s %s(%s) throws %s' % (return_type, route.java_method, args, throws)):
            arg_class = arg_type.java_type()
            required_args = ', '.join(f.java_name for f in arg_type.all_required_fields)
            if required_only:
                out('%(cls)s arg = new %(cls)s(%(args)s);' % dict(cls=arg_class, args=required_args))
            else:
                optional_fields = arg_type.all_optional_fields
                for field in optional_fields:
                    # disable translation of nulls to default
                    self.generate_field_validation(field, allow_default=False)

                if arg_type.supports_builder:
                    # use builder to build with optional fields
                    out('%(cls)s arg = %(cls)s.newBuilder(%(args)s)' % dict(cls=arg_class, args=required_args))
                    with self.g.indent():
                        for field in optional_fields:
                            out('.%s(%s)' % (field.java_builder_setter, field.java_name))
                        out('.build();')
                else:
                    # use full constructor
                    all_args = ', '.join(f.java_name for f in arg_type.all_fields)
                    out('%(cls)s arg = new %(cls)s(%(args)s);' % dict(cls=arg_class, args=all_args))

            if route.has_result or route.request_style in ('upload', 'download'):
                out('return %s(arg);' % route.java_method)
            else:
                out('%s(arg);' % route.java_method)

    def generate_route_builder(self, route):
        if not route.supports_builder:
            return

        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        arg_type = route.arg
        result_type = route.result
        return_type = route.java_builder_return_type

        if route.request_style == 'upload':
            returns="Uploader builder for configuring request parameters and instantiating an uploader."
        elif route.request_style == 'download':
            returns="Downloader builder for configuring the request parameters and instantiating a downloader."
        else:
            returns="Request builder for configuring request parameters and completing the request."

        required_fields = arg_type.all_required_fields
        args = ', '.join(f.java_type_and_name() for f in required_fields)

        out('')
        javadoc(route, fields=required_fields, returns=returns)
        with self.g.block('public %s %s(%s)' % (return_type, route.java_builder_method, args)):
            builder_args = ', '.join(f.java_name for f in required_fields)
            out('%s argBuilder = %s.newBuilder(%s);' % (
                arg_type.java_builder_class,
                arg_type.java_class,
                builder_args,
            ))
            out('return new %s(this, argBuilder);' % return_type)

    def translate_error_wrapper(self, route, error_wrapper_var):
        if route.has_error:
            return 'new %(exc)s(%(ew)s.getRequestId(), %(ew)s.getUserMessage(), (%(err)s) %(ew)s.getErrorValue());' % dict(
                exc=route.java_exception_class,
                err=route.error.java_type(),
                ew=error_wrapper_var,
            )
        else:
            message = '"Unexpected error response for \\"%(route)s\\":" + %(ew)s.getErrorValue()' % dict(
                route=route.babel_name,
                ew=error_wrapper_var,
            )
            return 'new DbxApiException(%(ew)s.getRequestId(), %(ew)s.getUserMessage(), %(msg)s);' % dict(
                msg=message,
                ew=error_wrapper_var,
            )

    def generate_route_simple_call(self, route, arg_var, before):
        out = self.g.emit

        with self.g.block('try'):
            self.g.generate_multiline_list(
                (
                    'client.getHost().%s()' % camelcase('get_' + route.host),
                    '"%s"' % route.url_path,
                    arg_var if route.has_arg else 'null',
                    'true' if route.auth_style == 'noauth' else 'false',
                    route.arg.java_serializer,
                    route.result.java_serializer,
                    route.error.java_serializer,
                ),
                before=before,
                after=';',
            )
        with self.g.block('catch (DbxWrappedException ex)'):
            out('throw %s' % self.translate_error_wrapper(route, 'ex'))

    def generate_route_rpc_call(self, route, arg_var):
        self.generate_route_simple_call(
            route,
            arg_var,
            # return value is optional
            before=('return ' if route.has_result else '') + 'client.rpcStyle',
        )

    def generate_route_download_call(self, route, arg_var):
        self.generate_route_simple_call(
            route,
            arg_var,
            # always need to return a downloader
            before='return client.downloadStyle',
        )

    def generate_route_upload_call(self, route, arg_var):
        out = self.g.emit

        self.g.generate_multiline_list(
            (
                'client.getHost().%s()' % camelcase('get_' + route.host),
                '"%s"' % route.url_path,
                arg_var if route.has_arg else 'null',
                'true' if route.auth_style == 'noauth' else 'false',
                route.arg.java_serializer,
            ),
            before='HttpRequestor.Uploader uploader = client.uploadStyle',
            after=';',
        )
        out('return new %s(uploader);' % route.java_uploader_class)

    def generate_data_type(self, data_type):
        """Generate a class definition for a datatype (a struct or a union)."""
        out = self.g.emit

        with self.new_file(data_type):
            self.importer.add_imports_for_data_type(data_type)
            self.importer.generate_imports()

            if data_type.is_enum:
                self.generate_data_type_enum(data_type)
            elif data_type.is_union:
                self.generate_data_type_union(data_type)
            else:
                self.generate_data_type_struct(data_type)

    def generate_data_type_enum(self, data_type):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        out('')
        javadoc(data_type)
        with self.g.block('public enum %s' % data_type.java_class):
            out('// union %s' % data_type.babel_name)
            self.generate_enum_values(data_type)

            #
            # Serialization
            #
            self.generate_union_serializer(data_type)

    def generate_enum_values(self, data_type):
        """Generate enum values for simple unions or tags."""
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        all_fields = data_type.all_fields
        for i, field in enumerate(all_fields):
            javadoc(field)
            comment = ''
            if field.is_catch_all:
                assert field.data_type.is_void, field.data_type
                comment = ' // *catch_all'
            elif not field.data_type.is_void:
                comment += ' // %s' % field.data_type.java_type()

            sep = ',' if i < (len(all_fields) - 1) else ';'
            out(field.java_enum + sep + comment)

    def generate_data_type_union(self, data_type):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        class_doc = """%s

            This class is %s union.  Tagged unions instances are always associated to a
            specific tag.  This means only one of the {@code isAbc()} methods will return {@code
            true}. You can use {@link #tag()} to determine the tag associated with this instance.
            """ % (data_type.babel_doc, 'an open tagged' if data_type.catch_all_field else 'a tagged')
        if data_type.catch_all_field:
                class_doc += """

                Open unions may be extended in the future with additional tags. If a new tag is
                introduced that this SDK does not recognized, the {@link #%s} value will be used.
                """ % data_type.catch_all_field.java_singleton


        out('')
        javadoc(class_doc, context=data_type)
        with self.g.block('public final class %s' % data_type.java_class):
            out('// union %s' % data_type.java_class)

            #
            # Tag
            #
            out('')
            javadoc('Discriminating tag type for {@link %s}.' % data_type.java_class)
            with self.g.block('public enum Tag'):
                self.generate_enum_values(data_type)

            #
            # Simple field singletons
            #
            nulls = tuple("null" for f in data_type.all_fields if f.has_value)
            if any(not f.has_value for f in data_type.all_fields):
                out('')
            for field in data_type.all_fields:
                if not field.has_value:
                    singleton_args = ', '.join(chain(("Tag.%s" % field.tag_name,), nulls))
                    javadoc(field)
                    out('public static final %s %s = new %s(%s);' % (
                        data_type.java_class,
                        field.java_singleton, data_type.java_class,
                        singleton_args,
                    ))

            #
            # Instance fields
            #
            out('')
            out('private final Tag tag;')
            for field in data_type.all_fields:
                if field.has_value:
                    out('private final %s %s;' % (field.data_type.java_type(boxed=True), field.java_name))

            #
            # Constructor
            #
            args = ', '.join(chain(
                (('Tag tag'),),
                ('%s %s' % (field.data_type.java_type(boxed=True), field.java_name)
                 for field in data_type.all_fields if field.has_value),
            ))
            out('')
            javadoc(data_type,
                    fields=(f for f in data_type.all_fields if f.has_value),
                    params=OrderedDict(tag="Discriminating tag for this instance."))
            with self.g.block('private %s(%s)' % (data_type.java_class, args)):
                out('this.tag = tag;')
                for field in data_type.all_fields:
                    if field.has_value:
                        # don't perform validation in the private constructor
                        out('this.%s = %s;' % (field.java_name, field.java_name))


            #
            # Field getters/constructors
            #
            out('')
            if data_type.catch_all_field:
                catch_all_doc = "If a tag returned by the server is unrecognized by this SDK, the {@link Tag#%s} value will be used." % (
                    data_type.catch_all_field.tag_name)
            else:
                catch_all_doc = ""
            javadoc(
                """
                Returns the tag for this instance.

                This class is a tagged union.  Tagged unions instances are always associated to a
                specific tag.  This means only one of the {@code isXyz()} methods will return {@code
                true}. Callers are recommended to use the tag value in a {@code switch} statement to
                properly handle the different values for this {@code %s}.

                %s""" % (data_type.java_class, catch_all_doc),
                context=data_type,
                returns="the tag for this instance."
            )
            with self.g.block('public Tag tag()'):
                out('return tag;')
            self.generate_data_type_union_field_methods(data_type)

            #
            # Helper methods
            #
            self.generate_hash_code(data_type)
            self.generate_equals(data_type)
            self.generate_to_string(data_type)

            #
            # Serialization
            #
            self.generate_union_serializer(data_type)

    def generate_data_type_union_field_methods(self, data_type):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        for field in data_type.all_fields:
            #
            # isFieldName()
            #
            out('')
            javadoc(
                """
                Returns {@code true} if this instance has the tag {@link Tag#%s}, {@code false}
                otherwise.
                """ % field.tag_name,
                returns=(
                    """
                    {@code true} if this instance is tagged as {@link Tag#%s},
                    {@code false} otherwise.
                    """
                ) % field.tag_name
            )
            with self.g.block('public boolean %s()' % field.java_is_union_type_method):
                out('return this.tag == Tag.%s;' % field.tag_name)

            if field.has_value:
                #
                # Union fieldName() [factory method]
                #
                out('')
                doc = (
                    """
                    Returns an instance of {@code %s} that has its tag set to {@link Tag#%s}.

                    %s
                    """ % (data_type.java_class, field.tag_name, field.babel_doc)
                )
                returns = "Instance of {@code %s} with its tag set to {@link Tag#%s}." % (data_type.java_class, field.tag_name)
                javadoc(
                    doc,
                    context=field,
                    params=OrderedDict(value="value to assign to this instance.") if field.has_value else (),
                    returns=returns,
                    throws=self.doc.javadoc_throws(field, "value"),
                )
                if field.has_value:
                    with self.g.block('public static %s %s(%s value)' % (
                            data_type.java_class,
                            field.java_factory_method,
                            field.java_type(),
                    )):
                        self.generate_field_validation(field, value_name="value", omit_arg_name=True, allow_default=False)
                        args = ", ".join(
                            "value" if f.as_babel is field.as_babel else "null"
                            for f in data_type.all_fields if f.has_value
                        )
                        out('return new %s(Tag.%s, %s);' % (data_type.java_class, field.tag_name, args))

                    if field.data_type.is_nullable:
                        out('')
                        javadoc(doc, context=field, returns=returns)
                        with self.g.block('public static %s %s()' % (data_type.java_class, field.java_factory_method)):
                            out('return %s(null);' % field.java_factory_method)

                #
                # getFieldNameValue()
                #
                out('')
                javadoc(
                    """
                    %s

                    This instance must be tagged as {@link Tag#%s}.
                    """ % (field.babel_doc, field.tag_name),
                    context=field,
                    returns="""
                    The %s value associated with this instance if {@link #%s} is
                    {@code true}.
                    """ % (self.doc.javadoc_ref(field), field.java_is_union_type_method),
                    throws=OrderedDict(
                        IllegalStateException="If {@link #%s} is {@code false}." % field.java_is_union_type_method,
                    )
                )
                with self.g.block('public %s %s()' % (field.java_type(), field.java_getter)):
                    with self.g.block('if (this.tag != Tag.%s)' % field.tag_name):
                        out('throw new IllegalStateException("Invalid tag: required Tag.%s, but was Tag." + tag.name());' % field.tag_name)
                    out('return %s;' % field.java_name)


    def generate_data_type_struct(self, data_type):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        # we want to hide classes that aren't usable by developers. This include helper classes we
        # use internally for building the request. If a struct is only ever used as the argument to
        # a route request, then developers will never have to create an instance themselves. Mark
        # the class as package-private.
        #
        # The exception to this rule are struct classes located in namespaces outside the route
        # namespace. To be able to import these classes, they will have to remain public.
        if is_data_type_required_outside_package(data_type):
            visibility = 'public'
        else:
            # package private since this struct only gets used privately as a route arg.
            visibility = ''

        out('')
        javadoc(data_type)
        with self.g.block(('%s class %s' % (visibility, data_type.java_class_with_inheritance)).strip()):
            out('// struct %s' % data_type.babel_name)

            #
            # instance fields
            #
            out('')
            for field in data_type.fields:
                # fields marked as protected since structs allow inheritance
                out('protected final %s;' % field.java_type_and_name())

            #
            # constructor.
            #

            # use builder or required-only constructor for default values
            args = ', '.join(
                field.java_type_and_name() for field in data_type.all_fields
            )
            doc = data_type.babel_doc
            if data_type.supports_builder:
                doc += """

                Use {@link newBuilder} to create instances of this class without specifying values for all optional fields.
                """
            out('')
            javadoc(doc, context=data_type, fields=data_type.all_fields, allow_defaults=False)
            with self.g.block('public %s(%s)' % (data_type.java_class, args)):
                parent_fields = data_type.parent.all_fields if data_type.parent else ()

                if parent_fields:
                    parent_args = ', '.join(f.java_name for f in parent_fields)
                    out('super(%s);' % parent_args)

                for field in data_type.fields:
                    self.generate_field_validation(field, allow_default=False)
                    self.generate_field_assignment(field, allow_default=False)

            # required-only constructor
            if data_type.has_optional_fields:
                # create a constructor with just required fields (for convenience)
                required_fields = data_type.all_required_fields
                required_args = ', '.join(
                    field.java_type_and_name()
                    for field in required_fields
                )
                out('')
                javadoc(
                    """
                    %s

                    The default values for unset fields will be used.
                    """ % data_type.babel_doc,
                    context=data_type,
                    fields=required_fields
                )
                with self.g.block('public %s(%s)' % (data_type.java_class, required_args)):
                    this_args = []
                    for field in data_type.all_fields:
                        if field.data_type.is_nullable:
                            this_args.append('null')
                        elif field.has_default:
                            this_args.append(field.default_value)
                        else:
                            this_args.append(field.java_name)
                    out('this(%s);' % ', '.join(this_args))

            #
            # getter methods
            #
            for field in data_type.fields:
                out('')
                if field.is_optional:
                    returns = 'value for this field, or {@code null} if not present.'
                elif not field.data_type.is_primitive:
                    returns = 'value for this field, never {@code null}.'
                else:
                    returns = 'value for this field.'

                if field.has_default:
                    returns += ' Defaults to %s.' % field.default_value

                javadoc(field, returns=returns)
                with self.g.block('public %s %s()' % (field.java_type(), field.java_getter)):
                    out('return %s;' % field.java_name)


            #
            # builder
            #
            if data_type.supports_builder:
                self.generate_struct_builder(data_type)

            #
            # Helper methods
            #
            self.generate_hash_code(data_type)
            self.generate_equals(data_type)
            self.generate_to_string(data_type)

            #
            # Serialization
            #
            self.generate_struct_serializer(data_type)

    def generate_struct_builder(self, data_type):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        assert data_type.supports_builder, "Data type does not support builder: %r" % data_type

        parent_supports_builder = data_type.parent and data_type.parent.supports_builder
        all_required_fields = data_type.all_required_fields
        fields = data_type.fields if parent_supports_builder else data_type.all_fields
        required_fields = tuple(f for f in fields if f.is_required)
        optional_fields = tuple(f for f in fields if f.is_optional)
        ancestors = get_ancestors(data_type.as_babel)

        all_required_args = ', '.join(f.java_type_and_name() for f in all_required_fields)
        required_args = ', '.join(f.java_type_and_name() for f in required_fields)

        out('')
        javadoc(
            'Returns a new builder for creating an instance of this class.',
            context=data_type,
            fields=all_required_fields,
            returns='builder for this class.',
        )
        with self.g.block('public static %s newBuilder(%s)' % (data_type.java_builder_class, all_required_args)):
            builder_args = ', '.join(f.java_name for f in all_required_fields)
            out('return new %s(%s);' % (data_type.java_builder_class, builder_args))

        out('')
        javadoc('Builder for %s.' % self.doc.javadoc_ref(data_type))
        with self.g.block('public static class %s' % data_type.java_builder_class_with_inheritance):
            #
            # Instance fields
            #

            for field in required_fields:
                out('protected final %s;' % field.java_type_and_name())

            if optional_fields:
                out('')
            for field in optional_fields:
                out('protected %s;' % field.java_type_and_name())

            #
            # Constructor
            #
            out('')
            with self.g.block('protected %s(%s)' % (data_type.java_builder_class, all_required_args)):
                if parent_supports_builder:
                    parent_required_fields = tuple(f for f in data_type.all_parent_fields if f.is_required)
                    if parent_required_fields:
                        parent_args = ', '.join(f.java_name for f in parent_required_fields)
                        out('super(%s);' % parent_args)

                for field in required_fields:
                    self.generate_field_validation(field)
                    self.generate_field_assignment(field)

                for field in optional_fields:
                    if field.data_type.is_nullable:
                        out('this.%s = null;' % field.java_name)
                    else:
                        assert field.has_default, repr(field)
                        out('this.%s = %s;' % (field.java_name, field.default_value))

            #
            # Setter/Adder methods
            #
            self.generate_builder_methods(data_type.java_builder_class, fields)

            #
            # Build method
            #
            out('')
            javadoc(
                "Builds an instance of %s configured with this builder's values" % self.doc.javadoc_ref(data_type),
                returns='new instance of %s' % self.doc.javadoc_ref(data_type)
            )
            with self.g.block('public %s build()' % data_type.java_class):
                build_args = ', '.join(f.java_name for f in data_type.all_fields)
                out('return new %s(%s);' % (data_type.java_class, build_args))

    def generate_builder_methods(self, builder_class, fields, wrapped_builder_name=None):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        for field in fields:
            if not field.is_optional:
                continue

            doc = 'Set value for optional field.'
            if field.has_default:
                doc += """

                If left unset or set to {@code null}, defaults to {@code %s}.
                """ % field.default_value


            #
            # withFieldName(FieldType fieldValue);
            #
            out('')
            javadoc(doc, context=field, fields=(field,), returns='this builder')
            with self.g.block('public %s %s(%s %s)' % (
                    builder_class,
                    field.java_builder_setter,
                    field.data_type.java_type(boxed=True), # null treated as default
                    field.java_name,
            )):
                if wrapped_builder_name:
                    out('this.%s.%s(%s);' % (wrapped_builder_name, field.java_builder_setter, field.java_name))
                else:
                    self.generate_field_validation(field)
                    self.generate_field_assignment(field)
                out('return this;')

    def generate_exception_type(self, route):
        if not route.has_error:
            return

        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        data_type = route.error
        class_name = data_type.java_exception_class
        error_type = data_type.java_type()

        with self.new_file(data_type, class_name):
            self.importer.add_imports_for_exception_type(data_type)
            self.importer.generate_imports()

            out('')
            javadoc('Exception thrown when the server responds with a %s error.' % self.doc.javadoc_ref(data_type))
            with self.g.block('public class %s extends DbxApiException' % class_name):
                out('private static final long serialVersionUID = 0L;')
                out('')
                javadoc('The error reported by %s.' % self.doc.javadoc_ref(route))
                out('public final %s errorValue;' % error_type)

                out('')
                with self.g.block('public %s(String requestId, LocalizedText userMessage, %s errorValue)' % (class_name, error_type)):
                    out('super(requestId, userMessage, buildMessage("%s", userMessage, errorValue));' % route.babel_name)
                    with self.g.block('if (errorValue == null)'):
                        out('throw new NullPointerException("errorValue");')
                    out('this.errorValue = errorValue;')

    def generate_uploader_type(self, route):
        if route.request_style != 'upload':
            return

        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        class_name = route.java_uploader_class.name
        with self.new_file(route, class_name):
            self.importer.add_imports_for_route_uploader(route)
            self.importer.generate_imports()

            result_type = route.result.java_type()
            error_type = route.error.java_type()
            if route.has_error:
                exception_type = route.java_exception_class
            else:
                exception_type = 'DbxApiException'

            out('')
            javadoc(
                """
                The {@link DbxUploader} returned by %s.

                Use this class to upload data to the server and complete the request.

                This class should be properly closed after use to prevent resource leaks and allow
                network connection reuse. Always call {@link #close} when complete (see {@link
                DbxUploader} for examples).
                """ % self.doc.javadoc_ref(route)
            )
            with self.g.block('public class %s extends DbxUploader<%s, %s, %s>' % (class_name, result_type, error_type, exception_type)):
                out('')
                javadoc(
                    'Creates a new instance of this uploader.',
                    params=(('httpUploader', 'Initiated HTTP upload request'),),
                    throws=(('NullPointerException', 'if {@code httpUploader} is {@code null}'),)
                )
                with self.g.block('public %s(HttpRequestor.Uploader httpUploader)' % class_name):
                    out('super(httpUploader, %s, %s);' % (route.result.java_serializer, route.error.java_serializer))

                out('')
                with self.g.block('protected %s newException(DbxWrappedException error)' % exception_type):
                    out('return %s' % self.translate_error_wrapper(route, 'error'))

    def generate_builder_type(self, route):
        if not route.supports_builder:
            return

        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        assert route.arg.is_struct, "Can only create builders for struct arg types."

        class_name = route.java_builder_class.name
        with self.new_file(route, class_name):
            self.importer.add_imports_for_route_builder(route)
            self.importer.generate_imports()

            arg_type = route.arg
            if route.has_error:
                exception_class = route.java_exception_class
            else:
                exception_class = 'DbxApiException'
            builder_arg_class = arg_type.java_builder_class
            builder_arg_name = arg_type.java_builder_field
            client_name = route.namespace.java_field
            route_auth = route.auth_style if route.auth_style != 'noauth' else 'user'

            out('')
            javadoc(
                """
                The request builder returned by %s.

                Use this class to set optional request parameters and complete the request.
                """ % self.doc.javadoc_ref(route, builder=True)
            )
            with self.g.block('public class %s' % route.java_builder_class_with_inheritance):
                out('private final %s %s;' % (route.namespace.java_class(route_auth), client_name))
                out('private final %s %s;' % (builder_arg_class, builder_arg_name))

                #
                # CONSTRUCTOR
                #

                args = ', '.join('%s %s' % pair for pair in (
                    (route.namespace.java_class(route_auth), client_name),
                    (builder_arg_class, builder_arg_name),
                ))


                out('')
                javadoc(
                    'Creates a new instance of this builder.',
                    params=[
                        (client_name, 'Dropbox namespace-specific client used to issue %s requests.' % route.namespace.babel_name),
                        (builder_arg_name, 'Request argument builder.'),
                    ],
                    returns='instsance of this builder',
                )
                # package private
                with self.g.block('%s(%s)' % (class_name, args)):
                    with self.g.block('if (%s == null)' % client_name):
                        out('throw new NullPointerException("%s");' % client_name)
                    with self.g.block('if (%s == null)' % builder_arg_name):
                        out('throw new NullPointerException("%s");' % builder_arg_name)
                    out('this.%(nf)s = %(nf)s;' % dict(nf=client_name));
                    out('this.%(nf)s = %(nf)s;' % dict(nf=builder_arg_name));

                #
                # SETTERS/ADDERs for optional/list fields
                #

                self.generate_builder_methods(class_name, arg_type.all_fields, wrapped_builder_name=builder_arg_name)

                #
                # BUILD method to start request
                #

                out('')
                if route.request_style in ('upload', 'download'):
                    out('@Override')
                    # inehrit doc from parent
                else:
                    javadoc('Issues the request.')
                if route.is_deprecated:
                    out('@SuppressWarnings("deprecation")')
                with self.g.block('public %s start() throws %s, DbxException' % (route.java_return_type, exception_class)):
                    out('%s arg = this.%s.build();' % (arg_type.java_type(), builder_arg_name))
                    if route.has_result:
                        out('return %s.%s(arg);' % (client_name, route.java_method))
                    else:
                        out('%s.%s(arg);' % (client_name, route.java_method))

    def generate_field_assignment(self, field, lhs=None, rhs=None, allow_default=True):
        out = self.g.emit

        lhs = lhs or ('this.%s' % field.java_name)
        rhs = rhs or field.java_name

        underlying_data_type = field.data_type
        if underlying_data_type.is_nullable:
            underlying_data_type = underlying_data_type.nullable_data_type
        if underlying_data_type.is_list:
            underlying_data_type = underlying_data_type.list_data_type

        # our timestamp format only allows for second-level granularity (no millis).
        # enforce this.
        #
        # TODO: gotta be a better way than this...
        if is_timestamp_type(underlying_data_type.as_babel) and rhs != 'null':
            rhs = 'com.dropbox.core.util.LangUtil.truncateMillis(%s)' % rhs

        if allow_default and field.has_default:
            if rhs == 'null':
                out('%s = %s;' % (lhs, field.default_value))
            else:
                with self.g.block('if (%s != null)' % rhs):
                    out('%s = %s;' % (lhs, rhs))
                with self.g.block('else'):
                    # set default
                    out('%s = %s;' % (lhs, field.default_value))
        else:
            out('%s = %s;' % (lhs, rhs))

    def generate_field_validation(self, field, value_name=None, omit_arg_name=False, allow_default=True):
        """Generate validation code for one field.
        """
        out = self.g.emit
        data_type = field.data_type
        value_name = value_name or field.java_name

        if data_type.is_nullable:
            data_type =  data_type.nullable_data_type
            if data_type.requires_validation:
                with self.g.block('if (%s != null)' % field.java_name):
                    self.generate_data_type_validation(data_type, value_name, omit_arg_name=omit_arg_name)
        else:
            # Don't need to check primitive/default types for null.
            if not (data_type.is_primitive or (allow_default and field.has_default)):
                with self.g.block('if (%s == null)' % value_name):
                    if omit_arg_name:
                        out('throw new IllegalArgumentException("Value is null");')
                    else:
                        out('throw new IllegalArgumentException("Required value for \'%s\' is null");' % value_name)
            self.generate_data_type_validation(data_type, value_name, omit_arg_name=omit_arg_name)

    def generate_namespace_serializers(self, namespace):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        serializers_class = namespace.java_serializers_class
        package_relpath = self.create_package_path(serializers_class.package)
        file_name = os.path.join(package_relpath, serializers_class.name + '.java')

        # resolve all required data types
        required_data_types = get_all_required_data_types_for_namespace(namespace)

        with self.g.output_to_relative_path(file_name), self.ctx.scoped(serializers_class.fq):
            self.generate_file_header()
            out('package %s;' % serializers_class.package)

            if any(dt.is_struct for dt in namespace.data_types):
                self.ctx.add_imports('com.dropbox.core.babel.StructSerializer')
            if any(dt.is_union for dt in namespace.data_types):
                self.ctx.add_imports('com.dropbox.core.babel.UnionSerializer')

            # import every data type...
            self.ctx.add_imports(*(data_type.java_class for data_type in required_data_types))
            self.importer.generate_imports()

            out('')
            javadoc(
                """
                Internal class used for Babel serialization. This class is subject to change at any
                time. No fields within this class should be accessed outside of this library.
                """
            )
            with self.g.block('public final class %s' % serializers_class.name):
                for data_type in namespace.data_types:
                    serializer_type = 'Struct' if data_type.is_struct else 'Union'
                    javadoc("For internal use only.")
                    out('public static final %s.Serializer %s = new %s.Serializer();' % (
                        data_type.java_class,
                        data_type.java_serializer_singleton,
                        data_type.java_class,
                    ))

    # T95586: Because Android has a bug that forces all classes with RUNTIME annotations into the
    # primary dex, we cannot use annotation-based serialization. If we do, then every POJO will be
    # added to a multidex app's primary dex, potentially exceeding the method count limit.
    #
    # The solution is to generate the serialization code for every POJO. Note that from a
    # performance and maintenance standpoint, this is not ideal.
    #
    # The dalvik bug is tracked here: https://code.google.com/p/android/issues/detail?id=78144
    def generate_struct_serializer(self, data_type):
        assert isinstance(data_type, DataTypeWrapper), repr(data_type)
        assert data_type.is_struct, repr(data_type)

        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        # attempt to limit scope to avoid polluting the Javadoc
        if is_data_type_serializer_required_outside_package(data_type):
            scope = 'public '
        else:
            scope = ''

        out('')
        javadoc("For internal use only.")
        with self.g.block('%sstatic final class Serializer extends StructSerializer<%s>' % (scope, data_type.java_class)):
            out('public static final Serializer INSTANCE = new Serializer();')
            self.generate_struct_serialize(data_type)
            self.generate_struct_deserialize(data_type)

    def generate_union_serializer(self, data_type):
        assert isinstance(data_type, DataTypeWrapper), repr(data_type)
        assert data_type.is_union, repr(data_type)

        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        # attempt to limit the scope to avoid polluting the Javadoc
        if is_data_type_serializer_required_outside_package(data_type):
            scope = 'public '
        else:
            scope = ''

        out('')
        javadoc("For internal use only.")
        with self.g.block('%sstatic final class Serializer extends UnionSerializer<%s>' % (scope, data_type.java_class)):
            out('public static final Serializer INSTANCE = new Serializer();')
            self.generate_union_serialize(data_type)
            self.generate_union_deserialize(data_type)

    def generate_struct_serialize(self, data_type):
        assert data_type.is_struct, repr(data_type)

        out = self.g.emit

        out('')
        out('@Override')
        with self.g.block('public void serialize(%s value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException' % data_type.java_type()):

            if data_type.has_enumerated_subtypes:
                for subtype in data_type.enumerated_subtypes:
                    subtype_class = subtype.data_type.java_class
                    serializer = subtype.data_type.java_serializer
                    with self.g.block('if (value instanceof %s)' % subtype_class):
                        out('%s.serialize((%s) value, g, collapse);' % (serializer, subtype_class))
                        out('return;')

            with self.g.block('if (!collapse)'):
                out('g.writeStartObject();')

            ancestors = get_ancestors(data_type.as_babel)
            tag = '.'.join(name for name, _ in ancestors[1:] if name)
            if tag:
                out('writeTag("%s", g);' % tag)

            for field in data_type.all_fields:
                field_dt = field.data_type
                field_value = 'value.%s' % field.java_name
                with self.conditional_block('if (%s != null)' % field_value, field_dt.is_nullable):
                    out('g.writeFieldName("%s");' % field.babel_name)
                    out('%s.serialize(%s, g);' % (field_dt.java_serializer, field_value))

            with self.g.block('if (!collapse)'):
                out('g.writeEndObject();')

    def generate_struct_deserialize(self, data_type):
        assert data_type.is_struct, repr(data_type)

        out = self.g.emit

        out('')
        out('@Override')
        with self.g.block('public %s deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException' % data_type.java_type()):
            out('%s value;' % data_type.java_type())
            out('String tag = null;')

            with self.g.block('if (!collapsed)'):
                out('expectStartObject(p);')
                out('tag = readTag(p);')
                if data_type.is_enumerated_subtype:
                    ancestors = get_ancestors(data_type.as_babel)
                    expected_tag = '.'.join(name for name, _ in ancestors if name)
                    with self.g.block('if ("%s".equals(tag))' % expected_tag):
                        out('tag = null;')

            with self.g.block('if (tag == null)'):
                for field in data_type.all_fields:
                    default_value = field.default_value if field.has_default else 'null'
                    out('%s f_%s = %s;' % (
                        field.data_type.java_type(boxed=True), field.java_name, default_value
                    ))
                with self.g.block('while (p.getCurrentToken() == JsonToken.FIELD_NAME)'):
                    out('String field = p.getCurrentName();')
                    out('p.nextToken();')

                    for i, field in enumerate(data_type.all_fields):
                        conditional = 'if' if i == 0 else 'else if'
                        serializer = field.data_type.java_serializer
                        with self.g.block('%s ("%s".equals(field))' % (conditional, field.babel_name)):
                            out('f_%s = %s.deserialize(p);' % (field.java_name, serializer))
                    with self.g.block('else'):
                        out('skipValue(p);')

                for field in data_type.all_fields:
                    if not field.is_optional:
                        with self.g.block('if (f_%s == null)' % field.java_name):
                            out('throw new JsonParseException(p, "Required field \\"%s\\" missing.");' % field.babel_name)
                args = ['f_%s' % f.java_name for f in data_type.all_fields]
                out('value = new %s(%s);' % (data_type.java_class, ', '.join(args)))

            for tag, subtype_dt in get_enumerated_subtypes_recursively(data_type):
                with self.g.block('else if ("%s".equals(tag))' % tag):
                    out('value = %s.deserialize(p, true);' % subtype_dt.java_serializer)

            with self.g.block('else'):
                out('throw new JsonParseException(p, "No subtype found that matches tag: \\"" + tag + "\\"");')

            with self.g.block('if (!collapsed)'):
                out('expectEndObject(p);')

            out('return value;')

    def generate_union_serialize(self, data_type):
        assert data_type.is_union, repr(data_type)

        out = self.g.emit

        out('')
        out('@Override')
        with self.g.block('public void serialize(%s value, JsonGenerator g) throws IOException, JsonGenerationException' % data_type.java_type()):
            tag = 'value' if data_type.is_enum else 'value.tag()'
            with self.g.block('switch (%s)' % tag):
                for field in data_type.all_fields:
                    if field.is_catch_all:
                        continue
                    with self.g.block('case %s:' % field.tag_name):
                        if field.data_type.is_void:
                            out('g.writeString("%s");' % field.babel_name)
                        else:
                            out('g.writeStartObject();')
                            out('writeTag("%s", g);' % field.babel_name)
                            serializer = field.data_type.java_serializer
                            value = 'value.%s' % field.java_name
                            if field.data_type.is_struct and field.data_type.is_collapsible:
                                out('%s.serialize(%s, g, true);' % (serializer, value))
                            else:
                                out('g.writeFieldName("%s");' % field.babel_name)
                                out('%s.serialize(%s, g);' % (serializer, value))
                            out('g.writeEndObject();')
                        out('break;')

                with self.g.block('default:'):
                    if data_type.catch_all_field:
                        out('g.writeString("%s");' % data_type.catch_all_field.babel_name)
                    else:
                        out('throw new IllegalArgumentException("Unrecognized tag: " + %s);' % tag)

    def generate_union_deserialize(self, data_type):
        assert data_type.is_union, repr(data_type)

        out = self.g.emit

        out('')
        out('@Override')
        with self.g.block('public %s deserialize(JsonParser p) throws IOException, JsonParseException' % data_type.java_type()):
            out('%s value;' % data_type.java_type())
            out('boolean collapsed;')
            out('String tag;')

            with self.g.block('if (p.getCurrentToken() == JsonToken.VALUE_STRING)'):
                out('collapsed = true;')
                out('tag = getStringValue(p);')
                out('p.nextToken();')
            with self.g.block('else'):
                out('collapsed = false;')
                out('expectStartObject(p);')
                out('tag = readTag(p);')

            with self.g.block('if (tag == null)'):
                out('throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);')

            for field in data_type.all_fields:
                if field.is_catch_all:
                    continue

                field_dt = field.data_type
                with self.g.block('else if ("%s".equals(tag))' % field.babel_name):
                    if not field.has_value:
                        out('value = %s.%s;' % (data_type.java_class, field.java_singleton))
                    else:
                        out('%s fieldValue = null;' % field_dt.java_type())
                        with self.conditional_block('if (p.getCurrentToken() != JsonToken.END_OBJECT)', field_dt.is_nullable):
                            if field_dt.is_struct and field_dt.is_collapsible:
                                out('fieldValue = %s.deserialize(p, true);' % field_dt.java_serializer)
                            else:
                                out('expectField("%s", p);' % field.babel_name)
                                out('fieldValue = %s.deserialize(p);' % field_dt.java_serializer)

                        if field_dt.is_nullable:
                            with self.g.block('if (fieldValue == null)'):
                                out('value = %s.%s();' % (data_type.java_class, field.java_factory_method))
                            with self.g.block('else'):
                                out('value = %s.%s(fieldValue);' % (data_type.java_class, field.java_factory_method))
                        else:
                            out('value = %s.%s(fieldValue);' % (data_type.java_class, field.java_factory_method))
            with self.g.block('else'):
                if data_type.catch_all_field:
                    out('value = %s.%s;' % (data_type.java_class, data_type.catch_all_field.java_singleton))
                    out('skipFields(p);')
                else:
                    out('throw new JsonParseException(p, "Unknown tag: " + tag);')

            with self.g.block('if (!collapsed)'):
                out('expectEndObject(p);')

            out('return value;')

    def generate_data_type_validation(self, data_type, value_name, description=None, omit_arg_name=False, level=0):
        out = self.g.emit

        if omit_arg_name:
            description = ""
        else:
            description = description or (" '%s'" % value_name)

        babel_dt = data_type.as_babel

        if is_list_type(babel_dt):
            if babel_dt.min_items is not None:
                with self.g.block('if (%s.size() < %s)' % (value_name, data_type.java_value(babel_dt.min_items))):
                    out('throw new IllegalArgumentException("List%s has fewer than %s items");' % (
                        description, data_type.java_value(babel_dt.min_items)))
            if babel_dt.max_items is not None:
                with self.g.block('if (%s.size() > %s)' % (value_name, data_type.java_value(babel_dt.max_items))):
                    out('throw new IllegalArgumentException("List%s has more than %s items");' %
                        (description, data_type.java_value(babel_dt.max_items)))
            xn = 'x' if level == 0 else 'x%d' % level
            with self.g.block('for (%s %s : %s)' % (data_type.list_data_type.java_type(), xn, value_name)):
                with self.g.block('if (%s == null)' % xn):
                    out('throw new IllegalArgumentException("An item in list%s is null");' % description)
                self.generate_data_type_validation(data_type.list_data_type, xn, 'an item in list%s' % description, level=level+1)

        elif is_numeric_type(data_type.as_babel):
            if babel_dt.min_value is not None:
                with self.g.block('if (%s < %s)' % (value_name, data_type.java_value(babel_dt.min_value))):
                    out('throw new IllegalArgumentException("Number%s is smaller than %s");' %
                        (description, data_type.java_value(babel_dt.min_value)))
            if babel_dt.max_value is not None:
                with self.g.block('if (%s > %s)' % (value_name, data_type.java_value(babel_dt.max_value))):
                    out('throw new IllegalArgumentException("Number%s is larger than %s");' %
                        (description, data_type.java_value(babel_dt.max_value)))

        elif is_string_type(babel_dt):
            if babel_dt.min_length is not None:
                with self.g.block('if (%s.length() < %d)' % (value_name, babel_dt.min_length)):
                    out('throw new IllegalArgumentException("String%s is shorter than %s");' %
                        (description, data_type.java_value(babel_dt.min_length)))
            if babel_dt.max_length is not None:
                with self.g.block('if (%s.length() > %d)' % (value_name, babel_dt.max_length)):
                    out('throw new IllegalArgumentException("String%s is longer than %s");' %
                        (description, data_type.java_value(babel_dt.max_length)))
            if babel_dt.pattern is not None:
                # TODO: Save the pattern as a static variable.
                # NOTE: pattern should match against entire input sequence
                with self.g.block('if (!java.util.regex.Pattern.matches("%s", %s))' % (
                        sanitize_pattern(babel_dt.pattern), value_name)):
                    out('throw new IllegalArgumentException("String%s does not match pattern");' % description)

        elif any((
                is_composite_type(babel_dt),
                is_boolean_type(babel_dt),
                is_timestamp_type(babel_dt),
                is_bytes_type(babel_dt),
        )):
            pass  # Nothing to do for these

        else:
            out('throw new RuntimeException("XXX Don\'t know how to validate %s: type %s");' %
                (description, data_type.babel_name))

    def generate_list_builder_ensure_mutable(self, field):
        assert field.data_type.is_list, "field must be a list type: %r" % field.data_type

        out = self.g.emit

        value_name = field.java_name
        data_type = field.data_type.list_data_type
        # We use a variable, valueName_isMutable, to keep track of our
        # internal list mutability. This allows us to repeatedly call
        # build() with different list values:
        #
        # builder = Foo.newBuilder()
        #     .addBars(new Bar(1),
        #              new Bar(2));
        #
        # Foo foo1 = builder.build();
        # Foo foo2 = builder.addBars(new Bar(3)).build();
        #
        # foo1.equals(foo2) == false;
        #
        if field.is_optional:
            with self.g.block('if (this.%s == null)' % value_name):
                out('this.%s = new java.util.ArrayList<%s>();' % (value_name, data_type.java_type()))

        with self.g.block('if (!this.%s_isMutable)' % value_name):
            out('this.%s = new java.util.ArrayList<%s>(this.%s);' % (value_name, data_type.java_type(), value_name))
            out('this.%s_isMutable = true;' % value_name)

    def generate_list_builder_validation_and_assignment(self, field, boxed=False):
        assert field.data_type.is_list, "field must be a list type: %r" % field.data_type

        out = self.g.emit

        value_name = field.java_name
        description = "'%s'" % value_name
        data_type = field.data_type.list_data_type

        with self.g.block('if (%s == null)' % value_name):
            out('throw new IllegalArgumentException("%s must not be null");' % description)

        with self.g.block('for (%s x_ : %s)' % (data_type.java_type(boxed=boxed), value_name)):
            with self.g.block('if (x_ == null)'):
                out('throw new IllegalArgumentException("An item in %s is null");' % description)

            self.generate_data_type_validation(data_type, 'x_', 'an item in %s' % description)

            max_items = field.data_type.as_babel.max_items
            if max_items is not None:
                with self.g.block('if (this.%s.size() >= %s)' % (value_name, max_items)):
                    out('throw new IllegalArgumentException("List at capacity with %s item");' % max_items)

            out('this.%s.add(x_);' % value_name)

    def generate_to_string(self, data_type):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        out('')
        out('@Override')
        with self.g.block('public String toString()'):
            out('return Serializer.INSTANCE.serialize(this, false);')

        out('')
        javadoc(
            """
            Returns a String representation of this object formatted for easier readability.

            The returned String may contain newlines.
            """,
            returns="Formatted, multiline String representation of this object"
        )
        with self.g.block('public String toStringMultiline()'):
            out('return Serializer.INSTANCE.serialize(this, true);')

    def generate_hash_code(self, data_type):
        out = self.g.emit
        javadoc = self.doc.generate_javadoc

        assert isinstance(data_type, DataTypeWrapper), repr(data_type)
        assert data_type.is_struct or data_type.is_union, repr(data_type)
        assert not data_type.is_enum, "enum types don't require equals() methods"

        if data_type.is_struct:
            fields = [f.java_name for f in data_type.fields]
        else:
            fields = ['tag'] + [f.java_name for f in data_type.all_fields if f.has_value]

        out('')
        out('@Override')
        with self.g.block('public int hashCode()'):
            if not fields:
                out('// attempt to deal with inheritance')
                out('return getClass().toString().hashCode();')
            else:
                with self.g.block('int hash = java.util.Arrays.hashCode(new Object []', after=');'):
                    self.g.generate_multiline_list(fields, delim=('', ''))
                if data_type.parent:
                    out('hash = (31 * super.hashCode()) + hash;')
                out('return hash;')

    @staticmethod
    def _java_eq(field, name):
        if field.data_type.is_primitive:
            return 'this.%(f)s == other.%(f)s' % dict(f=name)
        elif not field.data_type.is_nullable:
            return '(this.%(f)s == other.%(f)s) || (this.%(f)s.equals(other.%(f)s))' % dict(f=name)
        else:
            return '(this.%(f)s == other.%(f)s) || (this.%(f)s != null && this.%(f)s.equals(other.%(f)s))' % dict(f=name)

    def generate_equals(self, data_type):
        assert isinstance(data_type, DataTypeWrapper), repr(data_type)
        assert data_type.is_struct or data_type.is_union, repr(data_type)

        if data_type.is_struct:
            self.generate_struct_equals(data_type)
        else:
            self.generate_union_equals(data_type)

    def generate_union_equals(self, data_type):
        out = self.g.emit

        assert data_type.is_union, repr(data_type)
        assert not data_type.is_enum, "enum types don't require equals() methods"

        out('')
        out('@Override')
        with self.g.block('public boolean equals(Object obj)'):
            with self.g.block('if (obj == this)'):
                out('return true;')
            with self.g.block('else if (obj instanceof %s)' % data_type.java_class):
                out('%(cn)s other = (%(cn)s) obj;' % dict(cn=data_type.java_class))
                with self.g.block('if (this.tag != other.tag)'):
                    out('return false;')

                with self.g.block('switch (tag)'):
                    for field in data_type.all_fields:
                        out('case %s:' % field.tag_name)
                        with self.g.indent():
                            if field.has_value:
                                out('return %s;' % self._java_eq(field, field.java_name))
                            else:
                                out('return true;')
                    out('default:')
                    with self.g.indent():
                        out('return false;')
            with self.g.block('else'):
                out('return false;')

    def generate_struct_equals(self, data_type):
        out = self.g.emit

        assert data_type.is_struct, repr(data_type)

        parent_fields = data_type.parent.fields if data_type.parent else ()
        field_tuples = tuple((f, f.java_name) for f in data_type.all_fields)

        out('')
        out('@Override')
        with self.g.block('public boolean equals(Object obj)'):
            with self.g.block('if (obj == this)'):
                out('return true;')
            out('// be careful with inheritance')
            with self.g.block('else if (obj.getClass().equals(this.getClass()))'):
                out('%(cn)s other = (%(cn)s) obj;' % dict(cn=data_type.java_class))

                if not field_tuples:
                    out('return true;')
                elif len(field_tuples) == 1:
                    out('return %s;' % self._java_eq(*field_tuples[0]))
                else:
                    out('return (%s)' % self._java_eq(*field_tuples[0]))
                    with self.g.indent():
                        for field, name in field_tuples[1:]:
                            out('&& (%s)' % self._java_eq(field, name))
                        out(';')
            with self.g.block('else'):
                out('return false;')

    @contextmanager
    def conditional_block(self, text, predicate):
        if predicate:
            with self.g.block(text):
                yield
        else:
            yield


# TODO: Add all Java reserved words.
_RESERVED_KEYWORDS = {
    'Enum',
    'Iterable',
    'Object',
    'abstract',
    'assert',
    'boolean',
    'break',
    'byte',
    'case',
    'catch',
    'char',
    'class',
    'const',
    'continue',
    'default',
    'do',
    'double',
    'else',
    'enum',
    'extends',
    'false',
    'final',
    'finally',
    'float',
    'for',
    'goto',
    'if',
    'int',
    'interface',
    'long',
    'native',
    'new',
    'null',
    'package',
    'private',
    'protected',
    'public',
    'return',
    'short',
    'static',
    'strictfp',
    'super',
    'switch',
    'synchronized',
    'this',
    'throw',
    'throws',
    'transient',
    'true',
    'try',
    'void',
    'volatile',
    'while',
}


_TYPE_MAP_UNBOXED = {
    'UInt64': 'long',
    'Int64': 'long',
    'UInt32': 'long',
    'Int32': 'int',
    'Float64': 'double',
    'Float32': 'float',
    'Boolean': 'boolean',
    'Bytes': 'byte[]',
    'String': 'String',
    'Timestamp': 'java.util.Date',
    'Void': 'void',
}


_TYPE_MAP_BOXED = {
    'UInt64': 'Long',
    'Int64': 'Long',
    'UInt32': 'Long',
    'Int32': 'Integer',
    'Float64': 'Double',
    'Float32': 'Float',
    'Boolean': 'Boolean',
    'Bytes': 'byte[]',
    'String': 'String',
    'Timestamp': 'java.util.Date',
    'Void': 'Void',
}
