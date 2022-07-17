/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;

import java.util.Scanner;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Game 
{
    private Parser parser;
    private Room currentRoom;
    private int indiceLinhaGameSalvo;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        this.indiceLinhaGameSalvo = 0;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office, porao, sotao;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        porao = new Room("in the basement");
        sotao = new Room("in the attic");
        
        // initialise room exits
        outside.adicionarSaida(theatre, "east");
        outside.adicionarSaida(lab, "south");
        outside.adicionarSaida(pub, "west");
        
        theatre.adicionarSaida(outside, "west");
        
        pub.adicionarSaida(outside, "east");
        
        lab.adicionarSaida(outside, "north");
        lab.adicionarSaida(office, "east");
        
        office.adicionarSaida(lab, "west");
        office.adicionarSaida(sotao, "up");
        office.adicionarSaida(porao, "down");
        
        porao.adicionarSaida(office, "up");
        
        sotao.adicionarSaida(office, "down");

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {
        ManipulaArquivoTexto.readRecords();
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished){
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        if(ManipulaArquivoTexto.getPalavrasArquivo().size() >= 0){
            System.out.println();
            System.out.println("Welcome to Adventure!");
            System.out.println("Adventure is a new, incredibly boring adventure game.");
            System.out.println("Type 'help' if you need help.");
            System.out.println();
            System.out.println("You are " + currentRoom.getDescription());
            System.out.println("");
            currentRoom.mostrarItens();
            System.out.println("");
            System.out.println("Exits: ");
            for(String saida : currentRoom.getSaidas().values()){
                System.out.printf("%s ", saida);
            }
            System.out.println("");
        }
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        String commandWord = command.getCommandWord();
        //String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);
        else if (commandWord.equals("comer")){
            System.out.println("Voce comeu e agora nao esta mais com fome");
        }
        else if(commandWord.equals("procurar")){
            printProcurar();
            printHelp();
        }
        else if(commandWord.equals("adicionar")){
            Scanner input = new Scanner(System.in);
            String itemDoPlayer = "";
            System.out.println("Digite um item para adicionar a sala:");
            Items itemPlayer = new Items(input.nextLine());
            currentRoom.addItem(itemPlayer);
            System.out.println("O item foi adicionado com sucesso");
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        
        for(int i = 0; i < CommandWords.getValidCommands().length; i++){
            System.out.printf(" %s", CommandWords.getValidCommands()[i]);
        }
        System.out.println("");
//        /System.out.println("   go quit help comer procurar");
    }
    
    private void printProcurar(){
        if(currentRoom.getItems().size() > 0){
            System.out.println("Itens:");
            currentRoom.mostrarItens();
        }
        else{
            System.out.println("> Nao ha nenhum item nesta sala");
        }
        
        if(currentRoom.getMonstros().size() > 0){
            System.out.println("\n> Monstros:");
            currentRoom.mostrarMonstros();
        }
        else{
            System.out.println("\n> Nao ha nenhum monstro aqui");
        }
        
        if(currentRoom.getJogadores().size() > 0){
            System.out.println("\n> Jogadores:");
            currentRoom.mostrarJogadoresSala();
        }
        else{
            System.out.println("\n> Nao ha nenhum jogador nesta sala");
        }
        System.out.print("Exits: ");
        System.out.println("");
        for(String saida : currentRoom.getSaidas().values()){
            System.out.printf("%s ", saida);
        }
        System.out.println("");
        System.out.println();
    }
    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        int controle = 0, controle2 = 0;
        for(String a : currentRoom.getSaidas().values()){
            if(a.equals(direction)){
                for(Room b : currentRoom.getSaidas().keySet()){
                    if(controle2 == controle){
                        nextRoom = b;
                    }
                    controle2++;
                }
            }
            controle++;
        }

        if (nextRoom == null)
            System.out.println("There is no door!");
        else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.println("");
            currentRoom.mostrarItens();
            System.out.println("");
            System.out.println("Exits: ");
            for(String saida : currentRoom.getSaidas().values()){
                System.out.printf("%s ", saida);
            }
            System.out.println("");
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game. Return true, if this command
     * quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else{
            ManipulaArquivoTexto.closeFile();
            return true;
        }// signal that we want to quit
    }
}
