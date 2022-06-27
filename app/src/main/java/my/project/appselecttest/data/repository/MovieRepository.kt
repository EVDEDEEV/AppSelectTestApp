package my.project.appselecttest.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import my.project.appselecttest.data.api.MoviesApi
import my.project.appselecttest.data.paging.MoviesPagingSource
import my.project.appselecttest.data.paging.NETWORK_PAGE_SIZE
import my.project.appselecttest.presentation.models.Movie
import javax.inject.Inject


interface MovieRepository {
    suspend fun getMoviesList(): Flow<PagingData<Movie>>
}


class MovieRepositoryImpl @Inject constructor(
    private val api: MoviesApi,
) : MovieRepository {

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
}



