package my.project.appselecttest.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
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
            binding.textView.visibility = View.GONE
            binding.button.visibility = View.GONE
//            moviesAdapter.setMovies(it)
//            loadingData()
        }

        binding.button.setOnClickListener {
            mainViewModel.getMovies()
        }
        setUpRecyclerView()

    }

//    private fun loadingData() {
//        lifecycleScope.launch {
//            mainViewModel.listData.collect { pagingData ->
//                moviesAdapter.setMovies(pagingData)
//            }
//        }
//    }

    private fun setUpRecyclerView() {
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
    }
}