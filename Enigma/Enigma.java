/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package newpackage;

import java.util.Scanner;
import java.util.Random;

public class Enigma {
    public static void main(String[] args) {
        Random rand = new Random();
        int chaveDeslocamento = rand.nextInt(200) + 1;// Gerando chave de deslocamento entre 1 e 200 - Mais um para não ter o risco da chave de deslocamento ser zero
        int indiceFrase = rand.nextInt(3);
        String frases[] = {"programacao de computadores dois", "java eh vida", "testando"};
        //int chaveDeslocamento = 22;
        CifraDeCesar cifraDeCesar = new CifraDeCesar(chaveDeslocamento); //O deslocamento da chave vai ser 22 unidades neste caso - Pode mudar se quiser
        //String cifrada = cifraDeCesar.cifrar("programacao de computadores dois"); //Mensagem que sera cifrada
        String cifrada = cifraDeCesar.cifrar(frases[indiceFrase]);
        String decifrada = cifraDeCesar.decifrar(cifrada); //mensagem que foi cifrada decifrada - programacao de computadores dois
        boolean continuar = true;
        Scanner input = new Scanner(System.in);
        String respostaUsuario;
        
        while(continuar){
            System.out.printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\nMensagem cifrada: %s\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n", cifrada);
            System.out.printf("Sabe-se que a chave de deslocamento e: %d\n", chaveDeslocamento);
            System.out.println("Decifre a frase e digite a solução");
            System.out.println("Caso queira parar a execucao do programa, digite '0'");
            respostaUsuario = input.nextLine();
            if(respostaUsuario.length() > cifrada.length() || respostaUsuario.length() < cifrada.length()){
                System.out.printf("A frase cifrada tem apenas %d caracteres.\nTente novamente\n\n", cifrada.length());
            }
            else{
                switch(respostaUsuario){
                    case "0": //Se quiser sair do programa
                        System.out.println("Fechando o programa...");
                        System.exit(0);
                    default: //Caso queira decifrar a mensagem que foi cifrada
                        try { //Se acertar a decifragem
                            cifraDeCesar.verificarResposta(respostaUsuario, cifrada);
                            System.out.println("Parabens, voce acertou!");
                            continuar = false;
                        } catch (DecifragemInvalidaException e) { //Se errar a decifragem
                            System.err.printf("%s\n", e.getMessage());
                        }
                }
            }
        }
    }
}
