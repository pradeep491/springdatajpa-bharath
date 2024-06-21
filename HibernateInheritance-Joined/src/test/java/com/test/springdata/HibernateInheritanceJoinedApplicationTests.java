package com.test.springdata;

import com.test.springdata.entities.Cheque;
import com.test.springdata.entities.CreditCard;
import com.test.springdata.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateInheritanceJoinedApplicationTests {

	@Autowired
	private PaymentRepository repo;

	@Test
	void contextLoads() {
	}
	@Test
	public void createCardPayment() {

		CreditCard card = new CreditCard();
		card.setId(123);
		card.setAmount(1000);
		card.setCardnumber("12345678");

		repo.save(card);
	}
	@Test
	public void createChequePayment() {

		Cheque cheque = new Cheque();
		cheque.setId(321);
		cheque.setAmount(2000);
		cheque.setChecknumber("12345678");

		repo.save(cheque);
	}

}
