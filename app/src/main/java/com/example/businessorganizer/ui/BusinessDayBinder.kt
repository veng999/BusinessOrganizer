package com.example.businessorganizer.ui

import android.view.View
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder

class BusinessDayBinder : DayBinder<DayViewContainer> {
    override fun bind(container: DayViewContainer, day: CalendarDay) {
        container.calendarDayText.text = day.date.dayOfMonth.toString()
    }

    override fun create(view: View) = DayViewContainer(view)
}