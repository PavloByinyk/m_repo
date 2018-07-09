package com.example.gottgried.castomcalendar.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.gottgried.castomcalendar.EventItem
import com.example.gottgried.castomcalendar.R
import com.example.gottgried.castomcalendar.interfaces.OnCalendarSwipeListener
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Gottgried on 02.07.2018.
 */
class CalendarView  constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var MAX_EVENT = 3

    companion object {
        const val monthYearFormat = "MMM yyyy"
        const val dateFormat = "dd-MM-yyyy"
        const val dateTimeFormat = "dd-MM-yyyy hh:mm:ss"
        const val EXTRA_MARGIN = 15
        const val POST_TIME: Long = 100
    }

    private var eventList: ArrayList<EventItem> = ArrayList()
    private var calender: Calendar = Calendar.getInstance()
    private var layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    private var dayViewHeader: View = layoutInflater.inflate(R.layout.layout_day_header_view, this, false)

    private var dayViewRow1: FrameLayout = layoutInflater.inflate(R.layout.layout_day_date_view, this, false) as FrameLayout
    private var dayViewRow2: FrameLayout = layoutInflater.inflate(R.layout.layout_day_date_view, this, false) as FrameLayout
    private var dayViewRow3: FrameLayout = layoutInflater.inflate(R.layout.layout_day_date_view, this, false) as FrameLayout
    private var dayViewRow4: FrameLayout = layoutInflater.inflate(R.layout.layout_day_date_view, this, false) as FrameLayout
    private var dayViewRow5: FrameLayout = layoutInflater.inflate(R.layout.layout_day_date_view, this, false) as FrameLayout
    private var dayViewRow6: FrameLayout = layoutInflater.inflate(R.layout.layout_day_date_view, this, false) as FrameLayout

    private var monthTitle: TextView? = dayViewHeader.findViewById(R.id.txt_monthTitle) as TextView
    private var btn_next: ImageView? = dayViewHeader.findViewById(R.id.btn_next) as ImageView
    private var btn_previous: ImageView? = dayViewHeader.findViewById(R.id.btn_previous) as ImageView


    init {
        removeAllViews()  //In-built function in LinearLayout
        orientation = LinearLayout.VERTICAL
        addView(dayViewHeader)
        addView(dayViewRow1)
        addView(dayViewRow2)
        addView(dayViewRow3)
        addView(dayViewRow4)
        addView(dayViewRow5)
        addView(dayViewRow6)

        monthTitle?.text = SimpleDateFormat(monthYearFormat, Locale.getDefault()).format(calender.time)
        btn_next?.setOnClickListener { nextMonth() }
        btn_previous?.setOnClickListener { previousMonth() }


        setOnTouchListener(object : OnCalendarSwipeListener(context) {
            override fun onSwipeLeft() {
                nextMonth()
            }
            override fun onSwipeRight() {
                previousMonth()
            }
        })

        updateEventView(true)


        var selectedCalender: Calendar = Calendar.getInstance()
        //This will get current calender time of system

        selectedCalender.set(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DATE))
        //This will set selectedCalender to selected month and year by next/previous buttons

        //This will set date to first
        selectedCalender.set(Calendar.DATE, 1)
        selectedCalender.set(Calendar.HOUR, 0)
        selectedCalender.set(Calendar.MINUTE, 0)
        selectedCalender.set(Calendar.SECOND, 0)
        calender.set(Calendar.DATE, 1)

        //This will count total days in selected month
        var totalDaysToShow: Int = calender.getActualMaximum(Calendar.DAY_OF_MONTH)

        //total days extra to be added from previous month
        val toFillInPreviousMonthDays = 1 - calender.get(Calendar.DAY_OF_WEEK)

        calender.set(Calendar.DATE, totalDaysToShow)

//total days extra to be added from next month
        val toFillInNextMonthDays = 7 - calender.get(Calendar.DAY_OF_WEEK)

//total days to count max weeks in a month
        totalDaysToShow += Math.abs(toFillInPreviousMonthDays) + toFillInNextMonthDays

        calender.set(Calendar.DATE, 1)

        if (toFillInPreviousMonthDays != 0) {
            selectedCalender.add(Calendar.DAY_OF_YEAR, toFillInPreviousMonthDays)
        }


        //Now, count max. number of weeks in a selected month do the below code which will give to show number of week layouts in a view and based on this make extra weeks visible or hidden and remove all the events which added before.
        val totalRows = totalDaysToShow.div(7)
        when (totalRows) {
            4 -> {
                dayViewRow5.visibility = View.GONE
                dayViewRow6.visibility = View.GONE
            }
            5 -> {
                dayViewRow5.visibility = View.VISIBLE
                dayViewRow6.visibility = View.GONE
            }
            else -> {
                dayViewRow5.visibility = View.VISIBLE
                dayViewRow6.visibility = View.VISIBLE
            }
        }
        val dateFormatter = SimpleDateFormat(dateFormat, Locale.getDefault())

        (dayViewRow1.findViewById(R.id.layout_tripEvents) as LinearLayout).removeAllViews()
        (dayViewRow2.findViewById(R.id.layout_tripEvents) as LinearLayout).removeAllViews()
        (dayViewRow3.findViewById(R.id.layout_tripEvents) as LinearLayout).removeAllViews()
        (dayViewRow4.findViewById(R.id.layout_tripEvents) as LinearLayout).removeAllViews()
        (dayViewRow5.findViewById(R.id.layout_tripEvents) as LinearLayout).removeAllViews()
        (dayViewRow6.findViewById(R.id.layout_tripEvents) as LinearLayout).removeAllViews()



    }





    fun nextMonth() {
        calender.add(Calendar.MONTH, 1)
        monthTitle?.text = SimpleDateFormat(monthYearFormat, Locale.getDefault()).format(calender.time)
        updateEventView()
    }
    fun previousMonth() {
        calender.add(Calendar.MONTH, -1)
        monthTitle?.text = SimpleDateFormat(monthYearFormat, Locale.getDefault()).format(calender.time)
        updateEventView()
    }
    private fun updateEventView(firstTime: Boolean = false) {
        //Will implement this in next Part, Part-2
    }
}