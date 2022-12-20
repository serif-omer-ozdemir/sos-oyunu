package com.info.sosoyunu

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.info.sosoyunu.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityMainBinding
    private var player: String = "p1" // birinci oyuncu
    private var s: Int = 0
    private var o: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        renk()

        tasarim.b1.setOnClickListener {
            butonTikla(tasarim.b1)

        }

        tasarim.b2.setOnClickListener {
            butonTikla(tasarim.b2)
        }
        tasarim.b3.setOnClickListener {
            butonTikla(tasarim.b3)
        }
        tasarim.b4.setOnClickListener {
            butonTikla(tasarim.b4)
        }
        tasarim.b5.setOnClickListener {
            butonTikla(tasarim.b5)
        }
        tasarim.b6.setOnClickListener {
            butonTikla(tasarim.b6)
        }
        tasarim.b7.setOnClickListener {
            butonTikla(tasarim.b7)
        }
        tasarim.b8.setOnClickListener {
            butonTikla(tasarim.b8)
        }
        tasarim.b9.setOnClickListener {
            butonTikla(tasarim.b9)
        }

        tasarim.bttonReset.setOnClickListener {
            sifirla()
            sayacSifirla()
            akfifligiAc()
        }


    }


    fun renk(){
        rasgeleRenkVer(tasarim.b1)
        rasgeleRenkVer(tasarim.b2)
        rasgeleRenkVer(tasarim.b3)
        rasgeleRenkVer(tasarim.b4)
        rasgeleRenkVer(tasarim.b5)
        rasgeleRenkVer(tasarim.b6)
        rasgeleRenkVer(tasarim.b7)
        rasgeleRenkVer(tasarim.b8)
        rasgeleRenkVer(tasarim.b9)
    }
    fun rasgeleRenkVer(button: Button) {
        val rnd = Random
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        button.setBackgroundColor(color)
    }

    fun sayacSifirla() {
        s = 0
        o = 0
        tasarim.textViewS.text = "S:0"
        tasarim.textViewO.text = "O:0"
    }

    fun sifirla() {
        tasarim.b1.text = ""
        tasarim.b2.text = ""
        tasarim.b3.text = ""
        tasarim.b4.text = ""
        tasarim.b5.text = ""
        tasarim.b6.text = ""
        tasarim.b7.text = ""
        tasarim.b8.text = ""
        tasarim.b9.text = ""
    }

    fun butonTikla(button: Button) { // buton nesnesıne erıs
        if (button.text == "") {
            if (player == "p1") {
                button.text = "S"
                player = "p2"
            } else {
                button.text = "O"
                player = "p1"
            }
            win()
        }
    }

    fun win() {
        if (
            (tasarim.b1.text == "S" && tasarim.b2.text == "S" && tasarim.b3.text == "S")
            || (tasarim.b4.text == "S" && tasarim.b5.text == "S" && tasarim.b6.text == "S")
            || (tasarim.b7.text == "S" && tasarim.b8.text == "S" && tasarim.b9.text == "S")
            || (tasarim.b1.text == "S" && tasarim.b4.text == "S" && tasarim.b7.text == "S")
            || (tasarim.b2.text == "S" && tasarim.b5.text == "S" && tasarim.b8.text == "S")
            || (tasarim.b3.text == "S" && tasarim.b6.text == "S" && tasarim.b9.text == "S")
            || (tasarim.b1.text == "S" && tasarim.b5.text == "S" && tasarim.b9.text == "S")
            || (tasarim.b3.text == "S" && tasarim.b5.text == "S" && tasarim.b7.text == "S")
        ) {

            s++
            tasarim.textViewS.text = "S: $s"
            alertX()
            akfifligiKapat()
            sayacKontrol()

        } else if ((tasarim.b1.text == "O" && tasarim.b2.text == "O" && tasarim.b3.text == "O")

            || (tasarim.b4.text == "O" && tasarim.b5.text == "O" && tasarim.b6.text == "O")
            || (tasarim.b7.text == "O" && tasarim.b8.text == "O" && tasarim.b9.text == "O")
            || (tasarim.b1.text == "O" && tasarim.b4.text == "O" && tasarim.b7.text == "O")
            || (tasarim.b2.text == "O" && tasarim.b5.text == "O" && tasarim.b8.text == "O")
            || (tasarim.b3.text == "O" && tasarim.b6.text == "O" && tasarim.b9.text == "O")
            || (tasarim.b1.text == "O" && tasarim.b5.text == "O" && tasarim.b9.text == "O")
            || (tasarim.b3.text == "O" && tasarim.b5.text == "O" && tasarim.b7.text == "O")
        ) {

            o++
            tasarim.textViewO.text = "O: $o"
            alertO()
            akfifligiKapat()
            sayacKontrol()
        } else if (tasarim.b1.text != "" && tasarim.b2.text != "" && tasarim.b3.text != ""
            && tasarim.b4.text != "" && tasarim.b5.text != "" && tasarim.b6.text != ""
            && tasarim.b7.text != "" && tasarim.b8.text != "" && tasarim.b9.text != ""

        ) {
            akfifligiKapat()
            alertBerabere()

        }
    }

    fun sayacKontrol() {
        if (s == 3 || o == 3) {
            val nesne = AlertDialog.Builder(this@MainActivity)
            nesne.setTitle("OYUN BİTTİ!")
            nesne.setMessage("Tekrar denemek ister misin ? ")

            nesne.setPositiveButton("TAMAM") { Dialog, i ->
                Toast.makeText(applicationContext, "OYUN BİTTİ", Toast.LENGTH_LONG).show()
                sifirla()
                akfifligiAc()
            }

            nesne.show()
        }

        akfifligiKapat()
    }


    fun alertBerabere() {
        val nesne = AlertDialog.Builder(this@MainActivity)
        nesne.setTitle("KİMSE KAZANAMADI!")
        nesne.setMessage("Tekrar denemek ister misin ? ")

        nesne.setPositiveButton("Evet") { Dialog, i ->
            sifirla()
            akfifligiAc()
        }
        nesne.setNegativeButton("Hayir") { Dialog, i ->
            sifirla()
            akfifligiKapat()
        }
        nesne.show()
    }

    fun alertX() {
        val nesne = AlertDialog.Builder(this@MainActivity)
        nesne.setTitle(" 'S' kisisi kazandi")
        nesne.setMessage("Devam etmek ister misin ? ")

        nesne.setPositiveButton("Evet") { Dialog, i ->
            sifirla()
            akfifligiAc()
        }
        nesne.setNegativeButton("Hayir") { Dialog, i ->
            akfifligiKapat()
        }
        nesne.show()
    }

    fun alertO() {
        val nesne = AlertDialog.Builder(this@MainActivity)
        nesne.setTitle(" 'O' kisisi kazandi")
        nesne.setMessage("Devam etmek ister misin ? ")

        nesne.setPositiveButton("Evet") { Dialog, i ->
            sifirla()
            akfifligiAc()
        }
        nesne.setNegativeButton("Hayir") { Dialog, i ->
            sifirla()
            akfifligiKapat()

        }
        nesne.show()
    }

    fun akfifligiKapat() {
        tasarim.b1.isEnabled = false
        tasarim.b2.isEnabled = false
        tasarim.b3.isEnabled = false
        tasarim.b4.isEnabled = false
        tasarim.b5.isEnabled = false
        tasarim.b6.isEnabled = false
        tasarim.b7.isEnabled = false
        tasarim.b8.isEnabled = false
        tasarim.b9.isEnabled = false
    }

    fun akfifligiAc() {
        tasarim.b1.isEnabled = true
        tasarim.b2.isEnabled = true
        tasarim.b3.isEnabled = true
        tasarim.b4.isEnabled = true
        tasarim.b5.isEnabled = true
        tasarim.b6.isEnabled = true
        tasarim.b7.isEnabled = true
        tasarim.b8.isEnabled = true
        tasarim.b9.isEnabled = true
    }

}