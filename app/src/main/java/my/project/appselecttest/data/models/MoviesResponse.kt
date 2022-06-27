package my.project.appselecttest.data.models


import com.google.gson.annotations.SerializedName
import my.project.appselecttest.presentation.models.Movie

data class MoviesResponse(
    @SerializedName("results")
    val movies: List<MovieModel>?,
)

fun MoviesResponse?.mapToUi(): List<Movie> = this?.movies?.map { movie ->
    Movie(
        title = movie.displayTitle.orEmpty(),
        image = movie.multimedia?.src.orEmpty(),
        description = movie.summaryShort.orEmpty()
    )
}.orEmpty()

