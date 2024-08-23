package com.example.thecountriesapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.thecountriesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el Spinner con las regiones
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.regions_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerRegions.adapter = adapter

        // Configurar el botón para enviar la región seleccionada
        binding.buttonListCountries.setOnClickListener {
            val selectedRegion = binding.spinnerRegions.selectedItem.toString()
            val intent = Intent(this, CountriesListActivity::class.java).apply {
                putExtra("REGION", selectedRegion)
            }
            startActivity(intent)
        }
    }
}
