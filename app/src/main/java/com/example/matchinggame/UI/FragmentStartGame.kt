package com.example.matchinggame.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.matchinggame.R
import com.example.matchinggame.ViewModel.MainActivityViewModel
import com.example.matchinggame.databinding.FragmentStartGameBinding

class FragmentStartGame : Fragment() {

    private lateinit var binding: FragmentStartGameBinding
    private val mainActivityViewModel:MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartGameBinding.inflate(inflater, container, false)
        binding.count.text=mainActivityViewModel.getCount().toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.playButton.setOnClickListener{
            requireView().findNavController().navigate(R.id.action_fragmentStartGame_to_fragmentGame)
        }
    }
}