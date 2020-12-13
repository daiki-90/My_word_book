<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${word != null}">
                <h2><c:out value="${word.word}" /></h2>
                <div id="word_contents">
                    <p><a href="<c:url value='/words/rshow?id=${word.id}' />">contents</a></p>
                </div>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/word_books/show?id=${sessionScope.wordBook_id }' />">一覧</a></p>
    </c:param>
</c:import>