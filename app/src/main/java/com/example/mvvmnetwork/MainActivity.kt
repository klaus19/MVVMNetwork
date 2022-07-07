package com.example.mvvmnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmnetwork.adapter.MainAdapter
import com.example.mvvmnetwork.viewmodel.Mainviewmodel

class MainActivity : AppCompatActivity() {

    private val viewmodel:Mainviewmodel by viewModels()
    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)



        fetchDetails()

        setupAdapter()

    }

    private fun setupAdapter() {

    }

    private fun fetchDetails() {

    }


}