const btnBook = document.querySelector('.btn-booking');
const formBook = document.getElementById('form-booking');
const inputPhone = document.getElementById('input-phone');


var phoneCus = `${window.localStorage.getItem('phoneCustomer')}`;
const bookingElement = document.querySelector('.list-booking-infor');
const cancelForm = document.getElementById('cancelBookForm');
if (phoneCus != 'null') {
    inputPhone.value = phoneCus;
}
btnBook.addEventListener('click', async (e) => {
    e.preventDefault();
    if (inputPhone.value == phoneCus) {
        const { status } = await checkToken(accessToken);
        if (status == 'success') {
            formBook.action = `booking.htm?phone=${phoneCus}&storeId=0&step=0`;
            formBook.submit();
        }
    }
    else {
        const { status } = await checkDuplicatePhone(inputPhone.value);
        console.log(status);
        if (status == 'Found') {
            $('#modalLogin').modal('show');
            inputAccount.value = inputPhone.value;
        }
        else {
            $('#regisModal').modal('show');
            phoneRegis.value = inputPhone.value;
        }
    }
})

if (accessToken != `null`) {
    // handle getdata
    (async () => {
        const { status, phoneCustomer } = await checkToken(accessToken);
        if (status == 'success') {
            const { status_info, street, dateBook, nameStaff, dayOfWeek, minuteBook, hourBook, idShift, idStaff } = await infoBooking(phoneCustomer);
            
            if (status_info == 'success') {
                const d = new Date(dateBook);
                const timeBook = minuteBook == 0 ? `${hourBook}h00` : `${hourBook}h${minuteBook}`
                const countdownDate = new Date(d.getFullYear(), d.getMonth(), d.getDate(), hourBook, minuteBook, 0, 0);
                const countdownTime = countdownDate.getTime();
                const now = new Date().getTime();
                const timeleft = countdownTime - now;
                const dayleft = Math.floor(timeleft / (1000 * 60 * 60 * 24));
                const hourleft = Math.floor((timeleft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                const minuteleft = Math.floor((timeleft % (1000 * 60 * 60)) / (1000 * 60));
                const dayleftTittle = dayleft == 0 ? `` : `${dayleft} ngày `;
                const hourleftTittle = hourleft == 0 ? `` : `${hourleft} giờ `;
                const minuteleftTittle = minuteleft == 0 ? `` : `${minuteleft} phút `;
                const dayBook = d.getDate() < 10 ? `0${d.getDate()}` : `${d.getDate()}`
                console.log(dayBook)
                const monthBook = d.getMonth() + 1 < 10 ? `0${d.getMonth() + 1}` : `${d.getMonth() + 1}`
                //minuteleft = 0;
                console.log({ dayleft, hourleft, minuteleft });
                if (minuteleft <= 0) {
                    //cancelForm.action = `/booking/cancel/?phoneBook=${phoneCus}&dateBook=${dateBook}&idShift=${idShift}&staffBook=${idStaff}`
                    //cancelForm.submit();
                }
                else {
                    bookingElement.innerHTML = `
                        <div class="container__booking-info">
                        <div class="title-booked mt-4">
                            Lịch đặt của anh
                        </div>
                        <div class="relative">
                            <div class="box-booking__info">
                                <div class="box-booking__item">
                                    <div class="box-booking__content">
                                        <div class="time-to">
                                            Chỉ còn <span style="color: rgb(231, 65, 65);">${dayleftTittle}${hourleftTittle}${minuteleftTittle}</span> là đến lịch hẹn
                                        </div>
                                        <div class="item">
                                            <img src="https://30shine.com/static/media/calendar.67158d06.svg" alt="">
                                            <span>${dayOfWeek}, ngày ${dayBook}.${monthBook}, ${timeBook}</span>
                                        </div>
                                        <div class="item item-name">
                                            <img src="https://30shine.com/static/media/shop.d02661a2.svg" alt="">
                                            ${street}
                                        </div>
                                        <div class="item">
                                            <img src="https://30shine.com/static/media/user2.00eb2b41.svg" alt="">
                                            <span>${nameStaff}</span>
                                        </div>
                                    </div>
                                    <div class="box-booking__action">
                                        <div class="button">Đổi lịch</div>
                                        <div class="button">Hủy lịch</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                        `
                    const changBook = document.querySelectorAll('.box-booking__action .button');
                    // click chang book
                    changBook[0].onclick = () => {
                        let answer = confirm('Anh có chắc chắn muốn đổi lịch không ạ?');
                        if (answer) {
                            location.href = `booking.htm?phone=${phoneCustomer}&storeId=0&step=0`;
                        }
                    }
                    // click cancel book
                    changBook[1].onclick = () => {
                        cancelForm.action = `cancel.htm?phoneBook=${phoneCustomer}`
                        let answer = confirm('Anh có chắc chắn muốn hủy lịch không ạ?');
                        if (answer) {
                            cancelForm.submit();
                        }
                    }
                }
            }
        }
    })();


    // function getdata
    async function infoBooking(phone) {
        return postData("user/info-booking", { phone })
    }
}