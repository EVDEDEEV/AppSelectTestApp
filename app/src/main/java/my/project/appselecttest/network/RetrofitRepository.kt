package my.project.appselecttest.network

import androidx.lifecycle.MutableLiveData
import my.project.appselecttest.network.models.MovieItem
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository
@Inject
constructor(private val apiInterface: ApiInterface) {

//    suspend fun getMovies() = apiInterface.getMovies(apiKey = "")
suspend fun makeApiCall(query: String, liveDataList: MutableLiveData<MovieItem>) {
     val call = apiInterface.getMovies(apiKey = "otfGYS588CxyRQR1xWPdBHzNlL6U2OeR")

 }

}
