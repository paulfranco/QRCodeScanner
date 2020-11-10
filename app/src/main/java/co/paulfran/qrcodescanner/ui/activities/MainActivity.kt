package co.paulfran.qrcodescanner.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import co.paulfran.qrcodescanner.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(this)

    }

    override fun onDestinationChanged(navCon: NavController, dest: NavDestination, args: Bundle?) {
        when (dest.id) {
            R.id.navigation_details -> hideNavIfNecessary()
            else -> showNavIfNecessary()
        }
    }

    private fun showNavIfNecessary() = takeIf { bottomNavView.visibility == View.GONE }
            ?.apply { bottomNavView.visibility = View.VISIBLE }

    private fun hideNavIfNecessary() = takeIf { bottomNavView.visibility == View.VISIBLE }
            ?.apply { bottomNavView.visibility = View.GONE }
}