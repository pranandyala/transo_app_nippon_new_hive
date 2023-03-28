package com.transo.nippon.customer.vendor.nein.user

import BaseFragment
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.transo.nippon.customer.vendor.nein.user.constants.Constant
import com.transo.nippon.customer.vendor.nein.user.databinding.FragmentBookingBinding
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//private  isConsignor:boolean = false;

/**
 * A simple [Fragment] subclass.
 * Use the [BookingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookingFragment : BaseFragment() {
    private var isConsignor: Boolean = false
    private var isConsignee: Boolean = false
    private var isBooking: Boolean = false
    private var minDate: Long = 0
    private var maxDate: kotlin.Long = 0
    private var currentDate: kotlin.Long = 0
    private var fromDate = ""
    private var toDate = ""

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var l = 0
    var b = 0
    var h = 0
    private var _binding: FragmentBookingBinding? = null
    private val mFormatter = SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.ENGLISH)
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        //   activity.supportActionBar!!.setHomeButtonEnabled(false)
        //  activity.supportActionBar!!.title=""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_booking, container, false)
        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        //thisgetWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        //  this.requireActivity().actionBar!!.setHomeButtonEnabled(false)
        // this.requireActivity().actionBar!!.title=""
        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize();
    }

    private fun initialize() {
        //initVolleyCallback();
        //mVolleyService = new VolleyService(mResultCallback, getActivity());
        // PrefUtils prefUtils = new PrefUtils(getActivity());

        _binding!!.fixedLayout.setOnClickListener {
            if (!isConsignor) {
                _binding!!.hiddenView.visibility = View.VISIBLE
                isConsignor = true
                _binding!!.arrowButton.setImageResource(R.drawable.remove_booking)

                _binding!!.hiddenViewConsignee.visibility = View.GONE
                isConsignee = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonConsignee.setImageResource(R.drawable.ic_add)

                _binding!!.hiddenViewAddBooking.visibility = View.GONE
                isBooking = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonBooking.setImageResource(R.drawable.ic_add)

            } else {
                _binding!!.hiddenView.visibility = View.GONE
                isConsignor = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButton.setImageResource(R.drawable.ic_add)


            }

        }
        _binding!!.arrowButton.setOnClickListener {
            if (!isConsignor) {
                _binding!!.hiddenView.visibility = View.VISIBLE
                isConsignor = true
                _binding!!.arrowButton.setImageResource(R.drawable.remove_booking)

                _binding!!.hiddenViewConsignee.visibility = View.GONE
                isConsignee = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonConsignee.setImageResource(R.drawable.ic_add)

                _binding!!.hiddenViewAddBooking.visibility = View.GONE
                isBooking = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonBooking.setImageResource(R.drawable.ic_add)

            } else {
                _binding!!.hiddenView.visibility = View.GONE
                isConsignor = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButton.setImageResource(R.drawable.ic_add)
            }

        }


        _binding!!.fixedLayoutConsignee.setOnClickListener {
            if (!isConsignee) {
                _binding!!.hiddenViewConsignee.visibility = View.VISIBLE
                isConsignee = true
                _binding!!.arrowButtonConsignee.setImageResource(R.drawable.remove_booking)


                _binding!!.hiddenView.visibility = View.GONE
                isConsignor = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButton.setImageResource(R.drawable.ic_add)

                _binding!!.hiddenViewAddBooking.visibility = View.GONE
                isBooking = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonBooking.setImageResource(R.drawable.ic_add)
            } else {
                _binding!!.hiddenViewConsignee.visibility = View.GONE
                isConsignee = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonConsignee.setImageResource(R.drawable.ic_add)
            }

        }


        _binding!!.arrowButtonConsignee.setOnClickListener {
            if (!isConsignee) {
                _binding!!.hiddenViewConsignee.visibility = View.VISIBLE
                isConsignee = true
                _binding!!.arrowButtonConsignee.setImageResource(R.drawable.remove_booking)
                _binding!!.hiddenView.visibility = View.GONE
                isConsignor = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButton.setImageResource(R.drawable.ic_add)

                _binding!!.hiddenViewAddBooking.visibility = View.GONE
                isBooking = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonBooking.setImageResource(R.drawable.ic_add)
            } else {
                _binding!!.hiddenViewConsignee.visibility = View.GONE
                isBooking = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonConsignee.setImageResource(R.drawable.ic_add)
            }

        }



        _binding!!.fixedLayoutAddBooking.setOnClickListener {
            if (!isBooking) {
                _binding!!.hiddenViewAddBooking.visibility = View.VISIBLE
                isBooking = true
                _binding!!.arrowButtonBooking.setImageResource(R.drawable.remove_booking)

                _binding!!.hiddenView.visibility = View.GONE
                isConsignee = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButton.setImageResource(R.drawable.ic_add)

                _binding!!.hiddenViewConsignee.visibility = View.GONE
                isConsignor = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonConsignee.setImageResource(R.drawable.ic_add)
            } else {
                _binding!!.hiddenViewAddBooking.visibility = View.GONE
                isBooking = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)


                _binding!!.arrowButtonBooking.setImageResource(R.drawable.ic_add)
            }

        }


        _binding!!.arrowButtonBooking.setOnClickListener {
            if (!isBooking) {
                _binding!!.hiddenViewAddBooking.visibility = View.VISIBLE
                isBooking = true
                _binding!!.arrowButtonBooking.setImageResource(R.drawable.remove_booking)

                _binding!!.hiddenView.visibility = View.GONE
                isConsignee = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButton.setImageResource(R.drawable.ic_add)

                _binding!!.hiddenViewConsignee.visibility = View.GONE
                isConsignor = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonBooking.setImageResource(R.drawable.remove_booking)
            } else {
                _binding!!.hiddenViewAddBooking.visibility = View.GONE
                isBooking = false
                //  _binding!!.arrowButton.background= ContextCompat.getDrawable(requireContext(), R.drawable.ic_add)
                _binding!!.arrowButtonBooking.setImageResource(R.drawable.ic_add)
            }

        }




        initWeight();
        initPicker()
    }

    override fun onResume() {
        super.onResume()

        setTitle("Booking Creation", false)
    }

    private fun initPicker() {

        _binding!!.pickUpDate.setOnClickListener { view ->
            showDateTimePicker(
                1,
                _binding!!.pickUpDate
            )
        }
    }

    fun showDateTimePicker(item: Int, dateEtxt: TextInputEditText) {
        if (activity != null) {
            val c = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    TimePickerDialog(
                        activity,
                        { view1: TimePicker?, hourOfDay: Int, minute: Int ->
                            c[Calendar.HOUR_OF_DAY] = hourOfDay
                            c[Calendar.MINUTE] = minute
                            c[Calendar.YEAR] = year
                            c[Calendar.MONTH] = monthOfYear
                            c[Calendar.DAY_OF_MONTH] = dayOfMonth
                            dateEtxt.setText(mFormatter.format(c.time))
                            if (item == 1) {
                                fromDate = mFormatter.format(c.time)
                                toDate = ""
                                //_binding.toDate.getText().clear()
                                minDate = c.timeInMillis
                            } else if (item == 2) {
                                minDate = 0
                                toDate = mFormatter.format(c.time)
                            }
                        },
                        c[Calendar.HOUR_OF_DAY],
                        c[Calendar.MINUTE],
                        false
                    ).show()
                }, c[Calendar.YEAR], c[Calendar.MONTH], c[Calendar.DAY_OF_MONTH]
            )
            if (item == 1) {
//                datePickerDialog.getDatePicker().setMinDate(minDate);
                datePickerDialog.datePicker.maxDate = c.timeInMillis
            } else if (item == 2) {
                datePickerDialog.datePicker.minDate = minDate
                datePickerDialog.datePicker.maxDate = c.timeInMillis
            }
            datePickerDialog.show()
        }
    }

    private fun initWeight() {
        var adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.weight_type, android.R.layout.simple_spinner_dropdown_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                binding.spinner.setError(null);
                if (position == 0) {
                    binding.weight.setText("");
                    binding.weight.setFocusable(true);
                    binding.weight.setClickable(true);
                    binding.weight.setFocusableInTouchMode(true);
                    binding.volumeLayout.setVisibility(View.GONE);
                } else if (position == 1) {
                    binding.weight.setText("");
                    binding.length.setText("");
                    binding.breadth.setText("");
                    binding.height.setText("");
                    binding.weight.setFocusable(false);
                    binding.weight.setClickable(true);
                    binding.volumeLayout.setVisibility(View.VISIBLE);
                } else {
                    binding.weight.setEnabled(false);
                }
            }

        }


        /*
        new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

        }
    }*/



        binding.weight.setFilters(arrayOf<InputFilter>(Constant.DecimalDigitsInputFilter(5, 3)));

        binding.length.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                volumetricWeightCalculation();
            }
        })

        binding.breadth.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                volumetricWeightCalculation();
            }
        })


        binding.height.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                volumetricWeightCalculation();
            }
        })

        /*
         binding.length.addTextChangedListener(object :TextWatcher{


             public void beforeTextChanged(CharSequence s, int start, int count,
                 int after) {

             }

             public void onTextChanged(CharSequence s, int start, int before,
                 int count) {
                 volumetricWeightCalculation();
             }

             public void afterTextChanged(Editable s) {

             }
         });*/
    }

    private fun volumetricWeightCalculation() {
        if ("" != binding.length.getText().toString() && "" != binding.breadth.getText()
                .toString() && "" != binding.height.getText().toString()
        ) {
            try {
                l = binding.length.getText().toString().toInt()
                b = binding.breadth.getText().toString().toInt()
                h = binding.height.getText().toString().toInt()
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
            //            float Volume = ((l * b * h) / 5000) / 1000;
            val Volume: Float = (l * b * h / 5000).toFloat()
            System.out.printf("volume :%s%n", String.format("%.2f", Volume).toDouble())
            val weights = Volume.toInt()
            binding.weight.setText(weights.toString())
        }
    }
}