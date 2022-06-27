package my.project.appselecttest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.appselecttest.data.models.MovieItem
import my.project.appselecttest.databinding.MoviesItemBinding
import my.project.appselecttest.presentation.models.Movie
import my.project.appselecttest.presentation.models.MovieList


class MoviesAdapter : PagingDataAdapter<Movie, MoviesAdapter.MyViewHolder>(DiffUtilCallBack) {

//private var listMovies = emptyList<Movie>()

    object DiffUtilCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie,
        ): Boolean {
            return oldItem == newItem
        }
    }

    private var moviesList = emptyList<Movie>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
//        return MyViewHolder(MoviesItemBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MoviesItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.bind(moviesList[position])
        getItem(position)?.let {
            holder.bind(it)
        }
    }

//    override fun getItemCount(): Int {
//        return moviesList.size
//    }

    inner class MyViewHolder(
        private val binding: MoviesItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            Picasso.get().load(movie.image).into(binding.imageView)
            binding.movieTitle.text = movie.title
            binding.descriptionText.text = movie.description
        }
    }

    fun setMovies(movies: List<Movie>) {
        moviesList = movies
        notifyDataSetChanged()
    }
}






