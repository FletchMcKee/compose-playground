package com.fletchmckee.composeplayground.common.ui.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val LightPlaygroundColorScheme = lightColorScheme(
  primary = Violet,
  onPrimary = Color.White,
  secondary = Piglet,
  onSecondary = Color.White,
  tertiary = Lilac,
)

val DarkPlaygroundColorScheme = darkColorScheme(
  primary = Violet,
  onPrimary = Color.Black,
  secondary = Umbra,
  onSecondary = Color.Black,
  tertiary = Lilac
)

@Composable
fun PlaygroundTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicThemingEnabled: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    supportsDynamicTheming() && dynamicThemingEnabled -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    else -> if (darkTheme) DarkPlaygroundColorScheme else LightPlaygroundColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = PlaygroundTypography,
    content = content,
  )
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
