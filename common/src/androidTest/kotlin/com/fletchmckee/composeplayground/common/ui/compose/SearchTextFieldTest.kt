package com.fletchmckee.composeplayground.common.ui.compose

import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.text.input.TextFieldValue
import com.fletchmckee.composeplayground.common.R
import org.junit.Rule
import org.junit.Test

class SearchTextFieldTest {
  @get:Rule
  val composeTestRule = createAndroidComposeRule<ComponentActivity>()

  @Test
  fun clearButton_gone_whenBlankText() {
    composeTestRule.setContent {
      MaterialTheme {
        SearchTextField(
          searchText = TextFieldValue(),
          hint = "",
          onSearchTextChange = { },
        )
      }
    }
    val clearText = composeTestRule.activity.getString(R.string.clear_text)
    composeTestRule.onNodeWithContentDescription(clearText)
      .assertDoesNotExist()
  }

  @Test
  fun clearButton_visible_whenNonBlankText() {
    composeTestRule.setContent {
      MaterialTheme {
        SearchTextField(
          searchText = TextFieldValue("C"),
          hint = "",
          onSearchTextChange = { },
        )
      }
    }
    val clearText = composeTestRule.activity.getString(R.string.clear_text)
    composeTestRule.onNodeWithContentDescription(clearText)
      .assertIsDisplayed()
  }
}
