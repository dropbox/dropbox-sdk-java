package plugins.model

import java.io.Serializable

class ClientSpec(
    var name: String? = null,
    var javadoc: String? = null,
    var routeFilter: String? = null,
    var requestsClassnamePrefix: String? = null,
    var unusedClassesToGenerate: String? = null,
) : Serializable