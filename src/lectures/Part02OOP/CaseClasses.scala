package lectures.Part02OOP

object CaseClasses extends App{

  // scala specific concepts

  // re-implement equals, hashCode, toString
  case class Person(name: String, age: Int)


  ///1- class params are fields
  val noha = new Person("Noha", 28)
  println(noha.name)

  // 2- sensible string
  println(noha.toString)
  println(noha)  // will print its content

  // 3- equals and hashcode implemented
  val noh2 = new Person("Noha", 28)
  println(noha== noh2)

  // 4- CCs have handy copy method
  val noha3 = noha.copy(age=29)
  println(noha3)

  // 5- CCs have  companion
  val thePerson = Person
  val test =thePerson.apply("Campanion", 29)
  println(test)
  val fatma = Person("Fatma", 29)
  println(fatma)

  // 6- CCs are serializable
  // Methods are case classes AKKA

  // 7- CCs has extractor patterns --> pattern matching

  // case object
  case object UnitedKingdom{
    def name: String = "jkhjkh"
  }

  val s = UnitedKingdom
  println(s.name)

}
