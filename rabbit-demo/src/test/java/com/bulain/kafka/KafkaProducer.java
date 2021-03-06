package com.bulain.kafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KafkaApplication.class)
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Test
	public void testProducer() {
		for (int i = 0; i < 10; i++) {
			kafkaTemplate.send("myTopic", "this is a test message " + i);
		}
	}
	
	@Test
	public void testAck() {
		for (int i = 0; i < 10; i++) {
			kafkaTemplate.send("ackTopic", "this is a test message " + i);
		}
	}
	
	@Test
	public void testConcurrent() {
		for (int i = 0; i < 100; i++) {
			kafkaTemplate.send("concurrentTopic", "this is a test message " + i);
		}
	}

}
