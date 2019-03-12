/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class Pavimento {
    constructor(largh, lungh, costomq, materiale) {
        this.largh = largh;
        this.lungh = lungh;
        this.costomq = costomq;
        this.materiale = materiale.trim().toUpperCase();
    }

    calcolaTot() {
        let totale = 0;

        totale = this.largh * this.lungh * this.costomq;

        return totale;
    }

    prezzoFinale() {
        let res = "";

        /* Legno pino:
         dimensioni 4 X 5 
         Costo al mq 30 euro
         Costo totale: 600 euro
         */
        res += "Pavimento di " + this.materiale + ": <br />";
        res += "dimensioni mt. " + this.largh.toFixed(2) + " x mt. " + this.lungh.toFixed(2) + "<br />";
        res += "costo mq/€ " + this.costomq.toFixed(2) + "<br />";
        res += "costo totale € " + this.calcolaTot().toFixed(2);

        return res;
    }

    rigaPavimento() {
        let res = "";

        // Legno pino – 4X5 – costo 600 euro
        res += this.materiale + " - mq (" + this.largh.toFixed(2) + " x  "
                + this.lungh.toFixed(2) + ") - costo € " + this.calcolaTot().toFixed(2);

        return res;
    }
}

class Preventivo {
    constructor(cliente) {
        this.cliente = cliente;
        this.pavimenti = [];
    }

    vediPreventivo() {
        let res = "";

        res += "Preventivo: " + this.cliente;
        res += this.vediPavimenti();

        return res;
    }

    vediPavimenti() {
        let res = "<br /> TOTALE: € " + this.getTotalePreventivo().toFixed(2);

        if (this.pavimenti.length > 0) {
            res += "<br /> preventivi:";
            res += "<br /><select id='sel_pav' size = '10' onclick='visBtnElimina();'>";

            let i = 0;

            this.pavimenti.forEach(function (unPav) {
                res += "<option value ='" + i + "'>" + unPav.rigaPavimento() + "</option>";
                i++;
            });

            res += "</select>";
        }

        return res;
    }

    getTotalePreventivo() {
        let totale = 0;

        this.pavimenti.forEach(function (unPav) {
            totale += unPav.calcolaTot();
        });

        return totale;
    }

    eliminaPavimento(pIdx) {
        this.pavimenti.splice(pIdx, 1);
    }
}