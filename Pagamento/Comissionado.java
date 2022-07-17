/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Comissionado extends Empregado {
    private double valorVendas;

    public Comissionado(){
        super("", "", 0);
        this.valorVendas = 0.0;
    }
    
    public Comissionado(String nome, String sobrenome, int numIdent, double valorVendas){
        super(nome, sobrenome, numIdent);
        this.valorVendas = valorVendas;
    }
    
    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }
    
    
    @Override
    public double getValorAPagar(int diaPagamento, int mesPagamento){
        return (this.valorVendas * 0.06);
    }
}
