<%-- 
    Document   : form
    Created on : 1-apr-2019, 8.40.20
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/nostalciac.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="ico/ciac.ico">
        <script src="js/libreria.js" type="text/javascript"></script>
        <title>Account</title>
    </head>
    <body>
        <form>
            <div class="campo">
                <label for="nome">Nome: </label> <!-- for: ID dell'input! -->
                <input type="text" id="nome" name="nome" value="" placeholder="inserisci il nome..." title="numeri non ammessi!" />
            </div>
            <div class="campo">
                <label for="cognome">Cognome: </label> <!-- for: ID dell'input! -->
                <input type="text" id="cognome" name="cognome" value="" placeholder="inserisci il cognome..." title="numeri non ammessi!" />
            </div>
            <div class="campo">
                <label for="username">Username: </label> <!-- for: ID dell'input! -->
                <input type="text" id="username" name="username" value="" placeholder="scegli il tuo username..." />
            </div>
            <div class="campo">
                <label for="password">Password: </label> <!-- for: ID dell'input! -->
                <input type="password" id="password" name="password" value="" placeholder="scegli una password..." />
            </div>
            <div class="campo">
                <label for="password2">Ripeti PW: </label> <!-- for: ID dell'input! -->
                <input type="password" id="password2" name="password2" value="" placeholder="ridigita la password..." />
            </div>
            <div class="campo">
                <label for="email">E-mail: </label> <!-- for: ID dell'input! -->
                <input type="text" id="email" name="email" value="" placeholder="inserisci l'email..." />
            </div>
            <div class="campo">
                <label for="nascita">Nat<span id="natOA">o</span>: </label> <!-- for: ID dell'input! -->
                <input type="date" id="nascita" name="nascita" value="" placeholder="inserisci l'email..." />
            </div>
            <div class="campo">
                <label for="citta">Citt&agrave;: </label> <!-- for: ID dell'input! -->
                <input type="text" id="citta" name="citta" value="" placeholder="inserisci la citt&agrave;..." list="elencoCitta" />
            </div>
            <datalist id="elencoCitta">
                <option value="Torino" />
                <option value="Ivrea" />
                <option value="Milano" />
            </datalist>
            <div class="campo">
                <label for="privacy">Accetto la policy: </label> <!-- for: ID dell'input! -->
                <input type="checkbox" id="privacy" name="privacy" />
            </div>
            <div class="campo">
                <label>Sesso: </label>
                <label for="sesso_M">M</label> <!-- for: ID dell'input! -->
                <input type="radio" id="sesso_M" name="sesso" value="Maschio" />
                &nbsp;&nbsp;&nbsp;
                <label for="sesso_F">F</label> <!-- for: ID dell'input! -->
                <input type="radio" id="sesso_F" name="sesso" value="Femmina" />
            </div>
            <div class="campo">
                <label for="note">Note: </label> <!-- for: ID dell'input! -->
                <textarea id="note" name="note" placeholder="scrivi un commento..."></textarea>
            </div>
            <div class="campo">
                <label for="corsi">Corso: </label> <!-- for: ID dell'input! -->
                <!--<select id="corsi" name="corsi" multiple size="7">-->
                <select id="corsi" name="corsi">
                    <option value="" selected="selected">Scegli il corso</option>
                    <option value="c1">Corso di MSWord</option>
                    <option value="c2">Corso di MSExcel</option>
                    <option value="c3">Corso di MSAccess</option>
                    <option value="c4">Corso di MSPowerPoint</option>
                    <option value="c5">Corso di MSOneNote</option>
                </select>
            </div>
            <div class="campo">
                <label for="pReset"></label> <!-- for: ID dell'input! -->
                <input type="reset" value="Cancella i dati" id="pReset" />
            </div>
            <div class="campo">
                <label for="pSubmit"></label> <!-- for: ID dell'input! -->
                <input type="submit" value="Invia i dati" id="pSubmit" />
            </div>
            <div class="campo">
                <label for="pButton"></label> <!-- for: ID dell'input! -->
                <input type="button" value="Controlla i dati" id="pButton" />
            </div>
        </form>
        <script src="js/anagrafica.js" type="text/javascript"></script>
    </body>
</html>
