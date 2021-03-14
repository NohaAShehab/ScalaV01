package exercise

import scala.runtime.Nothing$

abstract class MyListGeneric[+A]{
  /*
  * head = first element of the list
  * tail = remainder of the list
  * isEmptyGeneric = is the list EmptyGeneric
  * add (int) ==> new list with this element added.
  * toString ==> a string representation of the list
  * */

  def head: A
  def tail: MyListGeneric[A]
  def isEmptyGeneric:Boolean
  def add[B >: A] (element: B): MyListGeneric[B]
  def printElements: String
  override def toString :String = "["+ printElements +"]"

}
// EmptyGeneric list will be an object
object EmptyGeneric extends MyListGeneric[Nothing] {
  /// ???
  def head: Nothing = throw new NoSuchElementException/// this expression represent nothing
  def tail: MyListGeneric[Nothing] = throw new NoSuchElementException
  def isEmptyGeneric:Boolean = true
  def add [B >: Nothing](element: B): MyListGeneric[B] = new ConsGeneric(element, EmptyGeneric)
  override def printElements: String = ""
}

// this ConsGeneric object will represent the non EmptyGeneric list
// h for head, t for tail
class ConsGeneric[+A](h: A, t: MyListGeneric[A])extends MyListGeneric[A]{
  def head: A = h
  def tail: MyListGeneric[A] = t
  def isEmptyGeneric:Boolean = false
  def add [B >: A] (element: B): MyListGeneric[B] = new ConsGeneric(element, this)

  // element to be added to this list.
  override def printElements: String =
    if(t.isEmptyGeneric) "" + h
    else h+ " "+ t.printElements
}

object ListTestGeneric extends App{

  val listOfIntegers: MyListGeneric[Int] = new ConsGeneric(1, new ConsGeneric(2, new ConsGeneric(3, EmptyGeneric)))
  val listOfStrings: MyListGeneric[String] = new ConsGeneric("Hello", new ConsGeneric("Scala", new ConsGeneric("World", EmptyGeneric)))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}