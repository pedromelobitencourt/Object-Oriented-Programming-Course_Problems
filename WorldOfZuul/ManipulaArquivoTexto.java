/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;

//import java.io.EOFException;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ManipulaArquivoTexto {
    private static Formatter output;
    private static Scanner input;
    private static ArrayList<String> palavrasArquivo;
    
    public static ArrayList<String> getPalavrasArquivo(){
        return ManipulaArquivoTexto.palavrasArquivo;
    }
    
    public static void openFile(){
            try{
                Path path = Paths.get("entradasUsuario.txt");
                if(Files.exists(path)){ //Se já existir o arquivo, preciso só lê-lo
                    input = new Scanner(Paths.get("entradasUsuario.txt"));
                }
                else{ //Se não existir o arquivo, vou criá-lo e depois lê-lo
                    output = new Formatter("entradasUsuario.txt");
                    input = new Scanner(Paths.get("entradasUsuario.txt"));
                }
            }
            catch(FileNotFoundException e){
                System.out.println("Arquivo nao encontrado!\n Fechando a execucao...\n");
                System.exit(1);
            }
            catch(IOException e){
                System.exit(1);
            }
        }
        
        public static void addRecords(String a){
            try{
                FileWriter fstream = new FileWriter("entradasUsuario.txt", true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(a.concat("\n"));
                out.close();
                fstream.close();
            }
            catch(FormatterClosedException e){
                System.err.println("Erro ao tentar gravar no arquivo\nFechando a execucao...");
            }
            catch(Exception e){
                System.out.println("Nao deu para gravar, foi mal\n");
                System.exit(1);
            }
        }
        
        public static void closeFile(){
            if(output != null){
                output.close();
                input.close();
            }
        }
        
        public static void readRecords(){
            int i = 0;
            palavrasArquivo = new ArrayList<String>();
            try{
                while(input.hasNext()){
                    palavrasArquivo.add(input.nextLine());
                }
            }
            catch(NoSuchElementException e){
                System.err.println("Fechando a execucao...\n");
                System.exit(1);
            }
            catch(IllegalStateException e){
                System.err.println("Erro ao ler o arquivo\nFechando a execucao...");
                System.exit(1);
            }
            
            /*System.out.println("Palavras lidas do arquivo:\n");
            for(String a : palavrasArquivo){
                System.out.printf("%s\n", a);
            }*/
        }
}
