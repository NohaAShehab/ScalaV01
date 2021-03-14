package lectures.Part02OOP

import java.io.Writer

object Novel extends  App{
  val author = new Writer("Mostafa", "Sadek", 1890)
  val author2 = new Writer("Mostafa", "Sadek", 1890)

  val novel= new Novel("Awraa El Ward", 1900, author)

//  println(novel.authorAge)
//  println(novel.isWrittenBy(author))
//  println(novel.isWrittenBy(author2))

  val counter = new Counter
  counter.inc  // return an object of the counter type
  counter.inc
  counter.inc
  counter.print
  counter.inc.inc.inc.print

  counter.inc(10).print

}

class Writer (firstName: String, lastName: String, var birthYear: Int){
  def fullName:String= firstName+ " "+ lastName
}

class Novel (name:String, year: Int, author: Writer){
  def authorAge= year - author.birthYear
  def isWrittenBy(author:Writer)= author== this.author  // print what
  def copy(newYear: Int):Novel= new Novel(name,newYear, author)
}

//class Counter(n: Int){
//  def count =n // return the current count .. .// getter

class Counter (val count : Int = 0){
  def inc:Counter = {
    println("incrementing")
    new Counter(count+1)
  } // imutability


  def dec:Counter = {
    println("decrementing")
    new Counter(count-1)
  } //

  def inc(n: Int):Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  } // imutability

  def dec(n: Int):Counter = {
    if (n <=  0) this
    else dec.dec(n-1)
  } // imutability

  def print: Unit= println(count)
}

