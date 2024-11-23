package com.geekforgeek.quicknotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekforgeek.quicknotes.ui.theme.MintChip
import com.geekforgeek.quicknotes.ui.theme.QuickFreeze

@Composable
fun EditNote(){

    var inputTitle by remember { mutableStateOf(TextFieldValue("")) }
    var inputDescription by remember { mutableStateOf(TextFieldValue("")) }

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
            TextField(
                value = inputTitle,
                onValueChange = {
                    inputTitle = it
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        "Title",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MintChip,
                    unfocusedContainerColor = MintChip,
                    unfocusedIndicatorColor = MintChip,
                    focusedIndicatorColor = MintChip
                ),
                textStyle = TextStyle.Default.copy(
                    fontSize = 28.sp, fontWeight = FontWeight.Bold
                ),
                maxLines = 2,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(Modifier.height(16.dp))

            TextField(
                value = inputDescription,
                onValueChange = {
                    inputDescription = it
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        "Notes Description",
                        fontSize = 18.sp
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MintChip,
                    unfocusedContainerColor = MintChip,
                    unfocusedIndicatorColor = MintChip,
                    focusedIndicatorColor = MintChip
                ),
                textStyle = TextStyle.Default.copy(
                    fontSize = 18.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }
    }
}