package my.project.appselecttest.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import my.project.appselecttest.BuildConfig.ApiKey
import my.project.appselecttest.data.api.ApiInterface
import my.project.appselecttest.data.models.mapToUi
import my.project.appselecttest.presentation.models.Movie


const val NETWORK_PAGE_SIZE = 20

class MoviesPagingSource(
//    private val mapper: MovieListMapper,
    private val apiInterface: ApiInterface,
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPosition = params.key ?: 0
            val pageSize = params.loadSize
//            val jsonResponse = apiInterface.getMovies(apiKey = ApiKey)
            val response =
                apiInterface.getMovies(apiKey = ApiKey, offset = currentPosition).body()?.mapToUi()
            LoadResult.Page(
                data = response.orEmpty(),
                prevKey = if (currentPosition == 0) null else -20,
                nextKey = currentPosition.plus(20)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
//
//        val position = params.key ?: INITIAL_LOAD_SIZE
//        val offset = if (params.key != null)
//            ((position - 1) * NETWORK_PAGE_SIZE) + 1 else INITIAL_LOAD_SIZE
//        return try {
//            val response =
//                apiInterface.getMovies(apiKey = "", offset = offset).body()?.mapToUi()
////                apiInterface.getMovies(apiKey = "").mapToUi()
//            LoadResult.Page(
//                data = response.orEmpty(),
//                prevKey = if (position == 0) null else -20,
//                nextKey = position.plus(20)
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//    }
//}
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
