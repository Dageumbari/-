//$(function(){
	//페이지 로딩시 실행될 함수
	//setOrgName();
//})

//모든 Ajax Post요청에 대해 http 헤더에 SCRF토큰을 설정
//안되는데요..ㅠ
/*var csrfToken = $("meta[name='_csrf']").attr("content") ;
	     var csrfHeader = $("meta[name='_csrf_header']").attr("content") ;
	     alert(csrfToken);
	      $(document).ajaxSend(function (e, xhr, options) {
	          xhr.setRequestHeader(csrfHeader, csrfToken);
	      });*/

$(function() {

	$('.reset-3c756112--orgTab-8d620844').on('click',function(event){
		$.ajax({
			url: "/dashboard/orgNavi"
		}).done(function(data){
			console.log("orgNavi 호출 했을까나...")
		})
	})

	$('#createOrgBtn').on('click', function() {
 
		var orgName = prompt("Your app/company name 조직 이름 넣으쇼");
		
		if(orgName && orgName.length){
			$.ajax({
				url: "/dashboard/createOrg",
				type: "POST",
				data: {
					"dashBoardName" : orgName				
				},
			})
				//dataType: "json", //"json"
				//cache: false,
			.done(function(result){
				//var result = JSON.parse(orgName);
				//if(result.statusCode==200){
					console.log("입력된 조직 이름: "+orgName);
					window.location.href="/dashboard/spaces?dashBoardUrl="+orgName;
					
					//$("#butsave").removeAttr("disabled");
					//$('#fupForm').find('input:text').val('');
					//$("#success").show();
					//$('#success').html('Data added successfully !'); 
			})
			.fail(function(result){
				//console.log("조직 생성 실패"+error);
				alert("다시 시도해주세요.");	
			})

		}else{
			
		}
	});
});

//팀 페이지


$(document).ready(function(){
	$('div[name=teamInfo]').on('click',function(){
		
		var clickedTeam = $(this).attr("id");
		console.log("클릭한 팀: "+clickedTeam);
		
		//모두 한번만 실행 되어야 함....
		
		
		//데이터(팀 코드) 전송 후  리턴값 리스트로 받아 뿌려주기

		$.ajax({
			url : "/dashboard/getTeamCode",
			data : {
				"teamCode" : clickedTeam
			},
			type : "GET",
			dataType : "JSON"
		})
		.done(function(data){
			console.log("팀 코드 보내기 성공")

			var a ='';
			
			$.each(data,function(key,value){
				alert("반복~");
			});
			$('').html(a);
			
		})
		.fail(function(data){
			console.log("팀 코드 보내기 실패~");
		});
		
		
		
	
		
		
		//바디
		var newBody = document.createElement("div");
		document.getElementById(clickedTeam).appendChild(newBody);
		var attrBody = document.createAttribute("class");
		attrBody.value = "reset-3c756112--panelBody-19b86669--dark-9f89be6e--medium-b7383e74--withScrollbar-39338630--scrollAxisY-7680295e--teamPanelMembers-c72ef26c"
		newBody.setAttributeNode(attrBody);
		
		//바디 - 멤버 패널
		var newPanel = document.createElement("div");
		newBody.appendChild(newPanel);
		var attrPanel = document.createAttribute("class");
		attrPanel.value = "reset-3c756112--teamPanelMembersGrid-4c5fa14c";
		newPanel.setAttributeNode(attrPanel);
		
		//바디 - 멤버 패널 - 멤버 리스트
		//이프문으로 컨트롤러 값 가져와서 리스트 뽑아주기
		var newMembers = document.createElement("div");
		newPanel.appendChild(newMembers);
		var attrMembers = document.createAttribute("class");
		attrMembers.value = "reset-3c756112--S400Top-02771c54--teamPanelMembersGridItem-e5314f8c";
		newMembers.setAttributeNode(attrMembers);
		newMembers.setAttribute("id","memberList");
		
		var newMember1 = document.createElement("div");
		newMembers.appendChild(newMember1);
		var attrMember = document.createAttribute("class");
		attrMember.value = "reset-3c756112--teamPanelMember-2f79c7a6--teamPanelMemberClickable-a079aa82";
		newMember1.setAttributeNode(attrMember);
		newMember1.setAttribute("type","button");
		
		var newMember2 = document.createElement("div");
		newMember1.appendChild(newMember2);
		var attrMember2 = document.createAttribute("class");
		attrMember2.value = "reset-3c756112--tooltipContainer-7fdb9b70--large-8e58dfee--circle-6c5acd10";
		newMember2.setAttributeNode(attrMember2);

		var newMember3 = document.createElement("div");
		newMember2.appendChild(newMember3);
		var attrMember3 = document.createAttribute("class");
		attrMember3.value ="reset-3c756112--avatarFrame-2f40cdc9--large-8e58dfee--circle-6c5acd10";
		newMember3.setAttributeNode(attrMember3);
		
		var newMember4 = document.createElement("img");
		newMember3.appendChild(newMember4);
		var attrMember4 = document.createAttribute("class");
		attrMember4.value ="image-67b14f24--avatar-1c1d03ec";
		newMember4.setAttributeNode(attrMember4);
		newMember4.setAttribute("src","hehe");
		
		var newMember5 = document.createElement("div");
		newMember3.appendChild(newMember5);
		var attrMember5 = document.createAttribute("class");
		attrMember5.value ="reset-3c756112--innerShadow-7a3a8651";
		newMember5.setAttributeNode(attrMember5);
		
		
		
		/*
		var newMember3 = document.createElement("div");
		newMember2.appendChild(newMember3);
		var attrMember3 = document.createAttribute("class");
		attrMember3.value ="";
		newMember3.setAttributeNode(attrMember3);
		*/
		//푸터
		var newfooter = document.createElement("div");
		
		
		
		//특정 노드 삭제  removeChild()
	});
});

$('#orgDelete').on('click',function(){

	var result = confirm("조직을 삭제 하시겠습니까? 삭제 이후에는 되돌릴 수 없습니다.");
	
	if (result === true){
		
		$.ajax({
			url: "/dashboard/settings",
			type: "get",
		})
		.done(function(result){
			alert("조직이 삭제 되었습니다.");
			//개인 조직으로 돌아가기
		})
		.fail(function(result){
			alert("다시 시도해주세요.");
			
		});

	}else {
		
		return false;
	}
	
});













