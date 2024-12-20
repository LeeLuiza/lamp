package com.example.lamp.presenter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lamp.R
import com.example.lamp.UiState
import com.example.lamp.databinding.FragmentMainBinding
import com.example.lamp.di.ViewModelFactory
import com.example.lamp.di.appComponent
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding: FragmentMainBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainFragmentViewModel by viewModels() {viewModelFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getColors()

        with(binding) {
            switchLamp.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    viewModel.turnOn()
                } else {
                    viewModel.turnOff()
                }
                viewModel.lampState.observe(viewLifecycleOwner) {
                    //reaction(it)
                }
            }

            seekBarBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    stateBrightness(progress)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item)

            viewModel.colors.observe(viewLifecycleOwner) {
                when (it) {
                    is UiState.Success -> {
                        adapter.addAll(it.value)
                    }
                    is UiState.Failure -> {
                        adapter.addAll(listOf("Нет"))
                    }
                    else -> {}
                }
            }

            viewModel.stateColor.observe(viewLifecycleOwner) {
                //reaction(it)
            }
            spinnerColors.adapter = adapter
            spinnerColors.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    itemSelected: View, selectedItemPosition: Int, selectedId: Long
                ) {
                    val adapter = parent?.adapter as? ArrayAdapter<String>
                    val selectedText = adapter?.getItem(selectedItemPosition) ?: ""
                    if (selectedText != "-")
                        viewModel.setColor(selectedText)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }

    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    private fun stateBrightness(level: Int) {
        viewModel.setBrightness(level)
        viewModel.stateBrightness.observe(viewLifecycleOwner) {
            //reaction(it)
        }
    }
}