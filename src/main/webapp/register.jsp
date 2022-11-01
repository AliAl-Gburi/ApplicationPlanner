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
    <jsp:param name="title" value="Register"/>
</jsp:include>
<body class="contact pb-4">

<div class="container">
    <jsp:include page="header.jsp">
        <jsp:param name="active" value="active"/>
    </jsp:include>

    <main>

        <form action="Controller?command=Register" method="post">
            <div class="card mycard">
                <h2 class="text-center mt-3">Register</h2>
                <div class="mb-3">
                    <label class="form-label" for="email">Email <span class="required">*</span></label><input
                        type="text" name="email" class="form-control" id="email">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="password">Password <span class="required">*</span></label><input
                        type="password" name="password" class="form-control" id="password">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="username">Username <span class="required">*</span></label><input
                        type="text" name="username" class="form-control" id="username">
                </div>
                <div class="mb-3">
                    <input type="submit" class="form-control btn btn-primary" id="submit" value="Sign Up">
                </div>
            </div>
        </form>
    </main>
</div>

</body>
</html>
