package com.example.businessorganizer.calendar.binders

import android.graphics.Color
import android.view.View
import androidx.core.view.isInvisible
import com.example.businessorganizer.R
import com.example.businessorganizer.calendar.containers.DayViewContainer
import com.example.businessorganizer.databinding.FragmentCalendarBinding
import com.example.businessorganizer.ui.extension.setBackgroundResource
import com.example.businessorganizer.ui.extension.setTextColor
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder

class DayBinder(private val binding: FragmentCalendarBinding) :
    DayBinder<DayViewContainer> {

    override fun bind(container: DayViewContainer, day: CalendarDay) {
        with(container) {
            this.day = day
            calendarDayText.text = day.date.dayOfMonth.toString()
            if (day.owner == DayOwner.THIS_MONTH) {
                if (day.date == getSelectedDate()) {
                    setTextColor(R.color.rose_red)
                    setBackgroundResource(R.drawable.selection_background)
                } else {
                    setTextColor(Color.BLACK)
                    calendarDayText.background = null
                }
            } else {
                calendarDayText.isInvisible = false
            }
        }
    }

    override fun create(view: View) =
        DayViewContainer(
            view,
            binding
        )
}