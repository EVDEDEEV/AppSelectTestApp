package my.project.appselecttest.presentation

import android.os.Binder
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import my.project.appselecttest.R
import my.project.appselecttest.databinding.ActivityMainBinding
import my.project.appselecttest.presentation.adapters.MoviesAdapter


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        GlobalScope.launch(Dispatchers.IO) {
//            val rtt = Api.api.getMovies("otfGYS588CxyRQR1xWPdBHzNlL6U2OeR").body()
//            val ano = rtt
//            val ona = 3
//        }

//        mainViewModel.getAllMovies()

    }


//    private fun setUpRv() {
//        moviesAdapter = MoviesAdapter()
//
//        binding.recyclerView.apply {
//            adapter = moviesAdapter
//            layoutManager = LinearLayoutManager(
//                this@MainActivity,
//                LinearLayoutManager.HORIZONTAL, false
//            )
//            setHasFixedSize(true)
//        }
//
//        mainViewModel.allMovies.observe(this) { listMovies ->
//
//            moviesAdapter.movies = listMovies
//        }
//
//
//    }


}