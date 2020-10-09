/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEstrella;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


/**
 *
 * @author mirse
 */

public class AEstrella {
 
    
    //Mundo sobre el que se debe calcular A*
    Mundo mundo;
    
    //Camino
    public char camino[][];
    
    //Casillas expandidas
    int camino_expandido[][];
    
    //Número de nodos expandidos
    int expandidos;
    
    //Coste del camino
    float coste_total;
    
    public AEstrella(){
        expandidos = 0;
        mundo = new Mundo();
    }
    
    public AEstrella(Mundo m){
        //Copia el mundo que le llega por parámetro
        mundo = new Mundo(m);
        camino = new char[m.tamanyo_y][m.tamanyo_x];
        camino_expandido = new int[m.tamanyo_y][m.tamanyo_x];
        expandidos = 0;
        
        //Inicializa las variables camino y camino_expandidos donde el A* debe incluir el resultado
            for(int i=0;i<m.tamanyo_x;i++)
                for(int j=0;j<m.tamanyo_y;j++){
                    camino[j][i] = '.';
                    camino_expandido[j][i] = -1;
                }
    }
    
    //Calcula el A*
    public int CalcularAEstrella(){

        boolean encontrado = false;
        int result = -1;
        
        //AQUÍ ES DONDE SE DEBE IMPLEMENTAR A*
        Node expandir;
        //listaExplorados.
        List<Node> listaInterior = new ArrayList<>();
        //ListaPorExplorar
        List<Node> listaFrontera = new ArrayList<>();
        //Añadir Nodo Innicial a lista Frontera.
        listaFrontera.add(new Node(mundo.getCaballero(),null,0,0,0));
        //bucle
        Coordenada caballero=mundo.getCaballero();
        Coordenada dragon=mundo.getDragon();
        EnumSet<Direction> enumset= EnumSet.of(Direction.E, Direction.NE, Direction.NW, Direction.SE,Direction.SW, Direction.W);
        boolean sol=false;
        while(!listaFrontera.isEmpty()&&!sol){
            Node auxNode= listaFrontera.remove(0);
            listaInterior.add(auxNode);
            //encontrar dragon, Cambiar a letra
            if(mundo.mundo[auxNode.cor.y][auxNode.cor.x]=='d'){
                //Node meta.
                //reconstruir cami.
                sol=true;
            }
            else{
                //expandir 
                for(Direction dir: enumset){
                    Coordenada auxCor= dir.getNeighborCoordinates(auxNode.cor);
                    //Comprobamos que este en el mapa.
                    int x,y;
                    x=auxCor.x;
                    y=auxCor.y;
                    //int tamanyo_x;
                    //int tamanyo_y;
                    int h=1;
                    //dentro del tablero
                    if(x<mundo.tamanyo_x&&x>=0&&y<mundo.tamanyo_y&&y>=0){
                        char c= mundo.mundo[y][x];
                        //System.out.println(c);
                        //valores recorribles
                        if(!(c=='b'||c=='p')){
                            System.out.println(c);
                            int w=Util.calcularPeso(c);
                            Node aux= new Node(auxCor,auxNode,auxNode.g,h,w);
                            System.out.println(w);
                        }
                    }
                    
                   /* if(x<mundo.tamanyo_x&&x>=0&&y<mundo.tamanyo_y&&y>=0){
                        char c= mundo.mundo[y][x];
                        
                        if(!(c=='p'||c=='b')){
                            int w=Util.calcularPeso(c);
                            Node aux= new Node(auxCor, auxNode,auxNode.g,h,w);
                            if(!listaInterior.contains(aux)){
                                if(listaFrontera.contains(aux)){
                                    Node aux2=listaInterior.get(listaInterior.indexOf(aux));
                                    
                                    
                                }
                            else{
                                listaFrontera.add(aux);
                            }
                            }
                        }
                    }*/
                }
            }
            
            
            
        }
      

        //Si ha encontrado la solución, es decir, el camino, muestra las matrices camino y camino_expandidos y el número de nodos expandidos
        if(encontrado){
            //Mostrar las soluciones
            System.out.println("Camino");
            mostrarCamino();

            System.out.println("Camino explorado");
            mostrarCaminoExpandido();
            
            System.out.println("Nodos expandidos: "+expandidos);
        }

        return result;
    }
    
    
    
   
    
    //Muestra la matriz que contendrá el camino después de calcular A*
    public void mostrarCamino(){
        for (int i=0; i<mundo.tamanyo_y; i++){
            if(i%2==0)
                System.out.print(" ");
            for(int j=0;j<mundo.tamanyo_x; j++){
                System.out.print(camino[i][j]+" ");
            }
            System.out.println();   
        }
    }
    
    //Muestra la matriz que contendrá el orden de los nodos expandidos después de calcular A*
    public void mostrarCaminoExpandido(){
        for (int i=0; i<mundo.tamanyo_y; i++){
            if(i%2==0)
                    System.out.print(" ");
            for(int j=0;j<mundo.tamanyo_x; j++){
                if(camino_expandido[i][j]>-1 && camino_expandido[i][j]<10)
                    System.out.print(" ");
                System.out.print(camino_expandido[i][j]+" ");
            }
            System.out.println();   
        }
    }
    
    public void reiniciarAEstrella(Mundo m){
        //Copia el mundo que le llega por parámetro
        mundo = new Mundo(m);
        camino = new char[m.tamanyo_y][m.tamanyo_x];
        camino_expandido = new int[m.tamanyo_y][m.tamanyo_x];
        expandidos = 0;
        
        //Inicializa las variables camino y camino_expandidos donde el A* debe incluir el resultado
            for(int i=0;i<m.tamanyo_x;i++)
                for(int j=0;j<m.tamanyo_y;j++){
                    camino[j][i] = '.';
                    camino_expandido[j][i] = -1;
                }
    }
    
    public float getCosteTotal(){
        return coste_total;
    }
}


