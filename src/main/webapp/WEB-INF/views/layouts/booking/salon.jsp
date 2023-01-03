<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<base href="${pageContext.servletContext.contextPath}/">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>

<div class="main" style="background-color: rgb(238, 238, 238)">
    <div class="container">
        <div class="row">
           <c:forEach var="store" items="${stores}">
            <div class="col-sm-6 col-lg-4">
                <div class="card mt-4" style="width: 18rem;">
                    <img class="card-img-top" src="${store.pathImg}" alt=" Card image cap">
                    <div class="card-body" style="display:inline-block;">
                        <h5 class="card-title">${store.city}</h5>
                        <p class="card-text">${store.street}</p>
                        <a href="#" class="btn-choose__store btn btn-primary">Chọn salon</a>
                    </div>
                </div>
                <input class="flag-idStore" type="text" style="display:none" value="${store.idStore}">
            </div>
            </c:forEach>
        </div>
        <form id="chooseStore" method="post"></form>
    </div>
</div>

<script src="client/script/booking/salon.js">
</script>