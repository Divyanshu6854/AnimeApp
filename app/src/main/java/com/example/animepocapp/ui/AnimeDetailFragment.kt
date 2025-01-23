package com.example.animepocapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.animepocapp.databinding.FragmentAnimeDetailBinding
import com.example.animepocapp.utils.ProgressBarHelper
import com.example.animepocapp.viewmodel.GetAnimeDetailByIdViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnimeDetailFragment : Fragment() {

    lateinit var binding: FragmentAnimeDetailBinding
    private val getAnimeDetailByIdViewModel: GetAnimeDetailByIdViewModel by viewModels()
    var animeId : Int = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animeId = arguments?.getInt("AnimeId", -1)!!
        initView()
        apiResponse()
    }

    fun initView() {
        ProgressBarHelper.show(requireActivity())
        getAnimeDetailByIdViewModel.getAnimeDetail(animeId)
    }

    fun apiResponse(){
        getAnimeDetailByIdViewModel.posts.observe(requireActivity()){ resp ->
            ProgressBarHelper.hide()
            binding.title.text = resp.data.title
            binding.tvGenre.text = "Genre : "+resp.data.genres.joinToString(", ") { it.name }
            binding.tvEpisodes.text = "Episodes : "+resp.data.episodes.toString()
            binding.tvRating.text = "Rating : "+resp.data.rating
            binding.tvSynopsis.text = resp.data.synopsis

            if (resp.data.trailer.youtube_id.isNullOrEmpty()){
                binding.imgPoster.visibility = View.VISIBLE
                binding.youtubePlayerView.visibility = View.GONE
                Glide.with(requireContext()).load(resp.data.images.jpg.image_url).into(binding.imgPoster)
            } else {
                binding.imgPoster.visibility = View.GONE
                binding.youtubePlayerView.visibility = View.VISIBLE
                lifecycle.addObserver(binding.youtubePlayerView)
                binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        val videoId = resp.data.trailer.youtube_id
                        youTubePlayer.loadVideo(videoId, 0f)
                    }
                })
            }
        }

        getAnimeDetailByIdViewModel.errorMessage.observe(requireActivity()){ error ->
            ProgressBarHelper.hide()
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            Log.e("AnimeDetailFrag", "error-> $error")
        }
    }

}