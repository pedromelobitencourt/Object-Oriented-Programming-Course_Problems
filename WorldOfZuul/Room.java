/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * Class Room - a room in an adventure game.
 *
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Room 
{
    public String description;
    private ArrayList<Items> items;
    private ArrayList<Monster> monstros;
    private ArrayList<Player> jogadores;
    private HashMap<Room, String> saidas;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Room(String description) 
    {
        Random rand = new Random();
        items = new ArrayList<>();
        monstros = new ArrayList<>();
        jogadores = new ArrayList<>();
        saidas = new HashMap<>();
        int quantidadeItensSala = 9;
        int quantidadeJogadoresSala = 4;
        int quantidadeMonstrosSala = 5;
        
        for(int i = 0; i < rand.nextInt(quantidadeItensSala); i++){
            Items item = new Items();
            if(item.getNome().equals("Janela") && description.equals("outside the main entrance of the university")){
                i--;
            }
            else{
                items.add(item);
            }
        }
        
        for(int j = 0; j < rand.nextInt(quantidadeMonstrosSala); j++){
            Monster monster = new Monster();
            monstros.add(monster);
        }
        
        for(int k = 0; k < rand.nextInt(quantidadeJogadoresSala); k++){
            Player player = new Player();
            jogadores.add(player);
        }
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    
    public void adicionarSaida(Room saida, String direcao){
        this.saidas.put(saida, direcao);
    }
    
    public HashMap<Room, String> getSaidas(){
        return this.saidas;
    }
    
    /**
     * Return the description of the room (the one that was defined
     * in the constructor).
     */
    public String getDescription()
    {
        return description;
    }
    
    public ArrayList<Items> getItems(){
        return this.items;
    }
    
    public ArrayList<Monster> getMonstros(){
        return this.monstros;
    }
    
    public ArrayList<Player> getJogadores(){
        return this.jogadores;
    }
    
    public void mostrarItens(){
        ArrayList<Items> itemsSemStringsRepetidas = new ArrayList<>();
        int quantidadeApareceu = 0, quantidadeVezes = 0;
        
        for(Items a : this.items){
            for(Items b : itemsSemStringsRepetidas){
                if(a.getNome().equals(b.getNome())){
                    quantidadeVezes++;
                }
            }
            if(quantidadeVezes == 0){
                itemsSemStringsRepetidas.add(a);
            }
            quantidadeVezes = 0;
        }
        
        /*for(Items c : itemsSemStringsRepetidas){
            System.out.printf("%s\n\n", c.getNome());
        }*/
        
        for(Items a : itemsSemStringsRepetidas){
            for(Items b : items){
                if(b.getNome().equals(a.getNome())){
                    quantidadeApareceu++;
                }
            }
            if(quantidadeApareceu == 1){
                System.out.printf("%s: Ha 1 unidade\n", a.getNome());
            }
            else if(quantidadeApareceu > 1){
                System.out.printf("%s: Ha %d unidades\n", a.getNome(), quantidadeApareceu);
            }
            quantidadeApareceu = 0;
        }
    }
    
    public void mostrarMonstros(){
        int quantidadeMonstros = 0;
        for(Monster a : monstros){
            System.out.printf("Monstro %d - ", quantidadeMonstros+1);
            System.out.printf("Ele possui %.2f de forca e %.2f de vida\n", a.getForca(), a.getVida());
            quantidadeMonstros++;
        }
        System.out.println("");
    }
    
    public void mostrarJogadoresSala(){
        for(Player b : jogadores){
            System.out.printf("Nome: %s; Altura: %.2f; Idade: %d; Possui alguma arma: ", b.getNome(), b.getAltura(), b.getIdade());
            if(b.isPossuiArmas()){
                System.out.println("Sim");
            }
            else{
                System.out.println("Nao");
            }
        }
        System.out.println("");
    }
    
    public void addItem(Items item){
        this.items.add(item);
    }
}
