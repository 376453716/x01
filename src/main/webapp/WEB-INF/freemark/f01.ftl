<html>
<body>
<h1>Index</h1>

<div>get sysdate:${sysdate?datetime}</div>
<input type="text" name="userId"/>
<button id="queryBtn">query</button>

<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>birthday</td>
    </tr>
    <#if (userLst)??>
        <#list userLst as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.birthday?date}</td>
            </tr>
        </#list>
    </#if>
</table>

${a <#-- common -->}<br>
${b}<br>
${c}<br>
${flg?string('yes','no')}<br>

</body>
<head>
    <script type="javascript" src="/static/js/jquery-1.11.3.js"/>
    <title>Index</title>
    <script type="javascript">
        $(function () {
            $("#queryBtn").click()
            {

            }
        });
    </script>
</head>
</html>