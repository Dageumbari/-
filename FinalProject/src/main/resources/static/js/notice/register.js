/*  <script th:if="!${board?.idx}">
        $('#insert').click(function () {
            var jsonData = JSON.stringify({
                title: $('#board_title').val(),
                subTitle: $('#board_sub_title').val(),
                content: $('#board_content').val(),
                boardType: $('#board_type option:selected').val()
            });
            $.ajax({
                       url: "http://localhost:8081/api/boards",
                       type: "POST",
                       data: jsonData,
                       contentType: "application/json",
                       headers: {
                           "Authorization": "Basic " + btoa("havi" + ":" + "test")
                       },
                       dataType: "json",
                           success: function () {
                               alert('등록성공');
                               location.href = '/board/list';
                       },
                       error: function () {
                           alert('등록실패~');
                       }
                   });
        });
    </script>*/