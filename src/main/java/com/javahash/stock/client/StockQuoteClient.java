package com.javahash.stock.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.javahash.stock.GetQuote;
import com.javahash.stock.GetQuoteResponse;

public class StockQuoteClient extends WebServiceGatewaySupport {

	public GetQuoteResponse stockQuote(String company) {

		GetQuote quote = new GetQuote();
		quote.setSymbol(company);

		GetQuoteResponse quoteResp = (GetQuoteResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						quote,
						new SoapActionCallback(
								"http://www.webserviceX.NET/GetQuote"));
		return quoteResp;

	}
	public void printResp(GetQuoteResponse res) {
		String data=res.getGetQuoteResult();
		System.out.println("stock quote response :");
		System.out.println(data);
	}

}
