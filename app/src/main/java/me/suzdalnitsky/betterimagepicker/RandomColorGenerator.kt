package me.suzdalnitsky.betterimagepicker

import android.graphics.Color
import kotlin.random.Random

class RandomColorGenerator {

    private val random = Random.Default

    fun generate() = Color.argb(255, getRandomChanelValue(), getRandomChanelValue(), getRandomChanelValue())

    private fun getRandomChanelValue() = random.nextInt(256)
}