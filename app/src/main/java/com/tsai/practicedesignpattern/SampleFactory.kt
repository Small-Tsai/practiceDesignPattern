package com.tsai.practicedesignpattern

/**
 * 食物處理擁有相同的方法，因此將方法抽象化，變成一種規範
 */
interface CookMeal {
    fun cook()
    fun delivery()
}

class Steak : CookMeal {
    override fun cook() {
        println("把牛排煮熟")
    }

    override fun delivery() {
        println("送牛排")
    }
}

class Chicken : CookMeal {
    override fun cook() {
        println("把雞煮熟")
    }

    override fun delivery() {
        println("送雞")
    }
}

class Pork : CookMeal {
    override fun cook() {
        println("把豬煮熟")
    }

    override fun delivery() {
        println("送豬排")
    }
}

enum class MealType {
    STEAK, CHICKEN, PORK
}

/**
 * 隨著料理越來越多，假如我們在 Restaurant 不斷用 if else 判斷料理型別，
 * 會造成 Restaurant類非常臃腫，餐廳只需專注在餐點的處理上即可，因此建立一個工廠來專門依照型別建立不同食材。
 */
class MealFactory {

    fun createMeal(mealType: MealType): CookMeal {
        val meal = when (mealType) {
            MealType.STEAK -> Steak()
            MealType.CHICKEN -> Chicken()
            MealType.PORK -> Pork()
        }
        return meal
    }
}

class Restaurant(private val mealFactory: MealFactory) {

    fun mealOrder(mealType: MealType): CookMeal {
        val meal = mealFactory.createMeal(mealType)
        meal.cook()
        meal.delivery()
        return meal
    }
}

fun main() {
    val restaurant = Restaurant(MealFactory())
    restaurant.mealOrder(MealType.STEAK)
}
