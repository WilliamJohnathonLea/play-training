package models

import play.api.libs.json.{Format, Json}

object Implicits {

  implicit val orderFormat: Format[Order] = Json.format[Order]
  
}
