package com.transo.nippon.customer.vendor.nein.user.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.transo.nippon.customer.vendor.nein.user.R
import com.transo.nippon.customer.vendor.nein.user.model.BookingDetails
import com.transo.nippon.customer.vendor.nein.user.model.LRDetails


class DownloadPODAdapter(
    context: Context,
    item: Int,
    navController: NavController,
    mBookingList: ArrayList<LRDetails>
    //addressModelList: List<AddressModel>,
    //listener: AddressListener
) :
    RecyclerView.Adapter<DownloadPODAdapter.MyViewHolder?>() {
    private val context: Context

    //  private val addressModelList: List<AddressModel>
    // private var addressModelListFiltered: List<AddressModel>
    // private val listener: AddressListener
    private val item = 0
    lateinit var navController: NavController
    lateinit var mBookingList: ArrayList<LRDetails>
    private var isExpand = false

    init {
        this.context = context
        this.navController = navController
        this.mBookingList = mBookingList
        //  this.listener = listener
        // this.addressModelList = addressModelList
        //addressModelListFiltered = addressModelList
        //  this.item = item
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var bookingId: MaterialTextView
        lateinit var origin: MaterialTextView
        lateinit var destination: MaterialTextView
        lateinit var hiddenLayout: ConstraintLayout
        lateinit var arrowButton: ImageButton;

        init {
            bookingId = view.findViewById<MaterialTextView>(R.id.booking_number)
            origin = view.findViewById<MaterialTextView>(R.id.origin_city)
            destination = view.findViewById<MaterialTextView>(R.id.destination_city)

            hiddenLayout = view.findViewById(R.id.hidden_layout_invoice)
            arrowButton = view.findViewById(R.id.arrow_button)
            view.setOnClickListener { view1: View? ->
/*
                if (isExpand) {
                    hiddenLayout.visibility = View.GONE
                    isExpand = false
                    arrowButton.setImageResource(R.drawable.ic_add)

                } else {
                    isExpand = true
                    // send selected item in callback
                    //  listener.onSelected(addressModelListFiltered[adapterPosition])
                    // navController.navigate(R.id.action_invoice_eway_Fragment_to_Picture)
                    arrowButton.setImageResource(R.drawable.remove_booking)
                    hiddenLayout.visibility = View.VISIBLE
                }*/

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.download_pod_view_holder, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mBookingList.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bookingId.setText(mBookingList.get(position).lrNo)
        holder.origin.setText(mBookingList.get(position).origin)
        holder.destination.setText(mBookingList.get(position).destination)
    }

}