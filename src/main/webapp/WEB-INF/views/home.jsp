<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="notes" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<notes:layout title="Home">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <c:if test="${message != null}">
            <h3>${message}</h3>
        </c:if>
        <a href="/notes/new" class="btn btn-primary" role="button">
            Add note
        </a>
        <h3>My notes</h3>
        <table class="table">
            <thead class="thead-inverse">
                <tr>
                    <th>Name</th>
                    <th>E-mail</th>
                    <th>Send e-mail</th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach items="${notes}" var="note">
                <tbody>
                    <td>
                        <c:out value="${note.name}"/>
                    </td>
                    <td>
                        <c:out value="${note.email}"/>
                    </td>
                    <td>
                        <spring:url value="/notes/{noteId}/send" var="noteSend">
                            <spring:param name="noteId" value="${note.id}"/>
                        </spring:url>

                        <a href="${fn:escapeXml(noteSend)} ">
                            <c:out value="Send"/>
                        </a>
                    </td>
                    <td>
                        <spring:url value="/notes/{noteId}/edit" var="noteEdit">
                            <spring:param name="noteId" value="${note.id}"/>
                        </spring:url>

                        <a href="${fn:escapeXml(noteEdit)} ">
                            <c:out value="Change note"/>
                        </a>
                    </td>
                </tbody>
            </c:forEach>
        </table>
    </c:if>
</notes:layout>

