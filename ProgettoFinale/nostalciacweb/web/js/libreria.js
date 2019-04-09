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

//  TODO: passare lista con nomeCampo, caption e formato (per allineamento)
function creaTabellaDaJsonDB(oggJson, listaCampi, listaIntestaz, idTabella, classeTabella,
        contenitore = "body", id = "id", funcMod, funcElim) {
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
    if (listaIntestaz == "") {
        let v = [];
        for (campo in oggJson[0]) {
            v.push(campo);
        }
        listaIntestaz = v.join(",");
    }
    let vHead = listaIntestaz.split(",");
    let th;
    vHead.forEach(function (head, i) {
        th = document.createElement("th");
        th.innerHTML = head;
        riga.appendChild(th);
    });
    th = document.createElement("th");
    th.setAttribute("colspan", 2);
    let spanDB = document.createElement("span");
    spanDB.className = "inserisciDB";
    //spanDB.innerHTML = "+";
    spanDB.setAttribute("title", "Nuova sede");
    th.appendChild(spanDB);
    riga.appendChild(th);
    tHead.appendChild(riga);
    tabella.appendChild(tHead);

    // tbody
    let tBody = document.createElement("tbody");
    oggJson.forEach(function (record, i) {
        riga = document.createElement("tr");
        let cella;
        vCampi.forEach(function (campo, j) {
            cella = document.createElement("td");
            cella.innerHTML = record[campo];    // oggJson[i][campo]
            riga.appendChild(cella);
        });
        cella = document.createElement("td");
        spanDB = document.createElement("span");
        spanDB.className = "modificaDB";
        spanDB.setAttribute("idRec", record[id]);
        spanDB.setAttribute("idx", i);
        //spanDB.innerHTML = "M";
        spanDB.setAttribute("title", "Modifica");
        spanDB.onclick = funcMod;
        cella.appendChild(spanDB);
        riga.appendChild(cella);
        cella = document.createElement("td");
        spanDB = document.createElement("span");
        spanDB.className = "eliminaDB";
        spanDB.setAttribute("idRec", record[id]);
        //spanDB.innerHTML = "E";
        spanDB.setAttribute("title", "Elimina");
        spanDB.onclick = funcElim;
        cella.appendChild(spanDB);
        riga.appendChild(cella);
        tBody.appendChild(riga);
    });
    tabella.appendChild(tBody);

    if (oggJson.length > 0)
        // append della tabella al contenitore
        document.querySelector(contenitore).appendChild(tabella);
}

function getRecJson(obJson, campoId = "id", id) {
    for (let i = 0; i < obJson.length; i++) {
        if (obJson[i][campoId] == id) {
            return obJson[i];
        }
}
}


/**
 * 
 * @param {type} json   array json
 * @param {type} idx    indice del json
 * @param {type} contenitore
 * @param {type} funz   funzione che serve x spostarsi (valore id del campo, indice del json)
 * @param {type} campoId
 * @returns {undefined}
 */
function creaNavigator(json, idx, contenitore, funz, campoId = "id") {
    document.querySelector(contenitore).innerHTML = "";

    let sp;

    sp = document.createElement("span");
    sp.setAttribute("name", "sp_first");
    sp.setAttribute("id", "sp_first");
    sp.className = "navigator";
    sp.innerHTML = "<<";
    if (idx > 0) {
        sp.onclick = function () {
            funz(0)
        };
    }
    document.querySelector(contenitore).appendChild(sp);

    sp = document.createElement("span");
    sp.setAttribute("name", "sp_prev");
    sp.setAttribute("id", "sp_prev");
    sp.className = "navigator";
    sp.innerHTML = "<";
    if (idx > 0) {
        sp.onclick = function () {
            funz(idx - 1)
        };
    }
    document.querySelector(contenitore).appendChild(sp);

    sp = document.createElement("span");
    sp.setAttribute("name", "sp_page");
    sp.setAttribute("id", "sp_page");
    sp.className = "navigator";
    sp.innerHTML = (idx * 1 + 1) + " / " + json.length;
    document.querySelector(contenitore).appendChild(sp);

    sp = document.createElement("span");
    sp.setAttribute("name", "sp_next");
    sp.setAttribute("id", "sp_next");
    sp.className = "navigator";
    sp.innerHTML = ">";
    if (idx < json.length - 1) {
        sp.onclick = function () {
            funz(idx * 1 + 1)
        };
    }
    document.querySelector(contenitore).appendChild(sp);

    sp = document.createElement("span");
    sp.setAttribute("name", "sp_last");
    sp.setAttribute("id", "sp_last");
    sp.className = "navigator";
    sp.innerHTML = ">>";
    if (idx < json.length - 1) {
        sp.onclick = function () {
            funz(json.length - 1)
        };
    }
    document.querySelector(contenitore).appendChild(sp);
}

function getValueRadioButton(name) {
    let valore = "";
    document.querySelectorAll("[name=" + name + "]").forEach(function (radio, k) {
        if (radio.checked) {
            valore = radio.value;
        }
    });

    return valore;
}
