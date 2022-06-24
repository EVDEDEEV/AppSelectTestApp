package my.project.appselecttest.data.api

import my.project.appselecttest.di.AppModule.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object Api {
//
//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    val api: ApiInterface by lazy {
//        retrofit.create(ApiInterface::class.java)
//    }
//}