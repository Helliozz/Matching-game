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
import com.example.matchinggame.databinding.FragmentEndGameBinding


class FragmentEndGame : Fragment() {

    private lateinit var binding: FragmentEndGameBinding
    private val mainViewModel: MainActivityViewModel by activityViewModels()
    private var score: Int = 0
    private var totalScore: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        getScore()
        binding = FragmentEndGameBinding.inflate(inflater, container, false)
        totalScore = "${mainViewModel.getCount()}+$score"
        binding.count.text = totalScore
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.doubleButton.setOnClickListener {
            score *= 2
            totalScore = "${mainViewModel.getCount()}+$score"
            binding.count.text = totalScore
            binding.doubleButton.isEnabled = false
        }

        binding.homeButton.setOnClickListener {
            mainViewModel.changeCount(score)
            requireView().findNavController()
                .navigate(R.id.action_fragmentEndGame_to_fragmentStartGame)
        }

    }

    fun getScore() {
        score
        if (mainViewModel.getTime() > 40) {
            score = 100
        } else if (mainViewModel.getTime() < 23) {
            score = 10
        } else {
            score = 10
            for (i in 23 until mainViewModel.getTime()) {
                score += 5
            }
        }
    }

}