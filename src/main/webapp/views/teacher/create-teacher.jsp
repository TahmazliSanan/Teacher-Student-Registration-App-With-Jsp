<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
<head>
    <title>Create teacher</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 class="text-center">Create teacher</h3>
    <br>
    <br>
    <form action="../../index.jsp" method="post">
        <input type="hidden" id="actionType" name="actionType" value="create">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First name">
            <label for="firstName">First name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last name">
            <label for="lastName">Last name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
            <label for="email">Email</label>
        </div>
        <div class="form-floating mb-3">
            <button type="submit" class="btn btn-primary">Submit</button>
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
