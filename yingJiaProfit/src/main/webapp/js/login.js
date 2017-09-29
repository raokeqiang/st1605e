var base, phone, password, css;


$(function () {
    css = {
        "-moz-box-shadow": "0px 0px 10px #9e020c",
        "-webkit-box-shadow": "0px 0px 10px #9e020c",
        "box-shadow": "0px 0px 10px #9e020c"
    };

    login = function (b) {
        base = b;
        phone = $(".phone");
        password = $(".password");

        phone.keyup(function () {
            if ((/^1[3-9][0-9]\d{8}$/.test(phone.val()))) {
                phone.removeAttr("style");
                $(".error").html("").hide();
                return;
            }
        });



        //登录
        $(".submit").click(function () {
            $(".error").html("").hide();
            if (!(/^1[3-9][0-9]\d{8}$/.test(phone.val()))) {
                phone.focus().css(css);
                $(".error").html("手机号码格式不正确").show();
                return;
            }

            $.ajax({
                type: "POST", // 用POST方式传输
                dataType: "json", // 数据格式:JSON
                async: true,
                url: base + '/yingJiaProfit/toFrontLogin/loginCheck', // 目标地址
                data: {
                    mobilePhone: phone.val(),
                    password: password.val()
                },
                success: function (msg) {
                    if (msg==true) {
                        window.location.href = "/yingJiaProfit/subjectqian/showsubject";
                    } else {
                        $(".error").html("用户名或密码错误").show();
                    }
                }
            });

        });

        $(document).keyup(function (event) {
            if (event.keyCode == 13) {
                $(".submit").trigger("click");
            }
        });
    };
});


