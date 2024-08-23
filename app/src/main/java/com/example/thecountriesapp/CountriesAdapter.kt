package com.example.thecountriesapp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.thecountriesapp.databinding.ItemCountryBinding

class CountriesAdapter(
    private val countries: List<Country>,
    private val onCallButtonClick: (String) -> Unit
) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    inner class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country) {
            binding.textViewCountryName.text = country.name
            binding.textViewNativeName.text = country.nativeName
            binding.textViewCurrency.text = "${country.alpha3Code}    ${country.currencyName} (${country.currencySymbol})"

            Glide.with(binding.imageViewFlag.context)
                .load(country.flagPng)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(binding.imageViewFlag)

            binding.fabCall.setOnClickListener {
                onCallButtonClick(country.numericCode)
            }

            // Añadir clic para abrir la actividad de detalles
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, CountryDetailActivity::class.java).apply {
                    putExtra("COUNTRY", country)
                }
                binding.root.context.startActivity(intent)
            }
        }
    }
}
