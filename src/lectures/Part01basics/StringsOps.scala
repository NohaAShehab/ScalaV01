package lectures.Part01basics

object StringsOps extends App {

  var courseName= "Scala"
  val str: String= "Welcome to scala string"


  println("char at " + str.charAt(22))
  println("Substr " + str.substring(7, 11))
  println("Split" + str.split(" ").toList)
  println("Start with " + str.startsWith("hello"))
  println("Start with "+ str.startsWith("welcome"))
  println("replace "+ str.replace(" ", "@"))
  println("To lower case "+ str.toLowerCase())
  println("Str lenght "+ str.length())

  /** scala utilities ****/
  val aNumberString= "45"
  val aNumber = aNumberString.toInt
  /************* Prepending  **************/
  val aNumString= "2"
  println('a' +: aNumString :+ 'z')
  /************ Post pending *********/
  println("a" :+ aNumString)
  /************ reverse*********/
  println(str.reverse)
  /************ take a function *********/
  println(str.take(3))

  /***************** str s-Interpolator   ***************/
  var name = "Noha"; val age =17
  val greeting= s"Hello, My name is $name I am $age years old"
  println(greeting)
  val anotherGreetings= s"Hello, My name is $name, "+
    s"I turned to be ${age+1} years old this year :( "
  println(anotherGreetings)



  /*****************  f-Interpolator   ***************/
  val speed = 4.5f
  val readSpeed = f"$name can read $speed%2.2f book per month"
  // 2.2 format float with 2 digit after .
  println(readSpeed)


  /*****************  raw -Interpolator   ***************/

//  println("Give thanks to Allah\nfor the moon and the sky")

  println(raw"Give thanks to Allah \n for the moon and the sky")

  val strMsg = "Give thanks to Allah \n for the moon and the sky......"
  println(raw"$strMsg")



}
