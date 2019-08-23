package connectors

import javax.inject.{Inject, Singleton}
import models.{Order, Orders}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.db.NamedDatabase
import slick.jdbc.JdbcProfile

import scala.concurrent.Future

@Singleton
class ShopDbConnector @Inject()(@NamedDatabase("shop") protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import dbConfig.profile.api._

  def save(order: Order) = {
    val query = Orders.tableQuery += order
    db.run(query)
  }

  def all: Future[Seq[Order]] = {
    val query = Orders.tableQuery.result
    db run query
  }


}
