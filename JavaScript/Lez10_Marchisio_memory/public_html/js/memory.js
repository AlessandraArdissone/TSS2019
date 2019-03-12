/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var images = ["arethaFranklin", "bobDylan", "bobMarley", "bruceSpringsteen", "chuckBerry",
    "janisJoplin", "jimMorrison", "jimiHendrix", "joanJett", "neilYoung"];

var indexes = [];
var contaClick = 0;
var immagineSel = "";

function creaTabella(id, classe, nRows, nCols) {
    let res = "";

    res += "<table id='" + id + "' class='" + classe + "'>";

    for (let i = 0; i < nRows; i++) {
        res += "<tr>";

        for (let j = 0; j < nCols; j++) {
            res += "<td></td>";
        }

        res += "</tr>";
    }

    res += "</table>";

    return res;
}

function cercaIdx(idx) {
    let numIdx = 0;

    for (let i = 0; i < indexes.length; i++) {
        if (indexes[i] == idx) {
            numIdx++;
        }
    }

    return numIdx;
}

function deselectAll() {
    document.querySelectorAll("table.campoGioco td").forEach(function (elm, k) {
        elm.selected = false;
    });
}

function resetTurn() {
    immagineSel = "";
    contaClick = 0;
    deselectAll();
}

function recoverCards() {
    /*console.log("ricopri carte");*/
    document.querySelectorAll("table.campoGioco td").forEach(function (elm, k) {
        if (elm.selected == true)
            elm.querySelector(".dorsoCarta").style.transform = "rotateX(0deg)";
    });
/*    immagineSel = "";
    contaClick = 0;
    deselectAll();*/
    resetTurn();
    /*console.log("sblocca schermo");*/
    document.querySelector("#lockScreen").style.display = "none";
}

function giraCarta() {
    if (!this.selected) {
        this.querySelector(".dorsoCarta").style.transform = "rotateX(90deg)";
        this.selected = true;
        contaClick++;
        if (contaClick == 2) {
            if (this.image == immagineSel) {
/*                immagineSel = "";
                contaClick = 0;
                deselectAll();*/
                resetTurn();
            } else {
                /*console.log("blocca schermo");*/
                document.querySelector("#lockScreen").style.display = "flex";
                setTimeout(recoverCards, 3000);
            }
        } else
            immagineSel = this.image;
    }
}

// FLUSSO CODICE:
for (let i = 0; i < 20; i++) {
    let idx = Math.floor(Math.random() * 10);
    if (cercaIdx(idx) < 2)
        indexes[i] = idx;
    else
        i--;
}

document.getElementById("contenitore").innerHTML = creaTabella("gameField", "campoGioco", 4, 5);

document.querySelectorAll("table.campoGioco td").forEach(function (elm, k) {
    elm.image = images[indexes[k]];
    elm.style.backgroundImage = "url('./img/" + images[indexes[k]] + ".jpg')";
    elm.innerHTML = "<div class='dorsoCarta' />";
    elm.selected = false;
    elm.onclick = giraCarta;
});
