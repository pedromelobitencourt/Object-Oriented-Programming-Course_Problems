/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Esfera extends Tridimensional{
    private final double raio;
    
    /*public Esfera(){
        this.raio = 0.0;
    }*/
    
    public Esfera(double raio){
        this.raio = raio;
    }

    /*public void setRaio(double raio) {
        this.raio = raio;
    }*/

    public double getRaio() {
        return raio;
    }
    
    @Override
    public final double obterVolume() {
        return (4 * Math.pow(raio, 3) * Math.PI/3);
    }

    @Override
    public final double obterArea(){
        return (4 * Math.pow(raio, 2) * Math.PI);
    }
}
