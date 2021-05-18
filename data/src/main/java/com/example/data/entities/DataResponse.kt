package com.example.data.entities


/**
 * A generic wrapper class around data request
 */

sealed class DataResponse{

    class SUCCESS<RequestData>(var data: RequestData? = null): DataResponse()

    class ERROR(var error: ErrorResponse? = null): DataResponse()

    object LOADING : DataResponse()

}