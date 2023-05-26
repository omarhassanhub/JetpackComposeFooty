package com.example.jetpackcomposefooty.domain.model

//data class Match(
//    val leagueName: String,
//    val homeTeamId: Int,
//    val homeTeamName: String,
//    val awayTeamId: Int,
//    val awayTeamName: String,
//    val date: String,
//    val status: MATCHSTATUS,
//    val homeTeam90MinGoals: Int,
//    val awayTeam90MinGoals: Int,
//    val elapsed: Int
//)


enum class MATCHSTATUS{
    IN_PROGRESS,
    HALF_TIME,
    NOT_STARTED,
    FINISHED,
    CANCELLED,
    POSTPONED,
    SUSPENDED
}

//data class Match(
//    val data: List<Data>,
//    val meta: Meta
//)
//
//data class Data(
//    val aggregate_id: String,
//    val assistants: Assistants,
//    val attendance: String?,
//    val coverage: Coverage,
//    val deleted: String,
//    val group_id: String,
//    val group_name: String,
//    val id: Int,
//    val info: String?,
//    val league: League,
//    val leg: String?,
//    val pitch: String?,
//    val referee_id: String,
//    val round_id: String,
//    val round_name: String,
//    val scores: Scores,
//    val season_id: String,
//    val season_name: String,
//    val stage_id: String,
//    val stage_name: String,
//    val standings: Standings,
//    val status: Int,
//    val status_name: String,
//    val status_period: String?,
//    val teams: Teams,
//    val time: Time,
//    val venue_id: String,
//    val weather_report: WeatherReport,
//    val week: String,
//    val winner_team_id: String
//)
//
//data class Meta(
//    val count: Int,
//    val page: Int,
//    val pages: Int,
//    val plan: String,
//    val requests_left: Int,
//    val total: Int,
//    val user: String
//)
//
//data class Assistants(
//    val first_assistant_id: String?,
//    val fourth_assistant_id: String?,
//    val second_assistant_id: String?
//)
//
//data class Coverage(
//    val has_lineups: Int,
//    val has_standings: Int,
//    val has_tvs: Int
//)
//
//data class League(
//    val country_code: String,
//    val country_flag: String,
//    val country_id: String,
//    val country_name: String,
//    val id: Int,
//    val name: String,
//    val type: String
//)
//
//data class Scores(
//    val away_score: String,
//    val et_score: String?,
//    val ft_score: String,
//    val home_score: String,
//    val ht_score: String,
//    val ps_score: String?
//)
//
//data class Standings(
//    val away_position: Int,
//    val home_position: Int
//)
//
//data class Teams(
//    val away: Away,
//    val home: Home
//)
//
//data class Time(
//    val date: String,
//    val datetime: String,
//    val minute: Int,
//    val time: String,
//    val timestamp: Int,
//    val timezone: String
//)
//
//data class WeatherReport(
//    val desc: String,
//    val humidity_percent: Int,
//    val pressure: Int,
//    val temp: Temp,
//    val wind: Wind
//)
//
//data class Away(
//    val coach_id: String,
//    val form: String,
//    val id: Int,
//    val img: String,
//    val kit_colors: KitColors,
//    val name: String,
//    val short_code: String
//)
//
//data class Home(
//    val coach_id: String,
//    val form: String,
//    val id: Int,
//    val img: String,
//    val kit_colors: KitColorsX,
//    val name: String,
//    val short_code: String
//)
//
//data class KitColors(
//    val away_gk_main_color: String,
//    val away_gk_number_color: String,
//    val away_gk_second_color: String,
//    val away_main_color: String,
//    val away_number_color: String,
//    val away_second_color: String
//)
//
//data class KitColorsX(
//    val home_gk_main_color: String,
//    val home_gk_number_color: String,
//    val home_gk_second_color: String,
//    val home_main_color: String,
//    val home_number_color: String,
//    val home_second_color: String
//)
//
//data class Temp(
//    val celsius: Int,
//    val fahrenheit: Int
//)
//
//data class Wind(
//    val direction: String,
//    val kmph: Int,
//    val miles: Double
//)


data class Match(
    val data: List<Data>,
    val meta: Meta?
)

data class Data(
    val code: String?,
    val continent: String,
    val id: Int,
    val name: String,
    val sub_region: String?
)

data class Meta(
    val count: Int,
    val page: Int,
    val pages: Int,
    val plan: String,
    val requests_left: Int,
    val total: Int,
    val user: String
)