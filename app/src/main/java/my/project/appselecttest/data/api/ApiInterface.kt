package my.project.appselecttest.data.api

import my.project.appselecttest.Constants
import my.project.appselecttest.Constants.END_POINT
import my.project.appselecttest.data.api.models.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(Constants.END_POINT)
    suspend fun getMovies(@Query("api-key") apiKey: String): Response<ResponseModel>
}