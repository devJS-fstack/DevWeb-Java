<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="main" style="background-color: rgb(238, 238, 238)">
    <div class="container">
        <div class="booking-screen">
            <div class="body-relative relative">
                <div class="top-navigator">
                    <span>Đặt lịch giữ chỗ</span>
                </div>
                <div class="main-screen">
                    <div class="main-screen__block main-screen__block--active">
                        <div class="first-item"></div>
                        <div class="title-header__booking">
                            1. Chọn salon
                        </div>
                        <div class="bot-message">
                            <img src="https://30shine.com/static/media/bot_avatar_1654_1.26e1da41.jpg" alt="">
                            <div class="content-message">
                                <p>
                                    Đầu tiên anh ${nameCustomer} chọn "Tìm salon gần anh" ở ngay bên dưới để tìm Salon
                                    thuận tiện nhất nhé!
                                </p>
                            </div>
                        </div>
                        <div class="item-center">
                            <div class="salon-icon">
                                <img src="https://30shine.com/static/media/homeOutline.76facfa5.svg" alt="">
                                <div class="salon-icon--active">
                                    <div class="salon-icon--active__iner"></div>
                                    <div class="salon-icon--active__outner"></div>
                                </div>
                            </div>

                            <div class="salon-title">
                                ${streetName}
                            </div>

                            <div class="salon-icon--right">
                                <img src="https://30shine.com/static/media/caretRight.b0d191b3.svg" alt="">
                            </div>
                        </div>
                        <div class="text-validate">Anh vui lòng chọn salon trước để xem lịch còn trống ạ!</div>
                    </div>
                    <div class="main-screen__block">
                        <div class="title-header__booking">
                            2. Chọn dịch vụ
                        </div>
                        <div class="bot-message">
                            <img src="https://30shine.com/static/media/bot_avatar_1654_1.26e1da41.jpg" alt="">
                            <div class="content-message">
                                <p>
                                    Anh ${nameCustomer} chọn trước dịch vụ bên dưới để chúng em chuẩn bị chu đáo ạ
                                </p>
                            </div>
                        </div>
                        <div class="item-center">
                            <div class="salon-icon">
                                <img src="https://30shine.com/static/media/service.3a62b101.svg" alt="">
                                <div class="salon-icon--active">
                                    <div class="salon-icon--active__iner"></div>
                                    <div class="salon-icon--active__outner"></div>
                                </div>
                            </div>
                            <div class="salon-title service-title">
                                ${titleService}
                            </div>
                            <div class="salon-icon--right">
                                <img src="https://30shine.com/static/media/caretRight.b0d191b3.svg" alt="">
                            </div>
                        </div>
                        <div class="text-validate">Mời anh chọn dịch vụ để có stylist và giờ cắt phù hợp ạ!</div>
                        <div class="block-box">
                        <c:if test="${not empty servicesBooked}">
                            <div class="mt-4">
                                <div
                                    style="display:flex;flex-wrap: wrap;margin-left: -0.375rem;margin-right: -0.375rem;">
                                    <c:forEach var="item" items="${servicesBooked}">
                                    	<div class="name-service__booked">
                                    		${item.nameService}
                                    	</div>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                        </div>
                    </div>
                    <div class="main-screen__block">
                        <div class="title-header__booking">
                            3. Chọn ngày, giờ & stylist
                        </div>
                        <div class="bot-message">
                            <img src="https://30shine.com/static/media/bot_avatar_1654_1.26e1da41.jpg" alt="">
                            <div class="content-message">
                                <p>
                                    Anh ${nameCustomer} chọn Stylist riêng cho mình ạ
                                </p>
                            </div>
                        </div>
                        <div class="style-list dis-none" id="style-list">
                            <div class="style-list__dropdown pointer flex">
                                <span class="flex">
                                    <img src="https://30shine.com/static/media/user-large.69c611a8.svg" alt="">
                                </span>
                                <span class="sty-title">Chọn Stylist</span>
                                <span class="flex item-center" style="background-color: transparent;">
                                    <img class="img-drop"
                                        src="https://30shine.com/static/media/chevronRight.fe25caf9.svg" alt="">
                                </span>
                            </div>

                            <div class="content hide-stylist">
                                {{!-- <div class="left isActive">
                                    <div>
                                        <div class="user-default relative pointer">
                                            <img src="https://30shine.com/static/media/account_circle%20-%20yellow.d917c981.svg"
                                                alt="" class="img-user">
                                            <img src="https://30shine.com/static/media/checkYellow.02dbd103.svg" alt=""
                                                class="icon-check-default">
                                        </div>
                                    </div>

                                    <div>
                                        <span>
                                            30 shine
                                            <br>Chọn Hộ Anh
                                        </span>
                                    </div>
                                </div> --}}

                            </div>
                        </div>

                        <div class="block-box date-drop mt-2">
                            <div class="relative">
                                <div class="item-center">
                                    <div class="salon-icon">
                                        <img src="https://30shine.com/static/media/calendar-2.3c77d299.svg" alt="">
                                        <div class="salon-icon--active">
                                            <div class="salon-icon--active__iner"></div>
                                            <div class="salon-icon--active__outner"></div>
                                        </div>
                                    </div>
                                    <div class="salon-title__item">
                                        <div class="salon-title__item--center">
                                        </div>

                                    </div>
                                    <div class="salon-icon--right">
                                        <img class="date-drop__icon"
                                            src="https://30shine.com/static/media/caretRight.b0d191b3.svg" alt="">
                                    </div>
                                </div>

                                <div class="drop-shadow drop-date opacity-0">
                                </div>
                            </div>
                        </div>
                        <div class="box-time" id="box-time">
                            <div class="relative">
                                <div class="swiper-container">
                                    <div class="swiper-wrapper swiper__shift">


                                    </div>


                                </div>
                                <div class="swiper-button-prev swiper__button dis-none">
                                    <span class="swiper_button__icon">
                                        <svg viewBox="64 64 896 896" focusable="false" class="" data-icon="left"
                                            width="1em" height="1em" fill="currentColor" aria-hidden="true">
                                            <path
                                                d="M724 218.3V141c0-6.7-7.7-10.4-12.9-6.3L260.3 486.8a31.86 31.86 0 000 50.3l450.8 352.1c5.3 4.1 12.9.4 12.9-6.3v-77.3c0-4.9-2.3-9.6-6.1-12.6l-360-281 360-281.1c3.8-3 6.1-7.7 6.1-12.6z">
                                            </path>
                                        </svg>
                                    </span>
                                </div>
                                <div class="swiper-button-next swiper__button dis-none">
                                    <span class="swiper_button__icon">
                                        <svg viewBox="64 64 896 896" focusable="false" class="" data-icon="right"
                                            width="1em" height="1em" fill="currentColor" aria-hidden="true">
                                            <path
                                                d="M765.7 486.8L314.9 134.7A7.97 7.97 0 00302 141v77.3c0 4.9 2.3 9.6 6.1 12.6l360 281.1-360 281.1c-3.9 3-6.1 7.7-6.1 12.6V883c0 6.7 7.7 10.4 12.9 6.3l450.8-352.1a31.96 31.96 0 000-50.4z">
                                            </path>
                                        </svg>

                                    </span>
                                </div>
                            </div>
                        </div>
                        <div style="height: 120px"></div>
                    </div>
                    <div class="new-affix-v2">
                        <div class="content-step time-line space-between flex text-center">
                            <div class="button-finally btn-inactive pointer">
                                <span>Hoàn tất</span>
                            </div>
                            <span class="sub-description">Cắt xong trả tiền, hủy lịch không sao</span>
                        </div>

                    </div>


                </div>

            </div>
        </div>
        <form id="chooseStore" action="/booking/?phone={{_user.phoneUser}}&storeId=0&step=1" method="POST"></form>
        <form method="POST" id="book" style="display: none"></form>
    </div>
</div>

<script>
    const shiftSwiper = document.querySelector('.swiper__shift');
</script>


<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="https://momentjs.com/downloads/moment.js"></script>
<script>
	let shifts = ${shifts};
	let staffsInDate1 = ${staffsInDate1};
    let staffsInDate2 = ${staffsInDate2};
    let staffsInDate3 = ${staffsInDate3};
    let staffsInDate4 = ${staffsInDate4};
    let staffsInDate5 = ${staffsInDate5};
    let staffsInDate6 = ${staffsInDate6};
    let bookedInDates = ${bookedInDates};

    const mapRawToStaffInDate = (staffsInDate, dateRegis, store) => {
        return {
            CCCD: staffsInDate?.cccd,
            City: store?.city,
            DateRegis: moment(dateRegis?.dateRegis).format("YYYY-MM-DD"),
            Gender: staffsInDate?.gender,
            IDStaff: staffsInDate?.idStaff,
            IDStore: store?.idStore,
            NameStaff: staffsInDate?.nameStaff,
            PathImgStaff: staffsInDate?.pathImgStaff,
            SurName: staffsInDate?.surName,
        }
    };

    const mapRawToBookedInDate = (bookedInDate) => {
        return {
            DateBook: moment(bookedInDate.dateBook).format("yyyy-MM-dd"),
            IDShiftBook: bookedInDate.idShiftBook,
            IDStaff: bookedInDate.idStaff,
            Payment: bookedInDate.payment,
            PhoneCustomer: bookedInDate.phoneCustomer,
            IDStore: bookedInDate.idStore,
            StatusBook: bookedInDate.statusBook,
        }
    }

    const mapRawDataToShift = (shift) => {
        return {
            IDShift: shift.idShift,
            HourStart: shift.hourStart,
            MinuteStart: shift.minuteStart
        }
    }

    const mapRawDataToServiceBooked = (service) => {
        return {
            Description: service?.description,
            IDService: service?.idService,
            ListPrice: service?.price,
            NameService: service?.nameService,
            TypeService: service?.typeService,
        }
    }

    shifts = shifts.map(shift => mapRawDataToShift(shift));

    staffsInDate1 = staffsInDate1.map(staff => mapRawToStaffInDate(staff?.[0], staff?.[1], staff?.[0]?.store));
    staffsInDate2 = staffsInDate2.map(staff => mapRawToStaffInDate(staff?.[0], staff?.[1], staff?.[0]?.store));
    staffsInDate3 = staffsInDate3.map(staff => mapRawToStaffInDate(staff?.[0], staff?.[1], staff?.[0]?.store));
    staffsInDate4 = staffsInDate4.map(staff => mapRawToStaffInDate(staff?.[0], staff?.[1], staff?.[0]?.store));
    staffsInDate5 = staffsInDate5.map(staff => mapRawToStaffInDate(staff?.[0], staff?.[1], staff?.[0]?.store));
    staffsInDate6 = staffsInDate6.map(staff => mapRawToStaffInDate(staff?.[0], staff?.[1], staff?.[0]?.store));

    bookedInDates = bookedInDates.map(booked => mapRawToBookedInDate(booked));
    const bookedInDate1 = (bookedInDates ?? []).filter(booked => booked?.DateBook === moment().format("yyyy-MM-dd"));
    const bookedInDate2 = (bookedInDates ?? []).filter(booked => booked?.DateBook === (moment().add(1, "days").format("yyyy-MM-dd")));
    const bookedInDate3 = (bookedInDates ?? []).filter(booked => booked?.DateBook === (moment().add(2, "days").format("yyyy-MM-dd")));
    const bookedInDate4 = (bookedInDates ?? []).filter(booked => booked?.DateBook === (moment().add(3, "days").format("yyyy-MM-dd")));
    const bookedInDate5 = (bookedInDates ?? []).filter(booked => booked?.DateBook === (moment().add(4, "days").format("yyyy-MM-dd")));
    const bookedInDate6 = (bookedInDates ?? []).filter(booked => booked?.DateBook === (moment().add(1, "days").format("yyyy-MM-dd")));
    
    const rawServicesBooked = ${jsonServicesBooked}
    const serviceBooked = (rawServicesBooked ?? []).map(service => mapRawDataToServiceBooked(service));
    

</script>
<script src="client/script/booking/index.js"></script>