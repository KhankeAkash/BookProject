package com.example.bookproject.MasterActivity

import com.example.bookproject.Retrofit.MasterDataResponse
import com.example.bookproject.Retrofit.RType
import com.example.bookproject.Retrofit.SyncRequestModel
import com.example.bookproject.Retrofit.retrofit
import com.example.bookproject.common.custom_views.Constant
import retrofit2.Response

class MasterRepository {
    suspend fun callMaster(
        Rtype: MutableList<RType>,
        tenantId: String?,
        branch: List<String>
    ): Response<MasterDataResponse> {

        return retrofit.apiService.syncRequest(
            authHeader = Constant.BARER_TOKEN ,
            request = SyncRequestModel(
                RTYPE = Rtype,
                tenantId = tenantId,
                branchCode = branch,
                fxVerifier = "N",
                userCode = ""
            )
        )
    }
}