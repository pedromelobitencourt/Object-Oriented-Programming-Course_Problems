/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package newpackage;
public class CifraDeCesar {
    private Chave chave;
    
    public CifraDeCesar(int deslocamento){
        chave = new Chave(deslocamento);
    }
    
    public CifraDeCesar(){
        chave = new Chave(0);
    }
    
    public Chave getChave() {
        return chave;
    }

    public void setChave(Chave chave) {
        this.chave = chave;
    }
    
    public String cifrar(String mensagem){
        int deslocamento = 0, controle = 0, controle2 = 0;// controleAntigo = 0;
        String mensagemCifrada = "";
        boolean jaAchou = false;
        for(int i = 0; i < mensagem.length(); i++){
            if(mensagem.charAt(i) == ' '){
                mensagemCifrada += " ";
            }
            else{
                for(String a : getChave().getAlfabeto()){
                    if(a.equals(Character.toString(mensagem.charAt(i)))){
                        deslocamento = getChave().getDeslocamento();
                        //controleAntigo = controle;
                        while(deslocamento > 0){
                            if(controle == 25){
                                controle = 0;
                            }
                            else{
                                controle++;
                            }
                            deslocamento--;
                        }
                        controle2 = 0;
                        for(String b : getChave().getAlfabeto()){
                            if(controle == controle2 && jaAchou == false){
                                mensagemCifrada += b;
                                //controle = controleAntigo;
                                jaAchou = true;
                            }
                            controle2++;
                        }
                        jaAchou = false;
                    }
                    controle++;
                }
                controle = 0;
            }
        }
        return mensagemCifrada;
    }
    
    public String decifrar(String mensagem){
        int deslocamento = 0, controle = 0, controle2 = 0; //controleAntigo = 0;
        String mensagemDecifrada = "";
        boolean jaAchou = false;
        for(int i = 0; i < mensagem.length(); i++){
            if(mensagem.charAt(i) == ' '){
                mensagemDecifrada += " ";
            }
            else{
                for(String a : getChave().getAlfabeto()){
                    if(a.equals(Character.toString(mensagem.charAt(i)))){
                        deslocamento = getChave().getDeslocamento();
                        //controleAntigo = controle;
                        while(deslocamento > 0){
                            if(controle == 0){
                                controle = 25;
                            }
                            else{
                                controle--;
                            }
                            deslocamento--;
                        }
                        controle2 = 0;
                        for(String b : getChave().getAlfabeto()){
                            if(controle == controle2 && jaAchou == false){
                                mensagemDecifrada += b;
                                //controle = controleAntigo;
                                jaAchou = true;
                            }
                            controle2++;
                        }
                        jaAchou = false;
                    }
                    controle++;
                }
                controle = 0;
            }
        }
        return mensagemDecifrada;
    }
    
    public boolean verificarResposta(String tentativaUsuario, String mensagem) throws DecifragemInvalidaException{
        if(tentativaUsuario.equals(decifrar(mensagem))){
            return true;
        }
        else{
            throw new DecifragemInvalidaException();
        }
    }

}
