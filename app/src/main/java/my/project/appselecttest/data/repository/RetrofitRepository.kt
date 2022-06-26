package my.project.appselecttest.data.repository

import androidx.paging.PagingData
import my.project.appselecttest.BuildConfig
import my.project.appselecttest.data.api.ApiInterface
import my.project.appselecttest.data.models.MoviesResponse
import my.project.appselecttest.data.models.mapToUi
import my.project.appselecttest.data.models.mapper.MovieListMapper
import my.project.appselecttest.presentation.models.Movie
import javax.inject.Inject

class RetrofitRepository
@Inject
constructor(
    private val api: ApiInterface,
    private val mapper: MovieListMapper) {

    suspend fun getMoviesList(): List<Movie> {
        return api.getMovies(apiKey = BuildConfig.ApiKey, offset = 20).body().mapToUi()
    }
//    suspend fun getMoviesList(): List<Movie> {
//        return api.getMovies(apiKey = BuildConfig.ApiKey, offset = 20).body().mapToUi()
//    }
}



