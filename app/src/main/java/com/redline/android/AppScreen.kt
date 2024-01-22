package com.redline.android

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redline.android.ui.AssignmentsScreen
import com.redline.android.ui.ScheduleScreen

@Composable
fun RedlineApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(topBar = {
        // Talha, change this when you write the top app bar
    }) { innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = navController,
                startDestination = AppScreen.Assignments.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                // Assignments screen composable
                composable(route = AppScreen.Assignments.name) {
                    AssignmentsScreen(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                        onScreenChange = { screen ->
//                            Log.d("NAVIGATIOM", "$screen")
                            if (navController.currentDestination?.route != screen.name) {
                                navController.navigate(screen.name)
                            }
                        })
                }

                // Schedule Screen composable
                composable(route = AppScreen.Schedule.name) {
                    ScheduleScreen(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                        onScreenChange = { screen ->
                            if (navController.currentDestination?.route != screen.name) {
                                navController.navigate(screen.name)
                            }
                        })
                }
            }
        }
    }
}



enum class AppScreen() {
    Assignments, Schedule
}