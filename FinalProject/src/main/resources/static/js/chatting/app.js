var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    //return current value, cf.attr
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}
<script type="text/javascript">
//웹소켓을 사용할 수 있도록 페이지 로딩 완료 시 웹소켓 초기화
document.addEventListener("DOMContentLoaded", function(){
	WebSocket.init();
});
//웹소켓 설정
var WebSocket = (function(){
	var stompClient;
	var textArea = document.getElementById("chatOutput");
	//메세지화면
	var inputElm = document.getElementById("chatInput");
	//입력란
	var sendbtn = document.getElementById("sendbtn");
	//전송버튼
	var outroombtn = document.getElementById("outroom");
	//나가기버튼
	var usersessionid = document.getElementById("sessionuserid");
	//세션id
	var chatoutaddress = document.getElementById("chatoutaddress");
	//<input type="hidden" value='${chatoutaddress}' id="chatoutaddress">
	
function connect() {
    var socket = new SockJS('/websocket');
    //sockjs,stomp client를 통해 연결시도
    stompClient = Stomp.over(socket);
	stompClient.connect({}, function(){
		//메세지를 받는다. 각각의 구독으로~
		stompClient.subscribe('/topic/greetings', function(msg){
			printMessage(JSON.parse(msg.body).sendMessage + '/' + JSON.parse(msg.body).email);
		});
		//사용자 아이디 파싱~
		stompClient.subscribe('/topic/out', function(msg){
			printMessage(msg.body);
		});
		//방나가기
		stompClient.subscribe('/topic/in', function(msg){
			printMessage(msg.body);
		});
		//방들어오기
		
		//입장글
		stompClient.send("/app/in", {}, usersessionid.value + ' 님이 입장하셨습니다.');
	});
	//연결끊기
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
//메세지 전송 버튼 이벤트//
sendbtn.onclick = function(){
	sendMessage(inputElm.value);
	clear(inputElm);
}

//채팅방 나가기 버튼 이벤트//
outroombtn.onclick = function(){
	disconnect();
}

function printMessage(message){
	textArea.value += message + "\n";
}
//입력창 초기화//
function clear(input){
	input.value = "";	
}
//메세지전송
function chatContent(text) {
	//json파라미터를 msg body로 전송
    stompClient.send("/app/hello", {}, JSON.stringify({'chatContent': $("#email").usersessionid.value()}));
    //stringfy(전송할 데이터를 json형태로 만듦)로 vo와 매핑 -> subscribe info,msg handler 주소 매핑 
}
//초기화//
function init(){
	connect();
}

return {
	init : init
}
})();


/*function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});*/
