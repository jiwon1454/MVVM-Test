package kc.ac.finaltest.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val API_URL = "http://openapi.seoul.go.kr:8088/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //  늦은 초기화 작업
        val api: SafeApi by lazy {
        retrofit.create(SafeApi::class.java)
    }
}
