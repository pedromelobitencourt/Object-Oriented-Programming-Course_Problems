/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/

package principal;
public class Terceirizado extends Empregado{
    private double horasTrabalhadas;
    
    public Terceirizado(String nome, String sobrenome, int numIdent, double horasTrabalhadas){
        super(nome, sobrenome, numIdent);
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    public Terceirizado(){
        super("", "", 0);
        this.horasTrabalhadas = 0.0;
    }
    
    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    
    @Override
    public double getValorAPagar(int diaPagamento, int mesPagamento){
        return (ControlePagamento.HORA * this.horasTrabalhadas);
    }
}
