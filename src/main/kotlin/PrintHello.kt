//class PrintHello {
//}
fun main() {
    println("Hello Kotlin")
    getGreeting("hoge")

    println()
    println("How to write an if statement 1")
    val num1 = 100
    if( num1 >= 100 ) {
        println("variable num1 is 100 or more")
    } else {
        println("variable num1 is less than 100")
    }

    println()
    println("How to write a when statement")
    val num2 = 150
    when(num2) {
        100 -> {
            println("variable num2 is 100")
        }
        200 -> {
            println("variable num2 is 100")
        }
        else -> {
            println("The variable num2 is neither 100 nor 200")
        }
    }

    println()
    println("How to write a while statement")
    var num3 = 1
    while( num3 < 5 ) {
        println("num3 is $num3")
        num3++
    }

    println()
    println("How to write a for statement 1")
    for( num4 in 1..5 ) {
        println("num4 is $num4")
    }

    println()
    println("How to write a for statement 2")
    for( num5 in 1 until 10 step 2 ) {
        println("num5 is $num5")
    }

    println()
    println("How to write a for statement 3")
    val list1 = listOf(1, 3, 6, 10, 15)
    for ( num6 in list1 ) {
        println("num6 is $num6")
    }

    println()
    println("How to write a class statement")
    val human = Human("taro")
    human.showName()

    println()
    println("How to write inheritance")
    val animal = Animal("cat")
    animal.showName()

    val dog = Dog("poti", 7)
    dog.showName()
    dog.showAge()
}

fun getGreeting(name: String) {
    println("Good morning $name")
}

class Human( val name: String ) {
    fun showName() {
        println("name is $name")
    }
}
/* When inheriting a class, it is necessary to add the open modifier to the parent class */
/* The same is true for method inheritance */
open class Animal (val name: String) {
    fun showName() = println("name is $name")
    open fun cries() = println("")
}

class Dog(name: String, val age: Int) : Animal(name) {
    override fun cries() = println("bowbow")
    fun showAge() = println("$name is $age years old")
}