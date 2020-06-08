package com.bit.controller.space;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.model.vo.ChattingVO;
@Controller
public class ChatController {
    @GetMapping("/chatting")
    public String getWebSocketBroadcast() {
        return "chatting";
    }
		@MessageMapping("/HelloMsgTest") //requestMapping
		@SendTo("topic/ChattingVO") //전달받을 subscribe, 목적지구별
		 public ChattingVO send(ChattingVO ChattingVO) throws Exception {
			return new ChattingVO();
		}

}
