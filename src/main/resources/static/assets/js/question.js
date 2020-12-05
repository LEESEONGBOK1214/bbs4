$(document).ready(function () {
    $('#boardDelete').on('click', function () {
        let data = {
            bno: $('#bno').val()
        }

        $.ajax({
            data: data,
            type: 'delete',
            url: '/rest/memberDelete',
            success: function () {
                alert('삭제 완료!');
                window.location.href = '/';
            }
        })
    });

    $('#back').on('click', function () {
        window.location.href = "/";
    });


});

