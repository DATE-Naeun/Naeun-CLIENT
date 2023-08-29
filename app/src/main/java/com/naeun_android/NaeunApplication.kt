package com.naeun_android

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.naeun_android.BuildConfig.KAKAO_NATIVE_APP_KEY

class NaeunApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKakao()
    }

    private fun initKakao() {
        KakaoSdk.init(this, KAKAO_NATIVE_APP_KEY)
    }
}