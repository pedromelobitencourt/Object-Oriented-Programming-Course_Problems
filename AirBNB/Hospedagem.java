/* GRUPO:
    Pedro Veloso Inácio de Oliveira - 20213004837
    Pedro Vitor Melo Bitencourt - 20213001540
    Rafael Pereira Duarte - 20213005146
*/

package principal_Cefetairbnb_PedroVeloso_PedroVitor_RafaelPereira;

public class Hospedagem {
	private boolean alugado;
	private double preco;
	private String cliente;
        private int qntd_camas;


    public int getQntd_camas() {
        return qntd_camas;
    }
          
    public Hospedagem() {
	this.alugado = false;
        this.preco = 0.0;
        this.cliente = "";
		
    }

    public void setQntd_camas(int qntd_camas) {
        this.qntd_camas = qntd_camas;
    }
    
    public Hospedagem(int preco,String cliente) {
	this.alugado = true;
	this.preco = preco;
	this.cliente = cliente;
		
    }
    public boolean isAlugado() {
	return alugado;
    }
    public void setAlugado(boolean alugado) {
	this.alugado = alugado;
    }
    public double getPreco() {
	return preco;
    }
    public void setPreco(double preco) {
	this.preco = preco;
    }
    public String getCliente() {
	return cliente;
    }
    public void setCliente(String cliente) {
	this.cliente = cliente;
    }
	
	
}
