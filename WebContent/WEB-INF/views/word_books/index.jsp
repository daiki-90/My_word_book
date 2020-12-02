<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h3>マイページ</h3>
        <c:forEach var="wordBook" items="{wordBooks}">
            <ul>
                <li><c:out value="${wordbooks.name}" /></li>
            </ul>
        </c:forEach>

        <
        <div id="pagination">
            （全 ${wordBooks_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((reports_count - 1) / 10) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/reports/new' />">新規作成</a></p>
    </c:param>
</c:import>
