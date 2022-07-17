/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;

import java.util.Scanner;

public class Teste{
    public static void main(String[] args) {
        CaixaDeBrinquedo caixaDeBrinquedo = new CaixaDeBrinquedo();
        String escolha1, escolha2;
        int opcao = 0;
        double lado = 0.0, raio = 0.0, aresta = 0.0, base = 0.0, altura = 0.0;
        boolean continuar = true;
        
        Scanner input = new Scanner(System.in);
        
        
        while(continuar){
            System.out.println("Digite '1' para adicionar um brinquedo a caixa");
            System.out.println("Digite '2' para listar todos os brinquedos da caixa");
            System.out.println("Digite '3' para listar todos os brinquedos de uma forma especifica da caixa");
            System.out.println("Digite '4' para mostrar o volume de cada brinquedo da caixa");
            System.out.println("Digite '5' para mostrar a area de cada brinquedo da caixa");
            System.out.println("Digite '6' para mostrar a area e o volume de cada brinquedo da caixa");
            System.out.println("Digite '7' para remover um brinquedo da caixa");
            System.out.println("Digite '8' para fechar a caixa de brinquedos");
            escolha1 = input.next();
            
            switch(escolha1){
                case "1" -> {
                    System.out.println("Digite '1' se o brinquedo que vai ser adicionado e um Triangulo");
                    System.out.println("Digite '2' se o brinquedo que vai ser adicionado e um Quadrado");
                    System.out.println("Digite '3' se o brinquedo que vai ser adicionado e um Circulo");
                    System.out.println("Digite '4' se o brinquedo que vai ser adicionado e um Tetraedro");
                    System.out.println("Digite '5' se o brinquedo que vai ser adicionado e um Cubo");
                    System.out.println("Digite '6' se o brinquedo que vai ser adicionado e uma Esfera");
                    escolha2 = input.next();
                    
                    switch(escolha2){
                        case "1" -> {
                            //Triangulo triangulo = new Triangulo();
                            System.out.println("Digite o valor da base do triangulo");
                            //triangulo.setBase(input.nextDouble());
                            base = input.nextDouble();
                            System.out.println("Digite o valor da altura do triangulo");
                            //triangulo.setAltura(input.nextDouble());
                            altura = input.nextDouble();
                            Triangulo triangulo = new Triangulo(base, altura);
                            caixaDeBrinquedo.inserirBrinquedo(triangulo);
                            System.out.println("Brinquedo adicionado com sucesso!\n");
                        }
                        
                        case "2" -> {
                            //Quadrado quadrado = new Quadrado();
                            System.out.println("Digite o valor do lado do quadrado");
                            lado = input.nextDouble();
                            //quadrado.setLado(input.nextDouble());
                            Quadrado quadrado = new Quadrado(lado);
                            caixaDeBrinquedo.inserirBrinquedo(quadrado);
                            System.out.println("Brinquedo adicionado com sucesso!\n");
                        }
                        
                        case "3" -> {
                            //Circulo circulo = new Circulo();
                            System.out.println("Digite o valor do raio do circulo");
                            raio = input.nextDouble();
                            //circulo.setRaio(input.nextDouble());
                            Circulo circulo = new Circulo(raio);
                            caixaDeBrinquedo.inserirBrinquedo(circulo);
                            System.out.println("Brinquedo adicionado com sucesso!\n");
                        }
                        
                        case "4" -> {
                            //Tetraedro tetraedro = new Tetraedro();
                            System.out.println("Digite o valor da aresta do tetraedro");
                            //tetraedro.setAresta(input.nextDouble());
                            aresta = input.nextDouble();
                            Tetraedro tetraedro = new Tetraedro(aresta);
                            caixaDeBrinquedo.inserirBrinquedo(tetraedro);
                            System.out.println("Brinquedo adicionado com sucesso!\n");
                        }
                        
                        case "5" -> {
                            //Cubo cubo = new Cubo();
                            System.out.println("Digite o valor do lado do cubo");
                            //cubo.setLado(input.nextDouble());
                            lado = input.nextDouble();
                            Cubo cubo = new Cubo(lado);
                            caixaDeBrinquedo.inserirBrinquedo(cubo);
                            System.out.println("Brinquedo adicionado com sucesso!\n");
                        }
                        
                        case "6" -> {
                            //Esfera esfera = new Esfera();
                            System.out.println("Digite o valor do raio da esfera");
                            //esfera.setRaio(input.nextDouble());
                            raio = input.nextDouble();
                            Esfera esfera = new Esfera(raio);
                            caixaDeBrinquedo.inserirBrinquedo(esfera);
                            System.out.println("Brinquedo adicionado com sucesso!\n");
                        }
                    }
                }

                case "2" -> caixaDeBrinquedo.listarBrinquedos();
                    
                case "3" -> {
                    System.out.println("Digite '1' para ver todos os triangulos");
                    System.out.println("Digite '2' para ver todos os quadrados");
                    System.out.println("Digite '3' para ver todos os circulos");
                    System.out.println("Digite '4' para ver todos os tetraedros");
                    System.out.println("Digite '5' para ver todos os cubos");
                    System.out.println("Digite '6' para ver todas as esferas");
                    escolha2 = input.next();
                    
                    switch(escolha2){
                        case "1" -> caixaDeBrinquedo.listarTriangulos();
                            
                        case "2" -> caixaDeBrinquedo.listarQuadrados();
                            
                        case "3" -> caixaDeBrinquedo.listarCirculos();
                            
                        case "4" -> caixaDeBrinquedo.listarTetraedros();
                            
                        case "5" -> caixaDeBrinquedo.listarCubos();
                            
                        case "6" -> caixaDeBrinquedo.listarEsferas();
                    }
                }

                case "4" -> caixaDeBrinquedo.calcularVolume();
                    
                case "5" -> caixaDeBrinquedo.calcularArea();
                    
                case "6" -> caixaDeBrinquedo.calcularAreaEVolume();
                    
                case "7" -> {
                    caixaDeBrinquedo.listarBrinquedos();
                    System.out.println("Qual dos brinquedos voce gostaria de remover da caixa de brinquedos?");
                    opcao = input.nextInt();
                    caixaDeBrinquedo.removerBrinquedo(opcao-1);
                    System.out.println("Brinquedo removido com sucesso!\n");
                }
                    
                case "8" -> {
                    System.out.println("Fechando a caixa de brinquedos...");
                    continuar = false;
                }
                    
            }
        }
    }
}
