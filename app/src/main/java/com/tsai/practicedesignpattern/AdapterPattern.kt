package com.tsai.practicedesignpattern

import android.util.Log

interface Grandma {
    fun snore()
    fun sleep()
}

interface Wolf {
    fun bark()
    fun sleep()
}

class DefaultGrandma : Grandma {
    override fun snore() {
        Log.d(TAG, "snore: Grandma snore")
    }

    override fun sleep() {
        Log.d(TAG, "snore: Grandma sleep")
    }
}

class DefaultWolf : Wolf {
    override fun bark() {
        Log.d(TAG, "wolf bark")
    }

    override fun sleep() {
        Log.d(TAG, "wolf sleep")
    }
}

class WolfAdapter(private val wolf: DefaultWolf) : Grandma {
    override fun snore() {
        wolf.bark()
    }

    override fun sleep() {
        wolf.sleep()
    }
}

class GrandmaHome {
    fun call(grandma: Grandma) {
        grandma.snore()
    }
}