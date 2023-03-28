package com.transo.nippon.customer.vendor.nein.user.adapter


import android.content.Context
import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import com.transo.nippon.customer.vendor.nein.user.R
import com.transo.nippon.customer.vendor.nein.user.model.StatusUpdate
import com.transo.nippon.customer.vendor.nein.user.widget.AutoCompleteDropDown
import java.util.*
import kotlin.collections.ArrayList

/*
class UploadInvoiceAdapter {
}*/


class VehicleStatusUpdateAdapter(
    context: Context,
    item: Int,
    navController: NavController,
    mBookingList: ArrayList<StatusUpdate>
    //addressModelList: List<AddressModel>,
    //listener: AddressListener
) :
    RecyclerView.Adapter<VehicleStatusUpdateAdapter.MyViewHolder?>() {
    private val context: Context

    //  private val addressModelList: List<AddressModel>
    // private var addressModelListFiltered: List<AddressModel>
    // private val listener: AddressListener
    private val item = 0
    lateinit var navController: NavController
    lateinit var mBookingList: ArrayList<StatusUpdate>
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
        lateinit var statusUpdateLRNo: MaterialTextView
        lateinit var origin: MaterialTextView
        lateinit var destination: MaterialTextView
        lateinit var status: MaterialTextView
        lateinit var arrowButton: ImageButton;
        lateinit var cardView: MaterialCardView


        //     lateinit var mGpsTrackingHeader: AppCompatTextView
        lateinit var currentLocationLayout: TextInputLayout
        lateinit var spinner: AutoCompleteDropDown

        lateinit var chooseStatusLayout: TextInputLayout

        lateinit var mVehicleStatusSubmit: MaterialButton
        lateinit var mVheicleStatusCancel: MaterialButton

        lateinit var mTimeStamp: MaterialTextView


        init {
            statusUpdateLRNo = view.findViewById(R.id.status_update_lr_no)
            origin = view.findViewById<MaterialTextView>(R.id.origin)
            destination = view.findViewById<MaterialTextView>(R.id.destination)
            status = view.findViewById(R.id.status)
            arrowButton = view.findViewById(R.id.arrow_button_vehicle_status)
            currentLocationLayout = view.findViewById(R.id.current_location_layout)
            spinner = view.findViewById(R.id.spinner)

            // chooseStatusLayout = view.findViewById(R.id.choose_status_layout)

            mVehicleStatusSubmit = view.findViewById(R.id.submitBtn)
            mVheicleStatusCancel = view.findViewById(R.id.resetBtn)


            cardView = view.findViewById(R.id.material_card_status_update_layout)

            mTimeStamp = view.findViewById(R.id.mTimeStamp)


            initSpinner()

            /*
                view.setOnClickListener {

        mVehicleStatusSubmit.visibility = View.VISIBLE

    }*/


        }

        private fun initSpinner() {
            var adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
                context,
                R.array.where_is_delivery, android.R.layout.simple_spinner_dropdown_item
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    spinner.setError(null);

                    val s = SimpleDateFormat("dd/MM/yyyy hh:mm")
                    val format: String = s.format(Date())
                    mTimeStamp.setText(format)
                    mTimeStamp.visibility = View.VISIBLE
                }

            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.vehicle_status_update_view_holder, parent, false)
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


        holder.statusUpdateLRNo.setText(mBookingList.get(position).lrNo)
        holder.origin.setText(mBookingList.get(position).origin)
        holder.destination.setText(mBookingList.get(position).destination)
        holder.status.setText(mBookingList.get(position).status)
        val isExpandable: Boolean = bookingDetails.isExpanded

        if (isExpandable) {
            holder.arrowButton.setImageResource(R.drawable.remove_booking)
            holder.currentLocationLayout.visibility = View.VISIBLE
            holder.spinner.visibility = View.VISIBLE
            //   holder.chooseStatusLayout.visibility = View.VISIBLE
            holder.mVehicleStatusSubmit.visibility = View.VISIBLE
            holder.mVheicleStatusCancel.visibility = View.VISIBLE

        } else {
            holder.arrowButton.setImageResource(R.drawable.ic_add)

            holder.currentLocationLayout.visibility = View.GONE
            holder.spinner.visibility = View.GONE
            // holder.chooseStatusLayout.visibility = View.GONE
            holder.mVehicleStatusSubmit.visibility = View.GONE
            holder.mVheicleStatusCancel.visibility = View.GONE
        }


        holder.cardView.setOnClickListener {
            isAnyItemExpanded(position)
            bookingDetails.isExpanded = !bookingDetails.isExpanded

            /*
            statusUpdateLRNo = view.findViewById(R.id.status_update_lr_no)
            origin = view.findViewById<MaterialTextView>(R.id.origin)
            destination = view.findViewById<MaterialTextView>(R.id.destination)
            status = view.findViewById(R.id.status)
            arrowButton = view.findViewById(R.id.arrow_button_vehicle_status)
            currentLocationLayout = view.findViewById(R.id.current_location_layout)
            spinner = view.findViewById(R.id.spinner)

            chooseStatusLayout = view.findViewById(R.id.choose_status_layout)

            mVehicleStatusSubmit = view.findViewById(R.id.submitBtn)
            mVheicleStatusCancel = view.findViewById(R.id.resetBtn)*/





            notifyItemChanged(position, Unit)
        }

    }

}

