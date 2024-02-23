package com.redline.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redline.android.ui.AssignmentsScreen
import com.redline.android.ui.ScheduleScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RedlineApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(topBar = {
        // Talha, change this when you write the top app bar
        //RedlineTopAppBar()
    },
        bottomBar = {
            //RedlineNavBar()
        }
    ) { innerPadding ->
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

@ExperimentalMaterial3Api
@Composable
fun RedlineTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar( // figure out if this should be a background colour, it kind of looks like shit
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp),
                    painter = painterResource(R.drawable.redline_icon_foreground),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.redline),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RedlineNavBar(modifier: Modifier = Modifier, onScreenChange: (screen: AppScreen) -> Unit){
    var selectedItem by remember { mutableIntStateOf(0) }
    val labels = listOf("Assignments", "Schedule")
    val icons = listOf(Icons.Filled.List, Icons.Filled.DateRange)

    NavigationBar {
        labels.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {selectedItem = index
                    if (index == 0){
                        onScreenChange(AppScreen.Assignments)
                    }else{
                        onScreenChange(AppScreen.Schedule)
                    }},
                icon = {Icon(icons[index], contentDescription = null)},
                label = {Text(item)}
            )
        }

    }
}



enum class AppScreen() {
    Assignments, Schedule
}