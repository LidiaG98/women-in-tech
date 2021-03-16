package com.applaudostudios.womenintech.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.applaudostudios.womenintech.databinding.WomanItemBinding
import com.applaudostudios.womenintech.model.Women
import com.applaudostudios.womenintech.ui.adapter.WomenListAdapter.WomenListViewHolder

class WomenListAdapter(private val clickListener: WomanListener) :
    ListAdapter<Women, WomenListViewHolder>(WomenListDiffCallback()) {

    class WomanListener(val clickListener: (photoId: Int) -> Unit) {
        fun onClick(woman: Women) = clickListener(woman.womanId)
    }

    class WomenListViewHolder(private var binding: WomanItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(woman: Women, clickListener: WomanListener) {
            binding.woman = woman
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: WomenListViewHolder, position: Int) {
        val photoPreview = getItem(position)
        holder.bind(photoPreview, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WomenListViewHolder {
        return WomenListViewHolder(WomanItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    class WomenListDiffCallback : DiffUtil.ItemCallback<Women>() {

        override fun areItemsTheSame(
            oldItem: Women,
            newItem: Women
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: Women,
            newItem: Women
        ): Boolean {
            return (oldItem == newItem)
        }
    }
}