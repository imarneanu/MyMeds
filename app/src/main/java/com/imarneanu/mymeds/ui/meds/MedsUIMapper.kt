package com.imarneanu.mymeds.ui.meds

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

object MedsUIMapper {

    private val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    val now = toMilliseconds(LocalDate.now())

    fun toFormatDate(millis: Long): String {
        if (millis == 0L) return ""
        val instant = Instant.ofEpochMilli(millis)
        val date = instant.atZone(ZoneOffset.UTC).toLocalDate()
        return formatter.format(date)
    }

    fun toMilliseconds(date: LocalDate) =
        date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
}

