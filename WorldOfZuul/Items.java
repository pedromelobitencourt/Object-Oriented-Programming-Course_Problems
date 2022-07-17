/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;

import java.util.Random;
import java.util.ArrayList;

public class Items {
    private final String nome;
    
    public Items(){
        Random rand = new Random();
        ArrayList<String> nomes = new ArrayList();
        nomes.add("Carne");
        nomes.add("Biscoito");
        nomes.add("Manga");
        nomes.add("Agua");
        nomes.add("Leite");
        nomes.add("Katana");
        nomes.add("Adaga");
        nomes.add("Revolver");
        nomes.add("Arco");
        nomes.add("Pacote de municao");
        nomes.add("Flecha");
        nomes.add("Moeda");
        nomes.add("Remedio");
        nomes.add("Corda");
        nomes.add("Mochila");
        nomes.add("Janela");
        nomes.add("Mesa");
        nomes.add("Caderno");
        nomes.add("Computador");
        //{"Carne", "Biscoito", "Manga", "Agua", "Leite", "Katana", "Adaga", "Revolver", "Arco", "Flechas", "Moedas", "Remedio"
        
        this.nome = nomes.get(rand.nextInt(nomes.size()));
    }
    
    public Items(String nome){
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
}
