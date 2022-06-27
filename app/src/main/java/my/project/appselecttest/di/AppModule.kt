package my.project.appselecttest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import my.project.appselecttest.data.api.MoviesApi
import my.project.appselecttest.presentation.adapters.MoviesAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    companion object {
        private const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/"
    }

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAdapter(): MoviesAdapter = MoviesAdapter()
}