package com.example.aplikasinilai

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        val tvSapaan = findViewById<TextView>(R.id.tvSapaan)
        val etJumlah = findViewById<EditText>(R.id.etJumlah)
        val etNilai = findViewById<EditText>(R.id.etNilai)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // Ambil nama dari halaman 1
        val nama = intent.getStringExtra("nama")
        tvSapaan.text = "Selamat bertugas, Dosen $nama"

        btnProses.setOnClickListener {
            val jumlah = etJumlah.text.toString().toIntOrNull() ?: 0
            val nilai = etNilai.text.toString().toIntOrNull() ?: 0

            val status = when {
                nilai >= 80 -> "Sangat Baik"
                nilai >= 60 -> "Cukup"
                else -> "Kurang"
            }

            var hasil = ""
            for (i in 1..jumlah) {
                hasil += "Mahasiswa $i: $status\n"
            }

            tvHasil.text = hasil
        }
    }
}