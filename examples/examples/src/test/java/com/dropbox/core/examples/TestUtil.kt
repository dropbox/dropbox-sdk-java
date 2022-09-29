package com.dropbox.core.examples

import java.io.File

object TestUtil {
    fun isRunningInCI(): Boolean {
        val isRunningInCI =  System.getenv("ci") == "true"
        println("isRunningInCI: $isRunningInCI")
        return isRunningInCI
    }

}