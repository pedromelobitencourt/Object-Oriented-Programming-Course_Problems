/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;

public class TesteJogo {
    
	public static void main(String[] args){
                ManipulaArquivoTexto.openFile();
		Game game = new Game();
		game.play();
                ManipulaArquivoTexto.closeFile();
                
	}

}
