#!/usr/bin/env python

import textwrap
import unittest

from stone.frontend.frontend import specs_to_ir


class TestStone(unittest.TestCase):
    def _compare_namespace_names(self, api, expected_names):
        expected_names = sorted(expected_names)
        actual_names = sorted(list(api.namespaces.keys()))
        self.assertEqual(expected_names, actual_names)

    def _compare_datatype_names(self, namespace, expected_names):
        expected_names = sorted(expected_names)
        actual_names = sorted(list(namespace.data_type_by_name.keys()))
        self.assertEqual(expected_names, actual_names)
        actual_names_on_datatypes = sorted([d.name for d in namespace.data_type_by_name.values()])
        self.assertEqual(actual_names, actual_names_on_datatypes)

    def test_simple(self):
        """
        Tests that route whitelisting can generate the right datatypes for a namespace.
        """
        text = textwrap.dedent("""\
            namespace test

            struct TestArg
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult
                f String
                    "test doc"
                example default
                    f = "asdf"
            route TestRoute (TestArg, TestResult, Void)
                "test doc"

            struct TestArg2
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult2
                f String
                    "test doc"
                example default
                    f = "asdf"
            route TestRoute:2 (TestArg2, TestResult2, Void)
                "test doc"

            """)
        route_whitelist_filter = {
            "route_whitelist": {"test": ["TestRoute:2"]},
            "datatype_whitelist": {}
        }
        api = specs_to_ir([('test.stone', text)], route_whitelist_filter=route_whitelist_filter)
        self._compare_namespace_names(api, ['test'])
        self._compare_datatype_names(api.namespaces['test'], ['TestArg2', 'TestResult2'])

    def test_star(self):
        """
        Tests that inputs with "*" work as expected.
        """
        text = textwrap.dedent("""\
            namespace test

            struct TestArg
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult
                f String
                    "test doc"
                example default
                    f = "asdf"
            route TestRoute (TestArg, TestResult, Void)
                "test doc"

            struct TestArg2
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult2
                f String
                    "test doc"
                example default
                    f = "asdf"
            route TestRoute:2 (TestArg2, TestResult2, Void)
                "test doc"

            """)
        route_whitelist_filter = {
            "route_whitelist": {"test": ["*"]},
            "datatype_whitelist": {}
        }
        api = specs_to_ir([('test.stone', text)],
                          route_whitelist_filter=route_whitelist_filter)
        self._compare_namespace_names(api, ['test'])
        self._compare_datatype_names(api.namespaces['test'],
                                     ['TestArg', 'TestArg2', 'TestResult', 'TestResult2'])

    def test_alias(self):
        """
        Tests that aliased datatypes are correctly generated.
        """
        text = textwrap.dedent("""\
            namespace test

            struct TestArg
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult
                f String
                    "test doc"
                example default
                    f = "asdf"
            alias TestAlias = TestArg
            route TestRoute (TestAlias, TestResult, Void)
                "test doc"

            """)
        route_whitelist_filter = {
            "route_whitelist": {"test": ["TestRoute"]},
            "datatype_whitelist": {}
        }
        api = specs_to_ir([('test.stone', text)], route_whitelist_filter=route_whitelist_filter)
        self._compare_namespace_names(api, ['test'])
        self._compare_datatype_names(api.namespaces['test'], ['TestArg', 'TestResult'])

    def test_imports(self):
        """
        Tests that datatypes imported from another namespace are correctly included.
        """
        text = textwrap.dedent("""\
            namespace test

            struct TestArg
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult
                f String
                    "test doc"
                example default
                    f = "asdf"

            """)
        text2 = textwrap.dedent("""\
            namespace test2

            import test

            route TestRoute (test.TestArg, test.TestResult, Void)
                "test doc"

            """)
        route_whitelist_filter = {
            "route_whitelist": {"test2": ["TestRoute"]},
            "datatype_whitelist": {}
        }
        api = specs_to_ir([('test.stone', text), ('test2.stone', text2)],
                          route_whitelist_filter=route_whitelist_filter)
        self._compare_namespace_names(api, ['test', 'test2'])
        self._compare_datatype_names(api.namespaces['test'], ['TestArg', 'TestResult'])
        self._compare_datatype_names(api.namespaces['test2'], [])

    def test_builtin_types(self):
        """
        Tests that builtin datatypes, like lists, maps, and unions, are correctly evaluated.
        """
        text = textwrap.dedent("""\
            namespace test

            union Foo
                a
                    "test doc"
                example default
                    a = null
            union Bar
                a
                    "test doc"
                example default
                    a = null
            struct TestArg
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult
                f List(Foo)
                    "test doc"
                b Map(String, Bar)
                    "test doc"
                example default
                    f = [default]
                    b = {"test": default}
            route TestRoute (TestArg, TestResult, Void)
                "test doc"

            """)
        route_whitelist_filter = {
            "route_whitelist": {"test": ["TestRoute"]},
            "datatype_whitelist": {}
        }
        api = specs_to_ir([('test.stone', text)], route_whitelist_filter=route_whitelist_filter)
        self._compare_namespace_names(api, ['test'])
        self._compare_datatype_names(api.namespaces['test'], ['TestArg', 'TestResult',
                                                              'Foo', 'Bar'])

    def test_subtype(self):
        """
        Tests that datatypes that inherit from others are correctly generated.
        """
        text = textwrap.dedent("""\
            namespace test

            union Foo
                a
                    "test doc"
                example default
                    a = null
            union Bar extends Foo
                b
                    "test doc"
                example default
                    a = null
            struct TestArg
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult
                f Bar
                    "test doc"
                example default
                    f = default
            route TestRoute (TestArg, TestResult, Void)
                "test doc"

            """)
        route_whitelist_filter = {
            "route_whitelist": {"test": ["TestRoute"]},
            "datatype_whitelist": {}
        }
        api = specs_to_ir([('test.stone', text)], route_whitelist_filter=route_whitelist_filter)
        self._compare_namespace_names(api, ['test'])
        self._compare_datatype_names(api.namespaces['test'], ['TestArg', 'TestResult',
                                                              'Foo', 'Bar'])

        # Test enumerated subtypes as well
        text = textwrap.dedent("""\
            namespace test

            struct Foo
                union
                    file File
                    folder Folder
                path String
                    "test doc"
                example default
                    file = default
                example folder_default
                    folder = default

            struct File extends Foo
                a String
                    "test doc"
                example default
                    a = "a"
                    path = "a"

            struct Folder extends Foo
                b String
                    "test doc"
                example default
                    b = "b"
                    path = "a"

            struct TestArg
                f Foo
                    "test doc"
                example default
                    f = default
            struct TestResult
                f String
                    "test doc"
                example default
                    f = "asdf"
            route TestRoute (TestArg, TestResult, Void)
                "test doc"

            """)
        route_whitelist_filter = {
            "route_whitelist": {"test": ["TestRoute"]},
            "datatype_whitelist": {}
        }
        api = specs_to_ir([('test.stone', text)], route_whitelist_filter=route_whitelist_filter)
        self._compare_namespace_names(api, ['test'])
        self._compare_datatype_names(api.namespaces['test'], ['TestArg', 'TestResult',
                                                              'Foo', 'File', 'Folder'])

    def test_doc_refs(self):
        """
        Tests that datatypes referenced in documentation get generated.
        """
        text = textwrap.dedent("""\
            namespace test

            union Foo
                a
                    "test doc"
                example default
                    a = null
            union Bar
                a
                    "test doc"
                example default
                    a = null

            """)

        text2 = textwrap.dedent("""\
            namespace test2
                ":type:`test.Foo`"

            alias TestAlias = String
                ":field:`Baz.a`"

            struct TestStruct
                a TestAlias
                    "test doc"
                example default
                    a = "asdf"

            struct Baz
                a String
                    "test doc :field:`TestStruct.a`"
                example default
                    a = "asdf"

            struct TestArg
                f String
                    "test doc"
                example default
                    f = "asdf"
            struct TestResult
                f String
                    "test doc"
                example default
                    f = "asdf"
            route TestRoute (TestArg, TestResult, Void)
                ":type:`Baz` test doc"
            """)
        route_whitelist_filter = {
            "route_whitelist": {"test2": ["TestRoute"]},
            "datatype_whitelist": {}
        }
        api = specs_to_ir([('test.stone', text), ('test2.stone', text2)],
                          route_whitelist_filter=route_whitelist_filter)
        self._compare_namespace_names(api, ['test', 'test2'])
        self._compare_datatype_names(api.namespaces['test'], ['Foo'])
        self._compare_datatype_names(api.namespaces['test2'], ['TestArg', 'TestResult',
                                                               'TestStruct', 'Baz'])

if __name__ == '__main__':
    unittest.main()
