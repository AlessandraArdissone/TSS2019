/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//  CLASS DECLARATIONS:
function Bottle(brand, volume, content) {
//  PROPERTIES:
    this.brand = brand;
    this.volume = volume;
    this.content = content;
    this.color = "darkblue";
//  FUNCTIONS:
    this.state = function () {
        let res = "";

        res = "La mia bottiglia di acqua '" + this.brand + "' da " + this.volume
                + "cl contiene " + this.content + "cl.";

        return res;
    };
    this.pour = function (howMuch) {
        let res = 0;

        if (this.content - howMuch >= 0) {
            this.content -= howMuch;
            res = howMuch;
        } else {
            res = 0;
        }
        /*
         else {
         res = this.content;
         this.content = 0;
         }
         */
        return res;
    };
    this.fill = function (howMuch) {
        let res = 0;

        if (this.content + howMuch <= this.volume) {
            this.content += howMuch;
            res = howMuch;
        } else {
            res = this.volume - this.content;
            this.content = this.volume;
        }

        return res;
    };
}
//  GLOBAL VARIABLES:
var myBottle;
var divBottle;
var inBrand;
var inVolume;
var rnPour;
var rnFill;
var spPour;
var spFill;
var divGraphic;
//  FUNCTIONS:
function createBottle () {
    divBottle = document.getElementById("div_bottle");
    inBrand = document.getElementById("in_brand");
    inVolume = document.getElementById("in_volume");
    rnPour = document.getElementById("rn_pour");
    rnFill = document.getElementById("rn_fill");
    spPour = document.getElementById("sp_pour");
    spFill = document.getElementById("sp_fill");
    divBox = document.getElementById("div_box");
    divGraphic = document.getElementById("div_graphic");

    let myBrand = inBrand.value.trim();
    let myVolume = inVolume.value * 1;
    let res = "";

    if (myBrand !== "" && !isNaN(myVolume))
    {
        myBottle = new Bottle(myBrand, myVolume, myVolume);
        res = "Ho creato una bottiglia di marca '" + myBottle.brand + "' da " + myBottle.volume + "cl.<br/>";
        res += myBottle.state();
        drawBottle();
/*
        let node = document.createElement("div");
        node.style = "position:absolute;bottom:0px;height:100px;width:50px;background-color:" + myBottle.color;
        divGraphic.appendChild(node);
*/
    } else
        res = "Inserire marca e capacità della bottiglia che si desidera creare!";

    divBottle.innerHTML = res;
}

function setSpValue () {
    spPour.innerHTML = rnPour.value;
    spFill.innerHTML = rnFill.value;
}

function pourFromBottle () {
    divBottle.innerHTML += "<br/>Sono stati bevuti " + myBottle.pour(rnPour.value * 1) + "cl.<br/>";
    divBottle.innerHTML += myBottle.state();
    drawBottle();
}

function fillInBottle () {
    divBottle.innerHTML += "<br/>La bottiglia è stata riempita con " + myBottle.fill(rnFill.value * 1) + "cl.<br/>";
    divBottle.innerHTML += myBottle.state();
    drawBottle();
}

function drawBottle () {
    let cont = myBottle.content;
    let maxHeight = divBox.clientHeight ;
    let vol = myBottle.volume;
    let currentHeight = maxHeight*cont/vol;
    
    divGraphic.style.height = currentHeight + "px";
}