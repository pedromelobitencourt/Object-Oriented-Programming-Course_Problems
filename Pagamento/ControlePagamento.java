/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;

import java.util.ArrayList;

public class ControlePagamento {
    public static final double SALARIO = 1192.40; //atributo estático
    public static final double HORA = 20; //atributo estático - Valor de cada hora extra
    
    private ArrayList <Pagavel> pagamentos;
    
    public ControlePagamento(){
        this.pagamentos = new ArrayList();
    }
    
    public ArrayList <Pagavel> getPagamentos(){
        return this.pagamentos;
    }
    
    public void setPagamentos(ArrayList <Pagavel> pagamentos){
        this.pagamentos = pagamentos;
    }
    
    public void inserirPagavel(Pagavel pagamento){
        this.pagamentos.add(pagamento);
    }
    
    public void removerPagamento(int escolha){
        for(int i = 0; i < this.pagamentos.size(); i++){
            if(i == escolha){
                this.pagamentos.remove(i);
            }
        }
    }
    
    public void listarPagamentos(){
        int titulos = 1, concessionarias = 1, terceirizados = 1, comissionados = 1, assalariados = 1, assalariadosComissionados = 1;
        int pagamentos = 1;
        if(this.pagamentos.size() > 0){
            for(Pagavel a : this.pagamentos){
                System.out.printf("====== Pagamento nº %d ======\n\n", pagamentos);
                if(a instanceof Titulo){
                    System.out.printf("*Titulo %d*\n", titulos);
                    System.out.printf("Dia: %d\n", ((Titulo) a).getDia());
                    System.out.printf("Mes: %d\n", ((Titulo) a).getMes());
                    System.out.printf("Valor: R$%.2f\n\n", ((Titulo) a).getValor());
                    //System.out.printf("Valor a pagar: %.2f\n\n", ((Titulo) a).getValorAPagar(assalariados, assalariados));
                    titulos++;
                }
                if(a instanceof Concessionaria){
                    System.out.printf("*Concessionaria %d*\n", concessionarias);
                    System.out.printf("Dia: %d\n", ((Concessionaria) a).getDia());
                    System.out.printf("Mes: %d\n", ((Concessionaria) a).getMes());
                    System.out.printf("Valor: R$%.2f\n\n", ((Concessionaria) a).getValor());
                    concessionarias++;
                }
                if(a instanceof Terceirizado){
                    System.out.printf("*Terceirizado %d*\n", terceirizados);
                    System.out.printf("Nome: %s\n", ((Terceirizado) a).getNome());
                    System.out.printf("Sobrenome: %s\n", ((Terceirizado) a).getSobrenome());
                    System.out.printf("Numero de identidade: %d\n", ((Terceirizado) a).getNumIdent());
                    System.out.printf("Horas Trabalhadas: %.2f\n\n", ((Terceirizado) a).getHorasTrabalhadas());
                    terceirizados++;
                }
                if(a instanceof Comissionado && !(a instanceof AssalariadoComissionado)){
                    System.out.printf("*Comissionado %d*\n", comissionados);
                    System.out.println("Assalariado: Nao");
                    System.out.printf("Nome: %s\n", ((Comissionado) a).getNome());
                    System.out.printf("Sobrenome: %s\n", ((Comissionado) a).getSobrenome());
                    System.out.printf("Numero de identidade: %d\n", ((Comissionado) a).getNumIdent());
                    System.out.printf("Valor de vendas: R$%.2f\n\n", ((Comissionado) a).getValorVendas());
                    comissionados++;
                }
                if(a instanceof Assalariado){
                    System.out.printf("*Assalariado %d*\n", assalariados);
                    System.out.printf("Nome: %s\n", ((Assalariado) a).getNome());
                    System.out.printf("Sobrenome: %s\n", ((Assalariado) a).getSobrenome());
                    System.out.printf("Numero de identidade: %d\n", ((Assalariado) a).getNumIdent());
                    System.out.printf("Horas extras: %.2f\n\n", ((Assalariado) a).getHorasExtras());
                    assalariados++;
                }
                if(a instanceof AssalariadoComissionado){
                    System.out.printf("*Comissionado nº %d*\n", comissionados);
                    System.out.printf("*Assalariado/comissionado nº %d*\n", assalariadosComissionados);
                    System.out.printf("Nome: %s\n", ((AssalariadoComissionado) a).getNome());
                    System.out.printf("Sobrenome: %s\n", ((AssalariadoComissionado) a).getSobrenome());
                    System.out.printf("Numero de identidade: %d\n", ((AssalariadoComissionado) a).getNumIdent());
                    System.out.printf("Valor de vendas: R$%.2f\n\n", ((AssalariadoComissionado) a).getValorVendas());
                    assalariadosComissionados++;
                    comissionados++;
                }
                pagamentos++;
            }
        }
        else{
            System.out.println("Nao ha nenhum pagamento cadastrado no sistema. Por favor, adicione um ou mais");
        }
    }
    
    public void listarPagamentosConta(){
        int quantidade = 0;
        for(Pagavel a : this.pagamentos){
            if(a instanceof Conta){
                System.out.printf("**Conta nº %d:**\n\n", quantidade+1);
                if(a instanceof Titulo){
                    System.out.println("*Tipo de conta: Titulo");
                }
                
                else if(a instanceof Concessionaria){
                    System.out.println("*Tipo de conta: Concessionaria");
                }
                
                System.out.printf("Dia: %d\n", ((Conta) a).getDia());
                System.out.printf("Mes: %d\n", ((Conta) a).getMes());
                System.out.printf("Valor da conta: R$%.2f\n\n", ((Conta) a).getValor());
                quantidade++;
            }
        }
    }
    
    public void listarPagamentosEmpregado(){
        int quantidade = 0;
        for(Pagavel a : this.pagamentos){
            if(a instanceof Empregado){
                System.out.printf("**Empregado %d:**\n\n", quantidade+1);
                if(a instanceof Terceirizado){
                    System.out.println("*Tipo de empregado: Terceirizado");
                    System.out.printf("Nome: %s\n", ((Terceirizado) a).getNome());
                    System.out.printf("Sobrenome: %s\n", ((Terceirizado) a).getSobrenome());
                    System.out.printf("Numero de identidade: %d\n", ((Terceirizado) a).getNumIdent());
                    System.out.printf("Horas Trabalhadas: %.2f\n\n", ((Terceirizado) a).getHorasTrabalhadas());
                }
                
                else if(a instanceof Comissionado && !(a instanceof AssalariadoComissionado)){
                    System.out.println("*Tipo de empregado: Comissionado");
                    System.out.println("Assalariado: Nao");
                    System.out.printf("Nome: %s\n", ((Comissionado) a).getNome());
                    System.out.printf("Sobrenome: %s\n", ((Comissionado) a).getSobrenome());
                    System.out.printf("Numero de identidade: %d\n", ((Comissionado) a).getNumIdent());
                    System.out.printf("Valor de vendas: R$%.2f\n\n", ((Comissionado) a).getValorVendas());
                }
                else if(a instanceof Assalariado){
                    System.out.println("*Tipo de empregado: Assalariado");
                    System.out.printf("Nome: %s\n", ((Assalariado) a).getNome());
                    System.out.printf("Sobrenome: %s\n", ((Assalariado) a).getSobrenome());
                    System.out.printf("Numero de identidade: %d\n", ((Assalariado) a).getNumIdent());
                    System.out.printf("Horas extras: %.2f\n\n", ((Assalariado) a).getHorasExtras());
                }
                else if(a instanceof AssalariadoComissionado){
                    System.out.println("*Tipo de empregado: Assalariado/Comissionado");
                    System.out.printf("Nome: %s\n", ((AssalariadoComissionado) a).getNome());
                    System.out.printf("Sobrenome: %s\n", ((AssalariadoComissionado) a).getSobrenome());
                    System.out.printf("Numero de identidade: %d\n", ((AssalariadoComissionado) a).getNumIdent());
                    System.out.printf("Valor de vendas: R$%.2f\n\n", ((AssalariadoComissionado) a).getValorVendas());
                }
                quantidade++;
            }
        }
    }
    
    public void listarTitulos(){
        int quantidade = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof Titulo){
                System.out.printf("**Titulo nº %d**\n", quantidade+1);
                System.out.printf("Dia: %d\n", ((Titulo) a).getDia());
                System.out.printf("Mes: %d\n", ((Titulo) a).getMes());
                System.out.printf("Valor: %.2f\n\n\n", ((Titulo) a).getValor());
                quantidade++;
            }
        }
    }
    
    public void listarConcessionaria(){
        int quantidade = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof Concessionaria){
                System.out.printf("**Concessionaria nº %d**\n", quantidade+1);
                System.out.printf("Dia: %d\n", ((Concessionaria) a).getDia());
                System.out.printf("Mes: %d\n", ((Concessionaria) a).getMes());
                System.out.printf("Valor: R$%.2f\n\n", ((Concessionaria) a).getValor());
                quantidade++;
            }
        }
    }
    
    public void listarTerceirizados(){
        int quantidade = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof Terceirizado){
                System.out.printf("**Terceirizado nº %d**\n", quantidade+1);
                System.out.printf("Nome: %s\n", ((Terceirizado) a).getNome());
                System.out.printf("Sobrenome: %s\n", ((Terceirizado) a).getSobrenome());
                System.out.printf("Numero de identidade: %d\n", ((Terceirizado) a).getNumIdent());
                System.out.printf("Horas Trabalhadas: %.2f\n\n", ((Terceirizado) a).getHorasTrabalhadas());
                quantidade++;
            }
        }
    }
    
    public void listarComissionados(){
        int quantidade = 0;
        for(Pagavel a : this.pagamentos){
            if(a instanceof Comissionado){
                System.out.printf("**Comissionado nº %d**\n\n", quantidade+1);
                System.out.printf("Nome: %s\n", ((Comissionado) a).getNome());
                System.out.printf("Sobrenome: %s\n", ((Comissionado) a).getSobrenome());
                System.out.printf("Numero de identidade: %d\n", ((Comissionado) a).getNumIdent());
                System.out.printf("Valor de vendas: R$%.2f\n\n", ((Comissionado) a).getValorVendas());
                quantidade++;
            }
        }
    }
    
    public void listarAssalariados(){
        int quantidade = 0;
        for(Pagavel a : this.pagamentos){
            if(a instanceof Assalariado){
                System.out.printf("**Assalariado nº %d**\n\n", quantidade+1);
                System.out.printf("Nome: %s\n", ((Assalariado) a).getNome());
                System.out.printf("Sobrenome: %s\n", ((Assalariado) a).getSobrenome());
                System.out.printf("Numero de identidade: %d\n", ((Assalariado) a).getNumIdent());
                System.out.printf("Horas extras: %.2f\n\n", ((Assalariado) a).getHorasExtras());
                quantidade++;
            }
        }
    }
    
    public void listarAssalariadosComissionados(){
        int quantidade = 0;
        for(Pagavel a : this.pagamentos){
            if(a instanceof AssalariadoComissionado){
                System.out.printf("**Assalariado/comissionado nº %d**\n", quantidade+1);
                System.out.printf("Nome: %s\n", ((AssalariadoComissionado) a).getNome());
                System.out.printf("Sobrenome: %s\n", ((AssalariadoComissionado) a).getSobrenome());
                System.out.printf("Numero de identidade: %d\n", ((AssalariadoComissionado) a).getNumIdent());
                System.out.printf("Valor de vendas: %.2f\n", ((AssalariadoComissionado) a).getValorVendas());
                System.out.printf("Percentual de bonus: %.2f\n\n", ((AssalariadoComissionado) a).getPercentualBonus());
            }
        }
    }
    
    public void listarPagamentosComData(int diaPagamento, int mesPagamento){
        int conta = 0, empregado = 0, titulos = 0, concessionarias = 0, terceirizados = 0, comissionados = 0, assalariados = 0;
        int assalariadosComissionados = 0;
        for(Pagavel a : this.pagamentos){
            if(a instanceof Conta){
                System.out.printf("**Conta nº %d**\n", conta+1);
                if(a instanceof Titulo){
                    System.out.printf("*Titulo nº %d*\n", titulos+1);
                    System.out.printf("Dia do vencimento do titulo: %d\n", ((Titulo) a).getDia());
                    System.out.printf("Mes do vencimento do titulo: %d\n", ((Titulo) a).getMes());
                    System.out.printf("Valor do titulo: R$%.2f\n\n", ((Titulo) a).getValor());
                    System.out.printf("Valor a pagar: R$%.2f\n\n", a.getValorAPagar(diaPagamento, mesPagamento));
                    titulos++;
                }
                if(a instanceof Concessionaria){
                    System.out.printf("*Concessionaria nº %d*\n", concessionarias+1);
                    System.out.printf("Dia do vencimento do titulo: %d\n", ((Concessionaria) a).getDia());
                    System.out.printf("Mes do vencimento do titulo: %d\n", ((Concessionaria) a).getMes());
                    System.out.printf("Valor do titulo: R$%.2f\n\n", ((Concessionaria) a).getValor());
                    System.out.printf("Valor a pagar: R$%.2f\n\n", a.getValorAPagar(diaPagamento, mesPagamento));
                    concessionarias++;
                }
                conta++;
            }
            if(a instanceof Empregado){
                System.out.printf("**Empregado nº %d**\n", empregado+1);
                if(a instanceof Terceirizado){
                    System.out.printf("*Terceirizado nº %d*\n", terceirizados+1);
                    System.out.printf("Nome do empregado: %s\n", ((Terceirizado) a).getNome());
                    System.out.printf("Sobrenome do empregado: %s\n", ((Terceirizado) a).getSobrenome());
                    System.out.printf("Numero de identidade do empregado: %d\n", ((Terceirizado) a).numIdent);
                    System.out.printf("Horas trabalhadas: %.2f\n", ((Terceirizado) a).getHorasTrabalhadas());
                    System.out.printf("Valor a pagar: R$%.2f\n\n", a.getValorAPagar(diaPagamento, mesPagamento));
                    terceirizados++;
                }
                if(a instanceof Comissionado){
                    if(!(a instanceof AssalariadoComissionado)){
                        System.out.printf("*Comissionado nº %d*\n", comissionados+1);
                        System.out.println("Assalariado: Nao");
                        System.out.printf("Nome do empregado: %s\n", ((Comissionado) a).getNome());
                        System.out.printf("Sobrenome do empregado: %s\n", ((Comissionado) a).getSobrenome());
                        System.out.printf("Numero de identidade do empregado: %d\n", ((Comissionado) a).numIdent);
                        System.out.printf("Valor das vendas: R$%.2f\n", ((Comissionado) a).getValorVendas());
                        System.out.printf("Valor a pagar: R$%.2f\n\n", a.getValorAPagar(diaPagamento, mesPagamento));
                        comissionados++;
                    }
                    else if(a instanceof AssalariadoComissionado){
                        System.out.printf("*Comissionado nº %d*\n", comissionados+1);
                        System.out.printf("*Assalariado e comissionado nº %d\n", assalariadosComissionados+1);
                        System.out.printf("Nome do empregado: %s\n", ((AssalariadoComissionado) a).getNome());
                        System.out.printf("Sobrenome do empregado: %s\n", ((AssalariadoComissionado) a).getSobrenome());
                        System.out.printf("Numero de identidade do empregado: %d\n", ((AssalariadoComissionado) a).numIdent);
                        System.out.printf("Valor das vendas: R$%.2f\n", ((AssalariadoComissionado) a).getValorVendas());
                        System.out.printf("Percentual de bonus: %.2f\n", ((AssalariadoComissionado) a).getPercentualBonus());
                        System.out.printf("Valor a pagar: R$%.2f\n\n", a.getValorAPagar(diaPagamento, mesPagamento));
                        comissionados++;
                        assalariadosComissionados++;
                    }
                }
                if(a instanceof Assalariado){
                    System.out.printf("*Assalariado nº %d*\n", assalariados+1);
                    System.out.printf("Nome do empregado: %s\n", ((Assalariado) a).getNome());
                    System.out.printf("Sobrenome do empregado: %s\n", ((Assalariado) a).getSobrenome());
                    System.out.printf("Numero de identidade do empregado: %d\n", ((Assalariado) a).getNumIdent());
                    System.out.printf("Quantidade de horas extras: %.2f\n", ((Assalariado) a).getHorasExtras());
                    System.out.printf("Valor a pagar: R$%.2f\n\n", a.getValorAPagar(diaPagamento, mesPagamento));
                    assalariados++;
                    
                }
                empregado++;
            }
        }
    }
    
    public double getValorAPagarContas(int diaPagamento, int mesPagamento){
        double total = 0;
        for(Pagavel a : this.pagamentos){
            if(a instanceof Conta){
                total += a.getValorAPagar(diaPagamento, mesPagamento);
            }
        }
        return total;
    }
    
    public double getValorAPagarEmpregados(int diaPagamento, int mesPagamento){
        double total = 0;
        for(Pagavel a : this.pagamentos){
            if(a instanceof Empregado){
                total += a.getValorAPagar(diaPagamento, mesPagamento);
            }
        }
        return total;
    }
    
    public double ValorAPagarTitulosComData(int diaPagamento, int mesPagamento, int escolha){
        double total = 0.0;
        int i = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof Titulo){
                if(i == escolha){
                    total += a.getValorAPagar(diaPagamento, mesPagamento);
                }
                i++;
            }
        }
        return total;
    }
    
    public double ValorAPagarConcessionariasComData(int diaPagamento, int mesPagamento, int escolha){
        double total = 0.0;
        int i = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof Concessionaria){
                if(i == escolha){
                    total += a.getValorAPagar(diaPagamento, mesPagamento);
                }
                i++;
            }
        }
        return total;
    }
    
    public double ValorAPagarTerceirizadosComData(int diaPagamento, int mesPagamento, int escolha){
        double total = 0.0;
        int i = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof Terceirizado){
                if(i == escolha){
                    total += a.getValorAPagar(diaPagamento, mesPagamento);
                }
                i++;
            }
        }
        return total;
    }
    
    public double ValorAPagarComissionadosComData(int diaPagamento, int mesPagamento, int escolha){
        double total = 0.0;
        int i = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof Comissionado){
                if(i == escolha){
                    total += a.getValorAPagar(diaPagamento, mesPagamento);
                }
                i++;
            }
        }
        return total;
    }
    
    
    public double ValorAPagarAssalariadosComData(int diaPagamento, int mesPagamento, int escolha){
        double total = 0.0;
        int i = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof Assalariado){
                if(i == escolha){
                    total += a.getValorAPagar(diaPagamento, mesPagamento);
                }
                i++;
            }
        }
        return total;
    }
    
    public double ValorAPagarAssalariadosComissionadosComData(int diaPagamento, int mesPagamento, int escolha){
        double total = 0.0;
        int i = 0;
        for(Pagavel a: this.pagamentos){
            if(a instanceof AssalariadoComissionado){
                if(i == escolha){
                    total += a.getValorAPagar(diaPagamento, mesPagamento);
                }
                i++;
            }
        }
        return total;
    }
    
    public void removerTodosPagamentos(){
        this.pagamentos.removeAll(pagamentos);
    }
    
    public double valorAPagarTotal(int diaPagamento, int mesPagamento){
        double total = 0.0;
        for(Pagavel a : this.pagamentos){
            total += a.getValorAPagar(diaPagamento, mesPagamento);
        }
        return total;
    }
}
