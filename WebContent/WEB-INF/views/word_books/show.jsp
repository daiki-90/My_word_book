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
                                <pre>[<c:out value="${wordBook.comment}" />]</pre>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <p><a href="<c:url value='/words/new?id=${wordBook.id}' />">単語 追加 <i class="fas fa-pencil-alt"></i></a></p>
                <br>
                <p><a href="<c:url value='/words/random?id=${wordBook.id}' />">ランダム表示 <i class="fas fa-random"></i></a></p>
                <br>
                <table id="word_list">
                    <tbody>
                        <c:forEach var="word" items="${words}" varStatus="status">
                            <tr class="row${status.count % 2}">
                                <td class="word_title"><a href="<c:url value='/words/show?id=${word.id}' />">・ ${word.word}</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div id="pagination">
                    （全 ${words_count} 件）<br />
                    <c:forEach var="i" begin="1" end="${((words_count - 1) / 15) + 1}" step="1">
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
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/" />">単語帳一覧</a></p>
    </c:param>
</c:import>