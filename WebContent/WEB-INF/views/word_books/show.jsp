<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${wordBook != null}">
                <h2><c:out value="${wordBook.title}"></c:out></h2>
                <p><a href="<c:url value='/words/new' />">word 追加</a></p>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <pre><c:out value="${wordBook.comment}" /></pre>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <table id="word_list">
                    <tbody>
                        <c:forEach var="word" items="${words}" varStatus="status">
                            <tr class="row${status.count % 2}">
                                <td class="report_title"><a href="<c:url value='/reports/show?id=${report.id}' />">${word.word}</a></td>
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

        <p><a href="<c:url value="/" />">マイページ</a></p>
    </c:param>
</c:import>