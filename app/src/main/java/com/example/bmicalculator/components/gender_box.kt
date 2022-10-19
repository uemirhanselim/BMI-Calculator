package com.example.bmicalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun GenderBox(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    color: Color,
) {
    Box(
        modifier = Modifier.height(180.dp).width(180.dp).clickable { onClick.invoke() }.background(color = Color(16,20,39)),
        contentAlignment = Alignment.Center,

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween) {
            Icon(imageVector = icon, tint = color,
                modifier = Modifier.size(60.dp),contentDescription = "$text Icon")
            Text(text = text, style = MaterialTheme.typography.h6, color = color)
        }
    }
}