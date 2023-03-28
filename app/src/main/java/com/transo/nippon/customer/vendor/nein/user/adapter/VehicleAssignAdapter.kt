package com.transo.nippon.customer.vendor.nein.user.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import com.transo.nippon.customer.vendor.nein.user.R
import com.transo.nippon.customer.vendor.nein.user.model.BookingDetails
import java.lang.String
import java.util.*
import kotlin.collections.ArrayList

/*
class UploadInvoiceAdapter {
}*/


class VehicleAssignAdapter(
    context: Context,
    item: Int,
    navController: NavController,
    mBookingList: ArrayList<BookingDetails>
    //addressModelList: List<AddressModel>,
    //listener: AddressListener
) :
    RecyclerView.Adapter<VehicleAssignAdapter.MyViewHolder?>() {
    private val context: Context

    //  private val addressModelList: List<AddressModel>
    // private var addressModelListFiltered: List<AddressModel>
    // private val listener: AddressListener
    private val item = 0
    lateinit var navController: NavController
    lateinit var mBookingList: ArrayList<BookingDetails>
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
        lateinit var fixedLayout: ConstraintLayout
        lateinit var mGpsProvider: MaterialCheckBox
        lateinit var mSimTracking: MaterialCheckBox

        //     lateinit var mGpsTrackingHeader: AppCompatTextView
        lateinit var mGpsProviderNameLayout: TextInputLayout
        lateinit var mGpsDeviceIDLayout: TextInputLayout

        lateinit var mDriverMobileNoLayout: TextInputLayout

        lateinit var mVehicleASsignSubmit: MaterialButton
        lateinit var mVheicleAssignCancel: MaterialButton


        init {
            fixedLayout = view.findViewById(R.id.fixed_invoice_layout)
            bookingId = view.findViewById<MaterialTextView>(R.id.booking_number)
            origin = view.findViewById<MaterialTextView>(R.id.origin_city)
            destination = view.findViewById<MaterialTextView>(R.id.destination_city)

            hiddenLayout = view.findViewById(R.id.hidden_layout_invoice)
            arrowButton = view.findViewById(R.id.arrow_button)
            mGpsProvider = view.findViewById(R.id.gps_tracking_checkbox)
            mGpsProviderNameLayout = view.findViewById(R.id.gps_device_provider_name_layout)
            mGpsDeviceIDLayout = view.findViewById(R.id.gps_device_ID_layout)

            mSimTracking = view.findViewById(R.id.sim_tracking_checkbox)
            mDriverMobileNoLayout = view.findViewById(R.id.driver_mobile_No_layout)

            mVehicleASsignSubmit = view.findViewById(R.id.submitBtn_vehicle_assign)
            mVheicleAssignCancel = view.findViewById(R.id.resetBtn_vehicle_assign)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.vehicle_assign_viewholder, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mBookingList.size;
    }

    private fun isAnyItemExpanded(position: Int) {
        // what does index of do here
        val temp = mBookingList.indexOfFirst {
            it.isExpanded
        }
        if (temp >= 0 && temp != position) {
            mBookingList[temp].isExpanded = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val bookingDetails = mBookingList[position]
        holder.bookingId.setText(mBookingList.get(position).bookingId)
        holder.origin.setText(mBookingList.get(position).origin)
        holder.destination.setText(mBookingList.get(position).destination)

        val isExpandable: Boolean = bookingDetails.isExpanded
        holder.hiddenLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE
        if (isExpandable) {
            holder.arrowButton.setImageResource(R.drawable.remove_booking)
        } else {
            holder.arrowButton.setImageResource(R.drawable.ic_add)
        }
        holder.fixedLayout.setOnClickListener {
            // if any item expanded collapse it
            isAnyItemExpanded(position)
            bookingDetails.isExpanded = !bookingDetails.isExpanded


            notifyItemChanged(position, Unit)
        }

        holder.mGpsProvider.setOnCheckedChangeListener { compoundButton, b ->

            if (holder.mGpsProvider.isChecked) {
                holder.mGpsProviderNameLayout.visibility = View.VISIBLE
                holder.mGpsDeviceIDLayout.visibility = View.VISIBLE
            } else {
                holder.mGpsProviderNameLayout.visibility = View.GONE
                holder.mGpsDeviceIDLayout.visibility = View.GONE
            }
        }


        holder.mSimTracking.setOnCheckedChangeListener { compoundButton, b ->
            if (holder.mSimTracking.isChecked) {
                holder.mDriverMobileNoLayout.visibility = View.VISIBLE
                holder.mVehicleASsignSubmit.visibility = View.VISIBLE
                holder.mVheicleAssignCancel.visibility = View.VISIBLE
            } else {
                holder.mDriverMobileNoLayout.visibility = View.GONE
                holder.mVehicleASsignSubmit.visibility = View.GONE
                holder.mVheicleAssignCancel.visibility = View.GONE
            }
        }


    }

}

