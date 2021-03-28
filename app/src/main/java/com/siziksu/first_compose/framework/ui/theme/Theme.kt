package com.siziksu.first_compose.framework.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.siziksu.first_compose.R

val NunitoFontFamily = FontFamily(
    Font(R.font.nunito, FontWeight.Light),
    Font(R.font.nunito, FontWeight.Normal),
    Font(R.font.nunito_semibold, FontWeight.SemiBold),
    Font(R.font.nunito_bold, FontWeight.Bold)
)

@Suppress("LongMethod")
@Composable
fun AppComposeTheme(content: @Composable () -> Unit) {
    val colors = darkColors(
        primary = AppColors.Blue100,
        surface = AppColors.Blue900,
        background = AppColors.Blue900,
        onSurface = Color.White,
        onBackground = Color.White
    )

    @Suppress("MagicNumber")
    val typography = Typography(
        defaultFontFamily = NunitoFontFamily,
        h1 = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            letterSpacing = 2.sp
        ),
        h2 = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,
            letterSpacing = 2.sp
        ),
        h3 = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = 2.sp
        ),
        h4 = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            letterSpacing = 2.sp
        ),
        h5 = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            letterSpacing = 2.sp
        ),
        h6 = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 17.sp,
            letterSpacing = 2.sp
        ),
        body1 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.5.sp
        ),
        body2 = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.5.sp
        ),
        subtitle1 = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 14.sp,
            letterSpacing = 0.5.sp
        ),
        subtitle2 = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 13.sp,
            letterSpacing = 0.5.sp
        ),
        button = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            letterSpacing = 0.5.sp
        ),
        caption = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            letterSpacing = 0.5.sp
        ),
        overline = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 10.sp,
            letterSpacing = 0.5.sp
        )
    )
    MaterialTheme(
        colors = colors,
        typography = typography,
        content = content
    )
}

@Composable
fun DialogThemeOverlay(content: @Composable () -> Unit) {
    val dialogColors = darkColors(
        primary = Color.White,
        surface = Color.White.copy(alpha = 0.12f).compositeOver(Color.Black),
        onSurface = Color.White
    )

    val currentTypography = MaterialTheme.typography
    val dialogTypography = currentTypography.copy(
        body2 = currentTypography.body1.copy(
            fontWeight = FontWeight.Normal,
            fontSize = SpUnit.VALUE_20,
            lineHeight = SpUnit.VALUE_28,
            letterSpacing = SpUnit.VALUE_1
        ),
        button = currentTypography.button.copy(
            fontWeight = FontWeight.Bold,
            letterSpacing = EmUnit.VALUE_0_2
        )
    )
    MaterialTheme(colors = dialogColors, typography = dialogTypography, content = content)
}
