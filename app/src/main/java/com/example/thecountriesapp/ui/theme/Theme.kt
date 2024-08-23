package com.example.thecountriesapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Definición de colores para los temas claros y oscuros
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1565C0), // Azul oscuro
    secondary = Color(0xFF1565C0),
    tertiary = Color(0xFF1976D2)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1976D2), // Azul principal
    secondary = Color(0xFF1976D2),
    tertiary = Color(0xFF1565C0)

    /* Otros colores predeterminados que puedes sobreescribir
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun TheCountriesAPPTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
