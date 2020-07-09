$(function() {
	sideEvent();
	closeNav();
	callDraftList();
	callMergedList();
	callArchivedList();
	/* functionBold(); */
})
function sideEvent() {
	$('.edit-btn').on('click', function(e) {
		const item = $(e.target);

		if (!item.hasClass('active-1')) {
			item.addClass('active-1');
			$('.edit-bar').show();
		} else {
			item.removeClass('active-1')
			$('.edit-bar').hide();
		}

	})
}

function closeNav() {
	$('.reset-3c756112--closeButton').on('click', function(e) {
		$('.edit-bar').hide()
	})
}

function callDraftList() {
	$('#draftTab').on('click', function() {
		$.ajax({
			url : "/draftList",
			success : function(result) {
				$('#draftList').html(result);
			}
		})
	})
}

function callMergedList() {
	$('#mergeTab').on('click', function() {
		$('.reset-3c756112--draftsListing').remove('#draftList')
		$('.reset-3c756112--draftsListing').remove('#archiveList')
		// $(this).css('height', '0px')
		$.ajax({
			url : "/mergedList",
			success : function(result) {
				$('#mergedList').html(result);
			}
		})
	})
}

function callArchivedList() {
	$('#archiveTab').on('click', function() {
		$('.reset-3c756112--draftsListing').remove('#mergedList')
		// $('.reset-3c756112--drawerContentBody-with-scrollbar').css('height','')
		$.ajax({
			url : "/archivedList",
			success : function(result) {
				$('#archivedList').html(result);
			}
		})
	})
}
/*
 * //tabsItemInfo-draftTabs function functionBold(){
 * $(.reset-3c756112--tabsItem-touchableView).on('click', function(e){ var
 * clicked = $(this). } }
 */