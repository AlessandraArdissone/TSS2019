/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelector("#homeMenu").classList.add("active");

document.querySelector("#callDB").onclick = function () {
    fetch('http://localhost:8080/nostalciac/resources/tags')
            .then(response => response.json())
            .then(json => {
                creaTabellaDaJson(json, "", "tabTags", "tabella", "#risultato");
                console.log(json);
            })
            .catch(x => {
                alert("err" + x);
                console.log("err", x);
            });
};

document.querySelector("#b_post").onclick = function () {
    fetch('http://localhost:8080/nostalciac/resources/tags', {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "tag": "storia",
            "tipo": "comunicazione"
        })
    })
            .then(function (response) {
                console.log("response:", response);
            })
            .catch(res => console.error(res));
};

console.log("pagina nostalciac.js");