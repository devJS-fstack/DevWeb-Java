<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<div id="carouselExampleIndicators" class="carousel slide"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img class="d-block w-100"
				src="https://storage.30shine.com/banner/20220119_BannerSC100_w.jpg"
				alt="First slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100"
				src="https://storage.30shine.com/banner/220126_BannerUon_w.jpg"
				alt="Second slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100"
				src="https://storage.30shine.com/banner/210814_Banner_toa_sang_w.jpg"
				alt="Third slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100"
				src="https://storage.30shine.com/banner/210814_Banner_an_toan_w.jpg"
				alt="Fourth slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100"
				src="https://storage.30shine.com/banner/20220210_Banner_30Shine_Moca_w.jpg"
				alt="Fiveth slide">
		</div>
	</div>
	<a class="carousel-control-prev" href="#carouselExampleIndicators"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>
<form id="form-booking" action="/booking/?phone={{{phoneCustomer}}}"
	method="POST">
	<div class="card mt-4">
		<div class="card-header">?????t l???ch gi??? ch??? ch??? 30 gi??y</div>
		<div class="card-body">
			<h5 class="card-title" style="margin-top: 10px; margin-bottom: 0">C???t
				xong tr??? ti???n, h???y l???ch kh??ng sao</h5>
			<input type="number" pattern="((09|03|07|08|05)+([0-9]{8})\b)"
				required class="form-control wid-40pt" aria-label="Small"
				aria-describedby="inputGroup-sizing-sm"
				placeholder="Nh???p S??T ????? ?????t l???ch" name="inputPhone"
				id="input-phone">
			<button class="btn-booking btn btn-primary">?????t l???ch ngay</button>
		</div>
	</div>
</form>

<div class="list-booking-infor"></div>
<div class="home mt-4">
	<div class="layout layout-service">
		<div class="container">
			<a href="category-service.htm">
				<div class="layout__head">
					<div>
						<div class="head__title">Tr???i nghi???m d???ch v???</div>
						<div class="head__title head__sub-title">Th?? gi??n 30 ph??t v??
							b???n s??? t???a s??ng</div>
					</div>
					<div class="head__text-view-all">
						<span>Xem t???t c???</span> <img
							src="https://30shine.com/static/media/chevronRight.0f447c60.svg"
							alt="">
					</div>
				</div>
			</a>
			<div class="layout__banner hover">
				<a href="category-service.htm">
					<div class="banner__media">
						<img
							src="https://storage.30shine.com/ResourceWeb/data/images/home/20220104-30shine-banner-shine-combo-1.jpg"
							alt="">
					</div>
				</a>
			</div>
			<div class="layout__list">
				<div class="ant-row"
					style="margin-left: -15px; margin-right: -15px;">
					<div class="ant-col ant-col-xs-24 ant-col-md-12 ant-col-lg-6"
						style="padding-left: 15px; padding-right: 15px;">
						<a href="">
							<div class="list__item pointer border-none list__item-hover">
								<div class="item__media">
									<img
										src="https://storage.30shine.com/ResourceWeb/data/images/newHome/service/30shine-cat-goi-massage-2.jpg"
										alt="">
								</div>
								<div class="item__content">
									<div class="item__title">C???t g???i massage</div>
									<div class="item__subTitle">B???ng gi?? 2022(h???p d???n)</div>
								</div>
							</div>

						</a>
					</div>
					<div class="ant-col ant-col-xs-24 ant-col-md-12 ant-col-lg-6"
						style="padding-left: 15px; padding-right: 15px;">
						<a href="">
							<div class="list__item pointer border-none list__item-hover">
								<div class="item__media">
									<img
										src="https://storage.30shine.com/ResourceWeb/data/images/newHome/service/30shine-uon-2.jpg"
										alt="">
								</div>
								<div class="item__content">
									<div class="item__title">U???n nh???p kh???u H??n Qu???c</div>
									<div class="item__subTitle">Ch??? t??? 400K</div>
								</div>
							</div>

						</a>
					</div>
					<div class="ant-col ant-col-xs-24 ant-col-md-12 ant-col-lg-6"
						style="padding-left: 15px; padding-right: 15px;">
						<a href="">
							<div class="list__item pointer border-none list__item-hover">
								<div class="item__media">
									<img
										src="https://storage.30shine.com/ResourceWeb/data/images/newHome/service/30shine-nhuom-2.jpg"
										alt="">
								</div>
								<div class="item__content">
									<div class="item__title">Nhu???m th???o d?????c</div>
									<div class="item__subTitle">Ch??? t??? 300K</div>
								</div>
							</div>

						</a>
					</div>
					<div class="ant-col ant-col-xs-24 ant-col-md-12 ant-col-lg-6"
						style="padding-left: 15px; padding-right: 15px;">
						<a href="">
							<div class="list__item pointer border-none list__item-hover">
								<div class="item__media">
									<img
										src="https://storage.30shine.com/ResourceWeb/data/images/newHome/service/30shine-dich-vu-khac-2.jpg"
										alt="">
								</div>
								<div class="item__content">
									<div class="item__title">D???ch v??? kh??c</div>
									<div class="item__subTitle">4 d???ch v???</div>
								</div>
							</div>

						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="layout layout-service">
		<div class="container">
			<a href="discover.htm">
				<div class="layout__head">
					<div>
						<div class="head__title">Kh??m ph?? ki???u t??c</div>
						<div class="head__title head__sub-title">Ngu???n c???m h???ng t???o
							ki???u t??c m???i cho b???n</div>
					</div>
					<div class="head__text-view-all">
						<span>Xem t???t c???</span> <img
							src="https://30shine.com/static/media/chevronRight.0f447c60.svg"
							alt="">
					</div>
				</div>
			</a>
			<div class="layout__banner hover">
				<a href="discover.htm">
					<div class="banner__media">
						<img
							src="https://storage.30shine.com/ResourceWeb/data/images/home/30shine-banner-kham-pha-kieu-to.jpg"
							alt="">
					</div>
				</a>
			</div>
			<div class="layout__list">
				<div class="ant-row"
					style="margin-left: -15px; margin-right: -15px;">
					<div class="ant-col ant-col-xs-24 ant-col-md-12 ant-col-lg-12"
						style="padding-left: 15px; padding-right: 15px;">
						<a href="">
							<div class="list__item pointer border-none list__item-hover">
								<div class="item__media">
									<img
										src="https://storage.30shine.com/ResourceWeb/data/images/home/discover/30shine-kham-pha-kieu-toc-style-mater.png"
										alt="">
								</div>
								<div class="item__content">
									<div class="item__title">Kh??m ph?? ki???u t??c</div>
									<div class="item__subTitle">T??m c???m h???ng m???i cho m??i t??c</div>
								</div>
							</div>

						</a>
					</div>
					<div class="ant-col ant-col-xs-24 ant-col-md-12 ant-col-lg-12"
						style="padding-left: 15px; padding-right: 15px;">
						<a href="">
							<div class="list__item pointer border-none list__item-hover">
								<div class="item__media">
									<img
										src="https://storage.30shine.com/ResourceWeb/data/images/home/discover/30shine-kham-pha-kieu-toc.png"
										alt="">
								</div>
								<div class="item__content">
									<div class="item__title">Style ??a th??ch</div>
									<div class="item__subTitle">BXH c??c ki???u t??c hot trongt
										th??ng</div>
								</div>
							</div>

						</a>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<form id="cancelBookForm"
            method="POST"></form>
<script src="client/script/home/home.js"></script>










