package com.redline.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.redline.android.R




@Composable
fun ScheduleScreen(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier.fillMaxHeight()
    ){
        Text(
            text = "hello schedule"
        )
    }

}