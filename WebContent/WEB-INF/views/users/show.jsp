<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${user != null}">
                <div id="user_id">
                    <h2>id : ${user.id} </h2>
                </div>
                <table>
                    <tbody>

                        <tr>
                            <th>name</th>
                            <td><c:out value="${user.name}" /></td>
                        </tr>
                        <tr>
                            <th>authority</th>
                            <td>
                                <c:choose>
                                    <c:when test="${user.admin_flag == 1}">管理者</c:when>
                                    <c:otherwise>一般</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>

                    </tbody>
                </table>

                <p><a href="<c:url value='/users/edit?id=${user.id}' />">編集</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/users/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>
