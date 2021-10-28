package com.davidmendozamartinez.technicaltest.cakes.ui.screen.cakes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.davidmendozamartinez.technicaltest.cakes.databinding.ActivityCakesBinding
import com.davidmendozamartinez.technicaltest.cakes.ui.adapter.CakeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class CakesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCakesBinding
    private lateinit var viewModel: CakesViewModel
    private lateinit var adapter: CakeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCakesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CakesViewModel::class.java]

        setupList()
        setupStateHandler()
    }

    private fun setupList() {
        adapter = CakeAdapter {
            Toast.makeText(this, it.description, Toast.LENGTH_LONG).show()
        }
        binding.cakes.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.cakes.collect { adapter.submitList(it) }
        }
    }

    private fun setupStateHandler() {
        lifecycleScope.launchWhenStarted {
            viewModel.isLoadingVisible.collect { binding.progressIndicator.isVisible = it }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.isErrorVisible.collect { binding.error.isVisible = it }
        }
    }
}
