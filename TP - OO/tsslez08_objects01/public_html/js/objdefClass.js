/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// CLASSES AND SUBCLASSES DEFINITION
class Registry {
    constructor(name, phone, code, sex) {
        //  PROPERLY PREPARING DATA
        this.name = name.trim().toLowerCase();
        this.phone = phone;
        this.code = code * 1;
        let s = sex;
        s = s.trim().substr(0, 1).toUpperCase();
        this.sex = s;
    }

    sexName() {
        let res = "";

        if (this.sex === "M")
            res = "un uomo";
        else
            res = "una donna";

        return res;
    }

    sayHello() {
        let res = "";

        res = "Salve! Sono " + this.name + ", sono " + this.sexName() + " ed il mio numero di telefono è " + this.phone + ".";

        return res;
    }
}

class Player extends Registry {
    constructor(name, phone, code, sex, weight, role, height) {
        super(name, phone, code, sex);
        this.name = this.name.toUpperCase();
        this.weight = weight;
        this.role = role;
        this.height = height;
    }
// OVERRIDING SUPERIOR CLASS METHOD:
    sexName() {
        let res = "";

        if (this.sex === "M")
            res = "un giocatore";
        else
            res = "una giocatrice";

        return res;
    }

    sayHello() {
        let res = "";

        res = "Salve! Sono " + this.name + ", sono " + this.sexName() + " ed il mio ruolo è \"" + this.role + "\".";

        return res;
    }
}

class Referee extends Registry {
    constructor(name, phone, code, sex, category) {
        super(name, phone, code, sex);
        this.name = "Arb. " + name;
        this.category = category;
    }
// OVERRIDING SUPERIOR CLASS METHOD:
    sexName() {
        let res = "";

        if (this.sex === "M")
            res = "un arbitro";
        else
            res = "un arbitro donna";

        return res;
    }

    sayHello() {
        let res = "";

        res = "Salve! Sono " + this.name + ", sono " + this.sexName() + " e la mia categoria è \"" + this.category + "\".";

        return res;
    }
}

class Team {
    constructor(name, city, colors, category) {
        this.name = name;
        this.city = city;
        this.logo = "";
        this.colors = colors;
        this.category = category;
        this.players = [];
    }
    //METHODS
    listPlayersBR() {
        let res = "";

        for (let i = 0; i < this.players.length; i++) {
            res += "<br />" + this.players[i].code + " - " + this.players[i].name + " - " + this.players[i].role;
        }

        return res;
    }

    viewTeam() {
        let res = "";

        // Squadra "Juventus" con sede a Torino di serie A";
        res = "Squadra \"" + this.name + "\" con sede a " + this.city + " di " + this.category + ".";

        if (this.players.length > 0)
            res += "<br />Elenco giocatori:" + this.listPlayersBR();

        return res;
    }

    buyPlayer(aPlayer) {
        this.players.push(aPlayer);
    }

    sellPlayer(aCode) {
        for (let i = 0; i < this.players.length; i++) {
            let player = this.players[i];
            if (player.code == aCode) {
                this.players.splice(i, 1);
                break;
            }
        }
    }
}

class Championship {
    constructor(season) {
        this.season = season;
        this.matches = [];
    }

    addMatch(aMatch) {
        this.matches.push(aMatch);
    }

    listMatchesOPT() {
        let res = "";
        let i = 0;

        this.matches.forEach(function (aMatch) {
            res += "<option value='" + i + "'>" + aMatch.date + " - " + aMatch.hostTeam + " vs " + aMatch.guestTeam
                    + " => ris. " + aMatch.pt1 + "-" + aMatch.pt2 + "</option>";
            i++;
        });

        return res;
    }

    viewMatches() {
        let res = "";

        if (this.matches.length > 0) {
            res += "<select size='10' id='sel_matches'>";
            res += this.listMatchesOPT();
            res += "</select>";
        }

        return res;
    }
}

class League {
    constructor(name, description) {
        this.name = name;
        this.description = description;
        this.teams = [];
        this.referees = [];
        this.championships = [];
    }

    listTeamsBR() {
        let res = "";
        /*
         for (let i = 0; i < this.teams.length; i++)
         res += this.teams[i].viewTeam();
         */
        this.teams.forEach(function (aTeam) {
            res += aTeam.viewTeam();
        });

        return res;
    }

    listRefereesBR() {
        let res = "";

        this.referees.forEach(function (aReferee) {
            res += aReferee.code + " - " + aReferee.name + " - " + aReferee.category + "<br />";
        });

        return res;
    }

    viewLeague() {
        let res = "";

        // Lega "Juventus" con sede a Torino di serie A";
        res = "Lega " + this.name + " - " + this.description + ".";

        if (this.teams.length > 0) {
            res += "<br />Elenco squadre:<br />" + this.listTeamsBR();
        }

        if (this.referees.length > 0) {
            res += "<br />Elenco arbitri:<br />" + this.listRefereesBR();
        }

        return res;
    }

    addReferee(aReferee) {
        this.referees.push(aReferee);
    }

    addTeam(aTeam) {
        this.teams.push(aTeam);
    }

    addChampionship(aChampionship) {
        this.championships.push(aChampionship);
    }
    /*
     removeTeam(aCode) {
     for (let i = 0; i < this.teams.length; i++) {
     let team = this.teams[i];
     if (team.code == aCode) {
     this.teams.splice(i, 1);
     break;
     }
     }
     }
     */
}

class Match {
    constructor(date, place, hostTeam, guestTeam, refereeCode) {
        this.date = date;
        this.place = place;
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
        this.refereeCode = refereeCode;
        this.pt1 = "-";
        this.pt2 = "-";
        this.score = "da giocare";
    }
    
    getScore() {
        let res = "";
        if (this.pt1>this.pt2)
            res += "Ha vinto " + this.hostTeam + " " + this.pt1 + " punti contro " + this.pt2 + " di " + this.guestTeam;
        else
            res += "Ha vinto " + this.guestTeam + " " + this.pt2 + " punti contro " + this.pt1 + " di " + this.hostTeam;

        return res;
    }
}
/*
 const man = new Registry(" Monica Vitti", "454564564", "GJRKGERÒ", " female");
 alert(man.sayHello() + "..." + man.code);
 
 const myPlayer = new Player("Alessandro Altobelli ", "454564564", "007", " maschio", 92, "centrocampista", 190);
 alert(myPlayer.sayHello() + "..." + myPlayer.code);
 
 const myReferee = new Referee("Concetto Lobello", "454564564", "123", " femmina", "guardalinee");
 alert(myReferee.sayHello() + "..." + myReferee.code);
 */