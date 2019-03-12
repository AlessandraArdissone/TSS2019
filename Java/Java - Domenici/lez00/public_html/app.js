import Dado from './Dado.js';
import Giocatore from './Giocatore.js';


//main

let giocatore = new Giocatore(10,'Pippo');
let dGiocatore = new Dado();
let dBanco = new Dado();
while(giocatore.soldi>0){
    let puntiGiocatore = dGiocatore.lancio();
    let puntiBanco = dBanco.lancio();
    if(puntiGiocatore>puntiBanco){
        giocatore.incrementa();
    }else{
        giocatore.decrementa();
    }
    stampaMano(puntiGiocatore,puntiBanco,giocatore.soldi);
}

function stampaMano(puntiGiocatore,puntiBanco,soldi){
    console.log('--------------------------------------------------------------');
    console.log(`punti giocatore -> ${puntiGiocatore} , punti banco -> ${puntiBanco}`);
    console.log(`soldi giocatore -> ${soldi}`);
}