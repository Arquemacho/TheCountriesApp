package com.example.thecountriesapp

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Country(
    @SerializedName("Name")
    val name: String,

    @SerializedName("NativeName")
    val nativeName: String,

    @SerializedName("Alpha2Code")
    val alpha2Code: String,

    @SerializedName("Alpha3Code")
    val alpha3Code: String,

    @SerializedName("Region")
    val region: String,

    @SerializedName("SubRegion")
    val subRegion: String,

    @SerializedName("Latitude")
    val latitude: String,

    @SerializedName("Longitude")
    val longitude: String,

    @SerializedName("Area")
    val area: Int,

    @SerializedName("NumericCode")
    val numericCode: String,

    @SerializedName("NativeLanguage")
    val nativeLanguage: String,

    @SerializedName("CurrencyCode")
    val currencyCode: String,

    @SerializedName("CurrencyName")
    val currencyName: String,

    @SerializedName("CurrencySymbol")
    val currencySymbol: String,

    @SerializedName("Flag")
    val flag: String,

    @SerializedName("FlagPng")
    val flagPng: String
) : Parcelable
