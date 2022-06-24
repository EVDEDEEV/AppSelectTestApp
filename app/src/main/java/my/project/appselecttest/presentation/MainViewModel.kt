package my.project.appselecttest.presentation

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

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private suspend fun getMovies(): List<Movie> {
        return api.getMovies(apiKey = "otfGYS588CxyRQR1xWPdBHzNlL6U2OeR").body().mapToUi()
    }

    init {
            viewModelScope.launch(Dispatchers.IO) {
                val getMovies = getMovies()
                _movies.postValue(getMovies)
            }
        }
    }



