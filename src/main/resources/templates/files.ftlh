<!DOCTYPE HTML>
<html>
<head>
    <title>Файлы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div><h1>Список всех файлов</h1></div>
<div><h3>${directory.path}</h3></div>
git
<table border="1">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Размер</th>
    </tr>
    </thead>

    <#if allFiles??>
    <#list allFiles as file>
        <tr>
            <td>${file.name}</td>
            <td>${file.size!}</td>
        </tr>
    <#else>
        No message
    </#list>
</table>
</#if>
<a href="/">Назад</a>
</body>
</html>