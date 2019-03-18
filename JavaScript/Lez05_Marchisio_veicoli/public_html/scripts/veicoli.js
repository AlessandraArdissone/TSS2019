var coloriSfondo = ["red", "green", "yellow", "blue", "white"];
var indice = 0;
var veicolo="#astronave";
document.getElementById("astronave").style.left = "0px";
document.getElementById("astronave").style.top = "50px";
document.getElementById("aereo").style.left = "0px";
document.getElementById("aereo").style.top = "100px";
document.getElementById("automobile").style.left = "0px";
document.getElementById("automobile").style.top = "150px";
document.getElementById("bicicletta").style.left = "0px";
document.getElementById("bicicletta").style.top = "200px";



document.querySelector("#astronave").onclick= function() {
    veicolo=this.id;
    document.getElementById('schermo').innerHTML="Astronave";
    console.log(veicolo);
};

document.querySelector("#aereo").onclick= function() {
    veicolo="#aereo";
    document.getElementById('schermo').innerHTML="Aereo";
};

document.querySelector("#automobile").onclick= function() {
    veicolo="#automobile";
    document.getElementById('schermo').innerHTML="Automobile";
};

document.querySelector("#bicicletta").onclick= function() {
    veicolo="#bicicletta";
    document.getElementById('schermo').innerHTML="Bicicletta";
};


document.querySelector(".nord").onclick = function () {
    muovi(veicolo,0,-5);
};

document.querySelector(".sud").onclick = function () {
    muovi(veicolo,0,5);
};

document.querySelector(".est").onclick = function () {
    muovi(veicolo, 5, 0);
};

document.querySelector(".ovest").onclick = function () {
//    let x =parseFloat(document.getElementById("astronave").style.left);
//    x-=5;
//    document.getElementById("astronave").style.left=x+"px";
    muovi(veicolo, -5, 0);
    // console.log("est",x);
};

document.querySelector(".pOk").onclick = function () {
    indice++;
    if (indice >= coloriSfondo.length) {
        indice = 0;
    }
    document.body.style.backgroundColor = coloriSfondo[indice];

//    Con la linea commentata seguente si fa quello scritto sopra con una riga sola
//    document.querySelector("body").style.bachgroundColor=coloriSfondo[indice++ % coloriSfondo.length];
    console.log(indice);
};


function muovi(str, x, y) {

    let posX = parseFloat(document.querySelector(str).style.left);
    let posY = parseFloat(document.querySelector(str).style.top);
    posX += x;
    posY += y;
    document.querySelector(str).style.left = posX + "px";
    document.querySelector(str).style.top = posY + "px";

    console.log(str, posX, posY);
}

console.log("pagina gioco js caricata!");
//console.log(sx, alto);
