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
    <p>Warning! This action cannot be undone. All services of this business will also be removed. All appointments will be cancelled.</p>
    <p>Are you sure you want to delete ${business.getName()}</p>
    <a href="Controller?command=ConfirmDeleteBusiness&bid=${business.businessid}">Yes</a><a href="Controller?command=BusinessPage&bid=${business.businessid}">No</a>
</div>

</body>
</html>
