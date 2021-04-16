fun main( args: Array<String> ) {
    var dc1 = DemoClass()
    var dc2 = DemoClass()
    var dc3: DemoClass = dc1

    dc2.firstName = "object"
    dc2.lastName = "taro"
    dc3.firstName = "java"
    dc3.lastName = "daisuke"

    println("----- lesson1 -----")
    println(dc1.demoFun())
    println(dc2.demoFun())
    println(dc3.demoFun())

    dc1.marriage("kotlin")
    println()
    println("----- lesson2 -----")
    println(dc1.demoFun())
    println(dc2.demoFun())
    println(dc3.demoFun())
}

class DemoClass {
    var firstName: String = ""
    var lastName: String = ""

    fun demoFun() {
        println()
        println("my name is ${this.firstName} ${this.lastName}")
    }

    fun marriage(firstName: String) {
        this.firstName = firstName
    }
}