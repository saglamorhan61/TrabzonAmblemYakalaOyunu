package com.orhansaglam.trabzonamblemyakalaoyunu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var skor = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        

    }

    fun skoruArttir(view : View){
        skor = skor + 1
        skorText.setText("Skor: $skor")

    }
}