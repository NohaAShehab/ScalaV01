package lectures.Part02OOP
import scala.language.postfixOps

object methodNotations extends App{

  class Person (val name:String, favouriteMovie: String){
    def likes(movie: String): Boolean=  movie == favouriteMovie
    def hangOutWith(person: Person) : String=
      s"${this.name} is hangingout  with ${person.name}"

    // let us use + as the name of the function !!
    def +(person: Person) : String=
      s"${this.name} is hangingout  with ${person.name}"

    def unary_! : String = s"What is the hack ${name}"
    def isAlive : Boolean = true

    def apply() : String = s"My name is ${name} and I love ${favouriteMovie}"
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
}
