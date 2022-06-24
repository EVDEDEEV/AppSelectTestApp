package my.project.appselecttest.domain.mappers

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results")
    val movies: List<MovieModel>?
) {
    fun mapToUi(): List<MovieUi> = movies?.map { movie ->
        MovieUi(
            title = movie.title.orEmpty(),
            description = movie.description.orEmpty(),
            pictureUrl = movie.picture?.url.orEmpty()
        )
    }.orEmpty()
}

data class MovieModel(
    @SerializedName("display_title")
    val title: String?,
    @SerializedName("multimedia")
    val picture: MoviePictureModel?,
    @SerializedName("summary_short")
    val description: String?
)

data class MoviePictureModel(
    @SerializedName("src")
    val url: String?
)

data class MovieUi(
    val title: String,
    val description: String,
    val pictureUrl: String
)