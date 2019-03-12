/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * costante: lista dei colori disponibili
 * @type String
 */
const listaColori = "red,aqua,pink,yellow,green,violet,magenta,orange";
const colori = listaColori.split(",");
/**
 * utilizzo una variabile globale per il colore desiderato
 * @type String
 */
var coloreSelezionato = "red";

document.querySelector("#pStart").onclick = function() {
    console.log("click sul pulsante pStart");
    creoAmbienteGioco();
};

function creoAmbienteGioco() {
    console.log("creo ambiente gioco");
    
    generaTabellaDisegno();
    prgClickTabellaDisegno();
    generaTavolozza();
    coloraTavolozza();
    prgClickTavolozza();
}

/**
 * crea una tabella 20x20 e la inserisce in contT1
 * la tabella si chiamerà tabellaT1
 */
function generaTabellaDisegno() {
    document.querySelector("#contT1").innerHTML = generaTabHtml(20, 20, "tabellaT1", "tab");
}

/**
 * programma il click di tutte le celle della tabella con id tabellaT1
 */
function prgClickTabellaDisegno() {
    document.querySelectorAll("#tabellaT1 tr td").forEach(function(elm, k) {
        elm.onclick = function() {
            console.log("ho cliccato sulla cella");
            this.style.backgroundColor = coloreSelezionato;
        };
    });
}

/**
 * crea una tabella 8x1 che rappresenta la tavolozza
 */
function generaTavolozza() {
    document.querySelector("#contT2").innerHTML = generaTabHtml(8, 1, "tavolozza", "tab");
}

function coloraTavolozza() {
    document.querySelectorAll("#tavolozza tr td").forEach(function(elm, k) {
        elm.style.backgroundColor = colori[k];
    });
}

function prgClickTavolozza() {
    document.querySelectorAll("#tavolozza tr td").forEach(function(elm, k) {
        elm.onclick = function() {
            console.log("ho cliccato sulla tavolozza");
            coloreSelezionato = elm.style.backgroundColor;
        };
    });
}
