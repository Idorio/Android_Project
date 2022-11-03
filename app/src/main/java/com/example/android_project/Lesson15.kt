package com.example.android_project

//const val
fun outerFun(){
    print("I`m an outer fun")
}

class Lesson15 {

    val country: String = "Belarus"
    var city = "Minsk"
    lateinit var address: String

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val kotlinClass = KotlinClass("Grisha ", 23)
            val kotlinClass2 = KotlinClass("country", "city" , "address")
            println("${kotlinClass2.country} ${kotlinClass2.city} ${kotlinClass2.address}")

            val string = kotlinClass.getNameAndAge()
            println(string)

            val lesson15 = Lesson15()
            lesson15.city = "Brest"
            lesson15.address = "Goshkevicha 4"
            println("${lesson15.address}")

            lesson15.returnBoolean()
            outerFun()
        }
    }

    fun emptyFun(): Unit = print("I`m an empty fun")

    fun returnBoolean(): Boolean = true


}

class KotlinClass( val name: String,var age: Int): Parent(), Behavior{

    public var country = ""
    public var city = ""
    public var address = " "

    constructor() : this("", 1)
    constructor(country: String, city : String, address: String) : this(){
        this.country = country
        this.city = city
        this.address = address
    }

    fun getNameAndAge(): String{

        return "$name $age" //name + age
    }

    override fun getHairColor() {
        super.getHairColor()
    }

    override fun getEyeColor() {
        TODO("Not yet implemented")
    }

}

open class Parent{

    open fun getHairColor(){

    }

}

interface Behavior{

    fun getEyeColor()

}