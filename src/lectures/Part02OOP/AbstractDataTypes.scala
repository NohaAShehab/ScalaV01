package lectures.Part02OOP


object AbstractDataTypes extends App{


  // blank members, abstract fields or methods

  // cannot be instantiate
   abstract class Animal {
    val creatureType: String
    val category: String= "test"
    def eat:Unit
  }


  //  val animal = new Animal ///

  class Dog extends  Animal {
    override val creatureType: String = "Optimistic"

    override def eat: Unit = println("print mew mew")
  }

  val dog = new Dog
  println(dog.creatureType)
  dog.eat
  /// traits --> ultimate // can have abstract methods
  trait Carnivore{
    def eat(animal: Animal): Unit

  }
  trait Coldblooded

  class Crocodile extends  Animal with Carnivore{
    override val creatureType: String ="croc"

    override def eat: Unit = "Nom Nom"

    override def eat(animal: Animal): Unit = println(s"I'm animal and I'm eating ${animal.creatureType}")
  }

  val croc=  new Crocodile
  croc.eat(dog)

  // traits vs abstract classes .
  // 1- traits don't have constructor parameters
  // 2- multiple traits may be inherited by the class
  // 3- traits are behaviors, abstract class is a type of thing


  // type hierarchy  --> nothing-> nothing of anytype at all .





}
