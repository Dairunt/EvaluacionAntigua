<%-- 
    Document   : MostrarUsuarios
    Created on : 29-05-2014, 04:45:54 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelos.Usuario" %>
<%@page import="java.util.ArrayList" %>

<%
    ArrayList<Usuario> arrUsuarios= (ArrayList<Usuario>) request.getSession().getAttribute("arrUsuarios");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrando Usuarios</title>
    </head>
    <body>
        <form action="mostrarusuarios.do" method="post">
        <table border="1">
            <caption>Usuarios Registrados</caption>
    <%
        if (arrUsuarios == null)
            out.println("<h1>NO EXISTEN USUARIOS</h1>");
        else
        {    
            for (int i = 0; i < arrUsuarios.size();i++)
            {
                int rut = arrUsuarios.get(i).getRut();
                char dv = arrUsuarios.get(i).getDv();
                String nombres = arrUsuarios.get(i).getNombres();
                String apellidos = arrUsuarios.get(i).getApellidos();

                out.println("<tr>");
                out.println("<td>"+rut+"</td>"+
                            "<td>"+dv+"</td>"+
                            "<td>"+nombres+"</td>"+
                            "<td>"+apellidos+"</td>");
                out.println("</tr>");
            }
        }
    %>
    </table>
    </body>
</html>
