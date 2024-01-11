package com.example.coupangeatsappmarkii.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsappmarkii.data.Rest
import com.example.coupangeatsappmarkii.databinding.LayoutRestBinding


class RestAdapter(private val mRests: MutableList<Rest>) :
    RecyclerView.Adapter<RestAdapter.Holder>() {


    inner class Holder(binding: LayoutRestBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val name = binding.tvName
        val time = binding.tvTime
        val score = binding.tvScore
        val distance = binding.tvDistance
        val mainImgRes = binding.ivRestMain
        val subImgRes = binding.ivRestSub
        val subImgRes2 = binding.ivRestSub2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            LayoutRestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
            subImgRes.setImageResource(rest.subImgRes1)
            subImgRes2.setImageResource(rest.subImgRes2)
        }
    }

    override fun getItemCount(): Int = mRests.size


}