package com.example.businessorganizer.ui.calendar

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.businessorganizer.R
import com.example.businessorganizer.adapters.CalendarAdapter
import com.example.businessorganizer.calendar.binders.DayBinder
import com.example.businessorganizer.calendar.binders.MonthHeaderBinder
import com.example.businessorganizer.databinding.FragmentCalendarBinding
import com.example.businessorganizer.ui.extension.daysOfWeekFromLocale
import com.example.businessorganizer.ui.extension.setTextColorRes
import com.example.businessorganizer.utils.BusinessDateUtils.getCurrentMonth
import com.example.businessorganizer.utils.BusinessDateUtils.getFirstDayOfWeek
import com.example.businessorganizer.utils.BusinessDateUtils.getFirstMonth
import com.example.businessorganizer.utils.BusinessDateUtils.getLastMonth
import com.example.businessorganizer.utils.DrawableUtils
import com.example.businessorganizer.utils.LOCALE
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

private const val TEXT_SIZE = 15f
private const val TIME_FORMATTER = "MMMM"

class CalendarFragment : Fragment() {

    private var binding: FragmentCalendarBinding? = null
    private val monthTitleFormatter = DateTimeFormatter.ofPattern(TIME_FORMATTER)
    private val viewModel: CalendarViewModel by viewModels()

    private val startBackground: GradientDrawable by lazy {
        DrawableUtils.getBackgroundDrawable(
            requireContext(),
            R.drawable.continuous_selected_bg_start
        )
    }

    private val endBackground: GradientDrawable by lazy {
        DrawableUtils.getBackgroundDrawable(requireContext(), R.drawable.continuous_selected_bg_end)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setRecyclerView() Todo: configure RW
        setCalendarView()
        setOrderOfDays()
    }

    private fun setRecyclerView() {
        binding?.let { binding ->
            binding.rvTasks.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                adapter = CalendarAdapter()
                addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            }
        }
    }

    private fun setCalendarView() {
        binding?.let { binding ->
            with(binding.calendarView) {
                dayBinder = DayBinder(binding)
                monthHeaderBinder = MonthHeaderBinder(binding)
                setup(getFirstMonth(), getLastMonth(), getFirstDayOfWeek())
                scrollToMonth(getCurrentMonth())
            }
        }
    }

    private fun setOrderOfDays() {
        val daysOfWeek = daysOfWeekFromLocale()
        binding?.let { binding ->
            binding.legendLayout.root.children.forEachIndexed { index, view ->
                (view as TextView).apply {
                    text = daysOfWeek[index].getDisplayName(TextStyle.NARROW, Locale(LOCALE))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, TEXT_SIZE)
                    setTextColorRes(R.color.grey)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}