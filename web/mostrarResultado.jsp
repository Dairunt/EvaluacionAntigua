<%-- 
    Document   : mostrar
    Created on : 27-05-2014, 05:17:00 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String mensaje = (String) request.getSession().getAttribute("mensaje");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado de la operación : <%= mensaje %></h1>
    </body>
</html>
