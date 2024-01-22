package com.redline.android.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redline.android.AppScreen
import com.redline.android.R


@Composable
fun HomeTabs(modifier: Modifier = Modifier, onScreenChange: (screen: AppScreen) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
//                Log.d("NAVIGATIOM__", "Navigating to assignments from button")
                onScreenChange(AppScreen.Assignments)
            }
        ) {
            Text(
                text = stringResource(R.string.assignments_tab)
            )
        }
        Button(
            onClick = {
                Log.d("NAVIGATIOM_", "Navigating to schedule from button")
                onScreenChange(AppScreen.Schedule)
            }
        ) {
            Text(
                text = stringResource(R.string.schedule_tab)
            )
        }
    }
}

