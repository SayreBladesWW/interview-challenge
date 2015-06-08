package services

import scala.concurrent.Future

/**
 * This is a stub implementation
 * Please DO NOT MODIFY
 */

case class Quote(symbol: String, date: java.util.Date, price: Double)

trait QuoteService {
  def getQuote(symbol: String): Future[Quote]
}

class MockQuoteService extends QuoteService {

  def getQuote(symbol: String): Future[Quote] = {
    // This accounts for network latency
    Thread.sleep(2000)

    symbol match {
      case "AAPL" => Future {Quote("AAPL", new java.util.Date, 105.5)}
    }
  }

}
