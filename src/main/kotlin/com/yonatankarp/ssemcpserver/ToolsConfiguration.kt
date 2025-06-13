package com.yonatankarp.ssemcpserver

import com.yonatankarp.ssemcpserver.tools.ToolProvider
import org.springframework.ai.tool.ToolCallbackProvider
import org.springframework.ai.tool.method.MethodToolCallbackProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ToolsConfiguration {
    @Bean
    fun tools(toolProviders: List<ToolProvider>) : ToolCallbackProvider =
        MethodToolCallbackProvider.builder()
            .toolObjects(*toolProviders.toTypedArray())
            .build()
}
