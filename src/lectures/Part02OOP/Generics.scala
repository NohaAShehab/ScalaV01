package lectures.Part02OOP

object Generics extends App {

  // linked list

  // generic
//  class MyList[A]{ /// type A inside the class definition
////
////  }
  class MyList[+A]{
    /// type A inside the class definition
    def add [B >: A](element : B): MyList[B] = ??? // coveriant tye
    /*
    * A= Cat
    * B= Dog
    * */


  }
  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  class MyMap[key, value]

  // generic methods // class takes a type parameter
  object Mylist {
    // generic method
    def empty[A]: MyList[A] = ???

  }

  /// variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  // if cat extends animal does list of cats extends animal?
  // yes list[Cat] extends animal == Covariance
  class CovariantList[+A]
  val animal: Animal= new Cat
  val animalList: CovariantList[Animal]= new CovariantList[Cat]
  // animalList.add(new dog)  --> will turn the list to list of elements

  /// 2- no  invariance
  class InvariantLis[A] // cannot substitute one for another
  val invariantList : InvariantLis[Animal] = new InvariantLis[Animal]

  /// 3- Hell, No. Contra variance
  // how can we replace a cat with an animal !!!
//  class ContraVarianceList [-A]
//  val contraVarianceList: ContraVarianceList[Cat] = new ContraVarianceList[Animal]
  class Trainer [-A]
  val tranier: Trainer[Cat] = new Trainer[Animal]
  /// trainer of cat can be a trainer of dog


  //////////
  // bounded types
  //
  class Cage[A <: Animal]  (animal: A)
  // <: child
  // >: super type
  // class cage would accept types which are subtypes of animal
  val cage = new Cage (new Dog)

  class Car
  //val newCage= new Cage (new Car)/// will give compile error

  ////////////////////////////////////


  // expand mylist to be generic




}
