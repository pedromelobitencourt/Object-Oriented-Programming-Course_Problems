/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package newpackage;
public class Chave {
    private int deslocamento;
    private final String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    
    public Chave(){
        this.deslocamento = 0;
    }
    
    public Chave(int deslocamento){
        this.deslocamento = deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public int getDeslocamento() {
        return this.deslocamento;
    }

    public String[] getAlfabeto() {
        return alfabeto;
    }
    
    
}
