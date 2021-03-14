package lectures.Part02OOP

object OOPBasics extends App{
  val aStudent =  new Student
  println(aStudent)

  val aPerson = new Person("noha",22)
  println(aPerson)
  //  println(aPerson.age)   class parameters are not a fields
  // person2
  val aPerson2= new Person2("nohaaaaa", 23)
  println(aPerson2.age)

  // class Host
  val ahost = new Host("Noha", 22)
  println(ahost.x)
  ahost.greetFunctionOne("Fatma")
  ahost.greetFunctionOne()

  val bhost = new Host()
  bhost.greetFunctionOne("Nohaaaaaaaaaaaaa")

  val cHost =  new Host("Nuha")
  cHost.greetFunctionOne()
}

class Student

class Person(name: String, age: Int)  /// constructor --> class parameters are not a fields
class Person2(name:String, val age: Int)

class Host(name:String, age: Int){
  // class body
  val x =2

  /// it is a method
  def greetFunctionOne(name: String) = println(s"${this.name} says hello $name")

  // method overloading
  def greetFunctionOne():Unit = println(s"My name is $name")

  /// mutliple constructors

  def this (name: String) = this (name, 0)
  def this () = this ("Noha shehab", 0)

}