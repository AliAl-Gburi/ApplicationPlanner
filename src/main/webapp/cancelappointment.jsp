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
    <p>Are you sure you want to cancel appointment</p>
    <p>Service: ${appointment.getServiceName()}</p>
    <p>Date: ${appointment.getSimpleTime()} ${appointment.getAppointmentDay()}</p>
    <a href="Controller?command=ConfirmCancelAppointment&aid=${appointment.getAppointmentid()}">Yes</a> <a href="Controller?command=UserPage">No</a>
</div>

</body>
</html>
