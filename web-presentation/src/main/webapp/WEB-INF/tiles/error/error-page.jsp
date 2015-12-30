<%@include file="../common/taglib-includes.jsp" %>
<style>
    .error-background p{
        top:40%;
        position: absolute;
    }
    .error-background h1{
        top:10%;
        left:30%;
        position: absolute;
    }
    .error-background img{
        width:100%;
        height:auto;
    }

</style>
<div class="full-width full-height error-background">
    <h1 class="white-text">OOPS</h1>
    <p class="flow-text white-text"><c:out value="${error}"/></p>
    <img src="<c:url value="/res/img/error-image.jpg" />">
</div>