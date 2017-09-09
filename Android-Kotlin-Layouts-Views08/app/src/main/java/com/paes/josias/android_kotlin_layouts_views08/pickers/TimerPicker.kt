package com.paes.josias.android_kotlin_layouts_views08.pickers

import android.app.Dialog
import android.app.DialogFragment
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import java.util.*

/**
 * Created by Josias on 18/08/2017.
 */
class TimerPicker: DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var calendar:Calendar = Calendar.getInstance()
        var hour:Int = calendar.get(Calendar.HOUR_OF_DAY)
        var minute:Int = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(activity, this, hour, minute, true)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(activity, "Hour selected: " +
                "${hourOfDay}:${minute}", Toast.LENGTH_LONG).show()
    }
}

