/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var s_name="";
var s_surname="";

var n_vote=0;
var n_minvote=0;

var ar_votes = [];
var ar_names = [];

var summary="";

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

function get_vote() {
    let vote = document.getElementById("in_vote").value;
    if (vote==="") {
        alert("Inserire il voto!");
        return false;
    }
    else {
        if (isNaN(vote)) {
            alert("Voto non valido!");
            return false;
        }
        else {
            n_vote = vote*1;
//          n_vote = Number.parseInt(vote); //  metodo più "elegante"
//          n_vote = parseInt(vote); //  metodo più "elegante"
            return true;
        }
    }
}

function get_minvote() {
    let minvote = document.getElementById("in_minvote").value;
    if (minvote==="") {
        alert("Inserire il voto minimo!");
        return false;
    }
    else {
        if (isNaN(minvote)) {
            alert("Voto minimo non valido!");
            return false;
        }
        else {
            n_minvote = minvote*1;
            return true;
        }
    }
}

function stringToUPPER(string) {
    return string.toUpperCase().trim();
}

function exam_result() {
    if (get_vote() && get_minvote()) {
        if (n_vote >= n_minvote)
            document.getElementById("out_exam").innerHTML=s_name+" "+s_surname+" promosso!";
        else
            document.getElementById("out_exam").innerHTML=s_name+" "+s_surname+" bocciato!";
    }
}

function exam_resultUPPER() {
    if (get_vote() && get_minvote()) {
        if (n_vote >= n_minvote)
            document.getElementById("out_examUPPER").innerHTML=s_name.toUpperCase()+" "+stringToUPPER(s_surname)+" PROMOSSO!";
        else
            document.getElementById("out_examUPPER").innerHTML=s_name.toUpperCase()+" "+stringToUPPER(s_surname)+" BOCCIATO!";
    }
}

function addVote() {
    if (get_vote())
        ar_votes.push(n_vote);
    view_summary();
}

function view_summary() {
    let sum_votes = 0;

    for (let i=0; i<ar_votes.length; i++) {
        sum_votes+=ar_votes[i]*1;
    }
    let average = sum_votes/ar_votes.length;
    if (isNaN(average))
        summary = "Inseriti "+ar_votes.length+".";
    else    
        summary = "Inseriti "+ar_votes.length+" - media "+average+".";
    
    document.getElementById("out_summary").innerHTML = summary;
}

function addNameVote() {
    if (get_vote() && get_name() && get_surname()) {
        ar_votes.push(n_vote);
        ar_names.push(s_name + " " + s_surname);
    }
    view_list();
}

function view_list() {
    view_summary();
    let list="";
    let best_vote=0;
    let best_name="";
    
    for (let i=0; i<ar_names.length; i++) {
        if (i===0)
            list+="<ol>";
        list+="<li>"+ar_names[i]+" - "+ar_votes[i]+"</li>";
        if (i===(ar_names.length-1))
            list+="</ol>";
//      list+="#"+(i+1)+" "+ar_names[i]+" - "+ar_votes[i]+"<br>";
        if ((ar_votes[i]*1)>best_vote) {
            best_vote = ar_votes[i];
            best_name= "Migliore "+ar_names[i]+" con "+ar_votes[i]+".";
        }
    }
    document.getElementById("out_list").innerHTML = summary+"<br>"+list+"<br>"+best_name;
}