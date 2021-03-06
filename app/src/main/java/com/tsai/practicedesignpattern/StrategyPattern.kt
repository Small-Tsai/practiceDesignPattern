package com.tsai.practicedesignpattern

interface FightStrategy {
    fun execute()
}

class NormalAttack : FightStrategy {
    override fun execute() {
        println("execute: 普通攻擊")
    }
}

class FireBall : FightStrategy {
    override fun execute() {
        println("execute: 火球術")
    }
}

class Item : FightStrategy {
    override fun execute() {
        println("execute: 使用道具")
    }
}

enum class Strategy {
    NORMAL_ATTACK, FIREBALL, ITEM
}

class Adventurer {
    private var fightStrategy: FightStrategy? = null

    private fun setStrategy(fightStrategy: FightStrategy) {
        this.fightStrategy = fightStrategy
    }

    // 簡單工廠模式
    fun choiceFightStrategy(strategy: Strategy) {
        when (strategy) {
            Strategy.NORMAL_ATTACK -> setStrategy(NormalAttack())
            Strategy.FIREBALL -> setStrategy(FireBall())
            Strategy.ITEM -> setStrategy(Item())
        }
    }

    fun attack() {
        if (fightStrategy == null) {
            this.fightStrategy = NormalAttack()
        }
        fightStrategy?.execute()
    }

}

fun main() {
    /**
     * Strategy design pattern
     */
    val adventurer = Adventurer()
    adventurer.choiceFightStrategy(Strategy.FIREBALL)
    adventurer.attack()
    adventurer.choiceFightStrategy(Strategy.ITEM)
    adventurer.attack()
}