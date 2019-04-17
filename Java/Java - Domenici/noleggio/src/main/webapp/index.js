fetch('http://localhost:8080/noleggio/resources/biciclette')
        .then(response => response.json())
        .then(data => renderData(data));

function renderData(data){
    data.map(bici => renderBici(bici))
            .forEach(el => document.body.appendChild(el));
}

function renderBici(bici){
    const el = document.createElement("p");
    el.innerHTML = `marca -> ${bici.marca} | modello ${bici.modello}`;
    return el;
}   

