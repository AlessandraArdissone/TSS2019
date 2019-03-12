/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
export default class Giocatore {
    constructor(soldi, nome) {
        if (soldi <= 0)
            throw "PER GIOCARE DEVI AVERE I SOLDI!";

        this._soldi = soldi;
        this._nome = nome;
    }

    get soldi() {
        console.log("LETTURA SOLDI");
        return _soldi;
    }

    set soldi(valore) {
        if (valore <= 0)
            throw "PER GIOCARE DEVI AVERE I SOLDI!";

        this._soldi = valore;
    }

    get nome() {
        return _nome;
    }

    set nome(valore) {
        this._nome = valore;
    }

    incrementaSoldi() {
        this.soldi++;
    }

    decrementaSoldi() {
        this.soldi++;
    }
}

