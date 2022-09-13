package com.ianpedraza.atm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ianpedraza.atm.databinding.ActivityMainBinding
import com.ianpedraza.atm.utils.viewBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel: AtmViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCash.setOnClickListener { viewModel.cash(getAmount()) }
        binding.btnDeposit.setOnClickListener { viewModel.deposit(getAmount()) }

        viewModel.balance.observe(this) { balance ->
            balance?.let {
                binding.tvBalance.text = String.format("$%.2f", balance)
            }
        }
    }

    private fun getAmount() : Double {
        return try {
            binding.tietAmount.text.toString().toDouble()
        } catch (error: Exception) {
            0.0
        }
    }
}