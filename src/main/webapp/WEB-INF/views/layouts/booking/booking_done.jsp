<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="main" style="background-color: rgb(238, 238, 238)">
    <div class="container">
        <div class="booking-done">
            <div class="booking-done__item p-3">
                <div class="booking-done__title">
                    Đặt lịch thành công
                    <span role="img" aria-label="success">🎉</span>
                </div>
                <div class="booking-done__rotation">
                    <div class="pt-3">
                        <div>
                            <img src="https://images.squarespace-cdn.com/content/v1/5951eb9036e5d30f950a2b76/1500267843786-0XCDZTM29AEUGWQL27VM/barber+men+style+hair+cut+chatswood+sydney+nsw"
                                alt="">
                        </div>
                    </div>
                    <div class="pb-3">
                        <div class="street-booking">
                            ${streetStore}
                        </div>
                    </div>
                </div>
                <div class="booking-done__footer">
                    <div>
                        Hẹn gặp anh ${phoneBook} vào lúc:
                    </div>
                    <div class="time-booking">
                        ${timeChoose} ${dayOfWeek}, ${monthOfYear}
                    </div>
                </div>
            </div>

            <div class="booking-done__item p-3">
                <div class="flex pb-3">
                    <div>
                        <div style="
                font-weight: 600;
                font-size: 1.125rem;
                line-height: 1.75rem;
}
                :">
                            Stylist:
                            <span style="font-weight:500">${fullName}</span>
                        </div>
                        <div style="
                font-weight: 300;
                font-size: .875rem;
                line-height: 1.25rem;
                padding-top: 1rem;
                ">
                            Để cùng anh tạo nên kiểu tóc ưng ý nhất, em có một vài gợi ý dưới đây anh tham khảo nhé.
                        </div>
                    </div>
                    <div style="margin-left: 1.5rem;">
                        <div style="
                background-image:  url(${pathImgStaff});
                background-repeat: no-repeat;
                background-size: cover;
                border-radius: 9999px;
                width: 3.5rem;
                height: 3.5rem;
                "></div>
                    </div>
                </div>
                <div class="divide">
                    <a href="#" class="talk-stylist">
                        <img src="https://30shine.com/static/media/comment.a3c5655a.svg" alt="">
                        <div class="divide-title">Nói gì với stylist để có kiểu tóc ưng ý</div>
                        <div class="ml-auto">
                            <img src="https://30shine.com/static/media/chevronRight.5746f99f.svg" alt="">
                        </div>
                    </a>
                    <a href="#" class="hairs-style">
                        <img src="https://30shine.com/static/media/question-circle.a74ef5cd.svg" alt="">
                        <div class="divide-title">Khám phá các kiểu tóc hot</div>
                        <div class="ml-auto">
                            <img src="https://30shine.com/static/media/chevronRight.5746f99f.svg" alt="">
                        </div>
                    </a>
                </div>
            </div>

            <div class="booking-done__item p-3">
                <div>
                    <span style="
                font-weight:600;
                font-size: 1.125rem;
                line-height: 1.75rem;
                ">Chi tiết lịch đặt
                    </span>
                </div>
                <div style="margin-top:1rem">
                    <div>
                        <div style="
                color: #111;
                font-weight: 500;          
                font-size: .875rem;
                line-height: 1.25rem;
                padding-bottom: 0.25rem;
                ">
                            Dịch vụ
                        </div>
                        <div style="
                    font-weight: 300;
                    font-size: .875rem;
                    line-height: 1.25rem;
                    padding-bottom: 1rem;
                " class = "service-booking">
                            {{servicesChoose}}
                        </div>
                    </div>
                </div>
                <div class="pt-3 payment-done">
                    <div style="
                color: #111;
                font-weight: 500;          
                font-size: .875rem;
                line-height: 1.25rem;
                padding-bottom: 0.25rem;
                ">
                        Tổng tiền
                    </div>
                    <div style="
                    font-weight: 300;
                    font-size: .875rem;
                    line-height: 1.25rem;
                    padding-bottom: 1rem;
                ">
                        ${payment}K
                    </div>
                </div>
                <div class="pt-3">
                    <div style="
                color: #111;
                font-weight: 500;          
                font-size: .875rem;
                line-height: 1.25rem;
                padding-bottom: 0.25rem;
                ">
                        Thông tin gửi xe
                    </div>
                    <div style="
                    font-weight: 300;
                    font-size: .875rem;
                    line-height: 1.25rem;
                    padding-bottom: 1rem;
                    padding-top: 0.5rem;
                ">
                        🛵 Gửi xe máy miễn phí tại salon
                    </div>
                    <div style="
                    font-weight: 300;
                    font-size: .875rem;
                    line-height: 1.25rem;
                    padding-bottom: 1rem;
                ">
                        🚗 Bảo vệ salon sẽ hướng dẫn chỗ đậu ô tô cho anh
                    </div>
                </div>
            </div>
            <div class="booking-done__item p-3">
                <div class="flex pb-3">
                    <div>
                        <div style="
                font-weight: 600;
                font-size: 1.125rem;
                line-height: 1.75rem;
}
                :">
                            Đổi/Hủy lịch
                        </div>
                        <div style="
                font-weight: 300;
                font-size: .875rem;
                line-height: 1.25rem;
                padding-top: 1rem;
                ">
                            Để cùng anh tạo nên kiểu tóc ưng ý nhất, em có một vài gợi ý dưới đây anh tham khảo nhé.
                        </div>
                    </div>
                </div>
                <div class="divide">
                    <a href="${pageContext.servletContext.contextPath}/booking.htm?phone=${phoneBook}&storeId=0&step=0" class="change-book">
                        <img src="https://30shine.com/static/media/swap-box.8970d9fa.svg" alt="">
                        <div class="divide-title">Đổi lịch</div>
                        <div class="ml-auto">
                            <img src="https://30shine.com/static/media/chevronRight.5746f99f.svg" alt="">
                        </div>
                    </a>
                    <a href="" class="cancel-book">
                        <img src="https://30shine.com/static/media/close-circle.c6008166.svg" alt="">
                        <div class="divide-title">Hủy lịch</div>
                        <div class="ml-auto">
                            <img src="https://30shine.com/static/media/chevronRight.5746f99f.svg" alt="">
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <form id="cancelBookForm"
            action="${pageContext.servletContext.contextPath}/cancel.htm?phoneBook=${phoneBook}&dateBook=${dateBook}&idShift=${idShiftBook}&staffBook=${idStaffBook}"
            method="POST"></form>
    </div>
</div>
<script>
	function convertVietnames(input) {
		const inputArray = new Uint8Array(input.length);
		for (let i = 0; i < input.length; i++) {
		  inputArray[i] = input.charCodeAt(i);
		}
		const decoder = new TextDecoder("utf-8");
		const outputString = decoder.decode(inputArray);
		return outputString;
	}
	const dayOfWeek = "${dayOfWeek}";
	const monthOfYear = "${monthOfYear}";
	const phoneBook = "${phoneBook}";
	let streetStore = "${streetStore}";
	streetStore = convertVietnames(streetStore);
	const timeChoose = "${timeChoose}";
	const fullName = "${fullName}";
	const pathImgStaff = "${pathImgStaff}";
	const payment = "${payment}";
	const dateBook = "${dateBook}";
	const idShiftBook = "${idShiftBook}";
	const idStaffBook = "${idStaffBook}";
	let servicesChoose = "${servicesChoose}";
	servicesChoose = convertVietnames(servicesChoose);
	const streetEle = document.querySelector(".street-booking");
    streetEle.textContent = streetStore;
    const servicesChoosEle = document.querySelector(".service-booking");
    servicesChoosEle.textContent = servicesChoose;

    console.log( { dateBook, dayOfWeek, monthOfYear, phoneBook, streetStore, 
    timeChoose, fullName, pathImgStaff, payment, idShiftBook, idShiftBook, idStaffBook, servicesChoose } );
</script>
<script src="client/script/booking/booking_done.js"></script>