package com.transo.nippon.customer.vendor.nein.user.vendor_fragment

import BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.transo.nippon.customer.vendor.nein.user.R
import com.transo.nippon.customer.vendor.nein.user.databinding.FragmentVendorDashboardBinding

/**
 * A simple [Fragment] subclass.
 * Use the [VendorDashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VendorDashboardFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentVendorDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentVendorDashboardBinding.inflate(inflater, container, false)

        return binding.root
        //return inflater.inflate(R.layout.fragment_vendor_dashboard, container, false)
    }

    override fun onResume() {
        super.onResume()
        setTitle("", false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vendorVehicleAssign.setOnClickListener {

            findNavController().navigate(R.id.action_Vendor_Dashboard_to_Vehicle_Assign_Fragment)
        }
        binding.vendorStatusUpdate.setOnClickListener {

            findNavController().navigate(R.id.action_Vendor_Dashboard_to_Status_Update_Fragment)

        }
        binding.vendorPodUpload.setOnClickListener {

            findNavController().navigate(R.id.action_Vendor_Dashboard_to_POD_Upload_Fragment)

        }


        binding.vendorPodDownload.setOnClickListener {


            findNavController().navigate(R.id.action_Vendor_Dashboard_to_DownloadPOD_Fragment)
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VendorDashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VendorDashboardFragment().apply {

            }
    }
}