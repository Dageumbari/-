package com.bit.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	//전달되는 데이터 포맷을 ChattingVO로 해주기
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic/");
		//클라이언트로 메세지보낼 때 prefix
		config.setApplicationDestinationPrefixes("/chatView");
		//클라이언트에서 메세지 주고받을 때 prefix
	}
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websockethandler").withSockJS();
		//처음 소켓 연결할 때 endpoint url설정, chatView.js에서 SockJS 생성자로 연결
	}
}
