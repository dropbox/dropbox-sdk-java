import json
import os

from stone.ir import (
    Api,
    ApiNamespace,
    ApiRoute,
    DataType,
    Field,
    Int32,
    List,
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


def is_enum(data_type):
    if data_type is None:
        return False

    assert isinstance(data_type, DataType), repr(data_type)
    if is_union_type(data_type):
        return all(is_void_type(f.data_type) for f in data_type.all_fields)
    else:
        return False


# Generates an unofficial JSON representation of Stone.
class JsonCodeGenerator(CodeBackend):
    def what_type_info(self, data_type):
        if data_type is None:
            return None

        type_info = {
            "name": data_type.name,
            "is_struct_type": is_struct_type(data_type),
            "is_primitive_type": is_primitive_type(data_type),
            "is_boolean_type": is_boolean_type(data_type),
            "is_numeric_type": is_numeric_type(data_type),
            "is_list_type": is_list_type(data_type),
            "is_union_type": is_union_type(data_type),
            "is_bytes_type": is_bytes_type(data_type),
            "is_map_type": is_map_type(data_type),
            "is_composite_type": is_composite_type(data_type),
            "is_nullable_type": is_nullable_type(data_type),
            "is_string_type": is_string_type(data_type),
            "is_void_type": is_void_type(data_type),
            "is_timestamp_type": is_timestamp_type(data_type),
        }

        if is_struct_type(data_type):
            type_info["namespace"] = data_type.namespace.name
            type_info["parent_type_data"] = self.what_type_info(data_type.parent_type)
        if is_union_type(data_type):
            type_info["namespace"] = data_type.namespace.name
        if is_nullable_type(data_type):
            type_info["nullable_type_data"] = self.what_type_info(data_type.data_type)
        if is_union_type(data_type):
            type_info["parent_type_data"] = self.what_type_info(data_type.parent_type)
        if is_list_type(data_type):
            type_info["list_item_type_data"] = self.what_type_info(data_type.data_type)
            type_info["min_items"] = data_type.min_items
            type_info["max_items"] = data_type.max_items
        if is_map_type(data_type):
            type_info["map_key_type_data"] = self.what_type_info(data_type.key_data_type)
            type_info["map_value_type_data"] = self.what_type_info(data_type.value_data_type)

        return type_info

    def generate(self, api):
        for namespace in api.namespaces.values():
            namespace_data = {
                "name": namespace.name,
                "doc": namespace.doc,
                "routes": [],
                "types": []
            }
            for data_type in namespace.linearize_data_types():
                type_data = {
                    "name": data_type.name,
                    "doc": data_type.doc,
                    "type_info": self.what_type_info(data_type),
                    "fields": [],
                }

                type_data["examples"] = []
                for example in data_type.get_examples().values():
                    type_data["examples"].append({
                        "text": example.text,
                        "label": example.label,
                        "value": example.value,
                    })

                for field in data_type.all_fields:
                    if field.name is not "other":
                        field_data = {
                            "name": field.name,
                            "doc": field.doc,
                            "type_info": self.what_type_info(field.data_type),
                            "deprecated": field.deprecated,
                            "preview": field.preview,
                        }

                        type_data["fields"].append(field_data)

                namespace_data["types"].append(type_data)

            for route in namespace.routes:
                namespace_data["route_count"] = len(namespace.routes)
                namespace_data["routes"].append({
                    "name": route.name,
                    "doc": route.doc,
                    "version": route.version,
                    "path": "/" + str(route.version) + "/" + namespace.name + "/" + route.name
                })

            output_dir = "build/stone-json/types"

            if not os.path.exists(output_dir):
                os.makedirs(output_dir)

            if len(namespace_data["types"]) > 0:
                with open(output_dir + '/' + namespace.name + '.json', 'w') as f:
                    f.write(json.dumps(namespace_data, indent=2))
