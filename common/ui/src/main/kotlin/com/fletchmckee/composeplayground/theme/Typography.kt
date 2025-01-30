package com.fletchmckee.composeplayground.common.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.LineHeightStyle.Alignment
import androidx.compose.ui.text.style.LineHeightStyle.Trim
import androidx.compose.ui.unit.sp
import com.fletchmckee.composeplayground.common.R

private val balooBhai2FontFamily = FontFamily(
  Font(R.font.baloo_bhai_2_regular, FontWeight.Normal),
  Font(R.font.baloo_bhai_2_medium, FontWeight.Medium),
  Font(R.font.baloo_bhai_2_semi_bold, FontWeight.SemiBold),
  Font(R.font.baloo_bhai_2_bold, FontWeight.Bold),
  Font(R.font.baloo_bhai_2_extra_bold, FontWeight.ExtraBold),
)

internal val PlaygroundTypography = Typography(
  displayLarge = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 57.sp,
    lineHeight = 64.sp,
    letterSpacing = (-0.25).sp,
  ),
  displayMedium = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 45.sp,
    lineHeight = 52.sp,
    letterSpacing = 0.sp,
  ),
  displaySmall = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 36.sp,
    lineHeight = 44.sp,
    letterSpacing = 0.sp,
  ),
  headlineLarge = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 32.sp,
    lineHeight = 40.sp,
    letterSpacing = 0.sp,
  ),
  headlineMedium = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 28.sp,
    lineHeight = 36.sp,
    letterSpacing = 0.sp,
  ),
  headlineSmall = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 24.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.sp,
    lineHeightStyle = LineHeightStyle(
      alignment = Alignment.Bottom,
      trim = Trim.None,
    ),
  ),
  titleLarge = TextStyle(
    fontWeight = FontWeight.Bold,
    fontFamily = balooBhai2FontFamily,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
    lineHeightStyle = LineHeightStyle(
      alignment = Alignment.Bottom,
      trim = Trim.LastLineBottom,
    ),
  ),
  titleMedium = TextStyle(
    fontWeight = FontWeight.Bold,
    fontFamily = balooBhai2FontFamily,
    fontSize = 18.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.1.sp,
  ),
  titleSmall = TextStyle(
    fontWeight = FontWeight.Medium,
    fontFamily = balooBhai2FontFamily,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.1.sp,
  ),
  bodyLarge = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp,
    lineHeightStyle = LineHeightStyle(
      alignment = Alignment.Center,
      trim = Trim.None,
    ),
  ),
  bodyMedium = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.25.sp,
  ),
  bodySmall = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = balooBhai2FontFamily,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.4.sp,
  ),
  labelLarge = TextStyle(
    fontWeight = FontWeight.Medium,
    fontFamily = balooBhai2FontFamily,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.1.sp,
    lineHeightStyle = LineHeightStyle(
      alignment = Alignment.Center,
      trim = Trim.LastLineBottom,
    ),
  ),
  labelMedium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontFamily = balooBhai2FontFamily,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp,
    lineHeightStyle = LineHeightStyle(
      alignment = Alignment.Center,
      trim = Trim.LastLineBottom,
    ),
  ),
  labelSmall = TextStyle(
    fontWeight = FontWeight.Medium,
    fontFamily = balooBhai2FontFamily,
    fontSize = 10.sp,
    lineHeight = 14.sp,
    letterSpacing = 0.sp,
    lineHeightStyle = LineHeightStyle(
      alignment = Alignment.Center,
      trim = Trim.LastLineBottom,
    ),
  ),
)
