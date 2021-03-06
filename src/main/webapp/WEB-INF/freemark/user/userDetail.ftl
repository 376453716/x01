<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <title>Theme Template for Bootstrap</title>
    <link href="${request.getContextPath()}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${request.getContextPath()}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${request.getContextPath()}/static/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body role="document">
<!-- Fixed navbar -->
<#include "../head.ftl" parse=true>
<div class="container theme-showcase" role="main">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <h1>Theme example</h1>
        <p>This is a template showcasing the user list.</p>
    </div>

    <div class="page-header">
        <h1>Tables</h1>
    </div>
    <form id="updateUserForm" action="${request.getContextPath()}/authentic/update" method="post">
        <div class="row">
            <div class="col-md-6">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Username</th>
                        <th>birthday</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${user.id}</td>
                        <input type="hidden" name="id" value="${user.id}"/>
                        <td><input type="text" name="name" value="${user.name}"/></td>
                        <td><input type="text" name="birthday" value="${user.birthday?date}"/></td>
                    </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-sm btn-default" onclick="update()">update</button>
            </div>
        </div>
    </form>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${request.getContextPath()}/static/js/jquery-1.11.3.js"></script>
<script src="${request.getContextPath()}/static/bootstrap/js/bootstrap.min.js"></script>
<script>
    function update() {
        $("#updateUserForm").submit();
    }
</script>
</body>
</html>
