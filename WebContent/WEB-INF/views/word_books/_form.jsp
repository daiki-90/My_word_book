<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<div id="form">
    <label for="wordBook_date">日付</label><br />
    <input type="date" name="wordBook_date" value="<fmt:formatDate value='${wordBook.wordBook_date}' pattern='yyyy-MM-dd' />" />
    <br /><br />

    <label for="name">名前</label><br />
    <div id="login_user_name">
        <c:out value="${sessionScope.login_user.name}" />
    </div>
    <br /><br />

    <label for="title">タイトル</label><br />
    <input type="text" name="title" value="${wordBook.title}" />
    <br /><br />

    <label for="content">内容</label><br />
    <textarea name="comment" rows="10" cols="50">${wordBook.comment}</textarea>
    <br /><br />

    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">作成</button>
    <br />
</div>
