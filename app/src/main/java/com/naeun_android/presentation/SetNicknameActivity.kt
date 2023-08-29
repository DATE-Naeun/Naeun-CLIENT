package com.naeun_android.presentation

import android.os.Bundle
import android.view.MotionEvent
import com.naeun_android.R
import com.naeun_android.databinding.ActivitySetNicknameBinding
import com.naeun_android.util.BindingActivity
import com.naeun_android.util.hideKeyboard

class SetNicknameActivity : BindingActivity<ActivitySetNicknameBinding>(R.layout.activity_set_nickname) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        this.currentFocus?.let { hideKeyboard(it)}
        binding.etNickname.clearFocus()
        return super.dispatchTouchEvent(ev)
    }
}