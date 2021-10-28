package com.davidmendozamartinez.technicaltest.cakes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.davidmendozamartinez.technicaltest.cakes.databinding.ItemCakeBinding
import com.davidmendozamartinez.technicaltest.cakes.domain.model.Cake

class CakeAdapter(private val clickListener: (Cake) -> Unit) :
    ListAdapter<Cake, CakeAdapter.ViewHolder>(CakeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { cake ->
            holder.bind(cake)
            holder.itemView.setOnClickListener { clickListener(cake) }
        }
    }

    class ViewHolder private constructor(
        private val binding: ItemCakeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCakeBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: Cake) {
            binding.root.text = item.title
        }
    }
}

class CakeDiffCallback : DiffUtil.ItemCallback<Cake>() {
    override fun areItemsTheSame(oldItem: Cake, newItem: Cake): Boolean =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Cake, newItem: Cake): Boolean =
        oldItem == newItem
}
