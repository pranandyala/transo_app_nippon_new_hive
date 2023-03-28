import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.transo.nippon.customer.vendor.nein.user.dialog.AlertPopup
import java.io.IOException
import java.util.*

open class BaseFragment : Fragment(), AlertPopup.OnAlertInteractionListener {
    //  var mVolleyService: VolleyService? = null

    /**
     * The  result callback.
     */
    //   var mResultCallback: IResult? = null
    // var prefUtils: PrefUtils? = null
    // private var dialog: SweetAlertDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)
        //  prefUtils = PrefUtils(activity)
        return container
    }


    fun setTitle(title: String, homeButton: Boolean) {

        if (activity != null) {
            (activity as AppCompatActivity?)!!.supportActionBar!!.setTitle("     " + title)
            (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(
                homeButton
            )
            //  (activity as AppCompatActivity)!!.supportActionBar!!.
        }
    }

    /*

       Check for the Gps location permission.
            */
    fun checkLocationPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    requireActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    MY_PERMISSIONS_REQUEST_LOCATION
                )
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    MY_PERMISSIONS_REQUEST_LOCATION
                )
            }
            false
        } else {
            true
        }
    }
/*
    protected fun setTitleDashboard(title: String?) {

        if (title != null && activity is BaseActivity) {
            (activity as BaseActivity?).setTitleDashboard(title)
        }
    }

    protected fun setTitle(title: String?) {
        if (title != null && activity is MainActivity) {
            (activity as MainActivity?).setTitle(title)
        }
    }

    protected val app: App?
        protected get() = if (activity != null) {
            activity!!.application as App
        } else null

    fun alert(context: Context?, title: String?, body: String?) {
        if (activity as BaseActivity? != null) (activity as BaseActivity?).alert(
            context,
            title,
            body
        )
    }

    fun alert(context: Context?, icon: Int, title: String?, body: String?) {
        if (activity as BaseActivity? != null) (activity as BaseActivity?).alert(
            context,
            title,
            body
        )
    }

    fun alert(context: Context?, tag: Int, title: String?, body: String?, extra: Bundle?) {
        if (activity as BaseActivity? != null) (activity as BaseActivity?).alert(
            context,
            tag,
            title,
            body,
            extra
        )
    }

    fun alert(
        context: Context?,
        tag: Int,
        title: String?,
        icon: Int,
        body: String?,
        buttons: Array<String?>?,
        extra: Bundle?
    ) {
        if (activity as BaseActivity? != null) (activity as BaseActivity?).alert(
            context,
            tag,
            title,
            icon,
            body,
            buttons,
            extra
        )
    }

    fun onAlertInteraction(tag: Int, isPositive: Boolean, extra: Bundle?) {
        println("Test 1")
        if (activity != null) activity!!.onBackPressed()
    }

    fun alert(msg: String?) {
        if (dialog != null) {
            dialog.cancel()
        }
        dialog = SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
            .setTitleText(msg)
            .setContentText("")
            .setConfirmText(resources.getString(R.string.action_ok))
            .setConfirmClickListener(object : OnSweetClickListener() {
                fun onClick(sweetAlertDialog: SweetAlertDialog) {
                    sweetAlertDialog.cancel()
                }
            })
        dialog.show()
    }*/

    companion object {
        const val MY_PERMISSIONS_REQUEST_LOCATION = 99
        fun isNetworkAvailable(context: Context): Boolean {
            var connectedNetwork = false
            try {
                val cm =
                    (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                val networks = cm.activeNetworkInfo
                if (networks != null && networks.state == NetworkInfo.State.CONNECTED) {
                    connectedNetwork = true
                }
            } catch (e: Exception) {
                e.printStackTrace()
                connectedNetwork = false
            }
            return connectedNetwork
        }

        fun hideSoftKeyboardInput(context: Context, view: View) {
            val imm = (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun getAddress(context: Context?, latitude: Double, longitude: Double): String? {
            var address: String? = null
            var locationAddress: Address? = null
            val geocoder: Geocoder
            val addresses: List<Address>?
            geocoder = Geocoder(context!!, Locale.getDefault())
            try {
                addresses = geocoder.getFromLocation(
                    latitude,
                    longitude,
                    1
                ) // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                locationAddress = addresses!![0]
            } catch (e: IOException) {
                e.printStackTrace()
            }
            if (locationAddress != null) {
                address = locationAddress.getAddressLine(0)
                val address1 = locationAddress.getAddressLine(1)
                val city = locationAddress.locality
                val state = locationAddress.adminArea
                val country = locationAddress.countryName
                val postalCode = locationAddress.postalCode
                var currentLocation: String?
                if (!TextUtils.isEmpty(address)) {
                    currentLocation = address
                    if (!TextUtils.isEmpty(address1)) currentLocation += """
     
     $address1
     """.trimIndent()
                    if (!TextUtils.isEmpty(city)) {
                        currentLocation += """
                            
                            $city
                            """.trimIndent()
                        if (!TextUtils.isEmpty(postalCode)) currentLocation += " - $postalCode"
                    } else {
                        if (!TextUtils.isEmpty(postalCode)) currentLocation += """
     
     $postalCode
     """.trimIndent()
                    }
                    if (!TextUtils.isEmpty(state)) currentLocation += """
     
     $state
     """.trimIndent()
                    if (!TextUtils.isEmpty(country)) currentLocation += """
     
     $country
     """.trimIndent()
                }
            }
            return address
        }
    }

    override fun onAlertInteraction(tag: Int, isPositive: Boolean, extra: Bundle?) {
        //TODO("Not yet implemented")
    }
}