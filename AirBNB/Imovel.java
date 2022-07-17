/* GRUPO:
    Pedro Veloso Inácio de Oliveira - 20213004837
    Pedro Vitor Melo Bitencourt - 20213001540
    Rafael Pereira Duarte - 20213005146
*/

package principal_Cefetairbnb_PedroVeloso_PedroVitor_RafaelPereira;

public class Imovel {
	private Hospedagem[] quartos;
	private String proprietario;
        private String localizacao;
        private String nome;
        private double faturamento_proprietario;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getNome() {
        return nome;
    }
	
    public Imovel(Hospedagem[] quartos, String proprietario, String localizacao, String nome){
        this.quartos = quartos;
        this.proprietario = proprietario;
        this.localizacao = localizacao;
        this.nome = nome;
    }
        
    public Imovel(int numquartos) {
            this.quartos = new Hospedagem[numquartos];
            for(int i = 0; i < numquartos; i++){
                quartos[i] = new Hospedagem();
            }
	}

    public Hospedagem[] getQuartos() {
	return quartos;
    }

    public void setQuartos(Hospedagem[] quartos) {
	this.quartos = quartos;
    }
        
    public String getLocalizacao(){
        return this.localizacao;
    }
	
    public void setLocalizacao(String localizacao){
        this.localizacao = localizacao;
    }
        
    public void setProprietario(String proprietario){
        this.proprietario = proprietario;
    }
        
    public int quantidadeQuartos(){
        return quartos.length;
    }
        
    public void setFaturamentoProprietario(double faturamento){
        this.faturamento_proprietario = faturamento;
    }
    
    public double getFaturamentoProprietario(){
        return this.faturamento_proprietario;
    }
}

