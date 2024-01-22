package com.redline.android

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redline.android.ui.HomeTabs

@Composable
fun ScheduleScreen(
    modifier: Modifier = Modifier,
    onScreenChange: (screen: AppScreen) -> Unit
) {
    Column {
        HomeTabs(onScreenChange = onScreenChange)
        Text(
            text = "Schedule"
        )
    }

}