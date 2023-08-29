package com.naeun_android.presentation

import android.content.Intent
import android.os.Bundle
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.naeun_android.R
import com.naeun_android.databinding.ActivityLoginBinding
import com.naeun_android.util.BindingActivity
import com.naeun_android.util.setOnSingleClickListener
import timber.log.Timber

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        clickLoginButton()
    }

    private fun clickLoginButton() {
        binding.btnKakaoLogin.setOnSingleClickListener {
            goSetNicknameActivity()
            //loginWithKakao()
        }
    }

    private fun loginWithKaKao() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Timber.e(error, "카카오계정으로 로그인 실패")
            } else if (token != null) {
                Timber.d("카카오계정으로 로그인 성공 " + token.accessToken)
                // 파이어베이스 FCM 토큰 얻어오기
                // 액세스토큰 자동로그인 세팅하기
            }
        }

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null) {
                    Timber.e(error, "카카오톡으로 로그인 실패")

                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                } else if (token != null) {
                    Timber.d("카카오톡으로 로그인 성공 " + token.accessToken)
                    callback.invoke(token, error)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }

    private fun goSetNicknameActivity() {
        startActivity(Intent(this, SetNicknameActivity::class.java))
        if (!isFinishing) finish()
    }

}