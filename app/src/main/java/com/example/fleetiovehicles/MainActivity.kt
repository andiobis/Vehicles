package com.example.fleetiovehicles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fleetiovehicles.databinding.ActivityMainBinding
import com.example.fleetiovehicles.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}