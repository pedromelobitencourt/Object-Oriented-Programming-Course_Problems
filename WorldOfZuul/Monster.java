/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540

Não tirei os print's para que você possa ver as alterações, mas, após eu enviar esta atividade, vou comentar em todos
para que eu possa implementar uma interface gráfica futuramente
*/

package newpackage;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Monster {
    private final double forca; //Dano dos inimigos - Tipo o nível de periculosiddae
    private final double vida; //Quantidade de vida dos inimigos
    
    public Monster(){
        //double forcas[] = {50, 100, 200};
        //double vidas[] = {100, 300, 500};
        Random rand = new Random();
        //this.forca = forcas[rand.nextInt(3)];
        //this.vida = vidas[rand.nextInt(3)];
        List<Double> forcas = new ArrayList<Double>();
        forcas.add(50.0);
        forcas.add(100.0);
        forcas.add(200.0);
        
        List<Double> vidas = new ArrayList<Double>();
        vidas.add(100.0);
        vidas.add(300.0);
        vidas.add(500.0);
        
        this.forca = forcas.get(rand.nextInt(forcas.size()));
        this.vida = vidas.get(rand.nextInt(vidas.size()));
    }

    public double getForca() {
        return forca;
    }

    public double getVida() {
        return vida;
    }
    
    
}
