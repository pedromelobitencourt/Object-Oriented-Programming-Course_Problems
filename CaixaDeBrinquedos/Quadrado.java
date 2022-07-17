/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Quadrado extends Bidimensional{
    private final double lado;
    
    /*public Quadrado(){
        this.lado = 0.0;
    }*/
    
    public Quadrado(double lado){
        this.lado = lado;
    }

    /*public void setLado(double lado) {
        this.lado = lado;
    }*/

    public double getLado() {
        return lado;
    }
    
    
    @Override
    public final double obterArea() {
        return (lado * lado);
    }
    
}
