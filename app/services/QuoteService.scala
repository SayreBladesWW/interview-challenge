package services

import java.util.Date

import scala.concurrent.{ExecutionContext, Future}

/**
 * This is a stub implementation
 * Please DO NOT MODIFY
 */

case class Quote(symbol: String, date: Date, price: Double)

trait QuoteService {
  def getQuote(symbol: String, date:Date): Future[Quote]
}

class MockQuoteService(executionContext: ExecutionContext) extends QuoteService {

  implicit val ec = executionContext

  def getQuote(symbol: String, date:Date): Future[Quote] = {
    // This accounts for network latency
    Thread.sleep(2000)

    symbol match {
      case "AAPL" => Future {Quote("AAPL", date, 105.5)}
    }
  }

}
