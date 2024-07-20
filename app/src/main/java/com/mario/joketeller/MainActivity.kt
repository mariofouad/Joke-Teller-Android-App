package com.mario.joketeller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import com.mario.joketeller.ui.theme.Blue
import com.mario.joketeller.ui.theme.DarkBlue
import com.mario.joketeller.ui.theme.JokeTellerTheme
import com.mario.joketeller.ui.theme.LightBlue
import com.mario.joketeller.ui.theme.LightGreen
import com.mario.joketeller.ui.theme.LightRed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokeTellerTheme {
                JokeWithTextAndButton()
            }
        }
    }
}

@Composable
fun JokeWithTextAndButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Card(
            border = BorderStroke(
                width = 2.dp, brush = Brush.horizontalGradient(
                    listOf(LightRed, LightGreen)
                )
            ),
            colors = CardDefaults.cardColors(containerColor = LightBlue),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.8f)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxSize()
            ) {
                val jokes =
                    listOf(R.string.joke_1, R.string.joke_2, R.string.joke_3, R.string.joke_4)
                var randomJoke by remember {
                    mutableStateOf(R.string.jokes_will_appear_here)
                }
                val context = LocalContext.current
                Text(
                    text = stringResource(id = randomJoke),
                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(16.dp),
                    style = TextStyle(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Blue, DarkBlue
                            )
                        )
                    ),
                    fontSize = 24.sp
                )
                TextButton(
                    onClick = {
                        randomJoke = jokes.random()
                        Toast.makeText(
                            context,
                            getString(context, R.string.ha_ha),
                            Toast.LENGTH_LONG
                        ).show()
                    }, border = BorderStroke(
                        width = 2.dp, brush = Brush.horizontalGradient(
                            listOf(LightRed, LightGreen)
                        )
                    ), modifier = modifier.padding(top = 32.dp)
                ) {
                    Text(text = stringResource(id = R.string.ha_ha_me))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JokeWithTextAndButtonPreview() {
    JokeWithTextAndButton()
}