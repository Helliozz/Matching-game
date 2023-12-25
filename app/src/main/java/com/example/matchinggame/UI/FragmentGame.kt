package com.example.matchinggame.UI

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.matchinggame.R
import com.example.matchinggame.ViewModel.FragmentGameViewModel
import com.example.matchinggame.ViewModel.MainActivityViewModel
import com.example.matchinggame.databinding.FragmentGameBinding


class FragmentGame : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()
    private val gameViewModel: FragmentGameViewModel by activityViewModels()
    private val firstActiveArray: Array<Int> = arrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
    private val secondActiveArray: Array<Int> = arrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
    private var firstIsEmpty: Boolean = true
    private val activeArray: ArrayList<View> = arrayListOf()
    private lateinit var cardArray: Array<Array<Int>>
    private var buttonEnable: Boolean = true
    private var score = 0
    private lateinit var countDownTimer: CountDownTimer
    private var time: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        cardArray = gameViewModel.shuffle()
        binding.count.text = mainActivityViewModel.getCount().toString()
        updateImage()
        startTimer()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (buttonEnable) {
            binding.apply {
                button00.setOnClickListener {
                    button00.isGone = true
                    card00.isVisible = true
                    activeArray.add(button00)
                    activeArray.add(card00)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 0
                        firstActiveArray[1] = 0
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 0
                        secondActiveArray[1] = 0
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button01.setOnClickListener {
                    button01.isGone = true
                    card01.isVisible = true
                    activeArray.add(button01)
                    activeArray.add(card01)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 0
                        firstActiveArray[1] = 1
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 0
                        secondActiveArray[1] = 1
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button02.setOnClickListener {
                    button02.isGone = true
                    card02.isVisible = true
                    activeArray.add(button02)
                    activeArray.add(card02)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 0
                        firstActiveArray[1] = 2
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 0
                        secondActiveArray[1] = 2
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button03.setOnClickListener {
                    button03.isGone = true
                    card03.isVisible = true
                    activeArray.add(button03)
                    activeArray.add(card03)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 0
                        firstActiveArray[1] = 3
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 0
                        secondActiveArray[1] = 3
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button10.setOnClickListener {
                    button10.isGone = true
                    card10.isVisible = true
                    activeArray.add(button10)
                    activeArray.add(card10)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 1
                        firstActiveArray[1] = 0
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 1
                        secondActiveArray[1] = 0
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button11.setOnClickListener {
                    button11.isGone = true
                    card11.isVisible = true
                    activeArray.add(button11)
                    activeArray.add(card11)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 1
                        firstActiveArray[1] = 1
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 1
                        secondActiveArray[1] = 1
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button12.setOnClickListener {
                    button12.isGone = true
                    card12.isVisible = true
                    activeArray.add(button12)
                    activeArray.add(card12)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 1
                        firstActiveArray[1] = 2
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 1
                        secondActiveArray[1] = 2
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button13.setOnClickListener {
                    button13.isGone = true
                    card13.isVisible = true
                    activeArray.add(button13)
                    activeArray.add(card13)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 1
                        firstActiveArray[1] = 3
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 1
                        secondActiveArray[1] = 3
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button20.setOnClickListener {
                    button20.isGone = true
                    card20.isVisible = true
                    activeArray.add(button20)
                    activeArray.add(card20)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 2
                        firstActiveArray[1] = 0
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 2
                        secondActiveArray[1] = 0
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button21.setOnClickListener {
                    button21.isGone = true
                    card21.isVisible = true
                    activeArray.add(button21)
                    activeArray.add(card21)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 2
                        firstActiveArray[1] = 1
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 2
                        secondActiveArray[1] = 1
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button22.setOnClickListener {
                    button22.isGone = true
                    card22.isVisible = true
                    activeArray.add(button22)
                    activeArray.add(card22)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 2
                        firstActiveArray[1] = 2
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 2
                        secondActiveArray[1] = 2
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button23.setOnClickListener {
                    button23.isGone = true
                    card23.isVisible = true
                    activeArray.add(button23)
                    activeArray.add(card23)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 2
                        firstActiveArray[1] = 3
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 2
                        secondActiveArray[1] = 3
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button30.setOnClickListener {
                    button30.isGone = true
                    card30.isVisible = true
                    activeArray.add(button30)
                    activeArray.add(card30)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 3
                        firstActiveArray[1] = 0
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 3
                        secondActiveArray[1] = 0
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button31.setOnClickListener {
                    button31.isGone = true
                    card31.isVisible = true
                    activeArray.add(button31)
                    activeArray.add(card31)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 3
                        firstActiveArray[1] = 1
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 3
                        secondActiveArray[1] = 1
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button32.setOnClickListener {
                    button32.isGone = true
                    card32.isVisible = true
                    activeArray.add(button32)
                    activeArray.add(card32)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 3
                        firstActiveArray[1] = 2
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 3
                        secondActiveArray[1] = 2
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button33.setOnClickListener {
                    button33.isGone = true
                    card33.isVisible = true
                    activeArray.add(button33)
                    activeArray.add(card33)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 3
                        firstActiveArray[1] = 3
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 3
                        secondActiveArray[1] = 3
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button40.setOnClickListener {
                    button40.isGone = true
                    card40.isVisible = true
                    activeArray.add(button40)
                    activeArray.add(card40)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 4
                        firstActiveArray[1] = 0
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 4
                        secondActiveArray[1] = 0
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button41.setOnClickListener {
                    button41.isGone = true
                    card41.isVisible = true
                    activeArray.add(button41)
                    activeArray.add(card41)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 4
                        firstActiveArray[1] = 1
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 4
                        secondActiveArray[1] = 1
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button42.setOnClickListener {
                    button42.isGone = true
                    card42.isVisible = true
                    activeArray.add(button42)
                    activeArray.add(card42)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 4
                        firstActiveArray[1] = 2
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 4
                        secondActiveArray[1] = 2
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
                button43.setOnClickListener {
                    button43.isGone = true
                    card43.isVisible = true
                    activeArray.add(button43)
                    activeArray.add(card43)
                    if (firstIsEmpty) {
                        firstActiveArray[0] = 4
                        firstActiveArray[1] = 3
                        firstIsEmpty = false
                    } else {
                        secondActiveArray[0] = 4
                        secondActiveArray[1] = 3
                        check()
                        firstIsEmpty = true
                        buttonEnable = true
                    }
                }
            }
        }
    }

    private fun check() {
        buttonEnable = false
        if (gameViewModel.check(cardArray, firstActiveArray, secondActiveArray)) {
            cardArray[firstActiveArray[0]][firstActiveArray[1]] = 0
            cardArray[secondActiveArray[0]][secondActiveArray[1]] = 0
            firstActiveArray[0] = Int.MAX_VALUE
            firstActiveArray[1] = Int.MAX_VALUE
            secondActiveArray[0] = Int.MAX_VALUE
            secondActiveArray[1] = Int.MAX_VALUE
            activeArray.clear()
            score++
            if (score == 10) {
                Handler().postDelayed({
                    Thread.sleep(1000)
                    requireView().findNavController()
                        .navigate(R.id.action_fragmentGame_to_fragmentEndGame)
                }, 0)
            }
        } else {
            firstActiveArray[0] = Int.MAX_VALUE
            firstActiveArray[1] = Int.MAX_VALUE
            secondActiveArray[0] = Int.MAX_VALUE
            secondActiveArray[1] = Int.MAX_VALUE
            Handler().postDelayed(
                {
                    Thread.sleep(500)
                    activeArray[0].isVisible = true
                    activeArray[1].isGone = true
                    activeArray[2].isVisible = true
                    activeArray[3].isGone = true
                    activeArray.clear()
                }, 0
            )
        }
    }

    private fun updateImage() {
        binding.apply {
            image00.setImageResource(getDrawable(cardArray[0][0]))
            image01.setImageResource(getDrawable(cardArray[0][1]))
            image02.setImageResource(getDrawable(cardArray[0][2]))
            image03.setImageResource(getDrawable(cardArray[0][3]))
            image10.setImageResource(getDrawable(cardArray[1][0]))
            image11.setImageResource(getDrawable(cardArray[1][1]))
            image12.setImageResource(getDrawable(cardArray[1][2]))
            image13.setImageResource(getDrawable(cardArray[1][3]))
            image20.setImageResource(getDrawable(cardArray[2][0]))
            image21.setImageResource(getDrawable(cardArray[2][1]))
            image22.setImageResource(getDrawable(cardArray[2][2]))
            image23.setImageResource(getDrawable(cardArray[2][3]))
            image30.setImageResource(getDrawable(cardArray[3][0]))
            image31.setImageResource(getDrawable(cardArray[3][1]))
            image32.setImageResource(getDrawable(cardArray[3][2]))
            image33.setImageResource(getDrawable(cardArray[3][3]))
            image40.setImageResource(getDrawable(cardArray[4][0]))
            image41.setImageResource(getDrawable(cardArray[4][1]))
            image42.setImageResource(getDrawable(cardArray[4][2]))
            image43.setImageResource(getDrawable(cardArray[4][3]))
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(61000, 1000) {
            override fun onTick(p0: Long) {
                if (p0 >= 60000) {
                    time = "1:0${(p0 - 60000) / 1000}"
                } else if (p0 / 1000 > 9) {
                    time = "0:${p0 / 1000}"
                } else {
                    time = "0:0${p0 / 1000}"
                }
                binding.timer.text = time
                mainActivityViewModel.writeTime((p0 / 1000).toInt())
            }

            override fun onFinish() {

            }

        }.start()
    }

    private fun getDrawable(num: Int): Int {
        return when (num) {
            1 -> R.drawable.icon_1
            2 -> R.drawable.icon_2
            3 -> R.drawable.icon_3
            4 -> R.drawable.icon_4
            5 -> R.drawable.icon_5
            6 -> R.drawable.icon_6
            7 -> R.drawable.icon_7
            8 -> R.drawable.icon_8
            9 -> R.drawable.icon_9
            10 -> R.drawable.icon_10
            else -> R.drawable.icon_1
        }
    }
}