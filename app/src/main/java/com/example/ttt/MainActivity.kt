package com.example.ttt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ttt.ui.theme.TttTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TttTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageSlider()
                }
            }
        }
    }
}

@Composable
fun ImageSlider() {
    var currentImageIndex by remember { mutableStateOf(0) }

    val images = listOf<String>(
        "Image 1",
        "Image 2",
        "Image 3"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = images[currentImageIndex],
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = { currentImageIndex = (currentImageIndex - 1 + images.size) % images.size },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Попереднє зображення")
        }

        Button(
            onClick = { currentImageIndex = (currentImageIndex + 1) % images.size },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Наступне зображення")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ImageSliderPreview() {
    TttTheme {
        ImageSlider()
    }
}
