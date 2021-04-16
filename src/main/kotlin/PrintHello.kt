import kotlin.reflect.KProperty
import kotlinx.coroutines.*
import java.util.*

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

    println()
    val greeterImpl = GreeterImpl()
    greeterImpl.hello()

    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableList.add(4)
    println()
    println("mutableList is $mutableList")
    println("mutableList[2] is ${mutableList[2]}")

    val mutableMap: MutableMap<String, String> = mutableMapOf(  "firstName" to "hoge",
                                                                "lastName" to "huga",
                                                                "address" to "street address")
    println()
    println("mutableMap is $mutableMap")
    println("mutableMap[\"lastName\"] is ${mutableMap["lastName"]}")

    println()
    println(getOddOrEven(99))

    val text = if(100 % 2 == 0) "Even" else "Odd"
    println()
    println(text)

    val num7 = 200
    val text1 = when(num7) {
        100 -> {
            "Equal to 100"
        }
        200 -> {
            "Equal to 200"
        }
        else -> {
            "else"
        }
    }
    println()
    println(text1)

    /* How to use accessor method */
    val user1 = User1();
    user1.name = "AAA"  /* This way of writing is setter */
    println()
    println(user1)
    println(user1.name)  /* This way of writing is getter */
    /* user1.id = 15 */  /* Only getters are generated in the definition of val */
    println(user1.id)
    /* println(user1.middleName) */ /* Run-time error because the value is not initialized */
    user1.middleName = "tom"
    println(user1.middleName)

    /* Accessor method extension */
    val user2 = User2()
    user2.name = "danny"
    println()
    println(user2.isValidName)
    println(user2.language)
    user2.language = ""
    println(user2.language)

    val user3_1 = User3()
    val user3_2 = User3()
    println()
    println(user3_1.equals(user3_2))
    println(user3_1.hashCode() == user3_2.hashCode())
    user3_1.getJavaClass()
    user3_2.getJavaClass()
    println(user3_1.equals(user3_1))
    println(user3_1.hashCode() == user3_1.hashCode())

    val user4 = User4(1, "kotlin")
    println()
    println(user4.id)
    println(user4.name)
    println(user4.component1())
    println(user4.component2())
    val updateUser4 = user4.copy()
    println(updateUser4.toString())

    println()
    printUserinfo(10)

    val user5 = User5(20)
    println()
    println(user5.toString())
//    user5.id = 30

    val user6 = User6(id = 30, age = 24)
    println()
    println(user6.toString())

    val calc: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 + num2 }
    println()
    println(calc(10, 5))
    val squared: (Int) -> Int = { it * it }
    println(squared(11))
    /* Anonymous function */
    val twotimes: (Int) -> Int = fun(num: Int): Int { return num * 2 }
    println(twotimes(35))

    println()
    printCalcResult(10, 20, { num3, num4 -> num3 + num4 })
    printCalcResult2(10, 20, { num3, num4 -> num3 * num4 })

    println()
    println(13.square())

    val oddNumbers = with(mutableListOf<Int>()) {
        for ( i in 1..10 ) {
            if(i % 2 == 1) this.add(i)
        }
        this.joinToString(separator = " ")
    }
    println()
    println(oddNumbers)

    val evenNumbers = mutableListOf<Int>().run {
        for( i in 1..10 ) {
            if( i % 2 == 0 ) this.add(i)
        }
        this.joinToString(separator = ",")
    }
    println()
    println(evenNumbers)

    val multipleOfThree = mutableListOf<Int>().let { list ->
        for( i in 1..20 ) {
            if( i % 3 == 0 ) list.add(i)
        }
        list.joinToString(separator = " ")
    }
    println()
    println(multipleOfThree)

    val multipleOfFive = mutableListOf<Int>().apply {
        for(i in 1..100) {
            if( i % 5 == 0 ) this.add(i)
        }
        this.joinToString(separator = " ")
    }
    println()
    println(multipleOfFive)

    val num8 = Num(3) + Num(5)
    println()
    println(num8)

    val executor = AddCalculationExecutor(CommonCalculationExecutor())
    println()
    executor.printStartMessage()
    println(executor.calc(8, 11))
    val divExecutor = DivCalculationExecutorDelegate(CommonCalculationExecutor())
    divExecutor.printStartMessage()
    println(divExecutor.calc(10, 2))

    val person = Person()
    println()
    person.name = "Steve"
    person.address = "California"
    println(person.name)
    println(person.address)
    val delegatePerson = DelegatePerson()
    println()
    delegatePerson.name = "Michael"
    delegatePerson.address = "San Francisco"
    println(delegatePerson.name)
    println(delegatePerson.address)

    println()
//    GlobalScope.launch {
//        delay(1000L)
//        println("Naoto.")
//    }
//    println("My name is")
//    Thread.sleep(2000L)

    runBlocking {
        launch {
            delay(1000L)
            println("Naoto.")
        }
        println("My name is")
    }

    val hello = HelloByJava()
    println()
    hello.printHello()

    val uuid: UUID = UUID.randomUUID()
    println()
    println(uuid.toString())

    val javaFun = CalcJava { num1, num2 -> num1 + num2 }
    println()
    println(javaFun.calc(1, 3))
}

typealias Func1 = (Int, Int) -> Int

/* From this point on, classes and functions */

fun getGreeting(name: String) {
    println("Good morning $name")
}

fun getOddOrEven(num: Int) : String {
    val text = if (num % 2 != 0) {
        "Odd"
    } else {
        "Even"
    }
    return text
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
class GreeterImpl: Greeter {
    override fun hello() {
        println("this is the method hello of Greeter class")
    }
}

interface Greeter {
    fun hello()
}

/* In kotlin, accessor methods are automatically generated when you define a property */
class User1 {
    var name: String =""
    val id: Int = 11
    lateinit var middleName: String
}

/* Write the extension after defining the property you want to extend */
class User2 {
    lateinit var name: String
    val isValidName: Boolean
        get() = name != ""
    var language: String = ""
        set(value) {
            if( value == "" ) {
                field = "Kotlin"
            } else {
                field = value
            }
        }
}

class User3 {
    val id: Int = 1
    val name: String = "kotlin"

    fun getJavaClass() { println(javaClass) }
}

data class User4 (val id: Int, var name: String)

fun printUserinfo(id: Int, name: String = "default") {
    println("id = $id, name = $name")
}

data class User5 (val id: Int, var name: String = "default")

data class User6 (val id: Int, val name: String = "default", val age: Int)

fun printCalcResult(num1: Int, num2: Int, calc: (Int, Int) -> Int) {
    val result = calc(num1, num2)
    println(result)
}

fun printCalcResult2(num1: Int, num2: Int, calc: Func1) {
    val result = calc(num1, num2)
    println(result)
}

fun Int.square(): Int = this * this

data class Num(val value: Int) {
    operator fun plus(num: Num): Num {
        return Num(value * num.value)
    }
}

interface CalculationExecutor {
    val message: String
    fun calc(num1: Int, num2: Int): Int
    fun printStartMessage()
}

class CommonCalculationExecutor( override val message: String = "calc") : CalculationExecutor {
    override fun calc(num1: Int, num2: Int): Int {
        throw IllegalStateException("Not implements calc")
    }

    override fun printStartMessage() {
        println("start $message")
    }
}

class AddCalculationExecutor( private val calculationExecutor: CalculationExecutor) : CalculationExecutor {
    override val message: String
        get() = calculationExecutor.message

    override fun calc(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    override fun printStartMessage() {
        calculationExecutor.printStartMessage()
    }
}

class DivCalculationExecutorDelegate(private val calculationExecutor: CalculationExecutor) : CalculationExecutor by calculationExecutor {
    override fun calc(num1: Int, num2: Int): Int {
        return num1 / num2
    }
}

class Person {
    var name: String = ""
        get() {
            println("get the variable name")
            return field
        }
        set(value) {
            println("update the variable name")
            field = value
        }

    var address: String = ""
        get() {
            println("get the variable address")
            return field
        }
        set(value) {
            println("update the variable address")
            field = value
        }
}

/* T is a generic, unified by any type */
/* Any is a null-free root class */
/* thisRef is a reference to the delegator object */
/* property is the property of the delegator */
class DelegateWithMessage<T> {
    private var value: T? = null

    operator fun getValue( thisRef: Any?, property: KProperty<*> ): T {
        println("get the variable ${property.name}")
        return value!!
    }

    operator fun setValue( thisRef: Any?, property: KProperty<*>, value: T ) {
        println("update the variable ${property.name}")
        this.value = value
    }
}

class DelegatePerson {
    var name: String by DelegateWithMessage()
    var address: String by DelegateWithMessage()
}

class HelloByKotlin {
    fun printHello() {
        println("Hello Kotlin")
    }
}