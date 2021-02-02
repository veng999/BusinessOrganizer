package com.example.businessorganizer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.businessorganizer.databinding.FragmentCalendarBinding
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

class CalendarFragment : Fragment() {

    private var binding: FragmentCalendarBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek

        binding?.let { binding ->
            with(binding.calendarView){
                dayBinder = BusinessDayBinder()
                setup(firstMonth, lastMonth, firstDayOfWeek)
                scrollToMonth(currentMonth)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}