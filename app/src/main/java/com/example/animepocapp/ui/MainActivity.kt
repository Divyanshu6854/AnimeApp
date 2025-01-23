package com.example.animepocapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.animepocapp.databinding.ActivityMainBinding
import com.example.animepocapp.utils.SharedPrefUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        SharedPrefUtil(this).putPosition(0)
        setContentView(binding.root)
        initView()
    }

    fun initView(){
        loadFragment(AnimeListFragment())
    }

    fun loadFragment(fragment : Fragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.fragContainer.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun onAnimeItemSelected(id: Int, position: Int) {
        SharedPrefUtil(this).putPosition(position)
        val frag = AnimeDetailFragment()
        val arg = Bundle()
        arg.putInt("AnimeId", id)
        frag.arguments = arg
        loadFragment(frag)
    }
}
