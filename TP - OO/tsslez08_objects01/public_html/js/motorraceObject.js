/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var ar_race = [];

function Pilot(s_driver, s_car) {
    this.driver = s_driver;
    this.car = s_car;
    this.startPos = 0;
    this.finishPos = 0;
    this.viewEntry = function () {
        return "<tr><td>" + this.driver + "</td><td>" + this.car + "</td><td>" + this.startPos.toString() + "</td><td>" + this.finishPos + "</td></tr>";
      //return "<tr id='row"+ i + "' sel='0' onclick='selectRow()'><td>" + this.driver + "</td><td>" + this.car + "</td><td>" + this.startPos.toString() + "</td><td>" + this.finishPos + "</td></tr>";
    };
}

function addPilot() {
    let s_driver = document.getElementById("in_driver").value.trim();
    let s_car = document.getElementById("in_car").value.trim();
    
    let o_Pilot = new Pilot(s_driver, s_car);
 
    if (s_driver !== "" && s_car !== "") {
        ar_race.push(o_Pilot);
        document.getElementById("div_errors").innerHTML = "";
    } else
        errorMsg("Inserire pilota ed automobile!");

    document.getElementById("in_driver").value = "";
    document.getElementById("in_car").value = "";
    
    document.getElementById("in_driver").focus();
}

function errorMsg(strErr) {
    document.getElementById("div_errors").innerHTML = strErr;
}

function viewEnrollment() {
    let ris = "";
    if (ar_race.length > 0) {
        ris += "<table border=1><tbody>";
        ris += "<tr><th>Pilota</th><th>Auto</th><th>Griglia</th><th>Arrivo</th></tr>";
    }

    for (let i = 0; i < ar_race.length; i++)
        ris += ar_race[i].viewEntry();
    if (ar_race.length > 0)
        ris += "</tbody></table>";
    document.getElementById("div_race").innerHTML = ris;
}

function assignStartPosition() {
    for (let i = 0; i < ar_race.length; i++)
        ar_race[i].startPos = (i + 1);
    viewEnrollment();
}

function getStartPos() {
    let startPos = document.getElementById("in_startPos").value * 1;
    return startPos;
}

function getFinishPos() {
    let finishPos = document.getElementById("in_finishPos").value * 1;
    return finishPos;
}

function assignFinishPosition() {
    let n_startPos = getStartPos();
    let n_finishPos = getFinishPos();
    if (n_startPos && n_finishPos) {
        let i;
        for (i = 0; i < ar_race.length; i++) {
            let temp = ar_race[i];
            if (temp.startPos === n_startPos)
                break;
        }

        ar_race[i].finishPos = n_finishPos;
        viewEnrollment();
    }
}

function viewRaceArrivals() {
    let ris = "";
    ris += "<table border=1><tbody>";
    ris += "<tr><th>Pilota</th><th>Auto</th><th>Griglia</th><th>Arrivo</th></tr>";
    for (let r = 1; r <= ar_race.length; r++) {
        for (let i = 0; i < ar_race.length; i++) {
            let el = ar_race[i];
            if (el.finishPos === r) {
                ris += el.viewEntry();
                break;
            }
        }
    }

    ris += "</tbody></table>";
    document.getElementById("div_race").innerHTML = ris;
}