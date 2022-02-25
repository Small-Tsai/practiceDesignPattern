package com.tsai.practicedesignpattern

import android.os.Bundle
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
    }
}


