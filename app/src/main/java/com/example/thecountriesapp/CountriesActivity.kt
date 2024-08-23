package com.example.thecountriesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thecountriesapp.databinding.ActivityCountriesBinding
import com.bumptech.glide.Glide

class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val region = intent.getStringExtra("REGION")
        binding.textViewRegion.text = region

        // Cargar una imagen representativa de la región con Glide
        val imageUrl = getImageUrlForRegion(region)
        Glide.with(this).load(imageUrl).into(binding.imageViewRegion)
    }

    private fun getImageUrlForRegion(region: String?): String {
        return when (region) {
            "Africa" -> "url_de_la_imagen_africa"
            "Americas" -> "url_de_la_imagen_americas"
            "Asia" -> "url_de_la_imagen_asia"
            "Europe" -> "url_de_la_imagen_europa"
            "Oceania" -> "url_de_la_imagen_oceania"
            else -> ""
        }
    }
}
