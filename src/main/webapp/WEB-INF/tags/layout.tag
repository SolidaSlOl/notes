<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="notes" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="title" required="true" %>

<!DOCTYPE html>
<html>
<notes:htmlHeader/>

<body>

<div class="container">
  <notes:bodyHeader/>

  <jsp:doBody/>

</div>
<notes:footer />

</body>

</html>
