/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var jsonTags;

function caricaTag() {
    
    
    fetch('http://localhost:8080/nostalciac/resources/tags')
            .then(response => {
                console.log("response...", response);
                return response.json();
            })
            .then(json => {
                document.querySelector("#contenitore").innerHTML = "";
                creaTabellaDaJson(json, "id,tag,tipo", "tab1", "tabella", "#contenitore");
                jsonTags = json;
            })
            .then(e => caricaSelect())
            .catch(x => {
                alert("err" + x);
                console.log("err", x);
            });

}

caricaTag();

function caricaSelect() {
    //
    document.querySelector("#sel_tags").innerHTML = ""
    
    let opt = document.createElement("option");
    opt.innerHTML = "Scegli il record da modificare";
    opt.value = -1;
    document.querySelector("#sel_tags").append(opt);

    jsonTags.forEach((tag, j) => {
        let opt = document.createElement("option");
        opt.innerHTML = tag.id + " --> " + tag.tag + " - " + tag.tipo;
        opt.value = j;
        opt.setAttribute("tag", tag.tag);
        opt.setAttribute("tipo", tag.tipo);
        opt.setAttribute("idTag", tag.id); //meglio che id
        document.querySelector("#sel_tags").append(opt);

    })


}



//window.onload = function () {


document.querySelector("#sel_tags").onchange = function (e) {

    let indiceOpzione = document.querySelector("#sel_tags").selectedIndex
    let opzioneSelezionata = document.querySelector("#sel_tags").options[indiceOpzione]

    let value = opzioneSelezionata.value;
    let idTag = jsonTags[value].id;
    let tipo = jsonTags[value].tipo;
    let tag = jsonTags[value].tag;

    //alternativa      
    //let idTag = opzioneSelezionata.getAttribute("idTag")
    //let tipo = opzioneSelezionata.getAttribute("tipo")
    //let tag = opzioneSelezionata.getAttribute("tag")

    document.querySelector("#tag").value = tag;
    document.querySelector("#tipo").value = tipo;
    console.log(idTag, tipo, tag);
}

//}


document.querySelector("#b_modTag").onclick = function () {
    console.log("click su modifica tag")

    let indiceOpzione = document.querySelector("#sel_tags").selectedIndex
    let opzioneSelezionata = document.querySelector("#sel_tags").options[indiceOpzione]

    let value = opzioneSelezionata.value

    let idTag = jsonTags[value].id

    let obj = {}

    obj.tipo = document.querySelector("#tipo").value
    obj.tag = document.querySelector("#tag").value

    console.log("invio", obj)

    fetch('http://localhost:8080/nostalciac/resources/tags/' + idTag, {
        method: 'put',

        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

        body: JSON.stringify(obj)

    }).then(function (response) {
        console.log("response:", response)
        console.log("response.text():", response.text())
        
        caricaTag()
        caricaSelect()
        return;
    }).catch(res => console.error("ERRORE:", res))


}