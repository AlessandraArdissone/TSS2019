<%-- 
    Document   : sedi
    Created on : 8-apr-2019, 8.52.59
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes/headlinks.jsp" />
        <title>SEDI</title>
    </head>
    <body>
        <jsp:include page="includes/menu.jsp" />
        <main class="content">
            <article>
                <div id="div_sedi" name="div_sedi"></div>
                <div id="div_modifica" name="div_modifica">
                    <br />
                    <hr />
                    <br />
                    <form>
                        <div class="campo">
                            <label for="nome">Nome sede: </label>
                            <input type="text" id="nome" class="pure-input-1"><br/>
                        </div>
                        <div class="campo">
                            <label for="indirizzo">Indirizzo: </label>
                            <input type="text" id="indirizzo" class="pure-input-1"><br/>
                        </div>
                        <div class="campo">
                            <label for="tel">Tel: </label>
                            <input type="text" id="tel" class="pure-input-1" ><br/>
                        </div>
                        <div class="campo">
                            <label for="citta">Città: </label>
                            <input type="text" id="citta" size="100"><br/>
                        </div>
                        <div class="campo">
                            <label for="mail">Mail: </label>
                            <input type="text" id="mail" size="100"><br/>
                        </div>
                        <div class="campo">
                            <label for="note">Note: </label>
                            <textarea id="note" name="note" placeholder="scrivi un commento..." maxlength="2000"></textarea>
                        </div>
                        <div class="campo">
                            <label for="b_annulla">&nbsp;</label> <!-- for: ID dell'input! -->
                            <input type="button" id="b_annulla" value="Annulla modifica">
                            <input type="button" id="b_modSede" value="Conferma modifica">
                        </div>
                        <input type="hidden" id="idSede" name="idSede" />
                    </form>
                    <div id="div_cont_nav" name="div_cont_nav" class="campo">
                        <label for='div_nav'>&nbsp;</label>
                        <div id="div_nav" name="div_nav"></div>
                    </div>
                </div>
            </article>
        </main>
        <jsp:include page="./includes/footer.jsp" />
        <script src="js/sedi.js" type="text/javascript"></script>
    </body>
</html>
