import os
import re
from enum import Enum
from datetime import date
from collections import defaultdict
from sys import argv
from typing import List, Optional, NamedTuple, Tuple
from unidiff import PatchSet

class DataType(str, Enum):
    ROUTE = "route"
    STRUCT = "struct"
    UNION = "union"

NsChange = NamedTuple('NsChange', [
    ('file_name', str),
    ('added_routes', List[str]),
    ('added_structs', List[str]),
    ('added_unions', List[str]),
    ('deprecated_routes', List[str]),
    ('removed_routes', List[str]),
    ('removed_structs', List[str]),
    ('removed_unions', List[str]),
    ('updated_datatypes', Optional[List[Tuple[str, DataType]]]),
])

ChangeLog = NamedTuple('ChangeLog', [
    ('ns_changes', List[NsChange]),
    ('added_nses', List[str]),
    ('removed_nses', List[str]),
])


def parse_datatype_info(line):
    # type: (str) -> Optional[Tuple[DataType, str]]
    route = re.match(r"^route (.+)\(", line)
    struct = re.match(r"^struct (.+)$", line)
    union = re.match(r"^union (.+)$", line)
    match = struct or union or route
    if not match:
        return None
    datatype = DataType.ROUTE
    if struct:
        datatype = DataType.STRUCT
    if union:
        datatype = DataType.UNION
    return datatype, match.group(1)


def parse_change_log(change_log_diff):
    # type: (str) -> ChangeLog
    ns_changes = []
    added_nses = []
    removed_nses = []

    patch = PatchSet(change_log_diff)
    for patch_file in patch:
        path_parts = patch_file.path.split('.')
        if len(path_parts) != 2:
            continue
        ns_file_name, ext = path_parts
        if ext != "stone":
            continue

        if patch_file.is_added_file:
            added_nses.append(ns_file_name)
            continue

        if patch_file.is_removed_file:
            removed_nses.append(ns_file_name)
            continue

        added_routes = []
        added_structs = []
        added_unions = []
        deprecated_routes = []
        removed_routes = []
        removed_structs = []
        removed_unions = []
        updated_datatypes = []

        route_map = defaultdict(int)

        # Pass for checking for creation/deletion of datatypes
        for hunk in patch_file:
            for line in hunk:
                datatype_info = parse_datatype_info(line.value)
                if datatype_info is None:
                    continue
                datatype, datatype_name = datatype_info

                if datatype == DataType.ROUTE:
                    if line.is_added:
                        route_map[datatype_name] += 1
                    if line.is_removed:
                        route_map[datatype_name] -= 1

                if datatype == DataType.STRUCT:
                    if line.is_added:
                        added_structs.append(datatype_name)
                    if line.is_removed:
                        removed_structs.append(datatype_name)

                if datatype == DataType.UNION:
                    if line.is_added:
                        added_unions.append(datatype_name)
                    if line.is_removed:
                        removed_unions.append(datatype_name)


            datatype, datatype_name = None, None
            seen_datatypes = set()

            # Pass to check for updated datatypes
            for line in hunk:
                datatype_info = parse_datatype_info(line.value)
                if datatype_info and not line.is_removed:
                    if line.is_added:
                        datatype, datatype_name = None, None
                    else:
                        datatype, datatype_name = datatype_info
                if not datatype_info and datatype and datatype_name:
                    if line.is_removed or line.is_added and datatype_name not in seen_datatypes:
                        updated_datatypes.append((datatype, datatype_name))
                        seen_datatypes.add(datatype_name)

        for route, ref_count in route_map.items():
            if ref_count > 0:
                added_routes.append(route)
            if ref_count < 0:
                removed_routes.append(route)

        ns_change = NsChange(
            ns_file_name,
            added_routes,
            added_structs,
            added_unions,
            deprecated_routes,
            removed_routes,
            removed_structs,
            removed_unions,
            updated_datatypes,
        )
        ns_changes.append(ns_change)

    change_log = ChangeLog(ns_changes, added_nses, removed_nses)
    return change_log


def main():
    stream = os.popen('git diff')
    diff = stream.read()
    change_log = parse_change_log(diff)
    print("Spec Update {} (#<TODO>)".format(date.today().strftime("%m/%d/%Y")))
    print()
    print("Change Notes:")
    for ns_change in change_log.ns_changes:
        print()
        print("{} Namespace".format(ns_change.file_name))
        if ns_change.added_routes:
            print("- Add {} routes".format(", ".join(ns_change.added_routes)))
        if ns_change.added_structs:
            print("- Add {} structs".format(", ".join(ns_change.added_structs)))
        if ns_change.added_unions:
            print("- Add {} unions".format(", ".join(ns_change.added_unions)))
        if ns_change.removed_routes:
            print("- Remove {} routes".format(", ".join(ns_change.removed_routes)))
        if ns_change.removed_structs:
            print("- Remove {} structs".format(", ".join(ns_change.removed_structs)))
        if ns_change.removed_unions:
            print("- Remove {} unions".format(", ".join(ns_change.removed_unions)))
        if ns_change.updated_datatypes:
            for datatype, datatype_name in ns_change.updated_datatypes:
                print("- Update {} {} to include/remove/deprecate <TODO>".format(datatype_name, datatype))
    if change_log.added_nses:
        print()
        for ns in change_log.added_nses:
            print("Add {} namespace".format(ns))

    if change_log.removed_nses:
        print()
        for ns in change_log.removed_nses:
            print("Add {} namespace".format(ns))


if __name__ == "__main__":
    main()
