package com.example.android_project

class HouseBuilder(val builder: Builder) {

    fun hasSwimmingPool() = builder.swimmingPoll
    fun howManyStock() = builder.stock

    companion object Builder {
        var stock: Int = 0
        var swimmingPoll: Boolean = false

        fun setStock(stock: Int) = apply { this.stock = stock }
        fun setPool(swimmingPool: Boolean) = apply { this.swimmingPoll = swimmingPool }

        fun buildHouse(): HouseBuilder {
            return HouseBuilder(this)
        }
    }
}