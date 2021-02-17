package com.orhansaglam.trabzonamblemyakalaoyunu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

                //Uyari Mesaji
                val uyariMesaji = android.app.AlertDialog.Builder(this@MainActivity)
                uyariMesaji.setTitle("Oyun Bitti.")
                uyariMesaji.setMessage("Tekrar oynamak ister misiniz?")
                uyariMesaji.setPositiveButton("Evet") { dialog, which ->

                    val intent = Intent(this@MainActivity,MainActivity::class.java)
                    finish()
                    startActivity(intent)

                }
                uyariMesaji.setNegativeButton("Hayır", object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity,"Oyun Bitti.",Toast.LENGTH_LONG).show()
                    }

                })
                uyariMesaji.show()
            }

        }.start()
    }

    fun skoruArttir(view : View){
        skor = skor + 1
        skorText.setText("Skor: $skor")

    }
}