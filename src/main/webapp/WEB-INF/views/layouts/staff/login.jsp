<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign in & Sign up Form</title>
    <link rel="stylesheet" href="../css/staff.css" />
</head>

<body>
    <main>
        <div class="box">
            <div class="inner-box">
                <div class="forms-wrap">
                    <form action="/dashboard-manager" autocomplete="off" class="sign-in-form" method="get">
                        <div class="logo">
                            <img src="../img/logo.png" alt="" />
                            <h4>Hair Store</h4>
                        </div>

                        <div class="heading">
                            <h2>Đăng Nhập</h2>
                            <h6>Đăng nhập phần mềm cho quản lý</h6>
                        </div>

                        <div class="actual-form">
                            <span class="err-form"
                                style="font-size: 14px;position: relative;bottom: 13px;color: #e80b0b; display: none;">Tài
                                khoản hoặc
                                mật khẩu không
                                đúng</span>
                            <div class="input-wrap">
                                <input type="text" minlength="4" class="input-field input-acc" autocomplete="off"
                                    required />
                                <label>Tài khoản</label>
                            </div>

                            <div class="input-wrap">
                                <input type="password" minlength="4" class="input-field input-pass" autocomplete="off"
                                    required />
                                <label>Mật khẩu</label>

                            </div>

                            <input type="submit" value="Đăng Nhập" class="login-btn sign-btn" />

                            <p class="text">
                                Bạn đã quên mật khẩu?
                                <a href="" class="toggle" style="color:#111">Trợ giúp</a> để lấy lại mật khẩu
                            </p>
                        </div>
                    </form>

                    <form action="" autocomplete="off" class="sign-up-form">
                        <div class="logo">
                            <img src="../img/logo.png" alt="" />
                            <h4>Hair Store</h4>
                        </div>

                        <div class="heading">
                            <h2>Quên Mật Khẩu</h2>
                            <h6>Đã có tài khoản?</h6>
                            <a href="" class="toggle">Đăng nhập</a>

                        </div>

                        <div class="actual-form">
                            <div class="input-wrap">
                                <input type="email" class="input-field input-email" autocomplete="off" required />
                                <label>Email</label>
                                <span class="err-email-forgot"
                                    style="font-size: 12px;position: relative;bottom: -43px;color: #e80b0b; display: none;left:3px">Tài
                                    khoản hoặc
                                    mật khẩu không
                                    đúng</span>
                            </div>
                            <div class="input-wrap">
                                <input type="password" minlength="4" class="input-field input-pass-first"
                                    autocomplete="off" required />
                                <label>Mật khẩu mới</label>
                                <span class="err-pass-first"
                                    style="font-size: 12px;position: relative;bottom: -43px;color: #e80b0b; display: none;left:3px">Tài
                                    khoản hoặc
                                    mật khẩu không
                                    đúng</span>
                            </div>

                            <div class="input-wrap">
                                <input type="password" minlength="4" class="input-field input-pass-next"
                                    autocomplete="off" required />
                                <label>Xác nhận mật khẩu mới</label>
                                <span class="err-pass-next"
                                    style="font-size: 12px;position: relative;bottom: -43px;color: #e80b0b; display: none;left:3px">Tài
                                    khoản hoặc
                                    mật khẩu không
                                    đúng</span>
                            </div>

                            <input type="submit" value="Xác Nhận" class="sign-btn btn-confirm__forgot-pass mt-3" />

                            <p class="text">
                                Bạn sẽ đợi từ 3-7 ngày để duyệt đơn đăng ký,
                                <a href="#">Blog</a> và
                                <a href="#">Câu hỏi thường gặp</a>
                            </p>
                        </div>
                    </form>
                </div>

                <div class="carousel">
                    <div class="images-wrapper">
                        <img src="../img/image1.png" class="image img-1 show" alt="" />
                        <img src="../img/image2.png" class="image img-2" alt="" />
                        <img src="../img/image3.png" class="image img-3" alt="" />
                    </div>

                    <div class="text-slider">
                        <div class="text-wrap">
                            <div class="text-group">
                                <h2>Làm việc linh hoạt</h2>
                                <h2>Cơ hội thăng tiến hấp dẫn</h2>
                                <h2>Chế độ như công ty nước ngoài</h2>
                            </div>
                        </div>

                        <div class="bullets">
                            <span class="active" data-value="1"></span>
                            <span data-value="2"></span>
                            <span data-value="3"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <div id="toast">
        <div id="img"></div>
        <div id="desc"></div>
    </div>
    <script>
        const token = location.href.split('/?accessToken=')[1];
        if (token !== undefined) {
            window.localStorage.setItem('accessToken', token)
        }

    </script>
    <script src="../script/staff/login.js"></script>
</body>

</html>