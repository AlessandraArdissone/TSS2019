/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function creaTabellaDaJson(oggJson, listaCampi, idTabella, classeTabella, contenitore = "body") {
    document.querySelector(contenitore).innerHTML = "";

    let tabella = document.createElement("table");
    tabella.id = idTabella;
    tabella.className = classeTabella;

    // riga intestazione
    let tHead = document.createElement("thead");
    let riga = document.createElement("tr");
    if (listaCampi == "") {
        let v = [];
        for (campo in oggJson[0]) {
            v.push(campo);
        }
        listaCampi = v.join(",");
    }
    let vCampi = listaCampi.split(",");
    vCampi.forEach(function (campo, i) {
        let th = document.createElement("th");
        th.innerHTML = campo;
        riga.appendChild(th);
    });
    tHead.appendChild(riga);
    tabella.appendChild(tHead);

    // tbody
    let tBody = document.createElement("tbody");
    oggJson.forEach(function (record, i) {
        riga = document.createElement("tr");
        vCampi.forEach(function (campo, j) {
            let cella = document.createElement("td");
            cella.innerHTML = record[campo];    // oggJson[i][campo]
            riga.appendChild(cella);
        });
        tBody.appendChild(riga);
    });
    tabella.appendChild(tBody);

    if (oggJson.length > 0)
        // append della tabella al contenitore
        document.querySelector(contenitore).appendChild(tabella);
}

function getValueRadioButton(name) {
    let valore = "";
    document.querySelectorAll("[name=" + name + "]").forEach(function(radio, k) {
        if (radio.checked) {
            valore = radio.value;
        }
    });
    
    return valore;
}
