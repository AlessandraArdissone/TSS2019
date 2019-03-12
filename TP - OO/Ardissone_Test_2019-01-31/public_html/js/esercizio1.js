/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var ar_articoli = [];

function saluta() {
    let res = "";
    let s_nome = formattaNome(document.getElementById("in_nome").value);
    
    if (s_nome == "")
        alert("Inserire il nome!");
    else {

        let d_oggi = new Date();

        // Oggi è il 31/01/2019. Ciao s_nome, buona giornata!
        res = "Oggi è il " + d_oggi.toLocaleDateString() + ". Ciao " + s_nome + ", buona giornata!";
        document.getElementById("div_saluto").innerHTML = res;
    }
    document.getElementById("in_nome").focus();
}

function formattaNome(parola) {
    parola = parola.trim().toLowerCase();
    let res = "";
    let iniz = parola.substr(0, 1).toUpperCase();
    parola = parola.substr(1, parola.length-1);
    res = iniz.concat(parola);
    
    return res;
}

function spostaNomi() {
    let s_nome1 = document.getElementById("in_nome1").value.trim();
    let s_nome2 = document.getElementById("in_nome2").value.trim();
    let s_nome3 = document.getElementById("in_nome3").value.trim();

    document.getElementById("in_nome1").value = s_nome3;
    document.getElementById("in_nome2").value = s_nome1;
    document.getElementById("in_nome3").value = s_nome2;
}

function Articolo(nomeArticolo, costo) {
    this.nomeArticolo = nomeArticolo;
    this.costo = costo;
    this.stampaArticolo = function () {
        return this.nomeArticolo + " - € " + this.costo;
    };
}

function aggiungiArticolo() {
    let s_nomeArticolo = document.getElementById("in_articolo").value.trim();
    let n_costo = document.getElementById("in_costo").value * 1;

    let o_Articolo = new Articolo(s_nomeArticolo, n_costo);
    let b_add = true;

    if (s_nomeArticolo == "") {
        b_add = false;
        alert("Inserire il nome dell'articolo!");
    }

    if (Number.isNaN(n_costo) || n_costo <= 0) {
        b_add = false;
        alert("Inserire il costo dell'articolo!");
    }

    if (b_add) {
        ar_articoli.push(o_Articolo);
        // STAMPA OUTPUT!
        stampaArticoli();

        document.getElementById("in_articolo").value = "";
        document.getElementById("in_costo").value = "";

        document.getElementById("in_articolo").focus();
    }
}

function stampaArticoli() {
    let res = "";
    let totale = 0;
    let media = 0;
    let min = 0;
    let max = 0;

    for (let i = 0; i < ar_articoli.length; i++) {
        res += ar_articoli[i].stampaArticolo() + "<br />";
        totale += ar_articoli[i].costo;

        if (i == 0 || ar_articoli[i].costo < min)
            min = ar_articoli[i].costo;

        if (i == 0 || ar_articoli[i].costo > max)
            max = ar_articoli[i].costo;

    }

    media = totale / ar_articoli.length;

    res += "-----------------------------------<br />";
    res += "Totale - € " + totale + "<br />";
    res += "Media - € " + media + "<br />";
    res += "Min - € " + min + "<br />";
    res += "Max - € " + max;

    document.getElementById("div_articoli").innerHTML = res;
}