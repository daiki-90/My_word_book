<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>New Word Book 作成</h2>

        <form method="POST" action="<c:url value='/wordBooks/create' />">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="<c:url value='/' />">マイページ</a></p>
    </c:param>
</c:import>