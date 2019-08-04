package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

class ShopControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "ShopController GET" should {

    "render the index page from the application" in {
      val controller = inject[ShopController]
      val home = controller.index().apply(FakeRequest(GET, "/"))

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")

    }

    "render the index page from the router" in {
      val request = FakeRequest(GET, "/")
      val home = route(app, request).get

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")

    }
  }
}
