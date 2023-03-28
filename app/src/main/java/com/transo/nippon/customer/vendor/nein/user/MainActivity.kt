package com.transo.nippon.customer.vendor.nein.user

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.transo.nippon.customer.vendor.nein.user.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    var notificationItemCount: TextView? = null
    var notificationCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setHomeButtonEnabled(false)
        supportActionBar!!.title = ""
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.SignInFragment) {
                binding.toolbar.visibility = View.GONE
                //  bottomNavigationView.setVisibility(View.GONE);
            } else if (destination.id == R.id.SignUpFragment) {
                binding.toolbar.visibility = View.GONE
            } else if (destination.id == R.id.BookingFragment) {

                binding.mLogoToolbar.visibility = View.GONE
            } else if (destination.id == R.id.DashboardFragment) {
                binding.mLogoToolbar.visibility = View.VISIBLE
                binding.toolbar.visibility = View.VISIBLE

                // bottomNavigationView.setVisibility(View.VISIBLE);
            }
            else if (destination.id == R.id.InvoiceEwayBillFragment) {
                binding.mLogoToolbar.visibility = View.GONE
                binding.toolbar.visibility = View.VISIBLE

                // bottomNavigationView.setVisibility(View.VISIBLE);
            }
            else if(destination.id == R.id.LRTrackingFragment){
                binding.mLogoToolbar.visibility = View.GONE
                binding.toolbar.visibility = View.VISIBLE
            }
            else if(destination.id == R.id.PODDownloadFragment){
                binding.mLogoToolbar.visibility = View.GONE
                binding.toolbar.visibility = View.VISIBLE
            }
            else if(destination.id == R.id.VendorVehicleAssignFragment){
                binding.mLogoToolbar.visibility = View.GONE
                binding.toolbar.visibility = View.VISIBLE
            }
            else if(destination.id == R.id.VendorStatusUpdateFragment){
                binding.mLogoToolbar.visibility = View.GONE
                binding.toolbar.visibility = View.VISIBLE

            }

            else {
                binding.toolbar.visibility = View.VISIBLE
                binding.mLogoToolbar.visibility = View.VISIBLE
            }
        }
/*
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // menuInflater.inflate(R.menu.menu_main, menu

        getMenuInflater().inflate(R.menu.menu_main, menu)
        val menuItem: android.view.MenuItem? = menu.findItem(R.id.notification)
        val actionView = MenuItemCompat.getActionView(menuItem)
        notificationItemCount = actionView.findViewById<TextView>(R.id.cart_badge)
        actionView.setOnClickListener { v: View? ->
            onOptionsItemSelected(
                menuItem!!
            )
        }
        return true
    }

    private fun setupBadge() {
        if (notificationItemCount != null) {
            if (notificationCount == 0) {
                if (notificationItemCount!!.getVisibility() != View.GONE) {
                    notificationItemCount!!.setVisibility(View.GONE)
                }
            } else {
                //  println("notificationCount-->$notificationCount")
                notificationItemCount!!.setText(notificationCount.toString())
                if (notificationItemCount!!.getVisibility() != View.VISIBLE) {
                    notificationItemCount!!.setVisibility(View.VISIBLE)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            //  R.id.action_settings -> true
            R.id.notification -> {
                val navController = findNavController(R.id.nav_host_fragment_content_main)
                navController.navigate(R.id.NotificationFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        /*
            val navController = findNavController(R.id.nav_host_fragment_content_main)
            return navController.navigateUp(appBarConfiguration)
                    || super.onSupportNavigateUp()*/

        return true;
    }
}