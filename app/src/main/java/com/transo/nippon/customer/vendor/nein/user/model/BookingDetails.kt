package com.transo.nippon.customer.vendor.nein.user.model

data class BookingDetails(

    var bookingId: String? = null,
    var origin: String? = null,
    var destination: String? = null,
    var isExpanded: Boolean = false
)