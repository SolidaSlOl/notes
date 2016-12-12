<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="notes" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<notes:layout title="Home">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="/notes/new" class="btn btn-primary" role="button">
            Add note
        </a>
        <h3>My notes</h3>
        <table class="table">
            <thead class="thead-inverse">
                <tr>
                    <th>Name</th>
                    <th>E-mail</th>
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
                </tbody>
            </c:forEach>
        </table>
    </c:if>
</notes:layout>

