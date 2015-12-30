<%@include file="../common/taglib-includes.jsp" %>
<div class="row">
    <div class="col s12 m4 offset-m4">
        <div class="card">
            <c:url var="registerUrl" value="/register"/>
            <form:form commandName="userVo" action="${registerUrl}" method="post">
                <div class="card-image">
                    <img src="<c:url value='/res/img/welcome.jpg' />">
                    <span class="card-title">Register</span>
                </div>
                <div class="card-content">
                    <div class="row">
                        <div class="col s12">
                            <div class="row">
                                <div class="input-field col s12 m6">
                                    <form:input path="name" type="text" class="validate" cssErrorClass="validate invalid"/>
                                    <label for="name">Name</label>
                                </div>
                                <div class="input-field col s12 m6">
                                    <form:input path="surname" type="text" class="validate" cssErrorClass="validate invalid"/>
                                    <label for="surname">Surname</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <form:input path="email" type="email" class="validate" cssErrorClass="validate invalid"/>
                                    <label for="email">Email</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <form:input path="password" type="password" class="validate" cssErrorClass="validate invalid"/>
                                    <label for="password">Password</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="confirm-password" name="confirm-password" type="password" class="validate"/>
                                    <label for="confirm-password">Password</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-action">
                    <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</div>