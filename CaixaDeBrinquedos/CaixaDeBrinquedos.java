/*
Nome: Pedro Vitor Melo Bitencourt
Matrícula: 20213001540
*/
package principal;

import java.util.ArrayList;

public class CaixaDeBrinquedo {
    private ArrayList<Forma> formas;
    
    public CaixaDeBrinquedo(){
        this.formas = new ArrayList<>();
    }
    
    public void calcularAreaEVolume(){
        for(Forma object : this.formas){
            if(object instanceof Tridimensional){
                if(object instanceof Tetraedro){
                    System.out.printf("Eu sou um Tetraedro, minha area e %.2f unidade(s) de area, e meu volume e %.2f unidade(s) de volume\n\n", object.obterArea(), ((Tetraedro) object).obterVolume());
                }
                if(object instanceof Cubo){
                    System.out.printf("Eu sou um Cubo, minha area e %.2f unidade(s) de area, e meu volume e %.2f unidade(s) de volume\n\n", object.obterArea(), ((Cubo) object).obterVolume());
                }
                if(object instanceof Esfera){
                    System.out.printf("Eu sou uma Esfera, minha area e %.2f unidade(s) de area, e meu volume e %.2f unidade(s) de volume\n\n", object.obterArea(), ((Esfera) object).obterVolume());
                }
            }
            else if(object instanceof Bidimensional){
                if(object instanceof Triangulo){
                    System.out.printf("Eu sou um Triangulo, e minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
                if(object instanceof Quadrado){
                    System.out.printf("Eu sou um Quadrado, e minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
                if(object instanceof Circulo){
                    System.out.printf("Eu sou Circulo, e minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
            }
        }
    }
    
    public void inserirBrinquedo(Forma brinquedo){
        this.formas.add(brinquedo);
    }
    
    public void listarBrinquedos(){
        int brinquedos = 1, triangulos = 1, quadrados = 1, circulos = 1, tetraedros = 1, cubos = 1, esferas = 1;
        for(Forma brinquedo : this.formas){
            System.out.printf("===Brinquedo nº: %d===\n\n", brinquedos);
            if(brinquedo instanceof Tetraedro){
                System.out.printf("**Tetraedro nº: %d**\n", tetraedros);
                System.out.printf("Area: %.2f unidade(s) de area\n", brinquedo.obterArea());
                System.out.printf("Volume: %.2f unidade(s) de volume\n\n", ((Tetraedro) brinquedo).obterVolume());
                tetraedros++;
            }
            if(brinquedo instanceof Cubo){
                System.out.printf("**Cubo nº: %d**\n", cubos);
                System.out.printf("Area: %.2f unidade(s) de area\n", brinquedo.obterArea());
                System.out.printf("Volume: %.2f unidade(s) de volume\n\n", ((Cubo) brinquedo).obterVolume());
                cubos++;
            }
            if(brinquedo instanceof Esfera){
                System.out.printf("**Esfera nº: %d**\n", esferas);
                System.out.printf("Area: %.2f unidade(s) de area\n", brinquedo.obterArea());
                System.out.printf("Volume: %.2f unidade(s) de volume\n\n", ((Esfera) brinquedo).obterVolume());
                esferas++;
            }
            if(brinquedo instanceof Triangulo){
                System.out.printf("**Triangulo nº: %d**\n", triangulos);
                System.out.printf("Area: %.2f unidade(s) de area\n\n", brinquedo.obterArea());
                triangulos++;
            }
            if(brinquedo instanceof Quadrado){
                System.out.printf("**Quadrado nº: %d**\n", quadrados);
                System.out.printf("Area: %.2f unidade(s) de area\n\n", brinquedo.obterArea());
                quadrados++;
            }
            if(brinquedo instanceof Circulo){
                System.out.printf("**Circulo nº: %d**\n", circulos);
                System.out.printf("Area: %.2f unidade(s) de area\n\n", brinquedo.obterArea());
                circulos++;
            }
            brinquedos++;
        }
    }
    
    public void removerBrinquedo(int escolha){
        for(int i = 0; i < this.formas.size(); i++){
            if(i == escolha){
                this.formas.remove(i);
            }
        }
    }
    
    public void calcularVolume(){
        for(Forma a : this.formas){
            if(a instanceof Tridimensional){
                if(a instanceof Tetraedro){
                    System.out.printf("Eu sou um Tetraedro, e meu volume e: %.2f unidade(s) de volume\n\n", ((Tetraedro) a).obterVolume());
                }
                if(a instanceof Cubo){
                    System.out.printf("Eu sou um Cubo, e meu volume e: %.2f unidade(s) de volume\n\n", ((Cubo) a).obterVolume());
                }
                if(a instanceof Esfera){
                    System.out.printf("Eu sou uma Esfera, e meu volume e: %.2f unidade(s) de volume\n\n", ((Esfera) a).obterVolume());
                }
            }
        }
    }
    
    public void calcularArea(){
        for(Forma object : this.formas){
            if(object instanceof Tridimensional){
                if(object instanceof Tetraedro){
                    System.out.printf("Eu sou um Tetraedro, minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
                if(object instanceof Cubo){
                    System.out.printf("Eu sou um Cubo, minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
                if(object instanceof Esfera){
                    System.out.printf("Eu sou uma Esfera, minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
            }
            else if(object instanceof Bidimensional){
                if(object instanceof Triangulo){
                    System.out.printf("Eu sou um Triangulo, e minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
                if(object instanceof Quadrado){
                    System.out.printf("Eu sou um Quadrado, e minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
                if(object instanceof Circulo){
                    System.out.printf("Eu sou Circulo, e minha area e %.2f unidade(s) de area\n\n", object.obterArea());
                }
            }
        }
    }
    
    public void listarTriangulos(){
        int triangulos = 1;
        for(Forma a : this.formas){
            if(a instanceof Triangulo){
                System.out.printf("**Triangulo nº: %d\n", triangulos);
                System.out.printf("Area: %.2f unidade(s) de area\n\n", a.obterArea());
                triangulos++;
            }
        }
    }
    
    public void listarQuadrados(){
        int quadrados = 1;
        for(Forma a : this.formas){
            if(a instanceof Quadrado){
                System.out.printf("**Quadrado nº: %d\n", quadrados);
                System.out.printf("Area: %.2f unidade(s) de area\n\n", a.obterArea());
                quadrados++;
            }
        }
    }
    
    public void listarCirculos(){
        int circulos = 1;
        for(Forma a : this.formas){
            if(a instanceof Circulo){
                System.out.printf("**Circulo nº: %d\n", circulos);
                System.out.printf("Area: %.2f unidade(s) de area\n\n", a.obterArea());
                circulos++;
            }
        }
    }
    
    public void listarTetraedros(){
        int tetraedros = 1;
        for(Forma a : this.formas){
            if(a instanceof Tetraedro){
                System.out.printf("**Tetraedro nº: %d\n", tetraedros);
                System.out.printf("Area: %.2f unidade(s) de area\n", a.obterArea());
                System.out.printf("Volume: %.2f unidade(s) de volume\n\n", ((Tetraedro) a).obterVolume());
                tetraedros++;
            }
        }
    }
    
    public void listarCubos(){
        int cubos = 1;
        for(Forma a : this.formas){
            if(a instanceof Cubo){
                System.out.printf("**Cubo nº: %d\n", cubos);
                System.out.printf("Area: %.2f unidade(s) de area\n", a.obterArea());
                System.out.printf("Volume: %.2f unidade(s) de volume\n\n", ((Cubo) a).obterVolume());
                cubos++;
            }
        }
    }
    
    public void listarEsferas(){
        int esferas = 1;
        for(Forma a : this.formas){
            if(a instanceof Esfera){
                System.out.printf("**Esfera nº: %d\n", esferas);
                System.out.printf("Area: %.2f unidade(s) de area\n", a.obterArea());
                System.out.printf("Volume: %.2f unidade(s) de volume\n\n", ((Esfera) a).obterVolume());
                esferas++;
            }
        }
    }
}
