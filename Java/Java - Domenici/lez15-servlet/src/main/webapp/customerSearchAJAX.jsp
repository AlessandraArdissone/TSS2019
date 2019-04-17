<%-- 
    Document   : customerSearchAJAX
    Created on : 20-mar-2019, 14.30.48
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Customers</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="./includes/head-imports.jsp"/>
    </head>
    <body>
        <main>
            <header>
                <nav>
                    <c:import url="./includes/menu.jsp"/>
                </nav>
            </header>
            <article>
                <form class="pure-form">
                    <fieldset>
                        <legend>Ricerca AJAX (Javascript e REST service)</legend>
                        <label for="search">Cerca</label>
                        <input id="search" type="text" name="search" placeholder="inserisci iniziali"  />
                        <input id ="invia" type="submit" name="invia" value="Invia"
                               class="pure-button pure-button-primary"/>
                    </fieldset>
                </form>

                <br/><hr/>

                <table id="result" class="pure-table pure-table-bordered"
                       style="margin: 0 auto;" >
                    <thead>
                        <tr><th>ID</th><th>Name</th></tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </article>
            <footer>
                <c:import url="./includes/footer.jsp"/>
            </footer>
        </main>
        <script src="./js/customers.js" type="text/javascript"></script>
    </body>
</html>

