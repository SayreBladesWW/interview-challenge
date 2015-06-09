package services

import scala.concurrent.{ExecutionContext, Future}
import java.util.Date

/**
 * This is a stub implementation
 * Please DO NOT MODIFY
 */

case class SymbolShares(symbol: String, date: Date, numberOfShares: Int)

trait SharesService {
  def getSharesOutstanding(symbol: String, date: Date): Future[SymbolShares]
}

class MockSharesService(executionContext: ExecutionContext) extends SharesService {

  implicit val ec = executionContext
  
  def getSharesOutstanding(symbol: String, date:Date): Future[SymbolShares] = {
    // This accounts for network latency
    Thread.sleep(3000)

    symbol match {
      case "AAPL" => Future {SymbolShares("AAPL", date, 5500)}
    }
  }

}
