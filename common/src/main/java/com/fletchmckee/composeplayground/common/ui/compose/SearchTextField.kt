package com.fletchmckee.composeplayground.common.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fletchmckee.composeplayground.common.R

@Composable
fun SearchTextField(
    searchText: TextFieldValue = TextFieldValue(),
    hint: String = stringResource(R.string.search_hint),
    modifier: Modifier = Modifier,
    onSearchTextChange: (TextFieldValue) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    onClear: () -> Unit = { onSearchTextChange(TextFieldValue()) }
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = onSearchTextChange,
        placeholder = { Text(text = hint) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                // Decorative.
                contentDescription = null,
            )
        },
        trailingIcon = {
            if (searchText.text.isNotBlank()) {
                IconButton(
                    onClick = {
                        onClear()
                    },
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
        keyboardActions = keyboardActions,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
    MaterialTheme {
        var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
        SearchTextField(
            searchText = searchQuery,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            onSearchTextChange = {
                searchQuery = it
                println(searchQuery.text)
            }
        )
    }
}