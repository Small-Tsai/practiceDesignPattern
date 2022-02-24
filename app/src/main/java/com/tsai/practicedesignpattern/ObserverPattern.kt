package com.tsai.practicedesignpattern

// Observer

interface Observer {
    fun update(targetTitle: String)
}

interface Subject {
    fun getTitleChanged(title: String)
    fun add(subscriber: Observer)
    fun remove(subscriber: Observer)
}

class ConcreteSubject : Subject {

    private val subScribers = mutableListOf<Observer>()

    override fun getTitleChanged(title: String) {
        subScribers.forEach { it.update(title) }
    }

    override fun add(subscriber: Observer) {
        subScribers.add(subscriber)
    }

    override fun remove(subscriber: Observer) {
        subScribers.remove(subscriber)
    }

}
