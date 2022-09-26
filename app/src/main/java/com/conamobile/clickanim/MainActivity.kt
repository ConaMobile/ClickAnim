package com.conamobile.clickanim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.conamobile.clickanim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myButton
    }
}