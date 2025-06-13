package com.yonatankarp.ssemcpserver

import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ManifestController(
    private val serverProperties: McpServerProperties,
) {
    @GetMapping("/manifest.json")
    fun getManifest(): Map<String, Any> = mapOf(
        "name" to serverProperties.name,
        "type" to "sse",
        "description" to "My custom SSE MCP server",
        "version" to serverProperties.version
    )
}

@ConfigurationProperties(prefix = "spring.ai.mcp.server")
@Component
data class McpServerProperties(
    var name: String = "",
    var version: String = "",
)
