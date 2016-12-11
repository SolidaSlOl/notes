<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="css" required="false" %>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>${title}</title>
  <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
  <link href="${bootstrapCss}" rel="stylesheet"/>
  <link href="${css}" rel="stylesheet"/>
</head>
