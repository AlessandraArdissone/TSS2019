/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var coloriSfondo = ["red", "green", "yellow", "blue", "brown", "magenta", "aqua", "black", "gray", "white"];
var indice = 0;

function cambiaColore() {
    document.querySelector("body").style.backgroundColor = coloriSfondo[indice % coloriSfondo.length];
    this.style.backgroundColor = coloriSfondo[indice % coloriSfondo.length];
    console.log("colore", indice, coloriSfondo[indice++ % coloriSfondo.length]);
}

document.querySelectorAll(".cambiaSfondo").forEach(
        function(elm, i) {
            elm.onclick = cambiaColore;
        },
);

