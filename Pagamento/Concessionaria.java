/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Concessionaria extends Conta {

    
    public Concessionaria(int dia, int mes, double valor){
        super(dia, mes, valor);
    }
    
    public Concessionaria(){
        super(0, 0, 0.0);
    }
    
    @Override
    public double getValorAPagar(int diaPagamento, int mesPagamento) {
        return valor;
    }
    
    
    
}
