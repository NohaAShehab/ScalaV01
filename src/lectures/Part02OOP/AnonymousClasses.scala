package lectures.Part02OOP

object AnonymousClasses extends App{

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal = new Animal {
    override def eat: Unit = println("hahahahahahahahahhaha")
  }/// anonymous class  will
//
//  class AnonymousClasses$$anon extends Animal{
//  override def eat: Unit = println("hahahahahahahahahhaha")
//}
  println(funnyAnimal.getClass)

  class Person (name: String){
    def sayHi: Unit = println(s"Hi, My name is $name, how can I help")
  }

  val noha = new Person("noha"){
    override def sayHi: Unit =println(s"Hi, My name is noha, how can I be in service")
  }
  noha.sayHi
}
