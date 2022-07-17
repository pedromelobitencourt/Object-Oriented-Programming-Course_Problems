/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Cubo extends Tridimensional{
    private final double lado;
    
    /*public Cubo(){
        this.lado = 0.0;
    }*/
    
    public Cubo(double lado){
        this.lado = lado;
    }

    /*public void setLado(double lado) {
        this.lado = lado;
    }*/

    public double getLado() {
        return lado;
    }
    
    @Override
    public final double obterVolume() {
        return (Math.pow(lado, 3));
    }

    @Override
    public final double obterArea(){
        return (Math.pow(lado, 2) * 6);
    }
    
}
