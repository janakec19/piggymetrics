package com.piggymetrics.account.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.piggymetrics.account.domain.Account;

@FeignClient(name = "statistics-service", fallbackFactory = StatisticsServiceClientFallback.class)
public interface StatisticsServiceClient {

	@RequestMapping(method = RequestMethod.PUT, value = "/statistics/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void updateStatistics(@PathVariable("accountName") String accountName, Account account);

	@RequestMapping(value = "/statistics/{accountName}", method = RequestMethod.GET)
	public Object getStatisticsByAccountName(@PathVariable String accountName); 
}
