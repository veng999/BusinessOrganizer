package com.example.businessorganizer.ui

import android.graphics.Color
import android.view.View
import com.example.businessorganizer.databinding.FragmentCalendarBinding
import com.example.businessorganizer.ui.extension.setTextColor
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder

class BusinessDayBinder(private val binding: FragmentCalendarBinding) : DayBinder<DayViewContainer> {
    override fun bind(container: DayViewContainer, day: CalendarDay) {
        container.apply {
            this.day = day
            calendarDayText.text = day.date.dayOfMonth.toString()
        }

        if (day.owner == DayOwner.THIS_MONTH) {
            container.setTextColor(Color.BLACK)
        } else {
            container.setTextColor(Color.GRAY)
        }
    }

    override fun create(view: View) = DayViewContainer(view, binding)
}