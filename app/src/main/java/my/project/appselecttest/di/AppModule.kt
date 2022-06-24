package my.project.appselecttest.di

import androidx.compose.ui.graphics.GraphicsLayerScope
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import my.project.appselecttest.data.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/"

    fun provideRetrofit() : ApiInterface =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
}