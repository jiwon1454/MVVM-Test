package kc.ac.finaltest.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SafeApi {
    @GET("{API_KEY}/json/pharmListViewInfo/1/758/")
    suspend fun getList(
        @Path("API_KEY") apikey:String?
    ) : Response<Safe>
}