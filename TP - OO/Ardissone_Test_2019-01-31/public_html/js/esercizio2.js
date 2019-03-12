/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const cuccarini = "lorella";
const hunziker = "michelle";
const leviMontalcini = "rita";
const majorana = "ettore";

const ar_monete = [0.01,0.02,0.05,0.1,0.2,0.5,1,2];

var portafoglio = 0;

function inviaTest() {
    punti = 0;

    let s_cuccarini = document.getElementById("in_cuccarini").value.trim().toLowerCase();
    let s_hunziker = document.getElementById("in_hunziker").value.trim().toLowerCase();
    let s_leviMontalcini = document.getElementById("in_leviMontalcini").value.trim().toLowerCase();
    let s_majorana = document.getElementById("in_majorana").value.trim().toLowerCase();

    let b_rosa = false;
    let b_azzurro = false;
    let n_rispcorrette = 0;

    if (s_cuccarini == cuccarini) {
        punti += 10;
        b_rosa = true;
        n_rispcorrette++;
    }

    if (s_hunziker == hunziker) {
        punti += 10;
        b_rosa = true;
        n_rispcorrette++;
    }

    if (s_leviMontalcini == leviMontalcini) {
        punti += 20;
        b_azzurro = true;
        n_rispcorrette++;
    }

    if (s_majorana == majorana) {
        punti += 30;
        b_azzurro = true;
        n_rispcorrette++;
    }

    let res = "";

    res += n_rispcorrette + " risposte corrette<br />" + punti + " punti => ";

    if (b_rosa && b_azzurro && punti >= 40)
        res += "PROMOSSO!";
    else
        res += "BOCCIATO!";

    document.getElementById("div_test").innerHTML = res;
}

function prendiMonete() {
    n_moneta = document.getElementById("in_moneta").value * 1;

    if (isMoneta(n_moneta))
    {
        if (portafoglio >= n_moneta)
            portafoglio -= n_moneta;
        else
            alert("Credito insufficiente!");
    } else
        alert("Moneta non valida!");

    vediPortafoglio();
    document.getElementById("in_moneta").focus();
}

function mettiMonete() {
    n_moneta = document.getElementById("in_moneta").value * 1;

    if (isMoneta(n_moneta))
        portafoglio += n_moneta;
    else
        alert("Moneta non valida!");

    vediPortafoglio();
    document.getElementById("in_moneta").focus();
}

function isMoneta(valore) {
    let b_moneta = false;

    if (!Number.isNaN(valore) && valore > 0) {
        for ( let i=0; i<ar_monete.length; i++ )
        {
            if ( valore == ar_monete[i] ) {
                b_moneta = true;
                break;
            }
        }
    }

    return b_moneta;
}

function vediPortafoglio() {
    // TODO: formatta numero #.##!!
    document.getElementById("div_portafoglio").innerHTML = "€ " + portafoglio.toFixed(2);
}