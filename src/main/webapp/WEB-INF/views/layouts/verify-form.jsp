<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container mt-4 mb-5">
    <h1 style="text-align: center">Xác Thực Email</h1>
    <form method="post" action="./confirm-verify">
        <div class="form-group">
            <label for="exampleInputEmail1">Mã xác nhận email cho <span style="color:red">${email}</span></label>
            <input type="number" class="form-control" id="verify-number__regis" name="verifyNumber"
                aria-describedby="emailHelp" placeholder="Nhập mã xác nhận">
            <small id="verify-noti" class="form-text text-muted">Mã sẽ tự động xóa sau 2 phút.</small>
        </div>
        <button type="submit" class="btn btn-primary btn-verify-number__regis">Xác nhận</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
	const btnVerify_regis = document.querySelector('.btn-verify-number__regis');
	const verifyInput_regis = document.getElementById('verify-number__regis');
	const phoneRegisNew = "${inputPhone}";
	const emailRegisNew = "${email}";
	const nameRegisNew = "${nameCustomer}";
	const inputPasswordNew = "${inputPasswordNew}";
	btnVerify_regis.onclick = async (e) => {
	    e.preventDefault();
	    const { status, token, phoneCustomer } = 
		await postData("user/regis/verify-email", 
		{ 
			verifyNumber: verifyInput_regis.value, 
			phone: phoneRegisNew,
			email: emailRegisNew,
			nameCustomer: nameRegisNew,
			password: inputPasswordNew,
		}
		);
		console.log({ status, token, phoneCustomer })
	    if (status == 'success') {
	        window.localStorage.setItem('accessToken', token);
	        window.localStorage.setItem('phoneCustomer', phoneCustomer);
	        window.location.href = "index.htm";
	    }
	    else {
	        alert('Mã xác nhận không đúng, anh vui lòng thử lại ạ')
	    }
	}
	
	
</script>