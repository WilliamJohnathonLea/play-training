package controllers

import connectors.ShopDbConnector
import models.Implicits._
import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class ShopController @Inject()(cc: ControllerComponents, shop: ShopDbConnector)
                              (implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok
  }

}
