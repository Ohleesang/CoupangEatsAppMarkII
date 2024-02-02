package com.example.coupangeatsappmarkii.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsappmarkii.data.ListItem
import com.example.coupangeatsappmarkii.databinding.LayoutFragmentHomeMenuBinding

class MenuAdapter : ListAdapter<ListItem.Menu, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListItem.Menu>() {
            override fun areItemsTheSame(oldItem: ListItem.Menu, newItem: ListItem.Menu): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ListItem.Menu,
                newItem: ListItem.Menu,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class MenuViewHolder(binding: LayoutFragmentHomeMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val ivMenu = binding.ivMenu
        val tvMenu = binding.tvMenuName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            LayoutFragmentHomeMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as MenuViewHolder).apply {
            ivMenu.setImageResource(item.imgRes)
            tvMenu.text = item.name
        }
    }
}