package com.davidmendozamartinez.technicaltest.cakes.ui.screen.cakes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.davidmendozamartinez.technicaltest.cakes.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CakesActivity : AppCompatActivity() {
    private lateinit var viewModel: CakesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cakes)

        viewModel = ViewModelProvider(this)[CakesViewModel::class.java]
    }
}
