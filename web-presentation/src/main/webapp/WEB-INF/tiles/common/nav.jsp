<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="red" role="navigation">
  <div class="nav-wrapper container">
    <a id="logo-container" href="#" class="brand-logo">Logo</a>
    <ul class="right hide-on-med-and-down">
      <jsp:include page="nav-list.jsp" >
        <jsp:param name="textColor" value="white" />
      </jsp:include>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <jsp:include page="nav-list.jsp" >
        <jsp:param name="textColor" value="black" />
      </jsp:include>
    </ul>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>