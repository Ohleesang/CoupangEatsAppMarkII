package com.example.coupangeatsappmarkii.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coupangeatsappmarkii.R
import com.example.coupangeatsappmarkii.data.InstanceData
import com.example.coupangeatsappmarkii.databinding.FragmentHomeBinding
import com.example.coupangeatsappmarkii.databinding.LayoutFragmentHomeMenuBinding



class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //메뉴 부분
        onCreateGridLayout()

        //추천 맛집 부분
        binding.rvRecommendRest.run{
            layoutManager =LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = RecommendRestAdapter(InstanceData.restList)
        }

        //골라 먹는 맛집 부분
        binding.rvRest.run{
            layoutManager = LinearLayoutManager(context)
            adapter = RestAdapter(InstanceData.restList)
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onCreateGridLayout() {
        val layoutInflater = LayoutInflater.from(context)
        val gridLayout = binding.glMenu
        var childBinding: LayoutFragmentHomeMenuBinding
        //0~8 까지 메뉴 인스턴스 출력
        for (idx in 0..8) {
            childBinding = LayoutFragmentHomeMenuBinding.inflate(layoutInflater)

            InstanceData.menuList[idx].run {
                childBinding.run {
                    ivMenu.setImageResource(imgRes)
                    tvMenuName.text = name
                }
                gridLayout.addView(childBinding.root)
            }
        }

        // 버튼 추가
        childBinding = LayoutFragmentHomeMenuBinding.inflate(layoutInflater)
        childBinding.run {
            ivMenu.setImageResource(R.drawable.ic_down_arrow_btn)

            childBinding.tvMenuName.text = "더보기"
        }

        val buttonImageView = childBinding.root
        gridLayout.addView(buttonImageView)

        //버튼 이벤트
        buttonImageView.setOnClickListener {
            gridLayout.removeAllViews()
            for (menu in InstanceData.menuList) {
                childBinding = LayoutFragmentHomeMenuBinding.inflate(layoutInflater)
                menu.run {
                    childBinding.ivMenu.setImageResource(imgRes)
                    childBinding.tvMenuName.text = name
                    gridLayout.addView(childBinding.root)
                }
            }
        }


    }
}