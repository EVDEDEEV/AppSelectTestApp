package my.project.appselecttest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.appselecttest.di.AppModule
import my.project.appselecttest.domain.models.Movie
import my.project.appselecttest.network.ApiInterface
import my.project.appselecttest.network.RetrofitRepository
import my.project.appselecttest.network.models.MovieItem
import javax.inject.Inject


@HiltViewModel
class MainViewModel
@Inject constructor
    (private val api: ApiInterface) : ViewModel() {

    private val _response = MutableLiveData<List<MovieItem>>()
    val response: LiveData<List<MovieItem>> = _response

    init {
        fun getAllMovies() {
            viewModelScope.launch(Dispatchers.IO) {
                api.getMovies(apiKey = "").let { response ->
                    if (response.isSuccessful) {
                        _response.postValue(response.body())
                    } else {
                        Log.d("checkData", "Failed to load movies: ${response.errorBody()}")
                    }
                }
            }
        }


    }
}


