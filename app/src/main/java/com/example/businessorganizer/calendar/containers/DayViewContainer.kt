package com.example.businessorganizer.calendar.containers

import android.view.View
import com.example.businessorganizer.databinding.CalendarDayLayoutBinding
import com.example.businessorganizer.databinding.FragmentCalendarBinding
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.ViewContainer
import java.time.LocalDate

class DayViewContainer(
    view: View,
    fragmentBinding: FragmentCalendarBinding
) : ViewContainer(view) {
    lateinit var day: CalendarDay
    private val calendarDayBinding = CalendarDayLayoutBinding.bind(view)
    private val calendarView = fragmentBinding.calendarView
    val calendarDayText = calendarDayBinding.calendarDayText
    private var selectedDate: LocalDate? = null

    init {
        view.setOnClickListener {
            with(calendarView) {
                monthScrollListener = {
                    selectedDate?.let { date ->
                        // Clear selection if we scroll to a new month.
                        selectedDate = null
                        notifyDateChanged(date)
                    }
                }
                if (day.owner == DayOwner.THIS_MONTH) {
                    val currentSelection = selectedDate
                    if (currentSelection == day.date) {
                        selectedDate = null
                        notifyDateChanged(currentSelection)
                    } else {
                        selectedDate = day.date
                        notifyDateChanged(day.date)
                        if (currentSelection != null) {
                            notifyDateChanged(currentSelection)
                        }
                    }
                }
            }

        }
    }

    fun getSelectedDate(): LocalDate? {
        return selectedDate?.let {
            return@let LocalDate.of(it.year, it.month, it.dayOfMonth)
        }
    }
}