<%-- 
    Document   : MostrarProductosCat
    Created on : 17-06-2014, 04:19:02 PM
    Author     : USUARIO
--%>

<%@page import="Modelos.Producto"%>
<%@page import="Modelos.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%! ArrayList<Producto> arrProductos = new ArrayList<Producto>(); %>

<%
    ArrayList<Categoria> arrCategorias = (ArrayList<Categoria>) request.getSession().getAttribute("arrCategorias");
    ArrayList<Producto> arrProductos = (ArrayList<Producto>) request.getSession().getAttribute("arrProductos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos por Categoría</title>
    </head>
    <body>
        <form action="filtrarproductoscat.do" method="post">
            <select name="txtIdCategoria">
                <%
                     for (int i=0;i<arrCategorias.size();i++)
                     {
                         
                         out.println("<option value="+
                                 arrCategorias.get(i).getIdCategoria()+
                                 ">"+arrCategorias.get(i).getNombreCategoria()+
                                 "</option>");
                     }
                %>
            </select>
            <input type="submit" value="Filtrar Productos"><br>
        </form>
            <table border="1">
                <tr>
                    <td>Id Producto</td>
                    <td>Nombre Producto</td>
                </tr>
                <%
                     if (arrProductos != null)
                         for (int i = 0;i<arrProductos.size();i++)
                         {
                             out.println("<tr>");
                             out.println("<td>"+arrProductos.get(i).getIdProducto()+"</td>"+
                                         "<td>"+arrProductos.get(i).getNombreProducto()+"</td>");
                             out.println("</tr>");
                         }
                %>
                
            </table>
    </body>
</html>
