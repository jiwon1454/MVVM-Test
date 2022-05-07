package kc.ac.finaltest.repository

import android.util.Log
import kc.ac.finaltest.remote.RetrofitObject
import kc.ac.finaltest.remote.Safe
import retrofit2.Response

//MVVM 패턴을 위해 데이터 통신을 하는 Repository 생성( 여기서 통신한 값을 뷰모델에서 사용)
//실제로 데이터에 접근

class SafeRepository {
    suspend fun getSafeList(apiKey : String) : Response<Safe>{
//        Log.d("Repository","on")
        return RetrofitObject.api.getList(apiKey)
    }
}