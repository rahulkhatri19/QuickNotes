package com.geekforgeek.quicknotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekforgeek.quicknotes.ui.theme.MintChip
import com.geekforgeek.quicknotes.ui.theme.QuickFreeze

@Composable
fun DetailNote(){
    Box(
        Modifier.background(MintChip)
    ){
        Column(
            Modifier.padding(horizontal = 16.dp).fillMaxHeight()
        ) {
            Spacer(Modifier.height(56.dp))
            Box (
                modifier = Modifier.background(QuickFreeze),
            ){
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back Arrow", modifier = Modifier.padding(all = 8.dp))
            }

            Spacer(Modifier.height(16.dp))
            Text(
                text = "Tax payment before the end of march",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "This is reminder note, do as not forgot to pay tax before the end of march. Dont miss",
                fontSize = 18.sp,
            )
        }
    }
}