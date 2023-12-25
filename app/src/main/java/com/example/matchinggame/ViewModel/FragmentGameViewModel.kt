package com.example.matchinggame.ViewModel

import androidx.lifecycle.ViewModel

class FragmentGameViewModel : ViewModel() {


    fun check(
        cardArray: Array<Array<Int>>, firstActiveArray: Array<Int>, secondActiveArray: Array<Int>
    ): Boolean {
        if (cardArray[firstActiveArray[0]][firstActiveArray[1]]==cardArray[secondActiveArray[0]][secondActiveArray[1]]){
            return true
        }
        return false
    }

    fun shuffle(): Array<Array<Int>> {
        var shuffleArray = Array(5) { Array(4) { 0 } }
        var num: ArrayList<Int> = arrayListOf()
        for (i in 1..10) {
            num.add(i)
            num.add(i)
        }
        num.shuffle()

        var index = 0

        for (i in 0 until 5) {
            for (j in 0 until 4) {
                shuffleArray[i][j] = num[index]
                index++
            }
        }
        return shuffleArray
    }
}