//프롬프트에서 입력받은 조직을 디비에 넣는 방법 찾기~! 
function setOrgName(){
	var orgName = prompt("Your app/company name 조직 이름 넣으쇼")
	console.log("조직 이름 입력 값 : "+orgName)
	return orgName
}


//var dashURL2 = document.getElementByClassName("dashURL")[0].textContent;

function setDashURL() {
	var dashURL1 = document.getElementByClassName("dashURL")[0].textContent;
	location.href="/dashboard/"+dashURL1+"/spaces"
	console.log("대시유알엘 :"+dashURL1)
}