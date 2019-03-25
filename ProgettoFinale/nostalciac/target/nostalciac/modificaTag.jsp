<%-- 
    Document   : modificaTag
    Created on : 25-mar-2019, 11.56.18
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/nostalciac.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="">
        <script src="js/libreria.js" type="text/javascript"></script>
        <title>Modifica TAG</title>
    </head>
    <body>
        <h1>Modifica TAG</h1>
        <div id="risultato"></div>
        <form>
            <select id="sel_tags">
                <!--<option value="-1">Scegli il Tag</option>-->
            </select>
            <label for="tipo">Tipo: </label>
            <input type="text" id="tipo">
            <label for="tag">Tag: </label>
            <input type="text" id="tag">
            <input type="button" id="b_modTag" value="Conferma modifica">
        </form>
        <script src="js/modificaTag.js" type="text/javascript"></script>
    </body>
</html>