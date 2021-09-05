package com.example.answersdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_dashboard, R.id.nav_maths, R.id.nav_biology, R.id.nav_chemistry), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Intents to screens
        val accountScreen: Button = findViewById(R.id.btnRegister)
        accountScreen.setOnClickListener {
            val accountIntent = Intent(this, AccountActivity::class.java)
            startActivity(accountIntent)
        }

        val askScreen: Button = findViewById(R.id.btnAsk)
        askScreen.setOnClickListener {
            val askIntent = Intent(this, AskActivity::class.java)
            startActivity(askIntent)
        }

        val browseScreen: Button = findViewById(R.id.btnBrowse)
        browseScreen.setOnClickListener {
            val browseIntent = Intent(this, BrowseActivity::class.java)
            startActivity(browseIntent)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}