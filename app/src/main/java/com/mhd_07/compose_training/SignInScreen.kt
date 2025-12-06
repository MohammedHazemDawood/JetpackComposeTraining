package com.mhd_07.compose_training

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.mhd_07.compose_training.ui.theme.LocalDim

@Composable
fun SignInScreen(modifier: Modifier = Modifier, onSignUpClick: () -> Unit) {
    val dim = LocalDim.current
    Column(
        modifier = modifier.padding(
            start = dim.spacing_l,
            end = dim.spacing_l,
            top = dim.spacing_xxl,
            bottom = dim.spacing_xxxl
        )
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Text(text = "Hello,", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Welcome Back!", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextFieldWithLabel(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dim.spacing_xxl),
            value = email,
            onValueChange = { n -> email = n },
            placeholder = { Text(text = "Enter Email") },
            label = "Email"
        )
        OutlinedTextFieldWithLabel(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dim.spacing_l),
            value = password,
            onValueChange = { n -> password = n },
            placeholder = { Text(text = "Enter Password") },
            label = "Password"
        )
        Text(
            text = "Forgot Password?",
            modifier = Modifier
                .padding(start = dim.spacing_xs, top = dim.spacing_s, bottom = dim.spacing_m)
                .clickable {},
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0XFFFF9C00)
        )

        Button(
            onClick = { },
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.padding(bottom = dim.spacing_s)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dim.spacing_s),
                horizontalArrangement = Arrangement.spacedBy(
                    dim.spacing_xs,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Sign Up",
//                    modifier = Modifier.padding(end = dim.spacing_xs)
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dim.spacing_xxxl, end = dim.spacing_xxxl, bottom = dim.spacing_m),
            horizontalArrangement = Arrangement.spacedBy(
                dim.spacing_xs,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Gray)
            Text(
                text = "Or Sign in With",
//                modifier = Modifier.padding(horizontal = dim.spacing_xs),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            HorizontalDivider(modifier = Modifier.weight(1f), color = Color.Gray)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dim.spacing_m, Alignment.CenterHorizontally),
        ) {
            ElevatedCard(
                onClick = { },
                colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
                modifier = Modifier.size(dim.spacing_xl)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.google),
                        contentDescription = "Sign in with Google",
                        modifier = Modifier.size(dim.spacing_m)
                    )
                }
            }
            ElevatedCard(
                onClick = { },
                colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
                modifier = Modifier.size(dim.spacing_xl)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.facebook),
                        contentDescription = "Sign in with Facebook",
                        modifier = Modifier.size(dim.spacing_m)
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dim.spacing_xl),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Don’t have an account? ", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Sign up",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0XFFFF9C00),
                modifier = Modifier.clickable(onClick = onSignUpClick)
            )
        }
    }
}


@Composable
fun OutlinedTextFieldWithLabel(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (n: String) -> Unit,
    label: String,
    placeholder: @Composable () -> Unit = { }
) {
    val dim = LocalDim.current
    Column(modifier = modifier) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dim.spacing_xxs),
        )
    }
}