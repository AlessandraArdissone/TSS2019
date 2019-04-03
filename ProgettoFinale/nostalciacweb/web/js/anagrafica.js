/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelector("#pButton").onclick = controllaDati;
/*
 document.querySelector("#pSubmit").onclick = function () {
 return controllaDati();
 };
 */
document.querySelector("#pSubmit").onclick = controllaDati;

function controllaDati() {
    let nome = document.querySelector("#nome").value.trim();
    if (nome.length < 2) {
        alert("ATTENZIONE: nome troppo corto!");
        document.querySelector("#nome").focus();
        return false;
    }

    let cognome = document.querySelector("#cognome").value.trim();
    if (cognome.length < 2) {
        alert("ATTENZIONE: cognome troppo corto!");
        document.querySelector("#cognome").focus();
        return false;
    }

    let pw = document.querySelector("#password").value;
    let pw2 = document.querySelector("#password2").value;

    if (CheckPassword(pw)) {
        if (pw != pw2) {
            alert("ATTENZIONE: le password non coincidono");
            document.querySelector("#password2").focus();
            return false;
        }
    } else {
        document.querySelector("#password").focus();
        return false;
    }

    let privacy = document.querySelector("#privacy").checked;
    if (!privacy) {
        alert("ATTENZIONE: non hai accettato la Privacy Policy!");
        document.querySelector("#privacy").focus();
        return false;
    }

    //if (!document.querySelector("#sesso_M").checked && !document.querySelector("#sesso_F").checked) {
    if (getValueRadioButton("#sesso") == "") {
        alert("ATTENZIONE: selezionare il sesso!");
        document.querySelector("#sesso_M").focus();
        return false;
    }

    if (document.querySelector("#corsi").value == "") {
        alert("ATTENZIONE: selezionare il corso frequentato");
        document.querySelector("#corsi").focus();
        return false;
    }

    return true;
}
/*
 * Check a password between 8 to 15 characters which contains at least:
 *one lowercase letter, one uppercase letter, one numeric digit, and one special character
 *
 /^
 (?=.*\d)          // should contain at least one digit
 (?=.*[a-z])       // should contain at least one lower case
 (?=.*[A-Z])       // should contain at least one upper case
 (?=.*[!@#$%^&])   // should contain at least special character among !@#$%^&
 (?=.*[a-zA-Z0-9!@#$%^&]).{8,15} // should contain 8 to 15from the mentioned characters
 $/
 */
function CheckPassword(pw)
{
    let pwRegExp = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&])(?=.*[a-zA-Z0-9!@#$%^&]).{8,15}$/;
    if (pw.match(pwRegExp))
    {
        return true;
    } else {
        alert('La password inserita non corrisponde ai criteri richiesti!');
        return false;
    }
}

document.querySelector("#nome").onkeypress = nienteNumeriSulKeypress;
document.querySelector("#cognome").onkeypress = nienteNumeriSulKeypress;

function nienteNumeriSulKeypress(e) {
    let tasto = e.keyCode;

    if (tasto < 58 && tasto > 47)
        return false;
}

document.querySelectorAll("[name=sesso]").forEach(function (radio, k) {
    radio.onclick = function () {
        let val = this.value;
        let daScrivere = (val[0].toUpperCase() == "M") ? "o" : "a";
        document.querySelector("#natOA").innerHTML = daScrivere;
    };
});

function creaOggettoValori() {
    let o = {};

    o.nome = document.querySelector("#nome").value;
    o.cognome = document.querySelector("#cognome").value;
    o.email = document.querySelector("#email").value;
    o.nascita = document.querySelector("#nascita").value;
    o.citta = document.querySelector("#citta").value;
    o.sesso = getValueRadioButton("sesso");
    o.username = document.querySelector("#username").value;
    o.password = document.querySelector("#password").value;

    return o;
}

document.querySelector("#username").onchange = function (e) {
    let obj = creaOggettoValori();
    alert(JSON.stringify(obj));
/*    
    fetch('http://localhost:8080/nostalciac/resources/checkUsername', {
        method: 'post',
        
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        
        body: JSON.stringify(obj)
    }).then(function(response) {
        console.log("response:", response);
        console.log("response.text():", response.text());

        return ;
    }).catch(res => console.error("ERRORE:", res));
*/
};