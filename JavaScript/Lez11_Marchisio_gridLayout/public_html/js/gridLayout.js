/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelectorAll(".numero").forEach(function (elm, k) {
        elm.setAttribute("num", k);
        elm.innerHTML = k;
        elm.onclick = scriviNumero;
    });

function scriviNumero() {
    scrivi(this.innerHTML);
}

function scrivi(str) {
    document.querySelector("#schermo").innerHTML += str;
}

document.querySelector(".virgola").onclick = function() {document.querySelector("#schermo").innerHTML += ",";};

document.querySelector("body").onkeydown = function (e) {
    console.log("-------------------");
    console.log(e.which);
    console.log(e.key);
//  controllaAereo(e.which, e.shiftKey, e.ctrlKey);
    switch (e.key) {
        case "0":
        case "1":
        case "2":
        case "3":
        case "4":
        case "5":
        case "6":
        case "7":
        case "8":
        case "9":
            scrivi(e.key);
            break;
    }
    console.log(e);
};
