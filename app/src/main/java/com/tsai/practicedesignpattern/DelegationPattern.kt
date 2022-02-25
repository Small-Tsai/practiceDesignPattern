package com.tsai.practicedesignpattern

interface Cloth {
    fun wear()
}

interface Hat {
    fun putOn()
}

class Shirt : Cloth {
    override fun wear() {
        println("wear: shirt")
    }
}

class Dress : Cloth {
    override fun wear() {
        println("wear: Dress")
    }
}

class OldHat : Hat {
    override fun putOn() {
        println("putOn: oldHat")
    }
}

class Person(cloth: Cloth, hat: Hat) : Cloth by cloth, Hat by hat

fun main() {
    /**
     * Delegation design pattern
     */
    val shirt = Shirt()
    val dress = Dress()
    val oldHat = OldHat()
    val personShirt = Person(shirt, oldHat)
    val personDress = Person(dress, oldHat)

    personShirt.wear()
    personDress.wear()
    personShirt.putOn()
}