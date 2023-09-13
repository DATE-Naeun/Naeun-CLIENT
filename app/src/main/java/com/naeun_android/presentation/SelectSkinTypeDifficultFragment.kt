package com.naeun_android.presentation

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.naeun_android.R
import com.naeun_android.databinding.FragmentSelectSkinTypeDifficultBinding
import com.naeun_android.databinding.FragmentSelectSkinTypeEasyBinding
import com.naeun_android.util.BindingFragment

class SelectSkinTypeDifficultFragment : BindingFragment<FragmentSelectSkinTypeDifficultBinding>(R.layout.fragment_select_skin_type_difficult) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTextView()
    }

    private fun setupTextView() {
        val titleText = binding.tvQuestionnaireTitle
        val fullText = getString(R.string.skin_type_difficult_title)
        val spannableString = SpannableString(fullText)
        val startIndex = fullText.indexOf("정확한 피부타입 검사 결과")
        val endIndex = startIndex + "정확한 피부타입 검사 결과".length

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
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.main)),
            startIndex,
            endIndex,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE,
        )
    }
}
