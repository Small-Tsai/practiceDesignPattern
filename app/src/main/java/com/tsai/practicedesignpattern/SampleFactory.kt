package com.tsai.practicedesignpattern

class Steak {
    fun cook() {
        println("把牛排煮熟")
    }

    fun delivery() {
        println("送牛排")
    }
}

class Chicken {
    fun cook() {
        println("把雞煮熟")
    }

    fun delivery() {
        println("送雞")
    }
}

class Restaurant {
    fun cookSteak(): Steak {
        val steak = Steak()
        steak.cook()
        steak.delivery()
        return steak
    }

    fun cookChicken(): Chicken {
        val chicken = Chicken()
        chicken.cook()
        chicken.delivery()
        return chicken
    }
}

fun main() {
    val restaurant = Restaurant()
    restaurant.cookSteak()
    restaurant.cookChicken()
}
