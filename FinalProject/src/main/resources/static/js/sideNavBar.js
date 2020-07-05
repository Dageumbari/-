$(function(){
	sideEvent();
})

function sideEvent(){
	$('.edit-btn').on('click', function(e){
		const item = $(e.target);
		
		if(!item.hasClass('active-1')){
			item.addClass('active-1');
			$('.edit-bar').show();
		} 
		else {
			item.removeClass('active-1')
			$('.edit-bar').hide()
		}
		
		
		
	})
}