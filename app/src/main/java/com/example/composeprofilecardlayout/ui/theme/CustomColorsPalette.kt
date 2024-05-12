package com.example.composeprofilecardlayout.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorsPalette(
    val extraGreenColor: Color = Color.Unspecified,
    val extraRedColor: Color = Color.Unspecified,
    val extraColor3: Color = Color.Unspecified
)

val LightGreen200 = Color(0x9932CD32)
val DarkGreen800 = Color(229, 252, 178)

val LightRed200 = Color(223, 16, 6)
val DarkRed800 = Color(253, 181, 177)

val LightCustomColorsPalette = CustomColorsPalette(
    extraGreenColor = LightGreen200,
    extraRedColor = LightRed200
)

val DarkCustomColorsPalette = CustomColorsPalette(
    extraGreenColor = DarkGreen800,
    extraRedColor = DarkRed800
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }