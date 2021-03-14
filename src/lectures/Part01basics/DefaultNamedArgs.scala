package lectures.Part01basics

object DefaultNamedArgs extends App {
  /**   fact , pass the default values **/
  def factorial(n: Int, acc: Int = 1): Int={
    if (n<=1) acc
    else factorial(n-1,n * acc)
  }
  println(factorial(5))

  // default parameters
  def myPicture (ext: String = "png", width: Int = 1024 , height: Int = 3000): Unit ={
      println("saving a picture " + ext + " " + width + " " + height)
    }
  //  myPicture(44 )  // wrong
  myPicture()
  myPicture("ffff")
  myPicture(width = 666) // works
}
