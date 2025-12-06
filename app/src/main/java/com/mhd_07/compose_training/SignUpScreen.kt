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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import com.mhd_07.compose_training.ui.theme.LocalDim

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    val dim = LocalDim.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    var termsAccepted by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.padding(
            top = dim.spacing_xs,
            start = dim.spacing_l,
            end = dim.spacing_l
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = dim.spacing_xxxxl, bottom = dim.spacing_m)
        ) {
            Text(
                text = "Create an account",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = dim.spacing_xxs)
            )
            Text(
                text = "Let’s help you set up your account, it won’t take long.",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dim.spacing_xxs),
            verticalArrangement = Arrangement.spacedBy(dim.spacing_s)
        ) {
            OutlinedTextFieldWithLabel(
                value = name,
                onValueChange = { n -> name = n },
                label = "Name",
                placeholder = { Text(text = "Enter Name") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextFieldWithLabel(
                value = email,
                onValueChange = { n -> email = n },
                label = "Email",
                placeholder = { Text(text = "Enter Email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextFieldWithLabel(
                value = password,
                onValueChange = { n -> password = n },
                label = "Password",
                placeholder = { Text(text = "Enter Password") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextFieldWithLabel(
                value = passwordConfirm,
                onValueChange = { n -> passwordConfirm = n },
                label = "Confirm Password",
                placeholder = { Text(text = "Retype Password") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dim.spacing_s),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dim.spacing_xxs)
        ) {
            Checkbox(
                checked = termsAccepted,
                onCheckedChange = { n -> termsAccepted = n },
//                modifier = Modifier.padding(end = dim.spacing_xxs),
                colors = CheckboxDefaults.colors().copy(
                    checkedCheckmarkColor = Color(0XFFFF9C00),
                    uncheckedBorderColor = Color(0XFFFF9C00),
                    checkedBorderColor = Color(0XFFFF9C00),
                    checkedBoxColor = Color.White,
                    uncheckedBoxColor = Color.White,
                )
            )
            Text(
                text = "Accept terms & Condition",
                color = Color(0XFFFF9C00),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Button(
            onClick = { },
            shape = MaterialTheme.shapes.small,
            enabled = termsAccepted,
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
                .padding(
                    start = dim.spacing_xxxl,
                    end = dim.spacing_xxxl,
                    bottom = dim.spacing_m
                ),
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
                .fillMaxWidth()
                .padding(bottom = dim.spacing_m),
            horizontalArrangement = Arrangement.spacedBy(
                dim.spacing_m,
                Alignment.CenterHorizontally
            ),
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
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already a member? ", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Sign In",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0XFFFF9C00),
                modifier = Modifier.clickable {}
            )
        }
    }
}