package com.example.coupangeatsappmarkii.searchFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coupangeatsappmarkii.data.DummyData
import com.example.coupangeatsappmarkii.data.ListItem
import com.example.coupangeatsappmarkii.databinding.FragmentSearchBinding
import com.example.coupangeatsappmarkii.homeFragment.MenuAdapter

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    private val menuAdapter = MenuAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //메뉴 목록 보여 주기
        binding.rvSearchFragment.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = menuAdapter
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        menuAdapter.submitList(ListItem.MenuList(DummyData.menuList).menus)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}