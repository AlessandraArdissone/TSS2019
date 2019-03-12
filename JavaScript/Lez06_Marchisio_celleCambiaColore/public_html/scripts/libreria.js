/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * questa funzione genera una tabella passando il numero di righe e colonne
 * e ritorna una stringa che rappresenta il codice html della tabella richiesta
 * 
 * @param {type} righe
 * @param {type} colonne
 * @param {type} id
 * @param {type} classe
 * @returns {String}
 */
function generaTabHtml(righe, colonne, id, classe) {
    let ret = "<table";

    if (id != "")
        ret += " id='" + id + "'";

    if (classe != "")
        ret += " class='" + classe + "'";

    ret += ">";

    for (let i = 0; i < righe; i++) {
        ret += "<tr>";

        for (let j = 0; j < colonne; j++)
            ret += "<td></td>";

        ret += "</tr>";
    }

    ret += "</table>";

    return ret;
}
