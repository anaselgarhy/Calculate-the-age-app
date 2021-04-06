package com.example.calculatetheage

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_enter_day.*
import kotlinx.android.synthetic.main.activity_enter_day.btn1
import kotlinx.android.synthetic.main.activity_main.*

class enter_day : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_day)
        val year = Calendar.getInstance().get(Calendar.YEAR)
        var month = (Calendar.getInstance().get(Calendar.MONTH))+1 // دلة مونث بترجع0..11
        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val intentGo = Intent(this, print_age::class.java)
        val yearH = intent.getStringExtra("y").toString()
        val monthH = intent.getStringExtra("m").toString()
        btn1.setOnClickListener{
            if(bornInD.text.toString() != "") {
                if(yearH.toInt() != year || ((yearH.toInt() == year) && (monthH.toInt() != month))) {
                    if (bornInD.text.toString().toInt() in 1..31) {
                        intentGo.putExtra("d", bornInD.text.toString())
                        intentGo.putExtra("y", yearH)
                        intentGo.putExtra("m", monthH)
                        startActivity(intentGo)
                    } else
                        bornInD.error = "Are you from space"
                } else{
                    if(monthH.toInt() == month) {
                        if (bornInD.text.toString().toInt() in 1..day) {
                            intentGo.putExtra("d", bornInD.text.toString())
                            intentGo.putExtra("y", yearH)
                            intentGo.putExtra("m", monthH)
                            startActivity(intentGo)
                        } else {
                            bornInD.error = "Are you from the future ?";
                        }
                    }
                }
            }
            else
                bornInD.error = "Please enter your birthday"
            bornInD.setOnClickListener{
                bornInD.error = null;
            }
        }
    }
}