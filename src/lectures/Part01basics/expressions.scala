package lectures.Part01basics

object expressions extends App {
  /* math expressions
  *
  *  + - * / ^ | << >> >>> (right shift with zero extension)
  * */
  val x = 1+2  // expression
  println(x)

  val y= 1.222 * 23.444
  println(y)

  val z= 3*4+5
  println(z)
  val z2= 3+4*5
  println(z2)

  val z3= 3+5*5+(3+4)
  println(z3)

  var num1 = 5
  num1+=2
  println(num1)
  println(num1==5)
  println(7==num1)

  /* Instructions vs Expressions value */
  // IF expression
  val aCondition = true
  val aConditionvalue = if(aCondition) "trueeee" else 3 // IF Expression
  println(aConditionvalue)
  println(1 + 3)
  var i = 0
  while (i <10){
    println(i)
    i +=1
  }


  /************* Everything in scala is an expression *******************/
  var aVariable=10
  val aWeirdValue= (aVariable =3 )  // unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // code blocks  variable scope
  val aCodeBlock= {
    val y= 2
    val z= y + 1
    if( x > 2 ) "Hello world" else "goodbye"
  }

  // 1.difference between "hello world" vs println("hello world")?
  /*
  * hello world is a value of type string
  * while inside println () --> a side the effect the returned value (output of the function)
  *
  * */
  // this is a code block
  val someValue ={
    2 < 3  /// this is the result
  }
  val someothervalue = {
    if (someValue) 239 else 986
    42  // this is the value of this block
  }

  println(someothervalue)


}
