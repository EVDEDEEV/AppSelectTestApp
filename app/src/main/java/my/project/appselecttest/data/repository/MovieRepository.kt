package my.project.appselecttest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.*
import kotlinx.coroutines.flow.Flow
import my.project.appselecttest.data.api.ApiInterface
import my.project.appselecttest.data.models.MovieItem
import my.project.appselecttest.data.paging.MoviesPagingSource
import my.project.appselecttest.data.paging.NETWORK_PAGE_SIZE
import my.project.appselecttest.presentation.models.Movie
import javax.inject.Inject
import kotlin.coroutines.coroutineContext


interface MovieRepository {
    suspend fun getMoviesList(): Flow<PagingData<Movie>>
}


class MovieRepositoryImpl
@Inject
constructor(
    private val api: ApiInterface) : MovieRepository {
//    private val api: ApiInterface)  {

    override suspend fun getMoviesList(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                MoviesPagingSource(api)
            }
        ).flow
    }
//    suspend fun getMoviesList(): List<Movie> {
//        return api.getMovies(apiKey = BuildConfig.ApiKey, offset = 20).body().mapToUi()
//    }
}



