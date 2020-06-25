
$(document).ready(function(){
	var result='<c:out value="${result}"/>';
	checkModal(result);

	history.replaceState({}, null, null);
	
function checkModal(result) { 
	if (result === '' || history.state) {
		return;
	}
	if(parseInt(result)>0) {
		$(".modal-body").html("게시글" +  parseInt(result) + "빈이 등록되었습니다.")
	}
	$("#myModal").modal("show");
	
$(".regBtn").on("click", function() {
	self.location = "/main/notice/register";
});
   });
