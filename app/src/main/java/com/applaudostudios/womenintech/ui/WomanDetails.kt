package com.applaudostudios.womenintech.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.applaudostudios.womenintech.R
import com.applaudostudios.womenintech.databinding.FragmentWomanDetailsBinding
import com.applaudostudios.womenintech.ui.viewmodel.WomenDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WomanDetails : Fragment() {

    private lateinit var binding: FragmentWomanDetailsBinding
    private val args: WomanDetailsArgs by navArgs()
    private val womanDetailsViewModel: WomenDetailViewModel by viewModel { parametersOf(args.id) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_woman_details, container, false)
        womanDetailsViewModel.womanDetails.observe(viewLifecycleOwner, Observer { womanDetails ->
            binding.woman = womanDetails
        })
        return binding.root
    }
}