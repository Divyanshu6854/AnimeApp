package com.example.animepocapp.dataModel

data class AnimeDetailByIdModel(
    val data: Data,
)

data class Data(
    val mal_id: Long,
    val url: String,
    val images: Images1,
    val trailer: Trailer1,
    val approved: Boolean,
    val titles: List<Title1>,
    val title: String,
    val title_english: String,
    val title_japanese: String,
    val title_synonyms: List<String>,
    val type: String,
    val source: String,
    val episodes: Long,
    val status: String,
    val airing: Boolean,
    val aired: Aired1,
    val duration: String,
    val rating: String,
    val score: Double,
    val scored_by: Long,
    val rank: Long,
    val popularity: Long,
    val members: Long,
    val favorites: Long,
    val synopsis: String,
    val background: String,
    val season: String,
    val year: Long,
    val broadcast: Broadcast1,
    val producers: List<Producer1>,
    val licensors: List<Licensor1>,
    val studios: List<Studio1>,
    val genres: List<Genre1>,
    val explicit_genres: List<Any?>,
    val themes: List<Any?>,
    val demographics: List<Demographic1>,
)

data class Images1(
    val jpg: Jpg1,
    val webp: Webp1,
)

data class Jpg1(
    val image_url: String,
)

data class Webp1(
    val image_url: String,
)

data class Trailer1(
    val youtube_id: String,
    val url: String,
    val embed_url: String,
    val images: Images3,
)

data class Images3(
    val image_url: String,
)

data class Title1(
    val type: String,
    val title: String,
)

data class Aired1(
    val from: String,
    val to: String,
    val prop: Prop1,
    val string: String,
)

data class Prop1(
    val from: From1,
    val to: To1,
)

data class From1(
    val day: Long,
    val month: Long,
    val year: Long,
)

data class To1(
    val day: Long,
    val month: Long,
    val year: Long,
)

data class Broadcast1(
    val day: String,
    val time: String,
    val timezone: String,
    val string: String,
)

data class Producer1(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Licensor1(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Studio1(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Genre1(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Demographic1(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)
