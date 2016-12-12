<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="notes" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<notes:layout title="Add or update note">
    <h2>
        <c:choose>
            <c:when test="${note['new']}">
                Adding note
            </c:when>
            <c:otherwise>
                Updating note
            </c:otherwise>
        </c:choose>
    </h2>

    <form:form modelAttribute="note" class="form-horizontal">
        <div class="form-group row" class="has-feedback">
            <notes:inputField label="Name" name="name" type="text"
                               input="form-group"/>
            <notes:inputField label="E-mail" name="email" type="text"
                               input="form-group"/>

        </div>
        <div class="form-group row">
            <div class="col-sm-offset-2 col-sm-8">
                <button class="btn btn-primary" type="submit">
                    <c:choose>
                        <c:when test="${note['new']}">
                            Add note
                        </c:when>
                        <c:otherwise>
                            Update note
                        </c:otherwise>
                    </c:choose>
                </button>
            </div>
        </div>
    </form:form>
</notes:layout>

