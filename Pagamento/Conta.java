/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public abstract class Conta extends Pagavel {
    protected int dia;
    protected int mes;
    protected double valor;

    public Conta(){
        //super(0);
        this.dia = 0;
        this.mes = 0;
        this.valor = 0.0;
    }
    
    public Conta(int dia, int mes, double valor){
        //super(valorAPagar);
        this.dia = dia;
        this.mes = mes;
        this.valor = valor;
    }
    
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public double getValor() {
        return valor;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
