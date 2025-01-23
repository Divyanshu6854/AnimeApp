package com.example.animepocapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animepocapp.adapter.AnimeListAdapter
import com.example.animepocapp.databinding.FragmentAnimeListBinding
import com.example.animepocapp.utils.OnClickListeners
import com.example.animepocapp.utils.ProgressBarHelper
import com.example.animepocapp.utils.SharedPrefUtil
import com.example.animepocapp.viewmodel.GetAnimeListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeListFragment : Fragment(), OnClickListeners {

    lateinit var binding: FragmentAnimeListBinding
    private val getAnimeListViewModel: GetAnimeListViewModel by viewModels()
    lateinit var animeListAdapter: AnimeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        apiResponse()
    }

    fun initView() {
        ProgressBarHelper.show(requireActivity())
        if (getAnimeListViewModel.isDataFetched()) {
            ProgressBarHelper.hide()
            return
        }
        getAnimeListViewModel.getAnimeList()
    }

    fun apiResponse() {
        getAnimeListViewModel.posts.observe(viewLifecycleOwner) { resp ->
            ProgressBarHelper.hide()
            animeListAdapter = AnimeListAdapter(requireContext(), resp.data, this)
            binding.rvAnimeList.layoutManager = LinearLayoutManager(requireContext())
            binding.rvAnimeList.adapter = animeListAdapter
            getAnimeListViewModel.setDataFetched(true)
        }

        getAnimeListViewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            ProgressBarHelper.hide()
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onAnimeItemSelected(id: Int, position : Int) {
        (requireActivity() as MainActivity).onAnimeItemSelected(id, position)
    }

    override fun onResume() {
        super.onResume()
        if (SharedPrefUtil(requireContext()).getPosition() != 0){
            binding.rvAnimeList.scrollToPosition(SharedPrefUtil(requireContext()).getPosition())
        }
    }
}
