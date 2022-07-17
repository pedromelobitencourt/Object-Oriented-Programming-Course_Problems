/* GRUPO:
    Pedro Veloso Inácio de Oliveira - 20213004837
    Pedro Vitor Melo Bitencourt - 20213001540
    Rafael Pereira Duarte - 20213005146
*/

package principal_Cefetairbnb_PedroVeloso_PedroVitor_RafaelPereira;

import java.util.Scanner;

public class Main {
	
 public static void main(String[] args) {
	String cliente, nome_imovel, nome_proprietario, localizacao;
        int escolha = 0, quantidade_quartos = 0, opcao_hospedagem = 0, escolha_proprietario = 0;
        Imovel imovel;
        Hospedagem quartos[];
        Empresa CEFETairbnb = new Empresa();
        Scanner input = new Scanner(System.in);
        
        
     OUTER:
     while (true) {
         System.out.println("Digite '1' para cadastrar um imovel");
         System.out.println("Digite '2' para realizar uma hospedagem");
         System.out.println("Digite '3' para visualizar todas as hospedagens disponíveis");
         System.out.println("Digite '4' para visualizar todas as hospedagens");
         System.out.println("Digite '5' para obter o faturamento do CEFET airbnb");
         System.out.println("Digite '6' para mostrar os proprietários parceiros");
         System.out.println("Digite '7' para obter o faturamento dos proprietários parceiros");
         System.out.println("Digite '8' para obter o faturamento de todos os proprietários parceiros");
         System.out.println("Digite '9' para fechar o programa");
         escolha = input.nextInt();
         input.nextLine();
         switch (escolha) {
             case 1:
                 System.out.println("Digite o nome do imóvel:");
                 nome_imovel = input.nextLine();
                 System.out.println("Digite a localização do imóvel (cidade / Estado):");
                 localizacao = input.nextLine();
                 System.out.println("Digite o nome do proprietário do imóvel:");
                 nome_proprietario = input.nextLine();
                 System.out.println("Digite a quantidade de quartos que o imóvel vai disponibilizar para hospedagem:");
                 quantidade_quartos = input.nextInt();
                 quartos = new Hospedagem[quantidade_quartos];
                 for(int i = 0; i < quantidade_quartos; i++){
                     quartos[i] = new Hospedagem();
                     System.out.printf("Digite o preço da diária do quarto %d:\n", i+1);
                     quartos[i].setPreco(input.nextDouble());
                     System.out.printf("Digite quantas camas possui o quarto %d:\n", i+1);
                     quartos[i].setQntd_camas(input.nextInt());
                 }imovel = new Imovel(quartos, nome_proprietario, localizacao, nome_imovel);
                 CEFETairbnb.cadastrarImovel(imovel);
                 break;
             case 3:
                 CEFETairbnb.mostrarHospedagensDisponiveis();
                 break;
             case 2:
                 CEFETairbnb.mostrarHospedagensDisponiveis();
                 System.out.println("Qual o nome do cliente?");
                 cliente = input.nextLine();
                 System.out.println("Qual dessas opções o cliente gostaria de se hospedar?");
                 opcao_hospedagem = input.nextInt();
                 CEFETairbnb.cadastrarHospedagem(opcao_hospedagem - 1, cliente);
                 break;
             case 4:
                 CEFETairbnb.mostrarTodasHospedagens();
                 break;
             case 5:
                 System.out.printf("O faturamento atual do CEFET Airbnb é: %.2f", CEFETairbnb.getFaturamento_administracao());
                 break;
             case 6:
                 CEFETairbnb.mostrarProprietariosImoveis();
                 break;
             case 9:
                 System.out.println("Finalizando programa...");
                 break OUTER;
             case 7:
                 CEFETairbnb.mostrarProprietariosImoveis();
                 System.out.println("Qual dessas opções vocês gostaria de ver o faturamento?");
                 escolha_proprietario = input.nextInt();
                 System.out.printf("O faturamento é: %.2f\n", CEFETairbnb.mostrarFaturamentoProprietario(escolha_proprietario-1));
                 ;
                 break;
             case 8:
                 CEFETairbnb.mostrarFaturamentoTodosProprietarios();
                 break;
             default:
                 break;
         }
     }
}
}
