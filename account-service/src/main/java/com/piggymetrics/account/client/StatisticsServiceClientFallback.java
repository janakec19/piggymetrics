package com.piggymetrics.account.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.piggymetrics.account.domain.Account;

import feign.hystrix.FallbackFactory;

/**
 * @author cdov
 */

@Component
public class StatisticsServiceClientFallback implements FallbackFactory<StatisticsServiceClient> {
	private final Logger log = LoggerFactory.getLogger(getClass());
   
	@Override
    public StatisticsServiceClient create(Throwable cause) {
        return new StatisticsServiceClient() {
           
			@Override
			public void updateStatistics(String accountName, Account account) {
				log.error("update failed fue to {}",cause);
				
			}

			@Override
			public Object getStatisticsByAccountName(String accountName) {
				log.error("get failed fue to {}",cause);
				return null;
			}
        };
    }
}
