<%@ page import="org.pronet.app.models.Teacher" %>
<%@ page import="org.pronet.app.services.TeacherService" %>
<%@ page import="org.pronet.app.utils.ParameterUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    final TeacherService teacherService = new TeacherService();
    final long id = ParameterUtil.getLongValue(request.getParameter("id"));
    final Teacher foundTeacher = teacherService.getById(id);
%>

<html>
<head>
    <title>Teacher details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 class="text-center">Teacher details</h3>
    <br>
    <div class="card">
        <div class="card-header">
            Who is <%= foundTeacher.getFirstName() + " " + foundTeacher.getLastName() %>?
        </div>
        <div class="card-body">
            <p>
                <b>First name:</b> <%= foundTeacher.getFirstName() %> <br>
                <b>Last name:</b> <%= foundTeacher.getLastName() %> <br>
                <b>Email:</b> <%= foundTeacher.getEmail() %>
            </p>
        </div>
    </div>
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
