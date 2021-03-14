package lectures.Part02OOP

import scala.language.postfixOps

object methodNotationsExersise extends App{

  class Person (val name:String, favouriteMovie: String, var age: Int = 0){
    def likes(movie: String): Boolean=  movie == favouriteMovie
    def hangOutWith(person: Person) : String=
      s"${this.name} is hangingout  with ${person.name}"

    // let us use + as the name of the function !!
    def +(person: Person) : String=
      s"${this.name} is hangingout  with ${person.name}"

    def unary_! : String = s"What is the hack ${name}"
    def isAlive : Boolean = true

    def apply() : String = s"My name is ${name} and I love ${favouriteMovie}"

    /// exersise

    def +(nickName: String) : Person =
      new Person(s"${name} (${nickName})", this.favouriteMovie)

    // increment age
    def unary_+ : Person = new Person(this.name, this.favouriteMovie, this.age+1)

    // learns method
    def learns (something : String) : String = s"$name is learning $something"
    ///
    def learnsScala(): String= this learns "Scala"

    /// 4
    def apply(n: Int) : String = s"$name watched ${favouriteMovie} ${n} times"
  }

  val noha= new Person("Noha", "Monsters. Inc")
  println(noha.likes("finding dory"))
  println(noha.likes("Monsters. Inc"))
  /// what is coooooool ! ^^
  println(noha likes "Monsters. Inc")  // method notations
  // infix notation == operator notation
  val fatma=  new Person("Fatma", "Finding Nemo")
  println(noha hangOutWith fatma)
  // see this
  /// infix notation // syntatic sugar
  println(noha + fatma)
  println(noha.+(fatma))
  // see this also
  // all operators are methods


  println(1 + 2)
  println(1.+(2))
  println(3.+(4))


  ////// prefix
  val x = -1
  val y= 1.unary_- /// same as -1

  println(noha.unary_!)

  // method that doesn't accepts parameter can be used as postfix notation
  // using postfix require including import scala.language.postfixOps
  println(noha isAlive)
  /// check this .....
  println(noha.apply())
  println(noha())

  /// println
  // Ex-1
//  println(noha + "Nonna")  // returns an object with person type
  println((noha + "Nonna")())
  println((noha + "Nonna").apply())


  // Ex-2  add age to the person class // prefix
  println((+noha).age)

  // postfix
  println(noha learnsScala)  // noha is learning scala

  println(noha(10))



}
