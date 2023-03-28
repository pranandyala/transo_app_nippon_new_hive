package com.transo.nippon.customer.vendor.nein.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.transo.nippon.customer.vendor.nein.user.databinding.FragmentSigninBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SignInFragment : Fragment() {

    private var _binding: FragmentSigninBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSigninBinding.inflate(inflater, container, false)
//        requireActivity().actionBar!!.hide()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signin.setOnClickListener {
            // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            findNavController().navigate(R.id.action_signInFragment_to_VendorDashboardFragment)
        }

        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_SignInFragment_to_SignUpFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}