package com.redline.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
// Main app entry point
fun RedlineApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(topBar = {
        RedlineTopAppBar()
    }) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), color = MaterialTheme.colorScheme.background
        ) {
            // Here we setup tabs for assignment and schedule tabs.
            var tabIndex by remember { mutableIntStateOf(0) }
            val tabs = listOf("Assignments", "Schedule")

            Column (modifier = Modifier.fillMaxWidth()) {
                TabRow(selectedTabIndex = tabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index },
                            icon = {
                                when (index) {
                                    0 -> Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                                    1 -> Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                                }
                            }
                        )
                    }
                }

                // Switch
                when(tabIndex) {
                    0 -> AssignmentsScreen()
                    1 -> ScheduleScreen()
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
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    )
}
