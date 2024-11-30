package com.geekforgeek.quicknotes

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.geekforgeek.quicknotes.NotesRoute.DETAIL_NOTE
import com.geekforgeek.quicknotes.NotesRoute.EDIT_NOTE
import com.geekforgeek.quicknotes.NotesRoute.QUICK_NOTE
import com.geekforgeek.quicknotes.Utility.DESCRIPTION
import com.geekforgeek.quicknotes.Utility.ID
import com.geekforgeek.quicknotes.Utility.TITLE

@Composable
fun NotesNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = QUICK_NOTE) {
        composable(route = QUICK_NOTE) {
            QuickNote(navController)
        }

        composable(
            route = "$EDIT_NOTE?$TITLE={$TITLE}&$ID={$ID}&$DESCRIPTION={$DESCRIPTION}",
            arguments = listOf(
                navArgument(
                    name = ID
                ){
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(
                    name = TITLE
                ){
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument(
                    name = DESCRIPTION
                ){
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ){

            val id = it.arguments?.getInt(ID, -1) ?: -1
            val title = it.arguments?.getString(TITLE, "") ?: ""
            val description = it.arguments?.getString(DESCRIPTION, "") ?: ""

            EditNote(navController = navController, id=id, title = title, description = description)
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