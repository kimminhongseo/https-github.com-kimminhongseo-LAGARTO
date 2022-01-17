{
    let btnLoginElem = document.querySelector('#btnLogin');

    if (btnLoginElem){
        btnLoginElem.addEventListener('click', () => {
           alert('실행') ;
        });
    }

//기존 로그인 상태를 가져오기 위해 Facebook에 대한 호출
    function statusChangeCallback(res){
        statusChangeCallback(response);
    }


    function fnFbCustomLogin(){
        FB.login(function(response) {
            if (response.status === 'connected') {
                FB.api('/me', 'get', {fields: 'name,email'}, function(r) {
                    let url = '/user/login';
                    console.log(r);
                    fetch(url, {
                        method : 'post',
                        headers : {'Content-type' : 'application/json'},
                        body : JSON.stringify(r)
                    }).then(function (res){
                        return res.json();
                    })
                    location.href = "http://localhost:8090/user/join";
                })
            } else if (response.status === 'not_authorized') {
                // 사람은 Facebook에 로그인했지만 앱에는 로그인하지 않았습니다.
                alert('앱에 로그인해야 이용가능한 기능입니다.');
            } else {
                // 그 사람은 Facebook에 로그인하지 않았으므로이 앱에 로그인했는지 여부는 확실하지 않습니다.
                alert('페이스북에 로그인해야 이용가능한 기능입니다.');
            }
        }, {scope: 'public_profile,email'});
    }

    window.fbAsyncInit = function() {
        FB.init({
            appId      : '250393303901626', // 내 앱 ID를 입력한다.
            cookie     : true,
            xfbml      : true,
            version    : 'v12.0'
        });
        FB.AppEvents.logPageView();
    };

}
