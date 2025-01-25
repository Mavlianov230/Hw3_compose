package com.example.hw3_compose.ui.theme.activity

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw3_compose.App


@Composable
fun Main() {
    MaterialTheme {
        App()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Main()
}