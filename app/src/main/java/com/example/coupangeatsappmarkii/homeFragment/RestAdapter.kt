package com.example.coupangeatsappmarkii.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsappmarkii.data.ListItem
import com.example.coupangeatsappmarkii.databinding.LayoutFragmentHomeMenuBinding
import com.example.coupangeatsappmarkii.databinding.LayoutRecommendRestBinding
import com.example.coupangeatsappmarkii.databinding.LayoutRecommendRestItemBinding

class RestAdapter : ListAdapter<ListItem.Rest, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListItem.Rest>() {
            override fun areItemsTheSame(oldItem: ListItem.Rest, newItem: ListItem.Rest): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ListItem.Rest,
                newItem: ListItem.Rest,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class RestViewHolder(binding: LayoutRecommendRestItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val ivRest = binding.ivRestMain
        val tvName = binding.tvName
        val tvDistance = binding.tvDistance
        val tvScore = binding.tvScore
        val tvTime = binding.tvTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            LayoutRecommendRestItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as RestViewHolder).apply {
            ivRest.setImageResource(item.mainImgRes)
            tvName.text = item.name
            tvDistance.text = item.distance
            tvScore.text = item.score
            tvTime.text = item.time
        }
    }
}