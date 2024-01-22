package com.redline.android

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redline.android.ui.AssignmentsScreen

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
                            Log.d("NAVIGATIOM", "$screen")
                            navController.navigate(screen.name)
                        })
                }

                // Schedule Screen composable
                composable(route = AppScreen.Schedule.name) {
                    ScheduleScreen(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                        onScreenChange = {
                            navController.navigate(AppScreen.Assignments.name)
                        })
                }
            }
        }
    }
}

enum class AppScreen() {
    Assignments, Schedule
}