/*
Alunos:
    Pedro Veloso Inacio de Oliveira (20213004837)
    Pedro Vitor Melo Bitencourt (20213001540)
    Rafael Pereira Duarte (20213005146)
*/

package banco_PedroBitencourt_PedroVeloso_RafaelDuarte;

import java.util.ArrayList;

public class Banco {
    private ArrayList <ContaBancaria> contas;
    private static final double RENDIMENTO_DIA_POUPANCA = 0.001; //rendimento diário da poupança
    //private static final double LIMITE_CREDITO_ESPECIAL = 6000.00;

    public Banco(){
        this.contas = new <ContaBancaria> ArrayList();
    }

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
    }
    
    public double contabilizarSaldoTotalPessoa(String nomeCompleto){ //Retorna o saldo total de todas as contas de uma pessoa
        double saldoTotal = 0.0;
        if(this.contas.size() > 0){
            for(ContaBancaria a : contas){
                if(a.getNomeCompleto().equals(nomeCompleto)){
                    if(a instanceof ContaPoupanca || a instanceof ContaCorrenteSimples){
                        saldoTotal += a.getSaldo();
                    }
                    else{
                        ContaCorrenteEspecial b = (ContaCorrenteEspecial) a;
                        saldoTotal += b.getSaldo();
                        //saldoTotal += b.getLimiteCreditoEspecial(); //Se nao tivessemos feito o metodo sobrescrito em ContaCorrenteEspecial, fariamos desse jeito, usando downcasting
                    }
                }
                else{
                    return -1;
                } 
           }
        }
        else{
            return -1;
        }
        return saldoTotal;
    }
    
    
    public int sacarDinheiro(int numeroDaConta, double quantidade){
        for(ContaBancaria a : this.contas){
            if(a.getNumeroConta() == numeroDaConta){
                if(a instanceof ContaPoupanca || a instanceof ContaCorrenteSimples){
                    if(quantidade <= a.getSaldo()){
                        a.setSaldo(a.getSaldo() - quantidade);
                        return 1;
                    }
                    else{
                        System.out.printf("Voce nao tem tal quantidade para sacar. Voce pode sacar ate R$%.2f\n\n", a.getSaldo());
                        return 1;
                    }
                }
                else if(a instanceof ContaCorrenteEspecial){
                    ContaCorrenteEspecial b = (ContaCorrenteEspecial) a;
                    if(quantidade <= b.getSaldo()){
                        b.setSaldo(b.getSaldo() - quantidade);
                        return 1;
                    }      
                    else{
                        System.out.printf("Voce nao tem tal quantidade para sacar. Voce pode sacar ate R$%.2f\n\n", b.getSaldo());
                        return 1;
                    }
                }
            }
        }
        System.out.println("Nao foi possivel sacar, pois nao foi encontrada tal conta\n");
        return 0;
    }
    
    public int depositarDinheiro(int numeroDaConta, double quantidade){
        for(ContaBancaria a : this.contas){
            if(a.getNumeroConta() == numeroDaConta){
                a.setSaldo(a.getSaldo() + quantidade);
                return 1;
            }
        }
        return 0;
    }
    
    public double saldoPoupancaAposDias(int numeroDaConta, int dias){
        for(ContaBancaria a : this.contas){
            if(a instanceof ContaPoupanca){
                if(a.getNumeroConta() == numeroDaConta){
                    return (a.getSaldo() * (1 + RENDIMENTO_DIA_POUPANCA * dias));
                }
            }
        }
        return -1;
    }
    
    public double rendimentoPoupancaAposDias(int numeroDaConta, int dias){
        for(ContaBancaria a : this.contas){
            if(a instanceof ContaPoupanca){
                if(a.getNumeroConta() == numeroDaConta){
                    return (a.getSaldo() * RENDIMENTO_DIA_POUPANCA * dias);
                }
            }
        }
        return -1;
    }
    
    public void adicionarConta(ContaBancaria conta){
        this.contas.add(conta);
    }
    
    public int removerConta(int numeroDaConta){
        int posicao = -1;
        for(ContaBancaria a : this.contas){
            if(a.getNumeroConta() == numeroDaConta){
                posicao = this.contas.indexOf(a);
            }
        }
        if(posicao > -1){
            this.contas.remove(posicao);
            return 1;
        }
        else{
            return 0;
        }
        
    }
    
    public double verificarSaldo(int conta){
        for(ContaBancaria a : contas){
            if(a.getNumeroConta() == conta){
                if(a instanceof ContaPoupanca || a instanceof ContaCorrenteSimples){
                    return a.getSaldo();
                }
                else{
                    ContaCorrenteEspecial b = (ContaCorrenteEspecial) a;
                    return (b.getSaldo()); //Se nao tivessemos feito o metodo sobrescrito em ContaCorrenteEspecial, fariamos usando downcasting e somando com o b.getLimiteCreditoEspecial()
                }
            }
        } 
        return -1;
    }
    
    public double contabilizarSaldoTotal(){
        double saldoTotal = 0.0;
        for(ContaBancaria a : this.contas){
            if(a instanceof ContaPoupanca || a instanceof ContaCorrenteSimples){
                saldoTotal += a.getSaldo();
            }
            else{
                ContaCorrenteEspecial b = (ContaCorrenteEspecial) a;
                saldoTotal += b.getSaldo();
                //saldoTotal += b.getLimiteCreditoEspecial();//Se nao tivessemos feito o metodo sobrescrito em ContaCorrenteEspecial, fariamos desse jeito, usando downcasting
            }
        }
        return saldoTotal;
    }
    
    public void listarContas(){
        for(ContaBancaria a : this.contas){
            System.out.printf("%s\n\n", a.toString());
        }
    }
}
