<%-- 
    Document   : IngresarProductos
    Created on : 03-06-2014, 05:25:02 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelos.Categoria" %>
<%@page import="java.util.ArrayList" %>

<%
    ArrayList<Categoria> arrCategorias = (ArrayList<Categoria>) request.getSession().getAttribute("arrCategorias");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso de Productos</title>
    </head>
    <body>
        <h1>Ingrese Datos del Producto</h1>
        <form action="grabaralumno.do" method ="post">
            <input type="text" name="txtRut"> <input type="text" name="txtDv" size="1"><br>
            <input type="text" name="txtNombres" placeholder="Nombres"><br>
            <input type="text" name="txtApellidos" placeholder="Apellidos"><br>
            Carrera <select name="txtCarrera"> 
                <%
                    for (int i=0;i<arrCategorias.size();i++)
                    {
                        out.println("<option value='"+arrCategorias.get(i).getIdCategoria()+"'>"+
                                                      arrCategorias.get(i).getNombreCategoria()+
                                                      "</option>");
                    }
                        
                %>
            </select><br>
            <input type="submit" value="Grabar carrera">
            
        </form>
    </body>
</html>
