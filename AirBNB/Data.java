package principal_Cefetairbnb_PedroVeloso_PedroVitor_RafaelPereira;
public class Data {
    private int dia;
    private int mes;
    private int ano;
    
    public Data(){
        this.dia = 0;
        this.mes = 0;
        this.ano = 0;
    }
    
    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
}
