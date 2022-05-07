package kc.ac.finaltest.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//약국 데이터중에 필요한 데이터 클래스만 생성

data class Safe(
    @SerializedName("pharmListViewInfo")
    @Expose
    var pharmListViewInfo : PharamListViewInfo
)

data class PharamListViewInfo(
    @SerializedName("list_total_count")
    @Expose
    var listtotalcount : Int?=null,
    var row:List<Row>
)

data class Row(
    @SerializedName("PHARM_NAME")
    @Expose
    var pharm_name : String
)