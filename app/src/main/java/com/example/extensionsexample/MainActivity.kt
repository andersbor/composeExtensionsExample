package com.example.extensionsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.extensionsexample.ui.theme.ExtensionsExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExtensionsExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExtensionsExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ExtensionsExample(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        val result: Boolean = 5.isEven()
        Text(text = "5 is even: $result")
        val result2: Boolean = 5.isOdd()
        Text(text = "5 is odd: $result2")
        val list: List<Int> = listOf(1, 2, 3, 4, 5)
        val shortList = list.first(3)
        Text(text = "First 3 elements: $shortList")
        val strList: List<String> = listOf("a", "b", "c", "d", "e")
        val shortStrList = strList.first(2)
        Text(text = "First 2 elements: $shortStrList")
    }
}

fun Int.isEven(): Boolean { // extension function on Int
    return this % 2 == 0
}

fun Int.isOdd() = this % 2 != 0 // extension function in Int, inline

// returns the first "howMany" elements from the list
fun <T> List<T>.first(howMany: Int): List<T> { // extension function on List<T>, generic
    return this.subList(0, howMany)
}

@Preview(showBackground = true)
@Composable
fun ExtensionsPreview() {
    ExtensionsExampleTheme {
        ExtensionsExample()
    }
}