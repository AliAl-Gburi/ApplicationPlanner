<%--
  Created by IntelliJ IDEA.
  User: aliam
  Date: 18/01/2022
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Create Business"/>
    </jsp:include>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp">
        <jsp:param name="active" value="active"/>
    </jsp:include>
    <main>

        <form action="Controller?command=CreateBusiness" method="post">
            <div class="card mycard">
                <h2 class="text-center mt-3">Create Business</h2>
                <div class="mb-3">
                    <label class="form-label" for="businessname">Name <span class="required">*</span></label><input
                        type="text" name="businessname" class="form-control" id="businessname">
                </div>

                <div class="mb-3">
                    <input type="submit" class="form-control btn btn-primary" id="submit" value="Create">
                </div>
            </div>
        </form>
    </main>
</div>

</body>
</html>
