from __future__ import absolute_import, division, print_function, unicode_literals

import textwrap

MYPY = False
if MYPY:
    import typing  # noqa: F401 # pylint: disable=import-error,unused-import,useless-suppression

import unittest
try:
    # Works for Py 3.3+
    from unittest.mock import Mock
except ImportError:
    # See https://github.com/python/mypy/issues/1153#issuecomment-253842414
    from mock import Mock  # type: ignore

from stone.ir import (
    Alias,
    Api,
    ApiNamespace,
    Boolean,
    List,
    Map,
    Nullable,
    String,
    Struct,
    StructField,
    Timestamp,
    UInt64,
    Union,
    UnionField,
    Void,
    Float64)
from stone.ir.api import ApiRoute
from stone.backends.python_type_stubs import PythonTypeStubsBackend


ISO_8601_FORMAT = "%Y-%m-%dT%H:%M:%SZ"

def _make_backend():
    # type: () -> PythonTypeStubsBackend
    return PythonTypeStubsBackend(
        target_folder_path=Mock(),
        args=['--package', 'output'],
    )

def _make_namespace_with_alias():
    # type: (...) -> ApiNamespace
    ns = ApiNamespace('ns_with_alias')

    struct1 = Struct(name='Struct1', namespace=ns, ast_node=None)
    struct1.set_attributes(None, [StructField('f1', Boolean(), None, None)])
    ns.add_data_type(struct1)

    alias = Alias(name='AliasToStruct1', namespace=ns, ast_node=None)
    alias.set_attributes(doc=None, data_type=struct1)
    ns.add_alias(alias)

    str_type = String(min_length=3)
    str_alias = Alias(name='NotUserDefinedAlias', namespace=ns, ast_node=None)
    str_alias.set_attributes(doc=None, data_type=str_type)
    ns.add_alias(str_alias)

    return ns

def _make_namespace_with_many_structs():
    # type: (...) -> ApiNamespace
    ns = ApiNamespace('ns_with_many_structs')

    struct1 = Struct(name='Struct1', namespace=ns, ast_node=None)
    struct1.set_attributes(None, [StructField('f1', Boolean(), None, None)])
    ns.add_data_type(struct1)

    struct2 = Struct(name='Struct2', namespace=ns, ast_node=None)
    struct2.set_attributes(
        doc=None,
        fields=[
            StructField('f2', List(UInt64()), None, None),
            StructField('f3', Timestamp(ISO_8601_FORMAT), None, None),
            StructField('f4', Map(String(), UInt64()), None, None)
        ]
    )
    ns.add_data_type(struct2)

    return ns

def _make_namespace_with_nested_types():
    # type: (...) -> ApiNamespace
    ns = ApiNamespace('ns_w_nested_types')

    struct = Struct(name='NestedTypes', namespace=ns, ast_node=None)
    struct.set_attributes(
        doc=None,
        fields=[
            StructField(
                name='NullableList',
                data_type=Nullable(
                    List(UInt64())
                ),
                doc=None,
                ast_node=None,
            ),
            StructField(
                name='ListOfNullables',
                data_type=List(
                    Nullable(UInt64())
                ),
                doc=None,
                ast_node=None,
            )
        ]
    )
    ns.add_data_type(struct)

    return ns

def _make_namespace_with_a_union():
    # type: (...) -> ApiNamespace
    ns = ApiNamespace('ns_with_a_union')

    u1 = Union(name='Union', namespace=ns, ast_node=None, closed=True)
    u1.set_attributes(
        doc=None,
        fields=[
            UnionField(
                name="first",
                doc=None,
                data_type=Void(),
                ast_node=None
            ),
            UnionField(
                name="last",
                doc=None,
                data_type=Void(),
                ast_node=None
            ),
        ],
    )
    ns.add_data_type(u1)

    # A more interesting case with non-void variants.
    shape_union = Union(name='Shape', namespace=ns, ast_node=None, closed=True)
    shape_union.set_attributes(
        doc=None,
        fields=[
            UnionField(
                name="point",
                doc=None,
                data_type=Void(),
                ast_node=None
            ),
            UnionField(
                name="circle",
                doc=None,
                data_type=Float64(),
                ast_node=None
            ),
        ],
    )
    ns.add_data_type(shape_union)

    return ns

def _make_namespace_with_empty_union():
    # type: (...) -> ApiNamespace
    ns = ApiNamespace('ns_with_empty_union')

    union = Union(name='EmptyUnion', namespace=ns, ast_node=None, closed=True)
    union.set_attributes(
        doc=None,
        fields=[],
    )
    ns.add_data_type(union)

    return ns

def _make_namespace_with_route():
    # type: (...) -> ApiNamespace
    ns = ApiNamespace("_make_namespace_with_route()")
    mock_ast_node = Mock()
    route_one = ApiRoute(
        name="route_one",
        version=1,
        ast_node=mock_ast_node,
    )
    route_two = ApiRoute(
        name="route_one",
        version=2,
        ast_node=mock_ast_node,
    )
    ns.add_route(route_one)
    ns.add_route(route_two)
    return ns

def _make_namespace_with_route_name_conflict():
    # type: (...) -> ApiNamespace
    ns = ApiNamespace("_make_namespace_with_route()")
    mock_ast_node = Mock()
    route_one = ApiRoute(
        name="route_one_v2",
        version=1,
        ast_node=mock_ast_node,
    )
    route_two = ApiRoute(
        name="route_one",
        version=2,
        ast_node=mock_ast_node,
    )
    ns.add_route(route_one)
    ns.add_route(route_two)
    return ns

def _make_namespace_with_nullable_and_dafault_fields():
    # type: (...) -> ApiNamespace
    ns = ApiNamespace('ns_w_nullable__fields')

    struct = Struct(name='Struct1', namespace=ns, ast_node=None)
    default_field = StructField(
                        name='DefaultField',
                        data_type=UInt64(),
                        doc=None,
                        ast_node=None,
                    )
    default_field.set_default(1)
    struct.set_attributes(
        doc=None,
        fields=[
            StructField(
                name='NullableField',
                data_type=Nullable(
                    UInt64()
                ),
                doc=None,
                ast_node=None,
            ),
            default_field,
            StructField(
                name='RequiredField',
                data_type=UInt64(),
                doc=None,
                ast_node=None,
            )
        ]
    )
    ns.add_data_type(struct)

    return ns

def _api():
    api = Api(version="1.0")
    return api

_headers = """\
# -*- coding: utf-8 -*-
# Auto-generated by Stone, do not modify.
# @generated
# flake8: noqa
# pylint: skip-file

{}
from stone.backends.python_rsrc import stone_base as bb  # type: ignore
from stone.backends.python_rsrc import stone_validators as bv  # type: ignore

T = TypeVar('T', bound=bb.AnnotationType)
U = TypeVar('U')"""

class TestPythonTypeStubs(unittest.TestCase):
    def __init__(self, *args, **kwargs):
        super(TestPythonTypeStubs, self).__init__(*args, **kwargs)
        self.maxDiff = 1000000  # Increase text diff size

    def _evaluate_namespace(self, ns):
        # type: (ApiNamespace) -> typing.Text
        backend = _make_backend()
        backend._generate_base_namespace_module(ns)
        return backend.output_buffer_to_string()

    def test__generate_base_namespace_module__with_many_structs(self):
        # type: () -> None
        ns = _make_namespace_with_many_structs()
        result = self._evaluate_namespace(ns)
        expected = textwrap.dedent("""\
            {headers}

            class Struct1(bb.Struct):
                def __init__(self,
                             f1: bool = ...) -> None: ...
                f1: bb.Attribute[bool] = ...
                def _process_custom_annotations(
                    self,
                    annotation_type: Type[T],
                    field_path: Text,
                    processor: Callable[[T, U], U],
                ) -> None: ...

            Struct1_validator: bv.Validator = ...

            class Struct2(bb.Struct):
                def __init__(self,
                             f2: List[int] = ...,
                             f3: datetime.datetime = ...,
                             f4: Dict[Text, int] = ...) -> None: ...
                f2: bb.Attribute[List[int]] = ...
                f3: bb.Attribute[datetime.datetime] = ...
                f4: bb.Attribute[Dict[Text, int]] = ...
                def _process_custom_annotations(
                    self,
                    annotation_type: Type[T],
                    field_path: Text,
                    processor: Callable[[T, U], U],
                ) -> None: ...

            Struct2_validator: bv.Validator = ...

            """).format(headers=_headers.format(textwrap.dedent("""\
                from typing import (
                    Callable,
                    Dict,
                    List,
                    Text,
                    Type,
                    TypeVar,
                )

                import datetime""")))
        self.assertEqual(result, expected)

    def test__generate_base_namespace_module__with_nested_types(self):
        # type: () -> None
        ns = _make_namespace_with_nested_types()
        result = self._evaluate_namespace(ns)
        expected = textwrap.dedent("""\
            {headers}

            class NestedTypes(bb.Struct):
                def __init__(self,
                             list_of_nullables: List[Optional[int]] = ...,
                             nullable_list: Optional[List[int]] = ...) -> None: ...
                list_of_nullables: bb.Attribute[List[Optional[int]]] = ...
                nullable_list: bb.Attribute[Optional[List[int]]] = ...
                def _process_custom_annotations(
                    self,
                    annotation_type: Type[T],
                    field_path: Text,
                    processor: Callable[[T, U], U],
                ) -> None: ...

            NestedTypes_validator: bv.Validator = ...

            """).format(headers=_headers.format(textwrap.dedent("""\
                from typing import (
                    Callable,
                    List,
                    Optional,
                    Text,
                    Type,
                    TypeVar,
                )""")))
        self.assertEqual(result, expected)

    def test__generate_base_namespace_module_with_union__generates_stuff(self):
        # type: () -> None
        ns = _make_namespace_with_a_union()
        result = self._evaluate_namespace(ns)
        expected = textwrap.dedent("""\
            {headers}

            class Union(bb.Union):
                first: Union = ...
                last: Union = ...

                def is_first(self) -> bool: ...

                def is_last(self) -> bool: ...

                def _process_custom_annotations(
                    self,
                    annotation_type: Type[T],
                    field_path: Text,
                    processor: Callable[[T, U], U],
                ) -> None: ...

            Union_validator: bv.Validator = ...

            class Shape(bb.Union):
                point: Shape = ...

                def is_point(self) -> bool: ...

                def is_circle(self) -> bool: ...

                @classmethod
                def circle(cls, val: float) -> Shape: ...

                def get_circle(self) -> float: ...

                def _process_custom_annotations(
                    self,
                    annotation_type: Type[T],
                    field_path: Text,
                    processor: Callable[[T, U], U],
                ) -> None: ...

            Shape_validator: bv.Validator = ...

            """).format(headers=_headers.format(textwrap.dedent("""\
                from typing import (
                    Callable,
                    Text,
                    Type,
                    TypeVar,
                )""")))
        self.assertEqual(result, expected)

    def test__generate_base_namespace_module_with_empty_union(self):
        # type: () -> None
        ns = _make_namespace_with_empty_union()
        result = self._evaluate_namespace(ns)
        expected = textwrap.dedent("""\
            {headers}

            class EmptyUnion(bb.Union):
                def _process_custom_annotations(
                    self,
                    annotation_type: Type[T],
                    field_path: Text,
                    processor: Callable[[T, U], U],
                ) -> None: ...

            EmptyUnion_validator: bv.Validator = ...

            """).format(headers=_headers.format(textwrap.dedent("""\
                from typing import (
                    Callable,
                    Text,
                    Type,
                    TypeVar,
                )""")))
        self.assertEqual(result, expected)

    def test__generate_routes(self):
        # type: () -> None
        ns = _make_namespace_with_route()
        result = self._evaluate_namespace(ns)
        expected = textwrap.dedent("""\
            {headers}

            route_one: bb.Route = ...
            route_one_v2: bb.Route = ...

            """).format(headers=_headers.format(textwrap.dedent("""\
                from typing import (
                    TypeVar,
                )""")))
        self.assertEqual(result, expected)

    def test__generate_routes_name_conflict(self):
        # type: () -> None
        ns = _make_namespace_with_route_name_conflict()

        with self.assertRaises(RuntimeError) as cm:
            self._evaluate_namespace(ns)
        self.assertEqual(
            'There is a name conflict between {!r} and {!r}'.format(ns.routes[0], ns.routes[1]),
            str(cm.exception))

    def test__generate_base_namespace_module__with_alias(self):
        # type: () -> None
        ns = _make_namespace_with_alias()
        result = self._evaluate_namespace(ns)
        expected = textwrap.dedent("""\
            {headers}

            class Struct1(bb.Struct):
                def __init__(self,
                             f1: bool = ...) -> None: ...
                f1: bb.Attribute[bool] = ...
                def _process_custom_annotations(
                    self,
                    annotation_type: Type[T],
                    field_path: Text,
                    processor: Callable[[T, U], U],
                ) -> None: ...

            Struct1_validator: bv.Validator = ...

            AliasToStruct1_validator: bv.Validator = ...
            AliasToStruct1 = Struct1
            NotUserDefinedAlias_validator: bv.Validator = ...
            """).format(headers=_headers.format(textwrap.dedent("""\
                from typing import (
                    Callable,
                    Text,
                    Type,
                    TypeVar,
                )""")))
        self.assertEqual(result, expected)

    def test__generate_base_namespace_module__with_nullable_and_default_fields(self):
        # type: () -> None
        """
        Make sure that only Nullable fields and fields with default values are Optional in mypy
        """
        ns = _make_namespace_with_nullable_and_dafault_fields()
        result = self._evaluate_namespace(ns)
        expected = textwrap.dedent("""\
            {headers}

            class Struct1(bb.Struct):
                def __init__(self,
                             required_field: int = ...,
                             nullable_field: Optional[int] = ...,
                             default_field: Optional[int] = ...) -> None: ...
                required_field: bb.Attribute[int] = ...
                nullable_field: bb.Attribute[Optional[int]] = ...
                default_field: bb.Attribute[int] = ...
                def _process_custom_annotations(
                    self,
                    annotation_type: Type[T],
                    field_path: Text,
                    processor: Callable[[T, U], U],
                ) -> None: ...

            Struct1_validator: bv.Validator = ...

            """).format(headers=_headers.format(textwrap.dedent("""\
                from typing import (
                    Callable,
                    Optional,
                    Text,
                    Type,
                    TypeVar,
                )""")))
        self.assertEqual(expected, result)
