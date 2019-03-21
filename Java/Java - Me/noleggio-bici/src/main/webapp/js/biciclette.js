/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
console.log("biciclette:");

fetch('http://localhost:8080/noleggio-bici/resources/biciclette')
        .then(response => response.json())
        .then(json => {
            creaTabellaDaJson(json, "", "tabBiciclette", "tabella", "#risultatoRicerca");
            return json;
        })
        .then(data => {
            renderData(data);
            return data;
        })
        .then(biciclette => console.log(biciclette));

function renderData(data) {
    data.map(bici => renderBici(bici))
            .forEach(el => document.body.appendChild(el));
}

function renderBici(bici) {
    const el = document.createElement("p");
    el.innerHTML = `marca -> ${bici.marca} | modello -> ${bici.modello}`;  // template string con il back-tick
    return el;
}

function creaTabellaDaJson(oggJson, listaCampi, idTabella, classeTabella, contenitore = "body") {
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
            cella.innerHTML = record[campo];    // oggJson[j][campo]
            riga.appendChild(cella);
        });
        tBody.appendChild(riga);
    });
    tabella.appendChild(tBody);

    if (oggJson.length > 0)
        // append della tabella al contenitore
        document.querySelector(contenitore).appendChild(tabella);
}
