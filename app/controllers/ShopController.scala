package controllers

import connectors.ShopDbConnector
import models.Implicits._
import javax.inject._
import models.Order
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class ShopController @Inject()(cc: ControllerComponents, shop: ShopDbConnector)
                              (implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    shop.all.map { orders =>
      Ok(Json.toJson(orders))
    }
  }

  def insert() = Action.async(parse.json[Order]) { implicit request: Request[Order] =>
    shop.save(request.body).map { n =>
      Ok(Json.obj("result" -> n))
    }
  }

}
