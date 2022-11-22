package com.example.karakianov

import android.content.DialogInterface
import android.content.res.Configuration
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.karakianov.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding //对应main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.mainPage.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_container)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_homeFragment, R.id.nav_about_Us, R.id.nav_Intro, R.id.nav_maoriculture),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

       navView.itemTextColor = null;
        navView.setItemTextAppearance(R.style.MenuTextStyle);

        val records = getSharedPreferences("records", MODE_PRIVATE)
        val firstInstall = records.getBoolean("firstInstall", true)
        if (firstInstall) {
            showStartDialog()
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    fun directionLeft(){
        val drawerLayout: DrawerLayout = binding.drawerLayout
        drawerLayout.layoutDirection = View.LAYOUT_DIRECTION_LTR
    }

    fun directionRight(){
        val drawerLayout: DrawerLayout = binding.drawerLayout
        drawerLayout.layoutDirection = View.LAYOUT_DIRECTION_RTL
    }


    private fun showStartDialog() {
        AlertDialog.Builder(this)
            .setTitle("Thanks for downloading Karakia APP")
            .setMessage(" The Karakia App is a Prototype version and Students. It is intended that staff and students shall use this to get an understanding of giving Karakia and information related to karakia. Karakia for Wintec-Te Pukenga may change accordingly making older versions redundant. Wintec–Te Pukenga takes no responsibility of outdated information displayed on the app.")
            .setNegativeButton("Cancel", DialogInterface.OnClickListener{
                    p0,p1 -> p0.dismiss()
                    System.exit(-1)

            })
            .setPositiveButton(
                "ok"
            ) { dialog, which -> dialog.dismiss()
                val records = getSharedPreferences("records", MODE_PRIVATE)
                val editor = records.edit()
                editor.putBoolean("firstInstall", false)
                editor.apply()}
            .create().show()


    }

}

