package books.hj

import scala.collection.Searching._

object chapter1 extends App {

  //Write a Method to search an unsorted array

  def exists(array:Array[Int], search: Option[Int]): Boolean = {
    search match {
      case None => false
      case Some(x) => array.contains(x)
    }
  }

  println(exists(Array(1,4, 9000), Some(4)))

  //library within scala collection, the input must be a sorted array or else the results are unpredictable..
  def existsWithLibrary(array:Array[Int], search: Option[Int]): Boolean = {
    array.search(search.get) match {
      case Found(foundIndex) => true
      case _ => false
    }
  }


}
