package lectures.Part02OOP

object Inheritance extends App{

  /// single inheritance
  class Animal {

    val creatureType="wild"
    val noOfLegs = 4
    // private, protected and no modifier--- called public
    protected def eat: Unit= println("nummm num")
  }

  class Cat extends Animal {
    def crunch= {
      eat
    }
  }

  val cat = new Cat
  cat.crunch
  ///////////////////////  Extending class with param///////////////////////
  class Person(name: String, age: Int){
    def this() = this("Noha",28)
    def this(name: String)= this(name,28)
    override def toString: String = s"($name,$age)"
  }

  class Adult(name: String, age: Int) extends Person(name, age ){}
  val p2 = new Adult("Mostafa", 29)
  println("Person1")
  println(p2.toString)

  class Adult1(name: String, age: Int) extends Person(){}
  val p3 = new Adult1("Omar", 4)
  println("Person2")
  println(p3.toString)


  class Adult2() extends Person(){}
  val p4 = new Adult2()
  println("Person3")
  println(p3.toString)

//  class Adult(name: String, age: Int) extends Person{}// error for not defining the const

  /// overriding
//  class Dog extends Animal{
//    /// override param
//    override val creatureType: String = "demostic"
//    override protected def eat: Unit = println("crunch crunch crunch")
//  }
//
//  val dog = new Dog
//  println(dog.creatureType )
    /////////////////////////////////////////////////////////////////
    class Dog (override val creatureType: String ) extends Animal{
      /// override param
//      override val creatureType: String = "demostic"
      override def eat: Unit = println("crunch crunch crunch")
    }

    val dog = new Dog("Optimistic")
    println(dog.creatureType )

    // type substitution (polymorphism)
    val unknownAnimal = new Dog("K9")
    unknownAnimal.eat
  ////////////////////////////////////////////
  //    overriding , overloadig

      // super

      class Horse extends Animal{
        override def eat: Unit = {
          super.eat
          println("cum cum cum ")
        }
      }

      val horse = new Horse
      horse.eat

      // preventing override
      // using keyword final
      //      final --> class prevent extending
      //      final --> method --> overriding

      class Animal2 {
        val creatureType= "wild"
         final def eat = println("nom nom")
      }

      class Cat2 extends Animal2{
//        override eat /// wouldn't work
      }




      // sealed class--> can extend class in this file only -->


      sealed class Parent {

      }

      class Child extends Parent{

      }







}
