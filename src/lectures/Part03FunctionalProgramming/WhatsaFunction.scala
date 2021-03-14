package lectures.Part03FunctionalProgramming

object WhatsAFunction extends App {

  // use the function as the first class element
  // problem: OPP

  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element*2
  }

  println(doubler(2))  // instance of a function like a class
  // can be called like a function

  // function types = Function1[A,B]  --> 22

  val stringToIntConverter = new Function1[String, Int]{
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // function Types ===> Fucntion2[A,B,R] === (A,B) =>R
  // All Scala functions are  objects

  /// Exersise

  //
  // 1- function takes a string and concatenate them
  def concatenator : (String, String) => String = {
    new Function2[String, String, String] {
      override def apply(a: String, b: String): String = a + b
    }
  }
  println(concatenator("hello", "scala"))

  // 2- transform myPredictor and myTransformer into  to function types


  // 3- define a function which takes an int and returns another function which
  // takes an int and returns another int
  // - what is the type of this function
  // - how to do it
  //

//  def supperAdder: Function1[Int, Function1[Int,Int]] =
//    Function1[Int, Function1[Int,Int]]{
//      override def apply (x: Int) : Function1[Int,Int] = new Function1[Int,Int] {
//        override def apply(v1: Int): Int = x + y
//      }
//    }
}

//
trait MyFunction [A, B] {
  def apply (element: A): B /// abstract
}

