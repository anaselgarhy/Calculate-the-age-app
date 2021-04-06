package com.example.calculatetheage

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_enter_month.*
import kotlinx.android.synthetic.main.activity_enter_month.btn1
import kotlinx.android.synthetic.main.activity_main.*

class enter_month : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_month)
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val month = (Calendar.getInstance().get(Calendar.MONTH))//0..11
        val yearH = intent.getStringExtra("y").toString()
        btn1.setOnClickListener{
            if(bornInM.text.toString() != "") {
                if(yearH.toInt() != year) {
                    if (bornInM.text.toString().toInt() in 1..12) {
                        val intentGo = Intent(this, enter_day::class.java)
                        intentGo.putExtra("m", bornInM.text.toString())
                        intentGo.putExtra("y", yearH)
                        startActivity(intentGo)
                    } else
                        bornInM.error = "I am not stupid !";
                } else{

                    if (bornInM.text.toString().toInt() in 1..month+1) {
                        val intentGo = Intent(this, enter_day::class.java)
                        intentGo.putExtra("m", bornInM.text.toString())
                        intentGo.putExtra("y", yearH)
                        startActivity(intentGo)
                    } else
                        bornInM.error = "Are you from the future?";
                }
            }
            else
                bornInM.error = "Please enter the month of birth"
            bornInM.setOnClickListener {
                bornInM.error = null;
            }
        }
    }
}