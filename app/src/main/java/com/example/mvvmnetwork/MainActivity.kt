package com.example.mvvmnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmnetwork.adapter.MainAdapter
import com.example.mvvmnetwork.viewmodel.Mainviewmodel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewmodel:Mainviewmodel
    lateinit var mainAdapter: MainAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)





        setupAdapter()
        setupObserver()

    }

    private fun setupObserver() {
        mainViewmodel = ViewModelProvider(this).get(Mainviewmodel::class.java)
    }

    

    private fun setupAdapter() {

        recyclerView.layoutManager = LinearLayoutManager(this)
        mainAdapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
            recyclerView.context,
            (recyclerView.layoutManager as LinearLayoutManager).orientation
        )
        )
        recyclerView.adapter = mainAdapter
    }




}