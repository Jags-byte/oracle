package com.in28minutes.microservices.currencyexchangeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurrencyExchangeServiceApplicationTests {
	
	@Mock
	CurrencyExchangeRepository repo;

	@Test
	void retrieveExchangeValue() {
		CurrencyExchange currEx = new CurrencyExchange();
		currEx.setConversionMultiple(new BigDecimal(100));
		Mockito.when(repo.findByFromAndTo(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(currEx);
		CurrencyExchange ex = repo.findByFromAndTo("USD", "INR");
		double actualRes = ex.getConversionMultiple().doubleValue();
		assertEquals(100, actualRes);
	}

}
