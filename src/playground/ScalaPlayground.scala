package playground

import scala.annotation.tailrec

object ScalaPlayground extends App{

  println("Hello Scalaaaaaaaaa ")

  /////// greeting function (name, age) -> "Hi, My name is $name and I am $age years old"
  def greetingFunction(name: String, age: Int): String ={
    "Hi My name is "+ name + " and I am "+ age + " years old :)"
  }
  println(greetingFunction("Noha",28))

  ///////////  factorial function 1*2*3*.......*n
  def factorialFunction (n: Int): Int={
    if (n==1) n
    else n * factorialFunction(n-1)
  }
  println(factorialFunction(5))
  ///////////////////////////////////
  /* fibonacci function f(1), f(2)=1
  * f(n)= f(n-1) + f(n-2)FebonacciFunction
  *
  * */
  def FebonacciFunction (n: Int): Int ={
    if(n ==1 || n==2 ) 1
    else FebonacciFunction(n-1) + FebonacciFunction(n-2)
  }

  println(FebonacciFunction(10))

  //////////////// prime number
  def TestPrimeNumberFunction(n: Int): Boolean= {
    def IsPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && IsPrimeUntil(t - 1)
    }
    IsPrimeUntil(n / 2)
  }
  println(TestPrimeNumberFunction(7))
  println(TestPrimeNumberFunction(35))




}
