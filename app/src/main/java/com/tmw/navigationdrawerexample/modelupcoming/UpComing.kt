package com.tmw.navigationdrawerexample.modelupcoming

data class UpComing(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)