package com.example.bookproject.Retrofit

 //class DataClass{
     data class LoginRequest(
         var username: String,
         var password: String,
         var deviceId : String? = ""
     )

//     data class LoginResponse(
//         val access_token: String?,
//         val refresh_token: String?
//     )

data class preloginRequestModel(
    val username : String,
    val password : String,
)

data class preLoginResponse(

    val statusCode: String?,
    val successCode: String?,
    val message: String?,
    val data: PreLoginData?

)

data class PreLoginData(
    val token: String?
)

data class LoginResponse(
    val statusCode: Int?,
    val message: String?,
    val data: LoginData?
)

data class LoginData(
    val token: String?,
    val tokenValidity: Long?,
    val tenantId: Int?,
    val user: User?
)

data class User(
    val loginId: String?,
    val userName: String?,
    val tenantId: Int?,
    val roleCode: String?,
    val mobileNo1: String?,
    val userTypeCode: String?,
    val reportingUserCode: String?,
    val userFName: String?,
    val userMName: String?,
    val userLName: String?,
    val userDisplayName: String?,
    val userBaseBranchCode: String?,
    val emailId: String?,
    val forcePwdChgYN: Int?,
    val forcePwdChgDays: Int?,
    val employeeId: String?,
    val authStatus: String?,
    val isSuspended: Int?,
    val assignedBranch: String?,
    val preferLang: String?,
    val lastSuccessfulLoginDateTime: Long?,
    val lastSuccessfulLoginDateTimeStr: String?
)

data class SyncRequestModel(
    val RTYPE: List<RType>?,
    val branchCode: List<String>?,
    val fxVerifier: String?,
    val tenantId: String?,
    val userCode: String?
)

data class RType(
    val createDate: String?,
    val module: String?
)

data class MasterDataResponse(
    val statusCode: Int?,
    val message: String?,
    val data: MasterData?
)

data class MasterData(
    val responseDate: String?,
    val CR: Any?,
    val ST: Any?,
    val DT: Any?,
    val CT: Any?,
    val MT: Any?,
    val AR: Any?,
    val LK: Any?,
    val VL: Any?,
    val BR: Any?,
    val PR: List<PR>?,
    val PL: Any?,
    val GL: Any?,
    val DU: Any?,
    val UL: Any?,
    val GD: Any?,
    val GV: Any?,
    val GVO: Any?,
    val LD: Any?,
    val LA: Any?,
    val CO: Any?,
    val FX: Any?,
    val FM: Any?,
    val SC: Any?,
    val IR: Any?,
    val AD: Any?,
    val GVQ: Any?,
    val PO: Any?,
    val CTST: Any?,
    val VM: Any?,
    val BM: Any?,
    val SM: Any?,
    val MK: Any?,
    val MD: Any?,
    val IE: Any?
)

data class PR(
    val subFacilityCode: String?,
    val subFacilityName: String?,
    val facilityCode: String?,
    val facilityName: String?,
    val workFlowFile: String?,
    val processId: String?,
    val effectiveFrom: String?,
    val effectiveTill: String?,
    val status: String?,
    val minimumTenure: Int?,
    val maximumTenure: Int?,
    val foreClosureLockIn: Int?,
    val calculationType: String?,
    val interestType: String?,
    val fixedPeriod: Int?,
    val floatingPeriod: Int?,
    val floorLimit: Double?,
    val cielLimit: Double?,
    val interestRate: Double?,
    val discountROI: Double?,
    val moratoriunPeriod: Int?,
    val moratoriumCalculationType: String?,
    val tenureOveride: String?,
    val financeChargeOverride: String?,
    val moduleCode: String?,
    val installmentType: String?,
    val securityType: String?,
    val otherLanguage: String?,
    val authStatus: String?,
    val tenantId: Int?,
    val typeCropInd: String?,
    val customerCatagory: String?,
    val typeOfLoan: String?,
    val applicationType: String?,
    val purposeMultiSel: String?,
    val mulUserSel: String?
)
