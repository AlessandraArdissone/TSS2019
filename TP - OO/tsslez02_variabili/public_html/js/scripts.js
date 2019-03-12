
var num1;
var num2;
var risultato;
var totale = 0;
var okDati;


function isVuota(testo) {
    if (testo.length == 0)
        return true;
    else
        return false;


}
function  checkDati() {
    // verifico num1 e num2
    // e ritorno true se presenti solo numeri oppure non compilato
    // altrimenti ritorno false
    if (isNaN(num1) || isNaN(num2) || isVuota(num1) || isVuota(num2)) {
        return false;
    } else {
        return true;
    }
}

function faseInput() {
    num1 = document.getElementById("in_num1").value;
    num2 = document.getElementById("in_num2").value;
    okDati = checkDati();
    // verifico ok dati e poi vedo se trsformare in numeri
    if (okDati == true) {
        num1 = parseFloat(num1);
        num2 = parseFloat(num2);
    } else
    {
        alert("attenzione dati non corretti");

    }
}

function faseOutput() {
    document.getElementById("div_ris").innerHTML = risultato;
    document.getElementById("totale").innerHTML = totale;
}

function somma() {
    faseInput();
    if (okDati) {
        //attenzione è ancora testo!!!!
        risultato = num1 + num2;
        totale = totale + risultato;
        //richiamo il metodo faseoutput
        faseOutput();
    }

}



function calcola(op) {
    faseInput();
    if (okDati) {
        //attenzione è ancora testo!!!!
        if (op == "+")
            risultato = num1 + num2;
        if (op == "-")
            risultato = num1 - num2;
        if (op == "*")
            risultato = num1 * num2;
        if (op == "/")
            risultato = num1 / num2;
        totale = totale + risultato;
        //richiamo il metodo faseoutput
        faseOutput();

    }
}


