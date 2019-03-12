/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// CREO LA LEGA:
const myLeague = new League("FIGC", "Federazione Italiana Giuoco Calcio");
function init() {
// CREO GLI ARBITRI:
    var myReferee = new Referee("Concetto Lobello", "454564564", "123", " femmina", "guardalinee");
    myLeague.addReferee(myReferee);
    myReferee = new Referee("Pierluigi Collina", "454564564", "124", " maschio", "direttore di gara");
    myLeague.addReferee(myReferee);
    myReferee = new Referee("Byron Moreno", "454564564", "125", " maschio", "pirla");
    myLeague.addReferee(myReferee);
// CREO GIOCATORI E SQUADRE:
// PRIMA SQUADRA:
    var myTeam = new Team("Juventus", "Torino", "bianco-nero", "serie A");

    var myPlayer = new Player("Alessandro Altobelli ", "454564564", "007", " maschio", 92, "centrocampista", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Mimì Ayuhara", "454564564", "001", " fem", 92, "schiacciatrice", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Ken il guerriero", "454564564", "002", " m", 92, "distruttore", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Suzie Quatro", "454564564", "003", " m", 92, "cantante", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Tua mamma", "454564564", "004", " f", 92, "battona", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Lucio Anneo Seneca", "454564564", "05", " f", 92, "filosofo", 190);
    myTeam.buyPlayer(myPlayer);

    myLeague.addTeam(myTeam);
// SECONDA SQUADRA:
    myTeam = new Team("Inter", "Milano", "nero-azzurro", "serie A");

    myPlayer = new Player("Francesco Totti", "454564564", "006", " maschio", 92, "centrocampista", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Toshiro Mifune", "454564564", "008", " fem", 92, "schiacciatrice", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Gigi La Trottola", "454564564", "009", " m", 92, "distruttore", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Joan Jett", "454564564", "010", " m", 92, "cantante", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Tua sorella", "454564564", "011", " f", 92, "maiala", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Marco Tullio Cicerone", "454564564", "12", " f", 92, "retore", 190);
    myTeam.buyPlayer(myPlayer);

    myLeague.addTeam(myTeam);
// TERZA SQUADRA:
    myTeam = new Team("Milan", "Milano", "rosso-nero", "serie A");

    myPlayer = new Player("Alessandro Delpiero", "454564564", "013", " maschio", 92, "centrocampista", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Ciccio Ingrassia", "454564564", "014", " fem", 92, "portiere", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Bud Spencer", "454564564", "015", " m", 92, "picchiatore", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Ada Lovelace", "454564564", "016", " m", 92, "cantante", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Tuo nonno", "454564564", "017", "m", 92, "maniaco", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Blaise Pascal", "454564564", "18", " f", 92, "straccia-maroni", 190);
    myTeam.buyPlayer(myPlayer);

    myLeague.addTeam(myTeam);
// QUARTA SQUADRA:
    myTeam = new Team("A.S. Roma", "Roma", "giallo-rosso", "serie A");

    myPlayer = new Player("Rosy Garda", "454564564", "019", " maschio", 92, "centrocampista", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Franco Franchi", "454564564", "020", " fem", 92, "portiere", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Terence Hill", "454564564", "021", " m", 92, "picchiatore", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Giuliano Gemma", "454564564", "022", " m", 92, "cantante", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Franco Nero", "454564564", "023", "m", 92, "maniaco", 190);
    myTeam.buyPlayer(myPlayer);

    myPlayer = new Player("Moana Pozzi", "454564564", "24", " f", 92, "straccia-maroni", 190);
    myTeam.buyPlayer(myPlayer);

    myLeague.addTeam(myTeam);
// CREO IL CAMPIONATO CON LE PARTITE:
    var myChampionship = new Championship("Serie A TIM 2018-2019");

    var myMatch = new Match("2019/02/14", "Genova", "Juventus", "Inter", "125");
    myChampionship.addMatch(myMatch);

    myMatch = new Match("2019/02/28", "Napoli", "Inter", "Juventus", "124");
    myChampionship.addMatch(myMatch);

    myMatch = new Match("2019/05/24", "Duluth", "A.S. Roma", "Milan", "125");
    myChampionship.addMatch(myMatch);

    myMatch = new Match("2019/06/10", "Venezia", "Milan", "A.S. Roma", "123");
    myChampionship.addMatch(myMatch);

    myMatch = new Match("2019/09/05", "Trieste", "Juventus", "A.S. Roma", "123");
    myChampionship.addMatch(myMatch);
// AGGIUNGO IL CAMPIONATO ALLA LEGA:
    myLeague.addChampionship(myChampionship);

    document.getElementById("div_output").innerHTML = myLeague.championships[0].viewMatches();
}
/*
 document.write(myLeague.viewLeague());
 document.write("<br />");
 document.write(myLeague.championships[0].viewMatches());
 */
function addScore() {
    let pt1 = document.getElementById("in_pt1").value * 1;
    let pt2 = document.getElementById("in_pt2").value * 1;
    let mIndex = document.getElementById("sel_matches").value;
    if (mIndex != "") {
        let champ = myLeague.championships[0];
        let match = champ.matches[mIndex];

        match.pt1 = pt1;
        match.pt2 = pt2;

        document.getElementById("div_output").innerHTML = myLeague.championships[0].viewMatches();
    } else
        alert("ATTENZIONE! Selezionare la partirta a cui si vuole assegnare il risultato!");
}