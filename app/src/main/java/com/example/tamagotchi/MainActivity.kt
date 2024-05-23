package com.example.tamagotchi

import android.os.Bundle
import android.view.MenuInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val menu = MenuInflater(this).inflate(R.menu.bottom_nav_menu, navView.menu)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        var model = ViewModelProvider(this).get(Duckmodel::class.java)

        val hungerValue =findViewById<TextView>(R.id.hungerValue)

        model.hunger.observe(this, Observer { hunger ->
            hungerValue.text = "$hunger%"
        })

        val happinessValue =findViewById<TextView>(R.id.happinessValue)

        model.happiness.observe(this, Observer { happiness ->
            happinessValue.text = "$happiness%"
        })

        val hygieneValue =findViewById<TextView>(R.id.hygieneValue)

        model.hygiene.observe(this, Observer { hygiene ->
            hygieneValue.text = "$hygiene%"
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}
