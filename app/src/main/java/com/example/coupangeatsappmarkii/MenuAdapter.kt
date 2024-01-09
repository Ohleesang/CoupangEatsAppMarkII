package com.example.coupangeatsappmarkii
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsappmarkii.data.Menu
import com.example.coupangeatsappmarkii.databinding.LayoutMenuBinding


class MenuAdapter(private val mMenus: MutableList<Menu>) :
    RecyclerView.Adapter<MenuAdapter.Holder>() {


    inner class Holder(binding: LayoutMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgRes = binding.ivMenu
        val name = binding.tvMenuName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            LayoutMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val menu = mMenus[position]
        holder.run{
            imgRes.setImageResource(menu.imgRes)
            name.text = menu.name
        }
    }

    override fun getItemCount(): Int = mMenus.size


}