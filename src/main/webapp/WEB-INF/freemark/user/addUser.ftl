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
    <p>
        <input type="text" name="user.name" id="userName" class="form-control" required autofocus>
        <button type="button" class="btn btn-sm btn-default">query</button>
        <button type="button" class="btn btn-sm btn-default">add</button>
        <button type="button" class="btn btn-sm btn-default">update</button>
    </p>

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
                    <td>
                        <input type="text" name="name" id="name" class="form-control" required autofocus>
                    </td>
                    <td>
                        <input type="text" name="name" id="name" class="form-control" required autofocus>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>


</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${request.getContextPath()}/static/js/jquery-1.11.3.js"></script>
<script src="${request.getContextPath()}/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
