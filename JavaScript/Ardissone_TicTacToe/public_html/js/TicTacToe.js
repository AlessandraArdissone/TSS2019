/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var gameType = "P";
var player = "";
var playerXname = "";
var playerOname = "";

document.getElementById("twoPlayers").className = "inline";
document.getElementById("onePlayer").className = "hide";
document.getElementById("pStart").onclick = startGame;
document.getElementsByName("type").forEach(
        function (elm, k) {
            elm.onclick = viewPlayerPanel;
        }, );


function setPlayerNames() {
    switch (gameType) {
        case "C":
            playerXname = document.getElementById("playerXc").value.trim();
            playerOname = document.getElementById("playerOc").value.trim();
            break;
        case "P":
            playerXname = document.getElementById("playerXp").value.trim();
            playerOname = document.getElementById("playerOp").value.trim();
            break;
    }
}

function lockPlayerNames(lock) {
    document.getElementById("playerXc").readOnly = lock;
    document.getElementById("playerXp").readOnly = lock;
    document.getElementById("playerOp").readOnly = lock;
}

function startGame() {
    document.getElementsByName("type").forEach(
            function (elm, k) {
                if (elm.checked)
                    gameType = elm.value;
            }, );

    setPlayerNames();

    if (playerXname != "" && playerOname != "" && playerXname != playerOname) {
        player = "X";
        createGameField();
        lockPlayerNames(true);
    } else
        alert("Inserire i nomi dei giocatori!");
}

function createGameField() {
    let res = "";
    res += "<table class='gameField'>";
    res += "<tbody>";
    res += "<tr class='bottomLine'>";
    res += "<td id='1' class='rightLine'></td>";
    res += "<td id='2' class='rightLine'></td>";
    res += "<td id='3'></td>";
    res += "</tr>";
    res += "<tr class='bottomLine'>";
    res += "<td id='4' class='rightLine'></td>";
    res += "<td id='5' class='rightLine'></td>";
    res += "<td id='6'></td>";
    res += "</tr>";
    res += "<tr>";
    res += "<td id='7' class='rightLine'></td>";
    res += "<td id='8' class='rightLine'></td>";
    res += "<td id='9'></td>";
    res += "</tr>";
    res += "</tbody>";
    res += "</table>";

    document.getElementById("gameContainer").innerHTML = res;

    document.querySelectorAll("table.gameField td").forEach(
            function (elm, k) {
                elm.occupied = "";
                elm.onclick = play;
            }, );
}

function viewPlayerPanel() {
    switch (this.value) {
        case "C":
            /*alert("computer");*/
            document.getElementById("twoPlayers").className = "hide";
            document.getElementById("onePlayer").className = "inline";
            break;
        case "P":
            /*alert("due giocatori");*/
            document.getElementById("twoPlayers").className = "inline";
            document.getElementById("onePlayer").className = "hide";
            break;
    }
}

function getPlayerName(id) {
    let name = "";

    switch (id) {
        case "X":
            name = playerXname;
            break;
        case "O":
            name = playerOname;
            break;
        default:
            alert("Gioco non inizializzato!");
            break;
    }

    return name;
}

function play() {
    let winner = "";

    switch (gameType) {
        case "C":
            winner = playVScomputer(this);
            break;
        case "P":
            winner = playVSplayer(this);
            break;
    }

    if (winner != "") {
        console.log(getPlayerName(winner) + " ha vinto!");
/*
        setTimeout(function(){
            alert(getPlayerName(winner) + " ha vinto!");
        },100);
*/
        myAlert(getPlayerName(winner) + " ha vinto!");
        
        document.querySelectorAll("table.gameField td").forEach(
                function (elm, k) {
                    elm.onclick = "";
                }, );

        lockPlayerNames(false);
    } else if (evaluateDrawn()) {
/*
        setTimeout(function(){
        alert("Schema completo, partita patta!");
        },100);
*/
        myAlert("Schema completo, partita patta!");

        document.querySelectorAll("table.gameField td").forEach(
                function (elm, k) {
                    elm.onclick = "";
                }, );

        lockPlayerNames(false);
    }
}

function myAlert(str) {
    document.querySelector("#result").innerHTML = str;
    document.querySelector("#resultContainer").style.display = "flex";
}

function evaluateDrawn() {
    let nFree = 0;
    document.querySelectorAll("table.gameField td").forEach(
            function (elm, k) {
                if (elm.occupied == "")
                    nFree++;
            }, );
    if (nFree == 0)
        return true;
    else
        return false;
}

function cpuThink() {
    let emptyCells = [];

    document.querySelectorAll("table.gameField td").forEach(
            function (elm, k) {
                if (elm.occupied == "")
                    emptyCells.push(elm.id);
            }, );

    let id = Math.floor(Math.random() * emptyCells.length);

    return document.getElementById(emptyCells[id]);
}

function playVScomputer(obj) {
    let winner = "";
    winner = insertSymbol(obj);
    if (winner == "" && !evaluateDrawn())
        winner = insertSymbol(cpuThink());

    return winner;
}

function playVSplayer(obj) {
    let winner = "";
    winner = insertSymbol(obj);
    return winner;
}

function insertSymbol(obj) {
    console.log(player + " " + obj.id);
    let winner = "";
    if (obj.occupied != "")
        alert("Casella già occupata!");
    else {
        switch (player) {
            case "X":
                obj.classList.add("X");
                obj.occupied = "X";
                winner = evaluateWinner(obj.id);
                player = "O";
                break;
            case "O":
                obj.classList.add("O");
                obj.occupied = "O";
                winner = evaluateWinner(obj.id);
                player = "X";
                break;
            default:
                alert("Gioco non inizializzato!")
                break;
        }
    }
    console.log("simbolo inserito");
    return winner;
}

function isThree(numA, numB, numC) {
    let objA = document.getElementById(numA);
    let objB = document.getElementById(numB);
    let objC = document.getElementById(numC);
    if (objA.occupied == player
            && objB.occupied == player
            && objC.occupied == player) {
        objA.classList.add("win");
        objB.classList.add("win");
        objC.classList.add("win");
        return true;
    } else
        return false;
}

function evaluateWinner(num) {
    let winner = "";
    switch (num) {
        case "1":
            if (isThree(num, "2", "3")
                    || isThree(num, "4", "7")
                    || isThree(num, "5", "9"))
                winner = player;
            break;
        case "2":
            if (isThree(num, "1", "3")
                    || isThree(num, "5", "8"))
                winner = player;
            break;
        case "3":
            if (isThree(num, "2", "1")
                    || isThree(num, "6", "9")
                    || isThree(num, "5", "7"))
                winner = player;
            break;
        case "4":
            if (isThree(num, "5", "6")
                    || isThree(num, "1", "7"))
                winner = player;
            break;
        case "5":
            if (isThree(num, "1", "9")
                    || isThree(num, "3", "7")
                    || isThree(num, "2", "8")
                    || isThree(num, "4", "6"))
                winner = player;
            break;
        case "6":
            if (isThree(num, "3", "9")
                    || isThree(num, "4", "5"))
                winner = player;
            break;
        case "7":
            if (isThree(num, "1", "4")
                    || isThree(num, "8", "9")
                    || isThree(num, "3", "5"))
                winner = player;
            break;
        case "8":
            if (isThree(num, "2", "5")
                    || isThree(num, "7", "9"))
                winner = player;
            break;
        case "9":
            if (isThree(num, "1", "5")
                    || isThree(num, "7", "8")
                    || isThree(num, "3", "6"))
                winner = player;
            break;
    }

    return winner;
}