package com.transo.nippon.customer.vendor.nein.user

import BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.transo.nippon.customer.vendor.nein.user.adapter.UploadInvoiceAdapter
import com.transo.nippon.customer.vendor.nein.user.databinding.FragmentUploadInvoiceEwayBillBinding
import com.transo.nippon.customer.vendor.nein.user.model.BookingDetails
import com.transo.nippon.customer.vendor.nein.user.utils.MyDividerItemDecoration

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UploadInvoiceEwayBillFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UploadInvoiceEwayBillFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentUploadInvoiceEwayBillBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUploadInvoiceEwayBillBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //   return inflater.inflate(R.layout.fragment_upload_invoice_eway_bill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = _binding!!.rvInvoice;
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        /*
         recyclerView.addItemDecoration(
             MyDividerItemDecoration(
                 activity,
                 DividerItemDecoration.VERTICAL,
                 0
             )
         )*/

        var mBookingList: ArrayList<BookingDetails> = ArrayList()
        mBookingList.add(BookingDetails("9497384823759", "banglore", "chennai"))
        mBookingList.add(BookingDetails("9497384823759", "banglore", "chennai"))
        mBookingList.add(BookingDetails("9497384823759", "banglore", "chennai"))
        mBookingList.add(BookingDetails("9497384823759", "banglore", "chennai"))

        recyclerView.adapter =
            UploadInvoiceAdapter(requireContext(), 10, findNavController(), mBookingList)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UploadInvoiceEwayBillFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UploadInvoiceEwayBillFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onResume() {
        super.onResume()
        setTitle("Upload Invoice & Eway Bill", false)
    }
}