<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome John Doe!</h1>


<div>get data:${data}</div>

<P>
<#if price == 0>
    price == 0
<#else >
    price != 0
</#if>
</P>
<#if (users)??>
    <#list users as user>
    ${user}<br>
    <#else>
    No record.
    </#list>
<#else>
No record.
</#if>

</body>
</html>