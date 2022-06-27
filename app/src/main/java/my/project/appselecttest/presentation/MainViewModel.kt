package my.project.appselecttest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.appselecttest.data.api.ApiInterface
import my.project.appselecttest.data.models.MovieItem
import my.project.appselecttest.data.repository.MovieRepositoryImpl
import my.project.appselecttest.presentation.adapters.MoviesAdapter
import my.project.appselecttest.presentation.models.Movie
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepositoryImpl,
    private val adapter: MoviesAdapter
) : ViewModel() {

    private val _movies = MutableLiveData<PagingData<Movie>?>()
    val movies: LiveData<PagingData<Movie>?> = _movies
//    private val _moviesList = MutableLiveData<PagingData<Movie>>()
//    val movies: MutableLiveData<PagingData<Movie>> = _moviesList


    //    : LiveData<PagingData<Movie>>
//    fun getMovies() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = repository.getMoviesList().value
////            val response = repository.getMoviesList().value
//            _movies.postValue(response)
//        }
////        return response
//    }

//    init {
//        getMovies()
//    }
//}

suspend fun getMovies(): LiveData<PagingData<Movie>> {
        val response = repository.getMoviesList().cachedIn(viewModelScope)
        _movies.value = response.value
        return response
    }
}

//    suspend fun getMovies(): LiveData<PagingData<Movie>> {
//        val response = repository.getMoviesList()
//        _moviesList.value = response.value
//        return response
//    }
//}


//    init {
//        getMovies()
//    }


//    private val _movies = MutableLiveData<List<Movie>>()
//    val movies: LiveData<List<Movie>> = _movies
//
//    fun getMovies() {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val moviesList = repository.getMoviesList()
//                _movies.postValue(moviesList)
//            } catch (exception: Exception) {
//            }
//        }
//    }
//    init {
//        getMovies()
//    }
//
//
//    val listData = Pager(PagingConfig(pageSize = 1)) {
//        MoviesPagingSource(apiInterface)
//    }.flow.cachedIn(viewModelScope)


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
//}






