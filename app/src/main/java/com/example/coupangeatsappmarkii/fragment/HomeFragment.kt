package com.example.coupangeatsappmarkii.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.gridlayout.widget.GridLayout
import com.example.coupangeatsappmarkii.R
import com.example.coupangeatsappmarkii.data.InstanceData
import com.example.coupangeatsappmarkii.databinding.FragmentHomeBinding
import com.example.coupangeatsappmarkii.databinding.LayoutMenuBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        onCreateGridLayout()

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onCreateGridLayout() {
        val layoutInflater = LayoutInflater.from(context)
        val gridLayout = binding.glMenu
        var childBinding: LayoutMenuBinding
        //0~9 까지 메뉴 인스턴스 출력
        for (idx in 0..8) {
            childBinding = LayoutMenuBinding.inflate(layoutInflater)

            InstanceData.menuList[idx].run {
                childBinding.run {
                    ivMenu.setImageResource(imgRes)
                    tvMenuName.text = name
                }
                gridLayout.addView(childBinding.root)
            }
        }

        // 버튼 추가
        childBinding = LayoutMenuBinding.inflate(layoutInflater)
        childBinding.run {
            ivMenu.setImageResource(R.drawable.btn_see_more)
            childBinding.tvMenuName.text = "더보기"
        }

        val buttonImageView = childBinding.root
        gridLayout.addView(buttonImageView)

        //버튼 이벤트
        buttonImageView.setOnClickListener {
            gridLayout.removeAllViews()
            for (menu in InstanceData.menuList) {
                childBinding = LayoutMenuBinding.inflate(layoutInflater)
                menu.run {
                    childBinding.ivMenu.setImageResource(imgRes)
                    childBinding.tvMenuName.text = name
                    gridLayout.addView(childBinding.root)
                }
            }
        }


    }
}