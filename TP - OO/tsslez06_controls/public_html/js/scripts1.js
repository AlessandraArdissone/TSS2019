/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var s_name="";
var s_surname="";

function get_name() {
    let name = document.getElementById("in_name").value;
    if (name==="") {
        alert("Inserire il nome!");
        return false;
    }
    else {
        s_name = name;
        return true;
    }
}

function get_surname() {
    let surname = document.getElementById("in_surname").value;
    if (surname==="") {
        alert("Inserire il cognome!");
        return false;
    }
    else {
        s_surname = surname;
        return true;
    }
}

function make_greetings() {
    if (get_name() && get_surname())
        document.getElementById("out_greetings").innerHTML="Hello, "+s_name+" "+s_surname+"!";
}