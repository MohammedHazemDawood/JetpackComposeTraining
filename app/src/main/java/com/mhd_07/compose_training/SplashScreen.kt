package com.mhd_07.compose_training

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.mhd_07.compose_training.ui.theme.LocalDim

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onStartClick: () -> Unit) {
    val dim = LocalDim.current
    Box(modifier, contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(R.drawable.splash_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    val shader = LinearGradientShader(
                        from = Offset(0f, size.height),
                        to = Offset(0f, 0f),
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.6f),
                        ),
                        colorStops = listOf(0f, 1f),
                    )
                    drawContent()
                    drawRect(
                        brush = ShaderBrush(shader),
                        blendMode = BlendMode.DstIn
                    )
                },
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = dim.spacing_xl,
                    end = dim.spacing_xl,
                    top = dim.spacing_xxxxl,
                    bottom = dim.spacing_xxxl
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CompositionLocalProvider(LocalContentColor provides Color.White) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.coock_hat),
                        contentDescription = null,
                        modifier = Modifier.padding(top = dim.spacing_s)
                    )
                    Text("100K+ Premium Recipe", style = MaterialTheme.typography.displayMedium)
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Get Cooking",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displayLarge,
                        modifier = Modifier.padding(bottom = dim.spacing_s, start = dim.spacing_l, end = dim.spacing_l)
                    )
                    Text(
                        "Simple way to find Tasty Recipe",
                        style = MaterialTheme.typography.displaySmall
                    )
                    Button(
                        modifier = Modifier.padding(top = dim.spacing_xxxl, start = dim.spacing_s, bottom = dim.spacing_s),
                        onClick = onStartClick,
                        shape = MaterialTheme.shapes.small
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = dim.spacing_s),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Start Cooking",
                                modifier = Modifier.padding(end =dim.spacing_xs)
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}