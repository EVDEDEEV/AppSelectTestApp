package my.project.appselecttest.network.models


import com.google.gson.annotations.SerializedName
import my.project.appselecttest.domain.models.Movie

data class MoviesResponse(
    @SerializedName("results")
    val movieItems: List<MovieItem?>?,
) {

    fun mapToUi(): List<Movie> = movieItems?.map { movie ->
        Movie(
            title = movie?.displayTitle.orEmpty(),
            image = movie?.multimedia?.src.orEmpty(),
            description = movie?.summaryShort.orEmpty()
        )
    }.orEmpty()
}
