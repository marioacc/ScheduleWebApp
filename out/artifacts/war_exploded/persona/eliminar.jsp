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
        <title>Crear</title>
    </head>
    <body>
        <h1>Crear: ${persona}</h1>
        <form action="/persona/actualizar" method="POST">
        <table border="1">
            <tr>    <td><b>Id: </b></td><td>${persona.id} <input type="hidden" name="id" value="${persona.id}"/></td> </tr>
            <tr>    <td><b>Nombre: </b></td><td> <input type="text" name="nombre" value="${persona.nombre}"/> </td> </tr>
            <tr>    <td><b>Apellido Paterno: </b></td><td> <input type="text" name="apellido_paterno" value="${persona.apellido_paterno}"/></td> </tr>
            <tr>    <td><b>Apellido Materno: </b></td><td> <input type="text" name="apellido_materno" value="${persona.apellido_materno}"/></td> </tr>
            <tr>    <td><b>Alias: </b></td><td> <input type="text" name="alias" value="${persona.alias}"/></td> </tr>
            <tr>    <td colspan="2"> <input type="submit" value="Guardar"/></td></tr>
        </table>
        </form>
        
    </body>
</html>
