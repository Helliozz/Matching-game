package com.example.matchinggame.ViewModel

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var count: Int = 0
    private var time: Int = 0

    fun getCount(): Int {
        return count
    }

    fun changeCount(int: Int) {
        count += int
    }

    fun writeTime(int: Int){
        time=int+3
    }
    fun getTime():Int{
        return time
    }
}