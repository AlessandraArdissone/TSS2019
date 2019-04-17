/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const elSearch = document.getElementById("search");
const btn = document.getElementById("invia");
const tbody = document.querySelector("tbody");

btn.addEventListener("click", e => onSearch(e));

function onSearch(e) {
    e.preventDefault();
    console.log("search ..", elSearch.value);
    fetch('http://localhost:8080/lez15-servlet/api/customers/search?name=' + elSearch.value)
            .then(response => response.json())
            .then(json => fillTable(json));
}

function fillTable(data){
    tbody.innerHTML = '';
    data.map(customer => renderRow(customer))
            .forEach(row => tbody.appendChild(row));
}

function renderRow(customer){
    const row = document.createElement("tr");
    row.innerHTML = 
        `   <td>${customer.id}</td>
            <td>${customer.name}</td>
        `;
    return row;
}