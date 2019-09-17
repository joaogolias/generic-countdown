package br.com.generic_countdown

import java.time.LocalDate
import java.time.ZoneId

fun LocalDate.getEpochMilliseconds(): Long {
    return atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond*1000
}