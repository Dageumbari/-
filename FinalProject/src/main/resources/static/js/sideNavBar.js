$(function(){
	sideEvent();
	closeNav();
	callDraftList();
	/*functionBold();*/
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
			$('.edit-bar').hide();
		}
		
		
		
	})
}

function closeNav(){
	$('.reset-3c756112--closeButton').on('click', function(e){
		$('.edit-bar').hide()
	})
}

function callDraftList(){
	$('.reset-3c756112--tabsItem-touchableView').on('click',function(){
		$.ajax({
			url: "/draftList",
			success: function(result){
				$('#draftList').html(result);
			}
		})
	})
}
/*//tabsItemInfo-draftTabs
function functionBold(){
	$(.reset-3c756112--tabsItem-touchableView).on('click', function(e){
		var clicked = $(this).
	}
}*/