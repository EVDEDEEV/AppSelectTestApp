//package my.project.appselecttest.network.paging
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import my.project.appselecttest.network.ApiInterface
//import my.project.appselecttest.network.models.MovieItem
//
//class MoviesPagingSource(
//    private val apiInterface: ApiInterface
//    ): PagingSource<Int, MovieItem>() {
//
//
//    override fun getRefreshKey(state: PagingState<Int, MovieItem>): Int? {
//        return null
//    }
//
//
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
//
//        return try {
//            val  currentPage = params.key ?:1
//            val response = apiInterface.getMovies(apiKey = "", currentPage)
//            val data = response.body()?.movieItems?: emptyList()
//            val responseData = mutableListOf<MovieItem>()
//            responseData.addAll(data)
//
//            LoadResult.Page(
//                data = responseData,
//                prevKey = if (currentPage == 1) null else -1,
//                nextKey = currentPage.plus(1)
//            )
//
//        }catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//}