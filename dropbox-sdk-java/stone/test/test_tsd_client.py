import textwrap
import unittest

from stone.backends.tsd_client import TSDClientBackend
from stone.ir import Api, ApiNamespace, ApiRoute, Void, Int32
from stone.ir.data_types import Struct

MYPY = False
if MYPY:
    import typing  # noqa: F401 # pylint: disable=import-error,unused-import,useless-suppression


class TestGeneratedTSDClient(unittest.TestCase):
    def __init__(self, *args, **kwargs):
        super(TestGeneratedTSDClient, self).__init__(*args, **kwargs)

    def _get_api(self):
        # type () -> Api
        api = Api(version='0.1b1')
        api.route_schema = Struct(u'Route', 'stone_cfg', None)
        route1 = ApiRoute('get_metadata', 1, None)
        route1.set_attributes(None, ':route:`get_metadata`', Void(), Void(), Void(), {})
        route2 = ApiRoute('get_metadata', 2, None)
        route2.set_attributes(None, ':route:`get_metadata:2`', Void(), Int32(), Void(), {})
        ns = ApiNamespace('files')
        ns.add_route(route1)
        ns.add_route(route2)
        api.namespaces[ns.name] = ns
        return api, ns

    def test__generate_types_single_ns(self):
        # type: () -> None
        api, _ = self._get_api()
        backend = TSDClientBackend(
            target_folder_path="output",
            args=['files', 'files']
        )
        backend._generate_routes(api, 0, 0)
        result = backend.output_buffer_to_string()
        expected = textwrap.dedent(
            '''\

            /**
             * getMetadata()
             *
             * When an error occurs, the route rejects the promise with type Error<void>.
             * @param arg The request parameters.
             */
            public filesGetMetadata(arg: void): Promise<void>;

            /**
             * getMetadataV2()
             *
             * When an error occurs, the route rejects the promise with type Error<void>.
             * @param arg The request parameters.
             */
            public filesGetMetadataV2(arg: void): Promise<number>;
            ''')
        self.assertEqual(result, expected)

    def test_route_with_version_number_conflict(self):
        # type: () -> None
        api, ns = self._get_api()

        # Add a conflicting route
        route3 = ApiRoute('get_metadata_v2', 1, None)
        route3.set_attributes(None, None, Void(), Int32(), Void(), {})
        ns.add_route(route3)

        backend = TSDClientBackend(
            target_folder_path="output",
            args=['files', 'files']
        )
        with self.assertRaises(RuntimeError) as cm:
            backend._generate_routes(api, 0, 0)
        self.assertTrue(str(cm.exception).startswith(
            'There is a name conflict between'))
