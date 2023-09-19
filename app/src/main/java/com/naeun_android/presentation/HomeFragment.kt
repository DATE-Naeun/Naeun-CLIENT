package com.naeun_android.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naeun_android.R
import com.naeun_android.databinding.FragmentHomeBinding
import com.naeun_android.util.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var homeTypePopularAdapter: HomeTypePopularAdapter
    private lateinit var homeTypeCategoryRecommendAdapter: HomeTypeCategoryRecommendAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPopularAdapter()
        initCategoryAdapter()
    }

    private fun initPopularAdapter() {
        //itemClick 데이터 넣기
        binding.rvTypePopular.adapter = homeTypePopularAdapter
    }

    private fun initCategoryAdapter() {
        //itemClick 데이터 넣기
        binding.rvTypeCategoryRecommend.adapter = homeTypeCategoryRecommendAdapter
    }
}