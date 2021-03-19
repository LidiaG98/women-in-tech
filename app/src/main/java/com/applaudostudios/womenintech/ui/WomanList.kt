package com.applaudostudios.womenintech.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.applaudostudios.womenintech.R
import com.applaudostudios.womenintech.databinding.FragmentWomanListBinding
import com.applaudostudios.womenintech.ui.adapter.WomenListAdapter
import com.applaudostudios.womenintech.ui.viewmodel.WomenViewModel
import com.applaudostudios.womenintech.util.Status
import com.applaudostudios.womenintech.util.gone
import com.applaudostudios.womenintech.util.visible
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

        //Initialize binding to the view of this activity
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_woman_list, container, false)
        binding.lifecycleOwner = this

        //Set the adapter that is responsible to glue the information requested to the view
        val womenAdapter =
            WomenListAdapter(WomenListAdapter.WomanListener { womanId ->
                //Set the action that is going to trigger when we tap an item in the view
                val action = WomanListDirections.actionWomanListToWomanDetails2(womanId)
                view?.let { Navigation.findNavController(it).navigate(action) }
            })

        binding.womenRecycler.adapter = womenAdapter

        //Start watching when the information arrives, and when it's ready we display it
        womenViewModel.womenList.observe(viewLifecycleOwner, Observer { womenList ->
            binding.titleList.visible()
            binding.subTitleList.visible()
            womenAdapter.submitList(womenList)
        })

        //Check the status of the information, to known what items to display at any moment
        womenViewModel.status.observe(viewLifecycleOwner, Observer { status ->
            binding.progressBar.visibility = when (status) {
                Status.LOADING -> View.VISIBLE
                else -> View.GONE
            }
        })

        //Check the internet connection constantly to act accordingly
        womenViewModel.isConnected.observe(viewLifecycleOwner, Observer { hasConnection ->
            if (hasConnection == true) {
                binding.noWifiTxt.gone()
                womenViewModel.fetchList()
            } else {
                womenViewModel.status.value = Status.NO_CONNECTION
                binding.noWifiTxt.visible()
                womenViewModel.fetchList()
            }
        })

        return binding.root
    }
}