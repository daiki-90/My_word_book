<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <form method="POST" action="<c:url value='/words/create?id=${wordBook_id}' />">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="<c:url value='/word_books/show?id=${wordBook_id}' />">一覧</a></p>
    </c:param>
</c:import>