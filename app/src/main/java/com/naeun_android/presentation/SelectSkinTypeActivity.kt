package com.naeun_android.presentation

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.naeun_android.R
import com.naeun_android.databinding.ActivitySelectSkinTypeBinding
import com.naeun_android.util.BindingActivity

class SelectSkinTypeActivity :
    BindingActivity<ActivitySelectSkinTypeBinding>(R.layout.activity_select_skin_type) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TextView 설정을 별도의 함수로 분리
        setupTextView()
        setupTabLayoutAndViewPager()
    }

    private fun setupTextView() {
        val titleText = binding.tvSkinTypeTitle
        val fullText = getText(R.string.skin_type_title)
        val spannableString = SpannableString(fullText)
        val startIndex = fullText.indexOf("피부타입")
        val endIndex = startIndex + "피부타입".length

        applySpannableStyle(spannableString, startIndex, endIndex)
        titleText.text = spannableString
    }

    private fun applySpannableStyle(
        spannableString: SpannableString,
        startIndex: Int,
        endIndex: Int,
    ) {
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            startIndex,
            endIndex,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE,
        )

        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.main)),
            startIndex,
            endIndex,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
    }

    private fun setupTabLayoutAndViewPager() {
        binding.tlSelectQuestion.addTab(binding.tlSelectQuestion.newTab().setText("간편하게 선택"))
        binding.tlSelectQuestion.addTab(binding.tlSelectQuestion.newTab().setText("질문지로 선택"))

        val fragmentManager: FragmentManager = supportFragmentManager
        val adapter = SelectSkinTypeFragmentAdapter(fragmentManager, lifecycle)
        binding.viewpager2SelectSkinType.adapter = adapter

        binding.tlSelectQuestion.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewpager2SelectSkinType.currentItem = tab.position

                when (tab.position) {
                    0 -> binding.btnNext.text = getString(R.string.delete)
                    else -> binding.btnNext.text = getString(R.string.go_question)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        binding.viewpager2SelectSkinType.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tlSelectQuestion.selectTab(binding.tlSelectQuestion.getTabAt(position))
            }
        })
    }
}
