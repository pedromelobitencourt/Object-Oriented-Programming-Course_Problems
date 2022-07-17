/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Assalariado extends Empregado{
    private double horasExtras;
    
    public Assalariado(){
        super("", "", 0);
        this.horasExtras = 0.0;
    }
    
    public Assalariado(String nome, String sobrenome, int numIdent, double horasExtras){
        super(nome, sobrenome, numIdent);
        this.horasExtras = horasExtras;
    }
    
    public void setHorasExtras(double horasExtras){
        this.horasExtras = horasExtras;
    }
    
    public double getHorasExtras(){
        return this.horasExtras;
    }
    
    @Override
    public double getValorAPagar(int diaPagamento, int mesPagamento){
        return (ControlePagamento.SALARIO + (this.horasExtras * ControlePagamento.HORA));
    }
    
}
