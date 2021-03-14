package lectures.Part02OOP

object Objects extends App{


  // scala doesn't have class level functionality
  object Person {
    // when you define an object person you define an object and its type instance
    // static class level functionality
    // singletone ==> means single instance can refer to this type
    val No_Of_Eyes= 2
    def canfly: Boolean= false
    // factory method
    def apply (father: Person, mother: Person): Person = new Person("babieee")
  }

  class Person(val name: String = "Cloud"){
    // instance level functionality
  }

  println(Person.No_Of_Eyes)
  println(Person.canfly)

  // ... 2 objects from the same object Person are identical
  var noha= Person
  val nonna = Person
  println(noha == nonna)
  var  ifcondition: String = if(noha == nonna) "Are identical refers to the same type"
  else "Not identical "
  println(ifcondition)

  /// .. 2 objects from the same class but not identical
  var person1 = new Person
  var person2 = new Person
  println(person1== person2)


  val omar = Person(person1, person2)

}

