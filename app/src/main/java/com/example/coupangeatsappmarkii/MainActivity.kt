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

        // 더미데이터 생성
        InstanceData.setDummyDataMenu(this,"dummy_data_menu.xlsx")
        InstanceData.setDummyDataRest(this,"dummy_data_rest.xlsx")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 네비게이터 연결
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)




    }
}