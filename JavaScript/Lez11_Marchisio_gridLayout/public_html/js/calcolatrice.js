/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var display = "";

scrivi("0");

document.querySelectorAll(".numero").forEach(function (elm, k) {
    elm.setAttribute("num", k);
    elm.innerHTML = k;
    elm.onclick = scriviNumero;
});

function scriviNumero() {
    scrivi(this.innerHTML);
}

function scrivi(digit) {
    if (display == "0") {
        switch (digit) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                display = digit;
                break;
        }
    } else {
        display += digit;
    }
    //document.querySelector("#schermo").innerHTML += display;
    document.querySelector("#schermo").innerHTML = display;
}

//document.querySelector(".virgola").onclick = function() {document.querySelector("#schermo").innerHTML += ",";};

document.querySelector(".virgola").onclick = function () {
    scrivi(",");
};

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
        case ",":
            scrivi(e.key);
            break;
        case ".":
            scrivi(",");
            break;
    }
    console.log(e);
};
