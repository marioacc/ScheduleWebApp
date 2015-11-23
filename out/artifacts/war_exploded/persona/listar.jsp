<%-- 
    Document   : listar
    Created on : 28/09/2015, 05:17:28 PM
    Author     : Dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

    </head>
    <body>
    <div id="fecha"></div>
    <button onclick="actualizarFecha()">Actualizar</button>
    <table border="1">    
        <tr style="border: 1px solid black">
            <td>Id</dr><td>Nombre</td><td>Apellido Paterno</td><td>Apellido Materno</td><td>Alias</td><td></td> 
            <td><a href="/persona/crear">Agregar</td>
    </tr>
    
    <c:forEach var="persona" items="${list}">
     <tr style="border: 1px solid black">
         <td><a href="/persona/mostrar?personaId=${persona.id}">${persona.id}</dr>
        <td>${persona.nombre}</td>
        <td>${persona.apellido_paterno}</td>
        <td>${persona.apellido_materno}</td>
        <td>${persona.alias}</td>
        <td><a href="/persona/eliminar?personaId=${persona.id}">Eliminar</td>
        <td><a href="/persona/editar?personaId=${persona.id}">Editar</td>
</tr>
        </c:forEach>
    </table>
    <script>
        $(document).ready(function (){
            actualizarFecha();
        });
        function actualizarFecha(){
            $("#fecha").load("/fecha/actualizar");
        }
    </script>
    </body>
</html>
