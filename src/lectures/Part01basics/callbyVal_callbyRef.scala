package lectures.Part01basics

object callbyVal_callbyRef extends App {
  // call by name === call by ref

  def callByValue(x: Long): Unit = {
    println("call by value " + x)
    println("call by value " + x)
  }
  def callByRef(x: => Long): Unit = {
    println("call by value " + x)
    println("call by value " +x)
  }
  //// the value itself is sent
 callByValue(System.nanoTime)
  //// the function is executed every time the value is called.
 callByRef(System.nanoTime)

}
