<%@ page import="org.pronet.app.services.TeacherService" %>
<%@ page import="org.pronet.app.models.Teacher" %>
<%@ page import="org.pronet.app.utils.ParameterUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    final TeacherService teacherService = new TeacherService();
    final long id = ParameterUtil.getLongValue(request.getParameter("id"));
    final Teacher foundTeacher = teacherService.getById(id);
%>

<html lang="en">
<head>
    <title>Edit teacher</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 class="text-center">Edit teacher</h3>
    <br>
    <br>
    <form action="../../index.jsp" method="post">
        <input type="hidden" id="id" name="id" value="<%= id %>">
        <input type="hidden" id="actionType" name="actionType" value="edit">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="firstName" name="firstName"
                   placeholder="First name" value="<%= foundTeacher.getFirstName() %>">
            <label for="firstName">First name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="lastName" name="lastName"
                   placeholder="Last name" value="<%= foundTeacher.getLastName() %>">
            <label for="lastName">Last name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="email" class="form-control" id="email" name="email"
                   placeholder="Email" value="<%= foundTeacher.getEmail() %>">
            <label for="email">Email</label>
        </div>
        <div class="form-floating mb-3">
            <button type="submit" class="btn btn-success">Save</button>
            <a href="../../index.jsp" class="btn btn-dark">Back</a>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
