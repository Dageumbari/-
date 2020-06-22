/*!
 * Start Bootstrap - SB Admin v6.0.0 (https://startbootstrap.com/templates/sb-admin)
 * Copyright 2013-2020 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-sb-admin/blob/master/LICENSE)
 */
(function($) {
	"use strict";

	// Add active state to sidbar nav links
	var path = window.location.href; // because the 'href' property of the
	// DOM element is the absolute path
	$("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
		if (this.href === path) {
			$(this).addClass("active");
		}
	});

	// Toggle the side navigation
	$("#sidebarToggle").on("click", function(e) {
		e.preventDefault();
		$("body").toggleClass("sb-sidenav-toggled");
	});
})

function doLogin() {
	if (!isRecaptchachecked) {
		alert('리캡차 인증 체크를 해주세요.');
		$("#recaptcha").focus();
		return false;
	}

	doVaildRecaptcha();
}

var isRecaptchachecked = false;

function recaptchaCallback() {
	isRecaptchachecked = true;
}

function doVaildRecaptcha() {
	var formData = $("#loginForm").serialize(); // 해당 데이터의 값을 직렬화

	$.ajax({
		type : 'POST',
		contentType : "application/x-www-form-urlencoded",
		url : '/valid-recaptcha',
		data : formData,
		dataType : 'text',
		cache : false,
		success : function(data) {
			if (data == 'success') {
				// $('#loginForm').submit();
				alert('로그인 성공');
			} else {
				alert('인증되지 않은 주소입니다.');
			}
		},
		error : function(xhr, status, error) {
			console.log(error);
		}
	});
}

(jQuery);
