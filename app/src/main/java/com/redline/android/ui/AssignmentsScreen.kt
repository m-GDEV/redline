package com.redline.android.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redline.android.R
import com.redline.android.model.Assignment
import com.redline.android.model.Course
import com.redline.android.model.CourseDifficulty
import com.redline.android.model.CoursePriority
import java.util.Date

@Composable
fun AssignmentsScreen(
    modifier: Modifier = Modifier
) {
    Column {
        CourseSection(
            givenCourse = Course(
                "CIS*3490", CourseDifficulty.Medium, CoursePriority.Medium, listOf(
                    Assignment(
                        "Homework 1", 4.0f, 10, 1706932000, Pair(1706932000, 1706932000), null
                    )
                )
            )
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseSection(givenCourse: Course) {
    var expanded by remember { mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 20.dp),
        onClick = { expanded = !expanded }) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {

            Text(
                text = givenCourse.name, style = MaterialTheme.typography.displaySmall
            )

            if (expanded) {
                Text(
                    text = "${givenCourse.difficulty.name} Difficulty",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "${givenCourse.priority.name} Priority",
                    style = MaterialTheme.typography.bodySmall
                )

                givenCourse.assignments.map { currentAssignment ->
                    AssignmentSection(givenAssignment = currentAssignment)
                }
            }
        }
    }
}

@Composable
fun AssignmentSection(givenAssignment: Assignment) {
    Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Text(
            text = givenAssignment.name, style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Difficulty: ${givenAssignment.difficulty}",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Worth ${givenAssignment.weight}%",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Due on ${returnDateTime(givenAssignment.dueDate)}",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Should be worked on from:\n${returnDateTime(givenAssignment.workRange.first)} to ${
                returnDateTime(
                    givenAssignment.workRange.second
                )
            }", style = MaterialTheme.typography.bodySmall
        )
    }
}

fun returnDateTime(unixTime: Long): String {
    // change this later toLocaleString is depreceated
    return Date(unixTime * 1000).toLocaleString()
//    return "hello"
}
