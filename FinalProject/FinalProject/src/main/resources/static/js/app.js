var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}
function connect() {
    var socket = new SockJS('/websocket');
    //sockjs,stomp client를 통해 연결시도
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: '+frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
function sendName() {
	//json파라미터를 msg body로 전송
    stompClient.send("/app/", {}, JSON.stringify({'name': $("#name").val()}));
    //stringfy로 vo와 매핑 -> subscribe info,msg handler 주소 매핑 
    
    
}
function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
