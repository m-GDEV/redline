package com.redline.android.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redline.android.AppScreen
import com.redline.android.R


@Composable
fun HomeTabs(modifier: Modifier = Modifier, onScreenChange: (screen: AppScreen) -> Unit) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 15.dp),
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Button(
//            onClick = {
////                Log.d("NAVIGATIOM__", "Navigating to assignments from button")
//                onScreenChange(AppScreen.Assignments)
//            }
//        ) {
//            Text(
//                text = stringResource(R.string.assignments_tab)
//            )
//        }
//        Button(
//            onClick = {
////                Log.d("NAVIGATIOM_", "Navigating to schedule from button")
//                onScreenChange(AppScreen.Schedule)
//            }
//        ) {
//            Text(
//                text = stringResource(R.string.schedule_tab)
//            )
//        }
//    }
}

@Composable
fun RedlineNavBar(modifier: Modifier = Modifier, onScreenChange: (screen: AppScreen) -> Unit){
    var selectedItem by remember { mutableIntStateOf(0) }
    val labels = listOf("Assignments", "Schedule")
    val icons = listOf(Icons.Filled.List, Icons.Filled.DateRange)

    NavigationBar {
        labels.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {//selectedItem = index
                          if (index == 0){
                              onScreenChange(AppScreen.Assignments)
                              selectedItem = 0
                          }else{ // BUG: incorrectly hangs on index 0 selected upon first change from 0 to 1
                              onScreenChange(AppScreen.Schedule)
                              selectedItem = 1
                          }},
                icon = {Icon(icons[index], contentDescription = null)},
                label = {Text(item)}
            )
        }
    }
}

@Composable
fun TabHeader(tabNameId: Int) {
    Text(
        text = stringResource(id = tabNameId),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.displayLarge,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
    )
}

