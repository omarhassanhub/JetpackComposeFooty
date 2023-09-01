package com.example.jetpackcomposefooty.domain.model

data class Transfers(
    val data: TransfersData
)

data class TransfersData(
    val arrivals: List<Arrival>,
    val departures: List<Departure>
)

data class Arrival(
    val date: String?,
    val fee: String,
    val player: Player,
    val team_left: TeamLeft,
    val type: String
)

data class Departure(
    val date: String?,
    val fee: String,
    val player: Player,
    val team_join: TeamJoin,
    val type: String
)

data class Player(
    val id: Int?,
    val name: String
)

data class TeamLeft(
    val id: Int?,
    val name: String
)

data class TeamJoin(
    val id: Int?,
    val name: String
)


