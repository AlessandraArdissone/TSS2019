/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//  VARIABILI GLOBALI
var ar_voti = []; // array per immagazzinare i voti

function addVota() {
    // carico array
    ar_voti.push(document.getElementById("in_voto").value);

    print_don();
}

// funzione per stampare i voti
function print_don() {
    // quando il metodo mi deve ritornare qualcosa per prima cosa inizializzo la variabile e in fondo
    // metto il "return nomevariabile;"
    let text = "";

    document.getElementById("div_voti").innerHTML = "";
    
    for (i = 0; i < ar_voti.length; i++) {
        // In questo modo tutte le linee vengono generate con uno span con un id univoco, quindi possono essere gestiti anche singolarmenti
        document.getElementById("div_voti").innerHTML += "<span id='voto" + i + "'><b>#" + (i + 1) + "</b> --> " + ar_voti[i] + "<br/></span>";
    }
}

//  funzione per mostrare la media
function showAverage() {
    let total=0;
    let average=0;
    
    for (let i= 0;i<ar_voti.length; i++) {
        total += ar_voti[i]*1;
    }
    
    average = total/ar_voti.length;
    
    document.getElementById("average").innerHTML = average;
}