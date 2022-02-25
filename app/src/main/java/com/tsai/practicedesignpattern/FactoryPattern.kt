package com.tsai.practicedesignpattern

/**
 * 食物處理擁有相同的方法，因此將方法抽象化，變成一種規範
 */
interface CookMealManager {
    fun cook()
    fun delivery()
}

interface MealFactoryProvider {
    fun createMeal(): CookMealManager
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
 * 隨著料理越來越多，假如我們在 Restaurant 不斷用 if else 判斷料理型別，
 * 會造成 Restaurant類非常臃腫，餐廳只需專注在餐點的處理上即可，因此建立一個工廠來專門依照型別建立不同食材。
 * 同樣的隨著食材越來越多 (豬牛羊雞.....) 工廠的邏輯也會越來越臃腫 因此我們把工廠建立食材的方法抽像化，
 * 讓不同的工廠遵守相同的規範即可，例如一間大型食品公司成立許多分工廠來為其生產不同類別的食材。
 */
class SteakFactory : MealFactoryProvider {
    override fun createMeal(): CookMealManager {
        return Steak()
    }
}

class ChickenFactory : MealFactoryProvider {
    override fun createMeal(): CookMealManager {
        return Chicken()
    }
}

class PorkFactory : MealFactoryProvider {
    override fun createMeal(): CookMealManager {
        return Pork()
    }
}

class Restaurant(private val mealFactory: MealFactoryProvider) {

    fun mealOrder(): CookMealManager {
        val meal = mealFactory.createMeal()
        meal.cook()
        meal.delivery()
        return meal
    }
}

fun main() {
    val steakRestaurant = Restaurant(SteakFactory())
    val chickenRestaurant = Restaurant(ChickenFactory())
    steakRestaurant.mealOrder()
    chickenRestaurant.mealOrder()
}
