package org.project2.tweeter_type2;

import org.junit.jupiter.api.Test;
import org.project2.tweeter_type2.model.Message;
import org.project2.tweeter_type2.services.MessageServices;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TweeterType2ApplicationTests {
	private MessageServices messageServices;
	@Test
	void contextLoads() {
	}
	@Test
	void save(){
		Message message = new Message();
		message.setId(2);
		message.setText("Hello World");
		message.setTag("test");
		messageServices.save(message);
	}

}
