package plugins.model

import java.io.Serializable

class StoneConfig(
    var packageName: String = "com.dropbox.stone",
    var globalRouteFilter: String? = null,
    var dataTypesOnly: Boolean = false,
    var client: ClientSpec? = null,
    var routeWhitelistFilter: String? = null,
) : Serializable