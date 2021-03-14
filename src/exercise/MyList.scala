package exercise

abstract class MyList {

  /*
  * head = first element of the list
  * tail = remainder of the list
  * isEmpty = is the list empty
  * add (int) ==> new list with this element added.
  * toString ==> a string representation of the list
  * */

  def head: Int
  def tail: MyList
  def isEmpty:Boolean
  def add (element: Int): MyList
  def printElements: String
  override def toString :String = "["+ printElements +"]"

}
// empty list will be an object
object Empty extends MyList {
  /// ???
  def head: Int = throw new NoSuchElementException/// this expression represent nothing
  def tail: MyList = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add (element: Int): MyList = new Cons(element, Empty)
  override def printElements: String = ""
}

// this cons object will represent the non empty list
// h for head, t for tail
class Cons (h: Int, t: MyList)extends MyList{
  def head: Int = h
  def tail: MyList = t
  def isEmpty:Boolean = false
  def add (element: Int): MyList = new Cons(element, this)

  // element to be added to this list.
  override def printElements: String =
    if(t.isEmpty) "" + h
    else h+ " "+ t.printElements
}

object ListTest extends App{
//  val list = new Cons(1,Empty)
val list = new Cons(1,new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
 val list2= list.add(5) // return with a new list
  //  val list2 = new
  println(list.isEmpty)
  // polymorphic
  println(list2.toString)
  //  println(list.toString)

  //
}