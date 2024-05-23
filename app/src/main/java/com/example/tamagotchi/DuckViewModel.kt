package com.example.tamagotchi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.model

class Duckmodel : model() {
    private val _hunger = MutableLiveData<Int>()
    val hunger: LiveData<Int> get() = _hunger

    private val _happiness = MutableLiveData<Int>()
    val happiness: LiveData<Int> get() = _happiness

    private val _hygiene = MutableLiveData<Int>()
    val hygiene: LiveData<Int> get() = _hygiene

    init {
        resetStats()
    }

    fun feedDuck() {
        _hunger.value = (_hunger.value?: 0) - 10
    }

    fun playWithDuck() {
        _happiness.value = (_happiness.value?: 0) + 10
    }

    fun cleanDuck() {
        _hygiene.value = (_hygiene.value?: 0) + 10
    }

    fun resetStats() {
        _hunger.value = 50
        _happiness.value = 50
        _hygiene.value = 50
    }
}
