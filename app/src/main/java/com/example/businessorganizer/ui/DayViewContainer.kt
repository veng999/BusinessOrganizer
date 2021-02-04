package com.example.businessorganizer.ui

import android.view.View
import com.example.businessorganizer.databinding.CalendarDayLayoutBinding
import com.example.businessorganizer.databinding.FragmentCalendarBinding
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.ViewContainer
import java.time.LocalDate

class DayViewContainer(
    view: View,
    private val binding: FragmentCalendarBinding
): ViewContainer(view) {
    lateinit var day: CalendarDay
    private var startDate: LocalDate? = null
    private var endDate: LocalDate? = null
    private val today = LocalDate.now()
    val calendarDayText = CalendarDayLayoutBinding.bind(view).calendarDayText

    init {
        view.setOnClickListener {
            if (day.owner == DayOwner.THIS_MONTH && (day.date == today || day.date.isAfter(today))) {
                val date = day.date
                if (startDate != null) {
                    if (date < startDate || endDate != null) {
                        startDate = date
                        endDate = null
                    } else if (date != startDate) {
                        endDate = date
                    }
                } else {
                    startDate = date
                }

                binding.calendarView.notifyCalendarChanged()
                //bindSummaryViews()
            }
        }
    }
}