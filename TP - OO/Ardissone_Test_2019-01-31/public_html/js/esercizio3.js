/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pav = null;
var prev = null;

function creaPavimento() {
    let n_largh = document.getElementById("in_larghezza").value * 1;
    let n_lungh = document.getElementById("in_lunghezza").value * 1;
    let n_costomq = document.getElementById("in_costomq").value * 1;
    let s_materiale = document.getElementById("in_materiale").value.trim().toUpperCase();

    let b_crea = true;

    if (isNaN(n_largh) || n_largh <= 0) {
        b_crea = false;
        alert("Inserire la larghezza del pavimento!");
    }

    if (isNaN(n_lungh) || n_lungh <= 0) {
        b_crea = false;
        alert("Inserire la lunghezza del pavimento!");
    }

    if (isNaN(n_costomq) || n_costomq <= 0) {
        b_crea = false;
        alert("Inserire il costo al metro quadro!");
    }

    if (s_materiale == "") {
        b_crea = false;
        alert("Inserire il materiale!");
    }

    if (b_crea) {
        pav = new Pavimento(n_largh, n_lungh, n_costomq, s_materiale);

        document.getElementById("div_pavimento").innerHTML = pav.prezzoFinale();
    }
}

function creaPreventivo() {
    let s_cliente = document.getElementById("in_cliente").value.trim().toUpperCase();

    let b_crea = true;

    if (s_cliente == "") {
        b_crea = false;
        alert("Inserire il nome del cliente!");
    }

    if (b_crea) {
        prev = new Preventivo(s_cliente);

        document.getElementById("div_preventivo").innerHTML = prev.vediPreventivo();
    }
}

function aggiungiPavimento() {
    let b_add = true;

    if (pav == null) {
        b_add = false;
        alert("Creare prima il pavimento!");
    }

    if (prev == null) {
        b_add = false;
        alert("Creare prima il preventivo!");
    }

    if (b_add) {
        prev.pavimenti.push(pav);

        document.getElementById("div_preventivo").innerHTML = prev.vediPreventivo();
    }
}

function visBtnElimina() {
    document.getElementById("btn_elPav").hidden = false;
}

function eliminaPavimento() {
    let pIndex = document.getElementById("sel_pav").value;
    if (pIndex != "") {
        prev.eliminaPavimento(pIndex);
        document.getElementById("div_preventivo").innerHTML = prev.vediPreventivo();
    }
    else
        alert("Selezionare preventivo pavimento da eliminare!");
}

function init() {
    document.getElementById("btn_elPav").hidden = true;
}