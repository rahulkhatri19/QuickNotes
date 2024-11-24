package com.geekforgeek.quicknotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.geekforgeek.quicknotes.ui.theme.MintChip
import com.geekforgeek.quicknotes.ui.theme.QuickFreeze

@Composable
fun EditNote(navController: NavController){

    var inputTitle by remember { mutableStateOf(TextFieldValue("")) }
    var inputDescription by remember { mutableStateOf(TextFieldValue("")) }
    var isValidTitle by remember { mutableStateOf(true) }
    var isInValidTitle by remember { mutableStateOf(false) }
    var errorTitle by remember { mutableStateOf("") }

    Box(
        Modifier.background(MintChip)
    ){
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .fillMaxHeight()
        ) {
            Spacer(Modifier.height(56.dp))
            Card(
                modifier = Modifier.padding(end = 12.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = QuickFreeze),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, "Back Arrow", modifier = Modifier.padding(all = 8.dp))
            }

            Spacer(Modifier.height(16.dp))
            TextField(
                value = inputTitle,
                onValueChange = {
                    errorTitle = isValidTitleCondition(it.text)
                    inputTitle = it
                    isInValidTitle = errorTitle.length > 2
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
                    focusedIndicatorColor = MintChip,
                    errorContainerColor = MintChip
                ),
                textStyle = TextStyle.Default.copy(
                    fontSize = 28.sp, fontWeight = FontWeight.Bold
                ),
                maxLines = 2,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                isError = isInValidTitle
            )
            if (!isValidTitle){
                Text(
                    text = errorTitle,
                    color = Color.Red
                )
            }

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

fun isValidTitleCondition(input: String): String {
    val numberRegex = "[0-9]".toRegex()
    val alphRegex = "[a-z]".toRegex()

    return if (input.length < 3) {
        "Please add a Long Title"
    } else if (input.contains("%")){
        "Please Do not add % sign"
    } else if(input.contains(numberRegex)){
        "Please do not add Numbers"
    }
    else {
        ""
    }
}