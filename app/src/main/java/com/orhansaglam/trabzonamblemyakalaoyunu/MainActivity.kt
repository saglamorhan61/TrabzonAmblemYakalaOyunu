package com.orhansaglam.trabzonamblemyakalaoyunu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.DisplayMetrics
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var skor = 0
    var koordinatListesi = ArrayList<Pair<Float,Float>>()
    var runnable : Runnable = Runnable{ }
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Metrik alma

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val uzunluk = displayMetrics.heightPixels.toFloat()
        val genislik = displayMetrics.widthPixels.toFloat()

        // Pair
        val koordinat1 = Pair(genislik/-6,uzunluk/4)
        val koordinat2 = Pair(genislik/6,uzunluk/4)
        val koordinat3 = Pair(genislik/9,uzunluk/7)
        val koordinat4 = Pair(genislik/6,uzunluk/-7)
        val koordinat5 = Pair(genislik/-6,uzunluk/-7)
        val koordinat6 = Pair(genislik/6,uzunluk/6)
        koordinatListesi.add(koordinat1)
        koordinatListesi.add(koordinat2)
        koordinatListesi.add(koordinat3)
        koordinatListesi.add(koordinat4)
        koordinatListesi.add(koordinat5)
        koordinatListesi.add(koordinat6)




        //CountDownTimer
        object : CountDownTimer(15000,1000){
            override fun onTick(millisUntilFinished: Long) {
                zamanText.setText("Zaman: ${millisUntilFinished/1000}")
            }

            override fun onFinish() {
                zamanText.setText("Zaman: 0")
                handler.removeCallbacks(runnable)

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

        amblemiHareketEttir()
    }

    fun amblemiHareketEttir(){

        runnable = object : Runnable{
            override fun run() {
                val random = Random()
                val rastgeleIndex = random.nextInt(6)
                imageView.x = koordinatListesi[rastgeleIndex].first
                imageView.y = koordinatListesi[rastgeleIndex].second
                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)

    }

    fun skoruArttir(view : View){
        skor = skor + 1
        skorText.setText("Skor: $skor")

    }
}