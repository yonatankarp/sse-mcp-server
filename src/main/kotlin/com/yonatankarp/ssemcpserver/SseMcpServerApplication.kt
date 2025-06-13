package com.yonatankarp.ssemcpserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SseMcpServerApplication

fun main(args: Array<String>) {
    runApplication<SseMcpServerApplication>(*args)
}
