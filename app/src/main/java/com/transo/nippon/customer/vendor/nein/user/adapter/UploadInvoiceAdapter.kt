package com.transo.nippon.customer.vendor.nein.user.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.transo.nippon.customer.vendor.nein.user.R
import com.transo.nippon.customer.vendor.nein.user.model.BookingDetails
import java.lang.String
import java.util.*
import kotlin.collections.ArrayList

/*
class UploadInvoiceAdapter {
}*/


class UploadInvoiceAdapter(
    context: Context,
    item: Int,
    navController: NavController,
    mBookingList: ArrayList<BookingDetails>
    //addressModelList: List<AddressModel>,
    //listener: AddressListener
) :
    RecyclerView.Adapter<UploadInvoiceAdapter.MyViewHolder?>() {
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

        init {
            bookingId = view.findViewById<MaterialTextView>(R.id.booking_number)
            origin = view.findViewById<MaterialTextView>(R.id.origin_city)
            destination = view.findViewById<MaterialTextView>(R.id.destination_city)

            hiddenLayout = view.findViewById(R.id.hidden_layout_invoice)
            arrowButton = view.findViewById(R.id.arrow_button)
            view.setOnClickListener { view1: View? ->
var mPos:Int = adapterPosition
/*
                if(mBookingList.get(mPos).isExpanded){

                }else{

                }*/


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
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.upload_invoice_ewaybill_viewholder, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mBookingList.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.bookingId.setText(mBookingList.get(position).bookingId)
        holder.origin.setText(mBookingList.get(position).origin)
        holder.destination.setText(mBookingList.get(position).destination)
        /*
         val addressModel: AddressModel = addressModelListFiltered[position]
         holder.name.setText((addressModel.getAddress_name() + "(" + addressModel.getContactCode()).toString() + ")")
         if (item == 9 || item == 10) {
 //            holder.capacity.setText(addressModel.getAddress());
 //            if (addressModel.getCity() == null || addressModel.getCity().equals("null")) {
 //                holder.capacity.setText(String.format("%s, %s, %s", addressModel.getAddress(), addressModel.getCity(), addressModel.getState()));
 //            } else if (addressModel.getState() != null) {
 //                holder.capacity.setText(String.format("%s, %s, %s", addressModel.getAddress(), addressModel.getCity(), addressModel.getState()));
 //            } else {
 //                holder.capacity.setText(String.format("%s, %s, %s", addressModel.getAddress(), addressModel.getCity(), addressModel.getState()));
 //            }
             holder.capacity.text = String.format(
                 "%s, %s, %s",
                 addressModel.getAddress(),
                 addressModel.getCity(),
                 addressModel.getState()
             )
             holder.capacity.visibility = View.VISIBLE*/
    }

}


/*
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                addressModelListFiltered = if (charString.isEmpty()) {
                    addressModelList
                } else {
                    val filteredList: MutableList<AddressModel> = ArrayList<AddressModel>()
                    for (row in addressModelList) {
                        // name match condition. this might differ depending on your requirement
                        if (row.getAddress() != null && row.getAddress().toLowerCase().contains(
                                charString.lowercase(
                                    Locale.getDefault()
                                )
                            ) || row.getAddress_name() != null && row.getAddress_name()
                                .toLowerCase().contains(
                                    charString.lowercase(
                                        Locale.getDefault()
                                    )
                                ) || row.getContactCode() != null && row.getContactCode().toLowerCase()
                                .contains(
                                    charString.lowercase(
                                        Locale.getDefault()
                                    )
                                )
                        ) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = addressModelListFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                addressModelListFiltered = filterResults.values as ArrayList<AddressModel>
                notifyDataSetChanged()
            }
        }
    }*/