package lectures.Part01basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  def factorialFunction (n: Int): Int={
    if (n==1) n
    else{
      println("computing factorial of " + n +
        "I need first to calculate the factorial of "+ (n-1))
      val res = n * factorialFunction(n-1)
      println("computed factorial of " + (n-1))
      res
     }
  }
  println(factorialFunction(5))  // will give 120 at the end

//  println(factorialFunction(5000))  //stack overflow error  // recursion introduces errors here !!!

  // define another factorial
  def anthorFactorialFunction (n: Int): BigInt = {
    @tailrec  /// more search
    def factorialHelper (n: Int, accumlator: BigInt): BigInt = {
      if (n<=1) accumlator
      else factorialHelper(n-1, n*accumlator)
    }
    factorialHelper(n,1)
  }

//  println(anthorFactorialFunction(5000));  // when you need loops use tailrec -- tail recursion

  ///////// recursion functions
  /*
  * Contcat string n times
  * */
  @tailrec
  def concatStr(str: String, ntimes: Int,accumaltor: String):String = {

    if(ntimes <= 0) accumaltor
    else concatStr(str,ntimes-1, accumaltor + str)
  }

  println(concatStr("welcome noha ",4,""))


  /*** is prime function ***/
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t:Int, isStillPrime: Boolean):Boolean={
      if(!isStillPrime)false
      else if(t<=1)true
      else isPrimeHelper(t-1,n %t != 0 && isStillPrime)
    }
    isPrimeHelper(n/2, true)
  }
  println(isPrime(55))

  /*** is febonacci ***/

  def febonacci(n: Int):Int = {
    @tailrec
    def feboTail(i: Int, last: Int, nextLast: Int): Int={
      if(i>=n)last
      else feboTail(i + 1, last + nextLast, last)
    }
    if (n <2 ) 1
    else feboTail(2,1,1)
  }

  println(febonacci(10))

}
