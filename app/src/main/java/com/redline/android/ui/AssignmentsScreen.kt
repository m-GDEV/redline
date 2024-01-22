package com.redline.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.redline.android.AppScreen
import com.redline.android.R

@Composable
fun AssignmentsScreen(
    modifier: Modifier = Modifier,
    onScreenChange: (screen: AppScreen) -> Unit
) {
    Column {
        HomeTabs(onScreenChange = onScreenChange)
        TabHeader(tabNameId = R.string.assignments_tab)
    }

}