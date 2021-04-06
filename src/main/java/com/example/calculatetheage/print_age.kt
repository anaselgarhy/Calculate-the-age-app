package com.example.calculatetheage

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_print_age.*

class print_age : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print_age)
        //
        var year = Calendar.getInstance().get(Calendar.YEAR)
        var month = (Calendar.getInstance().get(Calendar.MONTH))+1 //1..12
        var day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        //
        val yearH :Int = intent.getStringExtra("y").toString().toInt()
        val monthH :Int = intent.getStringExtra("m").toString().toInt()
        val dayH :Int = intent.getStringExtra("d").toString().toInt()
        //
        var he_year = 0
        var he_month = 0
        var he_day = 0

        if(yearH == year) {
            println("if start ")
            he_year = 0;
            if(monthH == month){
                he_month = 0;
                if(dayH < day) {
                    for(i in dayH until day)
                        he_day++
                } else{
                    he_day = 0
                }
            } else {
                for(i in monthH until month)
                    he_month++
                for(i in dayH until day)
                    he_day++
            }
        } else {
            if (dayH >  day) {
                month -= 1;
                day += 30;
            }
            if (monthH > month) {
                year -= 1;
                month += 12;
            }

            he_year = year - yearH
            he_month = month - monthH
            he_day = day - dayH
        }


        vYear.text = "$he_year  Years"
        vMonth.text = "$he_month Month"
        vDay.text = "$he_day Days"

        btnE.setOnClickListener{
            val intentF = Intent(this , MainActivity::class.java)
            startActivity(intentF)
            finish()
            }
    }
}

