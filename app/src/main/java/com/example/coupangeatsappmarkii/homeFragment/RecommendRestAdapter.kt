package com.example.coupangeatsappmarkii.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsappmarkii.data.Rest
import com.example.coupangeatsappmarkii.databinding.LayoutRecommendRestBinding


class RecommendRestAdapter(private val mRests: MutableList<Rest>) :
    RecyclerView.Adapter<RecommendRestAdapter.Holder>() {


    inner class Holder(binding: LayoutRecommendRestBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val name = binding.tvName
        val time = binding.tvTime
        val score = binding.tvScore
        val distance = binding.tvDistance
        val mainImgRes = binding.ivRestMain
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            LayoutRecommendRestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val rest = mRests[position]

        holder.run {
            name.text = rest.name
            time.text = rest.time
            score.text = rest.score
            distance.text = rest.distance

            mainImgRes.setImageResource(rest.mainImgRes)
        }
    }

    override fun getItemCount(): Int = mRests.size


}