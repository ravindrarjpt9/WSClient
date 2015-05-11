package com.javahash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.javahash.stock.client.StockQuoteClient;

@Configuration
public class ServiceConfig {
	
  @Bean	
  public Jaxb2Marshaller getMarshaller(){
	  Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	  marshaller.setContextPath("com.javahash.stock");
	  return marshaller;
  }
  
  @Bean
  public StockQuoteClient getStockClient(){
	  
	  StockQuoteClient wsclient=new StockQuoteClient();
	  wsclient.setMarshaller(getMarshaller());
	  wsclient.setUnmarshaller(getMarshaller());
	  wsclient.setDefaultUri("http://www.webservicex.net/stockquote.asmx");
	  return wsclient;
  }
}
