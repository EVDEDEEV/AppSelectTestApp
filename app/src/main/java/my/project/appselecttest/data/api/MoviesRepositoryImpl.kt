package my.project.appselecttest.data.api

import my.project.appselecttest.data.api.ApiInterface
import javax.inject.Inject

class MoviesRepositoryImpl

@Inject
constructor(private val apiInterface: ApiInterface) {
suspend fun getMovies() = apiInterface.getMovies(apiKey = "")
}
