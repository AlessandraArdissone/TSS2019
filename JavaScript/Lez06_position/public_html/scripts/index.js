/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.querySelector("#sfondo #pOk").onclick = function () {
    document.querySelector("#sfondo").style.display = "none";
};

/* Programmo l'evento click di tutti gli oggetti di classe .pMsg: */
function mostraPopUp() {
    document.querySelector("#sfondo").style.display = "block";
}
/*
var mostraPopUp = function() {
    document.querySelector("#sfondo").style.display = "block";
};
*/
/*for (let i = 0; i < document.querySelectorAll(".pMsg").length; i++) {*/
document.querySelectorAll(".pMsg").forEach(
        function (elm, i) {
            elm.style.color = "green";
            elm.onclick = mostraPopUp;
            /*elm.onclick = function() {
                document.querySelector("#sfondo").style.display = "block";
            };*/
        },
);
/*}*/
