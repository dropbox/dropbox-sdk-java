import textwrap

from stone.backends.python_client import PythonClientBackend
from stone.ir import ApiNamespace, ApiRoute, Void, Int32

MYPY = False
if MYPY:
    import typing  # noqa: F401 # pylint: disable=import-error,unused-import,useless-suppression

import unittest

class TestGeneratedPythonClient(unittest.TestCase):
    def __init__(self, *args, **kwargs):
        super(TestGeneratedPythonClient, self).__init__(*args, **kwargs)

    def _evaluate_namespace(self, ns):
        # type: (ApiNamespace) -> typing.Text

        backend = PythonClientBackend(
            target_folder_path='output',
            args=['-m', 'files', '-c', 'DropboxBase', '-t', 'dropbox'])
        backend._generate_routes(ns)
        return backend.output_buffer_to_string()

    def _evaluate_namespace_with_auth_mode(self, ns, auth_mode):
        # type: (ApiNamespace, str) -> typing.Text

        # supply supported auth modes to the SDK generator using the new syntax
        backend = PythonClientBackend(
            target_folder_path='output',
            args=['-w', auth_mode, '-m', 'files', '-c', 'DropboxBase', '-t', 'dropbox'])
        backend._generate_route_methods({ns})
        return backend.output_buffer_to_string()

    def test_route_with_version_number(self):
        # type: () -> None

        route1 = ApiRoute('get_metadata', 1, None)
        route1.set_attributes(None, ':route:`get_metadata:2`', Void(), Void(), Void(), {})
        route2 = ApiRoute('get_metadata', 2, None)
        route2.set_attributes(None, None, Void(), Int32(), Void(), {})
        ns = ApiNamespace('files')
        ns.add_route(route1)
        ns.add_route(route2)

        result = self._evaluate_namespace(ns)

        expected = textwrap.dedent('''\
            def files_get_metadata(self):
                """
                :meth:`files_get_metadata_v2`

                :rtype: None
                """
                arg = None
                r = self.request(
                    files.get_metadata,
                    'files',
                    arg,
                    None,
                )
                return None

            def files_get_metadata_v2(self):
                arg = None
                r = self.request(
                    files.get_metadata_v2,
                    'files',
                    arg,
                    None,
                )
                return r

        ''')

        self.assertEqual(result, expected)

    def test_route_with_auth_mode1(self):
        # type: () -> None

        route1 = ApiRoute('get_metadata', 1, None)
        route1.set_attributes(None, ':route:`get_metadata:2`', Void(), Void(), Void(),
                              {'auth': 'app'})
        route2 = ApiRoute('get_metadata', 2, None)
        route2.set_attributes(None, None, Void(), Int32(), Void(),
                              {'auth': 'user, app'})
        ns = ApiNamespace('files')
        ns.add_route(route1)
        ns.add_route(route2)

        result = self._evaluate_namespace_with_auth_mode(ns, 'user')

        expected = textwrap.dedent('''\
            # ------------------------------------------
            # Routes in files namespace

            def files_get_metadata_v2(self):
                arg = None
                r = self.request(
                    files.get_metadata_v2,
                    'files',
                    arg,
                    None,
                )
                return r

        ''')

        self.assertEqual(result, expected)

    def test_route_with_auth_mode2(self):
        # type: () -> None

        route1 = ApiRoute('get_metadata', 1, None)
        route1.set_attributes(None, ':route:`get_metadata:2`', Void(), Void(), Void(),
                              {'auth': 'user'})
        route2 = ApiRoute('get_metadata', 2, None)
        route2.set_attributes(None, None, Void(), Int32(), Void(),
                              {'auth': 'user, app'})
        ns = ApiNamespace('files')
        ns.add_route(route1)
        ns.add_route(route2)

        result = self._evaluate_namespace_with_auth_mode(ns, 'user')

        expected = textwrap.dedent('''\
            # ------------------------------------------
            # Routes in files namespace

            def files_get_metadata(self):
                """
                :meth:`files_get_metadata_v2`

                :rtype: None
                """
                arg = None
                r = self.request(
                    files.get_metadata,
                    'files',
                    arg,
                    None,
                )
                return None

            def files_get_metadata_v2(self):
                arg = None
                r = self.request(
                    files.get_metadata_v2,
                    'files',
                    arg,
                    None,
                )
                return r

        ''')

        self.assertEqual(result, expected)

    def test_route_with_auth_mode3(self):
        # type: () -> None

        route1 = ApiRoute('get_metadata', 1, None)
        route1.set_attributes(None, ':route:`get_metadata:2`', Void(), Void(), Void(),
                             {'auth': 'app'})
        route2 = ApiRoute('get_metadata', 2, None)
        route2.set_attributes(None, None, Void(), Int32(), Void(),
                             {'auth': 'app, team'})
        ns = ApiNamespace('files')
        ns.add_route(route1)
        ns.add_route(route2)

        result = self._evaluate_namespace_with_auth_mode(ns, 'user')

        expected = textwrap.dedent('''\
            # ------------------------------------------
            # Routes in files namespace

        ''')

        self.assertEqual(result, expected)

    def test_route_with_version_number_name_conflict(self):
        # type: () -> None

        route1 = ApiRoute('get_metadata', 2, None)
        route1.set_attributes(None, None, Void(), Int32(), Void(), {})
        route2 = ApiRoute('get_metadata_v2', 1, None)
        route2.set_attributes(None, None, Void(), Void(), Void(), {})
        ns = ApiNamespace('files')
        ns.add_route(route1)
        ns.add_route(route2)

        with self.assertRaises(RuntimeError) as cm:
            self._evaluate_namespace(ns)
        self.assertEqual(
            'There is a name conflict between {!r} and {!r}'.format(route1, route2),
            str(cm.exception))

    # TODO: add more unit tests for client code generation
