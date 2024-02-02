package com.example.coupangeatsappmarkii.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsappmarkii.data.ListItem
import com.example.coupangeatsappmarkii.databinding.LayoutGridMenuBinding
import com.example.coupangeatsappmarkii.databinding.LayoutRecommendRestBinding
import com.example.coupangeatsappmarkii.databinding.LayoutRestItemBinding
import com.example.coupangeatsappmarkii.databinding.LayoutTitleBinding
import com.example.coupangeatsappmarkii.databinding.LayoutToolbarSearchBinding

class HomeListAdapter : ListAdapter<ListItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem == newItem
            }
        }
        private const val TYPE_SEARCH = 0
        private const val TYPE_MENU = 1
        private const val TYPE_TITLE = 2
        private const val TYPE_HORIZONTAL_RECYCLER_VIEW = 3
        private const val TYPE_VERTICAL_RECYCLER_VIEW = 4

    }

    // 뷰타입 확인
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ListItem.Search -> TYPE_SEARCH
            is ListItem.MenuList -> TYPE_MENU
            is ListItem.Title -> TYPE_TITLE
            is ListItem.Rest -> TYPE_VERTICAL_RECYCLER_VIEW
            is ListItem.RestList -> TYPE_HORIZONTAL_RECYCLER_VIEW
            else -> -1
        }
    }

    //뷰 홀더 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_SEARCH -> {
                val binding =
                    LayoutToolbarSearchBinding.inflate(inflater, parent, false)
                return SearchViewHolder(binding)
            }

            TYPE_MENU -> {
                val binding =
                    LayoutGridMenuBinding.inflate(inflater, parent, false)
                return MenuViewHolder(binding)
            }

            TYPE_TITLE -> {
                val binding =
                    LayoutTitleBinding.inflate(inflater, parent, false)
                return TitleViewHolder(binding)
            }

            TYPE_HORIZONTAL_RECYCLER_VIEW -> {
                val binding =
                    LayoutRecommendRestBinding.inflate(inflater, parent, false)
                return RecommendRestViewHolder(binding)
            }

            TYPE_VERTICAL_RECYCLER_VIEW -> {
                val binding =
                    LayoutRestItemBinding.inflate(inflater, parent, false)
                return RestViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    // 뷰 홀더 정의
    inner class SearchViewHolder(binding: LayoutToolbarSearchBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class MenuViewHolder(binding: LayoutGridMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val recyclerView = binding.rvMenu
        val menuAdapter = MenuAdapter()
        init{
            recyclerView.layoutManager = GridLayoutManager(recyclerView.context,5)
            recyclerView.adapter = menuAdapter
        }
    }

    inner class TitleViewHolder(binding: LayoutTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvTitle = binding.tvTitle
    }

    inner class RecommendRestViewHolder(binding: LayoutRecommendRestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val recyclerView = binding.rvRest
        val restAdapter = RestAdapter()
        init{
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context,LinearLayoutManager.HORIZONTAL,false)
            recyclerView.adapter = restAdapter
        }
    }

    inner class RestViewHolder(binding: LayoutRestItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val ivRest = binding.ivRestMain
        val ivSubRest = binding.ivRestSub
        val ivSubRest2 = binding.ivRestSub2
        val tvName = binding.tvName
        val tvDistance = binding.tvDistance
        val tvScore = binding.tvScore
        val tvTime = binding.tvTime
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is ListItem.Search -> {}
            is ListItem.Title -> (holder as TitleViewHolder).tvTitle.text = item.name

            is ListItem.MenuList -> (holder as MenuViewHolder).apply {
                menuAdapter.submitList(item.menus)
            }

            is ListItem.Rest -> (holder as RestViewHolder).apply {
                ivRest.setImageResource(item.mainImgRes)
                ivSubRest.setImageResource(item.subImgRes1)
                ivSubRest2.setImageResource(item.subImgRes2)
                tvName.text = item.name
                tvDistance.text = item.distance
                tvScore.text = item.score
                tvTime.text = item.time
            }
            is ListItem.RestList -> (holder as RecommendRestViewHolder).apply{
                restAdapter.submitList(item.rests)
            }
            else ->{}
        }
    }
}