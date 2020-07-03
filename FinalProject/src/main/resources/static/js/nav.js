$(function() {
	getDraftList(url);
	openEditsDrawer();
})



function openEditsDrawer() {
	$('#draft').click(function(){
		$(this).show()
	});
	
};


   function getDraftList(url) {
	   	var ajaxOption = {
			url : /draftList,
			async : true,
			type : "GET",
			dataType : "html",
			cache : false
		};
	
		$.ajax(ajaxOption).done(function(data) {
			// Contents 영역 삭제
			$('#draft').children().remove();
			$('.reset-3c756112--draftsPlaceholder').children().remove();
			// Contents 영역 교체
			$('#draft').html(data);
			return data;
		}
	);

/*
 * function openNav() {
 * 
 * $("#contents").load("/test/test.do", {"name" : "Kim"});
 * document.getElementById("mySidenav").style.width = "250px";
 * document.getElementById("main").style.marginLeft = "250px"; }
 * 
 * Set the width of the side navigation to 0 and the left margin of the page
 * content to 0 function closeNav() {
 * document.getElementById("mySidenav").style.width = "0";
 * document.getElementById("main").style.marginLeft = "0"; }
 */
/*
 * $(document).ready(function(){ $(".dropdown, .btn-group").hover(function(){
 * var dropdownMenu = $(this).children(".dropdown-menu");
 * if(dropdownMenu.is(":visible")){ dropdownMenu.parent().toggleClass("open"); }
 * }); });
 * 
 * 
 * $(".secondary-menu-toggle").on("click", function(e)
 * $(".secondary-menu").toggleClass("hidden")})
 * 
 * });
 */

