package my.project.appselecttest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.appselecttest.presentation.models.Movie
import my.project.appselecttest.network.ApiInterface
import my.project.appselecttest.network.models.mapToUi
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: ApiInterface,
) : ViewModel() {

    companion object {
        const val API_KEY = "otfGYS588CxyRQR1xWPdBHzNlL6U2OeR"
    }

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result =
                    api.getMovies(apiKey = API_KEY).body().mapToUi()
                _movies.postValue(result)
            } catch (exception: Exception) {
            }
        }
    }
    init {
        getMovies()
    }
}



