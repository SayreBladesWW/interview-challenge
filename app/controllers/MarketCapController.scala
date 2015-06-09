package controllers

import play.api.mvc.Controller
import services.{SharesService, MockQuoteService, MockSharesService, QuoteService}

import scala.concurrent.ExecutionContext

trait MarketCapController {
  this: Controller =>

  // dependencies
  implicit val ec:ExecutionContext
  val quoteService:QuoteService
  val sharesService:SharesService

  /**
   * This method should calculate the market capitalization of the given symbol for
   * the (last) price on the provided day.  Market cap is calculated simply as
   * (price * number of shares).  Data to calculate this is provided by the QuoteService
   * and SharesService.  If the inputs are invalid please return the proper http
   * response.
   *
   * @param symbol string, one of "MSFT","WTW","GOOG","AAPL"
   * @param date string, valid ISO 8601 local date
   * @return If successful, the result
   *         should be a 200 level code with a json message body that looks like:
   *         {
   *            "symbol":"MSFT",
   *            "marketcap":373,452,957.78
   *         }
   */
  def get(symbol:String, date:String) = TODO
}

class MarketCapControllerImpl extends MarketCapController with Controller {
  val ec = play.api.libs.concurrent.Execution.Implicits.defaultContext
  val quoteService = new MockQuoteService(ec)
  val sharesService = new MockSharesService(ec)
}
