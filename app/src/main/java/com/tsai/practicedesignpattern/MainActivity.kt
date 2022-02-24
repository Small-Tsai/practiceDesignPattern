package com.tsai.practicedesignpattern

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tsai.practicedesignpattern.databinding.ActivityMainBinding

const val TAG = "small tsai"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

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

        /**
         * Observer design patter
         */
        val observerOne = object : Observer {
            override fun update(targetTitle: String) {
                binding.observer1.text = targetTitle
            }
        }

        val observerTwo = object : Observer {
            override fun update(targetTitle: String) {
                binding.observer2.text = targetTitle
            }
        }

        val target = ConcreteSubject()

        binding.apply {

            updateBtn.setOnClickListener {
                target.getTitleChanged(edt.text.toString())
            }

            var checkScriberOne = false
            var checkScriberTwo = false

            button2.setOnClickListener {
                when (checkScriberOne) {
                    false -> {
                        target.add(observerOne)
                        button2.text = "已訂閱"
                        checkScriberOne = true
                        button2.setTextColor(android.graphics.Color.RED)
                    }
                    true -> {
                        target.remove(observerOne)
                        button2.text = "未訂閱"
                        checkScriberOne = false
                        button2.setTextColor(android.graphics.Color.WHITE)
                    }
                }
            }

            button3.setOnClickListener {
                when (checkScriberTwo) {
                    false -> {
                        target.add(observerTwo)
                        button3.text = "已訂閱"
                        checkScriberTwo = true
                        button3.setTextColor(android.graphics.Color.RED)
                    }
                    true -> {
                        target.remove(observerTwo)
                        button3.text = "未訂閱"
                        checkScriberTwo = false
                        button3.setTextColor(android.graphics.Color.WHITE)
                    }
                }
            }
        }

        /**
         * Bridge design pattern
         */
        val white = White()
        val bag = BackPack()
        bag.setColor(white)
        Log.d(TAG, "bag name = ${bag.getName()}")

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

        /**
         * Strategy design pattern
         */
        val adventurer = Adventurer()
        adventurer.choiceFightStrategy(Strategy.FIREBALL)
        adventurer.attack()
        adventurer.choiceFightStrategy(Strategy.ITEM)
        adventurer.attack()

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
}


