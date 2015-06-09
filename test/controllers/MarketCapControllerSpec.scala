package controllers

import play.api.libs.json.Json
import play.api.mvc.Controller
import play.api.test.Helpers.defaultAwaitTimeout
import play.api.test.{ FakeRequest, Helpers }
import org.scalatest._
import services.{MockSharesService, MockQuoteService}

class MarketCapControllerSpec
  extends WordSpec
  with Matchers
  with MarketCapController
  with Controller {

  val ec = scala.concurrent.ExecutionContext.Implicits.global
  val quoteService = new MockQuoteService(ec)
  val sharesService = new MockSharesService(ec)

  "get" should {
    "calculate the market cap for AAPL on 1/1/2010" in {
      val request = FakeRequest()
      val result = get("AAPL", "2010-01-01")(request)

      //verify status code
      Helpers.status(result) should equal(OK)

      // verify headers
      val headers = Helpers.headers(result)
      headers("ContentType") should be("application/json")

      // verify content
      val expected = """{"symbol":"AAPL", "marketcap":580250.00}"""
      Json.parse(expected) should equal(Helpers.contentAsJson(result))
    }
  }
}
