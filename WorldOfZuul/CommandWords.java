/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;

/*
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class CommandWords
{
    // a constant array that holds all valid command words
    private static final String validCommands[] = {
        "go", "quit", "help", "look", "comer", "procurar", "adicionar"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * Return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString)){
                //TesteJogo.addRecords(aString);
                return true;
            }
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
    public static String[] getValidCommands(){
        return CommandWords.validCommands;
    }

}
