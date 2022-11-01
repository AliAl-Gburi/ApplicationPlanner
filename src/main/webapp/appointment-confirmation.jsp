<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aliam
  Date: 20/01/2022
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="${business.name}"/>
</jsp:include>
<body>
<div class="container">
    <jsp:include page="header.jsp">
        <jsp:param name="active" value="active"/>
    </jsp:include>
    <h2>Confirm Appointment</h2>
    <p>Service: ${svc.name}</p>
    <p>Date: ${date}, ${time}</p>
    <a href="Controller?command=ConfirmAppointment&date=${date}&time=${time}&sid=${svc.serviceid}">Yes</a>
    <a href="Controller?command=MakeAppointmentPage&sid=${svc.serviceid}">No</a>
</div>

</body>
</html>
