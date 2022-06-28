package my.project.appselecttest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.appselecttest.databinding.MoviesItemBinding
import my.project.appselecttest.presentation.models.Movie


class MoviesAdapter : PagingDataAdapter<Movie, MoviesAdapter.MyViewHolder>(DiffUtilCallBack) {

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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MoviesItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class MyViewHolder(
        private val binding: MoviesItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            Picasso.get().load(movie.image).into(binding.imageView)
            binding.movieTitle.text = movie.title
            binding.descriptionText.text = movie.description
        }
    }
}






