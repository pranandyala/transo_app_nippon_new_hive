package com.transo.nippon.customer.vendor.nein.user.model

data class LRDetails(

    var lrNo: String? = null,
    var origin: String? = null,
    var destination: String? = null,
    var pod: String? = null,
    var isExpanded: Boolean = false
)