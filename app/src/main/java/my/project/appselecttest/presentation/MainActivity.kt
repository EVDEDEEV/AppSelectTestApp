package my.project.appselecttest.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import my.project.appselecttest.R
import my.project.appselecttest.databinding.ActivityMainBinding
import my.project.appselecttest.presentation.adapters.RecyclerViewAdapter


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var moviesAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.movies.observe(this) {
            moviesAdapter.setMovies(it)
        }
        setUpRv()
    }



    private fun setUpRv() {
        moviesAdapter = RecyclerViewAdapter()

        binding.recyclerView.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL, false
            )
            val itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            getDrawable(R.drawable.divider)?.let { itemDecoration.setDrawable(it) }
            addItemDecoration(itemDecoration)
            setHasFixedSize(true)


        }
//
//        mainViewModel.allMovies.observe(this) { listMovies ->
//
//            moviesAdapter.movies = listMovies
//        }
//
//
//    }


    }
}