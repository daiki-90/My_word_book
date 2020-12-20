<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${word != null}">
                <h2><c:out value="${word.word}"/></h2>

                <table>
                    <tbody>
                        <tr>
                            <th>意味</th>
                            <td>
                                <pre><c:out value="${word.content}" /></pre>
                            </td>
                        </tr>
                    </tbody>
                </table>
                    <p><a href="<c:url value="/words/edit?id=${word.id}" />">編集</a></p>
                    <br><br>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/word_books/show?id=${sessionScope.wordBook_id}" />">一覧に戻る</a></p>
    </c:param>
</c:import>