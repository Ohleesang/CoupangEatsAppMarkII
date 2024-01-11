package com.example.coupangeatsappmarkii.searchFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsappmarkii.data.Menu
import com.example.coupangeatsappmarkii.databinding.LayoutFragmentSearchMenuBinding


class MenuAdapter(private val mMenus: MutableList<Menu>) :
    RecyclerView.Adapter<MenuAdapter.Holder>() {


    inner class Holder(binding: LayoutFragmentSearchMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imgRes = binding.ivMenu
        val name = binding.tvMenuName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            LayoutFragmentSearchMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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