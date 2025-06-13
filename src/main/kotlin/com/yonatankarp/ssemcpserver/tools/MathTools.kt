package com.yonatankarp.ssemcpserver.tools

import org.springframework.ai.tool.annotation.Tool
import org.springframework.stereotype.Component

@Component
class MathTools : ToolProvider {
    @Tool(name = "add-numbers", description = "Add two numbers together")
    fun addNumbers(a: Int, b: Int) = a + b

    @Tool(name = "multiply-numbers", description = "Multiply two numbers together")
    fun multiplyNumbers(a: Int, b: Int) = a * b
}
