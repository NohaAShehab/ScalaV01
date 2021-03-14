package lectures.Part01basics

object ValuesVariablesTypes extends App {

  println("first scala value")
  val x: Int = 30
  println(x)
  // values are immutable cannot be re-assigned after creations
  //  x= 100  # will not work ...
  val y = 80
  println(y)

  /* Strings */
  val name: String = "Noha"
  println(name)
  val coursename = "scala"  // will not accept single qoutes
  println(coursename)

  /* Boolean */
  val booleanval: Boolean= true
  println(booleanval)
  val booleanval2 = false
  println(booleanval2)

  /* characters */
  val chartype: Char= 'a'  // chars are with single qoutes
  println(chartype)

  /*short*/
  val shortval: Short = 3377// only on 4 bits
  val longval: Long= 321423523
  val doubleval: Double= 2334.5345
  val floatval: Float=2.333f   // to represent flaot from the double

  /******************************** Variables *******************************************/
  /* variables are non-imutable */
  /* can be changed according the script */
  var intvariable: Int= 2020
  println(intvariable)
  intvariable=2021
  println(intvariable)



}
