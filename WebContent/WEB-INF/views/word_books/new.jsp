<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>単語帳 作成</h2>

        <form method="POST" action="<c:url value='/word_books/create' />">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="<c:url value='/' />">単語帳一覧</a></p>
    </c:param>
</c:import>