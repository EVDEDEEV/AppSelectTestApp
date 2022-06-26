package my.project.appselecttest.data.models.mapper

import my.project.appselecttest.data.models.MovieItem
import my.project.appselecttest.presentation.models.Movie


class MovieListMapper {

    fun toMovieList(movie: List<MovieItem>?): List<Movie> {
        with(movie) {
            return if (this?.isNotEmpty() == true) {
                this.map { toMovie(it) }
            } else {
                emptyList()
            }
        }
    }

    private fun toMovie(movie: MovieItem): Movie {
        with(movie) {
            return Movie(
                title = displayTitle.orEmpty(),
                image = multimedia?.src.orEmpty(),
                description = summaryShort.orEmpty()
            )
        }
    }
}