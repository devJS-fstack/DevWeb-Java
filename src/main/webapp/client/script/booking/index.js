const itemCenter = document.querySelectorAll('.item-center');
const formChooseStore = document.getElementById('chooseStore');
const urlBook = window.location.href;
const arrUrl = urlBook.split("&");
const mainScrActive = document.querySelector('.main-screen__block--active');
const mainScr = document.querySelectorAll('.main-screen__block');
const iconActive = document.querySelectorAll('.salon-icon--active');
const botMessage = document.querySelectorAll('.bot-message');
const textValidate = document.querySelectorAll('.text-validate');
const serviceTitle = document.querySelector('.service-title');
const salonTitle = document.querySelector('.salon-title');
var styList = document.querySelector('.style-list');
var styTitle = document.querySelector('.sty-title');

itemCenter[0].addEventListener('click', () => {
    formChooseStore.action = `${arrUrl[0]}&${arrUrl[1]}&step=1`;
    formChooseStore.submit();
})
if (arrUrl[1] !== 'storeId=0') {
    iconActive[0].style.display = 'none';
    botMessage[0].style.display = 'none';
    salonTitle.style.color = '#111';

    if (serviceTitle.innerHTML.trim() == 'Xem tất cả dịch vụ hấp dẫn') {
        mainScr[1].classList.add('main-screen__block--active');
        mainScr[0].classList.add('main-screen__block--done');
        mainScr[0].classList.remove('main-screen__block--active');
        iconActive[1].style.display = 'flex';
        botMessage[1].style.display = 'flex';
        serviceTitle.style.color = '#a3a3a3';
    } else {
        mainScr[0].classList.add('main-screen__block--done');
        mainScr[0].classList.remove('main-screen__block--active');
        mainScr[2].classList.add('main-screen__block--active');
        mainScr[1].classList.add('main-screen__block--done');
        mainScr[1].classList.remove('main-screen__block--active');
        iconActive[1].style.display = 'none';
        iconActive[2].style.display = 'flex';
        botMessage[1].style.display = 'none';
        botMessage[2].style.display = 'flex';
        serviceTitle.style.color = '#111';
    }
} else if (arrUrl[1] === 'storeId=0') {
    botMessage[0].style.display = 'flex';
    iconActive[0].style.display = 'flex';
    salonTitle.style.color = '#a3a3a3';
}

itemCenter[1].addEventListener('click', () => {
    if (arrUrl[1] === 'storeId=0') {
        textValidate[0].style.color = '#f46969';
        textValidate[0].style.display = 'block';
        itemCenter[0].style.borderColor = '#f46969';
        itemCenter[0].style.borderWidth = '1px';
        itemCenter[0].style.borderStyle = 'solid';
    } else {
        formChooseStore.action = `${arrUrl[0]}&${arrUrl[1]}&step=2`;
        formChooseStore.submit();
    }
})
itemCenter[2].addEventListener('click', () => {
    if (arrUrl[1] === 'storeId=0') {
        textValidate[0].style.color = '#f46969';
        textValidate[0].style.display = 'block';
        itemCenter[0].style.borderColor = '#f46969';
        itemCenter[0].style.borderWidth = '1px';
        itemCenter[0].style.borderStyle = 'solid';
    } else {
        if (serviceTitle.innerHTML.trim() == 'Xem tất cả dịch vụ hấp dẫn') {
            textValidate[1].style.color = '#f46969';
            textValidate[1].style.display = 'block';
            itemCenter[1].style.borderColor = '#f46969';
            itemCenter[1].style.borderWidth = '1px';
            itemCenter[1].style.borderStyle = 'solid';
        }
    }
})
itemCenter[3].addEventListener('click', () => {
    if (arrUrl[1] === 'storeId=0') {
        textValidate[0].style.color = '#f46969';
        textValidate[0].style.display = 'block';
        itemCenter[0].style.borderColor = '#f46969';
        itemCenter[0].style.borderWidth = '1px';
        itemCenter[0].style.borderStyle = 'solid';
    }
    else {
        if (serviceTitle.innerHTML.trim() == 'Xem tất cả dịch vụ hấp dẫn') {
            textValidate[1].style.color = '#f46969';
            textValidate[1].style.display = 'block';
            itemCenter[1].style.borderColor = '#f46969';
            itemCenter[1].style.borderWidth = '1px';
            itemCenter[1].style.borderStyle = 'solid';
        }
        else {
            clickdateDrop();
        }
    }
})


// render box time

if (serviceTitle.innerHTML.trim() != 'Xem tất cả dịch vụ hấp dẫn') {
    styList.classList.remove('dis-none');
    renderBoxTime();
    checkTimeNow();
    if (bookedInDate1.length > 0 && staffsInDate1.length > 0) {
        unvaliableTimeBooked(bookedInDate1, staffsInDate1[0].IDStaff);
    }
}


// dropdown stylist

const styDrop = document.querySelector('.style-list__dropdown');
const contentStaff = document.querySelector('.content');
const imgDrop = document.querySelector('.style-list__dropdown .img-drop');
var staffCurrent;
var bookedInDateCurrent;
styDrop.onclick = () => {
    if (contentStaff.classList.contains('fade-in')) {
        contentStaff.classList.add('hide-stylist');
        contentStaff.classList.remove('fade-in');
        imgDrop.src = 'https://30shine.com/static/media/chevronRight.fe25caf9.svg';
    } else {
        contentStaff.classList.remove('hide-stylist');
        contentStaff.classList.add('fade-in');
        imgDrop.src = 'https://30shine.com/static/media/chevronDown.4843aae8.svg';
        var staffItem = document.querySelectorAll('.left');
        var staffImg = document.querySelector('.user-default');
        //removeAllActiveStaff(staffItem);
        if (typeof staffCurrent === 'undefined') {
            clickStaffItem(staffItem, staffsInDate1, bookedInDate1);
        }
        else {
            clickStaffItem(staffItem, staffCurrent, bookedInDateCurrent);
        }
    }
}

// drop-down date 

const dateDrop = document.querySelector('.date-drop');
const dropDate = document.querySelector('.drop-date');
const dateItemCenter = document.querySelector('.salon-title__item--center');
const dropIconDate = document.querySelector('.date-drop__icon');
const date = new Date();
let dayOfWeek = date.getDay();
let dayCurrent = date.getDate();
let monthCurrent = date.getMonth() + 1;
let yearCurrent = date.getYear();
dropDate.innerHTML = '';
var boxTimeItemAll = document.querySelectorAll('.box-time__item');
var staffChoose;
var timeChoose;
var servicesChoose = '';
if (staffsInDate1.length > 0) {
    staffChoose = staffsInDate1[0].IDStaff;
    styTitle.innerHTML = staffsInDate1[0].SurName + ' ' + staffsInDate1[0].NameStaff;
}
var shiftChoose;
var dateChoose;
if (staffsInDate1.length > 0) dateChoose = staffsInDate1[0].DateRegis;


// render date center

dateItemCenter.innerHTML = `
                                    <span>Hôm nay,
                                </span>
                                <span>
                                    ${nameDayOfWeek(dayOfWeek)}
                                    (${dayCurrent}/${monthCurrent})
                                </span>
`;

function nameDayOfWeek(number) {
    switch (number) {
        case 0: return 'CN';
        case 1: return 'T2';
        case 2: return 'T3';
        case 3: return 'T4';
        case 4: return 'T5';
        case 5: return 'T6';
        case 6: return 'T7';
    }
}

function nameDay(number) {
    switch (number) {
        case 0: return 'Hôm nay,';
        case 1: return 'Ngày mai,';
        case 2: return 'Ngày kia,';
        case 3: return '';
        case 4: return '';
        case 5: return '';
    }
}

// check leap year
function leapYear(year) {
    return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
}
var dropItem = '';
var isClick = false;
function clickdateDrop() {
    if (!dropDate.classList.contains('opacity-1')) {
        dropDate.classList.add('opacity-1');
        dropDate.classList.add('fade-in');
        dropIconDate.src = 'https://30shine.com/static/media/caretDown.9392e204.svg';
        if (isClick) {
            dropDate.innerHTML = dropItem;
        }
        else {
            for (var i = 0; i < 6; i++) {
                dropItem += `
            <div class="drop-date__item pointer">
                <div style="width:35px"></div>
                <div>
                    <span>${nameDay(i)}</span>
                    <span>
                        ${nameDayOfWeek(dayOfWeek)}
                        (${dayCurrent}/${monthCurrent})
                    </span>
                </div>
            </div>
            `
                // handle day of week
                if (dayOfWeek == 6) dayOfWeek = 0;
                else {
                    dayOfWeek++;
                }
                // handle day of month
                if (leapYear(yearCurrent)) {
                    if (dayCurrent == 29 && monthCurrent == 2) {
                        dayCurrent = 0;
                        monthCurrent++;

                    }
                    if (dayCurrent == 30) {
                        if (monthCurrent == 4 || monthCurrent == 6 || monthCurrent == 9 || monthCurrent == 11) {
                            dayCurrent = 0;
                            monthCurrent++;
                        }

                    }
                    if (dayCurrent == 31) {
                        if (monthCurrent === 1 || monthCurrent == 3 || monthCurrent == 5 || monthCurrent == 7
                            || monthCurrent == 8 || monthCurrent == 10 || monthCurrent == 12) {
                            dayCurrent = 0;
                            monthCurrent++;
                        }
                    }
                }
                else {
                    if (dayCurrent == 28 && monthCurrent == 2) {
                        dayCurrent = 0;
                        monthCurrent++;

                    }
                    if (dayCurrent == 30) {
                        if (monthCurrent == 4 || monthCurrent == 6 || monthCurrent == 9 || monthCurrent == 11) {
                            dayCurrent = 0;
                            monthCurrent++;
                        }
                    }
                    if (dayCurrent == 31) {
                        if (monthCurrent === 1 || monthCurrent == 3 || monthCurrent == 5 || monthCurrent == 7
                            || monthCurrent == 8 || monthCurrent == 10 || monthCurrent == 12) {
                            dayCurrent = 0;
                            monthCurrent++;
                        }
                    }
                }
                dayCurrent++;
            }
            dropDate.innerHTML = dropItem;
            isClick = true;

        }
    } else {
        dropDate.classList.remove('opacity-1');
        dropDate.classList.remove('fade-in');
        dropDate.innerHTML = '';
        dropIconDate.src = 'https://30shine.com/static/media/caretRight.b0d191b3.svg';
    }
    let dropDateItem = document.querySelectorAll('.drop-date__item');
    dropDateItem.forEach((item, index) => {
        item.onclick = () => {
            dropDate.classList.remove('opacity-1');
            dropDate.classList.remove('fade-in');
            dropDate.innerHTML = '';
            dropIconDate.src = 'https://30shine.com/static/media/caretRight.b0d191b3.svg';
            btnFinally.classList.add('btn-inactive');
            if (index == 0) {
                if (staffsInDate1.length > 0)
                    dateChoose = staffsInDate1[0].DateRegis;
                dateItemCenter.innerHTML = item.innerHTML;
                renderBoxTime();
                checkTimeNow();
                var boxTimeItem = document.querySelectorAll('.box-time__item');
                clickBoxItem(boxTimeItem);
                renderStaffInDate(staffsInDate1);
                unvaliableTimeBooked(bookedInDate1, staffsInDate1[0].IDStaff);
                var staffItem = document.querySelectorAll('.left');
                var staffImg = document.querySelector('.user-default');
                isActiveFirstStaff(staffItem[0], staffImg);
                clickStaffItem(staffItem, staffsInDate1, bookedInDate1);
                styTitle.innerHTML = staffsInDate1[0].SurName + ' ' + staffsInDate1[0].NameStaff;
            } else {
                switch (index) {
                    case 1:
                        if (staffsInDate2.length) {
                            renderBoxTime();
                            dateChoose = staffsInDate2[0].DateRegis;
                            staffCurrent = staffsInDate2;
                            bookedInDateCurrent = bookedInDate2;
                            renderStaffInDate(staffsInDate2);
                            unvaliableTimeBooked(bookedInDate2, staffsInDate2[0].IDStaff);
                            var boxTimeItem = document.querySelectorAll('.box-time__item');
                            clickBoxItem(boxTimeItem);
                            var staffItem = document.querySelectorAll('.left');
                            var staffImg = document.querySelector('.user-default');
                            isActiveFirstStaff(staffItem[0], staffImg);
                            styTitle.innerHTML = staffsInDate2[0].SurName + ' ' + staffsInDate2[0].NameStaff;
                            staffChoose = staffsInDate2[0].IDStaff;
                            clickStaffItem(staffItem, staffsInDate2, bookedInDate2);
                        }
                        break;
                    case 2:
                        if (staffsInDate3.length) {
                            renderBoxTime();
                            dateChoose = staffsInDate3[0].DateRegis;
                            staffCurrent = staffsInDate3;
                            bookedInDateCurrent = bookedInDate3;
                            renderStaffInDate(staffsInDate3);
                            unvaliableTimeBooked(bookedInDate3, staffsInDate2[0].IDStaff);
                            var boxTimeItem = document.querySelectorAll('.box-time__item');
                            clickBoxItem(boxTimeItem);
                            var staffItem = document.querySelectorAll('.left');
                            var staffImg = document.querySelector('.user-default');
                            isActiveFirstStaff(staffItem[0], staffImg);
                            styTitle.innerHTML = staffsInDate3[0].SurName + ' ' + staffsInDate3[0].NameStaff;
                            staffChoose = staffsInDate3[0].IDStaff;
                            clickStaffItem(staffItem, staffsInDate3, bookedInDate3);
                        }
                        break;
                    case 3:
                        if (staffsInDate4.length) {
                            renderBoxTime();
                            dateChoose = staffsInDate4[0].DateRegis;
                            staffCurrent = staffsInDate4;
                            bookedInDateCurrent = bookedInDate4;
                            renderStaffInDate(staffsInDate4);
                            unvaliableTimeBooked(bookedInDate4, staffsInDate2[0].IDStaff);
                            var boxTimeItem = document.querySelectorAll('.box-time__item');
                            clickBoxItem(boxTimeItem);
                            var staffItem = document.querySelectorAll('.left');
                            var staffImg = document.querySelector('.user-default');
                            isActiveFirstStaff(staffItem[0], staffImg);
                            styTitle.innerHTML = staffsInDate4[0].SurName + ' ' + staffsInDate4[0].NameStaff;
                            staffChoose = staffsInDate4[0].IDStaff;
                            clickStaffItem(staffItem, staffsInDate4, bookedInDate4);
                        }
                        break;
                    case 4:
                        if (staffsInDate5.length) {
                            renderBoxTime();
                            dateChoose = staffsInDate5[0].DateRegis;
                            staffCurrent = staffsInDate5;
                            bookedInDateCurrent = bookedInDate5;
                            renderStaffInDate(staffsInDate5);
                            unvaliableTimeBooked(bookedInDate5, staffsInDate2[0].IDStaff);
                            var boxTimeItem = document.querySelectorAll('.box-time__item');
                            clickBoxItem(boxTimeItem);
                            var staffItem = document.querySelectorAll('.left');
                            var staffImg = document.querySelector('.user-default');
                            isActiveFirstStaff(staffItem[0], staffImg);
                            styTitle.innerHTML = staffsInDate5[0].SurName + ' ' + staffsInDate5[0].NameStaff;
                            staffChoose = staffsInDate5[0].IDStaff;
                            clickStaffItem(staffItem, staffsInDate5, bookedInDate5);
                        }
                        break;
                    case 5:
                        if (staffsInDate6.length) {
                            renderBoxTime();
                            staffCurrent = staffsInDate6;
                            bookedInDateCurrent = bookedInDate6;
                            dateChoose = staffsInDate6[0].DateRegis;
                            renderStaffInDate(staffsInDate6);
                            unvaliableTimeBooked(bookedInDate6, staffsInDate2[0].IDStaff);
                            var boxTimeItem = document.querySelectorAll('.box-time__item');
                            clickBoxItem(boxTimeItem);
                            var staffItem = document.querySelectorAll('.left');
                            var staffImg = document.querySelector('.user-default');
                            isActiveFirstStaff(staffItem[0], staffImg);
                            styTitle.innerHTML = staffsInDate6[0].SurName + ' ' + staffsInDate6[0].NameStaff;
                            staffChoose = staffsInDate6[0].IDStaff;
                            clickStaffItem(staffItem, staffsInDate6, bookedInDate6);
                        }
                        break;
                }
                dateItemCenter.innerHTML = item.innerHTML;
            }
        }
    })
}

// handle box-time
var shiftHtml = ``;
function returnMinuteFormat(number) {
    if (number == 0) return '00';
    else return number;
}
function renderBoxTime() {
    shiftHtml = ``;
    for (var i = 0; i < shifts.length;) {
        shiftHtml += `
    <div class="swiper-slide" style="width: 101.048px !important;">
        <div class="box-time__item">${shifts[i].HourStart}h${returnMinuteFormat(shifts[i].MinuteStart)}</div> 
        <div class="box-time__item">${shifts[++i].HourStart}h${returnMinuteFormat(shifts[i].MinuteStart)}</div>
        <div class="box-time__item">${shifts[++i].HourStart}h${returnMinuteFormat(shifts[i].MinuteStart)}</div>
    </div>
    `
        i++;
    }
    shiftSwiper.innerHTML = shiftHtml;
    var swiperBtn = document.querySelectorAll('.swiper__button')
    swiperBtn[0].classList.remove('dis-none')
    swiperBtn[1].classList.remove('dis-none')
}
function checkTimeNow() {
    var d = new Date();
    var boxTimeItem = document.querySelectorAll('.box-time__item');
    var hour = d.getHours();
    var minute = d.getMinutes();
    shifts.forEach((item, index) => {
        if (hour >= item.HourStart) {
            boxTimeItem[index].classList.add('unvaliable');
        } else {
            if (item.HourStart - hour == 1) {
                if (minute - item.MinuteStart > 30) {
                    boxTimeItem[index].classList.add('unvaliable');
                }
            }
        }
    })
}


function checkIsClickStaff(staffItem) {
    var isClick = false;
    staffItem.forEach((item, index) => {
        if (item.classList.contains('isActive')) {
            isClick = true;
        }
    })
    if (isClick)
        return true;
    else return false
}


function unvaliableTimeBooked(bookInDate, idStaff) {
    var boxTimeItem = document.querySelectorAll('.box-time__item');
    bookInDate.forEach((item) => {
        if (item.IDStaff == idStaff) {
            boxTimeItem[item.IDShiftBook - 1].classList.add('unvaliable');
        }
    })

}
var boxTimeItemCurrent = document.querySelectorAll('.box-time__item');
var btnFinally = document.querySelector('.button-finally');
clickBoxItem(boxTimeItemCurrent);
function clickBoxItem(boxTimeItem) {
    var indexPre = -1;
    var imgDrop = document.querySelector('.img-drop');
    boxTimeItem.forEach((item, index) => {
        item.onclick = () => {
            if (!item.classList.contains('unvaliable')) {
            botMessage[2].style.borderColor = '#c1e4ca';
            if (indexPre >= 0) boxTimeItem[indexPre].classList.remove('has-choice');
            item.classList.add('has-choice');
            shiftChoose = index + 1;
            indexPre = index;
            var staffItem = document.querySelectorAll('.left');
            btnFinally.classList.remove('btn-inactive');
            timeChoose = item.innerHTML.trim();
        }
    }
    })
}


function removeAllUnvaliable() {
    var boxTimeItem = document.querySelectorAll('.box-time__item');
    boxTimeItem.forEach((item, index) => {
        item.classList.remove('unvaliable');
        item.classList.remove('has-choice')
    })
}

// render staff follow date
function renderStaffInDate(staffItem) {
    const staffList = document.querySelector('.content');
    let html = ``;
    if (staffItem.length == 0) {
        contentStaff.classList.add('hide-stylist');
        contentStaff.classList.remove('fade-in');
        imgDrop.src = 'https://30shine.com/static/media/chevronRight.fe25caf9.svg';
    }
    for (let i = 0; i < staffItem.length; i++) {
        html += `
        <div class="left">
<div>
    <div class="user-default relative pointer">
        
        <img src="${staffItem[i].PathImgStaff}" alt="" class="img-user" style="width: 70px; height: 70px; border-radius: 50px; border: 2px solid #fff;" />
    </div>
</div>

<div>
    <span>
        ${staffItem[i].SurName}
        <br />
        ${staffItem[i].NameStaff}
    </span>
</div>
</div>
        `
    }
    staffList.innerHTML = html;
}

function removeAllActiveStaff() {
    var staff = document.querySelectorAll('.left');
    var iconCheck = document.querySelectorAll('.icon-check-default');
    iconCheck.forEach((item) => item.remove());
    staff.forEach((item) => item.classList.remove('isActive'));

}
function clickStaffItem(staffItem, staffInDate, bookedInDate) {
    var staffImg = document.querySelectorAll('.user-default');
    var html = ``;
    staffItem.forEach((item, index) => {
        item.onclick = () => {
            styTitle.innerHTML = staffInDate[index].SurName + ' ' + staffInDate[index].NameStaff;
            removeAllActiveStaff();
            btnFinally.classList.add('btn-inactive');
            renderBoxTime();
            if (staffInDate == staffsInDate1) checkTimeNow();
            if (staffInDate.length > 0) {
                unvaliableTimeBooked(bookedInDate, staffInDate[index].IDStaff);
                staffChoose = staffInDate[index].IDStaff;
                html = staffImg[index].innerHTML;
                html += `  <img class="icon-check-default" src="https://30shine.com/static/media/checkYellow.02dbd103.svg"/>`;
                staffImg[index].innerHTML = html;
                item.classList.add('isActive');
            }
            var boxTimeItem = document.querySelectorAll('.box-time__item');
            clickBoxItem(boxTimeItem);
        }
    })
}

function isActiveFirstStaff(staffLeft, staffImg) {
    let html = ``;
    html = staffImg.innerHTML;
    html += `  <img class="icon-check-default" src="https://30shine.com/static/media/checkYellow.02dbd103.svg"/>`;
    staffImg.innerHTML = html;
    staffLeft.classList.add('isActive');
}


const formBook = document.getElementById('book');
function totalPayment() {
    var payment = 0;
    for (var i = 0; i < serviceBooked.length; i++) {
        payment += serviceBooked[i].ListPrice;
    }
    return payment;

}
totalPayment();

var nameServiceBooked = document.querySelectorAll('.name-service__booked');
if (nameServiceBooked) {
    nameServiceBooked.forEach((item, index) => {
        if (index == nameServiceBooked.length - 1)
            servicesChoose += `${item.innerHTML.trim()}`
        else
            servicesChoose += `${item.innerHTML.trim()}, `
    })
}

btnFinally.onclick = () => {
    var html = ``;
    var phoneBook = arrUrl[0].split('phone=');
    var storeBook = arrUrl[1].split('=');
    var payment = totalPayment();
    if (!btnFinally.classList.contains('btn-inactive')) {
        html += `<input value="${shiftChoose}" name="idShiftBook">`;
        html += `<input value="${dateChoose}" name="dateBook">`;
        html += `<input value="${phoneBook[1]}" name="phoneBook">`;
        html += `<input value=${storeBook[1]} name="storeBook">`;
        html += `<input value="${staffChoose}" name="staffBook">`;
        html += `<input value="${payment}" name="payment">`;
        html += `<input value="${salonTitle.innerHTML.trim()}" name="streetStore">`;
        html += `<input value="${timeChoose}" name="timeChoose">`;
        html += `<input value="${servicesChoose}" name="servicesChoose">`;
        if (serviceBooked.length) {
            console.log("service booked: ", serviceBooked);
            for (var i = 0; i < serviceBooked.length; i++) {
                html += `<input value="${serviceBooked[i].IDService}" name="servicesBook[]">`;
            }
        }

        formBook.innerHTML = html;
        formBook.action = "booking/success";
        //console.log({ phoneBook, storeBook, shiftChoose, dateChoose, staffChoose, payment, timeChoose, servicesChoose, streetStore: salonTitle.innerHTML.trim() });
        formBook.submit();
    }
}
renderStaffInDate(staffsInDate1);
var staffItem = document.querySelectorAll('.left');
var staffImg = document.querySelector('.user-default');
if (staffItem && staffImg) isActiveFirstStaff(staffItem[0], staffImg);


// swiper 

var swiper = new Swiper('.swiper-container', {
    slidesPerView: 1,
    spaceBetween: 10,
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev'
    },
    slidesPerView: "auto",
    slidesBetween: "auto",
});