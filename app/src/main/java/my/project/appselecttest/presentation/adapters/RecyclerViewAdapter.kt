package my.project.appselecttest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.appselecttest.databinding.MoviesItemBinding
import my.project.appselecttest.data.models.MoviesResponse
import my.project.appselecttest.presentation.models.Movie


class RecyclerViewAdapter : PagingDataAdapter<MoviesResponse ,RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack) {

    object DiffUtilCallBack : DiffUtil.ItemCallback<MoviesResponse>() {
        override fun areItemsTheSame(oldItem: MoviesResponse, newItem: MoviesResponse): Boolean {
            return oldItem.hasMore == newItem.hasMore
        }

        override fun areContentsTheSame(
            oldItem: MoviesResponse,
            newItem: MoviesResponse
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
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class MyViewHolder(
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



