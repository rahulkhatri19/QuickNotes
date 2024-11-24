package com.geekforgeek.quicknotes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.geekforgeek.quicknotes.NotesRoute.DETAIL_NOTE
import com.geekforgeek.quicknotes.NotesRoute.EDIT_NOTE
import com.geekforgeek.quicknotes.NotesRoute.QUICK_NOTE

@Composable
fun NotesNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = QUICK_NOTE) {
        composable(route = QUICK_NOTE) {
            QuickNote(navController)
        }

        composable(EDIT_NOTE) {
            EditNote(navController)
        }

        composable(DETAIL_NOTE) {
            DetailNote(navController)
        }
    }

}

object NotesRoute {

    const val QUICK_NOTE = "Quick_Note"
    const val EDIT_NOTE = "Edit_Note"
    const val DETAIL_NOTE = "Detail_Note"
}