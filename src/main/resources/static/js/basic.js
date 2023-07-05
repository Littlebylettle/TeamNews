let host = 'http://' + window.location.host;

//
$(document).ready(function () {
    const auth = getToken();
    console.log("auth=", auth);
    if (auth === '') {
        // 로그인 버튼 클릭 시 login.html로 이동
        $('#login-text').click(function (e) {
            e.preventDefault(); // 기본 동작(링크 이동)을 막습니다.
            window.location.href = host + "/login.html";
        });

        // 회원가입 버튼 클릭시 signup.html로 이동
        $('#login-text').show();
        $('#signup-text').show();
    } else {
        $('#logout-text').show();
        $('#mypage-text').show();
        $('.postbox').show();
    }
})

function logout() {
    // 토큰 삭제
    Cookies.remove('Authorization', {path: '/'});
    window.location.href = host + "/";
}

function getToken() {
    let auth = Cookies.get('Authorization');

    if (auth === undefined || auth == null) {
        return '';
    }

    return auth;
}