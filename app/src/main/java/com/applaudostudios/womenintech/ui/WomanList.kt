package com.applaudostudios.womenintech.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.applaudostudios.womenintech.R
import com.applaudostudios.womenintech.databinding.FragmentWomanListBinding
import com.applaudostudios.womenintech.databinding.WomanItemBinding
import com.applaudostudios.womenintech.ui.adapter.WomenListAdapter
import com.applaudostudios.womenintech.ui.viewmodel.WomenViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WomanList : Fragment() {

    private val womenViewModel: WomenViewModel by viewModel()
    private lateinit var binding: FragmentWomanListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_woman_list, container, false)
        binding.lifecycleOwner = this

        val womenAdapter = WomenListAdapter(WomenListAdapter.WomanListener { womanId ->
            val action = WomanListDirections.actionWomanListToWomanDetails2(womanId)
            view?.let { Navigation.findNavController(it).navigate(action) }
        })
        binding.womenRecycler.adapter = womenAdapter

        womenViewModel.womenList.observe(viewLifecycleOwner, Observer { womenList ->
            womenAdapter.submitList(womenList)
        })
        return binding.root
    }
}