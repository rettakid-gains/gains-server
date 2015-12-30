<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <li><a href="<c:url value="/home" />" class="<c:out value="${param.textColor}"/>-text">Home</a></li>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <li><a href="<c:url value="/login" />" class="waves-effect waves-light btn">Login / Sign up</a></li>
</sec:authorize>