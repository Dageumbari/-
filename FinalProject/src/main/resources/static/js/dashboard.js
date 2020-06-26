//프롬프트에서 입력받은 조직을 디비에 넣는 방법 찾기~! 
function setOrgName(){
	var orgName = prompt("Your app/company name 조직 이름 넣으쇼")
	console.log("입력 받은 조직 이름 : "+orgName)
	
	if(orgName !=null){
		//내용 입력시 실행
	}
	else { 
		//취소 버튼 클릭시 실행
		alert("생성이 취소 되었습니다.")
	}
	return orgName
}
