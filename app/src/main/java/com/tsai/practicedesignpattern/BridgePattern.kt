package com.tsai.practicedesignpattern

import android.util.Log


// Bridge
interface Color {
    fun getColor(): String
}

class White : Color {
    override fun getColor(): String {
        return "White"
    }
}

class Black : Color {
    override fun getColor(): String {
        return "Black"
    }
}

abstract class Bag {
    protected var color: Color? = null

    abstract fun getName(): String

    @JvmName("setColor1")
    fun setColor(color: Color) {
        this.color = color
    }
}

class BackPack : Bag() {
    override fun getName(): String {
        return color?.getColor() + "Backpack"
    }
}

/**
 * 聚合範例
 * 班級與學生無關連 ---> 班級畢業後此班級就不存在了 但學生依然存在 （學生生命週期>班級）
 */
class Student {
    fun response() {
        println("student喊在！！")
    }
}

class clazz {
    fun request(student: Student) {
        println("class點名！！")
        student.response()
    }
}

class MyClass {
    fun example() {
        val c = clazz()
        val s = Student()
        c.request(s)
    }
}

/**
 * 合成範例 人與器官關聯性高 --> 人如死了心臟跟著停止跳動
 */
class Heart {
    fun response() {
        println("心臟跳動")
    }
}

class Human {
    val h = Heart()
    fun request() {
        println("人活著")
        h.response()
    }
}

class MyClass2 {
    fun example2() {
        val human = Human()
        human.request()
    }
}

//練習--
interface CarColor {
    fun color(): String
}

interface Car {
    val carColor: CarColor
    fun run()
}

class DefaultCarColor : CarColor {
    override fun color(): String {
        return "white"
    }
}

class ElectricCar(override val carColor: CarColor) : Car {
    override fun run() {
        Log.d(TAG, "run: 用電在跑")
    }
}

class NormalCar(override val carColor: CarColor) : Car {
    override fun run() {
        Log.d(TAG, "run: 用油在跑")
    }
}

fun main() {
    /**
     * Bridge design pattern
     */
    val white = White()
    val bag = BackPack()
    bag.setColor(white)
    println("bag name = ${bag.getName()}")

    /**
     * 練習 Bridge
     */
    val color = DefaultCarColor()
    val electricCar = ElectricCar(color)
    val normalCar = NormalCar(color)
    Log.d(TAG, "car color = ${electricCar.carColor.color()}")
    Log.d(TAG, "car color = ${normalCar.carColor.color()}")
    electricCar.run()
    normalCar.run()
}