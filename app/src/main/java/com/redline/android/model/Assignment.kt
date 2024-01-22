package com.redline.android.model

data class Assignment(
    val name: String,
    val difficulty: Float, // Scale 1-10
    // Don't put too much emphasis on this when making the formula
    val weight: Int, // 1-100%
    val dueDate: Long, // In unix time
    // Also in unix time, Pair[0] is start, Pair[1] is end
    val workRange: Pair<Long, Long>,
    val parentCourse: Course?
)
