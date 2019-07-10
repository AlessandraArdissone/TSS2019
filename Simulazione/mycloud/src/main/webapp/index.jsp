<%-- 
    Document   : index
    Created on : 15-jul-2019, 8.14.14
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes/headlinks.jsp" />
        <title>myCloud!</title>
    </head>
    <body>
        <jsp:include page="./includes/menu.jsp" />
        <main class="content">
            <article>
                <h1>myCloud!</h1>
                <img class="logo" src="img/mycloud.png" />
                    <div class="logreg">
                        <label for="pLogin">Sei già registrato?</label> <!-- for: ID dell'input! -->
                        <input type="button" value="Accedi" id="pLogin" />
                    </div>
                    <div class="logreg">
                        <label for="pButton">oppure</label> <!-- for: ID dell'input! -->
                        <input type="button" value="Registrati" id="pRegister" />
                    </div>
            </article>
        </main>
        <jsp:include page="./includes/footer.jsp" />
    </body>
    <script src="js/mycloud.js" type="text/javascript"></script>
</html>
