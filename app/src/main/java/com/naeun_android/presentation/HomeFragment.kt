package com.naeun_android.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.GravityCompat
import com.naeun_android.R
import com.naeun_android.databinding.FragmentHomeBinding
import com.naeun_android.util.BindingFragment
import com.naeun_android.util.setOnSingleClickListener

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var homeTypePopularAdapter: HomeTypePopularAdapter
    private lateinit var homeTypeCategoryRecommendAdapter: HomeTypeCategoryRecommendAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initPopularAdapter()
        //initCategoryAdapter()
        initDrawerMenu()
    }

    private fun initPopularAdapter() {
        //itemClick 데이터 넣기
        binding.rvTypePopular.adapter = homeTypePopularAdapter
    }

    private fun initCategoryAdapter() {
        //itemClick 데이터 넣기
        binding.rvTypeCategoryRecommend.adapter = homeTypeCategoryRecommendAdapter
    }

    private fun initDrawerMenu() {
        with(binding) {
            btnCategory.setOnSingleClickListener {
                dlDrawer.openDrawer(GravityCompat.START)
            }
            navDrawer.getHeaderView(0).findViewById<ImageView>(R.id.btn_back).setOnSingleClickListener {
                dlDrawer.closeDrawer(GravityCompat.START)
            }
        }
    }
}