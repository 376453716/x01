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


    <div class="row">
        <div class="col-md-6">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>id</th>
                    <th>Username</th>
                    <th>birthday</th>
                    <th>operate</th>
                </tr>
                </thead>
                <tbody>
                <#if (userList)??>
                    <#list userList as user>
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.birthday?date}</td>
                        <td><a href="${request.getContextPath()}/authentic/detail?id=${user.id}">${user.id}</a></td>
                    </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
    </div>

    <form id="queryUserForm" action="${request.getContextPath()}/authentic/list" method="post">
        <input type="text" name="name" id="userName" class="form-control" required autofocus>
        <button type="button" class="btn btn-sm btn-default" onclick="query()">query</button>
        <button type="button" class="btn btn-sm btn-default" onclick="add()">add</button>
    </form>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${request.getContextPath()}/static/js/jquery-1.11.3.js"></script>
<script src="${request.getContextPath()}/static/bootstrap/js/bootstrap.min.js"></script>
<script>
    function query() {
        $("#queryUserForm").attr("action", "${request.getContextPath()}/authentic/list");
        $("#queryUserForm").submit();
    }
    function add() {
        $("#queryUserForm").attr("action", "${request.getContextPath()}/authentic/input");
        $("#queryUserForm").submit();
    }
</script>
</body>
</html>
