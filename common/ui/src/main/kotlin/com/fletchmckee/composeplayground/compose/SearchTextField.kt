package com.fletchmckee.composeplayground.common.ui.compose

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fletchmckee.composeplayground.common.R
import com.fletchmckee.composeplayground.common.ui.theme.PlaygroundTheme
import com.fletchmckee.composeplayground.common.ui.theme.Umbra

const val SEARCH_TEXT_FIELD_TAG = "searchTextField"

@Composable
fun SearchTextField(
  searchQuery: TextFieldValue,
  hint: String,
  onSearchTextChange: (TextFieldValue) -> Unit,
  modifier: Modifier = Modifier,
  keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
  onClear: () -> Unit = { onSearchTextChange(TextFieldValue()) },
) {
  val focusRequester = remember { FocusRequester() }
  val keyboardController = LocalSoftwareKeyboardController.current

  OutlinedTextField(
    value = searchQuery,
    onValueChange = onSearchTextChange,
    placeholder = { Text(text = hint) },
    leadingIcon = {
      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = null, // Decorative
      )
    },
    trailingIcon = {
      if (searchQuery.text.isNotBlank()) {
        IconButton(
          onClick = { onClear() },
        ) {
          Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = stringResource(R.string.clear_text),
          )
        }
      }
    },
    maxLines = 1,
    singleLine = true,
    keyboardOptions = keyboardOptions,
    keyboardActions = KeyboardActions(
      onSearch = {
        keyboardController?.hide()
      },
    ),
    colors = OutlinedTextFieldDefaults.colors(

      focusedTextColor = Umbra,
      focusedBorderColor = MaterialTheme.colorScheme.primary,
      unfocusedBorderColor = Color.Gray,
    ),
    modifier = modifier
      .focusRequester(focusRequester)
      .focusable(true)
      .testTag(SEARCH_TEXT_FIELD_TAG),
    shape = RoundedCornerShape(12.dp),
  )

  LaunchedEffect(Unit) {
    focusRequester.requestFocus()
  }
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
  PlaygroundTheme(darkTheme = true) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    SearchTextField(
      searchQuery = searchQuery,
      hint = stringResource(R.string.search_hint),
      modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
      onSearchTextChange = {
        searchQuery = it
        println(searchQuery.text)
      },
    )
  }
}
