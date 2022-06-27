package my.project.appselecttest.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import my.project.appselecttest.BuildConfig.ApiKey
import my.project.appselecttest.data.api.MoviesApi
import my.project.appselecttest.data.models.mapToUi
import my.project.appselecttest.presentation.models.Movie


const val NETWORK_PAGE_SIZE = 20

class MoviesPagingSource(
    private val moviesApi: MoviesApi,
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPosition = params.key ?: 0
            val response =
                moviesApi.getMovies(apiKey = ApiKey, offset = currentPosition).body()?.mapToUi()
            LoadResult.Page(
                data = response.orEmpty(),
                prevKey = if (currentPosition == 0) null
                else currentPosition.minus(NETWORK_PAGE_SIZE),
                nextKey = currentPosition.plus(NETWORK_PAGE_SIZE)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

