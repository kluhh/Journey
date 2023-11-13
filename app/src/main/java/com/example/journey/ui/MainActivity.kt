package com.example.journey.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.journey.ui.theme.JourneyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            JourneyTheme { // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    WelcomeScreen()

                }
            }
        }
    }
}

@Composable
fun WelcomeScreen()
{
    Column {
        Spacer(modifier = Modifier.height(300.dp))

        ElevatedCard(
            modifier = Modifier.fillMaxWidth().padding(7.dp)
        ) {
//            Text(
//                text = "Hi ${userOne.firstName}, ${userOne.lastName}",
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//
//            )
        }
    }
}


@Preview
@Composable
fun WelcomeScreenPreview()
{
    WelcomeScreen()
}

