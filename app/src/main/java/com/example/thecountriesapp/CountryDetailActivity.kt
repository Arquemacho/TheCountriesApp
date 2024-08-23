package com.example.thecountriesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.thecountriesapp.databinding.ActivityCountryDetailBinding

class CountryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = intent.getParcelableExtra<Country>("COUNTRY")

        country?.let {
            binding.textViewCountryName.text = it.name
            binding.textViewAlphaCodes.text = "${it.alpha2Code} - ${it.alpha3Code}"
            binding.textViewCurrency.text = "${it.currencyName} (${it.currencySymbol})"
            binding.textViewCurrencyCode.text = it.currencyCode
            binding.textViewLanguage.text = it.nativeLanguage
            binding.textViewRegion.text = "${it.region}/${it.subRegion}"
            binding.textViewArea.text = "Area: ${it.area} km²"
            binding.textViewCoordinates.text = "(${it.latitude}, ${it.longitude})"
            binding.textViewNumericCode.text = it.numericCode

            Glide.with(this).load(it.flagPng).into(binding.imageViewFlag)
        }
    }
}
