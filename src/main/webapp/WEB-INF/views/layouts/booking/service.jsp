<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="main" style="background-color: rgb(238, 238, 238)">
	<div class="container">
		<form action="" id="formSubmitService" method="post">
			<div class="booking-screen">
				<div class="body-relative relative">
					<div class="top-navigator">
					<img src="https://30shine.com/static/media/arrowLeft.3e6be3da.svg"
							alt=""> <span>Chọn dịch vụ</span>
						<div class="note-price">1k = 1000đ</div>
					</div>
					<div class="floating-service"></div>

					<div class="booking-service">
						<div class="service-category">
							<div class="ant-anchor-wrapper">
								<div class="ant-anchor">
									<div class="swiper-container">
										<div class="swiper-wrapper">
											<c:forEach var="item" items="${categories}">
												<div class="swiper-slide">
													<div class="ant-anchor-link">
														<a href="${rootUrl}#category${item.idTypeService}"
															class="ant-anchor-link-title"> ${item.nameType} </a>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="padding-8">
							<div class="bot-message"
								style="display: flex; width: 100%; margin-left: 0;">
								<img
									src="https://30shine.com/static/media/bot_avatar_1654_1.26e1da41.jpg"
									alt="">
								<div class="content-message">
									<p>Ngoài gói Shine Combo 10 bước nổi tiếng, chúng em còn có
										rất nhiều gói Chăm sóc da, Lấy ráy tai và Uốn/Nhuộm dùng kèm
										rất tốt nữa đó</p>
								</div>
							</div>
						</div>

						<c:forEach var="item" items="${categories}">
							<div id="category${item.idTypeService}" class="pad-lef-rigth-2"
								data-type="${item.idTypeService}">
								<div class="service">
									<div class="service-category">
										<div class="category__name">${item.nameType}</div>
										<div class="category__number">${item.amount}dịch vụ</div>
									</div>
									<div class="service-list">
										<div class="grid gap-4 grid-cols-2 list-services"
											data-type="${item.idTypeService}"></div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
					<div class="new-affix-v2">
						<div class="content-step">
							<div class="button-next btn-inactive">
								<span>Chọn dịch vụ</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div style="display: none">
			<c:forEach var="item" items="${servicesBooked}">
				<input class="value-service" value="${item.idService}">
			</c:forEach>
		</div>
	</div>
</div>

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<script>
	const swiper = new Swiper('.swiper-container', {
		slidesPerView : 1,
		spaceBetween : 10,
		pagination : {
			el : '.swiper-pagination',
			clickable : true,
		},
		slidesPerView : "auto",
		slidesBetween : "auto",
	});
	const services = ${services};
</script>
<script src="client/script/booking/service.js">
</script>
