package my.project.appselecttest.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import my.project.appselecttest.BuildConfig
import my.project.appselecttest.data.api.ApiInterface
import my.project.appselecttest.data.models.MoviesResponse
import my.project.appselecttest.data.models.mapToUi
import my.project.appselecttest.data.models.mapper.MovieListMapper
import my.project.appselecttest.data.paging.MoviesPagingSource
import my.project.appselecttest.data.paging.NETWORK_PAGE_SIZE
import my.project.appselecttest.presentation.models.Movie
import javax.inject.Inject


interface MovieRepository {
    suspend fun getMoviesList(): LiveData<PagingData<Movie>>
}



class MovieRepositoryImpl
@Inject
constructor(
    private val api: ApiInterface) : MovieRepository {

    override suspend fun getMoviesList(): LiveData<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviesPagingSource(api)
            }
        ).liveData
    }
//    suspend fun getMoviesList(): List<Movie> {
//        return api.getMovies(apiKey = BuildConfig.ApiKey, offset = 20).body().mapToUi()
//    }
}



