package my.project.appselecttest.data.models


import com.google.gson.annotations.SerializedName
import my.project.appselecttest.presentation.models.Movie

data class MoviesResponse(
    @SerializedName("has_more")
    val hasMore: Boolean?,
    @SerializedName("results")
    val movieItems: List<MovieItem>?,
)

fun MoviesResponse?.mapToUi(): List<Movie> = this?.movieItems?.map { movie ->
    Movie(
        title = movie.displayTitle.orEmpty(),
        image = movie.multimedia?.src.orEmpty(),
        description = movie.summaryShort.orEmpty()
    )
}.orEmpty()

