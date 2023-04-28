package com.example.jetpackcomposefooty.domain.model

data class Match(
    val leagueName: String,
    val homeTeamId: Int,
    val homeTeamName: String,
    val awayTeamId: Int,
    val awayTeamName: String,
    val date: String,
    val status: MATCHSTATUS,
    val homeTeam90MinGoals: Int,
    val awayTeam90MinGoals: Int,
    val elapsed: Int
)


enum class MATCHSTATUS{
    IN_PROGRESS,
    HALF_TIME,
    NOT_STARTED,
    FINISHED,
    CANCELLED,
    POSTPONED,
    SUSPENDED
}