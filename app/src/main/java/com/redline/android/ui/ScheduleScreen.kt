package com.redline.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redline.android.AppScreen
import com.redline.android.R
import com.redline.android.RedlineTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    modifier: Modifier = Modifier,
    onScreenChange: (screen: AppScreen) -> Unit
) {
    Scaffold(topBar = {
        RedlineTopAppBar()
    },
        bottomBar = {
            RedlineNavBar(onScreenChange = onScreenChange)
        }
    ) { innerPadding ->
        Column {
            HomeTabs(onScreenChange = onScreenChange)
            Box(modifier = Modifier
                .padding(0.dp, 40.dp, 0.dp, 0.dp)
            )
            TabHeader(tabNameId = R.string.schedule_tab)
        }
    }


}