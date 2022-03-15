<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Document</title>
    <link href = "/css/style.css" rel="stylesheet"/>
	<script type="text/javascript" src = "/js/main.js"></script>
</head>
<body>

    <!-- Instale un plugin de VSCode para JSP para ayudar a la sintaxis -->

    <h1>Hola Mundo JSP</h1>
    <% out.println("Hola Mundo!"); %>
    <% List.of("Hola","Chau"); %>
    <button type="button" onclick="demo()">Show Alert</button>
    <a href="welcome">link</a>
</body>
</html>