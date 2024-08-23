package com.example.thecountriesapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thecountriesapp.databinding.ActivityCountriesListBinding
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

class CountriesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val region = intent.getStringExtra("REGION")
        Log.d("CountriesListActivity", "Selected region: $region")

        // Cargar el archivo JSON
        val countriesJson = assets.open("paises.json").bufferedReader().use { it.readText() }
        Log.d("CountriesListActivity", "JSON content loaded")

        // Parsear el JSON principal que contiene el objeto con "Countries"
        val jsonObject = Gson().fromJson(countriesJson, JsonObject::class.java)

        // Obtener el array "Countries" del JSON
        val countriesArray = jsonObject.getAsJsonArray("Countries")
        Log.d("CountriesListActivity", "Countries array size: ${countriesArray.size()}")

        // Deserializar el array a una lista de objetos `Country`
        val countriesType = object : TypeToken<List<Country>>() {}.type
        val countries: List<Country> = Gson().fromJson(countriesArray, countriesType)

        // Log para cada país
        countries.forEach { country ->
            Log.d("CountriesListActivity", "Country: ${country.name}, Region: ${country.region}")
        }

        // Filtrar los países por región
        val filteredCountries = countries.filter { it.region.equals(region, ignoreCase = true) }
        Log.d("CountriesListActivity", "Countries found for region: ${filteredCountries.size}")

        // Mostrar un mensaje si no hay países encontrados
        if (filteredCountries.isEmpty()) {
            Toast.makeText(this, "No countries found for the region $region", Toast.LENGTH_SHORT).show()
        }

        // Configurar el RecyclerView con el adaptador
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CountriesAdapter(filteredCountries, this::onCallButtonClick)
    }

    private fun onCallButtonClick(numericCode: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$numericCode")
        }
        startActivity(intent)
    }
}
