from __future__ import absolute_import, division, print_function, unicode_literals

import textwrap

MYPY = False
if MYPY:
    import typing  # noqa: F401 # pylint: disable=import-error,unused-import,useless-suppression

import os
import unittest
import subprocess
import sys
import shutil
try:
    # Works for Py 3.3+
    from unittest.mock import Mock
except ImportError:
    # See https://github.com/python/mypy/issues/1153#issuecomment-253842414
    from mock import Mock  # type: ignore

from stone.ir import (
    ApiNamespace,
    Boolean,
    Struct,
    StructField)
from stone.backends.tsd_types import TSDTypesBackend
from test.backend_test_util import _mock_output


def _make_backend(target_folder_path, template_path):
    # type: (typing.Text, typing.Text) -> TSDTypesBackend

    args = Mock()
    args.__iter__ = Mock(return_value=iter([template_path, "-i=0"]))

    return TSDTypesBackend(
        target_folder_path=str(target_folder_path),
        args=args
    )


def _make_namespace(ns_name="accounts"):
    # type: (typing.Text) -> ApiNamespace
    ns = ApiNamespace(ns_name)
    struct = _make_struct('User', 'exists', ns)
    ns.add_data_type(struct)
    return ns


def _make_struct(struct_name, struct_field_name, namespace):
    # type: (typing.Text, typing.Text, ApiNamespace) -> Struct
    struct = Struct(name=struct_name, namespace=namespace, ast_node=None)
    struct.set_attributes(None, [StructField(struct_field_name, Boolean(), None, None)])
    return struct


def _evaluate_namespace(backend, namespace_list):
    # type: (TSDTypesBackend, typing.List[ApiNamespace]) -> typing.Text

    get_result = _mock_output(backend)
    filename = "types.d.ts"
    backend.split_by_namespace = False
    backend._generate_base_namespace_module(namespace_list=namespace_list,
                                            filename=filename,
                                            extra_args={},
                                            template="""/*TYPES*/""",
                                            exclude_error_types=True)
    return get_result()


class TestTSDTypes(unittest.TestCase):
    def __init__(self, *args, **kwargs):
        super(TestTSDTypes, self).__init__(*args, **kwargs)
        self.maxDiff = None  # Increase text diff size

    def test__generate_types_single_ns(self):
        # type: () -> None
        backend = _make_backend(target_folder_path="output", template_path="")
        ns = _make_namespace()
        result = _evaluate_namespace(backend, [ns])
        expected = textwrap.dedent("""
        type Timestamp = string;

        namespace accounts {
          export interface User {
            exists: boolean;
          }

        }


        """)
        self.assertEqual(result, expected)

    def test__generate_types_empty_ns(self):
        # type: () -> None
        backend = _make_backend(target_folder_path="output", template_path="")
        empty_ns = ApiNamespace("empty_namespace")
        result = _evaluate_namespace(backend, [empty_ns])
        expected = textwrap.dedent("")
        self.assertEqual(result, expected)

    def test__generate_types_with_empty_ns(self):
        # type: () -> None
        backend = _make_backend(target_folder_path="output", template_path="")
        ns = _make_namespace()
        empty_ns = ApiNamespace("empty_namespace")
        result = _evaluate_namespace(backend, [ns, empty_ns])
        expected = textwrap.dedent("""
        type Timestamp = string;

        namespace accounts {
          export interface User {
            exists: boolean;
          }

        }


        """)
        self.assertEqual(result, expected)

    def test__generate_types_multiple_ns(self):
        # type: () -> None
        backend = _make_backend(target_folder_path="output", template_path="")
        ns1 = _make_namespace("accounts")
        ns2 = _make_namespace("files")
        result = _evaluate_namespace(backend, [ns1, ns2])
        expected = textwrap.dedent("""
        type Timestamp = string;

        namespace accounts {
          export interface User {
            exists: boolean;
          }

        }

        namespace files {
          export interface User {
            exists: boolean;
          }

        }


        """)
        self.assertEqual(result, expected)


class SpecHelper:
    """
    A helper class which exposes two namespace definitions
    and its corresponding type definitions for testing. The
    types are available as either a declaration or a namespace.
    """

    def __init__(self):
        pass

    _error_types = """
/**
 * An Error object returned from a route.
 */
interface Error<T> {
  // Text summary of the error.
  error_summary: string;
  // The error object.
  error: T;
  // User-friendly error message.
  user_message: UserMessage;
}

/**
 * User-friendly error message.
 */
interface UserMessage {
  // The message.
  text: string;
  // The locale of the message.
  locale: string;
}

"""

    _ns_spec = """\
namespace ns
import ns2
struct A
    "Sample struct doc."
    a String
        "Sample field doc."
    b Int64
struct B extends ns2.BaseS
    c Bytes
"""

    _ns_spec_types = """{
  /**
   * Sample struct doc.
   */
  export interface A {
    /**
     * Sample field doc.
     */
    a: string;
    b: number;
  }

  export interface B extends ns2.BaseS {
    c: string;
  }
%s
}
"""

    _ns2_spec = """\
namespace ns2
struct BaseS
    "This is a test."
    z Int64
    maptype Map(String, Int64)
union_closed BaseU
    z
    x String
alias AliasedBaseU = BaseU
    """

    _ns2_spec_types = """{
  /**
   * This is a test.
   */
  export interface BaseS {
    z: number;
    maptype: {[key: string]: number};
  }

  export interface BaseUZ {
    '.tag': 'z';
  }

  export interface BaseUX {
    '.tag': 'x';
    x: string;
  }

  export type BaseU = BaseUZ | BaseUX;

  export type AliasedBaseU = BaseU;
%s
}
"""

    _ns3_union_spec = """\
namespace ns3
struct A
    union
        a1 A1
        a2 A2
    a String
struct A1 extends A
    b Boolean
struct A2 extends A
    c Boolean
    mapfield Map(String, A)
union M
    e Boolean
    f String
union B
    w Boolean
    x A
    y M
    z A2
"""

    _ns3_union_spec_types = """{
  export interface A {
    a: string;
  }

  /**
   * Reference to the A polymorphic type. Contains a .tag property to let you
   * discriminate between possible subtypes.
   */
  export interface AReference extends A {
    /**
     * Tag identifying the subtype variant.
     */
    '.tag': "a1"|"a2";
  }

  export interface A1 extends A {
    b: boolean;
  }

  /**
   * Reference to the A1 type, identified by the value of the .tag property.
   */
  export interface A1Reference extends A1 {
    /**
     * Tag identifying this subtype variant. This field is only present when
     * needed to discriminate between multiple possible subtypes.
     */
    '.tag': 'a1';
  }

  export interface A2 extends A {
    c: boolean;
    mapfield: {[key: string]: A};
  }

  /**
   * Reference to the A2 type, identified by the value of the .tag property.
   */
  export interface A2Reference extends A2 {
    /**
     * Tag identifying this subtype variant. This field is only present when
     * needed to discriminate between multiple possible subtypes.
     */
    '.tag': 'a2';
  }

  export interface BW {
    '.tag': 'w';
    w: boolean;
  }

  export interface BX {
    '.tag': 'x';
    x: A1Reference|A2Reference|AReference;
  }

  export interface BY {
    '.tag': 'y';
    y: M;
  }

  export interface BZ extends A2 {
    '.tag': 'z';
  }

  export interface BOther {
    '.tag': 'other';
  }

  export type B = BW | BX | BY | BZ | BOther;

  export interface ME {
    '.tag': 'e';
    e: boolean;
  }

  export interface MF {
    '.tag': 'f';
    f: string;
  }

  export interface MOther {
    '.tag': 'other';
  }

  export type M = ME | MF | MOther;
%s
}
"""

    _timestamp_mapping = 'type Timestamp = string'

    _timestamp_def_formatted = "\n" + "  " + _timestamp_mapping + ";"

    @classmethod
    def get_ns_spec(cls):
        """Returns a test namespace which imports another namespace (`ns2`)."""
        return cls._ns_spec

    @classmethod
    def get_ns_types_as_declaration(cls):
        types = """\nimport * as ns2 from 'ns2';\n""" + (
            ("\ndeclare module 'ns' " + cls._ns_spec_types) % cls._timestamp_def_formatted) + "\n\n"
        return types.replace('namespace', 'declare module')

    @classmethod
    def get_ns2_spec(cls):
        """Returns a simple namespace."""
        return cls._ns2_spec

    @classmethod
    def get_ns2_types_as_declaration(cls):
        return (("\ndeclare module 'ns2' " + cls._ns2_spec_types
                 ) % cls._timestamp_def_formatted) + "\n\n"

    @classmethod
    def get_all_types_as_namespace(cls):
        types = cls._error_types + "\n" + cls._timestamp_mapping + ";\n" + (
            ("\nnamespace ns " + cls._ns_spec_types) % "") + (
            ("\nnamespace ns2 " + cls._ns2_spec_types) % "") + "\n\n"
        return types

    @classmethod
    def get_ns3_spec_for_union(cls):
        """
        Returns a test namespace which has a union field with all possible types of
        members a union can have. It includes (1) primitive, (2) struct, (3) enumerated
        subtypes, and (4) a union. This spec is useful in validating the auto-generated
        code for a union type defined in a namespace.
        """
        return cls._ns3_union_spec

    @classmethod
    def get_ns3_types_as_declaration(cls):
        return (("\ndeclare module 'ns3' " + cls._ns3_union_spec_types
                 ) % cls._timestamp_def_formatted) + "\n\n"


class TestTSDTypesE2E(unittest.TestCase):

    def __init__(self, *args, **kwargs):
        super(TestTSDTypesE2E, self).__init__(*args, **kwargs)
        self.maxDiff = None  # Increase text diff size

    def setUp(self):
        self.stone_output_directory = "output"
        if not os.path.exists(self.stone_output_directory):
            os.makedirs(self.stone_output_directory)
        self.template_file_name = "typescript.template"
        template_file_path = "{}/{}".format(self.stone_output_directory, self.template_file_name)
        with open(template_file_path, "w") as template_file:
            template_file.write("/*TYPES*/")

    def tearDown(self):
        # Clear output of stone tool after all tests.
        shutil.rmtree('output')

    def _verify_generated_output(self, filename, expected_namespace_types):
        with open(filename, 'r') as f:
            generated_types = f.read()
            self.assertEqual(generated_types, expected_namespace_types)

    def test_tsd_types_declarations_output(self):
        # Sanity check: stone must be importable for the compiler to work
        __import__('stone')

        # Compile spec by calling out to stone
        p = subprocess.Popen(
            [sys.executable,
             '-m',
             'stone.cli',
             'tsd_types',
             self.stone_output_directory,
             '--',
             self.template_file_name,
             '--exclude_error_types',
             '-i=0'],
            stdin=subprocess.PIPE,
            stderr=subprocess.PIPE)
        _, stderr = p.communicate(
            input=(SpecHelper.get_ns_spec() + SpecHelper.get_ns2_spec()).encode('utf-8'))
        if p.wait() != 0:
            raise AssertionError('Could not execute stone tool: %s' %
                                 stderr.decode('utf-8'))

        # one file must be generated per namespace
        expected_ns_output = SpecHelper.get_ns_types_as_declaration()
        self._verify_generated_output('output/ns.d.ts', expected_ns_output)

        expected_ns2_output = SpecHelper.get_ns2_types_as_declaration()
        self._verify_generated_output('output/ns2.d.ts', expected_ns2_output)

    def test_tsd_types_namespace_output(self):
        # Sanity check: stone must be importable for the compiler to work
        __import__('stone')

        output_file_name = "all_types.ts"

        # Compile spec by calling out to stone
        p = subprocess.Popen(
            [sys.executable,
             '-m',
             'stone.cli',
             'tsd_types',
             self.stone_output_directory,
             '--',
             self.template_file_name,
             output_file_name,
             '-i=0'],
            stdin=subprocess.PIPE,
            stderr=subprocess.PIPE)
        _, stderr = p.communicate(
            input=(SpecHelper.get_ns_spec() + SpecHelper.get_ns2_spec()).encode('utf-8'))
        if p.wait() != 0:
            raise AssertionError('Could not execute stone tool: %s' %
                                 stderr.decode('utf-8'))

        expected_output = SpecHelper.get_all_types_as_namespace()
        self._verify_generated_output('output/{}'.format(output_file_name), expected_output)

    def test_tsd_types_for_union(self):
        """
        Test tsd types generated for a union which has all possible data types as
        members including primitive, struct, enumerated sub types and unions.
        """
        # Sanity check: stone must be importable for the compiler to work
        __import__('stone')

        # Compile spec by calling out to stone
        p = subprocess.Popen(
            [sys.executable,
             '-m',
             'stone.cli',
             'tsd_types',
             self.stone_output_directory,
             '--',
             self.template_file_name,
             '--exclude_error_types',
             '-i=0'],
            stdin=subprocess.PIPE,
            stderr=subprocess.PIPE)
        _, stderr = p.communicate(
            input=(SpecHelper.get_ns3_spec_for_union()).encode('utf-8'))
        if p.wait() != 0:
            raise AssertionError('Could not execute stone tool: %s' %
                                 stderr.decode('utf-8'))

        # one file must be generated per namespace
        expected_ns_output = SpecHelper.get_ns3_types_as_declaration()
        self._verify_generated_output('output/ns3.d.ts', expected_ns_output)


if __name__ == '__main__':
    unittest.main()
