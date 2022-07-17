/*
Alunos:
    Pedro Veloso Inácio de Oliveira (20213004837)
    Pedro Vitor Melo Bitencourt (20213001540)
    Rafael Pereira Duarte (20213005146)

Colocamos um botão "Senha" extra para facilitar a correção e ver se está tudo certo
*/
package newpackage;

import java.security.SecureRandom;

public class JogoSenha {
    private int tentativas;
    private String senha;
    
    public JogoSenha(){
        SecureRandom rand = new SecureRandom();
        char caracteres[] = {'*', '#', '@', '%', '&'};
        senha = "";
        for(int i = 0; i < 7; i++){
            senha += caracteres[rand.nextInt(caracteres.length)];
        }
        this.tentativas = 4;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
    
    public int getTentativas() {
        return tentativas;
    }

    public String getSenha() {
        return senha;
    }
    
    public boolean verificarCaracterPosicao(String caracter, int posicao){
        if(this.senha.toCharArray()[posicao] == caracter.charAt(0)){
                return true;
        }
        else{
            return false;
        }
    }
    
    public void diminuirUmaTentativa(){
        this.tentativas--;
    }
}
