package lectures.Part01basics

import javax.lang.model.element.NestingKind

object Functions extends App {

  // define function
  def aFunction(a: String, b: Int): String = {
    // expression block
    println("welcome to the function block")
    a + " " +b  // return expression will evaluate to string.
  }
  println(aFunction("welcome a function ", 23))

  /////////////////////////////////////////////////////////
  def bFunction (a: String, b:Int) :String= a + " " + b

  println(bFunction("welcome b func", 23))

  ////////////
  def aParameterLessFunction(): Int= 40
  println(aParameterLessFunction())

  /// repeated function ////////////////////////////////
  def aRepeatedFunction (astring: String, n: Int): String= {
    if(n==1) astring
    else astring + aRepeatedFunction(astring,n-1)  // function called itself (recursive)
  }

  println(aRepeatedFunction("hello world ",3))
  /* in regular lang, you will loops in scala, functional lang. you will use recursive calling for the functions
  * when you need to use loops use recursion
  *
  * */

  /***** function return type */
  def cFunction (a: Int, b: Int)={
    a+b   // the compiler will guess the return type itself
  }
  println(cFunction(4,5))

  /****************** Without a return type but recursive ? *************/

//  def dFunction (a: Int, b: Int)={
//    if(b==1) "end of iterations"
//    else a + dFunction(6,b-1)
//
//  }
//  println(dFunction(4,5))

  /****************************** function may return a unit*********************/

    def eFunction (aString: String)= println(aString)

    var res= eFunction("Noha Shehab")  // will print NohaShehab
    // println(res)   #useless line

    /*******************  Function inside a function *******************/
    def aBigFunction(n: Int): Int={
      def aSmallFunction (a: Int, b: Int): Int= a +b
      aSmallFunction(n,n-1)
    }

  }
