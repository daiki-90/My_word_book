<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${wordBook != null}">
                <h2>編集</h2>
                <form method="POST" action="<c:url value='/word_books/update' />">
                    <c:import url="_form.jsp" />
                </form>
                 <p><a href="#" onclick="confirmDestroy();">この単語帳を削除</a></p>
                <form method="POST" action="<c:url value='/word_books/destroy' />">
                    <input type="hidden" name="_token" value="${_token}" />
                </form>
                <br />
                <script>
                    function confirmDestroy() {
                        if(confirm("本当に削除してよろしいですか？")) {
                            document.forms[1].submit();
                        }
                    }
                </script>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/' />">単語帳一覧</a></p>
        <br />
    </c:param>
</c:import>