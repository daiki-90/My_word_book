<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${wordBook != null}">
                <h2><c:out value="${wordBook.title}"></c:out></h2>

                <table>
                    <tbody>
                        <tr>
                            <td>
                                <pre><c:out value="${wordBook.comment}" /></pre>
                            </td>
                        </tr>

                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/" />">マイページ</a></p>
    </c:param>
</c:import>