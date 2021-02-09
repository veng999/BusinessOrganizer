package com.example.businessorganizer.calendar.binders

import android.view.View
import com.example.businessorganizer.calendar.containers.MonthViewHeaderContainer
import com.example.businessorganizer.databinding.FragmentCalendarBinding
import com.example.businessorganizer.utils.BusinessDateUtils
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder

class MonthHeaderBinder(private val binding: FragmentCalendarBinding) :
    MonthHeaderFooterBinder<MonthViewHeaderContainer> {
    override fun bind(container: MonthViewHeaderContainer, month: CalendarMonth) {
        container.mothTextView.text = BusinessDateUtils.getMontAndYearForHeader(month)
    }

    override fun create(view: View): MonthViewHeaderContainer = MonthViewHeaderContainer(view)

}