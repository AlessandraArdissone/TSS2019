/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const elSearch = document.getElementById("search");
const btn = document.getElementById("invia");

btn.addEventListener("click", e => onSearch(e));

function onSearch(e) {
    // previene l'azione di default del pulsante, cioè la SUBMIT
    e.preventDefault();
    console.log("search...", elSearch.value);

    document.querySelector("#risultatoRicerca").innerHTML = "";

    fetch('http://localhost:8080/lez15_servlet/api/customers/search?name=' + elSearch.value)
            .then(response => response.json())
            .then(json => {creaTabellaDaJson(json, "id,name,city,country", "tabAnagrafica", "tabella", "#risultatoRicerca");return json;})
            .then(cacca => console.log("cacca "+cacca));
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
