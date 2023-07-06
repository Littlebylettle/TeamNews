let host = 'http://' + window.location.host;

//
$(document).ready(function () {
    const auth = getToken();
    console.log("auth=", auth);
    if (auth === '') {

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
// 같이 들어있던 좋아요 js
const button = document.querySelector('#like');
const counter = '#couter';
let state = false;
let like = 12;

writeCounter(like, counter);
setState(state, button);

function writeCounter(number, id) {
    const elm = button.querySelector(id);
    elm.innerHTML = number;
}

function setState(state, elm) {
    if (state) {
        elm.classList.remove('dislike');
        elm.classList.add('active');
    } else {
        elm.classList.remove('active');
        elm.classList.add('dislike');
    }
}

function addLike() {
    if (!state) {
        like++;
        state = true;
        writeCounter(like, counter);
        setState(state, button);
    } else {
        like--;
        state = false;
        writeCounter(like, counter);
        setState(state, button);
    }
}

button.addEventListener('click', addLike);

