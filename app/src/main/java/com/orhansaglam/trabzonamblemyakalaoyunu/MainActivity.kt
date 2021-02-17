package com.orhansaglam.trabzonamblemyakalaoyunu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var skor = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CountDownTimer
        object : CountDownTimer(15000,1000){
            override fun onTick(millisUntilFinished: Long) {
                zamanText.setText("Zaman: ${millisUntilFinished/1000}")
            }

            override fun onFinish() {
                zamanText.setText("Zaman: 0")
            }

        }.start()
    }

    fun skoruArttir(view : View){
        skor = skor + 1
        skorText.setText("Skor: $skor")

    }
}