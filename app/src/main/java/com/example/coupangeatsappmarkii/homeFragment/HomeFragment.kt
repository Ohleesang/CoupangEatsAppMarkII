package com.example.coupangeatsappmarkii.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coupangeatsappmarkii.data.DummyData
import com.example.coupangeatsappmarkii.data.ListItem
import com.example.coupangeatsappmarkii.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val listAdapter = HomeListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val list = mutableListOf<ListItem>()
        list.add(ListItem.Search)
        list.add(ListItem.MenuList(DummyData.menuList))
        list.add(ListItem.Title("이즈 추천 맛집"))
        list.add(ListItem.RestList(DummyData.restList))
        list.add(ListItem.Title("골라 먹는 맛집"))
        list.addAll(DummyData.restList)
        listAdapter.submitList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}