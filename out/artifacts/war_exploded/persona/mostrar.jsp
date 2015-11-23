    <%--
    Document   : listar
    Created on : 28/09/2015, 05:17:28 PM
    Author     : Dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Personas</title>
    </head>
    <body>
        <table border="1">
            <tr>    <td><b>Id: </b></td><td>${persona.id}</td> </tr>
            <tr>    <td><b>Nombre: </b></td><td>${persona.nombre}</td> </tr>
            <tr>    <td><b>Apellido Paterno: </b></td><td>${persona.apellido_paterno}</td> </tr>
            <tr>    <td><b>Apellido Materno: </b></td><td>${persona.apellido_materno}</td> </tr>
            <tr>    <td><b>Alias: </b></td><td>${persona.alias}</td> </tr>
        </table>
        
    </body>
</html>
