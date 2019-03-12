/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var ogg = document.querySelector(".aereo");
ogg.classList.add("selezionato");
var nAerei = document.querySelectorAll("div.aereo").length;

document.querySelectorAll("div.aereo").forEach(
        function (elm, k) {
            posizionaAereo(elm, k);
        },
        );

function posizionaAereo(aereo, n) {
    var sx = Math.random() * 1000;
    var alto = Math.random() * 1000;
    var h = Math.random() * 100;
    var w = h;

    aereo.style.left = sx + "px";
    aereo.style.top = alto + "px";
    aereo.style.height = h + "px";
    aereo.style.width = w + "px";
    aereo.rotazione = 0;
    aereo.num = n;
    console.log("aereo" + n, sx, alto, h, w, 0);
}

function assegnaAereo() {
    ogg = this;

    document.querySelectorAll("div.aereo").forEach(
            function (elm, k) {
                if (elm == ogg)
                    elm.classList.add("selezionato");
                /*elm.className += " selezionato";*/
                else
                    elm.classList.remove("selezionato");
                /*elm.className = "aereo";*/
            },
            );
}

document.querySelectorAll("div.aereo").forEach(
        function (elm, k) {
            elm.onclick = assegnaAereo;
        },
        );

document.querySelector("body").onkeydown = function (e) {
    console.log(e.which);
    controllaAereo(e.which, e.shiftKey, e.ctrlKey);
    console.log(e);
};

function selezionaProxAereo() {
    ogg.classList.remove("selezionato");
    let n = ogg.num;

    document.querySelectorAll("div.aereo").forEach(
            function (elm, k) {
                if (k == (n+1)%nAerei) {
                    ogg = elm;
                    ogg.classList.add("selezionato");
                }
            },
            );
}

function controllaAereo(dir, shift, control) {
    switch (dir) {
        case 32: /* spazio */
            selezionaProxAereo();
            break;

        case 38: /* freccia SU */
            if (shift)
                ridimensiona("aereo", 0, -5);

            if (control)
                ruota("aereo", -5);

            if (!shift && !control)
                muovi("aereo", 0, -5);
            break;

        case 40: /* freccia GIU */
            if (shift)
                ridimensiona("aereo", 0, 5);

            if (control)
                ruota("aereo", 5);

            if (!shift && !control)
                muovi("aereo", 0, 5);
            break;

        case 39: /* freccia DX */
            if (shift)
                ridimensiona("aereo", 5, 0);
            else
                muovi("aereo", 5, 0);
            break;

        case 37: /* freccia SX */
            if (shift)
                ridimensiona("aereo", -5, 0);
            else
                muovi("aereo", -5, 0);
            break;
    }
}

function ruota(str, r) {
    let rot = parseFloat(ogg.rotazione);
    rot += r;
    ogg.rotazione = rot;
    ogg.style.transform = "rotate(" + rot + "deg)";
}

function ridimensiona(str, w, h) {
    let width = parseFloat(ogg.style.width);
    let height = parseFloat(ogg.style.height);
    width += w;
    height += h;
    ogg.style.width = width + "px";
    ogg.style.height = height + "px";

    console.log("ridimensiona " + str + ogg.num, width, height);
}

function muovi(str, x, y) {
    let posX = parseFloat(ogg.style.left);
    let posY = parseFloat(ogg.style.top);
    posX += x;
    posY += y;
    ogg.style.left = posX + "px";
    ogg.style.top = posY + "px";

    console.log("muovi " + str + ogg.num, posX, posY);
}
