package com.example.calculatetheage

import android.content.Intent
import android.icu.util.Calendar
import android.icu.util.MeasureUnit.DAY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var year: Int = Calendar.getInstance().get(Calendar.YEAR)
        btn1.setOnClickListener {
            if (bornInY.text.toString() != "") {
                if (bornInY.text.toString().toInt() in 1..year) {
                    val intentGo = Intent(this, enter_month::class.java)
                    intentGo.putExtra("y", bornInY.text.toString())
                    startActivity(intentGo)
                }
                else
                    bornInY.error = "Are you from the future?"
            } else
                bornInY.error = "Please enter the year of birth"
            bornInY.setOnClickListener {
                bornInY.error = null;
            }
        }
    }
}