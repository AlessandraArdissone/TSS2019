/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligoni;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        Quadrato q = new Quadrato(10);
        System.out.println(q);
        System.out.println(String.format("- Perimetro-> %s", q.perimetro()));
        System.out.println(String.format("- Area-> %s", q.area()));
    }
}

// CLASSE ASTRATTA!!
abstract class Poligono {

    private final int numeroLati;
    //protected final int numeroLati;

    public Poligono(int lati) {
        this.numeroLati = lati;
    }

    /* DI SOLITO NON SI FA CON LE get E LE set (QUESTO E' SOLO UN ESEMPIO),
    MA SE DEFINISCO UN METODO final (COSTANTE, INMODIFICABILE), NON NE POSSO FARE L'override NELLE CLASSI DERIVATE */
    //public final int getNumeroLati() {
    public int getNumeroLati() {
        return numeroLati;
    }

    @Override
    public String toString() {
        return String.format("numero lati-> %s", numeroLati);
    }

    // METODI ASTRATTI!!
    public abstract long perimetro();

    public abstract double area();
}

class Quadrato extends Poligono {

    private int lato;

    public Quadrato(int lato) {
        super(4);
        this.lato = lato;
    }

    @Override
    public long perimetro() {
        /* ANCHE SE LA VARIABILE numeroLati E' ERERDITATA, E' private E QUINDI NON VI POSSO ACCEDERE DIRETTAMENTE
        (PER POTERLO FARE AVREI DOVUTO DICHIARARLA protected NELLA CLASSE Poligono)
        PERO' SE LA DICHIARO protected  LA VEDO IN TUTTO IL package, ANCHE NEL main */
        return this.lato * this.getNumeroLati();
        //return this.lato * this.numeroLati;
    }

    @Override
    public double area() {
        return Math.pow(lato, 2);
    }

    @Override
    public String toString() {
        return String.format("Sono un quadrato:\n- %s\n- lato-> %s", super.toString(), this.lato);
    }

    /* DI SOLITO NON SI FA CON LE get E LE set (QUESTO E' SOLO UN ESEMPIO),
    MA SE DEFINISCO UN METODO final (COSTANTE, INMODIFICABILE), NON NE POSSO FARE L'override NELLE CLASSI DERIVATE */
/*
    @Override
    public int getNumeroLati() {
        return 25;
    }
*/
}

// LA CLASSE string E' final, DUNQUE NON SI PUO' ESTENDERE!!
// (public final class String NEL PACKAGE java.lang;)
//class newString extends String{}