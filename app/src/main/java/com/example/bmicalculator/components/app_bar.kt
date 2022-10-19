package com.example.bmicalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    text: String,
    onTap: () -> Unit,
    color: Color,
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 70.dp).background(color = color).clickable { onTap.invoke() }
    ) {
        Text(text = text, fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center, style =
            MaterialTheme.typography.h6, color = Color.White)
    }
}