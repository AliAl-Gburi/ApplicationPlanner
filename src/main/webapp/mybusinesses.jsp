<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aliam
  Date: 18/01/2022
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<div class="container">
    <jsp:include page="header.jsp">
        <jsp:param name="active" value="active"/>
    </jsp:include>
    <c:choose>
        <c:when test="${not empty businesses}">
            <div class="flexer">
                <c:forEach var="business" items="${businesses}">
                    <div class="card" style="width: 18rem; margin: 10px;">
                        <img src="images/download.jfif" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${business.name}</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="Controller?command=BusinessPage&bid=${business.businessid}" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </c:when>
        <c:otherwise>
            <p>You got none chief</p>
        </c:otherwise>
    </c:choose>

    <a href="createbusiness.jsp">Create Business</a>
</div>

</body>
</html>
