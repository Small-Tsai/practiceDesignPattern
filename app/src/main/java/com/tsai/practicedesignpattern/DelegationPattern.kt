package com.tsai.practicedesignpattern

import android.util.Log

interface Cloth {
    fun wear()
}

interface Hat {
    fun putOn()
}

class Shirt : Cloth {
    override fun wear() {
        Log.d(TAG, "wear: shirt")
    }
}

class Dress : Cloth {
    override fun wear() {
        Log.d(TAG, "wear: Dress")
    }
}

class OldHat : Hat {
    override fun putOn() {
        Log.d(TAG, "putOn: oldHat")
    }
}

class Person(cloth: Cloth, hat: Hat) : Cloth by cloth, Hat by hat