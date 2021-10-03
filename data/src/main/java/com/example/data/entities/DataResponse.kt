package com.example.data.entities

/**
 * A generic wrapper class around data request
 */

sealed class DataResponse<RequestData> {

    class SUCCESS<RequestData>(var data: RequestData? = null) : DataResponse<RequestData>()

    class ERROR<RequestData>(var error: ErrorResponse? = null, var data: RequestData? = null) : DataResponse<RequestData>()

    class LOADING<RequestData>(var data: RequestData? = null) : DataResponse<RequestData>()
}