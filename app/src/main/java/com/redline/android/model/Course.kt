package com.redline.android.model

data class Course(
    val name: String,
    val difficulty: CourseDifficulty,
    val priority: CoursePriority,
    val assignments: List<Assignment>
)

enum class CourseDifficulty {
    Easy, Medium, Hard
}

enum class CoursePriority {
    Low, Medium, High
}