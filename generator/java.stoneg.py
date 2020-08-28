from __future__ import absolute_import, division, print_function, unicode_literals

import abc
import argparse
import json
import os
import re
import six
import sys
import types

from collections import defaultdict, OrderedDict, Sequence
from contextlib import contextmanager
from functools import (
    partial,
    total_ordering,
    wraps,
)
from itertools import chain

from stone.ir import (
    Api,
    ApiNamespace,
    ApiRoute,
    DataType,
    Field,
    Int32,
    is_boolean_type,
    is_bytes_type,
    is_composite_type,
    is_list_type,
    is_map_type,
    is_nullable_type,
    is_numeric_type,
    is_primitive_type,
    is_string_type,
    is_struct_type,
    is_timestamp_type,
    is_union_type,
    is_user_defined_type,
    is_void_type,
    StructField,
    TagRef,
    Union,
    UnionField,
    unwrap_nullable,
    Void,
)
from stone.backend import CodeBackend
from stone.frontend.ir_generator import parse_data_types_from_doc_ref

@six.add_metaclass(abc.ABCMeta)
class StoneType:
    pass

StoneType.register(ApiNamespace)
StoneType.register(ApiRoute)
StoneType.register(DataType)
StoneType.register(Field)

def cached(f):
    cache = {}

    @wraps(f)
    def wrapper(*args, **kwargs):
        key = tuple(args) + tuple(entry for entry in sorted(kwargs.items()))
        if key in cache:
            return cache[key]
        else:
            val = f(*args, **kwargs)
            cache[key] = val
            return val

    return wrapper

class cached_property(object):
    """
    Decorator similar to @property, but which caches the results permanently.
    """
    def __init__(self, func):
        self._func = func
        self._attr_name = func.__name__

    def __get__(self, instance, owner):
        if instance is None:
            return self
        else:
            val = self._func(instance)
            instance.__dict__[self._attr_name] = val
            return val


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


def split_stone_name(stone_fq_name, max_parts):
    assert isinstance(stone_fq_name, six.text_type), repr(stone_fq_name)
    assert max_parts > 0, "max_parts must be positive"

    parts = stone_fq_name.split('.')
    if len(parts) > max_parts:
        raise ValueError('Malformed Stone reference: %s' % stone_fq_name)
    else:
        filler = (None,) * (max_parts - len(parts))
        return filler + tuple(parts)


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
    assert isinstance(data_type, DataType), repr(data_type)
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
    Returns a list of (tag, DataType) pairs.

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
    assert isinstance(data_type, DataType), repr(data_type)

    if not data_type.has_enumerated_subtypes():
        return []

    subtypes = []
    def add_subtype(data_type):
        subtypes.append(data_type)
        if data_type.has_enumerated_subtypes():
            for subtype in data_type.get_enumerated_subtypes():
                add_subtype(subtype.data_type)

    add_subtype(data_type)

    result = []
    for subtype in subtypes:
        tag = '.'.join(name for name, _ in get_ancestors(subtype) if name)
        result.append((tag, subtype))

    return result


def get_underlying_type(data_type, allow_data_structures=True):
    assert isinstance(data_type, DataType), repr(data_type)

    while True:
        if allow_data_structures and is_list_type(data_type):
            data_type = data_type.data_type
        elif allow_data_structures and is_map_type(data_type):
            data_type = data_type.value_data_type
        elif is_nullable_type(data_type):
            data_type = data_type.data_type
        else:
            break

    return data_type


def union_create_with_method_name(data_type, value_fields_subset):
    if len(value_fields_subset) > 0:
        method_suffix = 'And%s' % _capwords(value_fields_subset[0].name)
    else:
        method_suffix = ''
    return 'withTag%s' % method_suffix


def format_func_name(route):
    return '{}_v{}'.format(route.name, route.version) if route.version > 1 else route.name


@total_ordering
class JavaClass(object):
    """
    Represents a Java class name.

    This class is a convenience for handling Java classes. This class lets you reference a Java
    class explicitly by its fully-qualified name or its short-name.

    :ivar str fq_name: Fully-qualified Java class name
    """

    def __init__(self, fq_name, generics=()):
        assert isinstance(fq_name, six.text_type), repr(fq_name)
        assert isinstance(generics, Sequence), repr(generics)

        self._fq_name = fq_name
        self._generics = generics

        for g in generics:
            assert isinstance(g, (JavaClass, six.text_type)), repr(generics)
            if isinstance(g, six.text_type):
                assert '.' not in g, repr(generics)

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

    @classmethod
    def from_str(cls, val):
        """
        Returns an instance of JavaClass from its string representation produced using str(..).
        """
        matcher = re.match(r'^(?P<fq_name>[^< ]+)(?:<(?P<generics>.*)>)?$', val)
        if matcher is None:
            raise ValueError("Malformed Java class: %s" % val)
        fq_name = matcher.group('fq_name')
        generics_group = matcher.group('generics')

        generics = []
        if generics_group is not None:
            for gtype in generics_group.split(','):
                gtype = gtype.strip()
                if not gtype:
                    raise ValueError("Malformed Java class: %s" % val)
                if '.' in gtype:
                    generics.append(cls.from_str(gtype))
                else:
                    generics.append(gtype)

        return JavaClass(fq_name, generics=generics)

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
    def name_with_generics(self):
        if self._generics and all('.' in g for g in self._generics):
            return '%s<%s>' % (self._name, ', '.join(self._generics))
        else:
            return self._name

    def resolved_name(self, current_class, imports, generics=False):
        """
        Returns the appropriate name to use when referencing this class from within the given class.

        Examples:
            current_class => JavaClass("com.dropbox.files.C")
            imports => {JavaClass("com.dropbox.common.A"), JavaClass("java.util.B")}

            "com.dropbox.files.D"   => "D"                    # package local
            "com.dropbox.common.E"  => "com.dropbox.common.E" # not imported
            "com.dropbox.common.A"  => "A"                    # already imported
            "com.dropbox.files.C.X" => "X"                    # nested inner class
            "java.util.B.Y"         => "B.Y"                  # nested class outside current class

        Args:
            current_class(JavaClass): class that will reference this class
            imports(set[JavaClass]): set of full-qualified classes that have been imported

        :rtype: str
        """
        resolved = self._resolved_name(current_class, imports)
        if generics and self._generics:
            resolved_generics = ', '.join(
                g.resolved_name(current_class, imports, generics) if isinstance(g, JavaClass) else g
                for g in self._generics
            )
            return '%s<%s>' % (resolved, resolved_generics)
        else:
            return resolved

    def _resolved_name(self, current_class, imports):
        # no package, so just return the name
        if not self._package:
            return self._name

        assert isinstance(current_class, JavaClass), repr(current_class)
        assert imports is not None

        # inner class? (e.g. com.foo.CommitInfo.Builder)
        if self._fq_name.startswith(current_class._fq_name + '.'):
            return self._fq_name[len(current_class._fq_name) + 1:]

        # package-local class? we don't need to import these
        if self._package == current_class.package:
            return self._static_name

        # check if we already imported this name into our current context
        if self.import_class in imports:
            return self._static_name

        # last resort, display fully-qualified name
        return self._fq_name

    @property
    def package(self):
        """
        Name of package containing this Java class.

        Example: com.foo.Bar.Wop => com.foo

        :rtype: str
        """
        return self._package

    @property
    def is_nested(self):
        """
        Whether or not this class is nested within another Java class.

        :rtype: bool
        """
        return self._static_name != self._name

    @property
    def import_class(self):
        """
        Returns the root class containing this nested class. Example:

            com.foo.Bar     => com.foo.Bar
            com.foo.Bar.A   => com.foo.Bar
            com.foo.Bar.A.B => com.foo.Bar

        The returned class is the class you would import if you needed access to this class.

        :rtype: JavaClass
        """
        return JavaClass(self._import_name)

    def __repr__(self):
        return '%s(%s)' % (type(self), str(self))

    def __str__(self):
        if self._generics:
            return '%s<%s>' % (self._fq_name, ', '.join(str(g) for g in self._generics))
        else:
            return self._fq_name

    def __hash__(self):
        return hash(self._fq_name)

    def __ne__(self, other):
        return not self.__eq__(other)

    def __eq__(self, other):
        if isinstance(other, JavaClass):
            return self._fq_name == other._fq_name
        return False

    def __lt__(self, other):
        assert isinstance(other, type(self)), repr(other)
        return self._fq_name < other._fq_name


@total_ordering
class Visibility(object):
    def __init__(self, rank, name, modifier):
        self._rank = rank
        self._name = name
        self._modifier = modifier

    @property
    def name(self):
        return self._name

    @property
    def is_visible(self):
        return self._modifier is not None

    @property
    def modifier(self):
        if not self.is_visible:
            raise ValueError("Not visible")
        return self._modifier

    @classmethod
    def from_name(cls, name):
        for value in cls._VALUES:
            if value.name == name:
                return value
        raise ValueError("Unrecognized name: %s" % name)

    def __repr__(self):
        return self._name

    def __hash__(self):
        return self._rank

    def __ne__(self, other):
        return not self.__eq__(other)

    def __eq__(self, other):
        if isinstance(other, type(self)):
            return self._rank == other._rank
        return False

    def __lt__(self, other):
        assert isinstance(other, type(self)), repr(other)
        return self._rank < other._rank

Visibility.NONE = Visibility(0, 'NONE', None)
Visibility.PRIVATE = Visibility(1, 'PRIVATE', 'private')
Visibility.PACKAGE = Visibility(2, 'PACKAGE', '')
Visibility.PUBLIC = Visibility(3, 'PUBLIC', 'public')
Visibility._VALUES = (Visibility.NONE, Visibility.PRIVATE, Visibility.PACKAGE, Visibility.PUBLIC)


_CMDLINE_PARSER = argparse.ArgumentParser(prog='java-generator')
_CMDLINE_PARSER.add_argument('--package', type=six.text_type, required=True,
                             help='base package name')
_CMDLINE_PARSER.add_argument('--client-class', type=six.text_type, default='StoneClient',
                             help='Name of client class to generate.')
_CMDLINE_PARSER.add_argument('--client-javadoc', type=six.text_type,
                             default='Auto-generated Stone client',
                             help='Class Javadoc to use for auto-generated client.')
_CMDLINE_PARSER.add_argument('--requests-classname-prefix', type=six.text_type, default=None,
                             help=('Prefix to prepend to the per-namespace requests classes. '
                                   'Defaults to using the name of the client class.'))
_CMDLINE_PARSER.add_argument('--data-types-only', action="store_true", default=False,
                             help='Generate all data types but no routes or clients.')
_CMDLINE_PARSER.add_argument('--javadoc-refs', type=six.text_type, default=None,
                             help='Path to Javadoc references file. If a file exists at this ' +
                             'path, it will be loaded and used for generating correct Javadoc ' +
                             'references based off previous generator runs. This is useful when ' +
                             'generating multiple clients for a single project. ' +
                             'If this argument is specified, an update Javadoc references file ' +
                             'will be saved to the given location. It is OK if this file does not ' +
                             'exist.')
_CMDLINE_PARSER.add_argument('--unused-classes-to-generate', default=None, help='Specify types ' +
                             'that we want to generate regardless of whether they are used.')

class JavaCodeGenerator(CodeBackend):
    cmdline_parser = _CMDLINE_PARSER

    def generate(self, api):
        """
        Toplevel code generation method.

        This is called by stone.cli.
        """
        generator = JavaCodeGenerationInstance(self, api)
        if self.args.data_types_only:
            assert self.args.javadoc_refs is None, "Cannot specify --javadoc-refs with --data-types-only"
            generator.generate_data_types()
        else:
            generator.generate_all()


class JavaImporter(object):
    def __init__(self, current_class, j):
        assert isinstance(current_class, JavaClass), repr(current_class)
        assert isinstance(j, JavaApi), repr(j)

        self._class = current_class
        self._j = j
        self._imports = set()

    @property
    def imports(self):
        return frozenset(self._imports)

    def add_imports(self, *imports):
        """
        Adds the fully-qualified Java class names to the set of imports for the currently generated
        class.

        Imports must be fully-qualified class name strings (e.g. ``"com.foo.Bar"``) or JavaClass
        instances.
        """
        assert all(isinstance(i, (six.text_type, JavaClass)) for i in imports), repr(imports)

        def convert(val):
            if isinstance(val, JavaClass):
                return val
            elif isinstance(val, six.string_types):
                return JavaClass(val)
            else:
                raise AssertionError(repr(type(val)))

        # convert all imports to JavaClass instances
        imports = [convert(i) for i in imports]
        # remove imports that are missing package (e.g. long, Integer,
        # etc) and imports from java.lang
        imports = [
            i for i in imports
            if i.package and i.package != 'java.lang'
        ]

        current_class_prefix = self._class.fq + '.'

        existing_names = {i.name: i for i in self._imports}
        # avoid issues where we import a class with the same name as us
        existing_names[self._class.name] = self._class

        for import_ in imports:
            # resolve nested classes to their root containing class
            import_ = import_.import_class

            # already imported or local name (not fully qualified)
            if import_ in self._imports or not import_.package:
                continue

            # ignore nested classes inside our current class
            if import_ == self._class:
                continue

            # is this import in our existing names? make sure we choose the most "valid" import
            # between the two:
            if import_.name in existing_names:
                # we always prefer package-local imports, otherwise we can't determine at name
                # resolution time whether a package-local class needs to be fully-qualified or
                # not. This means we essentially block all imports that clash with package-local
                # class names.
                if import_.package == self._class.package:
                    existing_import = existing_names[import_.name]
                    self._imports.remove(existing_import)
                    existing_names[import_.name] = import_
                    self._imports.add(import_)
                else:
                    # leave the existing import alone
                    pass
            else:
                # new import
                existing_names[import_.name] = import_
                self._imports.add(import_)

    def add_imports_for_namespace(self, namespace):
        assert isinstance(namespace, ApiNamespace), repr(namespace)

        self.add_imports(
            'com.dropbox.core.DbxException',
            'com.dropbox.core.DbxWrappedException',
            'com.dropbox.core.http.HttpRequestor',
            'com.dropbox.core.v2.DbxRawClientV2',
            'java.util.HashMap',
            'java.util.Map',
        )
        for route in namespace.routes:
            self.add_imports_for_route(route)

    def add_imports_for_route(self, route):
        assert isinstance(route, ApiRoute), repr(route)

        j = self._j

        self._add_imports_for_data_type(route.arg_data_type)
        self._add_imports_for_data_type(route.result_data_type)
        self._add_imports_for_data_type_exception(route.error_data_type)

        if j.has_builder(route) and j.has_arg(route) and j.has_builder(route.arg_data_type):
            self._add_imports_for_data_type_builder(route.arg_data_type)

        if is_struct_type(route.arg_data_type):
            if j.has_builder(route):
                fields = route.arg_data_type.all_required_fields
            else:
                fields = route.arg_data_type.all_fields

            for field in fields:
                self.add_imports_for_field(field)

        if j.request_style(route) == 'upload':
            self.add_imports('com.dropbox.core.DbxUploader')
            if j.has_builder(route):
                self.add_imports('com.dropbox.core.v2.DbxUploadStyleBuilder')
        elif j.request_style(route) == 'download':
            self.add_imports(
                'com.dropbox.core.DbxDownloader',
                'com.dropbox.core.v2.DbxDownloadStyleBuilder',
                'java.util.Collections',
                'java.util.List',
                'java.util.Map',
            )

    def add_imports_for_route_builder(self, route):
        assert isinstance(route, ApiRoute), repr(route)

        j = self._j

        assert j.has_builder(route), repr(route)

        if j.has_arg(route) and j.has_builder(route.arg_data_type):
            self._add_imports_for_data_type_builder(route.arg_data_type)
        self._add_imports_for_data_type(route.result_data_type)
        self._add_imports_for_data_type_exception(route.error_data_type)

        namespace = j.route_namespace(route)
        self.add_imports(
            j.java_class(namespace),
            'com.dropbox.core.DbxException',
        )

        for field in route.arg_data_type.all_optional_fields:
            self.add_imports_for_field(field)

        if j.request_style(route) == 'download':
            self.add_imports(
                'com.dropbox.core.v2.DbxDownloadStyleBuilder',
                'com.dropbox.core.DbxDownloader',
            )
        elif j.request_style(route) == 'upload':
            self.add_imports('com.dropbox.core.v2.DbxUploadStyleBuilder')

    def add_imports_for_route_uploader(self, route):
        self.add_imports(
            'com.dropbox.core.DbxWrappedException',
            'com.dropbox.core.DbxUploader',
            'com.dropbox.core.http.HttpRequestor',
            'java.io.IOException',
        )
        self._add_imports_for_data_type(route.result_data_type)
        self._add_imports_for_data_type_exception(route.error_data_type)

    def add_imports_for_data_type(self, data_type, include_serialization=True):
        assert isinstance(data_type, DataType), repr(data_type)
        assert is_user_defined_type(data_type), repr(data_type)

        j = self._j

        # for hash code computation
        if data_type.fields or (is_union_type(data_type) and not j.is_enum(data_type)):
            self.add_imports('java.util.Arrays')

        self._add_imports_for_data_type(data_type)

        if include_serialization:
            self._add_imports_for_data_type_serializers(data_type)

        for field in data_type.all_fields:
            self.add_imports_for_field(field)
            # for regex pattern validation
            if is_string_type(field.data_type) and field.data_type.pattern is not None:
                self.add_imports('java.util.regex.Pattern')

        # check if we need to import parent type
        if is_struct_type(data_type) and data_type.parent_type:
            self._add_imports_for_data_type(data_type.parent_type)

    def add_imports_for_exception_type(self, data_type):
        j = self._j
        self.add_imports(
            'com.dropbox.core.DbxApiException',
            'com.dropbox.core.LocalizedText',
            j.java_class(data_type),
        )

    def add_imports_for_field(self, field):
        self._add_imports_for_data_type(field.data_type)

    def _add_imports_for_data_type(self, data_type):
        j = self._j

        if is_user_defined_type(data_type):
            self.add_imports(j.java_class(data_type))
        else:
            java_type = _TYPE_MAP_UNBOXED.get(data_type.name)
            if java_type and '.' in java_type:
                self.add_imports(java_type)

            if is_list_type(data_type) or is_nullable_type(data_type):
                self._add_imports_for_data_type(data_type.data_type)
            elif is_map_type(data_type):
                self._add_imports_for_data_type(data_type.value_data_type)
            elif is_timestamp_type(data_type):
                self.add_imports('com.dropbox.core.util.LangUtil')

    def _add_imports_for_data_type_builder(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        j = self._j
        self.add_imports(j.builder_class(data_type))

    def _add_imports_for_data_type_exception(self, data_type):
        j = self._j

        if is_void_type(data_type):
            self.add_imports('com.dropbox.core.DbxApiException')
        else:
            self.add_imports(
                j.java_class(data_type),
                j.exception_class(data_type),
            )

    def _add_imports_for_data_type_serializers(self, data_type):
        self.add_imports(
            'java.io.IOException',
            'com.fasterxml.jackson.core.JsonGenerationException',
            'com.fasterxml.jackson.core.JsonGenerator',
            'com.fasterxml.jackson.core.JsonParseException',
            'com.fasterxml.jackson.core.JsonParser',
            'com.fasterxml.jackson.core.JsonToken',
            'com.dropbox.core.stone.StoneSerializers',
            'com.dropbox.core.stone.StoneDeserializerLogger',
        )
        if is_struct_type(data_type):
            self.add_imports('com.dropbox.core.stone.StructSerializer')
        elif is_union_type(data_type):
            self.add_imports('com.dropbox.core.stone.UnionSerializer')

    def __repr__(self):
        return '%s(class=%s,imports=%s)' % (type(self).__name__, self._class, self._imports)


class JavaClassWriter(object):
    def __init__(self, g, j, refs, java_class, stone_element=None, package_doc=None):
        assert isinstance(java_class, JavaClass), repr(java_class)
        assert java_class.package, repr(java_class)

        self.importer = JavaImporter(java_class, j)

        self._g = g
        self._j = j
        self._refs = refs
        self._class = java_class
        self._stone_element = stone_element
        self._package_doc = package_doc

        if package_doc:
            assert java_class.name == 'package-info', "Only package-info.java files can contain package Javadoc"

    def _mkdirs(self, path):
        if not os.path.isdir(path):
            self._g.logger.info('Creating directory %s', path)
            os.makedirs(path)

    def __enter__(self):
        components = self._class.import_class.fq.split('.')
        path = os.path.join(*components)
        self._mkdirs(os.path.dirname(path))

        self._enter_ctx = self._g.output_to_relative_path(path + '.java')
        self._enter_ctx.__enter__()
        self._emit_header()
        if self._package_doc:
            self.javadoc(self._package_doc)
        self.out('package %s;', self._class.package)
        self.out('')
        return self

    def __exit__(self, exc_type, exc_value, traceback):
        ret = self._enter_ctx.__exit__(exc_type, exc_value, traceback)
        self._enter_ctx = None
        return ret

    def fmt(self, fmt_str, *args, **kwargs):
        assert isinstance(fmt_str, six.text_type), repr(fmt_str)
        generics = kwargs.get('generics', True)
        # resolve JavaClass to appropriate names based on our current imports
        resolved_args = tuple(
            self.resolved_class(a, generics=generics) if isinstance(a, JavaClass) else a
            for a in args
        )
        return fmt_str % resolved_args

    def out(self, fmt_str, *args, **kwargs):
        self._g.emit(self.fmt(fmt_str, *args), **kwargs)

    def block(self, fmt_str, *args, **kwargs):
        return self._g.block(self.fmt(fmt_str, *args).strip(), **kwargs)

    @contextmanager
    def conditional_block(self, predicate, fmt_str, *args):
        if predicate:
            with self.block(fmt_str, *args):
                yield
        else:
            yield

    def class_block(self, element, visibility=Visibility.PUBLIC, parent_class=None):
        assert isinstance(element, (JavaClass, StoneType)), repr(element)
        assert visibility.is_visible, repr((element, visibility))

        j = self._j

        java_class = j.java_class(element) if isinstance(element, StoneType) else element

        modifiers = [visibility.modifier]
        class_type = 'class'
        class_name = java_class.name_with_generics
        inheritance = parent_class

        if java_class.is_nested:
            modifiers.append('static')

        if isinstance(element, DataType):
            data_type = element
            if j.is_enum(data_type):
                class_type = 'enum'
            elif is_union_type(data_type):
                modifiers.append('final')
            elif is_struct_type(data_type) and data_type.parent_type:
                assert parent_class is None, repr((data_type, parent_class))
                inheritance = j.java_class(data_type.parent_type)

        if inheritance:
            return self.block('%s %s %s extends %s', ' '.join(modifiers), class_type, class_name, inheritance)
        else:
            return self.block('%s %s %s', ' '.join(modifiers), class_type, class_name)

    def resolved_class(self, val, generics=True):
        if isinstance(val, six.text_type):
            val = JavaClass(val)
        else:
            assert isinstance(val, JavaClass), repr(val)
        return val.resolved_name(self._class, self.importer.imports, generics=generics)

    def _emit_header(self):
        j = self._j
        filenames = j.get_spec_filenames(self._stone_element) if self._stone_element else None
        self.out('/* DO NOT EDIT */')
        if filenames:
            self.out('/* This file was generated from %s */' % ', '.join(filenames))
        else:
            self.out('/* This file was generated by Stone */')
        self.out('')

    def write_imports(self):
        # start off will all imports, then group into categories
        imports = self.importer.imports

        # remove package-local imports
        imports = {
            import_ for import_ in imports
            if import_.package != self._class.package
        }

        # group all our project imports into one spot. use the first two package parts for root corp
        # package (e.g. com.foo.core.v2 -> com.foo)
        project_package_prefix = '.'.join(self._class.package.split('.', 2)[:2])
        project_imports = {
            import_ for import_ in imports
            if import_.package.startswith(project_package_prefix)
        }
        imports = imports - project_imports

        # now group the rest by the first package part
        grouped = defaultdict(set)
        for import_ in imports:
            root = import_.package.split('.', 1)[0]
            grouped[root].add(import_)

        # now write out the groups in this order:
        #
        #    project packages
        #    3rd party packages
        #    java
        #    javax

        if project_imports:
            for import_ in sorted(project_imports):
                self.out('import %s;', import_.import_class.fq)

        java_imports = grouped.pop('java', set())
        javax_imports = grouped.pop('javax', set())

        needs_newline = bool(project_imports)
        for _, imports in chain(sorted(grouped.items()), [
                ('java', java_imports),
                ('javax', javax_imports)
        ]):
            if imports:
                if needs_newline:
                    self.out('')
                needs_newline = True
                for import_ in sorted(imports):
                    self.out('import %s;', import_.import_class.fq)

    def java_default_value(self, field):
        assert isinstance(field, Field), repr(field)
        assert field.has_default, repr(field)
        default_value = '\"\"' if field.default == '' else field.default
        return self.java_value(field.data_type, default_value)

    def java_value(self, data_type, stone_value):
        assert isinstance(data_type, DataType), repr(data_type)

        j = self._j

        if data_type.name == 'Boolean':
            return 'true' if stone_value else 'false'
        elif data_type.name == 'String':
            return self.fmt('"%s"', stone_value.replace('\\', '\\\\').replace('"', '\\"'))
        elif data_type.name in ('Float32', 'Float64'):
            return repr(stone_value) # Because str() drops the last few digits.
        elif data_type.name in ('Int64', 'UInt64', 'UInt32'):
            return str(stone_value) + 'L'  # Need exact type match for boxed values.
        elif is_union_type(data_type):
            assert isinstance(stone_value, TagRef), (data_type, stone_value)
            assert data_type == stone_value.union_data_type, (data_type, stone_value)

            for field in data_type.all_fields:
                if field.name == stone_value.tag_name:
                    if j.field_static_instance(field):
                        value = self.fmt('%s.%s', j.java_class(data_type), j.field_static_instance(field))
                    else:
                        assert j.field_factory_method(field)
                        value = self.fmt('%s.%s()', j.java_class(data_type), j.field_factory_method(field))
                    return value
            else:
                assert False, "Could not find tag '%s' in '%s'" % (stone_value.tag_name, data_type)
        else:
            return str(stone_value)

    def java_serializer(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)

        if is_user_defined_type(data_type):
            serializer_class = self._j.serializer_class(data_type)
            return self.fmt('%s.INSTANCE', serializer_class)
        else:
            serializers_class = JavaClass('com.dropbox.core.stone.StoneSerializers')
            if is_nullable_type(data_type) and is_struct_type(data_type.data_type):
                return self.fmt('%s.nullableStruct(%s)',
                                serializers_class, self.java_serializer(data_type.data_type))
            elif is_nullable_type(data_type):
                return self.fmt('%s.nullable(%s)',
                                serializers_class, self.java_serializer(data_type.data_type))
            elif is_list_type(data_type):
                # TODO: also support passing collapsed to list serializer
                return self.fmt('%s.list(%s)',
                                serializers_class, self.java_serializer(data_type.data_type))
            elif is_map_type(data_type):
                return self.fmt('%s.map(%s)',
                                serializers_class, self.java_serializer(data_type.value_data_type))
            else:
                return self.fmt('%s.%s()', serializers_class, camelcase(data_type.name))

    def javadoc(self, doc,
                stone_elem=None,
                fields=(),
                params=(),
                returns=None,
                throws=(),
                deprecated=None,
                allow_defaults=True):
        # convenience so we can do "javadoc(field)"
        if isinstance(doc, StoneType):
            assert stone_elem is None, repr(stone_elem)
            stone_elem = doc
            assert hasattr(stone_elem, "doc"), repr(stone_elem)
            doc = stone_elem.doc
            # apply default catch-all documentation to all fields
            if not doc and isinstance(stone_elem, UnionField):
                if stone_elem == self._j.field_containing_data_type(stone_elem).catch_all_field:
                    doc = _CATCH_ALL_DOC

        doc = doc or ''

        assert isinstance(doc, six.text_type), repr((doc, stone_elem))
        assert isinstance(stone_elem, StoneType) or stone_elem is None, repr(stone_elem)
        assert isinstance(fields, Sequence), repr(fields)
        assert all(isinstance(f, Field) for f in fields), repr(fields)
        assert isinstance(params, (Sequence, OrderedDict)), repr(params)
        assert isinstance(returns, (six.text_type, StoneType)) or returns is None, repr(returns)
        assert isinstance(throws, (Sequence, OrderedDict)), repr(throws)
        assert isinstance(deprecated, (ApiRoute, bool)) or deprecated is None, repr(deprecated)

        # auto-detect deprecated values
        if deprecated is None and stone_elem is not None:
            if isinstance(stone_elem, ApiRoute):
                deprecation_info = stone_elem.deprecated
                if deprecation_info is not None:
                    deprecated = deprecation_info.by or True
            elif isinstance(stone_elem, StructField):
                deprecated = stone_elem.deprecated
            else:
                assert not hasattr(stone_elem, "is_deprecated"), repr(stone_elem)

        params_doc = self._javadoc_fields(fields, stone_elem, allow_defaults=allow_defaults)
        params_doc.update(self._translate_ordered_collection(params, stone_elem))
        if isinstance(returns, StoneType):
            returns_doc = self._translate_stone_doc(returns.doc, returns) if hasattr(returns, 'doc') else ''
        else:
            returns_doc = self._translate_stone_doc(returns, stone_elem)
        throws_doc = self._translate_ordered_collection(throws, stone_elem)
        deprecated_doc = self._javadoc_deprecated(deprecated)

        requires_validation = any(self._field_validation_requirements(f) for f in fields)
        if requires_validation:
            exception = "IllegalArgumentException"
            if exception in throws_doc:
                throws_doc[exception] += ". Also thrown if any argument does not meet its preconditions."
            else:
                throws_doc[exception] = "If any argument does not meet its preconditions."

        return self._generate_javadoc_raw(
            self._translate_stone_doc(doc, stone_elem),
            params=params_doc,
            returns=returns_doc,
            throws=throws_doc,
            deprecated=deprecated_doc,
        )

    def throws(self, field, value_name=None):
        assert isinstance(field, Field), repr(field)
        assert value_name is None or isinstance(value_name, six.text_type), repr(value_name)

        reasons = self._field_validation_requirements(field, as_failure_reasons=True)
        throws = OrderedDict()

        if reasons:
            reasons_list = oxford_comma_list(reasons, conjunction='or')
            throws["IllegalArgumentException"] = "if {@code %s} %s." % (value_name, reasons_list)

        return throws

    def javadoc_ref(self, element, context=None, builder=False):
        assert isinstance(element, (JavaClass, StoneType, JavaReference)), repr(element)
        assert isinstance(context, StoneType) or context is None, repr(context)

        j = self._j

        if isinstance(element, JavaClass):
            ref = self.fmt("{@link %s}", element)
        elif isinstance(element, (ApiRoute, RouteReference)):
            route_ref = self._refs.route(element) if isinstance(element, ApiRoute) else element
            ref = self._javadoc_route_ref(route_ref, builder=builder)
        elif isinstance(element, (DataType, DataTypeReference)):
            if isinstance(element, DataType):
                if is_user_defined_type(element):
                    data_type_ref = self._refs.data_type(element)
                    ref = self._javadoc_data_type_ref(data_type_ref, builder=builder)
                else:
                    ref = self.fmt("{@link %s}", j.java_class(element, generics=False))
            else:
                data_type_ref = element
                ref = self._javadoc_data_type_ref(data_type_ref, builder=builder)
        elif isinstance(element, (Field, FieldReference)):
            # we need a context for union fields since we copy fields from parents into their
            # subclasses. Otherwise, we may make a reference to a field in a non-existing class or
            # incorrectly assume the field is an enum constant when it isn't.
            field_ref = self._refs.field(element, context) if isinstance(element, Field) else element
            ref = self._javadoc_field_ref(field_ref)
        else:
            raise AssertionError(repr(element))

        return sanitize_javadoc(ref)

    def _generate_javadoc_raw(self, doc, params=None, returns=None, throws=None, deprecated=None):
        # deprecated can be an empty six.text_type, which means no doc
        if not any((doc, params, returns, throws, deprecated is not None)):
            return

        prefix = ' * '
        attr_doc_prefix = prefix + (' ' * 4)

        def emit_attrs(tag, attrs):
            if attrs:
                self.out(prefix.rstrip())
                attr_prefix = ''.join((prefix, tag, ' '))

                for attr_name, attr_doc in attrs.items():
                    # Javadoc complains about tags that are missing documentation, except for
                    # @deprecated
                    if not attr_doc.strip():
                        if tag == '@deprecated':
                            self._g.emit_wrapped_text(
                                tag,
                                initial_prefix=prefix,
                                subsequent_prefix=attr_doc_prefix)
                        continue

                    if attr_name:
                        doc_text = '  '.join((attr_name, attr_doc))
                    else:
                        doc_text = attr_doc
                    self._g.emit_wrapped_text(
                        collapse_whitespace(doc_text),
                        initial_prefix=attr_prefix,
                        subsequent_prefix=attr_doc_prefix
                    )

        self.out('/**')

        if doc:
            first_paragraph = True
            for paragraph in split_paragraphs(doc.strip()):
                if not first_paragraph:
                    self.out(prefix.rstrip())
                    if paragraph:
                        paragraph = ''.join(('<p> ', paragraph, ' </p>'))
                else:
                    first_paragraph = False
                self._g.emit_wrapped_text(paragraph, initial_prefix=prefix, subsequent_prefix=prefix)

        emit_attrs('@param', params)
        emit_attrs('@return', { "": returns } if returns else None)
        emit_attrs('@throws', throws)
        # deprecated can be empty string, which still means we should emit
        emit_attrs('@deprecated', { "": deprecated } if deprecated is not None else None)

        self.out(' */')
        # compiler requires a separate annotation outside the javadoc to display warnings about
        # using obsolete APIs.
        if deprecated is not None:
            self.out('@Deprecated')

    def _javadoc_fields(self, fields, stone_elem, allow_defaults=True):
        j = self._j

        params = OrderedDict()
        for field in fields:
            assert isinstance(field, Field), repr(field)

            containing_data_type = j.field_containing_data_type(field)
            param_name = j.param_name(field)
            param_stone_doc = field.doc or ''
            is_catch_all = is_union_type(containing_data_type) and field == containing_data_type.catch_all_field
            if not param_stone_doc and is_catch_all:
                param_stone_doc = _CATCH_ALL_DOC

            context = stone_elem if isinstance(stone_elem, DataType) and field in stone_elem.all_fields else field
            param_doc = self._translate_stone_doc(param_stone_doc, field)

            # add '.' at end of doc if we have a doc and its missing.
            if param_doc.strip() and not param_doc.endswith('.'):
                param_doc += '.'

            preconditions = self._field_validation_requirements(field)
            if preconditions:
                param_doc += " Must %s." % oxford_comma_list(preconditions, conjunction='and')

            if allow_defaults and isinstance(field, StructField) and field.has_default:
                param_doc += " Defaults to {@code %s} when set to {@code null}." % (
                    self.java_default_value(field)
                )

            param_doc = param_doc.strip()
            if param_doc:
                params[param_name] = param_doc

        return params

    def _javadoc_deprecated(self, deprecated):
        assert isinstance(deprecated, (ApiRoute, bool)) or deprecated is None, repr(deprecated)

        if isinstance(deprecated, ApiRoute):
            return 'use %s instead.' % self.javadoc_ref(deprecated)
        elif isinstance(deprecated, bool) and deprecated:
            return ''
        else:
            return None

    def _translate_ordered_collection(self, collection, stone_elem):
        assert isinstance(collection, (Sequence, types.GeneratorType, OrderedDict)), repr(collection)

        if isinstance(collection, OrderedDict):
            collection = collection.items()

        return OrderedDict(
            (param_name, self._translate_stone_doc(doc, stone_elem))
            for param_name, doc in collection
        )

    def _field_validation_requirements(self, field, as_failure_reasons=False):
        assert isinstance(field, Field), repr(field)

        # field has no value
        if is_void_type(field.data_type):
            return None

        data_type = field.data_type
        nullable = is_nullable_type(data_type)
        if nullable:
            data_type = data_type.data_type

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
            if hasattr(data_type, condition):
                val = getattr(data_type, condition)
                if val is not None:
                    add_req(precondition % val, failure_reason % val)

        if is_list_type(data_type) or is_map_type(data_type):
            add_req('not contain a {@code null} item', 'contains a {@code null} item')
        elif is_string_type(data_type) and data_type.pattern is not None:
            pattern = sanitize_pattern(data_type.pattern)
            add_req('match pattern "{@code %s}"' % pattern, 'does not match pattern "{@code %s}"' % pattern)

        if not (nullable or self._j.is_java_primitive(data_type) or is_void_type(data_type)):
            add_req('not be {@code null}', 'is {@code null}')

        return requirements

    def _translate_stone_doc(self, doc, stone_elem=None):
        assert isinstance(doc, six.text_type) or doc is None, repr(doc)
        if doc:
            handler = lambda tag, val: self._javadoc_ref_handler(tag, val, stone_elem=stone_elem)
            return self._g.process_doc(sanitize_javadoc(doc), handler)
        else:
            return doc or ''

    def _javadoc_ref_handler(self, tag, val, stone_elem=None):
        """
        Args:
            tag(str): Type of Stone doc reference being made
            val(str): The Stone element reference
            stone_elem(StoneType): The stone element where this doc is appearing. This
                is the context for looking up references. For example, if we are handling
                the doc of a struct field, the Field object would be `stone_elem`.
                This allows us to look up relative references (e.g. reference another
                field within the same containing struct).
        """
        element = self._lookup_stone_ref(tag, val, stone_elem)
        if element is None and tag in ('route', 'type', 'field'):
            self._g.logger.warn('Unable to resolve Stone reference (:%s:`%s`) [ctx=%s]' % (tag, val, stone_elem))
            return sanitize_javadoc('{@code %s}' % camelcase(val))

        # use {@code ...} tag for unresolved references so we don't have broken links in our Javadoc
        if tag == 'route':
            ref = self._javadoc_route_ref(element)
        elif tag == 'type':
            ref = self._javadoc_data_type_ref(element)
        elif tag == 'field':
            ref = self._javadoc_field_ref(element)
        elif tag == 'link':
            anchor, link = val.rsplit(' ', 1)
            # unsanitize from previous sanitize calls
            anchor = unsanitize_javadoc(anchor)
            # do not sanitize this HTML
            return '<a href="%s">%s</a>' % (link, anchor)
        elif tag == 'val':
            # Note that all valid Stone literals happen to be valid Java literals.
            ref = '{@code %s}' % val
        else:
            assert False, 'Unsupported tag (:%s:`%s`)' % (tag, val)

        return sanitize_javadoc(ref)

    def _lookup_stone_ref(self, tag, val, stone_elem):
        assert isinstance(tag, six.text_type), repr(tag)
        assert isinstance(val, six.text_type), repr(val)
        assert isinstance(stone_elem, StoneType) or stone_elem is None, repr(stone_elem)
        assert val, repr(val)

        j = self._j

        def resolve_fq_name(val, max_parts):
            try:
                parts = split_stone_name(val, max_parts)
            except ValueError as e:
                # mark tag as invalid... can't raise exception here since we don't validate stone docs
                self._g.logger.warn('Malformed Stone reference value: `%s`. %s' % (val, str(e)))
                return None
            else:
                if stone_elem and None in parts:
                    context_parts = j.stone_fq_name(stone_elem).split('.')
                    # pad the end with None's
                    context_parts += [None,] * (max_parts - len(context_parts))
                    parts = [(orig or context) for orig, context in zip(parts, context_parts)]
                if None in parts:
                    return None
                else:
                    return '.'.join(parts)

        if tag == 'route':
            fq_name = resolve_fq_name(val.replace(":", "_v"), 2)
            return self._refs.route(fq_name) if fq_name else None
        elif tag == 'type':
            fq_name = resolve_fq_name(val, 2)
            return self._refs.data_type(fq_name) if fq_name else None
        elif tag == 'field':
            fq_name = resolve_fq_name(val, 3)
            return self._refs.field(fq_name) if fq_name else None
        elif tag == 'link':
            return None
        elif tag == 'val':
            return None
        else:
            assert False, 'Unsupported tag (:%s:`%s`)' % (tag, val)

    def _javadoc_route_ref(self, route_ref, builder=False):
        assert isinstance(route_ref, RouteReference), repr(route_ref)

        if self._g.args.data_types_only:
            return '{@code %s}' % route_ref.url_path

        if builder and route_ref.has_builder:
            method_name = route_ref.builder_method
            method_args = []
        else:
            method_name = route_ref.method
            method_args = [
                self.resolved_class(c, generics=False) for c in route_ref.method_arg_classes
            ]

        if method_args:
            return self.fmt('{@link %s#%s(%s)}', route_ref.java_class, method_name, ','.join(method_args))
        else:
            return self.fmt('{@link %s#%s}', route_ref.java_class, method_name)

    def _javadoc_data_type_ref(self, data_type_ref, builder=False):
        assert isinstance(data_type_ref, DataTypeReference), repr(data_type_ref)
        if builder and data_type_ref.has_builder:
            java_class = data_type_ref.builder_class
        else:
            java_class = data_type_ref.java_class
        return self.fmt('{@link %s}', java_class)

    def _javadoc_field_ref(self, field_ref):
        assert isinstance(field_ref, FieldReference), repr(field_ref)

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
        # So if the field's containing data type is a struct, makre sure the struct is
        # public. Otherwise, try to find out if that struct is uniqued used as a route argument and
        # make the Javadoc reference point to the route method instead of the struct class.
        if field_ref.route_refs and not self._g.args.data_types_only:
            # the struct should not appear anywhere else besides as a route argument
            return 'the {@code %s} argument to %s' % (
                field_ref.param_name,
                oxford_comma_list([
                    self._javadoc_route_ref(route_ref)
                    for route_ref in field_ref.route_refs
                ], conjunction='or'),
            )

        containing_data_type_ref = field_ref.containing_data_type_ref

        # can't reference a package-private data type.
        assert containing_data_type_ref.visibility.is_visible, repr(field_ref)

        # fallback to standard ref
        return self.fmt(
            '{@link %s#%s}',
            containing_data_type_ref.java_class,
            field_ref.static_instance or field_ref.getter_method
        )


class JavaApi(object):
    def __init__(self, api, generator_args):
        self.stone_api = api
        self._args = generator_args
        self._containing_data_types = self._get_containing_data_types(api)
        self._namespaces_by_route = self._get_namespaces_by_route(api)
        self._data_types_with_exception = self._get_data_types_with_exception(api)
        if generator_args.data_types_only:
            self._data_type_visibility = defaultdict(lambda: Visibility.PUBLIC)
            self._serializer_visibility = defaultdict(lambda: Visibility.PUBLIC)
            self._client_data_types = {
                data_type
                for namespace in api.namespaces.values()
                for data_type in namespace.data_types
            }
        else:
            self._data_type_visibility = self._resolve_data_type_visibility(api)
            self._serializer_visibility = self._resolve_serializer_visibility(api)
            # data types required for this specific client. We avoid generating data types that aren't
            # required by the client.
            self._client_data_types = {
                data_type for data_type, visibility in self._data_type_visibility.items()
                if visibility.is_visible
            }

    @staticmethod
    def _get_containing_data_types(api):
        mapping = {}
        for namespace in api.namespaces.values():
            for data_type in namespace.data_types:
                for field in data_type.fields:
                    mapping[field] = data_type
        return mapping

    @staticmethod
    def _get_namespaces_by_route(api):
        mapping = {}
        for namespace in api.namespaces.values():
            for route in namespace.routes:
                mapping[route] = namespace
        return mapping

    @staticmethod
    def _get_data_types_with_exception(api):
        data_types = set()
        for namespace in api.namespaces.values():
            for route in namespace.routes:
                if is_user_defined_type(route.error_data_type):
                    data_types.add(route.error_data_type)
        return data_types

    @staticmethod
    def _resolve_data_type_visibility(api):
        visibility = defaultdict(lambda: Visibility.NONE)

        def update(data_type, new_visibility):
            visibility[data_type] = max(visibility[data_type], new_visibility)

        def update_by_reference(data_type, namespace):
            if data_type.namespace == namespace:
                update(data_type, Visibility.PACKAGE)
            else:
                update(data_type, Visibility.PUBLIC)

        # Calculate initial visibility state based on routes that use our data types.
        for namespace in api.namespaces.values():
            for route in namespace.routes:
                arg = get_underlying_type(route.arg_data_type)
                result = get_underlying_type(route.result_data_type)
                error = get_underlying_type(route.error_data_type)

                if is_user_defined_type(result):
                    update(result, Visibility.PUBLIC)
                if is_user_defined_type(error):
                    update(error, Visibility.PUBLIC)
                if is_user_defined_type(arg):
                    # Could be something like List(FooArg), in which case, we just make FooArg public.
                    if arg != route.arg_data_type:
                        update(arg, Visibility.PUBLIC)
                    elif is_union_type(arg):
                        update(arg, Visibility.PUBLIC)
                    elif is_struct_type(arg):
                        # We explode structs so that their fields are the arguments to the route
                        # method.  We have to construct an instead of the arg object from our route
                        # method, so we might be able to make the arg class package-private if it
                        # isn't referenced anywhere else.
                        update_by_reference(arg, namespace)
                        for field in arg.all_fields:
                            field_data_type = get_underlying_type(field.data_type)
                            if is_user_defined_type(field_data_type):
                                update(field_data_type, Visibility.PUBLIC)

        # Not iterate repeatedly, cascading the visibility out to other required data types as necessary
        prev_state = None
        cur_state = visibility.copy()
        while prev_state != cur_state:
            for namespace in api.namespaces.values():
                if namespace.doc is not None:
                    data_types = parse_data_types_from_doc_ref(api, namespace.doc, namespace.name,
                                                               ignore_missing_entries=True)
                    for d in data_types:
                        update_by_reference(d, namespace)
                for data_type in namespace.data_types:
                    if not visibility[data_type].is_visible:
                        continue

                    if data_type.doc is not None:
                        data_types = parse_data_types_from_doc_ref(api, data_type.doc, namespace.name,
                                                                   ignore_missing_entries=True)
                        for d in data_types:
                            update_by_reference(d, namespace)

                    for field in data_type.all_fields:
                        field_data_type = get_underlying_type(field.data_type)
                        # if this data type is public, then all its fields must be public as well
                        # to ensure they are properly exposed to the user
                        if is_user_defined_type(field_data_type):
                            if visibility[data_type] == Visibility.PUBLIC:
                                update(field_data_type, Visibility.PUBLIC)
                            else:
                                # otherwise, just update visibility so this class can properly reference
                                # the field data type
                                update_by_reference(field_data_type, namespace)

                        if field.doc is not None:
                            data_types = parse_data_types_from_doc_ref(api, field.doc, namespace.name,
                                                                       ignore_missing_entries=True)
                            for d in data_types:
                                update_by_reference(d, namespace)

                    if is_struct_type(data_type):
                        if data_type.parent_type:
                            if visibility[data_type] == Visibility.PUBLIC:
                                update(data_type.parent_type, Visibility.PUBLIC)
                            else:
                                # subclasses need access to their parent class
                                update_by_reference(data_type.parent_type, namespace)

                        # parents need access to their enumerated subtype classes. If the parent is
                        # public, then make the sublcasses public too for casting.
                        if data_type.has_enumerated_subtypes():
                            for subtype in data_type.get_enumerated_subtypes():
                                if visibility[data_type] == Visibility.PUBLIC:
                                    update(subtype.data_type, Visibility.PUBLIC)
                                else:
                                    update_by_reference(subtype.data_type, namespace)

            prev_state = cur_state
            cur_state = visibility.copy()

        return visibility

    @staticmethod
    def _resolve_serializer_visibility(api):
        visibility = defaultdict(lambda: Visibility.NONE)

        def update(data_type, new_visibility):
            visibility[data_type] = max(visibility[data_type], new_visibility)

        def update_by_reference(data_type, namespace):
            if data_type.namespace == namespace:
                update(data_type, Visibility.PACKAGE)
            else:
                update(data_type, Visibility.PUBLIC)

        # Calculate initial visibility state based on routes that use our data types.
        for namespace in api.namespaces.values():
            for route in namespace.routes:
                for data_type in (route.arg_data_type, route.result_data_type, route.error_data_type):
                    data_type = get_underlying_type(data_type)
                    if is_user_defined_type(data_type):
                        update_by_reference(data_type, namespace)

        # Not iterate repeatedly, cascading the visibility out to other required data types as necessary
        prev_state = None
        cur_state = visibility.copy()
        while prev_state != cur_state:
            for namespace in api.namespaces.values():
                if namespace.doc is not None:
                    data_types = parse_data_types_from_doc_ref(api, namespace.doc, namespace.name,
                                                               ignore_missing_entries=True)
                    for d in data_types:
                        update_by_reference(d, namespace)
                for data_type in namespace.data_types:
                    if not visibility[data_type].is_visible:
                        continue

                    if data_type.doc is not None:
                        data_types = parse_data_types_from_doc_ref(api, data_type.doc, namespace.name,
                                                                   ignore_missing_entries=True)
                        for d in data_types:
                            update_by_reference(d, namespace)

                    for field in data_type.all_fields:
                        field_data_type = get_underlying_type(field.data_type)
                        if is_user_defined_type(field_data_type):
                            update_by_reference(field_data_type, namespace)

                        if field.doc is not None:
                            data_types = parse_data_types_from_doc_ref(api, field.doc, namespace.name,
                                                                       ignore_missing_entries=True)
                            for d in data_types:
                                update_by_reference(d, namespace)

                    # parents need access to their enumerated subtype serializers
                    if is_struct_type(data_type) and data_type.has_enumerated_subtypes():
                        for subtype in data_type.get_enumerated_subtypes():
                            update_by_reference(subtype.data_type, namespace)

            prev_state = cur_state
            cur_state = visibility.copy()

        return visibility

    @staticmethod
    def get_spec_filename(element):
        assert isinstance(element, StoneType), repr(element)
        assert hasattr(element, '_ast_node'), repr(element)
        return os.path.basename(element._ast_node.path)

    def get_spec_filenames(self, element):
        assert isinstance(element, StoneType), repr(element)
        filenames = OrderedDict() # ordered set
        if isinstance(element, ApiNamespace):
            for child in chain(element.data_types, element.routes):
                filenames[self.get_spec_filename(child)] = None
        else:
            filenames[self.get_spec_filename(element)] = None
        return filenames.keys()

    @staticmethod
    def requires_validation(data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        if is_list_type(data_type) or is_map_type(data_type):
            return True
        elif is_numeric_type(data_type):
            return any(r is not None for r in (
                data_type.min_value,
                data_type.max_value,
            ))
        elif is_string_type(data_type):
            return any(r is not None for r in (
                data_type.min_length,
                data_type.max_length,
                data_type.pattern,
            ))
        else:
            return False

    def is_collapsible(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        return is_struct_type(data_type) and not data_type.has_enumerated_subtypes()

    @staticmethod
    def param_name(stone_elem):
        assert isinstance(stone_elem, (ApiNamespace, Field)), repr(stone_elem)
        if isinstance(stone_elem, UnionField):
            return camelcase(stone_elem.name + '_value')
        else:
            return camelcase(stone_elem.name)

    def stone_fq_name(self, stone_elem, containing_data_type=None):
        assert isinstance(stone_elem, StoneType), repr(stone_elem)
        # When the containing data type of a field is a member of inheritance, field references
        # can be ambiguous. This is big problem with Unions since we copy all the parent fields
        # into the child union in Java. So the same field may appear multiple times, but in
        # different classes along the Stone chain of inheritance.
        assert isinstance(containing_data_type, DataType) or containing_data_type is None, repr(containing_data_type)

        if isinstance(stone_elem, ApiNamespace):
            parts = [stone_elem.name]
        elif isinstance(stone_elem, DataType):
            if is_user_defined_type(stone_elem):
                parts = [stone_elem.namespace.name, stone_elem.name]
            else:
                parts = [stone_elem.name]
        elif isinstance(stone_elem, ApiRoute):
            namespace = self.route_namespace(stone_elem)
            parts = [namespace.name, format_func_name(stone_elem)]
        elif isinstance(stone_elem, Field):
            containing_data_type = containing_data_type or self.field_containing_data_type(stone_elem)
            namespace = containing_data_type.namespace
            parts = [namespace.name, containing_data_type.name, stone_elem.name]
        else:
            raise ValueError("Unsupported Stone type: %s" % type(stone_elem))

        return '.'.join(p for p in parts)

    def namespace_getter_method(self, namespace):
        assert isinstance(namespace, ApiNamespace), repr(namespace)
        return camelcase(namespace.name)

    def field_getter_method(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_types[field]
        if is_struct_type(containing_data_type):
            return camelcase('get_' + field.name)
        elif is_union_type(containing_data_type) and self.has_value(field):
            return camelcase('get_' + field.name + '_value')
        else:
            return None

    def field_enum_name(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_types[field]
        if self.is_enum(containing_data_type):
            return allcaps(field.name)
        return None

    def field_tag_enum_name(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_types[field]
        if is_union_type(containing_data_type):
            return allcaps(field.name)
        return None

    def field_tag_match_method_name(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_types[field]
        assert is_union_type(containing_data_type), repr(field)
        return camelcase('is_' + field.name)

    def field_static_instance(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_types[field]
        if is_union_type(containing_data_type):
            if self.is_enum(containing_data_type):
                return self.field_enum_name(field)
            elif not self.has_value(field):
                return allcaps(field.name)
        return None

    def field_factory_method(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_types[field]
        if is_union_type(containing_data_type) and self.has_value(field):
            return camelcase(field.name)
        return None

    def field_builder_method(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_types[field]

        if field in containing_data_type.all_optional_fields:
            return camelcase('with_' + field.name)
        return None

    def is_java_primitive(self, data_type):
        return self.java_class(data_type, generics=False).name[0].islower()

    @staticmethod
    def is_enum(data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        if is_union_type(data_type):
            return all(is_void_type(f.data_type) for f in data_type.all_fields)
        else:
            return False

    @staticmethod
    def has_value(field):
        assert isinstance(field, Field), repr(field)
        return not is_void_type(field.data_type)

    def field_is_optional(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_type(field)
        return field in containing_data_type.all_optional_fields

    def field_is_required(self, field):
        assert isinstance(field, Field), repr(field)
        containing_data_type = self._containing_data_type(field)
        return field in containing_data_type.all_required_fields

    def url_path(self, route):
        """
        Server URL path associated with this route.
        """
        assert isinstance(route, ApiRoute), repr(route)
        return '2/%s/%s' % (self._namespaces_by_route[route].name, format_func_name(route))

    @staticmethod
    def has_arg(route):
        assert isinstance(route, ApiRoute), repr(route)
        return not is_void_type(route.arg_data_type)

    @staticmethod
    def has_result(route):
        assert isinstance(route, ApiRoute), repr(route)
        return not is_void_type(route.result_data_type)

    @staticmethod
    def has_error(route):
        assert isinstance(route, ApiRoute), repr(route)
        if is_void_type(route.error_data_type):
            return False
        else:
            # we only support user-defined error types
            assert is_user_defined_type(route.error_data_type), repr(route)
            return True

    @staticmethod
    def request_style(route):
        assert isinstance(route, ApiRoute), repr(route)
        return route.attrs.get('style', 'rpc')

    @staticmethod
    def auth_style(route):
        assert isinstance(route, ApiRoute), repr(route)
        return route.attrs.get('auth', 'user')

    @staticmethod
    def route_host(route):
        assert isinstance(route, ApiRoute), repr(route)
        return route.attrs.get('host', 'api')

    def has_builder(self, stone_elem):
        assert isinstance(stone_elem, (ApiRoute, DataType)), repr(stone_elem)
        if isinstance(stone_elem, DataType):
            data_type = stone_elem
            return is_struct_type(data_type) and len(data_type.all_optional_fields) > 1
        else:
            route = stone_elem
            return self.request_style(route) == 'download' or self.has_builder(route.arg_data_type)

    @staticmethod
    def route_method(route):
        assert isinstance(route, ApiRoute), repr(route)
        return camelcase(format_func_name(route))

    @staticmethod
    def route_builder_method(route):
        assert isinstance(route, ApiRoute), repr(route)
        return camelcase(format_func_name(route) + '_builder')

    @staticmethod
    def namespace_package(namespace, base_package):
        return base_package + '.' + namespace.name.replace('_', '').lower()

    def java_class(self, stone_elem, boxed=False, generics=True):
        assert isinstance(stone_elem, (ApiNamespace, ApiRoute, DataType, Field)), repr(stone_elem)

        base_package = self._args.package

        if isinstance(stone_elem, ApiNamespace):
            namespace = stone_elem
            package = self.namespace_package(namespace, base_package)
            prefix = self._args.requests_classname_prefix or self._args.client_class
            return JavaClass(package + '.' + classname('%s_%s_Requests' % (prefix, namespace.name)))
        elif isinstance(stone_elem, ApiRoute):
            route = stone_elem
            return self.java_class(self._namespaces_by_route[route])
        elif isinstance(stone_elem, Field):
            field = stone_elem
            return self.java_class(field.data_type, boxed=boxed, generics=generics)
        else:
            data_type = stone_elem

            if is_nullable_type(data_type):
                return self.java_class(data_type.data_type, boxed=True, generics=generics)
            elif is_user_defined_type(data_type):
                package = self.namespace_package(data_type.namespace, base_package)
                return JavaClass(package + '.' + classname(data_type.name))
            else:
                generic_classes = []
                if generics and is_list_type(data_type):
                    generic_classes = [self.java_class(data_type.data_type, boxed=True, generics=True)]
                elif generics and is_map_type(data_type):
                    generic_classes = [self.java_class(data_type.key_data_type, boxed=True), self.java_class(
                        data_type.value_data_type, boxed=True, generics=True)]

                type_map = _TYPE_MAP_BOXED if boxed else _TYPE_MAP_UNBOXED
                return JavaClass(type_map[data_type.name], generics=generic_classes)

    def builder_class(self, stone_elem):
        assert isinstance(stone_elem, (ApiRoute, DataType)), repr(stone_elem)
        assert self.has_builder(stone_elem), repr(stone_elem)

        if isinstance(stone_elem, ApiRoute):
            route = stone_elem

            if ',' in self.auth_style(route):
                # Use prefix here because multiple builders may be generated
                # if the endpoint has multiple auth types
                prefix = (self._args.requests_classname_prefix or self._args.client_class) + "_"
            else:
                prefix = ""
            package = self.java_class(route).package
            return JavaClass(package + '.' + classname('%s%s_builder' % (prefix, format_func_name(route))))
        else:
            data_type = stone_elem
            assert is_user_defined_type(data_type), repr(data_type)
            data_type_class = self.java_class(data_type)
            # nested static class
            return JavaClass(data_type_class.fq + '.Builder')

    def serializer_class(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)

        data_type_class = self.java_class(data_type)
        return JavaClass(data_type_class.fq + '.Serializer')

    def exception_class(self, element):
        assert isinstance(element, (DataType, ApiRoute)), repr(element)

        if isinstance(element, DataType):
            data_type = element
            assert self.data_type_has_exception(data_type), repr(data_type)
            return JavaClass(self.java_class(element).fq + 'Exception')
        else:
            route = element
            if self.has_error(route):
                return self.exception_class(route.error_data_type)
            else:
                return JavaClass('com.dropbox.core.DbxApiException')

    def route_exception_class(self, route):
        assert isinstance(route, ApiRoute), repr(route)

        if self.has_error(route):
            error = route.error_data_type
            error_class = self.java_class(error)
            return JavaClass(error_class.fq + 'Exception')
        else:
            return JavaClass('com.dropbox.core.DbxApiException')

    def route_throws_classes(self, route):
        assert isinstance(route, ApiRoute), repr(route)

        exc_classes = []
        if self.request_style(route) != 'upload':
            # upload routes don't receive the server response in the method call. The request is
            # issued later through the Uploader class
            route_specific_exc_class = self.route_exception_class(route)
            exc_classes.append(route_specific_exc_class)
        exc_classes.append(JavaClass('com.dropbox.core.DbxException'))
        return exc_classes

    def route_uploader_class(self, route):
        assert isinstance(route, ApiRoute), repr(route)
        return JavaClass(
            self.java_class(route).package + '.' + classname(format_func_name(route) + '_Uploader')
        )

    def route_downloader_class(self, route):
        assert isinstance(route, ApiRoute), repr(route)
        assert self.request_style(route) == 'download', repr(route)

        return JavaClass('com.dropbox.core.DbxDownloader', generics=(
            self.java_class(route.result_data_type, boxed=True),
        ))

    def is_used_by_client(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        return data_type in self._client_data_types

    def data_type_has_exception(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        assert is_user_defined_type(data_type), repr(data_type)
        return data_type in self._data_types_with_exception

    def field_containing_data_type(self, field):
        assert isinstance(field, Field), repr(field)
        assert field in self._containing_data_types, repr(field)
        return self._containing_data_types[field]

    def route_namespace(self, route):
        assert isinstance(route, ApiRoute), repr(route)
        assert route in self._namespaces_by_route, repr(route)
        return self._namespaces_by_route[route]

    def _lookup_data_type(self, fq_name):
        assert isinstance(fq_name, six.text_type), repr(fq_name)
        assert '.' in fq_name, repr(fq_name)
        namespace_name, data_type_name = split_stone_name(fq_name, max_parts=2)
        namespace = self.stone_api.namespaces.get(namespace_name)
        if namespace:
            for data_type in namespace.data_types:
                if data_type.name == data_type_name:
                    return data_type

    def data_type_visibility(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        return self._data_type_visibility[data_type]

    def update_data_type_visibility(self, data_type_fq_name, visibility):
        data_type = self._lookup_data_type(data_type_fq_name)
        if data_type:
            self._data_type_visibility[data_type] = max(
                self._data_type_visibility[data_type], visibility
            )

    def serializer_visibility(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        visibility = self._serializer_visibility[data_type]
        if not visibility.is_visible and self.data_type_visibility(data_type).is_visible:
            # if the containing data type is visible, force the serialize to be visible since
            # toString(..) depends on its serializer
            return Visibility.PRIVATE
        return visibility

    def update_serializer_visibility(self, data_type_fq_name, visibility):
        data_type = self._lookup_data_type(data_type_fq_name)
        if data_type:
            self._serializer_visibility[data_type] = max(
                self._serializer_visibility[data_type], visibility
            )

    def mark_data_type_as_used(self, data_type):
        self._client_data_types.add(data_type)


class JavaReferences(object):

    def __init__(self, j):
        self.j = j

        self.data_types = {}
        self.routes = {}
        self.fields = {}

        self._initialize()

    def load(self, f):
        data = json.load(f, object_hook=JavaReference.from_json)

        # resolve all name references
        for route in data['routes'].values():
            if route.error_ref:
                route.error_ref = data['data_types'][route.error_ref]
        for field in data['fields'].values():
            field.containing_data_type_ref = data['data_types'][field.containing_data_type_ref]
            field.route_refs = tuple(
                data['routes'][route_ref]
                for route_ref in field.route_refs
            )

        # now update our existing state
        self._update(data)

    def _update(self, data):

        # do data types first, since they are referenced by other types
        for key, data_type in data['data_types'].items():
            if key not in self.data_types:
                self.data_types[key] = data_type
            else:
                self.data_types[key].update_visibility(data_type.visibility)
                self.data_types[key].update_serializer_visibility(data_type.serializer_visibility)

        # routes reference their error types
        for key, route in data['routes'].items():
            if key not in self.routes:
                # update error_ref
                if route.error_ref:
                    route.error_ref = self.data_types[route.error_ref.fq_name]
                self.routes[key] = route

        # fields have data type and route refs
        for key, field in data['fields'].items():
            if key not in self.fields:
                # update refs
                field.containing_data_type_ref = self.data_types[field.containing_data_type_ref.fq_name]
                field.route_refs = tuple(
                    self.routes[route_ref.fq_name]
                    for route_ref in field.route_refs
                )
                self.fields[key] = field
            else:
                # update existing route refs
                merged_route_refs = list(self.fields[key].route_refs)
                for route_ref in field.route_refs:
                    route_ref = self.routes[route_ref.fq_name]
                    if route_ref not in merged_route_refs:
                        merged_route_refs.append(route_ref)
                self.fields[key].route_refs = tuple(merged_route_refs)

        # need to update our JavaApi with the new visibilities
        for key in data['data_types']:
            # get merged data type ref for our loaded data types
            data_type_ref = self.data_types[key]
            self.j.update_data_type_visibility(data_type_ref.fq_name, data_type_ref.visibility)
            self.j.update_serializer_visibility(data_type_ref.fq_name, data_type_ref.serializer_visibility)

    def serialize(self, f):
        return json.dump({
            'data_types': self.data_types,
            'routes': self.routes,
            'fields': self.fields,
        }, f, default=self._as_json)

    @staticmethod
    def _as_json(obj):
        if isinstance(obj, JavaReference):
            return obj._as_json()
        elif isinstance(obj, Visibility):
            return obj.name
        elif isinstance(obj, JavaClass):
            return str(obj)
        else:
            raise TypeError(repr(obj) + " is not JSON serializable")

    def data_type(self, data_type):
        j = self.j
        if isinstance(data_type, DataType):
            name = j.stone_fq_name(data_type)
        else:
            assert isinstance(data_type, six.text_type), repr(data_type)
            name = data_type
        assert '.' in name, "Must use fully-qualified stone name: %s" % name
        return self.data_types.get(name)

    def field(self, field, containing_data_type=None):
        j = self.j
        if isinstance(field, Field):
            name = j.stone_fq_name(field, containing_data_type)
        else:
            # we expect fully-qualified names for string field references
            assert containing_data_type is None, repr(field)
            assert isinstance(field, six.text_type), repr(field)
            name = field
        assert '.' in name, "Must use fully-qualified stone name: %s" % name
        return self.fields.get(name)

    def route(self, route):
        j = self.j
        if isinstance(route, ApiRoute):
            name = j.stone_fq_name(route)
        else:
            assert isinstance(route, six.text_type), repr(route)
            name = route
        assert '.' in name, "Must use fully-qualified stone name: %s" % name
        return self.routes.get(name)

    def _initialize(self):
        j = self.j

        # Data types
        for namespace in j.stone_api.namespaces.values():
            for data_type in namespace.data_types:
                self.data_types[j.stone_fq_name(data_type)] = DataTypeReference(j, data_type)

        # Routes
        route_refs_by_field = defaultdict(list)
        for namespace in j.stone_api.namespaces.values():
            for route in namespace.routes:
                error_ref = None
                if is_user_defined_type(route.error_data_type):
                    error_ref = self.data_types[j.stone_fq_name(route.error_data_type)]
                route_ref = RouteReference(j, route, error_ref)
                self.routes[j.stone_fq_name(route)] = route_ref

                # keep track of fields referenced by routes (required by Javadoc for overloaded methods)
                if route_ref.is_method_overloaded:
                    for field in route.arg_data_type.all_fields:
                        route_refs_by_field[field].append(route_ref)

        # Fields
        for namespace in j.stone_api.namespaces.values():
            for data_type in namespace.data_types:
                data_type_ref = self.data_types[j.stone_fq_name(data_type)]
                # Note that we may have duplicate references for the same field. This happens when
                # there is inheritance in the struct or union. We want to make sure that both
                # :field:`Child.field` and :field:`Parent.field` references work in Stone doc.
                for field in data_type.all_fields:
                    field_fq_name = j.stone_fq_name(field, data_type)
                    self.fields[field_fq_name] = FieldReference(
                        j, field, field_fq_name, data_type_ref, route_refs_by_field.get(field, ())
                    )


class JavaReference(object):
    def __init__(self, fq_name):
        assert isinstance(fq_name, six.text_type), repr(fq_name)
        self.fq_name = fq_name

    def __repr__(self):
        return '%s(%s)' % (type(self).__name__, self.__dict__)

    def __str__(self):
        return '%s(%s)' % (type(self).__name__, self.fq_name)

    def _as_json(self):
        dct = {}
        for k, v in self.__dict__.items():
            # avoid cyclic references issue
            if isinstance(v, JavaReference):
                dct[k] = v.fq_name
            elif isinstance(v, Sequence) and all(isinstance(e, JavaReference) for e in v):
                dct[k] = [
                    e.fq_name if isinstance(e, JavaReference) else e
                    for e in v
                ]
            elif isinstance(v, JavaClass):
                dct[k] = str(v)
            elif isinstance(v, Sequence) and all(isinstance(e, JavaClass) for e in v):
                dct[k] = [str(c) for c in v]
            else:
                dct[k] = v

        dct['_type'] = type(self).__name__
        return dct

    def _from_json(self, obj):
        obj.pop('_type')
        self.__dict__.update(obj)

    @classmethod
    def from_json(cls, obj):
        if '_type' in obj:
            ref_type = obj['_type']
            module = sys.modules[__name__]
            assert hasattr(module, ref_type), repr(ref_type)
            ref_cls = getattr(module, ref_type)
            assert issubclass(ref_cls, cls), repr(ref_cls)
            ref = cls.__new__(ref_cls)
            ref._from_json(obj)
            return ref
        return obj


class JavaClassReference(JavaReference):
    def __init__(self, name, java_class, visibility=Visibility.NONE):
        assert isinstance(java_class, JavaClass), repr(java_class)
        assert isinstance(visibility, Visibility), repr(visibility)
        super(JavaClassReference, self).__init__(name)
        self.java_class = java_class
        self.visibility = visibility

    def update_visibility(self, visibility):
        self.visibility = max(visibility, self.visibility)

    def _from_json(self, obj):
        self.java_class = JavaClass.from_str(obj.pop('java_class'))
        self.visibility = Visibility.from_name(obj.pop('visibility'))
        super(JavaClassReference, self)._from_json(obj)


class RouteReference(JavaClassReference):
    def __init__(self, j, route, error_ref):
        assert isinstance(route, ApiRoute), repr(route)
        super(RouteReference, self).__init__(
            j.stone_fq_name(route),
            j.java_class(route),
            Visibility.PUBLIC
        )

        self.namespace_name = j.route_namespace(route).name
        self.method = j.route_method(route)
        self.has_builder = j.has_builder(route)
        self.builder_method = j.route_builder_method(route) if self.has_builder else None
        self.error_ref = error_ref
        self.url_path = j.url_path(route)

        if is_struct_type(route.arg_data_type):
            self.is_method_overloaded = (
                any(route.arg_data_type.all_optional_fields) and not j.has_builder(route.arg_data_type)
            )
            if self.is_method_overloaded:
                fields = route.arg_data_type.all_fields
            else:
                fields = route.arg_data_type.all_required_fields
            self.method_arg_classes = tuple(j.java_class(field) for field in fields)
        else:
            self.method_arg_classes = ()
            self.is_method_overloaded = False

    def _from_json(self, obj):
        self.method_arg_classes = tuple(
            JavaClass.from_str(c) for c in obj.pop('method_arg_classes')
        )
        super(RouteReference, self)._from_json(obj)


class DataTypeReference(JavaClassReference):
    def __init__(self, j, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        super(DataTypeReference, self).__init__(
            j.stone_fq_name(data_type),
            j.java_class(data_type),
            visibility=j.data_type_visibility(data_type)
        )

        self.has_builder = j.has_builder(data_type)
        self.builder_class = j.builder_class(data_type) if self.has_builder else None
        self.serializer_visibility = j.serializer_visibility(data_type)

    def update_serializer_visibility(self, visibility):
        self.serializer_visibility = max(self.serializer_visibility, visibility)

    def _from_json(self, obj):
        self.builder_class = JavaClass.from_str(obj.pop('builder_class')) if obj['builder_class'] else None
        self.serializer_visibility = Visibility.from_name(obj.pop('serializer_visibility'))
        super(DataTypeReference, self)._from_json(obj)


class FieldReference(JavaReference):
    def __init__(self, j, field, fq_name, containing_data_type_ref, route_refs):
        assert isinstance(field, Field), repr(field)
        assert isinstance(containing_data_type_ref, DataTypeReference), repr(containing_data_type_ref)
        assert isinstance(route_refs, Sequence), repr(route_refs)
        assert all(isinstance(r, RouteReference) for r in route_refs), repr(route_refs)

        super(FieldReference, self).__init__(fq_name)

        self.param_name = j.param_name(field)
        self.static_instance = j.field_static_instance(field)
        self.getter_method = j.field_getter_method(field)

        self.containing_data_type_ref = containing_data_type_ref
        self.route_refs = route_refs


class JavaCodeGenerationInstance(object):
    """
    Java code generation instance for a particular Stone tree (:class:`stone.api.Api`).

    :ivar :class:`GeneratorContext` ctx: context for current generation
    """

    def __init__(self, g, api):
        self.api = api
        self.g = g
        self.j = JavaApi(api, self.g.args)
        # some classes are unused, but we still want them to be generated
        self._mark_special_unused_classes()
        self.refs = JavaReferences(self.j)
        # JavaClassWriter, created with self.class_writer(..)
        self.w = None

    @contextmanager
    def class_writer(self, stone_type_or_class, package_doc=None):
        assert isinstance(stone_type_or_class, (StoneType, JavaClass)), repr(stone_type_or_class)

        if isinstance(stone_type_or_class, JavaClass):
            java_class = stone_type_or_class
            stone_element = None
        else:
            java_class = self.j.java_class(stone_type_or_class)
            stone_element = stone_type_or_class

        with JavaClassWriter(self.g, self.j, self.refs, java_class, stone_element=stone_element, package_doc=package_doc) as w:
            assert self.w is None, self.w
            self.w = w
            yield w
            self.w = None

    def generate_all(self):
        self.update_javadoc_refs()

        self.generate_client()

        for namespace in self.api.namespaces.values():
            self.generate_namespace(namespace)

    def generate_data_types(self):
        for namespace in self.api.namespaces.values():
            for data_type in namespace.data_types:
                self.generate_data_type(data_type)

    def update_javadoc_refs(self):
        javadoc_refs_path = self.g.args.javadoc_refs

        if javadoc_refs_path is None:
            return

        # load existing file and merge it with our current state
        if os.path.exists(javadoc_refs_path):
            with open(javadoc_refs_path, 'r') as f:
                self.refs.load(f)

        # save our updated state back to the file
        with open(javadoc_refs_path, 'w') as f:
            self.refs.serialize(f)

    def generate_client(self):
        j = self.j

        namespaces = [
            ns for ns in self.api.namespaces.values()
            if ns.routes
        ]

        client_class = JavaClass(self.g.args.package + '.' + self.g.args.client_class)
        with self.class_writer(client_class) as w:
            w.importer.add_imports(*[
                j.java_class(namespace) for namespace in namespaces
            ])
            w.importer.add_imports('com.dropbox.core.v2.DbxRawClientV2')

            w.write_imports()

            w.out('')
            w.javadoc(self.g.args.client_javadoc or "")
            with w.class_block(client_class):
                w.out('protected final DbxRawClientV2 _client;')
                w.out('')
                for namespace in namespaces:
                    w.out('private final %s %s;', j.java_class(namespace), j.param_name(namespace))

                w.out('')
                w.javadoc(
                    """
                    For internal use only.
                    """,
                    params=(('_client', 'Raw v2 client to use for issuing requests'),)
                )
                with w.block('protected %s(DbxRawClientV2 _client)', client_class.name):
                    w.out('this._client = _client;')
                    for namespace in namespaces:
                        w.out('this.%s = new %s(_client);', j.param_name(namespace), j.java_class(namespace))

                for namespace in namespaces:
                    w.out('')
                    w.javadoc(
                        """
                        Returns client for issuing requests in the {@code "%s"} namespace.
                        """ % namespace.name,
                        returns="Dropbox %s client" % namespace.name
                    )
                    with w.block("public %s %s()", j.java_class(namespace), j.namespace_getter_method(namespace)):
                        w.out('return %s;' % j.param_name(namespace))

    def generate_namespace(self, namespace):
        assert isinstance(namespace, ApiNamespace), repr(namespace)

        j = self.j

        # add documentation to our packages
        self.generate_package_javadoc(namespace)

        # create class files for all namespace data types in this package
        for data_type in namespace.data_types:
            self.generate_data_type(data_type)

        for route in namespace.routes:
            # generate per-route uploader helpers
            if j.request_style(route) == 'upload':
                self.generate_route_uploader(route)

            # generate all necessary builder classes for routes that support it
            if j.has_builder(route):
                self.generate_route_builder(route)

        if namespace.routes:
            self.generate_namespace_routes(namespace)

    def _mark_special_unused_classes(self):
        j = self.j

        if not self.g.args.unused_classes_to_generate:
            return

        special_class_names = self.g.args.unused_classes_to_generate.split(', ')

        if not special_class_names:
            return

        special_data_types = [
            unwrap_nullable(data_type)[0]
            for namespace in j.stone_api.namespaces.values()
            for data_type in namespace.data_types
            if data_type.name in special_class_names
        ]

        all_special_data_types = set()

        # mark all special types public and used, and likewise mark all of their
        # referenced types as public and used

        def _propagate_changes(data_type):
            all_special_data_types.add(data_type)

            if is_void_type(data_type) or not is_user_defined_type(data_type):
                return

            field_types = [unwrap_nullable(f.data_type)[0] for f in data_type.all_fields]
            for field_type in field_types:
                if field_type not in all_special_data_types:
                    _propagate_changes(field_type)
            if data_type.parent_type:
                if data_type.parent_type not in all_special_data_types:
                    _propagate_changes(data_type.parent_type)

        for data_type in special_data_types:
            _propagate_changes(data_type)

        for data_type in all_special_data_types:
            if is_user_defined_type(data_type) and not is_void_type(data_type):
                data_type_fq_name = j.stone_fq_name(data_type)

                # mark public
                j.update_data_type_visibility(data_type_fq_name, Visibility.PUBLIC)
                j.update_serializer_visibility(data_type_fq_name, Visibility.PUBLIC)
                # mark as being referenced somewhere so that we generate
                j.mark_data_type_as_used(data_type)

    def generate_namespace_routes(self, namespace):
        assert isinstance(namespace, ApiNamespace), repr(namespace)

        j = self.j

        with self.class_writer(namespace) as w:
            w.importer.add_imports_for_namespace(namespace)
            w.write_imports()

            w.out('')
            w.javadoc('Routes in namespace "%s".' % namespace.name)
            with w.class_block(namespace):
                w.out('// namespace %s (%s)', namespace.name, ', '.join(j.get_spec_filenames(namespace)))
                w.out('')
                w.out('private final DbxRawClientV2 client;')

                w.out('')
                with w.block('public %s(DbxRawClientV2 client)', j.java_class(namespace)):
                    w.out('this.client = client;')

                for route in namespace.routes:
                    w.out('')
                    w.out('//')
                    w.out('// route %s', j.url_path(route))
                    w.out('//')
                    self.generate_route_base(route)
                    if j.has_arg(route):
                        self.generate_route(route, required_only=True)
                    # we don't use builders if we have too few optional fields. Instead we just
                    # create another method call. We have an exception for download endpoints, which
                    # recently added builders for previous routes that had no builders
                    has_optional_fields = is_struct_type(route.arg_data_type) and route.arg_data_type.all_optional_fields
                    if has_optional_fields and not j.has_builder(route.arg_data_type):
                        self.generate_route(route, required_only=False)

                    # route can have builder if arg does or if route has a particular request
                    # style. So check route for builder instead of arg here:
                    if j.has_builder(route):
                        self.generate_route_builder_method(route)

    def generate_package_javadoc(self, namespace):
        assert isinstance(namespace, ApiNamespace), repr(namespace)

        w = self.w
        j = self.j

        requests_reference_doc = ''
        # different routes may have different namespace classes based on the client configuration we
        # used. Go through all the routes references in a namespace to figure out all the requests
        # classes we have available.
        request_classes = OrderedDict()
        for route_ref in self.refs.routes.values():
            if route_ref.namespace_name == namespace.name:
                request_classes[route_ref.java_class] = None

        if request_classes:
            requests_reference_doc += 'See %s for a list of possible requests for this namespace.' % (
                ', '.join("{@link %s}" % c for c in request_classes)
            )

        package_doc = (
            """
            %s

            %s
            """ % (namespace.doc or '', requests_reference_doc)
        )

        package_info_class = JavaClass(j.java_class(namespace).package + '.' + 'package-info')
        with self.class_writer(package_info_class, package_doc=package_doc):
            pass

    def generate_route_base(self, route, force_public=False):
        assert isinstance(route, ApiRoute), repr(route)

        w = self.w
        j = self.j

        is_download = j.request_style(route) == 'download'
        is_public = force_public or (
            not (is_struct_type(route.arg_data_type) or is_download)
        )

        if j.request_style(route) == 'upload':
            returns = "Uploader used to upload the request body and finish request."
            return_class = j.route_uploader_class(route)
        elif j.request_style(route) == 'download':
            returns = "Downloader used to download the response body and view the server response."
            return_class = j.route_downloader_class(route)
        elif j.has_result(route):
            returns = route.result_data_type
            return_class = j.java_class(route.result_data_type)
        else:
            returns = None
            return_class = JavaClass('void')

        if is_public:
            deprecated = None # automatically determine from route
            visibility = 'public'
        else:
            deprecated = False # Don't mark private methods deprecated since we don't care
            visibility = ''    # package private

        throws_classes = j.route_throws_classes(route)
        throws = ', '.join(w.resolved_class(c) for c in throws_classes)

        args = []
        params = []
        if j.has_arg(route):
            arg_class = j.java_class(route.arg_data_type)
            args.append(w.fmt('%s arg', arg_class))
            params.append(('arg', route.arg_data_type.doc))

        if is_download:
            if is_public:
                headers_var = w.fmt('%s.<%s>emptyList()',
                                    JavaClass('java.util.Collections'),
                                    JavaClass('com.dropbox.core.http.HttpRequestor.Header'))
            else:
                headers_var = '_headers'
                headers_class = JavaClass.from_str('java.util.List<com.dropbox.core.http.HttpRequestor.Header>')
                args.append(w.fmt('%s %s', headers_class, headers_var))
                params.append((headers_var, 'Extra headers to send with request.'))

        w.out('')
        w.javadoc(route, returns=returns, deprecated=deprecated, params=params)
        with w.block('%s %s %s(%s) throws %s',
                     visibility,
                     return_class,
                     j.route_method(route),
                     ', '.join(args),
                     throws):
            if j.request_style(route) == 'rpc':
                self.generate_route_rpc_call(route, 'arg')
            elif j.request_style(route) == 'upload':
                self.generate_route_upload_call(route, 'arg')
            elif j.request_style(route) == 'download':
                self.generate_route_download_call(route, 'arg', headers_var)
            else:
                assert False, "unrecognized route request style: %s" % j.request_style(route)

    def generate_route(self, route, required_only=True):
        assert isinstance(route, ApiRoute), repr(route)

        w = self.w
        j = self.j

        assert j.has_arg(route), repr(route)

        # routes with union or builtin args (e.g. UInt32, List) are always made public and should
        # already be generated by generate_route_base(..).
        if not is_struct_type(route.arg_data_type):
            # One exception is if the route is a download style endpoint. We may have extra headers
            # we need to pass up for download endpoints, so those routes are made private. So just
            # generate the base route again, but force it to generate the public version without the
            # extra headers argument:
            if j.request_style(route) == 'download':
                self.generate_route_base(route, force_public=True)
            return

        # should only be left with struct args
        assert is_struct_type(route.arg_data_type), repr(route.arg_data_type)

        arg = route.arg_data_type
        result = route.result_data_type
        error = route.error_data_type

        if not required_only:
            assert not j.has_builder(arg), "Arg %s has builder, so unpacked method unnecessary." % repr(route)
            n_optional = len(arg.all_optional_fields)
            # we disable boxing for this method, which can be dangerous if we have more than one
            # optional argument. It will essentially prevent users from being able to use
            # default values for part of their request arguments. Consider updating code if
            # you want to support this.
            assert n_optional == 1, "More than one optional field should permit boxing! %s" % repr(route)


        if j.request_style(route) == 'upload':
            returns = "Uploader used to upload the request body and finish request."
            return_class = j.route_uploader_class(route)
        elif j.request_style(route) == 'download':
            returns = "Downloader used to download the response body and view the server response."
            return_class = j.route_downloader_class(route)
        elif j.has_result(route):
            returns = result
            return_class = j.java_class(route.result_data_type)
        else:
            returns=None
            return_class = JavaClass('void')

        if required_only:
            fields = arg.all_required_fields
        else:
            fields = arg.all_fields
        args = ', '.join(
            w.fmt('%s %s', j.java_class(f), j.param_name(f)) for f in fields
        )

        default_fields = tuple(f for f in arg.all_optional_fields if f.has_default)
        doc = route.raw_doc or ''
        if required_only and default_fields:
            if j.has_builder(route):
                doc += """

                The default values for the optional request parameters will be used. See %s
                for more details.""" % w.javadoc_ref(j.builder_class(route))
            else:
                assert len(default_fields) == 1, default_fields
                default_field = default_fields[0]
                doc += """

                The {@code %s} request parameter will default to {@code %s} (see {@link #%s(%s)}).""" % (
                    j.param_name(default_field),
                    w.java_default_value(default_field),
                    j.route_method(route),
                    ','.join(w.resolved_class(j.java_class(f, generics=False)) for f in arg.all_fields),
                )
        throws_classes = j.route_throws_classes(route)
        throws = ', '.join(w.resolved_class(c) for c in throws_classes)

        w.out('')
        w.javadoc(doc, stone_elem=route, fields=fields, returns=returns, allow_defaults=False)
        with w.block('public %s %s(%s) throws %s', return_class, j.route_method(route), args, throws):
            arg_class = j.java_class(arg)
            required_args = ', '.join(j.param_name(f) for f in arg.all_required_fields)
            if required_only:
                w.out('%s _arg = new %s(%s);', arg_class, arg_class, required_args)
            else:
                optional_fields = arg.all_optional_fields
                for field in optional_fields:
                    # disable translation of nulls to default
                    self.generate_field_validation(field, allow_default=False)

                if j.has_builder(arg):
                    # use builder to build with optional fields
                    w.out('%s _arg = %s.newBuilder(%s)', arg_class, required_args)
                    with self.g.indent():
                        for field in optional_fields:
                            w.out('.%s(%s)', j.field_builder_method(field), j.param_name(field))
                        w.out('.build();')
                else:
                    # use full constructor
                    all_args = ', '.join(j.param_name(f) for f in arg.all_fields)
                    w.out('%s _arg = new %s(%s);', arg_class, arg_class, all_args)

            if j.has_result(route) or j.request_style(route) in ('upload', 'download'):
                args = ['_arg']
                if j.request_style(route) == 'download':
                    # extra request headers
                    args.append(w.fmt('%s.<%s>emptyList()',
                                      JavaClass('java.util.Collections'),
                                      JavaClass('com.dropbox.core.http.HttpRequestor.Header')))
                w.out('return %s(%s);', j.route_method(route), ', '.join(args))
            else:
                w.out('%s(_arg);', j.route_method(route))

    def generate_route_builder_method(self, route):
        assert isinstance(route, ApiRoute), repr(route)

        w = self.w
        j = self.j

        assert j.has_builder(route), repr(route)

        arg = route.arg_data_type
        result = route.result_data_type
        return_class = j.builder_class(route)

        if j.request_style(route) == 'upload':
            returns="Uploader builder for configuring request parameters and instantiating an uploader."
        elif j.request_style(route) == 'download':
            returns="Downloader builder for configuring the request parameters and instantiating a downloader."
        else:
            returns="Request builder for configuring request parameters and completing the request."

        required_fields = arg.all_required_fields
        args = ', '.join(
            w.fmt('%s %s', j.java_class(f), j.param_name(f))
            for f in required_fields
        )

        w.out('')
        w.javadoc(route, fields=required_fields, returns=returns)
        with w.block('public %s %s(%s)', j.builder_class(route), j.route_builder_method(route), args):
            builder_args = ', '.join(j.param_name(f) for f in required_fields)
            if j.has_builder(arg):
                w.out('%s argBuilder_ = %s.newBuilder(%s);',
                      j.builder_class(arg),
                      j.java_class(arg),
                      builder_args,
                )
                w.out('return new %s(this, argBuilder_);', return_class)
            else:
                w.out('return new %s(this, %s);', return_class, builder_args)

    def translate_error_wrapper(self, route, error_wrapper_var):
        assert isinstance(route, ApiRoute), repr(route)
        assert isinstance(error_wrapper_var, six.text_type), repr(error_wrapper_var)

        w = self.w
        j = self.j

        if j.has_error(route):
            return w.fmt('new %s("%s", %s.getRequestId(), %s.getUserMessage(), (%s) %s.getErrorValue());',
                         j.route_exception_class(route),
                         j.url_path(route),
                         error_wrapper_var,
                         error_wrapper_var,
                         j.java_class(route.error_data_type),
                         error_wrapper_var)
        else:
            message = '"Unexpected error response for \\"%s\\":" + %s.getErrorValue()' % (
                format_func_name(route),
                error_wrapper_var,
            )
            return 'new DbxApiException(%s.getRequestId(), %s.getUserMessage(), %s);' % (
                error_wrapper_var,
                error_wrapper_var,
                message)

    def generate_route_simple_call(self, route, arg_var, before, *other_args):
        assert isinstance(route, ApiRoute), repr(route)

        w = self.w
        j = self.j

        with w.block('try'):
            multiline_args = [
                'this.client.getHost().%s()' % camelcase('get_' + j.route_host(route)),
                '"%s"' % j.url_path(route),
                arg_var if j.has_arg(route) else 'null',
                'true' if j.auth_style(route) == 'noauth' else 'false',
            ]
            multiline_args.extend(other_args)
            multiline_args.extend([
                w.java_serializer(route.arg_data_type),
                w.java_serializer(route.result_data_type),
                w.java_serializer(route.error_data_type),
            ])

            self.g.generate_multiline_list(
                multiline_args,
                before=before,
                after=';',
            )
        with self.g.block('catch (DbxWrappedException ex)'):
            w.out('throw %s' % self.translate_error_wrapper(route, 'ex'))

    def generate_route_rpc_call(self, route, arg_var):
        assert isinstance(route, ApiRoute), repr(route)

        j = self.j

        # return value is optional
        before = ('return ' if j.has_result(route) else '') + 'this.client.rpcStyle'
        self.generate_route_simple_call(
            route,
            arg_var,
            before,
        )

    def generate_route_download_call(self, route, arg_var, headers_var):
        assert isinstance(route, ApiRoute), repr(route)

        # always need to return a downloader
        before = 'return this.client.downloadStyle'
        self.generate_route_simple_call(
            route,
            arg_var,
            before,
            headers_var,
        )

    def generate_route_upload_call(self, route, arg_var):
        assert isinstance(route, ApiRoute), repr(route)

        w = self.w
        j = self.j

        self.g.generate_multiline_list(
            (
                'this.client.getHost().%s()' % camelcase('get_' + j.route_host(route)),
                '"%s"' % j.url_path(route),
                arg_var if j.has_arg(route) else 'null',
                'true' if j.auth_style(route) == 'noauth' else 'false',
                w.java_serializer(route.arg_data_type),
            ),
            before=w.fmt('%s _uploader = this.client.uploadStyle',
                         JavaClass('com.dropbox.core.http.HttpRequestor.Uploader')),
            after=';',
        )
        w.out('return new %s(_uploader, this.client.getUserId());', j.route_uploader_class(route))

    def generate_data_type(self, data_type):
        """Generate a class definition for a datatype (a struct or a union)."""
        assert is_user_defined_type(data_type), repr(data_type)

        j = self.j

        if not self.g.args.data_types_only and not j.is_used_by_client(data_type):
            return

        with self.class_writer(data_type) as w:
            w.importer.add_imports_for_data_type(data_type)
            w.write_imports()

            if j.is_enum(data_type):
                self.generate_data_type_enum(data_type)
            elif is_union_type(data_type):
                self.generate_data_type_union(data_type)
            elif is_struct_type(data_type):
                self.generate_data_type_struct(data_type)
            else:
                raise AssertionError(repr(data_type))

        # generate exception classes for routes if the data type is used as an error response
        if j.data_type_has_exception(data_type):
            self.generate_exception_type(data_type)

    def generate_data_type_enum(self, data_type):
        assert is_union_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        assert j.is_enum(data_type), repr(data_type)

        visibility = j.data_type_visibility(data_type)

        w.out('')
        w.javadoc(data_type)
        with w.class_block(data_type, visibility=visibility):
            w.out('// union %s (%s)', j.stone_fq_name(data_type), j.get_spec_filename(data_type))
            self.generate_enum_values(data_type)

            #
            # Serialization
            #
            self.generate_union_serializer(data_type)

    def generate_enum_values(self, data_type):
        """Generate enum values for simple unions or tags."""
        assert is_union_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        last_index = len(data_type.all_fields) - 1
        for i, field in enumerate(data_type.all_fields):
            w.javadoc(field)
            comment = ''
            if field == data_type.catch_all_field:
                assert is_void_type(field.data_type), repr(field)
                comment = ' // *catch_all'
            elif j.has_value(field):
                comment = w.fmt(' // %s', j.java_class(field))

            sep = ';' if i == last_index else ','
            enum_value = j.field_enum_name(field) or j.field_tag_enum_name(field)
            assert enum_value, repr(field)
            w.out(enum_value + sep + comment)

    def generate_data_type_union(self, data_type):
        assert is_union_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        class_doc = """%s

            This class is %s union.  Tagged unions instances are always associated to a
            specific tag.  This means only one of the {@code isAbc()} methods will return {@code
            true}. You can use {@link #tag()} to determine the tag associated with this instance.
            """ % (data_type.doc or '', 'an open tagged' if data_type.catch_all_field else 'a tagged')
        if data_type.catch_all_field:
                class_doc += """

                Open unions may be extended in the future with additional tags. If a new tag is
                introduced that this SDK does not recognized, the {@link #%s} value will be used.
                """ % j.field_static_instance(data_type.catch_all_field)


        visibility = j.data_type_visibility(data_type)

        w.out('')
        w.javadoc(class_doc, stone_elem=data_type)
        with w.class_block(data_type, visibility=visibility):
            w.out('// union %s (%s)', j.stone_fq_name(data_type), j.get_spec_filename(data_type))

            #
            # Tag
            #
            w.out('')
            w.javadoc('Discriminating tag type for {@link %s}.' % j.java_class(data_type).name)
            with w.block('public enum Tag'):
                self.generate_enum_values(data_type)

            #
            # Simple field singletons
            #
            all_fields = data_type.all_fields
            static_fields = [f for f in all_fields if is_void_type(f.data_type)]
            value_fields = [f for f in all_fields if not is_void_type(f.data_type)]

            if static_fields:
                w.out('')
            for field in static_fields:
                singleton_args = ', '.join(["Tag.%s" % j.field_tag_enum_name(field)])
                w.javadoc(field)
                method_name = union_create_with_method_name(data_type, [])
                w.out('public static final %s %s = new %s().%s(%s);',
                      j.java_class(data_type),
                      j.field_static_instance(field),
                      j.java_class(data_type),
                      method_name,
                      singleton_args,
                )

            #
            # Instance fields
            #
            w.out('')
            w.out('private Tag _tag;')
            for field in all_fields:
                if j.has_value(field):
                    w.out('private %s %s;', j.java_class(field, boxed=True), j.param_name(field))

            #
            # Constructors
            #

            w.out('')
            w.javadoc('Private default constructor, so that object is uninitializable publicly.')
            with w.block('private %s()', j.java_class(data_type)):
                pass
            w.out('')

            def _gen_create_with_method(data_type, value_fields_subset):
                w.out('')
                w.javadoc(data_type,
                          fields=value_fields_subset,
                          params=OrderedDict(_tag="Discriminating tag for this instance."))
                formatted_args = ', '.join(chain(
                    ['Tag _tag'],
                    [
                        w.fmt('%s %s', j.java_class(f, boxed=True), j.param_name(f))
                        for f in value_fields_subset
                    ],
                ))
                method_name = union_create_with_method_name(data_type, value_fields_subset)
                with w.block('private %s %s(%s)', j.java_class(data_type), method_name, formatted_args):
                    w.out('%s result = new %s();', j.java_class(data_type), j.java_class(data_type))
                    w.out('result._tag = _tag;')
                    for field in value_fields_subset:
                        # don't perform validation in the private constructor
                        w.out('result.%s = %s;', j.param_name(field), j.param_name(field))
                    w.out('return result;')

            _gen_create_with_method(data_type, [])
            for f in value_fields:
                _gen_create_with_method(data_type, [f])

            #
            # Field getters/constructors
            #
            w.out('')
            if data_type.catch_all_field:
                catch_all_doc = (
                    """
                    If a tag returned by the server is unrecognized by this SDK,
                    the {@link Tag#%s} value will be used.
                    """ % j.field_tag_enum_name(data_type.catch_all_field)
                )
            else:
                catch_all_doc = ""
            w.javadoc(
                """
                Returns the tag for this instance.

                This class is a tagged union.  Tagged unions instances are always associated to a
                specific tag.  This means only one of the {@code isXyz()} methods will return {@code
                true}. Callers are recommended to use the tag value in a {@code switch} statement to
                properly handle the different values for this {@code %s}.

                %s""" % (j.java_class(data_type).name, catch_all_doc),
                stone_elem=data_type,
                returns="the tag for this instance."
            )
            with w.block('public Tag tag()'):
                w.out('return _tag;')
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
        assert is_union_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        value_fields = [f for f in data_type.all_fields if not is_void_type(f.data_type)]

        for field in data_type.all_fields:
            #
            # isFieldName()
            #
            w.out('')
            w.javadoc(
                """
                Returns {@code true} if this instance has the tag {@link Tag#%s}, {@code false}
                otherwise.
                """ % j.field_tag_enum_name(field),
                returns=(
                    """
                    {@code true} if this instance is tagged as {@link Tag#%s},
                    {@code false} otherwise.
                    """
                ) % j.field_tag_enum_name(field)
            )
            with w.block('public boolean %s()' % j.field_tag_match_method_name(field)):
                w.out('return this._tag == Tag.%s;', j.field_tag_enum_name(field))

            if j.has_value(field):
                #
                # Union fieldName() [factory method]
                #
                w.out('')
                doc = (
                    """
                    Returns an instance of {@code %s} that has its tag set to {@link Tag#%s}.

                    %s
                    """ % (j.java_class(data_type).name, j.field_tag_enum_name(field), field.doc)
                )
                returns = "Instance of {@code %s} with its tag set to {@link Tag#%s}." % (
                    j.java_class(data_type).name, j.field_tag_enum_name(field))
                w.javadoc(
                    doc,
                    stone_elem=field,
                    params=OrderedDict(value="value to assign to this instance.") if j.has_value(field) else (),
                    returns=returns,
                    throws=w.throws(field, "value"),
                )
                if j.has_value(field):
                    with w.block('public static %s %s(%s value)',
                                 j.java_class(data_type),
                                 j.field_factory_method(field),
                                 j.java_class(field),
                    ):
                        self.generate_field_validation(field, value_name="value", omit_arg_name=True, allow_default=False)
                        method_name = union_create_with_method_name(data_type, [field])
                        w.out('return new %s().%s(Tag.%s, %s);',
                              j.java_class(data_type),
                              method_name,
                              j.field_tag_enum_name(field),
                              "value")

                    if is_nullable_type(field.data_type):
                        w.out('')
                        w.javadoc(doc, stone_elem=field, returns=returns)
                        with w.block('public static %s %s()', j.java_class(data_type), j.field_factory_method(field)):
                            w.out('return %s(null);', j.field_factory_method(field))

                #
                # getFieldNameValue()
                #
                w.out('')
                w.javadoc(
                    """
                    %s

                    This instance must be tagged as {@link Tag#%s}.
                    """ % (field.doc or '', j.field_tag_enum_name(field)),
                    stone_elem=field,
                    returns="""
                    The %s value associated with this instance if {@link #%s} is
                    {@code true}.
                    """ % (w.javadoc_ref(field.data_type), j.field_tag_match_method_name(field)),
                    throws=OrderedDict(
                        IllegalStateException="If {@link #%s} is {@code false}." % j.field_tag_match_method_name(field),
                    )
                )
                with w.block('public %s %s()', j.java_class(field), j.field_getter_method(field)):
                    with w.block('if (this._tag != Tag.%s)', j.field_tag_enum_name(field)):
                        w.out('throw new IllegalStateException("Invalid tag: required Tag.%s, but was Tag." + this._tag.name());', j.field_tag_enum_name(field))
                    w.out('return %s;', j.param_name(field))


    def generate_data_type_struct(self, data_type):
        assert is_struct_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        visibility = j.data_type_visibility(data_type)

        w.out('')
        w.javadoc(data_type)
        with w.class_block(data_type, visibility=visibility):
            w.out('// struct %s (%s)', j.stone_fq_name(data_type), j.get_spec_filename(data_type))

            #
            # instance fields
            #
            w.out('')
            for field in data_type.fields:
                # fields marked as protected since structs allow inheritance
                w.out('protected final %s %s;', j.java_class(field), j.param_name(field))

            #
            # constructor.
            #

            # use builder or required-only constructor for default values
            args = ', '.join(
                w.fmt('%s %s', j.java_class(f), j.param_name(f))
                for f in data_type.all_fields
            )
            doc = data_type.doc or ''
            if j.has_builder(data_type):
                doc += """

                Use {@link newBuilder} to create instances of this class without specifying values for all optional fields.
                """
            w.out('')
            w.javadoc(doc, stone_elem=data_type, fields=data_type.all_fields, allow_defaults=False)
            with w.block('public %s(%s)', j.java_class(data_type), args):
                parent_fields = data_type.parent_type.all_fields if data_type.parent_type else ()

                if parent_fields:
                    parent_args = ', '.join(j.param_name(f) for f in parent_fields)
                    w.out('super(%s);', parent_args)

                for field in data_type.fields:
                    self.generate_field_validation(field, allow_default=False)
                    self.generate_field_assignment(field, allow_default=False)

            # required-only constructor
            if data_type.all_optional_fields:
                # create a constructor with just required fields (for convenience)
                required_fields = data_type.all_required_fields
                required_args = ', '.join(
                    w.fmt('%s %s', j.java_class(f), j.param_name(f))
                    for f in required_fields
                )
                w.out('')
                w.javadoc(
                    """
                    %s

                    The default values for unset fields will be used.
                    """ % data_type.doc or '',
                    stone_elem=data_type,
                    fields=required_fields,
                )
                with w.block('public %s(%s)', j.java_class(data_type), required_args):
                    this_args = []
                    for field in data_type.all_fields:
                        if is_nullable_type(field.data_type):
                            this_args.append('null')
                        elif field.has_default:
                            this_args.append(w.java_default_value(field))
                        else:
                            this_args.append(j.param_name(field))
                    w.out('this(%s);', ', '.join(this_args))

            #
            # getter methods
            #
            for field in data_type.all_fields:
                w.out('')
                if field in data_type.all_optional_fields:
                    returns = 'value for this field, or {@code null} if not present.'
                elif j.is_java_primitive(field.data_type):
                    returns = 'value for this field.'
                else:
                    returns = 'value for this field, never {@code null}.'

                if field.has_default:
                    returns += ' Defaults to %s.' % w.java_default_value(field)

                w.javadoc(field.doc or '', stone_elem=field, returns=returns)
                with w.block('public %s %s()', j.java_class(field), j.field_getter_method(field)):
                    w.out('return %s;' % j.param_name(field))


            #
            # builder
            #
            if j.has_builder(data_type):
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
        assert is_struct_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        assert j.has_builder(data_type), repr(data_type)

        parent_has_builder = data_type.parent_type and j.has_builder(data_type.parent_type)
        all_required_fields = data_type.all_required_fields
        fields = data_type.fields if parent_has_builder else data_type.all_fields
        required_fields = [f for f in fields if f in all_required_fields]
        optional_fields = [f for f in fields if f not in all_required_fields]
        ancestors = get_ancestors(data_type)

        all_required_args = ', '.join(
            w.fmt('%s %s', j.java_class(f), j.param_name(f)) for f in all_required_fields
        )
        required_args = ', '.join(
            w.fmt('%s %s', j.java_class(f), j.param_name(f)) for f in required_fields
        )

        w.out('')
        w.javadoc(
            'Returns a new builder for creating an instance of this class.',
            stone_elem=data_type,
            fields=all_required_fields,
            returns='builder for this class.',
        )
        with w.block('public static %s newBuilder(%s)', j.builder_class(data_type), all_required_args):
            builder_args = ', '.join(j.param_name(f) for f in all_required_fields)
            w.out('return new %s(%s);', j.builder_class(data_type), builder_args)

        parent_class = None
        if data_type.parent_type and j.has_builder(data_type.parent_type):
            parent_class = j.builder_class(data_type.parent_type)

        w.out('')
        w.javadoc('Builder for %s.' % w.javadoc_ref(data_type))
        with w.class_block(j.builder_class(data_type), parent_class=parent_class):
            #
            # Instance fields
            #

            for field in required_fields:
                w.out('protected final %s %s;', j.java_class(field), j.param_name(field))

            if optional_fields:
                w.out('')
            for field in optional_fields:
                w.out('protected %s %s;', j.java_class(field), j.param_name(field))

            #
            # Constructor
            #
            w.out('')
            with w.block('protected %s(%s)', j.builder_class(data_type), all_required_args):
                if parent_has_builder:
                    parent_required_fields = [
                        f for f in data_type.parent_type.all_fields if f in all_required_fields
                    ]
                    if parent_required_fields:
                        parent_args = ', '.join(j.param_name(f) for f in parent_required_fields)
                        w.out('super(%s);', parent_args)

                for field in required_fields:
                    self.generate_field_validation(field)
                    self.generate_field_assignment(field)

                for field in optional_fields:
                    if is_nullable_type(field.data_type):
                        w.out('this.%s = null;', j.param_name(field))
                    else:
                        assert field.has_default, repr(field)
                        w.out('this.%s = %s;', j.param_name(field), w.java_default_value(field))

            #
            # Setter/Adder methods
            #
            self.generate_builder_methods(j.builder_class(data_type), fields)
            # delegate to parent builder, but make sure we return ourselves for proper chaining
            if parent_has_builder:
                self.generate_builder_methods(j.builder_class(data_type),
                                              data_type.parent_type.all_fields,
                                              wrapped_builder_name="super")

            #
            # Build method
            #
            w.out('')
            w.javadoc(
                """
                Builds an instance of %s configured with this builder's values
                """ % w.javadoc_ref(data_type),
                returns='new instance of %s' % w.javadoc_ref(data_type)
            )
            with w.block('public %s build()', j.java_class(data_type)):
                build_args = ', '.join(j.param_name(f) for f in data_type.all_fields)
                w.out('return new %s(%s);', j.java_class(data_type), build_args)

    def generate_builder_methods(self, builder_class, fields, wrapped_builder_name=None):
        assert isinstance(builder_class, JavaClass), repr(builder_class)
        assert isinstance(fields, Sequence), repr(fields)
        assert all(isinstance(f, StructField) for f in fields), repr(fields)

        w = self.w
        j = self.j

        # qualify builder name if necessary to avoid name conflicts
        if wrapped_builder_name and wrapped_builder_name != 'super':
            wrapped_builder_name = 'this.' + wrapped_builder_name

        for field in fields:
            containing_data_type = j.field_containing_data_type(field)
            if not field in containing_data_type.all_optional_fields:
                continue

            doc = 'Set value for optional field.'
            if field.has_default:
                doc += """

                If left unset or set to {@code null}, defaults to {@code %s}.
                """ % w.java_default_value(field)


            #
            # withFieldName(FieldType fieldValue);
            #
            w.out('')
            w.javadoc(doc, stone_elem=field, fields=(field,), returns='this builder')
            with w.block('public %s %s(%s %s)',
                         builder_class,
                         j.field_builder_method(field),
                         j.java_class(field, boxed=True), # null treated as default
                         j.param_name(field)):
                if wrapped_builder_name:
                    w.out('%s.%s(%s);',
                          wrapped_builder_name,
                          j.field_builder_method(field),
                          j.param_name(field))
                else:
                    self.generate_field_validation(field)
                    self.generate_field_assignment(field)
                w.out('return this;')

    def generate_exception_type(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)

        j = self.j

        exception_class = j.exception_class(data_type)

        data_type_ref = self.refs.data_type(data_type)
        route_refs = [
            ref for ref in self.refs.routes.values()
            if ref.error_ref == data_type_ref
        ]

        with self.class_writer(exception_class) as w:
            w.importer.add_imports_for_exception_type(data_type)
            w.write_imports()

            route_javadoc_refs = oxford_comma_list([w.javadoc_ref(r) for r in route_refs])

            w.out('')
            w.javadoc(
                """
                Exception thrown when the server responds with a %s error.

                This exception is raised by %s.
                """ % (w.javadoc_ref(data_type), route_javadoc_refs)
            )
            with w.class_block(exception_class, parent_class=JavaClass('com.dropbox.core.DbxApiException')):
                w.out('// exception for routes:')
                for route_ref in route_refs:
                    w.out('//     %s', route_ref.url_path)
                w.out('')
                w.out('private static final long serialVersionUID = 0L;')
                w.out('')

                w.javadoc('The error reported by %s.' % route_javadoc_refs)
                w.out('public final %s errorValue;', j.java_class(data_type))

                w.out('')
                with w.block('public %s(String routeName, String requestId, LocalizedText userMessage, %s errorValue)',
                             exception_class, j.java_class(data_type)):
                    w.out('super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));')
                    with w.block('if (errorValue == null)'):
                        w.out('throw new NullPointerException("errorValue");')
                    w.out('this.errorValue = errorValue;')

    def generate_route_uploader(self, route):
        assert isinstance(route, ApiRoute), repr(route)

        j = self.j

        assert j.request_style(route) == 'upload'

        with self.class_writer(j.route_uploader_class(route)) as w:
            w.importer.add_imports_for_route_uploader(route)
            w.write_imports()

            result_class = j.java_class(route.result_data_type, boxed=True)
            error_class = j.java_class(route.error_data_type, boxed=True)
            exception_class = j.route_exception_class(route)

            parent_class = JavaClass('com.dropbox.core.DbxUploader',
                                     generics=(result_class, error_class, exception_class))

            w.out('')
            w.javadoc(
                """
                The {@link DbxUploader} returned by %s.

                Use this class to upload data to the server and complete the request.

                This class should be properly closed after use to prevent resource leaks and allow
                network connection reuse. Always call {@link #close} when complete (see %s
                for examples).
                """ % (w.javadoc_ref(route), w.javadoc_ref(JavaClass('com.dropbox.core.DbxUploader')))
            )
            with w.class_block(j.route_uploader_class(route), parent_class=parent_class):
                w.out('')
                w.javadoc(
                    'Creates a new instance of this uploader.',
                    params=(('httpUploader', 'Initiated HTTP upload request'),),
                    throws=(('NullPointerException', 'if {@code httpUploader} is {@code null}'),)
                )
                with w.block('public %s(HttpRequestor.Uploader httpUploader, String userId)', j.route_uploader_class(route)):
                    w.out('super(httpUploader, %s, %s, userId);',
                          w.java_serializer(route.result_data_type),
                          w.java_serializer(route.error_data_type))

                w.out('')
                with w.block('protected %s newException(DbxWrappedException error)', exception_class):
                    w.out('return %s', self.translate_error_wrapper(route, 'error'))

    def generate_route_builder(self, route):
        assert isinstance(route, ApiRoute), repr(route)

        j = self.j

        assert j.has_builder(route), repr(route)

        arg = route.arg_data_type

        with self.class_writer(j.builder_class(route)) as w:
            result_class = j.java_class(route.result_data_type, boxed=True)
            error_class = j.java_class(route.error_data_type, boxed=True)
            exception_class = j.route_exception_class(route)

            if j.request_style(route) == 'upload':
                parent_class = JavaClass('com.dropbox.core.v2.DbxUploadStyleBuilder',
                                         generics=(result_class, error_class, exception_class))
                return_class = j.route_uploader_class(route)
            elif j.request_style(route) == 'download':
                parent_class = JavaClass('com.dropbox.core.v2.DbxDownloadStyleBuilder',
                                         generics=(result_class,))
                return_class = j.route_downloader_class(route)
            elif j.has_result(route):
                parent_class = None
                return_class = j.java_class(route.result_data_type)
            else:
                parent_class = None
                return_class = JavaClass('void')

            w.importer.add_imports_for_route_builder(route)
            w.write_imports()

            w.out('')
            w.javadoc(
                """
                The request builder returned by %s.

                Use this class to set optional request parameters and complete the request.
                """ % w.javadoc_ref(route, builder=True)
            )
            with w.class_block(j.builder_class(route), parent_class=parent_class):
                w.out('private final %s _client;', j.java_class(route))
                if j.has_builder(arg):
                    w.out('private final %s _builder;', j.builder_class(arg))
                else:
                    for f in arg.all_required_fields:
                        w.out('private final %s %s;', j.java_class(f), j.param_name(f))
                    for f in arg.all_optional_fields:
                        w.out('private %s %s;', j.java_class(f), j.param_name(f))

                #
                # CONSTRUCTOR
                #

                params=[
                    ('_client', 'Dropbox namespace-specific client used to issue %s requests.' % j.route_namespace(route).name)
                ]
                if j.has_builder(arg):
                    fields = ()
                    args = w.fmt('%s _client, %s _builder', j.java_class(route), j.builder_class(arg))
                    params.append(('_builder', 'Request argument builder.'))
                else:
                    fields = arg.all_required_fields
                    args = w.fmt('%s _client, %s',
                                 j.java_class(route),
                                 ', '.join(
                                     w.fmt('%s %s', j.java_class(f), j.param_name(f)) for f in fields
                                 ))

                w.out('')
                w.javadoc(
                    'Creates a new instance of this builder.',
                    params=params,
                    fields=fields,
                    returns='instsance of this builder',
                )
                # package private
                with w.block('%s(%s)', j.builder_class(route), args):
                    with w.block('if (_client == null)'):
                        w.out('throw new NullPointerException("_client");')
                    w.out('this._client = _client;')

                    if j.has_builder(arg):
                        with w.block('if (_builder == null)'):
                            w.out('throw new NullPointerException("_builder");')
                        w.out('this._builder = _builder;')
                    else:
                        for field in fields:
                            w.out('this.%s = %s;', j.param_name(field), j.param_name(field))
                        for field in arg.all_optional_fields:
                            if field.has_default:
                                w.out('this.%s = %s;', j.param_name(field), w.java_default_value(field))
                            else:
                                w.out('this.%s = null;', j.param_name(field))

                #
                # SETTERS/ADDERs for optional/list fields
                #

                wrapped_builder_name = '_builder' if j.has_builder(arg) else None
                self.generate_builder_methods(j.builder_class(route), arg.all_fields, wrapped_builder_name=wrapped_builder_name)

                #
                # BUILD method to start request
                #

                w.out('')
                if j.request_style(route) in ('download', 'upload'):
                    w.out('@Override')
                    # inehrit doc from parent
                else:
                    w.javadoc('Issues the request.')
                if route.deprecated is not None:
                    w.out('@SuppressWarnings("deprecation")')
                with w.block('public %s start() throws %s, DbxException',
                             return_class, exception_class):
                    if j.has_builder(arg):
                        w.out('%s arg_ = this._builder.build();', j.java_class(arg))
                    else:
                        w.out('%s arg_ = new %s(%s);',
                              j.java_class(arg),
                              j.java_class(arg),
                              ', '.join(j.param_name(f) for f in arg.all_fields))
                    args = ['arg_']
                    if j.request_style(route) == 'download':
                        args.append('getHeaders()')
                    if j.has_result(route) or j.request_style(route) in ('upload', 'download'):
                        w.out('return _client.%s(%s);', j.route_method(route), ', '.join(args))
                    else:
                        w.out('_client.%s(%s);', j.route_method(route), ', '.join(args))

    def generate_field_assignment(self, field, lhs=None, rhs=None, allow_default=True):
        assert isinstance(field, Field), repr(field)

        w = self.w
        j = self.j

        lhs = lhs or ('this.%s' % j.param_name(field))
        rhs = rhs or j.param_name(field)

        underlying_data_type = get_underlying_type(field.data_type)
        # our timestamp format only allows for second-level granularity (no millis).
        # enforce this.
        #
        # TODO: gotta be a better way than this...
        if is_timestamp_type(underlying_data_type) and rhs != 'null':
            rhs = w.fmt('%s.truncateMillis(%s)', JavaClass('com.dropbox.core.util.LangUtil'), rhs)

        if allow_default and field.has_default:
            java_default_value = w.java_default_value(field)
            if rhs == 'null':
                w.out('%s = %s;', lhs, java_default_value)
            else:
                with w.block('if (%s != null)', rhs):
                    w.out('%s = %s;', lhs, rhs)
                with w.block('else'):
                    # set default
                    w.out('%s = %s;', lhs, java_default_value)
        else:
            w.out('%s = %s;', lhs, rhs)

    def generate_field_validation(self, field, value_name=None, omit_arg_name=False, allow_default=True):
        """Generate validation code for one field.
        """
        assert isinstance(field, Field), repr(field)

        w = self.w
        j = self.j

        data_type = field.data_type
        value_name = value_name or j.param_name(field)

        if is_void_type(field.data_type):
            return
        elif is_nullable_type(field.data_type):
            data_type = data_type.data_type
            if j.requires_validation(data_type):
                with w.block('if (%s != null)', j.param_name(field)):
                    self.generate_data_type_validation(data_type, value_name, omit_arg_name=omit_arg_name)
        else:
            # Don't need to check primitive/default types for null.
            if not (j.is_java_primitive(field.data_type) or (allow_default and field.has_default)):
                with w.block('if (%s == null)' % value_name):
                    if omit_arg_name:
                        w.out('throw new IllegalArgumentException("Value is null");')
                    else:
                        w.out('throw new IllegalArgumentException("Required value for \'%s\' is null");', value_name)
            self.generate_data_type_validation(data_type, value_name, omit_arg_name=omit_arg_name)

    # T95586: Because Android has a bug that forces all classes with RUNTIME annotations into the
    # primary dex, we cannot use annotation-based serialization. If we do, then every POJO will be
    # added to a multidex app's primary dex, potentially exceeding the method count limit.
    #
    # The solution is to generate the serialization code for every POJO. Note that from a
    # performance and maintenance standpoint, this is not ideal.
    #
    # The dalvik bug is tracked here: https://code.google.com/p/android/issues/detail?id=78144
    def generate_struct_serializer(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        assert is_struct_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        visibility = j.serializer_visibility(data_type)
        parent_class = JavaClass('com.dropbox.core.stone.StructSerializer',
                                 generics=[j.java_class(data_type)])

        w.out('')
        w.javadoc("For internal use only.")
        with w.class_block(j.serializer_class(data_type), visibility=visibility, parent_class=parent_class):
            w.out('public static final %s INSTANCE = new %s();',
                  j.serializer_class(data_type),
                  j.serializer_class(data_type))
            self.generate_struct_serialize(data_type)
            self.generate_struct_deserialize(data_type)

    def generate_union_serializer(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        assert is_union_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        visibility = j.serializer_visibility(data_type)
        parent_class = JavaClass('com.dropbox.core.stone.UnionSerializer',
                                 generics=[j.java_class(data_type)])

        w.out('')
        w.javadoc("For internal use only.")
        with w.class_block(j.serializer_class(data_type), visibility=visibility, parent_class=parent_class):
            w.out('public static final %s INSTANCE = new %s();',
                  j.serializer_class(data_type),
                  j.serializer_class(data_type))
            self.generate_union_serialize(data_type)
            self.generate_union_deserialize(data_type)

    def generate_struct_serialize(self, data_type):
        assert is_struct_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        w.out('')
        w.out('@Override')
        with w.block('public void serialize(%s value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException', j.java_class(data_type)):

            if data_type.has_enumerated_subtypes():
                for subtype in data_type.get_enumerated_subtypes():
                    subtype_serializer = w.java_serializer(subtype.data_type)
                    with w.block('if (value instanceof %s)', j.java_class(subtype)):
                        w.out('%s.serialize((%s) value, g, collapse);',
                              subtype_serializer,
                              j.java_class(subtype))
                        w.out('return;')

            with w.block('if (!collapse)'):
                w.out('g.writeStartObject();')

            ancestors = get_ancestors(data_type)
            tag = '.'.join(name for name, _ in ancestors[1:] if name)
            if tag:
                w.out('writeTag("%s", g);' % tag)

            for field in data_type.all_fields:
                field_serializer = w.java_serializer(field.data_type)
                field_value = 'value.%s' % j.param_name(field)
                with w.conditional_block(is_nullable_type(field.data_type), 'if (%s != null)', field_value):
                    w.out('g.writeFieldName("%s");', field.name)
                    w.out('%s.serialize(%s, g);', field_serializer, field_value)

            with w.block('if (!collapse)'):
                w.out('g.writeEndObject();')

    def generate_struct_deserialize(self, data_type):
        assert is_struct_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        w.out('')
        w.out('@Override')
        with w.block('public %s deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException', j.java_class(data_type)):
            w.out('%s value;', j.java_class(data_type))
            w.out('String tag = null;')

            with w.block('if (!collapsed)'):
                w.out('expectStartObject(p);')
                w.out('tag = readTag(p);')
                if data_type.is_member_of_enumerated_subtypes_tree():
                    ancestors = get_ancestors(data_type)
                    expected_tag = '.'.join(name for name, _ in ancestors if name)
                    with w.block('if ("%s".equals(tag))' % expected_tag):
                        w.out('tag = null;')

            with w.block('if (tag == null)'):
                for field in data_type.all_fields:
                    default_value = w.java_default_value(field) if field.has_default else 'null'
                    w.out('%s f_%s = %s;',
                          j.java_class(field, boxed=True), j.param_name(field), default_value)

                if data_type.all_fields:
                    with w.block('while (p.getCurrentToken() == JsonToken.FIELD_NAME)'):
                        w.out('String field = p.getCurrentName();')
                        w.out('p.nextToken();')

                        for i, field in enumerate(data_type.all_fields):
                            conditional = 'if' if i == 0 else 'else if'
                            serializer = w.java_serializer(field.data_type)
                            with w.block('%s ("%s".equals(field))', conditional, field.name):
                                w.out('f_%s = %s.deserialize(p);', j.param_name(field), serializer)
                        with w.block('else'):
                            w.out('skipValue(p);')

                for field in data_type.all_fields:
                    if field not in data_type.all_optional_fields:
                        with w.block('if (f_%s == null)', j.param_name(field)):
                            w.out('throw new JsonParseException(p, "Required field \\"%s\\" missing.");' , field.name)
                args = ['f_%s' % j.param_name(f) for f in data_type.all_fields]
                w.out('value = new %s(%s);', j.java_class(data_type), ', '.join(args))

            for tag, subtype_dt in get_enumerated_subtypes_recursively(data_type):
                with w.block('else if ("%s".equals(tag))', tag):
                    w.out('value = %s.deserialize(p, true);', w.java_serializer(subtype_dt))

            with w.block('else'):
                w.out('throw new JsonParseException(p, "No subtype found that matches tag: \\"" + tag + "\\"");')

            with w.block('if (!collapsed)'):
                w.out('expectEndObject(p);')

            w.out('StoneDeserializerLogger.log(value, value.toStringMultiline());')
            w.out('return value;')

    def generate_union_serialize(self, data_type):
        assert is_union_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        w.out('')
        w.out('@Override')
        with w.block('public void serialize(%s value, JsonGenerator g) throws IOException, JsonGenerationException', j.java_class(data_type)):
            tag = 'value' if j.is_enum(data_type) else 'value.tag()'
            with w.block('switch (%s)' % tag):
                for field in data_type.all_fields:
                    if field == data_type.catch_all_field:
                        continue
                    with w.block('case %s:', j.field_tag_enum_name(field)):
                        if is_void_type(field.data_type):
                            w.out('g.writeString("%s");', field.name)
                        else:
                            w.out('g.writeStartObject();')
                            w.out('writeTag("%s", g);', field.name)
                            serializer = w.java_serializer(field.data_type)
                            value = 'value.%s' % j.param_name(field)
                            if j.is_collapsible(field.data_type) or is_nullable_type(field.data_type) and j.is_collapsible(field.data_type.data_type):
                                w.out('%s.serialize(%s, g, true);', serializer, value)
                            else:
                                w.out('g.writeFieldName("%s");', field.name)
                                w.out('%s.serialize(%s, g);', serializer, value)
                            w.out('g.writeEndObject();')
                        w.out('break;')

                with w.block('default:'):
                    if data_type.catch_all_field:
                        w.out('g.writeString("%s");', data_type.catch_all_field.name)
                    else:
                        w.out('throw new IllegalArgumentException("Unrecognized tag: " + %s);', tag)

    def generate_union_deserialize(self, data_type):
        assert is_union_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        w.out('')
        w.out('@Override')
        with w.block('public %s deserialize(JsonParser p) throws IOException, JsonParseException', j.java_class(data_type)):
            w.out('%s value;', j.java_class(data_type))
            w.out('boolean collapsed;')
            w.out('String tag;')

            with w.block('if (p.getCurrentToken() == JsonToken.VALUE_STRING)'):
                w.out('collapsed = true;')
                w.out('tag = getStringValue(p);')
                w.out('p.nextToken();')
            with w.block('else'):
                w.out('collapsed = false;')
                w.out('expectStartObject(p);')
                w.out('tag = readTag(p);')

            with w.block('if (tag == null)'):
                w.out('throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);')

            for field in data_type.all_fields:
                if field == data_type.catch_all_field:
                    continue

                field_dt = field.data_type
                with w.block('else if ("%s".equals(tag))', field.name):
                    if is_void_type(field.data_type):
                        w.out('value = %s.%s;', j.java_class(data_type), j.field_static_instance(field))
                    else:
                        w.out('%s fieldValue = null;', j.java_class(field_dt, boxed=True, generics=True))
                        with w.conditional_block(is_nullable_type(field.data_type), 'if (p.getCurrentToken() != JsonToken.END_OBJECT)'):
                            field_serializer = w.java_serializer(field_dt)
                            if j.is_collapsible(field_dt) or is_nullable_type(field_dt) and j.is_collapsible(field_dt.data_type):
                                w.out('fieldValue = %s.deserialize(p, true);', field_serializer)
                            else:
                                w.out('expectField("%s", p);', field.name)
                                w.out('fieldValue = %s.deserialize(p);', field_serializer)

                        if is_nullable_type(field.data_type):
                            with w.block('if (fieldValue == null)'):
                                w.out('value = %s.%s();', j.java_class(data_type), j.field_factory_method(field))
                            with w.block('else'):
                                w.out('value = %s.%s(fieldValue);', j.java_class(data_type), j.field_factory_method(field))
                        else:
                            w.out('value = %s.%s(fieldValue);', j.java_class(data_type), j.field_factory_method(field))
            with w.block('else'):
                if data_type.catch_all_field:
                    w.out('value = %s.%s;', j.java_class(data_type), j.field_static_instance(data_type.catch_all_field))
                else:
                    w.out('throw new JsonParseException(p, "Unknown tag: " + tag);')

            with w.block('if (!collapsed)'):
                w.out('skipFields(p);')
                w.out('expectEndObject(p);')

            w.out('return value;')

    def generate_data_type_validation(self, data_type, value_name, description=None, omit_arg_name=False, level=0):
        assert isinstance(data_type, DataType), repr(data_type)

        w = self.w
        j = self.j

        if omit_arg_name:
            description = ""
        else:
            description = description or (" '%s'" % value_name)

        if is_list_type(data_type):
            if data_type.min_items is not None:
                java_value = w.java_value(Int32(), data_type.min_items)
                with w.block('if (%s.size() < %s)', value_name, java_value):
                    w.out('throw new IllegalArgumentException("List%s has fewer than %s items");',
                          description, java_value)
            if data_type.max_items is not None:
                java_value = w.java_value(Int32(), data_type.max_items)
                with w.block('if (%s.size() > %s)', value_name, java_value):
                    w.out('throw new IllegalArgumentException("List%s has more than %s items");',
                          description, java_value)
            xn = 'x' if level == 0 else 'x%d' % level
            list_item_type = j.java_class(data_type.data_type, boxed=True, generics=True)
            with w.block('for (%s %s : %s)', list_item_type, xn, value_name):
                with w.block('if (%s == null)', xn):
                    w.out('throw new IllegalArgumentException("An item in list%s is null");', description)
                self.generate_data_type_validation(data_type.data_type, xn, 'an item in list%s' % description, level=level+1)

        elif is_map_type(data_type):
            xn = 'x' if level == 0 else 'x%d' % level
            map_item_type = j.java_class(data_type.value_data_type, boxed=True, generics=True)
            with w.block('for (%s %s : %s.values())', map_item_type, xn, value_name):
                with w.block('if (%s == null)', xn):
                    w.out('throw new IllegalArgumentException("An item in map%s is null");', description)
                self.generate_data_type_validation(data_type.value_data_type, xn, 'an item in map%s' % description, level=level+1)

        elif is_numeric_type(data_type):
            if data_type.min_value is not None:
                java_value = w.java_value(data_type, data_type.min_value)
                with w.block('if (%s < %s)', value_name, java_value):
                    w.out('throw new IllegalArgumentException("Number%s is smaller than %s");',
                          description, java_value)
            if data_type.max_value is not None:
                java_value = w.java_value(data_type, data_type.max_value)
                with w.block('if (%s > %s)', value_name, java_value):
                    w.out('throw new IllegalArgumentException("Number%s is larger than %s");',
                          description, java_value)

        elif is_string_type(data_type):
            if data_type.min_length is not None:
                java_value = w.java_value(Int32(), data_type.min_length)
                with w.block('if (%s.length() < %s)', value_name, java_value):
                    w.out('throw new IllegalArgumentException("String%s is shorter than %s");',
                          description, java_value)
            if data_type.max_length is not None:
                java_value = w.java_value(Int32(), data_type.max_length)
                with w.block('if (%s.length() > %s)', value_name, java_value):
                    w.out('throw new IllegalArgumentException("String%s is longer than %s");',
                          description, java_value)
            if data_type.pattern is not None:
                # TODO: Save the pattern as a static variable.
                # NOTE: pattern should match against entire input sequence
                pattern_class = JavaClass("java.util.regex.Pattern")
                pattern = sanitize_pattern(data_type.pattern)
                with w.block('if (!%s.matches("%s", %s))', pattern_class, pattern, value_name):
                    w.out('throw new IllegalArgumentException("String%s does not match pattern");', description)

        elif any((
                is_composite_type(data_type),
                is_boolean_type(data_type),
                is_timestamp_type(data_type),
                is_bytes_type(data_type),
        )):
            pass  # Nothing to do for these

        else:
            raise AssertionError(repr(data_type))

    def generate_to_string(self, data_type):
        assert is_user_defined_type(data_type), repr(data_type)

        w = self.w

        w.out('')
        w.out('@Override')
        with w.block('public String toString()'):
            w.out('return Serializer.INSTANCE.serialize(this, false);')

        w.out('')
        w.javadoc(
            """
            Returns a String representation of this object formatted for easier readability.

            The returned String may contain newlines.
            """,
            returns="Formatted, multiline String representation of this object"
        )
        with w.block('public String toStringMultiline()'):
            w.out('return Serializer.INSTANCE.serialize(this, true);')

    def generate_hash_code(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        assert is_user_defined_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        assert not j.is_enum(data_type), "enum types don't require equals() methods"

        if is_struct_type(data_type):
            fields = [j.param_name(f) for f in data_type.fields]
        else:
            fields = ['_tag'] + [j.param_name(f) for f in data_type.all_fields if j.has_value(f)]

        w.out('')
        w.out('@Override')
        with w.block('public int hashCode()'):
            if not fields:
                w.out('// attempt to deal with inheritance')
                w.out('return getClass().toString().hashCode();')
            else:
                arrays_class = JavaClass('java.util.Arrays')
                with w.block('int hash = %s.hashCode(new Object []', arrays_class, after=');'):
                    self.g.generate_multiline_list(fields, delim=('', ''))
                if data_type.parent_type:
                    w.out('hash = (31 * super.hashCode()) + hash;')
                w.out('return hash;')

    def _java_eq(self, field, name=None):
        assert isinstance(field, Field), repr(field)

        j = self.j

        name = name or j.param_name(field)

        if j.is_java_primitive(field.data_type):
            return 'this.%(f)s == other.%(f)s' % dict(f=name)
        elif not is_nullable_type(field.data_type):
            return '(this.%(f)s == other.%(f)s) || (this.%(f)s.equals(other.%(f)s))' % dict(f=name)
        else:
            return '(this.%(f)s == other.%(f)s) || (this.%(f)s != null && this.%(f)s.equals(other.%(f)s))' % dict(f=name)

    def generate_equals(self, data_type):
        assert isinstance(data_type, DataType), repr(data_type)
        assert is_user_defined_type(data_type), repr(data_type)

        if is_struct_type(data_type):
            self.generate_struct_equals(data_type)
        else:
            self.generate_union_equals(data_type)

    def generate_union_equals(self, data_type):
        assert is_union_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        assert not j.is_enum(data_type), "enum types don't require equals() methods"

        w.out('')
        w.out('@Override')
        with w.block('public boolean equals(Object obj)'):
            with w.block('if (obj == this)'):
                w.out('return true;')
            with w.block('if (obj == null)'):
                w.out('return false;')
            with w.block('else if (obj instanceof %s)', j.java_class(data_type)):
                w.out('%s other = (%s) obj;', j.java_class(data_type), j.java_class(data_type))
                with w.block('if (this._tag != other._tag)'):
                    w.out('return false;')

                with w.block('switch (_tag)'):
                    for field in data_type.all_fields:
                        w.out('case %s:', j.field_tag_enum_name(field))
                        with self.g.indent():
                            if j.has_value(field):
                                w.out('return %s;', self._java_eq(field))
                            else:
                                w.out('return true;')
                    w.out('default:')
                    with self.g.indent():
                        w.out('return false;')
            with w.block('else'):
                w.out('return false;')

    def generate_struct_equals(self, data_type):
        assert is_struct_type(data_type), repr(data_type)

        w = self.w
        j = self.j

        w.out('')
        w.out('@Override')
        with w.block('public boolean equals(Object obj)'):
            with w.block('if (obj == this)'):
                w.out('return true;')
            with w.block('if (obj == null)'):
                w.out('return false;')
            w.out('// be careful with inheritance')
            with w.block('else if (obj.getClass().equals(this.getClass()))'):
                w.out('%s other = (%s) obj;', j.java_class(data_type), j.java_class(data_type))

                if not data_type.all_fields:
                    w.out('return true;')
                elif len(data_type.all_fields) == 1:
                    w.out('return %s;', self._java_eq(data_type.all_fields[0]))
                else:
                    w.out('return (%s)', self._java_eq(data_type.all_fields[0]))
                    with self.g.indent():
                        for field in data_type.all_fields[1:]:
                            w.out('&& (%s)', self._java_eq(field))
                        w.out(';')
            with w.block('else'):
                w.out('return false;')




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
    'List': 'java.util.List',
    'Map': 'java.util.Map',
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
    'List': 'java.util.List',
    'Map': 'java.util.Map',
}

_CATCH_ALL_DOC = """
Catch-all used for unknown tag values returned by the Dropbox servers.

Receiving a catch-all value typically indicates this SDK version is not up to
date. Consider updating your SDK version to handle the new tags.
"""
