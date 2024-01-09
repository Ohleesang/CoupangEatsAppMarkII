package com.example.coupangeatsappmarkii

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coupangeatsappmarkii.data.InstanceData
import com.example.coupangeatsappmarkii.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 네비게이터 연결
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        // 네비게이션 동작할떄 라벨 및 이미지 사라지게 않게하기

        // 텍스트뷰 굵기 조정
        navView.setItemTextAppearanceActiveBoldEnabled(false)

        // 틴트를 널값으로주기
        navView.setItemIconTintList(null)


        // 더미데이터 생성
        InstanceData.setDummyDataMenu(this,"dummy_data_menu.xlsx")



    }
}