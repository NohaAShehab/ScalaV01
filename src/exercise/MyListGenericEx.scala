package exercise


abstract class MyListGenericEx[+A]{
  /*
  * head = first element of the list
  * tail = remainder of the list
  * isEmptyGeneric = is the list EmptyGeneric
  * add (int) ==> new list with this element added.
  * toString ==> a string representation of the list
  * */

  def head: A
  def tail: MyListGenericEx[A]
  def isEmptyGeneric:Boolean
  def add[B >: A] (element: B): MyListGenericEx[B]
  def printElements: String
  override def toString :String = "["+ printElements +"]"

  def map[B](transformer: MyTransformer[A,B]): MyListGenericEx[B]
  def flatMap[B](transformer: MyTransformer[A,MyListGenericEx[B]]):MyListGenericEx[B]
  def filter (predicate: MyPredicate[A]):MyListGenericEx[A]

  def ++[B >: A](list: MyListGenericEx[B]):MyListGenericEx[B]
}
// EmptyGeneric list will be an object
object EmptyGenericEx extends MyListGenericEx[Nothing] {
  /// ???
  def head: Nothing = throw new NoSuchElementException/// this expression represent nothing
  def tail: MyListGenericEx[Nothing] = throw new NoSuchElementException
  def isEmptyGeneric:Boolean = true
  def add [B >: Nothing](element: B): MyListGenericEx[B] = new ConsGenericEx(element, EmptyGenericEx)
  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing,B]): MyListGenericEx[B]= EmptyGenericEx
  def flatMap[B](transformer: MyTransformer[Nothing,MyListGenericEx[B]]):MyListGenericEx[B] =EmptyGenericEx
  def filter (predicate: MyPredicate[Nothing]):MyListGenericEx[Nothing] = EmptyGenericEx

  /// concat
  override def ++[B >: Nothing](list: MyListGenericEx[B]): MyListGenericEx[B] = list
}

// this ConsGenericEx object will represent the non EmptyGeneric list
// h for head, t for tail
class ConsGenericEx[+A](h: A, t: MyListGenericEx[A])extends MyListGenericEx[A]{
  def head: A = h
  def tail: MyListGenericEx[A] = t
  def isEmptyGeneric:Boolean = false
  def add [B >: A] (element: B): MyListGenericEx[B] = new ConsGenericEx(element, this)

  // element to be added to this list.
  override def printElements: String =
    if(t.isEmptyGeneric) "" + h
    else h+ " "+ t.printElements


  /** **
   *
   *Explain
  ***/
  override def map[B](transformer: MyTransformer[A, B]): MyListGenericEx[B] =
    new ConsGenericEx[B](transformer.transform(h), t.map(transformer))

  /** **
   *
   *Explain  [1,2].flatmap(n => [n,n+1])
   * =[1,2] ++ [2].flatMap(n => [n, n+1])
   * =[1,2] ++ [2,3] ++ Empty.flatMap (n => [n, n+1])
   * =[1,2] ++ [2,3] ++ Empty
   ***/
  override def flatMap[B](transformer: MyTransformer[A, MyListGenericEx[B]]): MyListGenericEx[B]
  =transformer.transform(h) ++ t.flatMap(transformer)


  /** **
   *
   *Explain
   ***/
  override def filter(predicate: MyPredicate[A]): MyListGenericEx[A] =
    if (predicate.test(h)) new ConsGenericEx(h, t.filter(predicate))
    else t.filter(predicate) // will not be included

  override def ++[B >: A](list: MyListGenericEx[B]): MyListGenericEx[B]
  = new ConsGenericEx(h,t ++ list)
}



/// traits
trait MyPredicate[-T]{
  def test(element:T):Boolean
}

trait MyTransformer[-A,B]{
  def transform(elem: A): B
}
object ListTestGenericEx extends App{


  val listOfIntegers: MyListGenericEx[Int] = new ConsGenericEx(1, new ConsGenericEx(2, new ConsGenericEx(3, EmptyGenericEx)))

  val anthorlistOfIntegers: MyListGenericEx[Int] = new ConsGenericEx(4, new ConsGenericEx(5, new ConsGenericEx(6, EmptyGenericEx)))
//==
  val listOfStrings: MyListGenericEx[String] = new ConsGenericEx("Hello", new ConsGenericEx("Scala", new ConsGenericEx("World", EmptyGenericEx)))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new MyTransformer[Int,Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }).toString)

  println((anthorlistOfIntegers ++ listOfIntegers).toString)

  println(listOfIntegers.flatMap(transformer = new MyTransformer[Int, MyListGenericEx[Int]] {
    override def transform(elem: Int): MyListGenericEx[Int] = new ConsGenericEx(elem +1, EmptyGenericEx)
  }).toString)


}
