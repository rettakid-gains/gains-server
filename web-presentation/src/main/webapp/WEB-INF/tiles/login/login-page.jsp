<%@include file="../common/taglib-includes.jsp" %>
<div class="row">
    <div class="col s12 m4 offset-m4">
        <div class="card">
            <c:url var="loginUrl" value="/login"/>
            <form:form commandName="loginVo" action="${loginUrl}/" method="post">
                <div class="card-image">
                    <img src="<c:url value='/res/img/welcome.jpg' />">
                    <span class="card-title">Login</span>
                </div>
                <div class="card-content">
                    <div class="row">
                        <div class="col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <form:input path="email" type="text" class="validate" cssErrorClass="validate invalid"/>
                                    <label for="email">User</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <form:input path="password" type="password" class="validate" cssErrorClass="validate invalid"/>
                                    <label for="password">Password</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-action">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                        <i class="material-icons right">send</i>
                    </button>
                    <a href="<c:url value="/register" />" class="btn" >Sign Up</a>
                </div>
            </form:form>
        </div>
    </div>
</div>