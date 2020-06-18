
//주영공지 

$(document).ready(function(){
	var result='<c:out value="${result}"/>';
});


function checkModal(result) {
	if (result === ' ') {
		return;
	}
	if(parseInt(result)>0) {
		$(".modal-body").html("게시글" +  parseInt(result) + "번이 등록되었습니다.")
	}//class
	$("#noticeModal").modal("show"); //id
   }
   });
   
   $("#regBtn").on("click", function() {

		self.location = "/notice/register";

	});

   
   
   
