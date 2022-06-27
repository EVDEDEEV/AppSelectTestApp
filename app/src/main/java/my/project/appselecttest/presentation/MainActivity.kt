package my.project.appselecttest.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import my.project.appselecttest.R
import my.project.appselecttest.databinding.ActivityMainBinding
import my.project.appselecttest.presentation.adapters.MoviesAdapter
import my.project.appselecttest.presentation.models.Movie


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val moviesAdapter by lazy {
        MoviesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel.movies.observe(this) {
            binding.textView.visibility = View.GONE
            binding.button.visibility = View.GONE
            initObservers()

        }
        setUpRecyclerView()


//            moviesAdapter.setMovies(it)
//            mainViewModel.getMovies()
////            loadingData()
//        }

        binding.button.setOnClickListener {
//                    mainViewModel.getMovies()
            initObservers()
        }

    }

//    }

    private fun setUpRecyclerView() {
//        val moviesAdapter =  MoviesAdapter()
        binding.recyclerView.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL, false
            )
            val itemDecoration =
                DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            getDrawable(R.drawable.divider)?.let { itemDecoration.setDrawable(it) }
            addItemDecoration(itemDecoration)
            setHasFixedSize(true)
        }
    }

    private fun initObservers() {
        lifecycleScope.launch {
            mainViewModel.getMovies().observe(this@MainActivity) {
                moviesAdapter.submitData(lifecycle, it)

            }
        }
    }
}

