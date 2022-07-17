/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public class Titulo extends Conta {
    
    public Titulo(int dia, int mes, double valor){
        super(dia, mes, valor);
    }
    
    public Titulo(){
        super(0, 0, 0);
    }
    
    @Override
    public double getValorAPagar(int diaPagamento, int mesPagamento) {
        if(mesPagamento != 12){
            if(mesPagamento == mes){
                if(diaPagamento > dia){
                    return valor * 1.1;
                }
                else{
                    return valor;
                }
            }
            else{
                if(mesPagamento > mes){
                    return valor * 1.1;
                }
                else{
                    return valor;
                }
            }
        }
        else{
            if(diaPagamento > dia){
                return valor * 1.1;
            }
            else{
                return valor;
            }
        }
    }
    
    
}
