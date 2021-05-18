package com.example.domain.entities


/**
 * A generic wrapper class around data request
 */

sealed class DataEntity< out RequestData>{
    class ERROR(var error: ErrorEntity): DataEntity<Nothing>()

    class SUCCESS<RequestData>(var data: RequestData? = null): DataEntity<RequestData>()

    object LOADING : DataEntity<Nothing>()

}