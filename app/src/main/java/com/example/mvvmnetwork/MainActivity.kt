package com.example.mvvmnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmnetwork.adapter.MainAdapter
import com.example.mvvmnetwork.viewmodel.Mainviewmodel

class MainActivity : AppCompatActivity() {

   private val mainViewmodel:Mainviewmodel by viewModels()
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

        mainViewmodel.response.observe(this){ results ->
            results.data?.let { users->
                progressBar.isVisible = users.isEmpty()
                recyclerView.isVisible = users.isNotEmpty()
                mainAdapter.addData(users)

            }

        }
        mainViewmodel.getUsers()
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