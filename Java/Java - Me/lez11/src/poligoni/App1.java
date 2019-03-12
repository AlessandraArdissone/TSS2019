/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligoni;

import java.util.stream.IntStream;

/**
 *
 * @author tss
 */
public class App1 {

    public static void main(String[] args) {
        Square sq = new Square("Quadrato", 7);
        System.out.println("nome -> " + sq.nome());
        System.out.println("perimetro -> " + sq.perimetro());
        System.out.println("area -> " + sq.area());
        sq.disegna();
    }
}

abstract class FiguraGeometrica {

    public abstract String nome();

    public abstract double perimetro();

    public abstract double area();

    public abstract void disegna();

    // POSSO ANCHE DICHIARARE E DEFINIRE METODI CONCRETI, SE VOGLIO
}

class Square extends FiguraGeometrica {

    private final String nome;
    private static final int NUM_LATI = 4;
    private double lato;
    private static final String NOME = "Quadrato";
    private static final String CAR = "*";

    public Square(double lato) {
        this(NOME, lato);
    }

    public Square(String nome, double lato) {
        this.nome = nome;
        this.lato = lato;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumLati() {
        return NUM_LATI;
    }

    public double getLato() {
        return this.lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    @Override
    public String nome() {
        return String.format("nome-> %s!", nome);
    }

    @Override
    public double perimetro() {
        return NUM_LATI * this.lato;
    }

    @Override
    public double area() {
        return Math.pow(this.lato, 2);
    }

    @Override
    public void disegna() {
        printFullLine();
        printBody();
        printFullLine();
    }

    private void printFullLine() {
        IntStream.range(0, (int) this.lato).forEach(i -> System.out.print(CAR + " "));
        System.out.println();
    }

    private void printHollowLine() {
        System.out.print(CAR);
        IntStream.range(0, (int) this.lato - 2).forEach(i -> System.out.print("  "));
        System.out.print(" " + CAR);
        System.out.println();
    }

    private void printBody() {
        IntStream.range(0, (int) this.lato - 2).forEach(i -> printHollowLine());
    }
}

interface IFiguraGeometrica {

    // SOLO METODI ASTRATTI E PUBBLICI, E POSSO ANCHE SOTTINTENDERLO:
    String nome();

    abstract double perimetro();

    public double area();

    public abstract void disegna();
}

class Rectangle implements IFiguraGeometrica {

    @Override
    public String nome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double perimetro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disegna() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
