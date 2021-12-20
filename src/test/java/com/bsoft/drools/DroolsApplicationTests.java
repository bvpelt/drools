package com.bsoft.drools;

import com.bsoft.drools.domain.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DroolsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test01() {
		OrderRequest orderRequest = new OrderRequest(123, "CARD", 12700, null);
		log.info("Initial orderRequest: {}", orderRequest);

		orderRequest.setDiscount(15);
		log.info("Step 01 - orderRequest: {}", orderRequest);

		log.info("Step 01 - orderRequest price: {}", orderRequest.getPrice());
		Assertions.assertEquals(10795, orderRequest.getPrice());
	}
}
