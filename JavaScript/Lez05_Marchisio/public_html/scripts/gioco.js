/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var coloriSfondo=["red","green","yellow","blue", "white"];
var indice=0;
var sx=Math.random()*1000;
document.getElementById("astronave").style.left=sx+"px";
var alto=Math.random()*100;
document.getElementById("astronave").style.top=alto+"px";

document.querySelector(".nord").onclick = function (){
    let y =parseFloat(document.getElementById("astronave").style.top);
    y-=5;
    document.getElementById("astronave").style.top=y+"px";
    console.log("nord",y);
};

document.querySelector(".sud").onclick = function (){
    let y =parseFloat(document.getElementById("astronave").style.top);
    y+=5;
    document.getElementById("astronave").style.top=y+"px";
    console.log("sud",y);
};

document.querySelector(".est").onclick = function (){
    let x =parseFloat(document.getElementById("astronave").style.left);
    x+=5;
    document.getElementById("astronave").style.left=x+"px";
    console.log("est",x);
};

document.querySelector(".ovest").onclick = function (){
    let x =parseFloat(document.getElementById("astronave").style.left);
    x-=5;
    document.getElementById("astronave").style.left=x+"px";
    console.log("est",x);
};

document.querySelector(".pOk").onclick = function (){
    indice++;
    if (indice>=coloriSfondo.length) {
        indice=0;
    }
    document.body.style.backgroundColor=coloriSfondo[indice];
    
//    Con la linea commentata seguente si fa quello scritto sopra con una riga sola
//    document.querySelector("body").style.bachgroundColor=coloriSfondo[indice++ % coloriSfondo.length];
    console.log(indice);
};



console.log("pagina gioco js caricata!");
console.log(sx,alto);