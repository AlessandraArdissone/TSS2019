/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var ar_race = [];

function add_pilot() {
    let s_driver = document.getElementById("in_driver").value.trim();
    let s_car = document.getElementById("in_car").value.trim();
    let n_startpos = 0;
    let n_finishpos = 0;

    let struct_pilot = {
        driver: s_driver,
        car: s_car,
        startPos: n_startpos,
        finishPos: n_finishpos,
        view_entry: function () {
            return "<tr><td>" + this.driver + "</td><td>" + this.car + "</td><td>" + this.startPos.toString() + "</td><td>" + this.finishPos + "</td></tr>";
        }
    };

    if (s_driver !== "" && s_car !== "") {
        ar_race.push(struct_pilot);
        document.getElementById("div_errors").innerHTML = "";
    } else
        errorMsg("Inserire pilota ed automobile!");
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
        ris += ar_race[i].view_entry();

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
                ris += el.view_entry();
                
                let node = document.createElement("div");
                node.style = "position:absolute;left:" + (r-1) * 100 + "px";
                node.innerHTML = el.driver;
                document.getElementById("div_stage").appendChild(node);
                
                break;
            }
        }
    }

    ris += "</tbody></table>";

    document.getElementById("div_race").innerHTML = ris;
}