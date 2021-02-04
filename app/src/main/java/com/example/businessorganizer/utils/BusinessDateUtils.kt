package com.example.businessorganizer.utils

import java.time.Month
import java.time.Year
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

private const val LOCALE = "ru"

object BusinessDateUtils {
    fun getCurrentYear() = Year.now().value
    fun getFirstMonth() = getMonthOfCurrentYear(Month.JANUARY)
    fun getLastMonth() = getMonthOfCurrentYear(Month.DECEMBER)
    fun getCurrentMonth() = YearMonth.now()
    fun getFirstDayOfWeek() = WeekFields.of(Locale(LOCALE)).firstDayOfWeek
    fun getMonthOfCurrentYear(month: Month) = YearMonth.of(getCurrentYear(), month)
}