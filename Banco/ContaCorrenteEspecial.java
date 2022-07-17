/*
Alunos:
    Pedro Veloso Inacio de Oliveira (20213004837)
    Pedro Vitor Melo Bitencourt (20213001540)
    Rafael Pereira Duarte (20213005146)
*/

package banco_PedroBitencourt_PedroVeloso_RafaelDuarte;

public class ContaCorrenteEspecial extends ContaBancaria{ //ContaCorrenteEspecial representa os cheques especiais que as ContasCorrentes possuem
    private static final double limiteCreditoEspecial = 6000.00;

    public ContaCorrenteEspecial(){
        super("", 0, 0.0);
        //this.limiteCreditoEspecial = 0.0;
    }

    public ContaCorrenteEspecial(String nomeCompleto, int numeroConta, double saldo){
        super(nomeCompleto, numeroConta, saldo);
        //this.limiteCreditoEspecial = limiteCreditoEspecial;
    }

    public double getLimiteCreditoEspecial() {
        return limiteCreditoEspecial;
    }
    
    @Override
    public double getSaldo(){
        return super.saldo + this.getLimiteCreditoEspecial();
    }
    
    @Override
    public void setSaldo(double saldo){
        this.saldo = saldo - this.getLimiteCreditoEspecial();
    }
    
}
