<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${word != null}">
                <div id="word-title">
                    <h2><c:out value="${word.word}"/></h2>
                </div>
                <div id="word-acd">
                    <input id="acd-check1" class="acd-check" type="checkbox">
                    <label class="acd-label" for="acd-check1">意味(クリック) <i class="far fa-hand-point-up"></i></label>
                    <div class="acd-content">
                        <pre><c:out value="${word.content}" /></pre>
                    </div>
                </div>
                <br><br>

                <div id="next">
                    <p><a href="<c:url value='/words/random?id=${sessionScope.wordBook_id}' />">next <i class="fas fa-forward"></i></a></p>
                </div>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/word_books/show?id=${sessionScope.wordBook_id}" />">一覧に戻る</a></p>
    </c:param>
</c:import>