/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Triangulo extends Bidimensional{
    private final double base;
    private final double altura;
    
    /*public Triangulo(){
        this.base = 0.0;
        this.altura = 0.0;
    }*/
    
    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    /*public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }*/

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
    
    
    @Override
    public final double obterArea() {
        return (base * altura)/2;
    }
    
    
    //
}
