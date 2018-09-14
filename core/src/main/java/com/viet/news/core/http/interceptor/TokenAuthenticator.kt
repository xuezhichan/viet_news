package com.viet.news.core.http.interceptor

import com.viet.news.core.api.HttpResponse
import com.viet.news.core.api.RetrofitManager
import com.viet.news.core.config.LoginEnum
import com.viet.news.core.domain.User
import com.viet.news.core.domain.request.LoginParams
import com.viet.news.core.domain.response.LoginRegisterResponse
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.io.IOException

/**
 * http status 返回401 处理,需要更新设备token
 * 设备登录:传os_type,device_id,login_type
 */
class TokenAuthenticator : Authenticator {
    @Throws(IOException::class)
    override fun authenticate(route: Route, response: Response): Request? {
        val param = LoginParams()
        param.setType(LoginEnum.HARDWARE)
        //由于GsonFactory强制加了一层HttpResponse，所以此处强制转换
        val data = RetrofitManager.get().apiService()
                .logins(param)
                .execute()
                .body() as HttpResponse<LoginRegisterResponse>?
        val token = data?.data?.token.toString()
        User.currentUser.accessToken = token
        return response.request().newBuilder()
                .addHeader("Authorization", token)
                .build()
    }
}