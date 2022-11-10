package com.example.android_project.Lesson16

class Lesson16 {

    val nullable: Int? = null

    companion object {


        @JvmStatic
        fun main(args: Array<String>) {
            val lesson16 = Lesson16()
            var nonNullableValues: Int = 0 //не нал переменная
            //val nullableValues: Int? = lesson16.nullable// это нал переменная
            val nullableValues: Int? = 12
            nonNullableValues.let {
                nonNullableValues = it
            }

            if (nullableValues !=null){
                nonNullableValues=nullableValues
            }
            nonNullableValues = nullableValues ?: 0
            println(nonNullableValues)

            nonNullableValues=nullableValues!!
            print(nonNullableValues)

            val outer = Outer(Inner("value is inner"))
            val value:String = outer.inner?.value ?: ""

        }
    }
}

data class Outer(val inner: Inner?)
data class Inner(val value: String)

