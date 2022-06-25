package my.project.appselecttest.network

import my.project.appselecttest.network.models.MoviesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("reviews/all.json")
    suspend fun getMovies(@Query("api-key") apiKey: String,/* @Query("offset") offset: Int*/): Response<MoviesResponse>
}

