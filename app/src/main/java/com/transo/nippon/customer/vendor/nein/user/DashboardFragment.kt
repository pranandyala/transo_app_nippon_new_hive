package com.transo.nippon.customer.vendor.nein.user

import BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.transo.nippon.customer.vendor.nein.user.databinding.FragmentDashboardBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DashboardFragment : BaseFragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createBooking.setOnClickListener {
            findNavController().navigate(R.id.action_Dashboard_to_booking_Fragment)
        }
        binding.invoiceEwayBill.setOnClickListener {
            findNavController().navigate(R.id.action_Dashboard_to_invoice_eway_Fragment)
        }

        binding.podUpload.setOnClickListener {
            findNavController().navigate(R.id.action_Dashboard_to_DownloadPOD_Fragment)
        }

        binding.tracking.setOnClickListener {
            findNavController().navigate(R.id.action_Dashboard_to_LRTrackign_Fragment)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        setTitle("", false)
    }
}