/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var colori = ["red", "deeppink", "green", "chartreuse", "yellow", "deepskyblue", "blue", "blueviolet", "brown", "darkorange", "darkgoldenrod", "magenta", "aqua", "aquamarine", "black", "gray", "white"];
var color = "";

function creaTabella(id, classe, nRows, nCols, contenitore) {
    let res = "";

    res += "<table id='" + id + "' class='" + classe + "'>";

    for (let i = 0; i < nRows; i++) {
        res += "<tr>";

        for (let j = 0; j < nCols; j++) {
            res += "<td></td>";
        }

        res += "</tr>";
    }

    res += "</table>";

    document.querySelector(contenitore).innerHTML = res;
}

function generaTabellaTab() {
    creaTabella("tab", "tabella", prompt("Numero righe:", "2"), prompt("Numero colonne:", "2"), "#contenitoreTab");
    document.querySelectorAll("table.tabella td").forEach(
            function (elm, k) {
                elm.onclick = coloraCella;
            },
            );
}

function coloraCella() {
    if (color == "")
        alert("Selezionare il colore!");
    else
        this.style.backgroundColor = color;
}

function assegnaColore() {
    document.querySelectorAll("table.tavolozza td").forEach(
            function (elm, k) {
                elm.style.outline = "";
            },
            );
    this.style.outline = "dashed 3px black";
    color = this.style.backgroundColor;
}

document.querySelector("#pTab").onclick = generaTabellaTab;

creaTabella("tav", "tavolozza", colori.length, 1, "#div_tavolozza");

colori.forEach(
        function (elm, k) {
            document.querySelector("#tav").childNodes[0].childNodes[k].childNodes[0].style.backgroundColor = elm;
        }
);

document.querySelectorAll("table.tavolozza td").forEach(
        function (elm, k) {
            elm.onclick = assegnaColore;
        },
        );
