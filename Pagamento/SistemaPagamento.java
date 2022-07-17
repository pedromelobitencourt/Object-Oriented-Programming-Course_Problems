/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/

package principal;
import java.util.Scanner;
public class SistemaPagamentoTeste {
    public static void main(String[] args) {
        boolean continuar = true;
        String escolha, escolha2, escolha3;
        int diaPagamento = 0, mesPagamento = 0, opcao = 0;
        Scanner input = new Scanner(System.in);
        ControlePagamento controlePagamento = new ControlePagamento();
        
        while(continuar){
            System.out.println("Digite '1' para adicionar uma conta");
            System.out.println("Digite '2' para adicionar um empregado");
            System.out.println("Digite '3' para listar os pagamentos sem uma data especifica"); //Listar os pagamentos sem o getValorAPagar(), só com informações sobre tais pagamentos
            System.out.println("Digite '4' para listar um tipo de pagamento especifico sem uma data especifica"); //Mesma explicação acima, mas para algum tipo de pagamento (empregado, conta, assalariado...)
            System.out.println("Digite '5' para listar os pagamentos e o valor que deve pagar cada se for em uma data especifica"); //Listar os pagamentos aí, mas agora com o getValorAPagar() e as demais informações
            System.out.println("Digite '6' para calcular o quanto deverá pagar de um pagamento especifico em uma data especifica");
            System.out.println("Digite '7' para ver o total que deve pagar caso pague todos os pagamentos em uma data especifica");
            System.out.println("Digite '8' para remover um tipo de pagamento especifico");
            System.out.println("Digite '9' para remover todos os pagamentos");
            System.out.println("Digite '10' para desligar o sistema");
            escolha = input.next();
            
            switch(escolha){
                case "1" -> {
                    System.out.println("Digite '1' para adicionar um título");
                    System.out.println("Digite '2' para adicionar uma conta da concessionária");
                    escolha2 = input.next();
                    switch(escolha2){
                        case "1" -> {
                            Titulo titulo = new Titulo();
                            System.out.println("Digite o valor do titulo");
                            titulo.setValor(input.nextDouble());
                            System.out.println("Digite o dia do titulo:");
                            titulo.setDia(input.nextInt());
                            System.out.println("Digite o mes do titulo:");
                            titulo.setMes(input.nextInt());
                            controlePagamento.inserirPagavel(titulo);
                    }
                            
                        case "2" -> {
                            Concessionaria concessionaria = new Concessionaria();
                            System.out.println("Digite o valor da conta da concessionaria");
                            concessionaria.setValor(input.nextDouble());
                            System.out.println("Digite o dia da conta da concessionaria");
                            concessionaria.setDia(input.nextInt());
                            System.out.println("Digite o mes da conta da concessionaria");
                            concessionaria.setMes(input.nextInt());
                            controlePagamento.inserirPagavel(concessionaria);
                    }
                    }
                    break;
                }
                case "2" ->{
                    System.out.println("Digite '1' para adicionar um funcionario terceirizado");
                    System.out.println("Digite '2' para adicionar um funcionario comissionado");
                    System.out.println("Digite '3' para adicionar um funcionario assalariado");
                    System.out.println("Digite '4' para adicionar um funcionario assalariado/comissionado");
                    escolha2 = input.next();
                    
                    switch(escolha2){
                        case "1" -> { 
                            Terceirizado terceirizado = new Terceirizado();
                            System.out.println("Digite o nome do funcionario terceirizado");
                            terceirizado.setNome(input.next());
                            input.nextLine();
                            System.out.println("Digite o sobrenome do funcionario terceirizado");
                            terceirizado.setSobrenome(input.next());
                            System.out.println("Digite o numero de identidade do funcionario terceirizado");
                            terceirizado.setNumIdent(input.nextInt());
                            System.out.println("Digite a quantidade de horas trabalhadas do funcionario terceirizado");
                            terceirizado.setHorasTrabalhadas(input.nextDouble());
                            controlePagamento.inserirPagavel(terceirizado);
                            break;
                    }
                        case "2" ->{
                            Comissionado comissionado = new Comissionado();
                            System.out.println("Digite o nome do funcionario comissionado");
                            comissionado.setNome(input.next());
                            System.out.println("Digite o sobrenome do funcionario comissionado");
                            comissionado.setSobrenome(input.next());
                            System.out.println("Digite o numero de identidade do funcionario comissionado");
                            comissionado.setNumIdent(input.nextInt());
                            System.out.println("Digite o valor das vendas do funcionario comissionado");
                            comissionado.setValorVendas(input.nextDouble());
                            controlePagamento.inserirPagavel(comissionado);
                            break;
                        }
                        case "3" ->{
                            Assalariado assalariado = new Assalariado();
                            System.out.println("Digite o nome do funcionario assalariado");
                            assalariado.setNome(input.next());
                            System.out.println("Digite o sobrenome do funcionario assalariado");
                            assalariado.setSobrenome(input.next());
                            System.out.println("Digite o numero de identidade do funcionario assalariado");
                            assalariado.setNumIdent(input.nextInt());
                            System.out.println("Digite o numero de horas extras trabalhadas pelo funcionario assalariado");
                            assalariado.setHorasExtras(input.nextDouble());
                            controlePagamento.inserirPagavel(assalariado);
                            break;
                        }
                        case "4" ->{
                            AssalariadoComissionado assalariadoComissionado = new AssalariadoComissionado();
                            System.out.println("Digite o nome do funcionario assalariado/comissionado");
                            assalariadoComissionado.setNome(input.next());
                            System.out.println("Digite o sobrenome do funcionario assalariado/comissionado");
                            assalariadoComissionado.setSobrenome(input.next());
                            System.out.println("Digite o numero de identidade do funcionario assalariado/comissionado");
                            assalariadoComissionado.setNumIdent(input.nextInt());
                            System.out.println("Digite o valor de vendas do funcionario assalariado/comissionado");
                            assalariadoComissionado.setValorVendas(input.nextDouble());
                            System.out.println("Digite o percentual de bonus do funcionario assalariado/comissionado");
                            assalariadoComissionado.setPercentualBonus(input.nextDouble());
                            controlePagamento.inserirPagavel(assalariadoComissionado);
                            break;
                        }
                    }
                    break;
                }
                case "3"->{
                    controlePagamento.listarPagamentos();
                    break;
                }
                case "4"->{
                    System.out.println("Digite '1' para listar todos pagamentos tipo Conta");
                    System.out.println("Digite '2' para listar todos pagamentos tipo Empregado");
                    System.out.println("Digite '3' para listar algum subtipo especifico de Conta");
                    System.out.println("Digite '4' para listar algum subtipo especifico de Empregado");
                    escolha2 = input.next();
                    
                    switch(escolha2){
                        case "1" -> controlePagamento.listarPagamentosConta();
                        case "2" -> controlePagamento.listarPagamentosEmpregado();
                        case "3" -> {
                            System.out.println("Digite '1' para listar todos os titulos");
                            System.out.println("Digite '2' para listar todas contas da concessionaria");
                            escolha3 = input.next();
                            
                            switch(escolha3){
                                case "1" -> controlePagamento.listarTitulos();
                                case "2" -> controlePagamento.listarConcessionaria();
                            }
                    }
                        case "4" -> {
                            System.out.println("Digite '1' para listar os funcionarios terceirizados");
                            System.out.println("Digite '2' para listar os funcionarios comissionados");
                            System.out.println("Digite '3' para listar os funcionarios assalariados");
                            System.out.println("Digite '4' para listar os funcionarios assalariados/comissionados");
                            escolha3 = input.next();
                            
                            switch(escolha3){
                                case "1" -> controlePagamento.listarTerceirizados();
                                case "2" -> controlePagamento.listarComissionados();
                                case "3" -> controlePagamento.listarAssalariados();
                                case "4" -> controlePagamento.listarAssalariadosComissionados();
                            }
                    }
                    }
                    break;
                }
                case "5"->{
                    System.out.println("Digite o dia que deseja pagar as contas");
                    diaPagamento = input.nextInt();
                    System.out.println("Digite o mes que deseja pagar as contas");
                    mesPagamento = input.nextInt();
                    controlePagamento.listarPagamentosComData(diaPagamento, mesPagamento);
                    break;
                }
                case "6"->{
                    System.out.println("Digite '1' se quer o valor que deve pagar de todos pagamentos tipo Conta");
                    System.out.println("Digite '2' se quer o valor que deve pagar de todos pagamentos tipo Empregado");
                    System.out.println("Digite '3' se quer o valor de um pagamento tipo Conta");
                    System.out.println("Digite '4' se quer o valor um pagamento tipo Empregado");
                    escolha2 = input.next();
                    
                    switch(escolha2){
                        case "1" -> {
                            System.out.println("Digite o dia que deseja pagar as contas");
                            diaPagamento = input.nextInt();
                            System.out.println("Digite o mes que deseja pagar as contas");
                            mesPagamento = input.nextInt();
                            System.out.printf("Voce deve pagar: R$%.2f\n\n", controlePagamento.getValorAPagarContas(diaPagamento, mesPagamento));
                    }
                        case "2" -> {
                            System.out.println("Digite o dia que deseja pagar os empregados");
                            diaPagamento = input.nextInt();
                            System.out.println("Digite o mes que deseja pagar os empregados");
                            mesPagamento = input.nextInt();
                            System.out.printf("Voce deve pagar R$%.2f\n\n", controlePagamento.getValorAPagarEmpregados(diaPagamento, mesPagamento));
                    }
                        case "3" -> {
                            System.out.println("Digite '1' se quer o valor de um Titulo");
                            System.out.println("Digite '2' se quer o valor de uma conta da Concessionaria");
                            escolha3 = input.next();
                            switch(escolha3){
                                case "1" -> {
                                    System.out.println("Digite o dia que deseja pagar a conta");
                                    diaPagamento = input.nextInt();
                                    System.out.println("Digite o mes que deseja pagar a conta");
                                    mesPagamento = input.nextInt();
                                    System.out.println("Opcoes:\n");
                                    controlePagamento.listarTitulos();
                                    opcao = input.nextInt();
                                    System.out.printf("Voce deve pagar: R$%.2f\n\n", controlePagamento.ValorAPagarTitulosComData(diaPagamento, mesPagamento, opcao-1));
                            }
                                case "2" -> {
                                    System.out.println("Digite o dia que deseja pagar a conta");
                                    diaPagamento = input.nextInt();
                                    System.out.println("Digite o mes que deseja pagar a conta");
                                    mesPagamento = input.nextInt();
                                    System.out.println("Opcoes:\n\n");
                                    controlePagamento.listarConcessionaria();
                                    opcao = input.nextInt();
                                    System.out.printf("Voce deve pagar: R$%.2f\n\n", controlePagamento.ValorAPagarConcessionariasComData(diaPagamento, mesPagamento, opcao-1));
                            }
                            }
                    }
                        case "4" -> {
                            System.out.println("Digite '1' se quer o valor a pagar de um Terceirizado");
                            System.out.println("Digite '2' se quer o valor a pagar de um Comissionado");
                            System.out.println("Digite '3' se quer o valor a pagar de um Assalariado");
                            System.out.println("Digite '4' se quer o valor a pagar de um Assalariado/comissionado");
                            escolha3 = input.next();
                            
                            switch(escolha3){
                                case "1" -> {
                                    System.out.println("Digite o dia que deseja pagar a conta");
                                    diaPagamento = input.nextInt();
                                    System.out.println("Digite o mes que deseja pagar a conta");
                                    mesPagamento = input.nextInt();
                                    System.out.println("Opcoes:\n");
                                    controlePagamento.listarTerceirizados();
                                    opcao = input.nextInt();
                                    System.out.printf("Voce deve pagar: R$%.2f\n\n", controlePagamento.ValorAPagarTerceirizadosComData(diaPagamento, mesPagamento, opcao-1));
                            }
                                case "2" -> {
                                    System.out.println("Digite o dia que deseja pagar a conta");
                                    diaPagamento = input.nextInt();
                                    System.out.println("Digite o mes que deseja pagar a conta");
                                    mesPagamento = input.nextInt();
                                    System.out.println("Opcoes:\n");
                                    controlePagamento.listarComissionados();
                                    opcao = input.nextInt();
                                    System.out.printf("Voce deve pagar: R$%.2f\n\n", controlePagamento.ValorAPagarComissionadosComData(diaPagamento, mesPagamento, opcao-1));
                            }
                                case "3" -> {
                                    System.out.println("Digite o dia que deseja pagar a conta");
                                    diaPagamento = input.nextInt();
                                    System.out.println("Digite o mes que deseja pagar a conta");
                                    mesPagamento = input.nextInt();
                                    System.out.println("Opcoes:\n");
                                    controlePagamento.listarAssalariados();
                                    opcao = input.nextInt();
                                    System.out.printf("Voce deve pagar: R$%.2f\n\n", controlePagamento.ValorAPagarAssalariadosComData(diaPagamento, mesPagamento, opcao-1));
                            }
                                case "4" -> {
                                    System.out.println("Digite o dia que deseja pagar a conta");
                                    diaPagamento = input.nextInt();
                                    System.out.println("Digite o mes que deseja pagar a conta");
                                    mesPagamento = input.nextInt();
                                    System.out.println("Opcoes:\n");
                                    controlePagamento.listarAssalariadosComissionados();
                                    opcao = input.nextInt();
                                    System.out.printf("Voce deve pagar: R$%.2f\n\n", controlePagamento.ValorAPagarAssalariadosComissionadosComData(diaPagamento, mesPagamento, opcao-1));
                            }
                            }
                    }
                    }
                    break;
                }
                case "8"->{
                    System.out.println("Opcoes\n");
                    controlePagamento.listarPagamentos();
                    opcao = input.nextInt();
                    controlePagamento.removerPagamento(opcao-1);
                    System.out.println("Pagamento excluido com sucesso");
                    break;
                }
                case "10"->{
                    System.out.println("Desligando sistema...");
                    continuar = false;
                    break;
                }
                case "9" ->{
                    controlePagamento.removerTodosPagamentos();
                    System.out.println("Todos pagamentos excluidos com sucesso\n");
                    break;
                }
                case "7"->{
                    System.out.println("Digite o dia de pagamento");
                    diaPagamento = input.nextInt();
                    System.out.println("Digite o mes de pagamento");
                    mesPagamento = input.nextInt();
                    System.out.printf("Caso voce pague todos os pagamentos em %d/%d, voce pagara: R$%.2f\n\n", diaPagamento, mesPagamento, controlePagamento.valorAPagarTotal(diaPagamento, mesPagamento));
                }
            }
        }
    }
}
