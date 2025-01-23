package com.example.animepocapp.dataModel


data class AnimeListDataModel(
    val pagination: Pagination,
    val data: List<AnimeDetails>,
)

data class Pagination(
    val last_visible_page: Long,
    val has_next_page: Boolean,
    val current_page: Long,
    val items: Items,
)

data class Items(
    val count: Long,
    val total: Long,
    val per_page: Long,
)

data class AnimeDetails(
    val mal_id: Int,
    val url: String,
    val images: Images,
    val trailer: Trailer,
    val approved: Boolean,
    val titles: List<Title>,
    val title: String,
    val title_english: String?,
    val title_japanese: String,
    val title_synonyms: List<String>,
    val type: String,
    val source: String,
    val episodes: Long,
    val status: String,
    val airing: Boolean,
    val aired: Aired,
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
    val season: String?,
    val year: Long?,
    val broadcast: Broadcast,
    val producers: List<Producer>,
    val licensors: List<Licensor>,
    val studios: List<Studio>,
    val genres: List<Genre>,
    val explicit_genres: List<Any?>,
    val themes: List<Theme>,
    val demographics: List<Demographic>,
)

data class Images(
    val jpg: Jpg,
    val webp: Webp,
)

data class Jpg(
    val image_url: String,
    val small_image_url: String,
    val large_image_url: String,
)

data class Webp(
    val image_url: String,
    val small_image_url: String,
    val large_image_url: String,
)

data class Trailer(
    val youtube_id: String?,
    val url: String?,
    val embed_url: String?,
    val images: Images2,
)

data class Images2(
    val image_url: String?,
    val small_image_url: String?,
    val medium_image_url: String?,
    val large_image_url: String?,
    val maximum_image_url: String?,
)

data class Title(
    val type: String,
    val title: String,
)

data class Aired(
    val from: String,
    val to: String?,
    val prop: Prop,
    val string: String,
)

data class Prop(
    val from: From,
    val to: To,
)

data class From(
    val day: Long,
    val month: Long,
    val year: Long,
)

data class To(
    val day: Long?,
    val month: Long?,
    val year: Long?,
)

data class Broadcast(
    val day: String?,
    val time: String?,
    val timezone: String?,
    val string: String?,
)

data class Producer(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Licensor(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Studio(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Genre(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Theme(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)

data class Demographic(
    val mal_id: Long,
    val type: String,
    val name: String,
    val url: String,
)