package com.example.businessorganizer.calendar.containers

import android.view.View
import com.example.businessorganizer.databinding.CalendarMonthHeaderLayoutBinding
import com.kizitonwose.calendarview.ui.ViewContainer

class MonthViewHeaderContainer(view: View) : ViewContainer(view) {
    val mothTextView = CalendarMonthHeaderLayoutBinding.bind(view).headerMonth
}