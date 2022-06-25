package my.project.appselecttest.network

import my.project.appselecttest.BuildConfig
import my.project.appselecttest.network.models.mapToUi
import my.project.appselecttest.presentation.models.Movie
import javax.inject.Inject

class RetrofitRepository
@Inject
constructor(private val api: ApiInterface) {

    suspend fun getMoviesList(): List<Movie> {
        return api.getMovies(apiKey = BuildConfig.ApiKey, /*offset = 20*/).body().mapToUi()
    }
}



