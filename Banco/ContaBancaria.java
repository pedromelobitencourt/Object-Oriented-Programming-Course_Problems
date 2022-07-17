/*
Alunos:
    Pedro Veloso Inacio de Oliveira (20213004837)
    Pedro Vitor Melo Bitencourt (20213001540)
    Rafael Pereira Duarte (20213005146)
*/

package banco_PedroBitencourt_PedroVeloso_RafaelDuarte;

public abstract class ContaBancaria {
    protected final String nomeCompleto;
    protected final int numeroConta;
    protected double saldo;

    public ContaBancaria(){
        this.nomeCompleto = "";
        this.numeroConta = 0;
        this.saldo = 0.0;
    }
    
    public ContaBancaria(String nomeCompleto, int numeroConta, double saldo){
        this.nomeCompleto = nomeCompleto;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    
    public String getNomeCompleto(){
        return this.nomeCompleto;
    }
    public int getNumeroConta(){
        return numeroConta;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    
    @Override
    public String toString(){
        return String.format("%s: %s%n%s: %d%n%s R$%.2f",
        "Nome",nomeCompleto,
        "Numero da conta",numeroConta, "Saldo da conta", getSaldo());
    }
}
