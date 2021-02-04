package com.example.businessorganizer.ui.calendar

import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private const val DATE_FORMAT = "EEE'\n" +
        "'d MMM"

class CalendarViewModel : ViewModel(){
    private val today = LocalDate.now()
    private var startDate: LocalDate? = null
    private var endDate: LocalDate? = null
    private val headerDateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT)


}