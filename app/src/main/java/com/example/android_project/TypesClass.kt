package com.example.android_project

class TypesClass {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //не изменяемоя колекция
            val collectionList = listOf<String>(
                "hello",
                "bye",
                "world"
            )
            //collectionList.add()
            // изменяемая колекция
            val collectionlist2 = mutableListOf<String>()
            collectionlist2.add("Hello")
            collectionlist2.add("bye")
            collectionlist2.add("world")

            collectionList.forEach{ words ->
                print("$words ")
            }

            for(i in 1..10){
                print(i)
            }

            val arrayList = arrayListOf<String>(
                "hello",
                "bye",
                "world"
            )
            for (word in arrayList){
                print(word)
            }

            for (i in 10 downTo 1 step 2){
                print("$i\n")
            }

            for(i in 1..10){
                if(i==2){
                    println("Hello World")
                    continue
                }
                println(i)
            }
            val typesClass1 = TypesClass()
            repeat(10){
                println(typesClass1.getName())
            }

        }
    }

   fun  getName(): String{
        return "Hello"
    }
}


open class Parent2{

    open fun walk(){
        print("Parent is walking")
    }
}

class Child : Parent2(){
    override fun walk(){
        print("Child is walking")
    }
    fun sleep(){
        print("Child is sleeping")
    }
}