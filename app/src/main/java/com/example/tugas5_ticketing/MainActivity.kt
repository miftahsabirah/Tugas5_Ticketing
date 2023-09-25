package com.example.tugas5_ticketing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tugas5_ticketing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jenisTiket = arrayOf(
            "Ekonomi",
            "Ekonomi Premium",
            "Bisnis",
            "Eksekutif"
        )

        with(binding) {
            val jenisTiketAdapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item, jenisTiket
            )
            jenisTiketAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinJenisTiket.adapter = jenisTiketAdapter


            var selectedDate = ""
            datePick.init(
                datePick.year,
                datePick.month,
                datePick.dayOfMonth
            ) { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year"
            }

            var selectedTime = ""
            timePick.setOnTimeChangedListener { _, timeOfDay, minute ->
                selectedTime = String.format("%02d:%02d", timeOfDay, minute)
            }

            tombol.setOnClickListener{
                val selectedTicket = spinJenisTiket.selectedItem.toString()
                val tombol = "Pemesanan tiket $selectedTicket untuk \ntanggal $selectedDate pada jam $selectedTime"
                Toast.makeText(this@MainActivity, tombol,Toast.LENGTH_SHORT).show()
            }


//
        }
    }
}