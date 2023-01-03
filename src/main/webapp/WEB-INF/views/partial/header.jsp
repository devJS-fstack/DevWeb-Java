<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<base href="${pageContext.servletContext.contextPath}/">
</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="index.htm">The Baber</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="Project-CK/index.htm#"
					id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <img
						class="user-avatar" src="" alt=""> <span class="name-user">
							Khách hàng </span>
				</a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" data-toggle="modal"
							data-target="#modalLogin">Đăng nhập</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" data-toggle="modal"
							data-target="#regisModal">Đăng ký</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" data-toggle="modal"
							data-target="#changepass">Quên mật khẩu</a>
					</div></li>
			</ul>
		</div>
	</div>
</nav>

						<!-- Form login -->
<form method="get" action="" id="formLogin">
	<div class="modal fade changepass" id="modalLogin" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title modal-login" id="exampleModalLabel">Đăng
						Nhập</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body body-change-pass" style="padding-top: 1rem;">
					<h5 class="heading-login">Nhập tài khoản và mật khẩu của anh
						chị.</h5>
					<div
						style="box-shadow: 0 0 4px rgb(0 0 0/ 14%); box-sizing: border-box; width: 100%; height: 2.5rem; overflow: hidden; border: 1px solid rgba(0, 0, 0, .14); border-radius: 2px;">
						<input type="text" class="form-control input-change-pass"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Tài khoản" name="inputAccount">

					</div>
					<div
						style="box-shadow: 0 0 4px rgb(0 0 0/ 14%); box-sizing: border-box; width: 100%; height: 2.5rem; overflow: hidden; border: 1px solid rgba(0, 0, 0, .14); border-radius: 2px; margin: 1rem 0 2rem 0;">
						<input type="password" class="form-control input-change-pass"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Mật khẩu" name="inputPassword">

					</div>
				</div>
				<div class="err-login">
					<span>Tài khoản hoặc mật khẩu không đúng. Mời anh kiểm tra
						lại!</span>
				</div>
				<div class="modal-footer">
					<button id="btnLogin" type="submit" class="btn btn-primary"
						style="width: 100%">Tiếp tục</button>
				</div>
			</div>
		</div>
	</div>
</form>

							<!-- Form register -->
<form method="post" id="formRegis">
	<div class="modal fade changepass" id="regisModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title modal-login" id="exampleModalLabel">Đăng
						Ký</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body body-change-pass">
					<h5 class="heading-login">Đăng ký tài khoản nhanh chóng và dễ
						dàng</h5>
					<div class="relative input-group input-group-sm mb-4">
						<div
							style="box-shadow: 0 0 4px rgb(0 0 0/ 14%); box-sizing: border-box; width: 100%; height: 2.5rem; overflow: hidden; border: 1px solid rgba(0, 0, 0, .14); border-radius: 2px;">
							<input type="text" class="form-control input-change-pass"
								aria-label="Small" aria-describedby="inputGroup-sizing-sm"
								placeholder="Họ Và Tên" name="inputName"> <span
								class="span-err__regis err-name">Tài khoản hoặc mật khẩu
								không đúng. Mời anh kiểm tra lại!</span>

						</div>
					</div>
					<div class="relative input-group input-group-sm mb-4">
						<div
							style="box-shadow: 0 0 4px rgb(0 0 0/ 14%); box-sizing: border-box; width: 100%; height: 2.5rem; overflow: hidden; border: 1px solid rgba(0, 0, 0, .14); border-radius: 2px;">
							<input type="text" pattern="((09|03|07|08|05)+([0-9]{8})\b)"
								required class="form-control input-change-pass"
								aria-label="Small" aria-describedby="inputGroup-sizing-sm"
								placeholder="Số di động" maxlength="10" name="inputPhone">
							<span class="span-err__regis err-phone">Tài khoản hoặc mật
								khẩu không đúng. Mời anh kiểm tra lại!</span>

						</div>
					</div>
					<div class="relative input-group input-group-sm mb-4">
						<div
							style="box-shadow: 0 0 4px rgb(0 0 0/ 14%); box-sizing: border-box; width: 100%; height: 2.5rem; overflow: hidden; border: 1px solid rgba(0, 0, 0, .14); border-radius: 2px;">
							<input type="email" class="form-control input-change-pass"
								aria-label="Small"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
								aria-describedby="inputGroup-sizing-sm" placeholder="Email"
								name="inputEmail"> <span
								class="span-err__regis err-email">Tài khoản hoặc mật khẩu
								không đúng. Mời anh kiểm tra lại!</span>

						</div>
					</div>
					<div class="relative input-group input-group-sm mb-4">
						<div
							style="box-shadow: 0 0 4px rgb(0 0 0/ 14%); box-sizing: border-box; width: 100%; height: 2.5rem; overflow: hidden; border: 1px solid rgba(0, 0, 0, .14); border-radius: 2px;">
							<input type="password" class="form-control input-change-pass"
								aria-label="Small" aria-describedby="inputGroup-sizing-sm"
								placeholder="Nhập mật khẩu mới" name="inputPasswordNew">
							<span class="span-err__regis err-pass">Tài khoản hoặc mật
								khẩu không đúng. Mời anh kiểm tra 
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button id="btn-regis" type="submit" class="btn btn-primary"
						style="width: 100%">Đăng Ký</button>
				</div>
			</div>
		</div>
	</div>
</form>
<div class="modal fade changepass" id="changepass" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header header-change-pass">
                <h5 class="modal-title" id="exampleModalLabel" style="    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;">Đặt lại mật khẩu</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body body-change-pass">
                <div class="relative input-group input-group-sm mb-4 input-change">
                    <div class="input-group-prepend">
                    </div>
                    <div style="    box-shadow: 0 0 4px rgb(0 0 0 / 14%);box-sizing: border-box;
    width: 100%;
    height: 2.5rem;
    overflow: hidden;
    border: 1px solid rgba(0,0,0,.14);
    border-radius: 2px;">
                        <input type="text" class="form-control input-change-pass" aria-label="Small"
                            aria-describedby="inputGroup-sizing-sm" placeholder="Email" name="inputEmail_search">

                    </div>
                    <span class="span-err__regis err-email__search">Tài khoản hoặc mật khẩu không đúng. Mời anh kiểm tra
                        lại!</span>
                </div>
            </div>
            <div class="modal-footer">
                <button id="btn-search-account" type="submit" class="btn btn-primary btn-change-pass"
                    style="width:100%">Tiếp Theo</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade changepass" id="verify-email" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header header-change-pass">
                <h5 class="modal-title" id="exampleModalLabel" style="    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;">Nhập Mã Xác Thực</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body body-change-pass">
                <div class="relative input-group input-group-sm mb-4 input-change">
                    <h5 class="heading-login" style=" width:100%;padding-bottom: 0;"> Nhập mã xác thực
                        được gửi
                        đến email
                    </h5>
                    <h6 class="heading-login header-verify" style="color:#d60808; width:100%">
                    </h6>
                    <div class="input-group-prepend">
                    </div>
                    <div style="    box-shadow: 0 0 4px rgb(0 0 0 / 14%);box-sizing: border-box;
    width: 100%;
    height: 2.5rem;
    overflow: hidden;
    border: 1px solid rgba(0,0,0,.14);
    border-radius: 2px;">
                        <input type="text" class="form-control input-change-pass" aria-label="Small"
                            aria-describedby="inputGroup-sizing-sm" placeholder="Mã xác thực" name="verify_number">

                    </div>
                </div>
                <span class="span-err__regis err-verify" style="top:163px">Tài khoản hoặc mật khẩu không đúng. Mời anh
                    kiểm tra
                    lại!</span>
            </div>
            <div class="modal-footer">
                <button id="btn-verify" type="submit" class="btn btn-primary btn-change-pass" style="width:100%">Xác
                    Nhận</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade changepass" id="change-pass-new" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header header-change-pass">
                <h5 class="modal-title" id="exampleModalLabel" style="    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;">Thiết Lập Mật Khẩu</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body body-change-pass">
                <div class="relative input-group input-group-sm mb-4 input-change">
                    <div class="input-group-prepend">
                    </div>
                    <div style="    box-shadow: 0 0 4px rgb(0 0 0 / 14%);box-sizing: border-box;
    width: 100%;
    height: 2.5rem;
    overflow: hidden;
    border: 1px solid rgba(0,0,0,.14);
    border-radius: 2px;">
                        <input type="password" class="form-control input-change-pass" aria-label="Small"
                            aria-describedby="inputGroup-sizing-sm" placeholder="Mật khẩu mới" name="pass_first">

                    </div>
                </div>
                <div class="relative input-group input-group-sm mb-4 input-change">
                    <div class="input-group-prepend">
                    </div>
                    <div style="    box-shadow: 0 0 4px rgb(0 0 0 / 14%);box-sizing: border-box;
    width: 100%;
    height: 2.5rem;
    overflow: hidden;
    border: 1px solid rgba(0,0,0,.14);
    border-radius: 2px;">
                        <input type="password" class="form-control input-change-pass" aria-label="Small"
                            aria-describedby="inputGroup-sizing-sm" placeholder="Nhập lại mật khẩu mới"
                            name="pass_last">

                    </div>
                </div>
            </div>
            <span class="span-err__regis err-pass-change" style="top: 58px;width: 100%;text-align: center;"></span>
            <div class="modal-footer">
                <button id="btn-confirm__change-pass" type="submit" class="btn btn-success btn-change-pass"
                    style="width:100%">Xác Nhận</button>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
	const rootContext = "${pageContext.servletContext.contextPath}"
</script>
<script src="client/script/header.js"></script>
