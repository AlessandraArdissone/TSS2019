/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelector("#sediMenu").classList.add("active");

var jsonSedi;

document.querySelector("body").onload = caricaSedi;

function caricaSedi() {
    //fetch('http://localhost:8080/nostalciac/resources/sedi?' + Math.random())   // per aggirare la cache del server (ma non funziona)
    fetch('http://localhost:8080/nostalciac/resources/sedi')
            .then(response => response.json())
            .then(json => {
                creaTabellaDaJsonDB(json, "nome,citta,tel,mail", "Sede,Città,Telefono,e-mail", "tabSedi", "tabella", "#div_sedi", "id", evModSede, evCancSede);
                jsonSedi = json;
//                console.log(json);
            })
            .catch(x => {
                alert("err" + x);
//                console.log("err", x);
            });

    document.querySelector("#div_modifica").style.display = "none";
}

let evModSede = function () {
    //alert("Modifica record " + this.getAttribute("idRec"));
    prepModSede( this.getAttribute("idx"));
};

function prepModSede( idx) {
//    console.log("prepModSede", idx);
    let idRec = jsonSedi[idx]["id"];
    caricaSede(idRec);
    creaNavigator(jsonSedi, idx, "#div_nav", prepModSede, "id");
    document.querySelector("#div_modifica").style.display = "block";
}

let evCancSede = function () {
    alert("Elimina record " + this.getAttribute("idRec"));
};

function caricaSede(idSede) {
    let sede = getRecJson(jsonSedi, "id", idSede);

    document.querySelector("#idSede").value = idSede;
    document.querySelector("#nome").value = sede.nome;
    document.querySelector("#indirizzo").value = sede.indirizzo;
    document.querySelector("#tel").value = sede.tel;
    document.querySelector("#citta").value = sede.citta;
    document.querySelector("#mail").value = sede.mail;
    document.querySelector("#note").value = sede.note;
}
;

document.querySelector("#b_annulla").onclick = function () {
    document.querySelector("#div_modifica").style.display = "none";
};

document.querySelector("#b_modSede").onclick = function () {
//    console.log("click su modifica sede");

    let idSede = document.querySelector("#idSede").value;

    let sede = {};
    sede.nome = document.querySelector("#nome").value.trim();
    sede.indirizzo = document.querySelector("#indirizzo").value;
    sede.tel = document.querySelector("#tel").value;
    sede.citta = document.querySelector("#citta").value;
    sede.mail = document.querySelector("#mail").value;
    sede.note = document.querySelector("#note").value;

//    console.log("modifico", sede);

    fetch('http://localhost:8080/nostalciac/resources/sedi/' + idSede, {
        method: 'put',

        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

        body: JSON.stringify(sede)

    }).then(function (response) {
//        console.log("response:", response);
//        console.log("response.text():", response.text());
        caricaSedi();
        return;
    }).catch(res => console.error("ERRORE:", res));
}
;