package com.yonatankarp.ssemcpserver.tools

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.slf4j.LoggerFactory
import org.springframework.ai.tool.annotation.Tool
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component

@Component
class DateTimeTools : ToolProvider {
    @Tool(name = "get-current-datetime", description = "Get the current date and time in the user's timezone")
    fun getCurrentDateTime(): String =
        LocalDateTime.now()
            .atZone(LocaleContextHolder.getTimeZone().toZoneId())
            .toString()
            .also { logger.info("Current time: $it") }

    @Tool(name = "set-alarm", description = "Set a user alert for a given time, provided in ISO 8601 format")
    fun setAlarm(time: String): String =
        LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME).toString()
            .also { logger.info("Alarm set to $it") }

    companion object {
        private val logger = LoggerFactory.getLogger(DateTimeTools::class.java)
    }
}
