package com.bit.restController;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.web.bind.annotation.RestController;


import com.bit.model.vo.ChattingVO;


@RestController 
//messageHandler
public class ChatRestController {
	/*
	 * @RequestMapping(value="/chatting", method=RequestMethod.GET) //pathvariable쓸지
	 * 고민 public ModelAndView chat(ChattingVO chattingvo) { ModelAndView mav=new
	 * ModelAndView("chat/chatMain"); mav.addObject("chatMain",chattingvo); return
	 * mav; }
	 */
	@MessageMapping("/hello")
	@SendTo("/topic/roomId")
	public ChattingVO broadcasting(ChattingVO message) throws Exception {
		System.out.println("message: " + message.getChatting());
		return message;
	//index.html의 tbody greetings,app.js의 greetings로 보내줄건데 데이터타입을 vo로
	}
	//mapping 추가해주기 , app.js가서 파싱 수정
	@MessageMapping("/out") //설정한 prefix를 포함하면 /app/hello이다.//
	@SendTo("/topic/out") //전달할려는 곳의 subscribe,stomp에서 현재 구독중인 주소에 매핑하여 전송
	public String outroom(String message) throws Exception{
		System.out.println("out message: " + message);
		return message;
	}
	@MessageMapping("/in") //설정한 prefix를 포함하면 /app/hello이다.//
	@SendTo("/topic/in") //전달할려는 곳의 subscribe//
	public String inroom(String message) throws Exception{
		System.out.println("in message: " + message);
		return message;
	}
}

