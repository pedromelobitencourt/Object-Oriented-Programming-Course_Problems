/*
Alunos:
    Pedro Veloso Inacio de Oliveira (20213004837)
    Pedro Vitor Melo Bitencourt (20213001540)
    Rafael Pereira Duarte (20213005146)
*/

package banco_PedroBitencourt_PedroVeloso_RafaelDuarte;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        boolean continuar = true;
        String escolha1, escolha2;
        Banco banco = new Banco();
        Scanner input = new Scanner(System.in);
        String nomeCompleto;
        int numeroConta = 0, dias = 0;
        double quantidadeDinheiro = 0.0;
        
        while(continuar){
            System.out.println("Digite '1' para criar uma conta");
            System.out.println("Digite '2' para ver seu saldo em todas as suas contas");
            System.out.println("Digite '3' para ver seu saldo em uma conta especifica");
            System.out.println("Digite '4' para sacar dinheiro em uma conta");
            System.out.println("Digite '5' para depositar dinheiro em uma conta");
            System.out.println("Digite '6' para contabilizar o saldo total de todos os clientes do banco");
            System.out.println("Digite '7' para contabilizar o saldo da poupanca apos alguns dias");
            System.out.println("Digite '8' para contabilizar o rendimento da poupanca apos alguns dias");
            System.out.println("Digite '9' para remover uma conta do banco");
            System.out.println("Digite '10' para listar todas as contas do banco");
            System.out.println("Digite '11' para desligar o sistema");
            escolha1 = input.next();
            input.nextLine();
            
            switch(escolha1){
                case "1":
                    System.out.println("Digite '1' se a conta sera uma Conta Poupanca");
                    System.out.println("Digite '2' se a conta sera uma Conta Corrente Simples");
                    System.out.println("Digite '3' se a conta sera uma Conta Corrente Especial");
                    escolha2 = input.next();
                    input.nextLine();
                    
                    switch(escolha2){
                        case "1":              
                            System.out.println("Digite o seu nome completo");
                            nomeCompleto = input.nextLine();
                            System.out.println("Digite o numero da conta");
                            numeroConta = input.nextInt();
                            ContaPoupanca contaPoupanca = new ContaPoupanca(nomeCompleto, numeroConta, 0.0);
                            banco.adicionarConta(contaPoupanca);
                            System.out.println("Conta adicionada com sucesso!");
                            break;
                            
                        case "2":
                            System.out.println("Digite o seu nome completo");
                            nomeCompleto = input.nextLine();
                            System.out.println("Digite o numero conta");
                            numeroConta = input.nextInt();
                            ContaCorrenteSimples contaCorrenteSimples = new ContaCorrenteSimples(nomeCompleto, numeroConta, 0.0);
                            banco.adicionarConta(contaCorrenteSimples);
                            System.out.println("Conta adicionada com sucesso!");
                            break;
                            
                        case "3":
                            System.out.println("Digite o seu nome completo");
                            nomeCompleto = input.nextLine();
                            System.out.println("Digite o numero conta");
                            numeroConta = input.nextInt();
                            ContaCorrenteEspecial contaCorrenteEspecial = new ContaCorrenteEspecial(nomeCompleto, numeroConta, 0.0);
                            banco.adicionarConta(contaCorrenteEspecial);
                            System.out.println("Conta adicionada com sucesso!");
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Digite seu nome completo");
                    nomeCompleto = input.nextLine();
                    if(banco.contabilizarSaldoTotalPessoa(nomeCompleto) == -1){
                        System.out.println("Voce nao possui uma conta no banco\n");
                    }
                    else{
                        System.out.printf("Voce possui R$%.2f, somando todos os saldos de suas contas\n\n", banco.contabilizarSaldoTotalPessoa(nomeCompleto));
                    }
                    break;
                case "3":
                    System.out.println("Digite o numero da conta");
                    numeroConta = input.nextInt();
                    if(banco.verificarSaldo(numeroConta) == -1){
                        System.out.println("Voce nao possui uma conta no banco\n");
                    }
                    else{
                        System.out.printf("O saldo da conta %d e: R$%.2f\n\n", numeroConta, banco.verificarSaldo(numeroConta));
                    }
                    break;
                case "4":
                    System.out.println("Digite o numero da conta");
                    numeroConta = input.nextInt();
                    System.out.println("Digite a quantidade de dinheiro que voce quer sacar");
                    quantidadeDinheiro = input.nextDouble();
                    banco.sacarDinheiro(numeroConta, quantidadeDinheiro);
                    System.out.println("Dinheiro sacado com sucesso!");
                    break;
                case "5":
                    System.out.println("Digite o numero da conta");
                    numeroConta = input.nextInt();
                    System.out.println("Digite a quantidade de dinheiro que voce vai depositar");
                    quantidadeDinheiro = input.nextDouble();
                    if(banco.depositarDinheiro(numeroConta, quantidadeDinheiro) == 1){
                        System.out.println("Dinheiro depositado com sucesso!\n");
                    }
                    else{
                        System.out.println("Nao foi possivel depositar nessa conta, pois ela nao existe\n");
                    }
                    break;
                case "6":
                    System.out.printf("Somando o saldo de todos os clientes do banco, ha: R$%.2f\n\n", banco.contabilizarSaldoTotal());
                    break;
                case "7":
                    System.out.println("Digite o numero da conta");
                    numeroConta = input.nextInt();
                    System.out.println("Digite a quantidade de dias");
                    dias = input.nextInt();
                    if(banco.saldoPoupancaAposDias(numeroConta, dias) == -1){
                        System.out.println("Nao ha uma Conta Poupanca com esse numero em nosso banco");
                        break;
                    }
                    else{
                        System.out.printf("O saldo da conta %d apos %d dias sera: R$%.2f\n\n", numeroConta, dias, banco.saldoPoupancaAposDias(numeroConta, dias));
                        break;
                    }
                case "8":
                    System.out.println("Digite o numero da conta");
                    numeroConta = input.nextInt();
                    System.out.println("Digite o numero de dias");
                    dias = input.nextInt();
                    if(banco.rendimentoPoupancaAposDias(numeroConta, dias) == -1){
                        System.out.println("Nao ha uma Conta Poupanca com esse numero em nosso banco");
                        break;
                    }
                    else{
                        System.out.printf("O rendimento da conta %d apos %d dias sera de: R$%.2f\n\n", numeroConta, dias, banco.rendimentoPoupancaAposDias(numeroConta, dias));
                        break;
                    }
                case "9":
                    System.out.println("Digite o numero da conta");
                    numeroConta = input.nextInt();
                    if(banco.removerConta(numeroConta) == 0){
                        System.out.println("Nao foi possivel remover a conta, pois ela nao existe em nosso banco\n");
                    }
                    else{
                        System.out.println("Conta removida com sucesso!\n");
                    }
                    break;
                case "11":
                    System.out.println("Desligando sistema...");
                    continuar = false;
                    break;
                case "10":
                    banco.listarContas();
                    break;
            }
            
        }
    }
}

