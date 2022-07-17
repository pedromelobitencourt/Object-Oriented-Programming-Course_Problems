/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Circulo extends Bidimensional{
    private final double raio;
    
    /*public Circulo(){
        this.raio = 0.0;
    }*/
    
    public Circulo(double raio){
        this.raio = raio;
    }

    /*public void setRaio(double raio) {
        this.raio = raio;
    }*/

    public double getRaio() {
        return raio;
    }
    
    @Override
    public final double obterArea() {
        return (Math.PI * raio * raio);
    }
}
