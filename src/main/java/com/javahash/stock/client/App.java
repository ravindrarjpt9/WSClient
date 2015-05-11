package com.javahash.stock.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javahash.config.ServiceConfig;
import com.javahash.stock.GetQuoteResponse;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		 
		 
		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
		 ServiceConfig.class);
		 System.out.println(context.getBeanDefinitionCount());
		 StockQuoteClient wsclient = (StockQuoteClient) context
		 .getBean(StockQuoteClient.class);
		 GetQuoteResponse resp = wsclient.stockQuote("IBM");
		 wsclient.printResp(resp);
		 
		 }
}
