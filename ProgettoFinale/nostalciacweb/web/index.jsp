<%-- 
    Document   : index
    Created on : 25-mar-2019, 9.14.14
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes/headlinks.jsp" />
        <title>NOSTALCIAC</title>
    </head>
    <body>
        <jsp:include page="./includes/menu.jsp" />
        <main class="content">
            <article>
                <h1>NostalCIAC!</h1>
                <!--        
                        <input type="button" id="callDB" value="Tags" />
                        <input id="in_findID" type="text" placeholder="id del tag da cercare...">
                        <input type="button" id="findID" value="cerca ID">
                        <input type="button" id="b_post" value="inserisci TAG">
                        <hr>
                        <div id="risultato"></div>
                -->
            </article>
        </main>
        <jsp:include page="./includes/footer.jsp" />
    </body>
    <script src="js/nostalciac.js" type="text/javascript"></script>
</html>
