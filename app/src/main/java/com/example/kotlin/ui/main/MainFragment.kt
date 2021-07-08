package com.example.kotlin.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.base.BaseFragment
import com.example.kotlin.databinding.FragmentMainBinding


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private var viewModel: MainViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun showDisconnectState() {
    }

    override fun setupUi() {
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun setupLiveData() {
        viewModel?.fetchPlayList()?.observe(requireActivity(), {
            Toast.makeText(requireContext(), it?.king.toString(), Toast.LENGTH_SHORT).show()
        })
    }


}