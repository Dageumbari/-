$(function(){
	openNav();
})

function openNav(){
	$('.navigationButton').on('click',function(event){
		const CLICKED_CLASS = "clicked"	
		classlist.toggle(CLICKED_CLASS)
	})
});

$(document).ready(function(){
    $(".dropdown, .btn-group").hover(function(){
        var dropdownMenu = $(this).children(".dropdown-menu");
        if(dropdownMenu.is(":visible")){
            dropdownMenu.parent().toggleClass("open");
        }
    });
});     


$(".secondary-menu-toggle").on("click", function(e)
	$(".secondary-menu").toggleClass("hidden")})
	
});



						

						
						
						
						