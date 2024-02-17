package com.example.ttt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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

    val imagesWithText = listOf(
        Pair(R.drawable.test, "Природа справжнє диво"),
        Pair(R.drawable.car, "Нова модель гоночної машини"),
        Pair(R.drawable.study, "Ніколи не пізно навчатись")
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imagesWithText[currentImageIndex].first),
            contentDescription = null,
            modifier = Modifier.padding(16.dp).fillMaxWidth().height(300.dp)
        )

        Text(
            text = imagesWithText[currentImageIndex].second,
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = { currentImageIndex = (currentImageIndex + 1) % imagesWithText.size },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Наступне зображення")
        }

        Button(
            onClick = { currentImageIndex = (currentImageIndex - 1 + imagesWithText.size) % imagesWithText.size },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Попереднє зображення")
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