<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
        <c:when test="${not empty user.getProfilePicPath()}">
            <img src="profilepics/${user.getUserid()}.jpg" width="200" alt=""/>
        </c:when>
        <c:otherwise>
            <img src="images/stock.jpg" width="200" alt=""/>
        </c:otherwise>
    </c:choose>
    <p>Email: ${user.getEmail()}</p>
    <p>Username: ${user.getUsername()}</p>

    <p>Change your profile picture:</p>
    <form action="Controller?command=UploadPhoto" method="post" enctype="multipart/form-data">
        <input type="file" id="file" name="file" value="Select Image"/>
        <input type="submit" value="Upload"/>
    </form>
</div>

</body>
</html>
