<%-- 
    Document   : test
    Created on : 15-mar-2019, 14.21.39
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!-- DIRETTIVA page -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            for (int i = 0; i < 10; i++) {
                out.println("<p>parola " + i + "</p>");
            }
        %>

        <hr>

        <%
            for (int i = 0; i < 10; i++) {
        %>
        <p>parola <%=i%></p>
        <%
        }
        %>
        
        <hr>
        
        <c:forEach begin="0" end="9" var="i" step="1">
            <p>parola <c:out value="${i}" /></p>
        </c:forEach>
    </body>
</html>
