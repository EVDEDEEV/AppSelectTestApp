package my.project.appselecttest.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    private const val BASE_URL = ""

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}