/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package newpackage;
public class JogoDaVelha {
    private boolean eBolinha;
    private Integer[][] posicoesMarcacoes; //Matriz 3x3, que representa o jogo da velha (sua "interface") / Onde tiver 1 é onde a bolinha ou x foi marcada(o)
    
    public JogoDaVelha(boolean eBolinha){
        this.eBolinha = eBolinha;
        this.posicoesMarcacoes = new Integer[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.posicoesMarcacoes[i][j] = 0;
            }
        }
    }
    
    public boolean verificarSeGanhou(){ //Método para ver se teve algum caso em que a "bolinha" ou o "x" ganhou
        if((posicoesMarcacoes[0][0] == 1 && posicoesMarcacoes[0][1] == 1 && posicoesMarcacoes[0][2] == 1) ||
                (posicoesMarcacoes[1][0] == 1 && posicoesMarcacoes[1][1] == 1 && posicoesMarcacoes[1][2] == 1) ||
                (posicoesMarcacoes[2][0] == 1 && posicoesMarcacoes[2][1] == 1 && posicoesMarcacoes[2][2] == 1) ||
                (posicoesMarcacoes[0][0] == 1 && posicoesMarcacoes[1][0] == 1 && posicoesMarcacoes[2][0] == 1) ||
                (posicoesMarcacoes[0][1] == 1 && posicoesMarcacoes[1][1] == 1 && posicoesMarcacoes[2][1] == 1) ||
                (posicoesMarcacoes[0][2] == 1 && posicoesMarcacoes[1][2] == 1 && posicoesMarcacoes[2][2] == 1) ||
                (posicoesMarcacoes[0][0] == 1 && posicoesMarcacoes[1][1] == 1 && posicoesMarcacoes[2][2] == 1) ||
                (posicoesMarcacoes[0][2] == 1 && posicoesMarcacoes[1][1] == 1 && posicoesMarcacoes[2][0] == 1)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void adicionarPosicao(int linha, int coluna){
        this.posicoesMarcacoes[linha][coluna] = 1;
    }
}
