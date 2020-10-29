/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEstrella;

import java.util.ArrayList;
import java.util.Collections;
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
    private boolean TestDireccionesPares(){
    boolean res=false;
    Coordenada par = new Coordenada(2, 1);
    return res;
    }
    public int CalcularAEstrella(){
        
        /*
        if(Util.isEven(3)){
               System.out.println("No es par 3");
            }
            if(Util.isEven(4)){
                System.out.println("Es par 4");
            }
        if(Util.isOdd(5)){
            System.out.println("Es impar 5");
        }
        if(Util.isOdd(6)){
            System.out.println("Es impar 6");
        }*/
        

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
        //Direction.E, Direction.NE, Direction.NW, Direction.SE,Direction.SW, Direction.W, Direction.C
        EnumSet<Direction> enumset= EnumSet.of(Direction.E, Direction.NE, Direction.NW, Direction.SE,Direction.SW, Direction.W);
        //Comprobar EnumSet para filas pares e impares
        /*
        Coordenada impar = new Coordenada(5,5);
        Coordenada par = new Coordenada(2,2);
        //new Coordenada(result, result)
        int i=0;
        System.out.println("par "+par.y+","+par.x);
            char c= 'a';
        for(Direction d : enumset){
            
            i++;
            Coordenada aux=d.getNeighborCoordinates(par);
            System.out.println(i+" coordenada "+aux.y+","+aux.x);
            camino[aux.y][aux.x]=c;
            c++;
           
        }
        camino[par.y][par.x]='I';
        System.out.println("Camino");
        mostrarCamino();
        
        
         i=0;
         System.out.println("impar "+impar.y+","+impar.x);
        for(Direction d : enumset){
            c++;
            i++;
            Coordenada aux=d.getNeighborCoordinates(impar);
            System.out.println(i+" coordenada "+aux.y+","+aux.x);
            camino[aux.y][aux.x]=c;
           
        }
        camino[impar.y][impar.x]='P';
        System.out.println("Camino");
        mostrarCamino();
        */
        
        
        boolean sol=false;
        
      

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


