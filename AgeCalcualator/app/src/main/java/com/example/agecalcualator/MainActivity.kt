package com.example.agecalcualator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var selectDate:TextView
    private lateinit var  calsi :Button
    private lateinit var showAge :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectDate = findViewById(R.id.selectDate)
        calsi = findViewById(R.id.calsi)
        showAge = findViewById(R.id.showAge)
        

    }

    fun selectDate(view: View) {
        var calendar = Calendar.getInstance()
        var calendarDay = calendar.get(Calendar.DAY_OF_MONTH)
        var calendarMonth = calendar.get(Calendar.MONTH)
        var calendarYear = calendar.get(Calendar.YEAR)

        val calendarDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                 view, year , month , dayOfMonth ->
            calendarDay = dayOfMonth
            calendarMonth = month
            calendarYear = year
            calsi.visibility = View.VISIBLE
            textMessage("You Select Date: $calendarDay/${calendarMonth+1}/$calendarYear ")
            calsi.setOnClickListener{
                val currentYear = Calendar.getInstance()
                    .get(Calendar.YEAR)
                if (calendarYear>currentYear) {
                    textMessage("Date is not valid")
                }
                else {
                    val age = currentYear - calendarYear
                    showAge.visibility= View.VISIBLE
                    showAge.text = "Your age is $age year "
                    textMessage("Your age is $age year")
                }
            }
            selectDate.text = "You Select Date: $calendarDay/${calendarMonth+1}/$calendarYear "
        },calendarYear, calendarMonth, calendarDay)

        calendarDialog.show()
    }

    private fun textMessage(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()

    }


}