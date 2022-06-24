package my.project.appselecttest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.appselecttest.databinding.MoviesItemBinding
import my.project.appselecttest.network.models.MovieModel
import my.project.appselecttest.network.models.MovieUi

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: MoviesItemBinding) : RecyclerView.ViewHolder(binding.root)


    private val diffCallBack = object : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var movies: MutableList<MovieModel>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(MoviesItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.binding.apply {
            movieTitle.text = currentMovie.title
            Picasso.get().load(currentMovie.picture.toString()).into(holder.binding.imageView)
            textView.text = currentMovie.description
        }
    }

    override fun getItemCount() = movies.size
    }
