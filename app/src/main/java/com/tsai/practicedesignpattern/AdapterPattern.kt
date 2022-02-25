package com.tsai.practicedesignpattern

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
        println("snore: Grandma snore")
    }

    override fun sleep() {
        println("sleep: Grandma sleep")
    }
}

class DefaultWolf : Wolf {
    override fun bark() {
        println("wolf bark")
    }

    override fun sleep() {
        println("wolf sleep")
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

fun main() {
    /**
     * Adapter design pattern
     */
    val grandma = DefaultGrandma()
    val wolf = DefaultWolf()

    /**
     * Wolf ----> Grandma 試著用[WolfAdapter]把狼偽裝成奶奶
     */
    val wolfAdapter = WolfAdapter(wolf)
    val grandmaHome = GrandmaHome()
    grandmaHome.call(grandma)
    grandmaHome.call(wolfAdapter)
}