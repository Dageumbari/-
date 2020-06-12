$(function(){
	openNav();
})

function openNav(){
	$('.navigationButton').on('click',function(event){
		moveActive('.nav','a',target(event));
	})
}

function moveActive(removeTarget, addTarget,target){
	target.closest(removeTarget).find('.active').removeClass('active');
	target.closest(addTarget).addClass('active');
	
}
