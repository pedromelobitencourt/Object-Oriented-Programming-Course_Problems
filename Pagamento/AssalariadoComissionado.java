/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class AssalariadoComissionado extends Comissionado{
    private double percentualBonus;
    
    public AssalariadoComissionado(String nome, String sobrenome, int numIdent, double valorVendas, double percentualBonus){
        super(nome, sobrenome, numIdent, valorVendas);
        this.percentualBonus = percentualBonus;
    }
    
    
    public AssalariadoComissionado(){
        super("", "", 0, 0);
        this.percentualBonus = 0.0;
    }
    
    public double getPercentualBonus() {
        return percentualBonus;
    }

    public void setPercentualBonus(double percentualBonus) {
        this.percentualBonus = percentualBonus;
    }
    
    
    
    @Override
    public double getValorAPagar(int diaPagamento, int mesPagamento){
        return (ControlePagamento.SALARIO *(1 + (this.percentualBonus/100)) + (getValorVendas() * 0.06));
    }
}
