package com.transo.nippon.customer.vendor.nein.user.vendor_fragment

import BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.transo.nippon.customer.vendor.nein.user.R
import com.transo.nippon.customer.vendor.nein.user.adapter.VehicleAssignAdapter
import com.transo.nippon.customer.vendor.nein.user.adapter.VehicleStatusUpdateAdapter
import com.transo.nippon.customer.vendor.nein.user.databinding.FragmentVendorStatusUpdateBinding
import com.transo.nippon.customer.vendor.nein.user.model.BookingDetails
import com.transo.nippon.customer.vendor.nein.user.model.StatusUpdate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VendorStatusUpdateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VendorStatusUpdateFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentVendorStatusUpdateBinding? = null
    private val binding get() = _binding!!
    override fun onResume() {
        super.onResume()
        setTitle("Status Update", false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = _binding!!.rvStatusUpdate
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        var mBookingList: ArrayList<StatusUpdate> = ArrayList()
        mBookingList.add(StatusUpdate("9497384823759", "banglore", "chennai", "delivered", false))
        mBookingList.add(StatusUpdate("9497384823759", "banglore", "chennai", "delivered", false))
        mBookingList.add(StatusUpdate("9497384823759", "banglore", "chennai", "delivered", false))
        mBookingList.add(StatusUpdate("9497384823759", "banglore", "chennai", "delivered", false))

        recyclerView.adapter =
            VehicleStatusUpdateAdapter(requireContext(), 10, findNavController(), mBookingList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = com.transo.nippon.customer.vendor.nein.user.databinding.FragmentVendorStatusUpdateBinding.inflate(inflater, container, false)

        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VendorStatusUpdateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VendorStatusUpdateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}