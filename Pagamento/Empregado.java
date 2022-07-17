/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;
public abstract class Empregado extends Pagavel {
    protected String nome;
    protected String sobrenome;
    protected int numIdent;


    public Empregado(){
        //super(0);
        this.nome = "";
        this.sobrenome = "";
        this.numIdent = 0;
    }
    
    public Empregado(String nome, String sobrenome, int numIdent){
        //super(valorAPagar);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numIdent = numIdent;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getNumIdent() {
        return numIdent;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNumIdent(int numIdent) {
        this.numIdent = numIdent;
    }
    
    
}
