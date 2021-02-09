package com.example.businessorganizer.utils

import com.kizitonwose.calendarview.model.CalendarMonth
import java.time.Month
import java.time.Year
import java.time.YearMonth
import java.time.format.TextStyle
import java.time.temporal.WeekFields
import java.util.*

const val LOCALE = "ru"

object BusinessDateUtils {
    fun getCurrentYear() = Year.now().value
    fun getFirstMonth() = getMonthOfCurrentYear(Month.JANUARY)
    fun getLastMonth() = getMonthOfCurrentYear(Month.DECEMBER)
    fun getCurrentMonth() = YearMonth.now()
    fun getFirstDayOfWeek() = WeekFields.of(Locale(LOCALE)).firstDayOfWeek
    fun getMonthOfCurrentYear(month: Month) = YearMonth.of(getCurrentYear(), month)
    fun getMontAndYearForHeader(month: CalendarMonth): String {
        return "${month.yearMonth.month.getDisplayName(TextStyle.FULL_STANDALONE, Locale(LOCALE))
            .toLowerCase().capitalize()} ${month.year}"
    }
}