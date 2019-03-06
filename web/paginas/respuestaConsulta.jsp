<%-- 
    Document   : respuesta
    Created on : 4/02/2019, 07:33:56 PM
    Author     : sala8
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList lista =  (ArrayList) request.getAttribute("listaDatos");
        %>
        <h1>Vengo de la servlet.....<%=lista.get(0)%></h1>
        <a href="./index.html"> Volver</a>
    </body>
</html>
