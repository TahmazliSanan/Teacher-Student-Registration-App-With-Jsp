<%@ page import="java.util.List" %>
<%@ page import="org.pronet.app.models.Teacher" %>
<%@ page import="org.pronet.app.services.TeacherService" %>
<%@ page import="org.pronet.app.utils.ParameterUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    final TeacherService teacherService = new TeacherService();
    final long id = ParameterUtil.getLongValue(request.getParameter("id"));
    final String actionType = ParameterUtil.getStringValue(request.getParameter("actionType"));

    if (actionType.equalsIgnoreCase("remove")) {
        teacherService.deleteById(id);
    }

    final String firstName = ParameterUtil.getStringValue(request.getParameter("firstName"));
    final String lastName = ParameterUtil.getStringValue(request.getParameter("lastName"));
    final String email = ParameterUtil.getStringValue(request.getParameter("email"));
    final List<Teacher> teachers = teacherService.getAll(firstName, lastName, email);
%>

<html lang="en">
<head>
    <title>Teachers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 class="text-center">Teachers</h3>
    <br>
    <% if (teachers.isEmpty()) { %>
        <div class="alert alert-danger" role="alert">
            There is no teacher in system!
        </div>
    <% } else { %>
        <form action="">
            <div class="row">
                <div class="col">
                    <input type="text" class="form-control" id="firstName" name="firstName"
                           placeholder="First name" aria-label="First name" value="<%= firstName %>">
                </div>
                <div class="col">
                    <input type="text" class="form-control" id="lastName" name="lastName"
                           placeholder="Last name" aria-label="Last name" value="<%= lastName %>">
                </div>
                <div class="col">
                    <input type="email" class="form-control" id="email" name="email"
                           placeholder="Email" aria-label="Email" value="<%= email %>">
                </div>
                <div class="col">
                    <button type="submit" class="form-control btn btn-warning">Search</button>
                </div>
            </div>
        </form>

        <br>
        <table class="table table-bordered">
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Teacher teacher : teachers) {
        %>
        <tr>
            <td><%= teacher.getFirstName() %></td>
            <td><%= teacher.getLastName() %></td>
            <td><%= teacher.getEmail() %></td>
            <td>
                <a href="#" class="btn btn-outline-info">Details</a>
                <a href="#" class="btn btn-outline-success">Edit</a>
                <a href="views/teacher/remove-teacher.jsp?id=<%= teacher.getId() %>" class="btn btn-outline-danger">
                    Remove</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } %>
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
