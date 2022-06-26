package my.project.appselecttest.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import my.project.appselecttest.BuildConfig.ApiKey
import my.project.appselecttest.data.api.ApiInterface
import my.project.appselecttest.data.models.MoviesResponse
import my.project.appselecttest.data.models.mapToUi
import my.project.appselecttest.data.models.mapper.MovieListMapper
import my.project.appselecttest.presentation.models.Movie
import my.project.appselecttest.presentation.models.MovieList


const val NETWORK_PAGE_SIZE = 20
private const val INITIAL_LOAD_SIZE = 1

class MoviesPagingSource(
    private val apiInterface: ApiInterface,
    private val mapper: MovieListMapper,
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        val position = params.key ?: INITIAL_LOAD_SIZE
        val offset = if (params.key != null)
            ((position - 1) * NETWORK_PAGE_SIZE) + 1 else INITIAL_LOAD_SIZE
        return try {
            val jsonResponse =
                apiInterface.getMovies(apiKey = "", offset = offset).body()?.movieItems
//            val response = mapper.toMovieList(jsonResponse)
            val response = mapper.toMovieList(jsonResponse)
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                position + (params.loadSize) / NETWORK_PAGE_SIZE
            }
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)

    }


}
}

//        val pageSize: Int = params.loadSize
//        apiInterface.getMovies(apiKey = ApiKey, offset = 0)


//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
//
//
//        return try {
//            val currentPage = params.key ?: 0
//            val response = apiInterface.getMovies(apiKey = "", currentPage)
////            val response = retrofit.getMoviesList()
//            val data = response.body()?.mapToUi()
////            val data = response ?: emptyList()
//            val responseData = mutableListOf<MovieItem>()
//            if (data != null) {
//                responseData.addAll(data)
//            }
//
//
//            LoadResult.Page(
//                data = responseData,
//                prevKey = if (currentPage == 0) null else -1,
//                nextKey = currentPage.plus(20)
//            )
//
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
