package com.example.jetpackcomposefooty.domain.model

data class Fixtures(
    val data: List<FixturesData>,
)

data class FixturesData(
    val league: League,
    val scores: Scores,
    val teams: Teams,
    val time: Time,
)

data class League(
    val country_flag: String,
    val name: String,
)

data class Scores(
    val away_score: String,
    val home_score: String,
)

data class Teams(
    val away: Away,
    val home: Home
)

data class Time(
    val time: String,
)

data class Away(
    val img: String,
    val name: String,
)

data class Home(
    val img: String,
    val name: String,
)

val exampleFixtures =
    FixturesData(
        league = League(
            "https://cdn.soccersapi.com/images/soccer/teams/80/2869.png",
            "Premier League"
        ),
        scores = Scores(
            "",
            ""
        ),
        teams = Teams(
            Away(
                "https://cdn.soccersapi.com/images/soccer/teams/80/2869.png",
                "Nordsjaelland"
            ),
            Home(
                "https://cdn.soccersapi.com/images/soccer/teams/80/2869.png",
                "Chelsea"
            )
        ),
        time = Time(
            "15:00:00"
        )
    )

val exampleFixtures2 =
    FixturesData(
        league = League(
            "https://cdn.soccersapi.com/images/soccer/teams/80/2869.png",
            "Premier League"
        ),
        scores = Scores(
            "",
            ""
        ),
        teams = Teams(
            Away(
                "https://cdn.soccersapi.com/images/soccer/teams/80/2869.png",
                "Arsenal"
            ),
            Home(
                "https://cdn.soccersapi.com/images/soccer/teams/80/2869.png",
                "Austria Lustenau"
            )
        ),
        time = Time(
            "15:00:00"
        )
    )