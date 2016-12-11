<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="notes" tagdir="/WEB-INF/tags" %>

<%@ attribute name="title" required="true" %>
<%@ attribute name="css" required="false" %>


<!DOCTYPE html>
<html>
<notes:htmlHeader css="${css}"/>

<body>

<div class="container">

  <jsp:doBody/>

</div>
<notes:footer />

</body>

</html>
