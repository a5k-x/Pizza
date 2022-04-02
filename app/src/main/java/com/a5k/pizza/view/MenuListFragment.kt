package com.a5k.pizza.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a5k.pizza.data.AppState
import com.a5k.pizza.databinding.FragmentMenuListBinding
import com.a5k.pizza.view.adapter.MainAdapter
import com.a5k.pizza.view.adapter.MenuAdapter
import com.a5k.pizza.viewModel.MainViewModel

class MenuListFragment : Fragment() {

    private var vb: FragmentMenuListBinding? = null
    private var mainAdapter: MainAdapter? = null
    private var menuAdapter: MenuAdapter? = null
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentMenuListBinding.inflate(inflater, container, false)
        return vb?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initBannerAdapter()
        initMenuAdapter()
    }

    private fun initViewModel() {
        mainAdapter = MainAdapter()
        menuAdapter = MenuAdapter()

        viewModel.getLiveData().observe(viewLifecycleOwner) { data -> render(data) }
        viewModel.getLiveDataMenu().observe(viewLifecycleOwner) { data -> render(data) }
        viewModel.getListBanner()
        viewModel.getListMenu()
    }

    private fun render(data: AppState) {
        when (data) {
            is AppState.SuccessListBanner -> {
                val listDataBanner = data.item
                mainAdapter?.initBanner(listDataBanner)
            }
            is AppState.SuccessListMenu -> {
                val listDataMenu = data.item
                menuAdapter?.initMenu(listDataMenu)
            }
            is AppState.Loading -> {}
            is AppState.Error -> {
                Toast.makeText(requireContext(),ERROR,Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initBannerAdapter() {
        vb?.recylerBannerContainer?.run {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = mainAdapter

        }
    }
    private fun initMenuAdapter(){
        vb?.recylerItemContainer?.run {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = menuAdapter
        }
    }
companion object{
    private const val ERROR = "Ошибка загрузки данных"
}

}

