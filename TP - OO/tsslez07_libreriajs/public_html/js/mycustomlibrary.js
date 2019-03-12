/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function create_listBR(arrayString) {
    let content = "";
    for (let i = 0; i < arrayString.length; i++) {
        content += arrayString[i] + "</br>";
    }
    return content;
}

function create_listBRObj(arrayString, objHTML) {
    let content = "";
    for (let i = 0; i < arrayString.length; i++) {
        content += arrayString[i] + "</br>";
    }
    objHTML.innerHTML = content;
}

function create_orderedlist(arrayString) {
    let content = "";
    for (let i = 0; i < arrayString.length; i++) {
        if (i === 0)
            content += "<ol>";
        content += "<li>" + arrayString[i] + "</li>";
        if (i === (arrayString.length - 1))
            content += "</ol>";
    }
    return content;
}

function create_orderedlistObj(arrayString, objHTML) {
    let content = "";
    for (let i = 0; i < arrayString.length; i++) {
        if (i === 0)
            content += "<ol>";
        content += "<li>" + arrayString[i] + "</li>";
        if (i === (arrayString.length - 1))
            content += "</ol>";
    }
    objHTML.innerHTML = content;
}

function create_listTable(arrayString) {
    let content = "";
    for (let i = 0; i < arrayString.length; i++) {
        if (i === 0) {
            content += "<table border=1>";
            content += "<tr>";
            content += "<th>Nr.</th>";
            /*
             content += "<th>Quadrato</th>";
             content += "<th>Cubo</th>";
             */
            content += "<th>Nome</th>";
            content += "</tr>";
        }
        content += "<tr><td>" + (i + 1) + "</td>";
        /*
         content += "<td>" + squarePower((i + 1)) + "</td>";
         content += "<td>" + cubePower((i + 1)) + "</td>";
         */
        content += "<td>" + arrayString[i] + "</td></tr>";
        if (i === (arrayString.length - 1))
            content += "</table>";
    }
    return content;
}

function create_listTableObj(arrayString, objHTML) {
    let content = "";
    for (let i = 0; i < arrayString.length; i++) {
        if (i === 0) {
            content += "<table border=1>";
            content += "<tr>";
            content += "<th>Nr.</th>";
            /*
             content += "<th>Quadrato</th>";
             content += "<th>Cubo</th>";
             */
            content += "<th>Nome</th>";
            content += "</tr>";
        }
        content += "<tr><td>" + (i + 1) + "</td>";
        /*
         content += "<td>" + squarePower((i + 1)) + "</td>";
         content += "<td>" + cubePower((i + 1)) + "</td>";
         */
        content += "<td>" + arrayString[i] + "</td></tr>";
        if (i === (arrayString.length - 1))
            content += "</table>";
    }
    objHTML.innerHTML = content;
}

function cubePower(number) {
//    return Math.pow(number, 3);

    return number * number * number;
}

function squarePower(number) {
//    return Math.pow(number, 2);
    return number * number;
}

function power(numberIn, powIn) {
    let numberOut = 1;

    let powOut;

    if (powIn === undefined)
        powOut = 2;
    else
        powOut = Math.abs(powIn);

    for (let i = 0; i < powOut; i++)
        numberOut *= numberIn;

    if (powIn < 0)
        numberOut = 1 / numberOut;  //  TODO:   NON funziona con base0!!

    return numberOut;
}

function sum(add1, add2)
{
    return add1 + add2;
}