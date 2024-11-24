package com.geekforgeek.quicknotes

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geekforgeek.quicknotes.NotesRoute.DETAIL_NOTE
import com.geekforgeek.quicknotes.NotesRoute.EDIT_NOTE
import com.geekforgeek.quicknotes.ui.theme.BananaMania
import com.geekforgeek.quicknotes.ui.theme.BlackMetal
import com.geekforgeek.quicknotes.ui.theme.FrozenSalmon
import com.geekforgeek.quicknotes.ui.theme.MintChip
import com.geekforgeek.quicknotes.ui.theme.Sunshine

@Composable
fun QuickNote(navController: NavController) {

    val notesType = arrayOf(
        "All (20)", "Important", "Bookmark", "Urgent"
    )

    val notesList = arrayListOf<Pair<String, String>>()
    notesList.add(Pair("Buy honey 100% original", "Buy the new brand honey for family here's the pic"))
    notesList.add(Pair("Plan for today", "Buy food, GYM, Meeting"))
    notesList.add(Pair("Tax payment before the end of march", "This is reminder note, do as not forgot to pay tax before the end of march. Dont miss"))
    notesList.add(Pair("Password WiFi gelato cafe near the station", "password WiFi gelato cafe near the station Wh indoor : to reset the wifi password on time to dom get confusion after every 4 weeks. This is a gentle reminder"))

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(EDIT_NOTE)
                },
            ) {
                Icon(Icons.Default.Add, "Add Icon")
            }
        },
        containerColor = BlackMetal
    ) { innerPadding ->
        Column(
            Modifier.padding(horizontal = 16.dp).fillMaxHeight(),
        ) {

            Spacer(Modifier.height(56.dp).padding(innerPadding))

            Row {
                Image(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile Image",
                    Modifier.size(40.dp)
                )
                Text(
                    text = "Hi, Rahul",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 12.dp, top = 4.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "My Notes",
                modifier = Modifier.padding(top = 12.dp),
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )

            Spacer(Modifier.height(16.dp))

            LazyRow {
                items(notesType) { list ->

                    Card(
                        Modifier.padding(end = 12.dp),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp),
                            text = list,
                            fontSize = 18.sp
                        )
                    }

                }
            }
            Spacer(Modifier.height(16.dp))
            LazyColumn {
                itemsIndexed(notesList) { index, list ->
                    Card(
                        modifier = Modifier.padding(bottom = 12.dp).fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor =
                            when(index%4){
                                0 -> FrozenSalmon
                                1 -> Sunshine
                                2 -> MintChip
                                3 -> BananaMania
                                else -> FrozenSalmon
                            }
                        ),
                        onClick = {
                            navController.navigate(DETAIL_NOTE)
                        }
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp),
                            text = list.first,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(12.dp))
                        Text(
                            modifier = Modifier.padding(bottom = 12.dp, start = 12.dp, end = 12.dp),
                            text = list.second,
                            fontSize = 16.sp
                        )
                    }
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DemoNotes() {
    QuickNote(rememberNavController())
}