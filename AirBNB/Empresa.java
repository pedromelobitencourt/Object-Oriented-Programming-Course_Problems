/* GRUPO:
    Pedro Veloso Inácio de Oliveira - 20213004837
    Pedro Vitor Melo Bitencourt - 20213001540
    Rafael Pereira Duarte - 20213005146
*/
package principal_Cefetairbnb_PedroVeloso_PedroVitor_RafaelPereira;

import java.util.ArrayList;

import java.util.Iterator;

public class Empresa {
    private ArrayList <Imovel> imoveis = new ArrayList <Imovel>();
	//private Imovel[] imoveis;
    private double faturamento_administracao;


    public double getFaturamento_administracao() {
        return faturamento_administracao;
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;
    }




    public void setFaturamento_administracao(double faturamento_administracao) {
        this.faturamento_administracao = faturamento_administracao;
    }


        
    public void realizarHospedagem(Imovel imovel, int quarto){
        if(imovel.getQuartos()[quarto].isAlugado()){
            System.out.println("Quarto já hospedado");
        }
        else{
            imoveis.add(imovel);
          }
    }
    
    public void cadastrarHospedagem(int escolha, String cliente){
    	int j = 0, k = -1;
        for(Imovel i : imoveis){
            for(j = 0; j < i.quantidadeQuartos(); j++){ //i.getQuartos()[j]
                if(!i.getQuartos()[j].isAlugado()){  //!i.getQuartos[j].isAlugado()
                k++;
                if(k == escolha){
                    i.getQuartos()[j].setAlugado(true);
                    i.getQuartos()[j].setCliente(cliente);
                    this.faturamento_administracao += i.getQuartos()[j].getPreco() * 0.3;
                    i.setFaturamentoProprietario(i.getFaturamentoProprietario() + i.getQuartos()[j].getPreco() * 0.7);
                }
            }
        }
    }}
    
    public void cadastrarImovel(Imovel imovel){
        imoveis.add(imovel);
    }
    
    public void mostrarHospedagensDisponiveis(){
        int j = 0, k = 0;
        for(Imovel i : imoveis){
            for(j = 0; j < i.quantidadeQuartos(); j++){ //i.getQuartos()[j]
                if(!i.getQuartos()[j].isAlugado()){
                    System.out.printf("        Opção %d:\n\n", k+1);
                    System.out.printf("Nome do imóvel: %s\n", i.getNome());
                    System.out.printf("Localização do imóvel: %s\n", i.getLocalizacao());
                    System.out.printf("Proprietário do imóvel: %s\n", i.getProprietario());
                    System.out.printf("Quantidade de camas: %d\n", i.getQuartos()[j].getQntd_camas());
                    System.out.printf("Preço da diária: %.2f\n", i.getQuartos()[j].getPreco());
                    k++;
                    System.out.println("");
                }
            }
        }
    }
    
    public void mostrarTodasHospedagens(){
        int j = 0;
        for(Imovel i : imoveis){
            for(j = 0; j < i.quantidadeQuartos(); j++){
                System.out.printf("Nome do imóvel: %s\n", i.getNome());
                System.out.printf("Localização do imóvel: %s\n", i.getLocalizacao());
                System.out.printf("Proprietário do imóvel: %s\n", i.getProprietario());
                System.out.printf("Quarto %d\n", j+1);
                System.out.printf("Quantidade de camas: %d\n", i.getQuartos()[j].getQntd_camas());
                System.out.printf("Preço da diária: %.2f\n", i.getQuartos()[j].getPreco());
                if(i.getQuartos()[j].isAlugado()){
                    System.out.println("Status: Indisponível");
                    System.out.printf("Nome do cliente: %s\n\n", i.getQuartos()[j].getCliente());
                }
                else{
                    System.out.println("Status: Disponível\n");
                }
            }
        }
    }
    
    public void mostrarProprietariosImoveis(){
        int j = 0;
        for(Imovel i : imoveis){
            System.out.printf("Proprietário %d: %s\n", j+1, i.getProprietario());
            j++;
        }
    }
    
    public int quantidadeImoveis(){
        return imoveis.size();
    }
    
    public double mostrarFaturamentoProprietario(int proprietario){
        int j = 0;
        for(Imovel i : imoveis){
            if(j == proprietario){
                return i.getFaturamentoProprietario();
            }
            j++;
        }
        return 0;
    }
    
    public void mostrarFaturamentoTodosProprietarios(){
        for(Imovel i : imoveis){
            System.out.printf("O faturamento de %s é: %.2f\n", i.getProprietario(), i.getFaturamentoProprietario());
        }
    }
}

