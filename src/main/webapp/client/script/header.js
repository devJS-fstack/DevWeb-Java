const btnLogin = document.getElementById("btnLogin");
const formLogin = document.getElementById("formLogin");
const errLogin = document.querySelector('.err-login');
const errRegis = document.querySelector('.err-regis');
const errSpan = document.querySelector('.err-regis span');
const modalLogin = document.getElementById('modalLogin');
const nameUser = document.querySelector('.name-user');
const dropDownMenu = document.querySelector('.dropdown-menu');
const btnRegis = document.getElementById('btn-regis');
const formRegis = document.getElementById('formRegis');
const modalRegis = document.getElementById('regisModal');
const navheader = document.querySelector('.navbar');


// create instance axios config

const inputAccount = document.querySelector('[name=inputAccount]');
const inputPassword = document.querySelector('[name=inputPassword]');

// get value input regis modal
const fullnameRegis = document.querySelector('[name=inputName]');
const phoneRegis = document.querySelector('[name=inputPhone]');
const emailRegis = document.querySelector('[name=inputEmail]');
const passwordRegis = document.querySelector('[name=inputPasswordNew]');

const instance = axios.create({
    baseURL: '',
    timeOut: 3 * 1000,
    headers: {
        'Content-Type': 'application/json'
    },
});

// xu ly data truoc khi xuong server
instance.interceptors.request.use((config) => {
    //console.log('before request');

    return config;
}, err => {
    return Promise.reject(err)
})

// xu ly data khi response tu server
instance.interceptors.response.use((config) => {
    //console.log('before response: ');

    return config;
}, err => {
    return Promise.reject(err)
})

// xu ly login submit

btnLogin.onclick = async (e) => {
    e.preventDefault();
    const { status, elements } = await login(inputAccount.value, inputPassword.value);
    console.log(status);
    if (status == 'failed') {
        errLogin.style.display = 'block';
    }
    else {
        window.localStorage.setItem('accessToken', elements.accessToken);
        window.localStorage.setItem('phoneCustomer', elements.phone);
        $('#modalLogin').modal('hide');
        nameUser.innerHTML = elements.nameCustomer;
        dropDownMenu.innerHTML = `
            <a class="dropdown-item" data-toggle="modal" >L???ch s??? t???a s??ng</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item log-out" data-toggle="modal">????ng xu???t</a>
            `
        window.location.href = 'index.htm';
        const dropdownItem = document.querySelector('.log-out')
        dropdownItem.onclick = () => {
            window.localStorage.clear();
            nameCustomerElement.innerHTML = 'Kh??ch h??ng';
            dropDownMenu.innerHTML = `
                <a class="dropdown-item" data-toggle="modal" data-target="#modalLogin">????ng
                            nh???p</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" data-toggle="modal" data-target="#regisModal">????ng k??</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" data-toggle="modal" data-target="#changepass">Qu??n m???t kh???u</a>
                `
        }
    }
}

// handle regis submit
const spanName = document.querySelector('.err-name');
const spanPhone = document.querySelector('.err-phone');
const spanEmail = document.querySelector('.err-email');
const spanPass = document.querySelector('.err-pass');
const notiRegis = (style, textErr, itemFocus, span) => {
    span.style.display = style;
    span.textContent = textErr;
    if (itemFocus) itemFocus.focus();
}

const checkNameRegis = () => {
    if (fullnameRegis.value == '') {
        notiRegis('block', 'Anh vui l??ng nh???p h??? t??n c???a m??nh ???', fullnameRegis, spanName);
        return false;
    }
    else {
        notiRegis('none', '', null, spanName);
        return true;
    }
}
var checkPhoneVar = false;
var checkEmailVar = false;
const checkPhoneRegis = async () => {
    if (phoneRegis.value == '') {
        notiRegis('block', 'Anh vui l??ng nh???p s??? ??i???n tho???i c???a m??nh ???', phoneRegis, spanPhone);
        checkPhoneVar = false;
    }
    else {
        if (!validatePhone(phoneRegis.value)) {
            notiRegis('block', 'Anh vui l??ng nh???p ????ng s??? ??i???n tho???i c???a m??nh ???', phoneRegis, spanPhone);
            checkPhoneVar = false;
        }
        else {
            const { status } = await checkDuplicatePhone(phoneRegis.value);
            if (status == 'Found') {
                notiRegis('block', 'S??? ??i???n tho???i n??y ???? ???????c d??ng, anh vui l??ng nh???p l???i ???', phoneRegis, spanPhone);
                checkPhoneVar = false;
            }
            else {
                notiRegis('none', '', null, spanPhone);
                checkPhoneVar = true;
            }
        }
    }
}

const checkEmailRegis = async () => {
    if (emailRegis.value == '') {
        notiRegis('block', 'Anh vui l??ng nh???p email c???a m??nh ???', emailRegis, spanEmail);
        checkEmailVar = false;
    }
    else {
        if (!validateEmail(emailRegis.value)) {
            notiRegis('block', 'Anh vui l??ng nh???p ????ng email c???a m??nh ???', emailRegis, spanEmail);
            checkEmailVar = false;
        }
        else {
            const { status } = await checkDuplicateEmail(emailRegis.value);
            if (status == 'Found') {
                notiRegis('block', 'Email n??y ???? ???????c d??ng, anh vui l??ng nh???p l???i ???', emailRegis, spanEmail);
                checkEmailVar = false;
            }
            else {
                notiRegis('none', '', null, spanEmail);
                checkEmailVar = true;
            }
        }
    }
}

const checkPasswordRegis = () => {
    if (passwordRegis.value == '') {
        notiRegis('block', 'Anh vui l??ng nh???p m???t kh???u c???a m??nh ???', passwordRegis, spanPass);
        return false;
    }
    else {
        if (!validatePassword(passwordRegis.value)) {
            notiRegis('block', 'M???t kh???u ph???i c?? ??t nh???t 8 k?? t???, trong ???? c?? ??t nh???t 1 k?? t??? s??? v?? 1 k?? t??? in hoa', passwordRegis, spanPass);
            return false;
        }
        else {
            notiRegis('none', '', null, spanPass);
            return true;
        }
    }
}

const verifyEmail_form = document.getElementById('verifyEmail');
const verifyPhone_input = document.getElementById('verify-input');

btnRegis.addEventListener('click', async (e) => {
    e.preventDefault();
    if (checkNameRegis()) {
        checkPhoneRegis();
        if (checkPhoneVar) {
            checkEmailRegis();
            if (checkEmailVar) {
                if (checkPasswordRegis()) {
                    formRegis.action = "verify-form.htm"
                    formRegis.submit();
                }
            }
        }
    }
})

const btnSearchAcc = document.getElementById('btn-search-account');
const spanEmail_search = document.querySelector('.err-email__search');
const inputEmail_search = document.querySelector('[name=inputEmail_search]');
var email_changePass;
inputEmail_search.oninput = () => {
    notiRegis('none', '', null, spanEmail_search)
}

btnSearchAcc.addEventListener('click', async (e) => {
    e.preventDefault();
    if (inputEmail_search.value == "") notiRegis('block', 'Anh vui l??ng nh???p email', inputEmail_search, spanEmail_search)
    else {
        if (validateEmail(inputEmail_search.value)) {
            const { status } = await checkDuplicateEmail(inputEmail_search.value)
            if (status == 'Found') {
                notiRegis('none', '', null, spanEmail_search)
                email_changePass = inputEmail_search.value;
                inputEmail_search.value = ''
                $('.header-verify').text(`${email_changePass}`)
                $('#changepass').modal('hide');
                $('#verify-email').modal('show');
                new Promise(() => {
                    sendverify(email_changePass);
                });
            } else {
                notiRegis('block', 'Email n??y ch??a ???????c d??ng ????? ????ng k?? t??i kho???n', inputEmail_search, spanEmail_search)
            }
        } else {
            notiRegis('block', 'Anh vui l??ng nh???p ????ng ?????nh d???ng email', inputEmail_search, spanEmail_search)
        }
    }
})


const btnVerify = document.querySelector('#btn-verify');
const inputVerify = document.querySelector('[name=verify_number]')
const spanVerify = document.querySelector('.err-verify');


inputVerify.oninput = () => {
    inputVerify.value = inputVerify.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
    notiRegis('none', '', null, spanVerify)
}

var count = 0;
btnVerify.addEventListener('click', async (e) => {
    e.preventDefault();
    if (inputVerify.value == "") {
        notiRegis('block', 'Anh vui l??ng nh???p m?? x??c th???c', inputVerify, spanVerify)
    } else {
        count++;
        if (count < 5) {
            const { status } = await confirmVerify_changepass(inputVerify.value.trim());
            if (status == 'success') {
                $('#verify-email').modal('hide');
                inputVerify.value = "";
                $('#change-pass-new').modal('show');
            } else {
                notiRegis('block', `M?? x??c th???c kh??ng ch??nh x??c. Anh c??n ${5 - count} l???n nh???p`, inputVerify, spanVerify)
            }
        } else {
            $('#verify-email').modal('hide');
            notiRegis('none', '', null, spanVerify)
            inputVerify.value = "";
        }
    }
})


const btnConfirm_change = document.getElementById('btn-confirm__change-pass');
const inputPass_first = document.querySelector('[name=pass_first]');
const inputPass_last = document.querySelector('[name=pass_last]');
const span_changepass = document.querySelector('.err-pass-change');

inputPass_first.oninput = () => {
    notiRegis('none', '', null, span_changepass);
}

inputPass_last.oninput = () => {
    notiRegis('none', '', null, span_changepass);
}

btnConfirm_change.addEventListener('click', async (e) => {
    e.preventDefault();
    if (inputPass_first.value == "" || inputPass_last.value == "") {
        notiRegis('block', 'Anh vui l??ng nh???p ?????y ????? th??ng tin m???t kh???u', null, span_changepass);
    } else {
        if (inputPass_first.value === inputPass_last.value) {
            const { status, elements } = await setPasswordNew(inputPass_first.value, email_changePass);
            if (status === 'success') {
                window.localStorage.setItem('accessToken', elements.accessToken);
                window.localStorage.setItem('phoneCustomer', elements.phone);
                window.location.href = 'index.htm';
            }
        } else {
            notiRegis('block', 'Nh???p sai m???t kh???u x??c nh???n. Anh vui l??ng nh???p ch??nh x??c !', null, span_changepass);
            console.log('not match')
        }
    }
})


phoneRegis.onfocus = async () => {
    checkNameRegis();
}
emailRegis.onfocus = async () => {
    if (checkNameRegis())
        checkPhoneRegis();
}
passwordRegis.onfocus = async () => {
    if (checkNameRegis()) {
        checkPhoneRegis();
        if (checkPhoneVar) {
            checkEmailRegis();
            if (checkEmailVar) {
            }
        }
    }
}

function convertVietnames(input) {
    const inputArray = new Uint8Array(input.length);
    for (let i = 0; i < input.length; i++) {
      inputArray[i] = input.charCodeAt(i);
    }
    const decoder = new TextDecoder("utf-8");
    const outputString = decoder.decode(inputArray);
    return outputString;
}


// check Token 
const accessToken = `${window.localStorage.getItem('accessToken')}`;
if (accessToken != `null`) {
    (async () => {
        const { status, nameCustomer, phoneCustomer } = await checkToken(accessToken);
        if (status === "success") {
            const nameCustomerElement = document.querySelector('.name-user');
            nameCustomerElement.innerHTML = nameCustomer;
            dropDownMenu.innerHTML = `
                <a class="dropdown-item" data-toggle="modal" >L???ch s??? t???a s??ng</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item log-out" data-toggle="modal">????ng xu???t</a>
                `
            const btnLogout = document.querySelector('.log-out')
            clickLogout(btnLogout);
        }
    })();

    function clickLogout(dropdownItem) {
        const nameCustomerElement = document.querySelector('.name-user');
        dropdownItem.onclick = () => {
            window.localStorage.clear();
            nameCustomerElement.innerHTML = 'Kh??ch h??ng';
            dropDownMenu.innerHTML = `
                <a class="dropdown-item" data-toggle="modal" data-target="#modalLogin">????ng
                            nh???p</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" data-toggle="modal" data-target="#regisModal">????ng k??</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" data-toggle="modal" data-target="#changepass">Qu??n m???t kh???u</a>
                `
            window.location.href = 'index.htm';
        }
    }
}

async function setPasswordNew(passwordNew, email) {
    return postData("user/modify-password", { password: passwordNew, email });
}

async function confirmVerify_changepass(verifyNumber) {
    return postData("user/verify-forgot-pass", { verifyNumber });
}

async function sendverify(email) {
    return postData("user/send-mail-forgot-password", { email });
}

async function checkToken(accessToken) {
    return postData("user/verify-token", { accessToken });
}

async function checkDuplicatePhone(phone) {
    return postData("user/regis/check-duplicate", { phone, referenceDuplicate: "ACCOUNT" });
}

async function checkDuplicateEmail(email) {
    return postData("user/regis/check-duplicate", { email, referenceDuplicate: "EMAIL" });
}

async function login(account, password) {
    return postData("user/login", { account, password } );
}


const validateEmail = (email) => {
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
};

const validatePhone = (phone) => {
    return /([\+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})\b/.test(phone);
}

const validatePassword = (pass) => {
    return /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/.test(pass);
}

async function postData(url = '', data = {}) {
    const response = await fetch(url, {
      method: 'POST',
      mode: 'cors',
      cache: 'no-cache',
      credentials: 'same-origin',
      headers: {
        'Content-Type': 'application/json'
      },
      redirect: 'follow',
      referrerPolicy: 'no-referrer',
      body: JSON.stringify(data)
    });
    return response.json();
}