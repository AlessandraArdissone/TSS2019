<%-- 
    Document   : modificaTag
    Created on : 25-mar-2019, 11.11.31
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="./includes/imports.jsp"/>
        <title>modifica TAG</title>
    </head>
    <body>
        <main>
            <header>
                <nav>
                    <c:import url="./includes/menu.jsp"/>
                </nav>
            </header>
            <article>
                <div id="contenitore"></div>
                <br><br>
                <form class="pure-form">
                    <fieldset>
                        <legend>Inserisci/Modifica TAGS</legend>
                        <label for="tipo">Tipo: </label>
                        <input type="text" id="tipo">
                        <label for="tag">Tag: </label>
                        <input type="text" id="tag">
                        <input type="button" class="pure-button pure-button-primary" id="b_modTag" value="Conferma modifica">
                        <br>
                    </fieldset>
                </form>
            </article>
            <footer>
                <c:import url="./includes/footer.jsp"/>
            </footer>
        </main>

        <script src="./indexTag.js" type="module"></script>
    </body>
</html>