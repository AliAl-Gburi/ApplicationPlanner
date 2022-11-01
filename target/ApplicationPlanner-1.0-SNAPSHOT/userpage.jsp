<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aliam
  Date: 2/5/2022
  Time: 5:25 AM
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
    <c:choose>
        <c:when test="${not empty appointments}">
            <table class="table table-hover">
                <thead>
                    <td>
                        Service
                    </td>
                    <td>Date</td>
                </thead>
                <c:forEach var="appointment" items="${appointments}">
                    <tr>
                        <td>${appointment.getServiceName()}</td>
                        <td>${appointment.getSimpleTime()} ${appointment.getAppointmentDay()}</td>
                        <td><a href="Controller?command=CancelAppointment&aid=${appointment.getAppointmentid()}">Cancel</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>You do not have any booked appointments yet</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
