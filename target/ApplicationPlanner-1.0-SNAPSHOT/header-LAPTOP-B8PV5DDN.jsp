<%--
  Created by IntelliJ IDEA.
  User: aliam
  Date: 18/01/2022
  Time: 09:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Appointment Planner</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link ${param.active}" aria-current="page" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${param.active}" href="register.jsp">Register</a>
                    </li>
                    <c:if test="${not empty user}">
                        <li class="nav-item">
                            <a class="nav-link ${param.active}" href="Controller?command=MyBusiness">My Businesses</a>
                        </li>
                    </c:if>

                    <c:if test="${not empty user}">


                        <li class="nav-item">
                            <a class="nav-link ${param.active}" href="Controller?command=FindServicePage">Find Services</a>
                        </li>

                    </c:if>

                    <c:if test="${not empty user}">


                        <li class="nav-item">
                            <a class="nav-link ${param.active}" href="Controller?command=UserPage">My Appointments</a>
                        </li>

                    </c:if>

                    <c:if test="${not empty user}">


                        <li class="nav-item">
                            <a class="nav-link ${param.active}" href="Controller?command=ProfilePage">Profile</a>
                        </li>

                    </c:if>


                </ul>
            </div>
        </div>
    </nav>
</header>
