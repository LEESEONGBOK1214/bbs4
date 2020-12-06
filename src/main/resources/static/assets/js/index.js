$(document).ready(function () {


    let color = '';
    let temp;
    for (let i = 0; i < 6; i++) {
        temp = Math.random() * 16;
        temp = temp.toFixed(0);
        if (temp >= 10) {

            switch (temp) {
                case '10':
                    temp = 'a';
                    break;
                case '11':
                    temp = 'b';
                    break;
                case '12':
                    temp = 'c';
                    break;
                case '13':
                    temp = 'd';
                    break;
                case '14':
                    temp = 'e';
                    break;
                case '15':
                    temp = 'f';
                    break;
            }// end of switch
        } // end of if temp >= 10

        color += temp;
    }

    // console.log(color);
    // alert('index.js 로딩');
    $('#header').css("background-color", '#' + color);


    //회원가입
    $('#join').on('click', function () {
        // console.log('회원가입 눌림!');
        // alert('회원가입해!');
        if ($('#confirm').hasClass('emailSuccess') === false) {
            alert('이메일 인증을 마쳐주세요')
            return false;
        }
        let data = {
            // let : var-> 전역함수로 인식.
            // var을 대체하기 위해 나옴.
            // 지역, 전역 구별됨
            id: $('#joinId').val(),
            password: $('#joinPW').val(),
            name: $('#name').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/join',
            success: function () {
                alert('회원가입 완료!');
                window.location.href = '/';
            }
            //ERROR
            //DEFAULT
        });
    });

    // 로그인
    $('#login').on('click', function () {
        // console.log('로그인클릭!');
        // alert('로그인해!');
        let data = {
            id: $('#loginId').val(),
            password: $('#loginPW').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/login',
            success: function () {
                window.location.href = '/';
            }
        });


    }); // end of login on

    $('#back').on('click', function () {
        window.location.href = "/";
    });

    // 글 쓰기
    $('#write').on('click', function () {
        let data = {
            title: $('#title').val(),
            content: $('#content').val(),
            writer: $('#writer').val(),
            mno: $('#mno').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/write',
            success: function () {
                alert('글등록 완료!');
                window.location.href = "/";
            }
        });
    });// end of write on click

    // 글 수정
    $('#writeModify').on('click', function () {
        console.log('글 수정 클릭!!');
        let data = {
            id: $('#loginId').val(),
            password: $('#loginPW').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/writeModify',
            success: function () {
                window.location.href = '/';
            }
        });
    }); // end of writeModify on click

    // 글 삭제
    $('#writeDelete').on('click', function () {
        console.log('글 삭제 클릭!!');
        let data = {
            id: $('#loginId').val(),
            password: $('#loginPW').val()
        }

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/writeDelete',
            success: function () {
                window.location.href = '/';
            }
        });


    }); // end of writeDelete on click

    // 글 추천 클릭
    $('#reco').on('click', function () {
        console.log('추천 클릭!');

        let data = {
            bno: $('#bno').val()
        }
        $.ajax({
            data: data,
            type: 'put',
            url: '/rest/reco',
            success: function () {
                alert('추천!');
                window.location.href = '/select/' + data.bno;
            }
        })
    });

    // 글 삭제 버튼
    $('#boardDelete').on('click', function () {
        let data = {
            bno: $('#bno').val()
        }

        $.ajax({
            data: data,
            type: 'delete',
            url: '/rest/boardDelete',
            success: function () {
                alert('삭제 완료!');
                window.location.href = '/';
            }
        })
    });

    // 글 수정 버튼
    $('#updateBtn').on('click', function () {
        let bno = $('#bno').val();
        window.location.href = '/update/' + bno;
    });

    // 글 수정 완료
    $('#update').on('click', function () {
        let data = {
            title: $('#title').val(),
            content: $('#content').val(),
            writer: $('#writer').val(),
            bno: $('#bno').val(),
        }

        $.ajax({
            data: data,
            type: 'put',
            url: '/rest/update',
            success: function () {
                alert('수정 완료!');
                window.location.href = '/select/' + data.bno;
            }
        })
    });


    // 댓글 버튼 클릭
    $('#replyBtn').on('click', function () {
        let data = {
            rcontent: $('#rcontent').val(),
            rwriter: $('#rwriter').text(),
            mno: $('#mno').val(),
            bno: $('#bno').val()
        }

        // alert(
        //     'rcontent : ' + $('#rcontent'),
        //     'rwriter'
        // );

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/reply',
            success: function () {
                location.reload();
            }
        })
    });


    // 이메일 전송 버튼 클릭
    $('#sendEmail').on('click', function () {

        let data = {
            userEmail: $('#email').val(),
        }
        if (!data.userEmail) {
            alert('이메일을 입력해 주세요!');
            return;
        }

        // alert(data.userEmail);

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/email',
            success: function () {
                alert('이메일을 확인해주세요!');
            }
        })
    });

    //  인증 버튼 클릭
    $('#confirm').on('click', function () {

        let data = {
            userEmail: $('#confirmCode').val(),
        }
        if (!data.userEmail) {
            alert('인증번호를 입력해 주세요!');
            return;
        }

        // alert(data.userEmail);

        $.ajax({
            data: data,
            type: 'post',
            url: '/rest/confirm',
            success: function () {
                alert('인증에 성공하였습니다!');
                $('#confirm').addClass('emailSuccess');
                $('#confirm').prop("disabled", true);
            }
        })
    });

    // 멤버 삭제 버튼
    // $('.memberDelete').on('click', function () {
    //     alert('멤버 삭제 버튼 클릭!');
    //     let data = {
    //         mno : $('.memberDelete').attr('name'),
    //     }
    //     alert('데이타' + data.mno) ;
    //
    //     $.ajax({
    //         data: data,
    //         type: 'delete',
    //         url: '/rest/memberDelete',
    //         success: function () {
    //             alert('삭제 완료!');
    //             window.location.href = '/memberList';
    //         }
    //     })
    // });

    //doc 끝
});


// 댓글 추천
function up(_rno) {
    let data = {
        bno: $('#bno').val(),
        rno: _rno,
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/up',
        success: function () {
            location.reload();
        }
    })
};

// 댓글 비추
function down(_rno) {
    let data = {
        rno: _rno,
        bno: $('#bno').val(),
    }

    $.ajax({
        data: data,
        type: 'put',
        url: '/rest/down',
        success: function () {
            location.reload();
        }
    })
};