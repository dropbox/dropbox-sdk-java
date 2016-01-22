"""Generate Java classes from Babel specs.

See https://github.com/dropbox/babelapi

Authors:
    Guido van Rossum (guido@dropbox.com)
    Ian Orton (ianorton@dropbox.com)
"""
# TODO: Support {".tag": <tag>, ".tag.<tag>" : "<subtag>", ...}.
# TODO: Don't generate assert statements, throw something.
# TODO: Don't throw XXX for "Don't know how to write/validate" cases.
# TODO: Should _reader not be public? Or should _writer be public?
# TODO: Namespace comments.

from __future__ import absolute_import, division, print_function, unicode_literals

import os
import argparse

from collections import OrderedDict
from contextlib import contextmanager
from functools import partial

from babelapi.generator import CodeGenerator
from babelapi.data_type import (
    get_underlying_type,
    is_binary_type,
    is_boolean_type,
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
    Void,
)

# TODO: Add all Java reserved words.
reserved_words = {'if', 'while', 'continue', 'public'}


def _fixreserved(s):
    if s in reserved_words:
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


def oxford_comma_list(values, conjunction='and'):
    if not values:
        return None
    elif len(values) == 1:
        return values[0]
    elif len(values) == 2:
        return '%s %s %s' % (values[0], conjunction, values[1])
    else:
        return '%s, %s %s' % (', '.join(values[:-1]), conjunction, values[-1])


def is_simple_field(field):
    return isinstance(field.data_type, Void)


def has_value_fields(data_type):
    assert is_union_type(data_type)
    for field in data_type.all_fields:
        if not is_simple_field(field):
            return True
    return False


def classname(s):
    return capwords(s)


def routename(s):
    return camelcase(s)


def builder_class_name(api_route):
    return classname(builder_method_name(api_route))


def builder_method_name(api_route):
    return camelcase(api_route.name) + 'Builder'


def parse_route_ref(ref, namespace=None):
    if '.' in ref:
        ref_namespace, route = ref.split('.', 1)
    else:
        ref_namespace = namespace.name
        route = ref
    return ref_namespace, route


def parse_field_ref(ref, api_namespace, api_data_type):
    if '.' in ref:
        data_type_name, field = ref.split('.', 1)
        data_type = api_namespace.data_type_by_name.get(data_type_name) or api_data_type
    else:
        data_type = api_data_type
        field = ref
    return data_type, field, data_type == api_data_type


def uses_builder_pattern(api_route):
    if is_struct_type(api_route.request_data_type):
        style = api_route.attrs.get('style', 'rpc')
        if style in ('upload', 'download'):
            return True

        n_optional = len(api_route.request_data_type.all_optional_fields)
        return n_optional > 1
    else:
        return False


def format_route_ref(api, namespace, route):
    assert namespace is not None
    api_namespace = api.namespaces[namespace]
    api_route = api_namespace.route_by_name[route]
    return format_route(api_namespace, api_route)


def format_route(api_namespace, api_route):
    if uses_builder_pattern(api_route):
        return '%s#%s' % (namespace_ref(api_namespace), builder_method_name(api_route))
    elif is_void_type(api_route.request_data_type):
        return '%s#%s' % (namespace_ref(api_namespace), routename(api_route.name))
    else:
        # by default, all doc refs should point to the method that
        # accepts the most arguments
        unpacked_types = (
            field_type(api_namespace.name, field, boxed=False, generics=False)
            for field in api_route.request_data_type.all_fields
        )
        args = ",".join(unpacked_types)
        return '%s#%s(%s)' % (namespace_ref(api_namespace), routename(api_route.name), args)


def format_data_type_ref(data_type):
    return classname(data_type)


def format_field_ref(api_data_type, field, use_link=True):
    field_name = camelcase(field)

    if api_data_type and use_link:
        return '{@link %s#%s}' % (format_data_type_ref(api_data_type.name), field_name)
    else:
        # don't use {@link} if we have no idea what it is (safest)
        return '{@code %s}' % (field_name,)


def is_primitive_type(dt):
    correct_type = is_boolean_type(dt) or is_numeric_type(dt) or is_void_type(dt)
    return correct_type and not is_nullable_type(dt)


def get_field(api_data_type, field_name):
    for field in api_data_type.all_fields:
        if field.name == field_name:
            return field
    return None

type_map_unboxed = {
    'UInt64': 'long',
    'Int64': 'long',
    'UInt32': 'long',
    'Int32': 'int',
    'Float64': 'double',
    'Float32': 'float',
    'Boolean': 'boolean',
    'Binary': 'byte[]',
    'String': 'String',
    'Timestamp': 'java.util.Date',
    'Void': 'void',
}

type_map_boxed = {
    'UInt64': 'Long',
    'Int64': 'Long',
    'UInt32': 'Long',
    'Int32': 'Integer',
    'Float64': 'Double',
    'Float32': 'Float',
    'Boolean': 'Boolean',
    'Binary': 'byte[]',
    'String': 'String',
    'Timestamp': 'java.util.Date',
    'Void': 'void',
}


def maptype(namespace, data_type, boxed=True, generics=True):
    """Map a Babel data type to a Java type expression.

    There are special cases for primitive types, list (array) types,
    and struct/union types.
    """
    data_type, nullable = get_underlying_type(data_type)
    if nullable:
        boxed = True
    if is_list_type(data_type):
        if generics:
            return 'java.util.List<%s>' % maptype(namespace, data_type.data_type)
        else:
            return 'java.util.List'
    type_map = type_map_boxed if boxed else type_map_unboxed
    if data_type.name in type_map:
        return type_map[data_type.name]
    assert is_composite_type(data_type), data_type
    return type_ref(namespace, data_type)


def type_ref(namespace, dt):
    ref = classname(dt.name)
    if dt.namespace != namespace:
        ref = namespace_ref(dt.namespace) + '.' + ref
    return ref

def namespace_ref(ns):
    return "Dbx" + classname(ns.name)


def mapreader(namespace, data_type):
    """Map a Babel data type to a Java expression giving a Reader instance.

    This is not quite the same as maptype(...) + '._reader' since
    there are exceptions for various types.

    The generated code assumes all classes from com.dropbox.core.json
    have been imported.
    """
    data_type, _ = get_underlying_type(data_type)
    if is_list_type(data_type):
        return 'JsonArrayReader.mk(%s)' % mapreader(namespace, data_type.data_type)
    if is_composite_type(data_type):
        return maptype(namespace, data_type) + '._reader'
    if is_string_type(data_type):
        return 'JsonReader.StringReader'
    if is_boolean_type(data_type):
        return 'JsonReader.BooleanReader'
    if is_numeric_type(data_type):
        # Assume JsonReader defines <foo>Reader for every integer and float type.
        return 'JsonReader.%sReader' % data_type.name
    if is_timestamp_type(data_type):
        return 'JsonDateReader.DropboxV2'
    if is_binary_type(data_type):
        return 'JsonReader.BinaryReader'
    if is_void_type(data_type):
        return 'JsonReader.VoidReader'
    assert False, data_type  # Unsupported primitive type


def mapvalue(namespace, data_type, value):
    """Map a Babel (Python) value to a Java expression."""
    if isinstance(value, bool):
        return 'true' if value else 'false'
    if isinstance(value, float):
        return repr(value)  # Because str() drops the last few digits.
    if data_type.name in ('Int64', 'UInt64', 'UInt32'):
        return str(value) + 'L'  # Need exact type match for boxed values.
    if isinstance(data_type, Union):
        assert isinstance(value, TagRef), (data_type, value)
        assert data_type is value.union_data_type, (data_type, value)
        return '%s.%s()' % (
            maptype(namespace, data_type),
            camelcase(value.tag_name),
        )
    return str(value)


# Matcher for Babel doc references.
docref = ':(?P<tag>[A-z]*):`(?P<val>.*?)`'

def doc_ref_handler(tag, val, api, namespace, data_type=None, link_local_fields=True):
    """Substitute references in Babel docstrings with the proper Javadoc format."""
    if tag == 'route':
        ref_namespace, route = parse_route_ref(val, namespace)
        return '{@link %s}' % format_route_ref(api, ref_namespace, route)
    elif tag == 'type':
        return '{@link %s}' % format_data_type_ref(val)
    elif tag == 'field':
        api_data_type, field, is_local = parse_field_ref(val, namespace, data_type)
        use_link = (not is_local) or link_local_fields
        return format_field_ref(api_data_type, field, use_link=use_link)
    elif tag == 'link':
        anchor, link = val.rsplit(' ', 1)
        return '<a href="%s">%s</a>' % (link, anchor)
    elif tag == 'val':
        # Note that all valid Babel literals happen to be valid Java literals.
        return '{@code %s}' % val
    else:
        assert False, 'Unsupported tag (:%s:`%s`)' % (tag, val)


def get_ancestors(data_type):
    """Return list of (tag, data_type) pairs.

    The first pair is the root and always has tag None.
    The last pair represents the argument.

    The tag is only present if the data_type in that pair has an
    ancestor and is a member of that ancestore's enumerated subtypes.

    Suppose we have the following tree:

      struct A
      struct B extends A
      struct C extends C

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


_cmdline_parser = argparse.ArgumentParser(prog='java-generator')
_cmdline_parser.add_argument('--package', type=str, help='base package name', required=True)

def field_name(field):
    return camelcase(field.name)


def field_doc(field):
    return getattr(field, "doc", "")


def field_type(namespace, field, boxed=True, generics=True):
    return maptype(namespace, field.data_type, boxed, generics)


def type_and_name(namespace, field, boxed=True):
    return '%s %s' % (field_type(namespace, field, boxed), field_name(field))


def get_auth_types_set(namespace):
    routes = namespace.routes
    if not routes:
        return set()

    return {
        route.attrs.get('auth', 'user')
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


class JavaCodeGenerator(CodeGenerator):
    cmdline_parser = _cmdline_parser

    def bsemi(self, before=''):
        """Like self.block(), but with a semicolon after the closing brace."""
        return self.block(before, after=';')

    def generate(self, api):
        """Toplevel code generation method.

        This is called by babelapi.cli.
        """
        package_name = self.args.package
        package_relpath = self.create_package_path(package_name)

        self.generate_dbx_clients(api, package_relpath, package_name)

        # Create a package for each namespace containing datatypes and routes.
        for namespace in api.namespaces.values():
            doc_out = partial(self.generate_doc, api, namespace)
            # Create a <Namespace>.java file containing nested classes.
            self.generate_namespace_wrapper(namespace, package_relpath, package_name, doc_out)

    def create_package_path(self, package_name):
        package_components = package_name.split('.')
        package_relpath = os.path.join(*package_components)
        package_fullpath = os.path.join(self.target_folder_path, package_relpath)
        if not os.path.isdir(package_fullpath):
            self.logger.info('Creating directory %s', package_fullpath)
            os.makedirs(package_fullpath)
        return package_relpath

    def generate_dbx_clients(self, api, package_relpath, package_name):
        out = self.emit

        user_client_class_name = 'DbxClientV2'
        with self.dbx_client(
                api, package_relpath, package_name, user_client_class_name, ('user', 'noauth'),
                """
                Use this class to make remote calls to the Dropbox API user endpoints.  User endpoints
                expose actions you can perform as a Dropbox user.  You'll need an access token first,
                normally acquired by directing a Dropbox user through the auth flow using {@link
                com.dropbox.core.DbxWebAuth}.
                """
        ):
            pass

        with self.dbx_client(
                api, package_relpath, package_name, 'DbxTeamClientV2', ('team',),
                """
                Use this class to make remote calls to the Dropbox API team endpoints.  Team endpoints
                expose actions you can perform on or for a Dropbox team.  You'll need a team access
                token first, normally acquired by directing a Dropbox Business team administrator
                through the auth flow using {@link com.dropbox.core.DbxWebAuth}.

                Team clients can access user endpoints by using the {@link #asMember} method.  This
                allows team clients to perform actions as a particular team member.
                """
        ):
            self.generate_javadoc(
                """
                Returns a {@link %s} that performs requests against Dropbox API user endpoints as the
                given team member.

                This method performs no validation of the team member ID.
                """ % (user_client_class_name,),
                params={"memberId": "Team member ID of member in this client's team, never {@code null}."},
                returns="Dropbox client that issues requests to user endpoints as the given team member",
                throws={"IllegalArgumentException": "If {@code memberId} is {@code null}"}
            )

            out('')
            with self.block('public %s asMember(String memberId)' % (user_client_class_name,)):
                out('if (memberId == null) throw new IllegalArgumentException("\'memberId\' should not be null");')
                out('return new %s(new DbxTeamRawClientV2(rawClient, memberId));' % (user_client_class_name,))

            self.generate_javadoc(
                """
                {@link DbxRawClientV2} raw client that adds select-user header to all requests.
                Used to perform requests as a particular team member.
                """
            )
            with self.block('private static final class DbxTeamRawClientV2 extends DbxRawClientV2'):
                out('private final String memberId;')
                out('')
                with self.block('private DbxTeamRawClientV2(DbxRawClientV2 underlying, String memberId)'):
                    out('super(underlying);')
                    out('this.memberId = memberId;')
                out('')
                out('@Override')
                with self.block('protected void addAuthHeaders(java.util.List<HttpRequestor.Header> headers)'):
                    out('super.addAuthHeaders(headers);')
                    out('com.dropbox.core.DbxRequestUtil.addSelectUserHeader(headers, memberId);')


    @contextmanager
    def dbx_client(self, api, package_relpath, package_name, class_name, auth_types, class_doc):
        assert class_doc

        out = self.emit

        namespaces = get_namespaces_by_auth_types(api, auth_types)

        file_name = os.path.join(package_relpath, class_name + '.java')
        with self.output_to_relative_path(file_name):
            out('/* DO NOT EDIT */')
            out('/* This file was generated by Babel */')
            out('')
            out('package %s;' % package_name)
            out('')
            out('import com.dropbox.core.DbxHost;')
            out('import com.dropbox.core.DbxRequestConfig;')
            out('import com.dropbox.core.http.HttpRequestor;')
            out('')
            self.generate_javadoc(
                """
                %s

                This class has no mutable state, so it's thread safe as long as you pass in a thread
                safe {@link HttpRequestor} implementation.
                """ % class_doc
            )
            with self.block('public final class %s' % class_name):
                out('private final DbxRawClientV2 rawClient;')
                get_field_name = lambda ns: camelcase(namespace.name)
                for namespace in namespaces:
                    out('public final %s %s;' % (namespace_ref(namespace), get_field_name(namespace)))
                out('')

                param_docs = OrderedDict((
                    ('requestConfig', 'Default attributes to use for each request'),
                    ('accessToken', 'OAuth 2 access token (that you got from Dropbox) '
                     'that gives your app the ability to make Dropbox API calls. Typically '
                     'acquired through {@link com.dropbox.core.DbxWebAuth}'),
                    ('host', 'Dropbox hosts to send requests to (used for mocking and testing)'),
                ))

                self.generate_javadoc(
                    """
                    Creates a client that uses the given OAuth 2 access token as authorization when
                    performing requests against the default Dropbox hosts.
                    """,
                    params=OrderedDict(
                        (k, v) for k, v in param_docs.items()
                        if k in ('requestConfig', 'accessToken')
                    )
                )
                with self.block('public %s(DbxRequestConfig requestConfig, String accessToken)' % class_name):
                    out('this(requestConfig, accessToken, DbxHost.Default);')

                out('')


                self.generate_javadoc(
                    """
                    Same as {@link #%s(DbxRequestConfig, String)} except you can also set the
                    hostnames of the Dropbox API servers. This is used in testing. You don't
                    normally need to call this.
                    """ % (class_name,),
                    params=param_docs
                )
                with self.block('public %s(DbxRequestConfig requestConfig, String accessToken, DbxHost host)' % class_name):
                    out('this(new DbxRawClientV2(requestConfig, accessToken, host));')

                out('')
                self.generate_javadoc(
                    """
                    For internal use only.
                    """,
                    params=param_docs
                )
                # package-private
                with self.block(('%s(DbxRawClientV2 rawClient)') % class_name):
                    out('this.rawClient = rawClient;')
                    for namespace in namespaces:
                        out('this.%s = new %s(rawClient);' % (
                            get_field_name(namespace), namespace_ref(namespace)
                        ))

                out('')
                # allow caller to add custom methods to the client
                yield

    def generate_namespace_wrapper(self, namespace, package_relpath, package_name, doc_out):
        out = self.emit
        class_name = namespace_ref(namespace)
        file_name = os.path.join(package_relpath, class_name + '.java')
        with self.output_to_relative_path(file_name):
            out('/* DO NOT EDIT */')
            out('/* This file was generated from %s.babel */' % namespace.name)
            out('')
            out('package %s;' % package_name)
            out('')
            out('import java.io.IOException;')
            out('import java.util.regex.Pattern;')
            out('import com.fasterxml.jackson.core.JsonGenerator;')
            out('import com.fasterxml.jackson.core.JsonParser;')
            out('import com.fasterxml.jackson.core.JsonToken;')
            out('import com.dropbox.core.DbxApiException;')
            out('import com.dropbox.core.v2.DbxRawClientV2;')
            out('import com.dropbox.core.DbxException;')
            out('import com.dropbox.core.DbxRequestUtil;')
            out('import com.dropbox.core.LocalizedText;')
            out('import com.dropbox.core.http.HttpRequestor;')
            out('import com.dropbox.core.json.JsonArrayReader;')
            out('import com.dropbox.core.json.JsonDateReader;')
            out('import com.dropbox.core.json.JsonReader;')
            out('import com.dropbox.core.json.JsonReadException;')
            out('import com.dropbox.core.json.JsonWriter;')

            out('')
            doc_out('Classes and routes in namespace "%s".' % namespace.name)
            with self.block('public final class %s' % class_name):
                out('// namespace %s' % namespace.name)
                out('')
                out('private final DbxRawClientV2 client;')
                out('')
                with self.block('%s(DbxRawClientV2 client)' % class_name):
                    out('this.client = client;')
                for data_type in namespace.linearize_data_types():
                    out('')
                    data_type_doc_out = partial(doc_out, data_type=data_type)
                    self.generate_data_type_class(namespace, data_type, data_type_doc_out)
                for route in namespace.routes:
                    self.generate_route_stuff(namespace, route, class_name, doc_out)

    def generate_packed_method(self, namespace, route, doc_out):
        out = self.emit
        arg_name = maptype(namespace, route.request_data_type)
        result_name = maptype(namespace, route.response_data_type)
        error_name = maptype(namespace, route.error_data_type)
        method_name = camelcase(route.name)
        method_javadoc_name = format_route(namespace, route)
        exc_name = classname(route.name + '_exception')
        result_reader = mapreader(namespace, route.response_data_type)
        error_reader = mapreader(namespace, route.error_data_type)
        doc_out('Exception thrown by {@link %s}.' % method_javadoc_name)
        with self.block('public static class %s extends DbxApiException' % exc_name):
            if error_name == 'void':
                with self.block('public %s(String requestId, LocalizedText userMessage)' % exc_name):
                    out('super(requestId, userMessage, buildMessage("%s", userMessage));' % route.name)
            else:
                doc_out('The error reported by %s.' % method_name)
                out('public final %s errorValue;' % error_name)
                out('')
                with self.block('public %s(String requestId, LocalizedText userMessage, %s errorValue)' % (exc_name, error_name)):
                    out('super(requestId, userMessage, buildMessage("%s", userMessage, errorValue));' % route.name)
                    out('this.errorValue = errorValue;')
        style = route.attrs.get('style', 'rpc')
        if style == 'upload':
            error_maker = camelcase(route.name + '_error_maker')
            uploader_maker = camelcase(route.name + '_uploader_maker')
            out('static DbxRequestUtil.RouteSpecificErrorMaker<%s> %s = '
                'new DbxRequestUtil.RouteSpecificErrorMaker<%s>()' %
                (exc_name, error_maker, exc_name))
            with self.bsemi():
                out('@Override')
                with self.block('public %s makeError(DbxRequestUtil.ErrorWrapper ew)' % exc_name):
                    if error_name == 'void':
                        out('return new %s(ew.requestId, ew.userMessage);' % exc_name)
                    else:
                        out('return new %s(ew.requestId, ew.userMessage, (%s) (ew.errValue));' % (exc_name, error_name))
            resname = 'Object' if result_name == 'void' else result_name
            errname = 'Object' if error_name == 'void' else error_name
            doc_out('The {@link com.dropbox.core.DbxUploader} returned by '
                    '{@link %s}.' % method_javadoc_name)
            uploader = classname(route.name + '_uploader')
            with self.block('public static class %s '
                            'extends com.dropbox.core.DbxUploader<%s,%s,%s>' %
                            (uploader, resname, errname, exc_name)):
                with self.block('%s(HttpRequestor.Uploader httpUploader, '
                                'JsonReader<%s> resultReader, JsonReader<%s>errorReader, '
                                'DbxRequestUtil.RouteSpecificErrorMaker<%s> errorMaker)'
                                % (uploader, resname, errname, exc_name)):
                    out('super(httpUploader, resultReader, errorReader, errorMaker);')
            out('static com.dropbox.core.DbxUploader.UploaderMaker'
                '<%s,%s,%s> %s = '
                'new com.dropbox.core.DbxUploader.UploaderMaker<%s,%s,%s>()' %
                (resname, errname, exc_name, uploader_maker, resname, errname, exc_name))
            with self.bsemi():
                out('@Override')
                with self.block('public com.dropbox.core.DbxUploader<%s,%s,%s> '
                                'makeUploader(HttpRequestor.Uploader httpUploader)' %
                                (resname, errname, exc_name)):
                    out('return new %s'
                        '(httpUploader, %s, %s, %s);' %
                        (uploader, result_reader, error_reader, error_maker))
            doc_out(route.doc)
            if arg_name == 'void':
                out('public %s %s()' % (uploader, method_name))
            else:
                out('private %s %s(%s arg)' % (uploader, method_name, arg_name))
            out('        throws DbxException')
        elif style == 'download':
            doc_out(route.doc)
            if arg_name == 'void':
                out('public com.dropbox.core.DbxDownloader<%s>'
                    ' %s()' % (result_name, method_name))
            else:
                out('private com.dropbox.core.DbxDownloader<%s>'
                    ' %s(%s arg)' %
                    (result_name, method_name, arg_name))
            out('        throws %s, DbxException' % exc_name)
        else:
            doc_out(route.doc)
            if arg_name == 'void':
                out('public %s %s()' % (result_name, method_name))
            else:
                out('private %s %s(%s arg)' %
                    (result_name, method_name, arg_name))
            out('        throws %s, DbxException' % exc_name)
        with self.block():
            with self.block('try'):
                host = route.attrs.get('host', 'api')
                is_noauth = route.attrs.get('auth', 'user') == 'noauth'
                if style == 'upload':
                    self.generate_multiline_list([
                        'client.getHost().%s' % host,
                        '"2/%s/%s"' % (namespace.name, route.name),
                        'arg' if arg_name != 'void' else 'null',
                        'true' if is_noauth else 'false',
                        arg_name + '._writer' if arg_name != 'void' else 'null',
                        uploader_maker,
                    ], before='return (%s) client.uploadStyle' % uploader, after=';')
                else:
                    ret = '' if is_void_type(route.response_data_type) else 'return '
                    self.generate_multiline_list([
                        'client.getHost().%s' % host,
                        '"2/%s/%s"' % (namespace.name, route.name),
                        'arg' if arg_name != 'void' else 'null',
                        'true' if is_noauth else 'false',
                        arg_name + '._writer' if arg_name != 'void' else 'null',
                        '%s' % result_reader,
                        '%s' % error_reader,
                    ], before='%sclient.%sStyle' % (ret, style), after=';')
            if style != 'upload':
                with self.block('catch (DbxRequestUtil.ErrorWrapper ew)'):
                    if error_name == 'void':
                        out('throw new %s(ew.requestId, ew.userMessage);' % exc_name)
                    else:
                        out('throw new %s(ew.requestId, ew.userMessage, (%s) (ew.errValue));' % (exc_name, error_name))
            else:
                # TODO: The right way to do this is not to
                # emit the try{} wrapper if it's not rpc style.
                out('catch (DbxException ex) { throw ex; } // Dummy')


    # Construct the relevant argument object, set the fields and call
    # the previously generated method.
    def generate_call_to_packed_method(self, namespace, route, ret, prefix="", required_only=False):
        out = self.emit
        arg_name = maptype(namespace, route.request_data_type)
        method_name = prefix + camelcase(route.name)
        args = []
        for field in route.request_data_type.all_fields:
            if required_only and field in route.request_data_type.all_optional_fields:
                args.append('null')
            else:
                args.append(field_name(field))
        out('%s arg = new %s(%s);' % (arg_name, arg_name, ', '.join(args)))
        out('%s%s(arg);' % (ret, method_name))


    def generate_unpacked_method(self, namespace, route, rtype, ret, doc_out, required_only=False):
        assert required_only or not uses_builder_pattern(route)

        out = self.emit
        method_name = camelcase(route.name)
        exc_name = classname(route.name + '_exception')
        if required_only:
            fields = route.request_data_type.all_required_fields
        else:
            fields = route.request_data_type.all_fields
        doc_out(route.doc, fields=fields)
        args = [type_and_name(namespace, field, boxed=False) for field in fields]
        out('public %s %s(%s)' % (rtype, method_name, ', '.join(args)))
        out('      throws %s, DbxException' % exc_name)
        with self.block():
            self.generate_call_to_packed_method(namespace, route, ret, required_only=required_only)

    def generate_builder(self, namespace, route, rtype, ret, outer, doc_out):
        assert uses_builder_pattern(route)

        out = self.emit
        exc_name = classname(route.name + '_exception')
        builder_name = builder_class_name(route)
        builder_fn_name = builder_method_name(route)
        style = route.attrs.get('style', 'rpc')
        if style == 'upload':
            doc_out(
                'The {@link com.dropbox.core.v2.DbxUploadStyleBuilder} '
                'returned by {@link #%s}.' % builder_fn_name
            )
            result_name = maptype(namespace, route.response_data_type)
            error_name = maptype(namespace, route.error_data_type)
            resname = 'Object' if result_name == 'void' else result_name
            errname = 'Object' if error_name == 'void' else error_name
            out('public final class %s extends DbxUploadStyleBuilder<%s,%s,%s>' %
                (builder_name, resname, errname, exc_name))
        elif style == 'download':
            doc_out(
                'The {@link com.dropbox.core.v2.DbxDownloadStyleBuilder} '
                'returned by {@link #%s}.' % builder_fn_name
            )
            result_name = maptype(namespace, route.response_data_type)
            resname = 'Object' if result_name == 'void' else result_name
            out('public final class %s extends DbxDownloadStyleBuilder<%s>' %
                (builder_name, resname))
        else:
            doc_out('The builder object returned by {@link #%s}' % builder_fn_name)
            out('public final class %s' % builder_name)
        with self.block():
            # Generate a field for every argument.
            all_args = [
                type_and_name(namespace, field)
                for field in route.request_data_type.all_fields
            ]
            for field in all_args:
                out('private %s;' % field)
            # Take every required argument in the constructor.
            req_fields = [
                type_and_name(namespace, field, boxed=False)
                for field in route.request_data_type.all_required_fields
            ]
            # The constructor is private and called by a helper method.
            out('')
            out('private %s(%s)' % (builder_name, ', '.join(req_fields)))
            with self.block():
                for field in route.request_data_type.all_required_fields:
                    fn = camelcase(field.name)
                    self.generate_field_validation(namespace, field, fn)
                    out('this.%s = %s;' % (fn, fn))
            # Create setter methods for each optional argument.
            for field in route.request_data_type.all_optional_fields:
                # Use underlying type since we don't want to allow nulls here
                dt, _ = get_underlying_type(field.data_type)
                arg_type = maptype(namespace, dt, boxed=False)
                arg_name = field_name(field)
                setter_name = camelcase(arg_name)
                out('')
                doc_out("Set value for optional request field {@code %s}." % arg_name,
                        fields=(field,))
                out('public %s %s(%s %s)' % (builder_name, setter_name,
                                             arg_type, arg_name))
                with self.block():
                    self.generate_field_validation(namespace, field, arg_name, omit_arg_name=True)
                    out('this.%s = %s;' % (arg_name, arg_name))
                    out('return this;')

            # Create a start() method to use the builder.
            out('')
            doc_out('Issues the request.')
            out('public %s start() throws %s, DbxException' % (rtype, exc_name))
            with self.block():
                packed_class = maptype(namespace, route.request_data_type)
                prefix = '%s.this.' % outer
                self.generate_call_to_packed_method(namespace, route, ret, prefix=prefix)

        # Generate the helper method used to construct the builder
        out('')
        doc_out(
            route.doc,
            fields=route.request_data_type.all_required_fields,
        )
        out('public %s %s(%s)' % (builder_name, builder_fn_name, ', '.join(req_fields)))
        with self.block():
            args = [field_name(field) for field
                    in route.request_data_type.all_required_fields]
            out('return new %s(%s);' % (builder_name, ", ".join(args)))

    def generate_route_stuff(self, namespace, route, outer, doc_out):
        self.emit('')
        self.generate_packed_method(namespace, route, doc_out)
        if is_struct_type(route.request_data_type):
            result_name = maptype(namespace, route.response_data_type)
            style = route.attrs.get('style', 'rpc')
            if style == 'upload':
                rtype = classname(route.name + '_uploader')
                ret = 'return '
                self.generate_builder(namespace, route, rtype, ret, outer, doc_out)
            elif style == 'download':
                rtype = 'com.dropbox.core.DbxDownloader<%s>' % result_name
                ret = 'return '
                self.generate_builder(namespace, route, rtype, ret, outer, doc_out)
            else:
                rtype = result_name
                ret = '' if rtype == 'void' else 'return '
                # Generate a shortcut with required args.
                self.generate_unpacked_method(namespace, route, rtype, ret, doc_out, required_only=True)
                n_optional = len(route.request_data_type.all_optional_fields)
                # Generate a builder if there are two or more optional args.
                # If there's only 1 optional argument then we might as well
                # just offer two overloaded methods.
                if n_optional == 1:
                    self.generate_unpacked_method(namespace, route, rtype, ret, doc_out)
                elif n_optional > 1:
                    self.generate_builder(namespace, route, rtype, ret, outer, doc_out)

    def generate_field_assignment(self, namespace, field):
        out = self.emit
        fn = field_name(field)
        if field.has_default:
            with self.block('if (%s != null)' % fn):
                if is_primitive_type(field.data_type):
                    # Extract the primitive value.
                    getter = '%sValue()' % field_type(namespace, field, boxed=False)
                    out('this.%s = %s.%s;' % (fn, fn, getter))
                else:
                    out('this.%s = %s;' % (fn, fn))
            with self.block('else'):
                # Fill in the default if null.
                value = mapvalue(namespace, field.data_type, field.default)
                out('this.%s = %s;' % (fn, value))
        else:
            out('this.%s = %s;' % (fn, fn))

    def generate_data_type_class(self, namespace, data_type, doc_out):
        """Generate a class definition for a datatype (a struct or a union)."""
        out = self.emit
        class_name = type_ref(namespace, data_type)
        out('')
        doc_out(data_type.doc)
        if is_union_type(data_type):
            self.generate_union(namespace, data_type, class_name, doc_out)
        else:
            # Struct.
            assert is_struct_type(data_type)
            decl = 'public static class %s' % class_name
            if data_type.parent_type:
                decl += ' extends %s ' % type_ref(namespace, data_type.parent_type)
            with self.block(decl):
                out('// struct %s' % class_name)
                # Generate fields declarations.
                for field in data_type.fields:
                    doc_out(field.doc)
                    out('public final %s;' % type_and_name(namespace, field, boxed=False))
                out('')

                # Generate the constructor.
                params = []
                for field in data_type.all_fields:
                    boxed = not is_primitive_type(field.data_type) or field.has_default
                    params.append(type_and_name(namespace,field, boxed))
                # repeat the class doc here
                doc_out(data_type.doc, fields=data_type.all_fields)
                with self.block('public %s(%s)' % (class_name, ', '.join(params))):
                    # Construct parent class.
                    if data_type.parent_type is not None:
                        parent_fields = [field_name(f) for f in data_type.parent_type.all_fields]
                        out('super(%s);' % ', '.join(parent_fields))
                    for field in data_type.fields:
                        self.generate_field_assignment(namespace, field)
                        self.generate_field_validation(namespace, field, field_name(field))

                # Generate JSON writer for struct.
                self.generate_json_writer(namespace, class_name, data_type)
                out('')

                # Generate JSON reader for struct.
                self.generate_json_reader(namespace, class_name, data_type)
                out('')

                # Generate toString(), toStringMultiline(), toJson(), fromJson() methods.
                with self.block('public String toString()'):
                    out('return "%s." + _writer.writeToString(this, false);' % class_name)
                out('')
                with self.block('public String toStringMultiline()'):
                    out('return "%s." + _writer.writeToString(this, true);' % class_name)
                out('')
                with self.block('public String toJson(Boolean longForm)'):
                    out('return _writer.writeToString(this, longForm);')
                out('')
                out('public static %s fromJson(String s)' % class_name)
                out('    throws JsonReadException')
                with self.block():
                    out('return _reader.readFully(s);')

    def generate_union(self, namespace, data_type, class_name, doc_out):
        """
        Generate code for a union.

        We treat both "simple" and "complex" unions the same (i.e. unions with no value tags and
        unions with at least one value tag).  This provides the following benefits:

            - Simpler generator code and Javadoc reference handling
            - Fewer breaking changes to 3rd party developers
            - Consistent mapping of union types to Java types (handle them all the same in 3rd party
              code)
        """
        out = self.emit
        with self.block('public static final class %s' % class_name):
            out('// union %s' % class_name)
            out('')
            # Generate a public enum named Tag.
            doc_out('The discriminating tag type for {@link %s}.' % class_name)
            tag_name = 'Tag'
            with self.block('public enum %s' % tag_name):
                self.generate_enum_values(data_type, doc_out, do_doc=True, last_sep='')
            out('')
            # Generate a public field holding the tag.
            doc_out('The discriminating tag for this instance.')
            out('public final %s tag;' % tag_name)
            out('')
            doc_out(
                """
                Returns the tag for this instance.

                This class is a tagged union.  Tagged unions instances are always associated to a
                specific tag.  Callers are recommended to use the tag value in a {@code switch}
                statement to determine how to properly handle this {@code %s}.
                """ % (class_name,),
                returns="the tag for this instance."
            )
            with self.block('public %s getTag()' % (tag_name,)):
                out('return this.tag;')

            # Generate values for each field.  All fields will be represented by
            # a set of functions:
            #
            #   creation: public static <class_name> fieldName(<optional field_data_type>)
            #   retrieval: public <field_data_type> asFieldName()
            #   verification: public boolean isFieldName()
            #
            # Simple fields will use singleton pattern for their values.
            unique_value_types = OrderedDict()  # Map type name -> value name
            constructors_made = OrderedDict()   # Map type name -> constructor_made
            for field in data_type.all_fields:
                if not is_simple_field(field):
                    type_name = maptype(namespace, field.data_type)
                    if type_name not in unique_value_types:
                        value_name = camelcase(field.name + '_value')
                        unique_value_types[type_name] = value_name
                        constructors_made[type_name] = False

            has_simple_field = False
            for field in data_type.all_fields:
                out('')

                field_name = camelcase(field.name)
                tag_field_name = allcaps(field.name)
                getter_name = camelcase('get_' + field.name + '_value')
                new_instance_name = field_name
                is_type_name = camelcase('is_' + field.name)

                if is_simple_field(field):
                    value_name = allcaps(field.name + '_instance')
                    has_simple_field = True
                    doc_out(field.doc)
                    out('private static final %s %s = new %s(%s.%s);' %
                        (class_name, value_name, class_name, tag_name, tag_field_name))
                else:
                    # For fields with values, define:
                    # - a private member to hold the value(*);
                    # - a private constructor(*);
                    # (*) Suppressed (shared) if a previous field uses the same type.
                    type_name = maptype(namespace, field.data_type)
                    javadoc_type_name = maptype(namespace, field.data_type, generics=False)
                    value_name = unique_value_types[type_name]
                    if not constructors_made[type_name]:
                        constructors_made[type_name] = True
                        out('private final %s %s;' % (type_name, value_name))
                        out('')
                        with self.block('private %s(%s tag, %s value)' %
                                        (class_name, tag_name, type_name)):
                            out('this.tag = tag;')
                            for other_value_name in unique_value_types.values():
                                if other_value_name == value_name:
                                    out('this.%s = value;' % value_name)
                                else:
                                    out('this.%s = null;' % other_value_name)
                            out('validate();')
                    else:
                        value_name = unique_value_types[type_name]
                        out('// Reusing %s for %s' % (value_name, field_name))

                    # retrieval
                    out('')
                    doc_out(
                        """
                        %s

                        This instance must be tagged as {@link %s#%s}.
                        """ % (field.doc, tag_name, tag_field_name),
                        returns="""
                        The {@link %s} value associated with this instance if {@link #%s} is
                        {@code true}.
                        """ % (javadoc_type_name, is_type_name),
                        throws={
                            "IllegalStateException": "If {@link #%s} is {@code false}." % (is_type_name,)
                        }
                    )
                    with self.block('public %s %s()' % (type_name, getter_name)):
                        with self.block('if (this.tag != %s.%s)' % (tag_name, tag_field_name)):
                            out('throw new IllegalStateException'
                                '("%s() requires tag==%s, actual tag==" + tag);' %
                                (getter_name, tag_field_name))
                        out('return %s;' % value_name)


                # new instance
                out('')
                doc_out(
                    """
                    Returns an instance of {@code %s} that has its tag set to {@link %s#%s}.

                    %s
                    """ % (class_name, tag_name, tag_field_name, field.doc),
                    params={
                        "value": "{@link %s} value to assign to this instance." % (javadoc_type_name,)
                    } if not is_simple_field(field) else {},
                    returns="""
                    Instance of {@code %s} with its tag set to {@link %s#%s}.
                    """ % (class_name, tag_name, tag_field_name),
                    throws=self.get_javadoc_throws_for_field_validation(field, "value")
                )
                if is_simple_field(field):
                    with self.block('public static %s %s()' % (class_name, new_instance_name)):
                        out('return %s.%s;' % (class_name, value_name))
                else:
                    with self.block('public static %s %s(%s value)' % (
                            class_name, new_instance_name, type_name
                    )):
                        out('return new %s(%s.%s, value);' % (
                            class_name, tag_name, tag_field_name
                        ))

                # is type
                out('')
                doc_out(
                    """
                    Returns {@code true} if this instance has the tag {@link %s#%s}, {@code false}
                    otherwise.
                    """ % (tag_name, tag_field_name),
                    returns=(
                        """
                        {@code true} if this instance is tagged as {@link %s#%s},
                        {@code false} otherwise.
                        """
                    ) % (tag_name, tag_field_name)
                )
                with self.block('public boolean %s()' % (is_type_name,)):
                    out('return this.tag == %s.%s;' % (tag_name, tag_field_name))

            out('')
            # Generate a private constructor to set the tag if we have any simple fields.
            if has_simple_field:
                with self.block('private %s(%s t)' % (class_name, tag_name)):
                    out('tag = t;')
                    for value_name in unique_value_types.values():
                        out('%s = null;' % value_name)
                    out('validate();')

            out('')
            with self.block('private final void validate()'):
                with self.block('switch (this.tag)'):
                    # A single no-op case for all simple fields.
                    cases = 0
                    for field in data_type.all_fields:
                        if is_simple_field(field):
                            out('case %s:' % allcaps(field.name))
                            cases += 1
                    if cases:
                        with self.indent():
                            out('break;')
                    # A separate case for each complex field.
                    for field in data_type.all_fields:
                        if not is_simple_field(field):
                            type_name = maptype(namespace, field.data_type)
                            value_name = 'this.' + unique_value_types[type_name]
                            out('case %s:' % allcaps(field.name))
                            with self.indent():
                                # TODO: Union fields may be optional but can't have defaults.
                                # Also, required union fields are already checked for null-ness
                                # when they are constructed, but the code here checks again.
                                # But refactoring all this to still share the hard work
                                # (doit()) is complicated.
                                self.generate_field_validation(namespace, field, value_name, omit_arg_name=True)
                                out('break;')

            # Generate JSON writer.
            out('')
            out('static final JsonWriter<%s> _writer = new JsonWriter<%s>()' %
                (class_name, class_name))
            with self.bsemi():
                out('public final void write(%s x, JsonGenerator g)' % class_name)
                out('  throws IOException')
                with self.block():
                    with self.block('switch (x.tag)'):
                        for field in data_type.all_fields:
                            out('case %s:' % allcaps(field.name))
                            with self.indent():
                                tn = maptype(namespace, field.data_type)
                                out('g.writeStartObject();')
                                out('g.writeFieldName(".tag");')
                                out('g.writeString("%s");' % field.name)
                                if not is_simple_field(field):
                                    vn = 'x.' + unique_value_types[tn]

                                    def doit(dt):
                                        if (is_struct_type(dt) and
                                                not dt.has_enumerated_subtypes()):
                                            # Collapse struct into union.
                                            out('%s._writer.writeFields(%s, g);' % (
                                                type_ref(namespace, dt), vn))
                                        else:
                                            self.generate_write_field(namespace, field, vn)

                                    if is_nullable_type(field.data_type):
                                        with self.block('if (%s != null)' % vn):
                                            doit(field.data_type.data_type)
                                    else:
                                        doit(field.data_type)
                                out('g.writeEndObject();')
                                out('break;')

            # Generate JSON reader.
            out('public static final JsonReader<%s> _reader = new JsonReader<%s>()' %
                (class_name, class_name))
            with self.bsemi():
                out('public final %s read(JsonParser parser)' % class_name)
                out('  throws IOException, JsonReadException')
                with self.block():
                    with self.block('if (parser.getCurrentToken() == JsonToken.VALUE_STRING)'):
                        out('String text = parser.getText();')
                        out('parser.nextToken();')
                        out('%s tag = _values.get(text);' % tag_name)
                        if data_type.catch_all_field is not None:
                            new_instance_name = camelcase(data_type.catch_all_field.name)
                            out('if (tag == null) { return %s.%s(); }' % (class_name, new_instance_name))
                        else:
                            with self.block('if (tag == null)'):
                                out('throw new JsonReadException'
                                    '("Unanticipated tag " + text + " without catch-all", '
                                    'parser.getTokenLocation());')
                        with self.block('switch (tag)'):
                            for field in data_type.all_fields:
                                new_instance_name = camelcase(field.name)
                                if is_simple_field(field):
                                    out('case %s: return %s.%s();' %
                                        (allcaps(field.name), class_name, new_instance_name))
                                elif is_nullable_type(field.data_type):
                                    out('case %s: return %s.%s(null);' %
                                        (allcaps(field.name), class_name, new_instance_name))
                        out('throw new JsonReadException("Tag " + tag + " requires a value", '
                            'parser.getTokenLocation());')
                    # Else expect either {".tag": <tag>} or {".tag": <tag>, <tag>: <value>}.
                    out('JsonReader.expectObjectStart(parser);')
                    out('String[] tags = readTags(parser);')
                    out('assert tags != null && tags.length == 1;')
                    out('String text = tags[0];')
                    out('%s tag = _values.get(text);' % tag_name)
                    out('%s value = null;' % class_name)
                    with self.block('if (tag != null)'):
                        with self.block('switch (tag)'):
                            for field in data_type.all_fields:
                                with self.block('case %s:' % allcaps(field.name)):
                                    new_instance_name = camelcase(field.name)
                                    if is_simple_field(field):
                                        out('value = %s.%s();' % (class_name, new_instance_name))
                                        # Expect nothing more.
                                    else:
                                        dt = field.data_type
                                        if is_nullable_type(dt):
                                            with self.block('if (parser.getCurrentToken() == '
                                                            'JsonToken.END_OBJECT)'):
                                                out('break;')  # Null value is OK.
                                            dt = dt.data_type
                                        out('%s v = null;' % maptype(namespace, dt))
                                        if is_struct_type(dt) and not dt.has_enumerated_subtypes():
                                            # Collapse struct into union.
                                            out('v = %s._reader.readFields(parser);' %
                                                maptype(namespace, dt))
                                        else:
                                            out('assert parser.getCurrentToken() == '
                                                'JsonToken.FIELD_NAME;')
                                            out('text = parser.getText();')
                                            out('assert tags[0].equals(text);')
                                            out('parser.nextToken();')
                                            # TODO: generate_read_field() writes code using
                                            # readField() methods, which check for duplicate
                                            # fields. We can't have duplicate fields here, so
                                            # that code is useless.  Need to refactor
                                            # generate_read_field() more.
                                            self.generate_read_field(namespace, field, 'v')
                                        out('value = %s.%s(v);' % (class_name, new_instance_name))
                                    out('break;')
                    if data_type.catch_all_field is None:
                        with self.block('if (value == null)'):
                            out('throw new JsonReadException'
                                '("Unanticipated tag " + text, parser.getTokenLocation());')
                    out('JsonReader.expectObjectEnd(parser);')
                    if data_type.catch_all_field is not None:
                        new_instance_name = camelcase(data_type.catch_all_field.name)
                        out('if (value == null) { return %s.%s(); }' % (class_name, new_instance_name))
                    out('return value;')
                out('')

            self.generate_static_values(data_type, tag_name, tag_name + '.')
            out('')

            # Generate toString(), toStringMultiline(), toJson(), fromJson() methods.
            with self.block('public String toString()'):
                out('return "%s." + _writer.writeToString(this, false);' % class_name)
            with self.block('public String toStringMultiline()'):
                out('return "%s." +  _writer.writeToString(this, true);' % class_name)
            with self.block('public String toJson(Boolean longForm)'):
                out('return _writer.writeToString(this, longForm);')
            out('public static %s fromJson(String s)' % class_name)
            out('    throws JsonReadException')
            with self.block():
                out('return _reader.readFully(s);')

    def generate_static_values(self, data_type, class_name, value_prefix=''):
        """Generate _values Map with static initializer (used by JSON reader)."""
        out = self.emit
        out('private static final java.util.HashMap<String,%s> _values;' % class_name)
        with self.block('static'):
            out('_values = new java.util.HashMap<String,%s>();' % class_name)
            for field in data_type.fields:
                out('_values.put("%s", %s%s);' % (field.name, value_prefix, allcaps(field.name)))

    def generate_enum_values(self, data_type, doc_out, do_doc=False, last_sep=';'):
        """Generate enum values."""
        out = self.emit
        count = len(data_type.all_fields)
        for i, field in enumerate(data_type.all_fields):
            if do_doc:
                doc_out(field.doc)
            if i + 1 == count:
                sep = last_sep
            else:
                sep = ','
            if field is data_type.catch_all_field:
                assert isinstance(field.data_type, Void), field.data_type
                sep += '  // *catch_all'
            elif not isinstance(field.data_type, Void):
                sep += '  // %s' % field.data_type.name
            out(allcaps(field.name) + sep)

    def generate_json_writer(self, namespace, class_name, data_type):
        """Generate the JsonWriter for a struct class."""
        out = self.emit
        if data_type.is_member_of_enumerated_subtypes_tree():
            # Accessor for the writer (bridge for strunion writing).
            with self.block('public JsonWriter getWriter()'):
                out('return %s._writer;' % class_name)
        out('')
        out('static final JsonWriter<%s> _writer = new JsonWriter<%s>()' %
            (class_name, class_name))
        with self.bsemi():
            ancestors = get_ancestors(data_type)
            out('public final void write(%s x, JsonGenerator g)' % class_name)
            out(' throws IOException')
            with self.block():
                if data_type.is_member_of_enumerated_subtypes_tree():
                    out('JsonWriter w = x.getWriter();')
                    with self.block('if (w != this)'):
                        out('w.write(x, g);')
                        out('return;')
                out('g.writeStartObject();')
                tags = [tag for tag, _ in ancestors if tag]
                if tags:
                    out('g.writeStringField(".tag", "%s");' % '.'.join(tags))
                for _, dt in ancestors:
                    out('%s._writer.writeFields(x, g);' % type_ref(namespace, dt))
                out('g.writeEndObject();')

            out('public final void writeFields(%s x, JsonGenerator g)' % class_name)
            out(' throws IOException')
            with self.block():
                for field in data_type.fields:
                    var_name = 'x.' + camelcase(field.name)
                    if is_nullable_type(field.data_type):
                        with self.block('if (%s != null)' % var_name):
                            self.generate_write_field(namespace, field, var_name)
                    else:
                        self.generate_write_field(namespace, field, var_name)

    def generate_write_field(self, namespace, field, var_name):
        """Generate code to write a single field."""
        out = self.emit
        ft = field.data_type
        # For strings, numbers and booleans use a shorthand method.
        if is_string_type(ft):
            out('g.writeStringField("%s", %s);' % (field.name, var_name))
        elif is_numeric_type(ft):
            out('g.writeNumberField("%s", %s);' % (field.name, var_name))
        elif is_boolean_type(ft):
            out('g.writeBooleanField("%s", %s);' % (field.name, var_name))
        else:
            # General case.
            out('g.writeFieldName("%s");' % field.name)
            self.generate_write_value(namespace, field.data_type, var_name)

    def generate_write_value(self, namespace, data_type, var_name, level=0):
        """Generate code to write a single value."""
        out = self.emit
        nullable = is_nullable_type(data_type)
        if nullable:
            data_type = data_type.data_type
        if is_string_type(data_type):
            out('g.writeString(%s);' % var_name)
        elif is_numeric_type(data_type):
            out('g.writeNumber(%s);' % var_name)
        elif is_boolean_type(data_type):
            out('g.writeBoolean(%s);' % var_name)
        elif is_composite_type(data_type):
            out('%s._writer.write(%s, g);' % (maptype(namespace, data_type), var_name))
        elif is_timestamp_type(data_type):
            out('writeDateIso(%s, g);' % var_name)
        elif is_binary_type(data_type):
            out('g.writeString(com.dropbox.core.util.StringUtil.base64Encode(%s));' % var_name)
        elif is_list_type(data_type):
            item_name = 'item' if level == 0 else 'item%d' % level
            out('g.writeStartArray();')
            with self.block('for (%s %s: %s)' %
                            (maptype(namespace, data_type.data_type), item_name, var_name)):
                with self.block('if (%s != null)' % item_name):
                    self.generate_write_value(namespace, data_type.data_type, item_name, level+1)
            out('g.writeEndArray();')
        else:
            out('throw new IOException("XXX Don\'t know how to write a %s");' %
                maptype(namespace, data_type))

    def generate_json_reader(self, namespace, class_name, data_type):
        """Generate the JsonReader for a struct class."""
        out = self.emit
        with self.bsemi('public static final JsonReader<%s> _reader = new JsonReader<%s>()' %
                        (class_name, class_name)):

            out('')
            out('public final %s read(JsonParser parser)' % class_name)
            out('    throws IOException, JsonReadException')
            with self.block():
                out('%s result;' % class_name)
                out('JsonReader.expectObjectStart(parser);')
                if data_type.is_member_of_enumerated_subtypes_tree():
                    # We need the .tag field first.
                    out('String[] tags = readTags(parser);')
                    out('result = readFromTags(tags, parser);')
                else:
                    out('result = readFields(parser);')
                out('JsonReader.expectObjectEnd(parser);')
                out('return result;')

            if data_type.is_member_of_enumerated_subtypes_tree():
                out('')
                out('public final %s readFromTags(String[] tags, JsonParser parser)' % class_name)
                out('    throws IOException, JsonReadException')
                with self.block():
                    ancestors = get_ancestors(data_type)
                    depth = len(ancestors) - 1
                    if depth >= 1:
                        with self.block('if (tags != null)'):
                            out('assert tags.length >= %d;' % depth)
                            for i, (tag, dt) in enumerate(ancestors[1:]):
                                out('assert "%s".equals(tags[%d]);' % (tag, i))
                    if data_type.has_enumerated_subtypes():
                        with self.block('if (tags != null && tags.length > %d)' % depth):
                            for field in data_type.get_enumerated_subtypes():
                                with self.block('if ("%s".equals(tags[%d]))' % (field.name, depth)):
                                    out('return %s._reader.readFromTags(tags, parser);' %
                                        type_ref(namespace, field.data_type))
                            out('// If no match, fall back to base class')
                    out('return readFields(parser);')

            out('')
            out('public final %s readFields(JsonParser parser)' % class_name)
            out('    throws IOException, JsonReadException')
            with self.block():
                for field in data_type.all_fields:
                    out('%s = null;' % type_and_name(namespace, field))
                with self.block('while (parser.getCurrentToken() == JsonToken.FIELD_NAME)'):
                    out('String fieldName = parser.getCurrentName();')
                    out('parser.nextToken();')
                    pfx = ''  # This becomes 'else ' after the first field.
                    for field in data_type.all_fields:
                        with self.block('%sif ("%s".equals(fieldName))' %
                                        (pfx, field.name)):
                            pfx = 'else '
                            self.generate_read_field(namespace, field,
                                                     '%s' % field_name(field))
                    out('%s{ JsonReader.skipValue(parser); }' % pfx)
                # Validate required fields.
                for field in data_type.all_required_fields:
                    with self.block('if (%s == null)' % field_name(field)):
                        out('throw new JsonReadException('
                            '\"Required field \\\"%s\\\" is missing.\", '
                            'parser.getTokenLocation());' % field.name)
                field_names = [field_name(field) for field in data_type.all_fields]
                out('return new %s(%s);' % (class_name, ', '.join(field_names)))

    def generate_field_validation(self, namespace, field, value_name, omit_arg_name=False):
        """Generate validation code for one field.
        """
        out = self.emit

        def todo(ft):
            """Decide whether doit() will emit any code."""
            if is_composite_type(ft):
                return False
            if is_list_type(ft):
                return True
            if is_numeric_type(ft):
                return ft.min_value is not None or ft.max_value is not None
            if is_string_type(ft):
                return (ft.min_length is not None or ft.max_length is not None or
                        ft.pattern is not None)
            if is_boolean_type(ft) or is_timestamp_type(ft) or is_binary_type(ft):
                return False
            return True

        def doit(ft, vn, dn=None, omit_arg_name=False, level=0):
            """Actually emit the validation code for the field.

            ft: field type
            vn: variable name
            dn: optional display name (defaults to vn)
            level: optional recursion level

            Note: This is recursive for list types.
            """
            if dn is None:
                dn = vn
            if omit_arg_name:
                dn = ""
            else:
                dn = " '%s'" % (dn,)

            if is_list_type(ft):
                if ft.min_items is not None:
                    with self.block('if (%s.size() < %s)' % (vn, mapvalue(namespace,
                                                                          ft, ft.min_items))):
                        out('throw new IllegalArgumentException("List%s has fewer than %s items");' %
                            (dn, mapvalue(namespace, ft, ft.min_items)))
                if ft.max_items is not None:
                    with self.block('if (%s.size() > %s)' % (vn, mapvalue(namespace,
                                                                          ft, ft.max_items))):
                        out('throw new IllegalArgumentException("List%s has more than %s items");' %
                            (dn, mapvalue(namespace, ft, ft.max_items)))
                xn = 'x' if level == 0 else 'x%d' % level
                with self.block('for (%s %s : %s)' % (maptype(namespace, ft.data_type), xn, vn)):
                    with self.block('if (%s == null)' % xn):
                        out('throw new IllegalArgumentException("An item in list%s is null");' % dn)
                    doit(ft.data_type, xn, 'an item in list%s' % dn, level+1)
            elif is_numeric_type(ft):
                if ft.min_value is not None:
                    with self.block('if (%s < %s)' % (vn, mapvalue(namespace, ft, ft.min_value))):
                        out('throw new IllegalArgumentException("Number%s is smaller than %s");' %
                            (dn, mapvalue(namespace, ft, ft.min_value)))
                if ft.max_value is not None:
                    with self.block('if (%s > %s)' % (vn, mapvalue(namespace, ft, ft.max_value))):
                        out('throw new IllegalArgumentException("Number%s is larger than %s");' %
                            (dn, mapvalue(namespace, ft, ft.max_value)))
            elif is_string_type(ft):
                if ft.min_length is not None:
                    with self.block('if (%s.length() < %d)' % (vn, ft.min_length)):
                        out('throw new IllegalArgumentException("String%s is shorter than %s");' %
                            (dn, mapvalue(namespace, ft, ft.min_length)))
                if ft.max_length is not None:
                    with self.block('if (%s.length() > %d)' % (vn, ft.max_length)):
                        out('throw new IllegalArgumentException("String%s is longer than %s");' %
                            (dn, mapvalue(namespace, ft, ft.max_length)))
                if ft.pattern is not None:
                    # TODO: Save the pattern as a static variable.
                    # NOTE: pattern should match against entire input sequence
                    with self.block('if (!java.util.regex.Pattern.matches("%s", %s))' %
                                    (ft.pattern.replace('\\', '\\\\'), vn)):
                        out('throw new IllegalArgumentException("String%s does not match pattern");' %
                            dn)
            elif is_composite_type(ft) or is_boolean_type(ft) or \
                    is_timestamp_type(ft) or is_binary_type(ft):
                pass  # Nothing to do for these
            else:
                out('throw new RuntimeException("XXX Don\'t know how to validate %s: type %s");' %
                    (dn, ft.name))

        ft, nullable = get_underlying_type(field.data_type)
        vn = value_name
        if nullable:
            if todo(ft):
                with self.block('if (%s != null)' % vn):
                    doit(ft, vn, omit_arg_name=omit_arg_name)
            else:
                # No validation required for this nullable field.
                pass
        elif is_primitive_type(ft) or (isinstance(field, StructField) and field.has_default):
            # Don't need to check primitive/default types for null.
            # The 'this.' means that we refer to the unboxed value.
            doit(ft, 'this.'+vn, omit_arg_name=omit_arg_name)
        else:
            with self.block('if (%s == null)' % vn):
                if omit_arg_name:
                    out('throw new IllegalArgumentException("Value is null");')
                else:
                    out('throw new IllegalArgumentException("Required value for \'%s\' is null");' %
                        camelcase(field.name))
            doit(ft, vn, omit_arg_name=omit_arg_name)

    def generate_read_field(self, namespace, field, var_name):
        """Generate the code to read one field."""
        out = self.emit
        ft = field.data_type
        out('%s = %s' % (var_name, mapreader(namespace, ft)))
        with self.indent():
            out('.readField(parser, "%s", %s);' % (field.name, var_name))

    def generate_javadoc(self, doc, params=None, returns=None, throws=None):
        out = self.emit
        prefix = ' * '
        attr_doc_prefix = prefix + (' ' * 4)

        if not any((doc, params, returns, throws)):
            return

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
                self.emit_wrapped_text(paragraph, initial_prefix=prefix, subsequent_prefix=prefix)

        def emit_attrs(tag, attrs):
            if attrs:
                out(prefix.rstrip())
                attr_prefix = ''.join((prefix, tag, ' '))

                for attr_name, attr_doc in attrs.items():
                    # Javadoc complains about tags that are missing documentation
                    if not attr_doc:
                        continue

                    if attr_name:
                        doc_text = '  '.join((attr_name, attr_doc))
                    else:
                        doc_text = attr_doc
                    self.emit_wrapped_text(
                        collapse_whitespace(doc_text),
                        initial_prefix=attr_prefix,
                        subsequent_prefix=attr_doc_prefix
                    )

        emit_attrs('@param', params)
        emit_attrs('@return', { "": returns } if returns else None)
        emit_attrs('@throws', throws)

        out(' */')

    def translate_babel_doc(self, api, namespace, doc, data_type=None, link_local_fields=True):
        if doc:
            handler = lambda tag, val: doc_ref_handler(tag, val, api, namespace, data_type, link_local_fields=link_local_fields)
            return self.process_doc(doc, handler)
        else:
            return doc

    def get_field_validation_requirements(self, field, as_failure_reasons=False):
        if is_simple_field(field):
            return None

        ft, nullable = get_underlying_type(field.data_type)
        requirements = []
        def add_req(precondition, failure_reason):
            if as_failure_reasons:
                requirements.append(failure_reason)
            else:
                requirements.append(precondition)

        for condition, (precondition, failure_reason) in (
                ("min_items", ("contain at least %s items", "has fewer than %s items")),
                ("max_items", ("contain at most %s items", "has more than %s items")),
                ("min_value", ("be greater than or equal to %s", "is less than %s")),
                ("max_value", ("be less than or equal to %s", "is greater than %s")),
                ("min_length", ("have length of at least %s", "is shorter than %s")),
                ("max_length", ("have length of at most %s", "is longer than %s"))
        ):
            if hasattr(ft, condition):
                val = getattr(ft, condition)
                if val is not None:
                    add_req(precondition % val, failure_reason % val)

        if is_list_type(ft):
            add_req("not contain a {@code null} item",
                    "contains a {@code null} item")
        elif is_string_type(ft) and ft.pattern is not None:
            pattern = ft.pattern.replace('\\', '\\\\')
            add_req('match pattern "{@code %s}"' % pattern,
                    'does not match pattern "{@code %s}"' % pattern)

        has_default = isinstance(field, StructField) and field.has_default
        if not (nullable or is_primitive_type(ft) or has_default):
            add_req("not be {@code null}",
                    "is {@code null}")

        return requirements

    def get_javadoc_throws_for_field_validation(self, field, value_name):
        reasons = self.get_field_validation_requirements(field, as_failure_reasons=True)
        if not reasons:
            return {}

        reasons_list = oxford_comma_list(reasons, conjunction='or')
        return {
            "IllegalArgumentException": "if {@code %s} %s." % (value_name, reasons_list)
        }

    def get_javadoc_params_for_fields(self, api, namespace, fields, data_type=None):
        if not fields:
            return {}

        params = OrderedDict()
        for field in fields:
            param_name = field_name(field)
            param_babel_doc = field_doc(field) or ''
            # @param documentation should not create awkward links to class fields in constructors or route methods.
            param_doc = self.translate_babel_doc(
                api, namespace, param_babel_doc, data_type=data_type, link_local_fields=False
            )
            if not param_doc.endswith('.'):
                param_doc += '.'
            preconditions = self.get_field_validation_requirements(field)
            if preconditions:
                preconditions_list = oxford_comma_list(preconditions, conjunction='and')
                param_doc += " {@code %s} must %s." % (param_name, preconditions_list)

            params[param_name] = param_doc

        return params

    def generate_doc(self, api, namespace, doc, data_type=None, fields=(), params=None, returns=None, throws=None):
        """Generate a Javadoc comment from Babel doc string."""
        out = self.emit
        if doc or fields:
            doc = self.translate_babel_doc(api, namespace, doc, data_type=data_type)
            params_doc = {
                k: self.translate_babel_doc(api, namespace, v, data_type=data_type)
                for k, v in (params or {}).items()
            }
            params_doc.update(self.get_javadoc_params_for_fields(api, namespace, fields, data_type=data_type))
            returns_doc = self.translate_babel_doc(api, namespace, returns, data_type=data_type)
            throws_doc = {
                k: self.translate_babel_doc(api, namespace, v, data_type=data_type)
                for k, v in (throws or {}).items()
            }
            requires_validation = any(self.get_field_validation_requirements(f) for f in fields)
            if requires_validation and "IllegalArgumentException" not in throws_doc:
                throws_doc["IllegalArgumentException"] = "if any argument does not meet its preconditions."
            self.generate_javadoc(doc, params=params_doc, returns=returns_doc, throws=throws_doc)
