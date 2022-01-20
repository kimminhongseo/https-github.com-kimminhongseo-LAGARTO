{



        var naver_id_login = new naver_id_login("pO4ULGyBXhxd8Ti8g4XH", "http://localhost:8090/callback");
        var state = naver_id_login.getUniqState();
        naver_id_login.setButton("white", 2, 40);
        naver_id_login.setDomain("http://localhost:8090/login");
        naver_id_login.setState(state);
        naver_id_login.setPopup();
        naver_id_login.init_naver_id_login();


    //api 네이버 로그인 버튼script

        //callback
        var naver_id_login = new naver_id_login("pO4ULGyBXhxd8Ti8g4XH", "http://localhost:8090");
        // 접근 토큰 값 출력
        alert(naver_id_login.oauthParams.access_token);
        // 네이버 사용자 프로필 조회
        naver_id_login.get_naver_userprofile("naverSignInCallback()");
        // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
        function naverSignInCallback() {
                alert(naver_id_login.getProfileData('email'));
                alert(naver_id_login.getProfileData('nickname'));
                alert(naver_id_login.getProfileData('age'));
        }



        //fetch






}

