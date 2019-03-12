/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var maxVote = 100;
var ar_exams = [];

function add_exam() {
    let s_firstName = document.getElementById("in_firstName").value.trim();
    let s_lastName = document.getElementById("in_lastName").value.trim();
    let n_vote = document.getElementById("in_vote").value*1;

    let struct_student = {
        firstName       : s_firstName,
        lastName        : s_lastName, 
        vote            : n_vote,
        examResultBR    : function() {
                            let res = this.firstName + " " + this.lastName + " ha preso " + this.vote + ".<br/>";
                            return res;
                          },
        examResultTable : function() {
                            let res = "<td>" + this.firstName + "</td><td>" + this.lastName + "</td><td>" + this.vote + "</td>";
                            return res;
                          },
        examResultOL    : function() {
                            let res = "<li>" + this.firstName + " " + this.lastName + " ha preso " + this.vote + ".</li>";
                            return res;
                          }
    };

    if ( s_firstName !== "" && s_lastName !== "" && !Number.isNaN(n_vote) && n_vote !== 0 ) {
        ar_exams.push(struct_student);
        document.getElementById("div_errors").innerHTML = "";
    }
    else
        errorMsg();

    viewExamOL();
//  viewExamsTable();
//  viewExamsBR();
//  create_examTable(ar_exams, document.getElementById("div_exams"));
}

function viewExamOL() {
    let content = "";
    for (let i=0; i<ar_exams.length; i++) {
        if (i === 0)
            content += "<ol>";

        content += ar_exams[i].examResultOL();

        if (i === (ar_exams.length - 1))
            content += "</ol>";
    }
    document.getElementById("div_exams").innerHTML = content;
}

function viewExamsTable() {
    let content = "";
    for (let i=0; i<ar_exams.length; i++) {
        if (i === 0) {
            content += "<table border=1>";
            content += "<tbody>";
            content += "<tr>";
            content += "<th>Nr.</th>";
            content += "<th>Nome</th>";
            content += "<th>Cognome</th>";
            content += "<th>Voto</th>";
            content += "</tr>";
        }

        content += "<tr>";
        content += "<td>" + (i + 1) + "</td>";
        content += ar_exams[i].examResultTable();
        content += "</tr>";

        if (i === (ar_exams.length - 1)) {
            content += "</tbody>";
            content += "</table>";
        }
    }
    document.getElementById("div_exams").innerHTML = content;
}

function viewExamsBR() {
    let content = "";
    for (let i=0; i<ar_exams.length; i++)
        content += ar_exams[i].examResultBR();
    document.getElementById("div_exams").innerHTML = content;
}

function create_examTable(arrayObj, objHTML) {
    let content = "";
    for (let i = 0; i < arrayObj.length; i++) {
        if (i === 0) {
            content += "<table border=1>";
            content += "<tbody>";
            content += "<tr>";
            content += "<th>Nr.</th>";
            content += "<th>Nome</th>";
            content += "<th>Cognome</th>";
            content += "<th>Voto</th>";
            content += "</tr>";
        }
        content += "<tr><td>" + (i + 1) + "</td>";
        content += "<td>" + arrayObj[i].firstName + "</td>";
        content += "<td>" + arrayObj[i].lastName + "</td>";
        content += "<td>" + arrayObj[i].vote + "</td></tr>";

        if (i === (arrayObj.length - 1)) {
            content += "</tbody>";
            content += "</table>";
        }
    }
    
    objHTML.innerHTML = content;
}

function errorMsg() {
    document.getElementById("div_errors").innerHTML = "Voto non inserito: verificare i dati!";
}