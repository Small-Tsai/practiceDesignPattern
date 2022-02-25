package com.tsai.practicedesignpattern

/**
 * 食物處理擁有相同的方法，因此將方法抽象化，變成一種規範
 */
interface CookMealManager {
    fun cook()
    fun delivery()
}

/**
 * 不同的餐廳可能有不同的醬料 因此建立抽象化的醬料規範
 */
interface Ingredient {
    fun getSauce()
}

class TWIngredient : Ingredient {
    override fun getSauce() {
        println("淋上台式醬料！")
    }
}

class ITIngredient : Ingredient {
    override fun getSauce() {
        println("淋上義式醬料")
    }
}

class Steak : CookMealManager {
    override fun cook() {
        println("把牛排煮熟")
    }

    override fun delivery() {
        println("送牛排")
    }
}

class Chicken : CookMealManager {
    override fun cook() {
        println("把雞煮熟")
    }

    override fun delivery() {
        println("送雞")
    }
}

class Pork : CookMealManager {
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
 * 利用 abstract class 將各種抽象物件整合在一起 並透過實體工廠來實作生產產品的過程
 */
abstract class Restaurant {

    fun mealOrder(mealType: MealType): CookMealManager {
        val meal = createMeal(mealType)
        val ingredient = getIngredient()
        meal.cook()
        ingredient.getSauce()
        meal.delivery()
        return meal
    }

    abstract fun createMeal(mealType: MealType): CookMealManager
    abstract fun getIngredient(): Ingredient
}

class TWRestaurant : Restaurant() {

    override fun createMeal(mealType: MealType): CookMealManager {
        return when (mealType) {
            MealType.STEAK -> Steak()
            MealType.CHICKEN -> Chicken()
            MealType.PORK -> Pork()
        }
    }

    override fun getIngredient(): Ingredient = TWIngredient()

}

class ITRestaurant : Restaurant() {

    override fun createMeal(mealType: MealType): CookMealManager {
        return when (mealType) {
            MealType.STEAK -> Steak()
            MealType.CHICKEN -> Chicken()
            MealType.PORK -> Pork()
        }
    }

    override fun getIngredient(): Ingredient = ITIngredient()

}

fun main() {
    val TWRestaurant = TWRestaurant()
    TWRestaurant.mealOrder(MealType.STEAK)
    TWRestaurant.mealOrder(MealType.CHICKEN)

    val ITRestaurant = ITRestaurant()
    ITRestaurant.mealOrder(MealType.STEAK)
    ITRestaurant.mealOrder(MealType.CHICKEN)

}
