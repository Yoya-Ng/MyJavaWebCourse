
package jrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Path("/exchange")
public class ExchangeRS {
    
    @GET
    @Path("/{symbol}")
    //http://localhost:8084/MyJavaWebCourse/jrest/exchange/USDTWD=x 透過URL換匯
    public String sayStock(@PathParam("symbol") String symbol) {
        double price =0;
         try {
            Stock stock = YahooFinance.get(symbol);
            price = stock.getQuote().getPrice().doubleValue();
        } catch (Exception e) {
        }
        return symbol +" -> "+ price;
    }
}
