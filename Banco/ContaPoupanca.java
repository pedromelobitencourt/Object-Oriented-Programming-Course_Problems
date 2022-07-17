/*
Alunos:
    Pedro Veloso Inacio de Oliveira (20213004837)
    Pedro Vitor Melo Bitencourt (20213001540)
    Rafael Pereira Duarte (20213005146)
*/

package banco_PedroBitencourt_PedroVeloso_RafaelDuarte;

public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(){
        super("", 0, 0.0);
    }

    public ContaPoupanca(String nomeCompleto, int numeroConta, double saldo){
        super(nomeCompleto, numeroConta, saldo);

    }
}
