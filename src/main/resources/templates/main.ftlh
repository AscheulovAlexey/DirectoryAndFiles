<!DOCTYPE HTML>
<html>
<head>
    <title>Директория и файлы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div><h1>Директория и файлы</h1></div>

<div>
    <form method="post">
        Новая директория
        <input type="text" name="path" placeholder="Введите путь: "/>
        <button type="submit">Добавить в список</button>
    </form>
</div>
<#if errorMessage??>
    <div style="color:red;font-style:italic;">
        ${errorMessage}
    </div>
</#if>
<#if directories??>
    <div><h3>Список всех директорий</h3></div>
    <table border="1">
        <thead>
        <tr>
            <th>Дата добавления</th>
            <th>Директория</th>
            <th>Общее количество файлов</th>
            <th>Общий размер файлов</th>
            <th>Посмотреть файлы в директории</th>
            <th>Удалить директорию</th>
        </tr>
        </thead>


        <#list directories as directory>

            <tr>
                <td>${directory.date}</td>
                <td>${directory.path}</td>
                <td>${directory.amount}</td>
                <td>${directory.size} Кб</td>
                <td>
                    <button onclick="location.href='/${directory.id}/files'" type="button">Файлы</button>
                </td>
                <td>
                    <button onclick="location.href='/${directory.id}'" type="button" formmethod="post">Удалить</button>
                </td>
            </tr>
        <#else>
            No message
        </#list>
    </table>
</#if>

</body>
</html>