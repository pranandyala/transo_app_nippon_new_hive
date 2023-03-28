package com.transo.nippon.customer.vendor.nein.user

import BaseFragment
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.appcompat.app.AlertDialog
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.transo.nippon.customer.vendor.nein.user.adapter.DownloadPODAdapter
import com.transo.nippon.customer.vendor.nein.user.databinding.FragmentPODBinding
import com.transo.nippon.customer.vendor.nein.user.model.LRDetails
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PODFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PODFragment : BaseFragment() {

    private var _binding: FragmentPODBinding? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_p_o_d, container, false)

        _binding = FragmentPODBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PODFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PODFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

        val recyclerView: RecyclerView = _binding!!.lrRv;
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

        var mBookingList: ArrayList<LRDetails> = ArrayList()
        mBookingList.add(LRDetails("9497384823759", "banglore", "chennai"))
        mBookingList.add(LRDetails("9497384823759", "banglore", "chennai"))
        mBookingList.add(LRDetails("9497384823759", "banglore", "chennai"))
        mBookingList.add(LRDetails("9497384823759", "banglore", "chennai"))

        recyclerView.adapter =
            DownloadPODAdapter(requireContext(), 10, findNavController(), mBookingList)
    }

    private fun initListeners() {
        _binding!!.dateRange.setOnClickListener {

            var materialDateBuilder: MaterialDatePicker.Builder<Pair<Long, Long>> =
                MaterialDatePicker.Builder.dateRangePicker()

            materialDateBuilder.setTitleText("SELECT A DATE")

            val materialDatePicker = materialDateBuilder.build()
            materialDatePicker.show(this.parentFragmentManager, "MATERIAL_DATE_PICKER")

            materialDatePicker.addOnPositiveButtonClickListener {

                _binding!!.dateRange.setText(materialDatePicker.headerText)
            }


        }

        _binding!!.chooseMonth.setOnClickListener {


/*
            MonthPickerDialog.Builder builder = new MonthPickerDialog.Builder(MainActivity.this,
                new MonthPickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(int selectedMonth, int selectedYear) { // on date set }
                    }, today.get(Calendar.YEAR), today.get(Calendar.MONTH));

                    builder.setActivatedMonth(Calendar.JULY)
                        .setMinYear(1990)
                        .setActivatedYear(2017)
                        .setMaxYear(2030)
                        .setMinMonth(Calendar.FEBRUARY)
                        .setTitle("Select trading month")
                        .setMonthRange(Calendar.FEBRUARY, Calendar.NOVEMBER)
                        // .setMaxMonth(Calendar.OCTOBER)
                        // .setYearRange(1890, 1890)
                        // .setMonthAndYearRange(Calendar.FEBRUARY, Calendar.OCTOBER, 1890, 1890)
                        //.showMonthOnly()
                        // .showYearOnly()
                        .setOnMonthChangedListener(new MonthPickerDialog.OnMonthChangedListener() {
                            @Override
                            public void onMonthChanged(int selectedMonth) { // on month selected } })
                                .setOnYearChangedListener(new MonthPickerDialog.OnYearChangedListener() {
                                    @Override
                                    public void onYearChanged(int selectedYear) { // on year selected } })
                                        .build()
                                            .show();*/

            //createDialogWithoutDateField()!!.show()

            /*

            RackMonthPicker(requireActivity())

                .setLocale(Locale.ENGLISH)
                .setColorTheme(getColorByThemeAttr(requireContext(), android.R.attr.colorPrimary, R.color.color_primary))
                .setPositiveButton(object : DateMonthDialogListener {
                    override fun onDateMonth(
                        month: Int,
                        startDate: Int,
                        endDate: Int,
                        year: Int,
                        monthLabel: String?
                    ) {
                    }
                })
                .setNegativeButton(object : OnCancelMonthDialogListener {
                    override fun onCancel(dialog: AlertDialog?) {}
                }).show()*/


        }
    }

    private fun getColorByThemeAttr(context: Context, attr: Int, defaultColor: Int): Int {
        val typedValue = TypedValue()
        val theme = context.theme
        val got = theme.resolveAttribute(attr, typedValue, true)
        return if (got) typedValue.data else defaultColor
    }

    private fun createDialogWithoutDateField(): DatePickerDialog? {
        val dpd = DatePickerDialog(requireContext(), null, 2014, 1, 24)
        try {
            val datePickerDialogFields = dpd.javaClass.declaredFields
            for (datePickerDialogField in datePickerDialogFields) {
                if (datePickerDialogField.name == "mDatePicker") {
                    datePickerDialogField.isAccessible = true
                    val datePicker: DatePicker = datePickerDialogField[dpd] as DatePicker
                    val datePickerFields = datePickerDialogField.type.declaredFields
                    for (datePickerField in datePickerFields) {
                        Log.i("test", datePickerField.name)
                        if ("mDaySpinner" == datePickerField.name) {
                            datePickerField.isAccessible = true
                            val dayPicker = datePickerField[datePicker]
                            (dayPicker as View).visibility = View.GONE
                        }
                    }
                }
            }
        } catch (ex: Exception) {
        }
        return dpd
    }

    override fun onResume() {
        super.onResume()
        setTitle("POD Download", false)
    }
}