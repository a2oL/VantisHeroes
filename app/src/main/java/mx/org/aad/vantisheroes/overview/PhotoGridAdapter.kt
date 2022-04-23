package mx.org.aad.vantisheroes.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import mx.org.aad.vantisheroes.databinding.GridViewItemBinding
import mx.org.aad.vantisheroes.network.RickProperty

class PhotoGridAdapter( private val onClickListener: OnClickListener ) : ListAdapter<RickProperty,
        PhotoGridAdapter.RickPropertyViewHolder>(DiffCallback) {

    class RickPropertyViewHolder(private var binding:
                                 GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(rickProperty: RickProperty) {
            binding.property = rickProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RickPropertyViewHolder {
        return RickPropertyViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RickPropertyViewHolder, position: Int) {
        val rickProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(rickProperty)
        }
        holder.bind(rickProperty)
    }
    companion object DiffCallback : DiffUtil.ItemCallback<RickProperty>() {
        override fun areItemsTheSame(oldItem: RickProperty, newItem: RickProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RickProperty, newItem: RickProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class OnClickListener(val clickListener: (rickProperty:RickProperty) -> Unit) {
        fun onClick(rickProperty:RickProperty) = clickListener(rickProperty)
    }

}


