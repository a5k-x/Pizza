package com.a5k.pizza.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a5k.pizza.data.AppState
import com.a5k.pizza.databinding.FragmentMenuListBinding
import com.a5k.pizza.view.adapter.MainAdapter
import com.a5k.pizza.viewModel.MainViewModel

class MenuListFragment : Fragment() {

    private var vb:FragmentMenuListBinding?=null
    private var mainAdapter:MainAdapter? = null
    private val viewModel:MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentMenuListBinding.inflate(inflater,container,false)
        return vb?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initBannerAdapter()
    }

    private fun initViewModel() {
        viewModel.getLiveData().observe(viewLifecycleOwner) {data -> render(data)}
    }

    private fun render(data: AppState) {
        when (data){
            is AppState.Success -> {}
            is AppState.Loading -> {}
            is AppState.Error -> {}
        }
    }

    private fun initBannerAdapter() {
        vb?.recylerBannerContainer?.run {
            layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
            mainAdapter = MainAdapter()
            adapter = mainAdapter
        }
    }



}

