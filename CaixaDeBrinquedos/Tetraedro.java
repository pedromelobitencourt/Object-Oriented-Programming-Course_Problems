/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Tetraedro extends Tridimensional{
    private final double aresta;
    
    /*public Tetraedro(){
        this.aresta = 0.0;
    }*/
    
    public Tetraedro(double aresta){
        this.aresta = aresta;
    }

    /*public void setAresta(double aresta) {
        this.aresta = aresta;
    }*/

    public double getAresta() {
        return aresta;
    }
    
    @Override
    public final double obterVolume() {
        return (Math.pow(aresta, 3) * Math.sqrt(2)/12);
    }

    @Override
    public final double obterArea() {
        return (Math.pow(aresta, 2) * Math.sqrt(3));
    }
    
}
