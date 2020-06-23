function doLogin() {
    let loginFailCount = document.getElementById('loginFailCount');
    console.info(loginFailCount);
    if (!isRecaptchachecked && loginFailCount > 3) {
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
    var formData = $("#login").serialize(); // 해당 데이터의 값을 직렬화

    $.ajax({
        type : 'GET',
        contentType : "application/x-www-form-urlencoded",
        url : '/valid-recaptcha',
        data : formData,
        dataType : 'text',
        cache : false,
        success : function(data) {
            if (data == 'success') {
                $('#login').submit();
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