package com.redline.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redline.android.AppScreen

@Composable
fun AssignmentsScreen(
    modifier: Modifier = Modifier, onScreenChange: (screen: AppScreen) -> Unit
) {
    Column {
        HomeTabs(onScreenChange = onScreenChange)
        Text(
            text = "Assignments",
        )
    }

}