package lectures.Part02OOP

import playground.{Cindrella, PrinceCharming}

import java.sql
import java.util.Date   // import them form another package

object PackagingAndImports extends App{

  /// packages  -->
//  package package_name
  // members inside the package can be accessed using package name

  val writer = new Writer("Noha" ,"Shehab",1992)

  val princess = new Cindrella
  // or package with class name .
  val princess2 = new Cindrella

  // packages are in hierarchy
  // matching folder structure

  // Specific scala structure  --> package objects
  // write methods, values outside classes
  // package object

  sayHello
  println(SPEED_OF_Light)

  // imports
  val prince = new PrinceCharming

  val date = new Date
  val sqlDate = new sql.Date(2020,5,4)

  /// default imports
  // java.lang -- string object exceptions
  // package a group of definitions under the same name

  // best practice --? mirror the structure


}
