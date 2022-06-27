package my.project.appselecttest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import my.project.appselecttest.data.repository.MovieRepositoryImpl
import my.project.appselecttest.presentation.models.Movie
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepositoryImpl,
) : ViewModel() {

    suspend fun getMovies(): Flow<PagingData<Movie>> {
        return repository.getMoviesList().cachedIn(viewModelScope)
    }
}






