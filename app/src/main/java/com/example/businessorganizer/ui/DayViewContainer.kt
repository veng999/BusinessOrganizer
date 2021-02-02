package com.example.businessorganizer.ui

import android.view.View
import com.example.businessorganizer.databinding.CalendarDayLayoutBinding
import com.kizitonwose.calendarview.ui.ViewContainer

class DayViewContainer(view: View): ViewContainer(view){
    val calendarDayText = CalendarDayLayoutBinding.bind(view).calendarDayText
}