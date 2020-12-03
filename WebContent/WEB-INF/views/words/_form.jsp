<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="title">ワード</label><br />
<input type="text" name="word" value="${word.word}" />
<br /><br />

<label for="content">意味</label><br />
<textarea name="content" rows="10" cols="50">${word.content}</textarea>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">追加</button>
