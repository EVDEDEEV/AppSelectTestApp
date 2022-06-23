package my.project.appselecttest.domain.mappers

import my.project.appselecttest.data.api.models.Multimedia
import my.project.appselecttest.data.api.models.ResponseModel
import my.project.appselecttest.data.api.models.Result
import my.project.appselecttest.domain.models.Images
import my.project.appselecttest.domain.models.MovieInfo
import my.project.appselecttest.domain.models.MoviesList

object ModelsMapper {

}

fun ResponseModel.toMovies(): MoviesList {
    return MoviesList(
        results = emptyList()
    )
}

fun Result.toMovieInfo(): MovieInfo {
    return MovieInfo(
        displayTitle = displayTitle,
        multimedia = multimedia,
        summaryShort = summaryShort
    )
}

fun Multimedia.toImages(): Images {
    return Images(
        src = src
    )
}