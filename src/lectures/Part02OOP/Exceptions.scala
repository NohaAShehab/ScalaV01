package lectures.Part02OOP

object Exceptions extends App{

  val x: String = null
  //println(x.length) // will give exceptions // this will crash with a null
  // pointer execptions

  // 1. throw new NullPointerException

  // exceptions are class instances ,,,
//  val aWeriedValue : String=  throw new NullPointerException  // returns with nothing

  // throwable classes  extends the Throwable class
  // Exceptions and errors (with the system) atr the major Throwable subtypes

  //  2. catch exceptions
  def getInt(withException : Boolean): Int =
    if(withException) throw new RuntimeException ("no Int for you")
    else 42
    //  getInt(x)

  val potentialFail =try{
    getInt(true)
  }catch{
  //    case e: RuntimeException => println("Caught a run time exception")
  //    case e: NullPointerException => 43
    case e: RuntimeException => 43

  }finally {
    /// code will be executed, no matter what
    println("Finally")
  }
  //
  println(potentialFail)

  /// 3. how to define your own exception

//  class MyException extends Exception
//  val exception = new MyException
//
//  throw exception

  /*
  *
  * 1. crash application with a OutofMemoryError
  * 2. Crash with SOE error
  * 3. PocketCalculator
  *   - add(x,y)
  *   - substract (x,y)
  *   - multiply (x,y)
  *   - divide (x,y)
  *
  * throw
  *  -overflowException if add (x,y) exceeds Int.MAX_VALUE
  *  - UnderflowException if subtract (x,y) exceeds Int.MAX_VALUE
  *   - math calculation exception by zero
  *
  *
  * */
//    val array = Array.ofDim(Int.MaxValue) /// exceeds memory limit.

//      val infinite : Int = 1 + infinite
//      val nolimit = infinite
//
      class OverFlowException extends RuntimeException
      class UnderFlowException extends RuntimeException
      class MathCalculationException extends RuntimeException ("Divide by 0")

  object PocketCalculator{
        def add(x: Int, y: Int): Int = {
          val result = x + y  /// -2147483639
          if(x > 0  && y < 0 && result < 0 ) throw new OverFlowException
          else if (x < 0 && y <0 && result > 0 ) throw new UnderFlowException
          else result
        }  // exceeed limit

        def subtract(x: Int, y: Int): Int = {
          val result = x - y  /// -2147483639
          if(x > 0  && y < 0 && result < 0 ) throw new OverFlowException
          else if (x < 0 && y > 0 && result > 0 ) throw new UnderFlowException
          else result
        }  // exceeed limit

        def multiply(x: Int, y: Int): Int = {
          val result = x * y  /// -2147483639
          if(x > 0  && y > 0 && result < 0 ) throw new OverFlowException
          else if (x < 0 && y < 0 && result < 0 ) throw new OverFlowException
          else if (x > 0 && y < 0 && result > 0 ) throw new  UnderFlowException
          else if (x < 0 && y > 0 && result > 0 ) throw new  UnderFlowException
          else result
        }  // exceeed limit

        def divide (x: Int, y: Int): Int = {

          if(y == 0 ) throw new MathCalculationException
          else x / y  /// -2147483639
        }  // exceeed limit
      }


//      println(PocketCalculator.add(Int.MaxValue, 10)) // will give -2147483639
      // println(PocketCalculator.divide(2, 0)) // will give -2147483639


}
