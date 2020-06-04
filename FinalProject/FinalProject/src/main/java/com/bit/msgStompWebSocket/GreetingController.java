package com.bit.msgStompWebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

public class GreetingController {

	  @MessageMapping("/hello")
	  @SendTo("/topic/greetings")
	  public GreetingTest greeting(HelloMsgTest message) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new GreetingTest("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	  }

}
