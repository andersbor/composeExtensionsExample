package com.example.extensionsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
                    val result: Boolean = 5.isEven()
                    val result2: Boolean = 5.isOdd()
                    val list: List<Int> = listOf(1, 2, 3, 4, 5)
                    val shortList = list.first(3)
                    Greeting(
                        name = shortList.toString(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun Int.isEven(): Boolean { // extension function on Int
    return this % 2 == 0
}

fun Int.isOdd() = this % 2 != 0 // extension function in Int, inline

fun <T> List<T>.first(howMany: Int): List<T> { // extension function on List<T>, generic
    return this.subList(0, howMany)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExtensionsExampleTheme {
        Greeting("Android")
    }
}