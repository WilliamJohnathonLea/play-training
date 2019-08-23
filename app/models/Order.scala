package models

import slick.jdbc.H2Profile.api._

case class Order(id: Int, drink: String, price: Double)

object Orders {

  lazy val tableQuery = TableQuery[Orders]((tag: Tag) => new Orders(tag))

}

class Orders(tag: Tag) extends Table[Order](tag, "orders") {

  override def * = (id, drink, price) <> (Order.tupled, Order.unapply)

  def id = column[Int]("id", O.PrimaryKey)

  def drink = column[String]("drink", O.SqlType("VARCHAR(30)"))

  def price = column[Double]("price")

}
