package com.example.coupangeatsappmarkii.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coupangeatsappmarkii.MenuAdapter
import com.example.coupangeatsappmarkii.data.InstanceData
import com.example.coupangeatsappmarkii.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //메뉴 목록 보여 주기
        binding.rvSearchFragment.run {
            layoutManager = GridLayoutManager(context, 3)
            adapter = MenuAdapter(InstanceData.menuList)

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}