/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private final int idade;
    private final double altura;
    private final boolean possuiArmas;
    private final String nome;

    public Player(){
        boolean possuiAlgumaArma[] = {true, false};
        List<Integer> idades = new ArrayList<Integer>();
        idades.add(16);
        idades.add(25);
        idades.add(38);
        idades.add(42);
        idades.add(55);
        
        List<Double> alturas = new ArrayList<Double>();
        alturas.add(1.55);
        alturas.add(1.6);
        alturas.add(1.72);
        alturas.add(1.78);
        alturas.add(1.85);
        alturas.add(1.92);
        
        ArrayList<String> nomes = new ArrayList();
        nomes.add("Anna");
        nomes.add("Caio");
        nomes.add("Maria");
        nomes.add("Pedro");
        nomes.add("Amanda");
        nomes.add("Rafael");
        nomes.add("Luciana");
        nomes.add("Joao");
        nomes.add("Fernanda");
        Random rand = new Random();
        
        this.idade = idades.get(rand.nextInt(idades.size()));
        this.altura = alturas.get(rand.nextInt(alturas.size()));
        this.possuiArmas = possuiAlgumaArma[rand.nextInt(2)];
        this.nome = nomes.get(rand.nextInt(nomes.size()));
    }
    
    
    public String getNome(){
        return this.nome;
    }
    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public boolean isPossuiArmas() {
        return possuiArmas;
    }
    
}
