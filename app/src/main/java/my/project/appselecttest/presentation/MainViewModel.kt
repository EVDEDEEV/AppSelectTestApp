package my.project.appselecttest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import my.project.appselecttest.presentation.models.Movie
import my.project.appselecttest.network.ApiInterface
import my.project.appselecttest.network.RetrofitRepository
import my.project.appselecttest.network.models.mapToUi
import my.project.appselecttest.network.paging.MoviesPagingSource
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RetrofitRepository,
    private val apiInterface: ApiInterface
) : ViewModel() {



    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val moviesList = repository.getMoviesList()
                _movies.postValue(moviesList)
            } catch (exception: Exception) {
            }
        }
    }
    init {
        getMovies()
    }


    val listData = Pager(PagingConfig(pageSize = 1)) {
        MoviesPagingSource(apiInterface)
    }


//    fun getMovies() {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val result =
//                    api.getMovies(apiKey = API_KEY, offset = 20).body().mapToUi()
//                _movies.postValue(result)
//            } catch (exception: Exception) {
//            }
//        }
//    }
//    init {
//        getMovies()
//    }
}



