package com.example.composeprofilecardlayout.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import shapes

private val DarkColorScheme = darkColorScheme(
    primary = CyanColor80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    surface = VeryLightGray
)

private val LightColorScheme = lightColorScheme(
    primary = CyanColor40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    surface = VeryLightGray

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) DarkColorScheme else LightColorScheme //dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = shapes
    )

    // logic for which custom palette to use
    val customColorsPalette = if (darkTheme) DarkCustomColorsPalette else LightCustomColorsPalette

    /**
     * here is the important point, where you will expose custom objects
     */
    CompositionLocalProvider(
        LocalCustomColorsPalette provides customColorsPalette // our custom palette
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}