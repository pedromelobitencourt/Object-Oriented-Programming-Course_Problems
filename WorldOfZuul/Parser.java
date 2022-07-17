/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Parser 
{

    private CommandWords commands;  // holds all valid command words
    private int indiceLinhaGameSalvo;
    private boolean jaLeuOJogoSalvo;

    public Parser() 
    {
        commands = new CommandWords();
        indiceLinhaGameSalvo = 0;
        this.jaLeuOJogoSalvo = false;
    }

    public Command getCommand() 
    {
        String inputLine = "";   // will hold the full input line
        String word1;
        String word2;

        System.out.print("> ");     // print prompt
        
        if(this.indiceLinhaGameSalvo == ManipulaArquivoTexto.getPalavrasArquivo().size()){
            this.jaLeuOJogoSalvo = true;
        }

        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            if(indiceLinhaGameSalvo < ManipulaArquivoTexto.getPalavrasArquivo().size()){
                inputLine = ManipulaArquivoTexto.getPalavrasArquivo().get(indiceLinhaGameSalvo);
                this.indiceLinhaGameSalvo++;
            }
            else{
                inputLine = reader.readLine();
            }
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        if(commands.isCommand(word1)){
            if(word2 != null && jaLeuOJogoSalvo == true){
                ManipulaArquivoTexto.addRecords(word1.concat(" ").concat(word2));
            }
            else if(word2 == null && !word1.equals("quit") && !word1.equals("go") && jaLeuOJogoSalvo == true){
                ManipulaArquivoTexto.addRecords(word1);
            }
            return new Command(word1, word2);
        }
        else{
            return new Command(null, word2);
        }
    }
}
