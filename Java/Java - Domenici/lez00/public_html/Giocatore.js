export default class Giocatore{
       
       constructor(soldi,nome){ 
           if(soldi < 0){
               throw "soldi negativi non validi";
           }
           this._soldi = soldi;
           this.nome = nome;
       } 
       
       incrementa(){
           this.soldi++;
       }
       
       decrementa(){
           this.soldi--;
       }
       
       get soldi(){
           return this._soldi;
       }
       
       set soldi(valore){
           if(valore < 0){
               throw "soldi negativi non validi";
           }
           this._soldi= valore;
       }
}


