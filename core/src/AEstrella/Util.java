/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEstrella;

/**
 *
 * @author rober
 */
public class Util {
    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
    public static int calcularPeso(char c){
        int res=0;
        switch(c){
            case 'c':
                res=1;
                break;
            case 'h':
                res=2;
                break;
            case 'a':
                res=3;
                break;
            default:
                res=0;
                break;
        }
        return res;
    }
    public static double manhattan(Coordenada destino, Coordenada inicio){
        double res=0.0;
            res=Math.abs(destino.x-inicio.x)+Math.abs(destino.y-inicio.y);
        return res;
    }
    public static double euclidea(Coordenada destino, Coordenada inicio){
        double res=0.0;
            res=Math.sqrt(Math.pow(destino.x-inicio.x,2)+Math.pow(destino.y-inicio.y,2));
        return res;
    }
    public static Cube offsetToCube(Coordenada hex){
        Cube res= new Cube();
            res.x= hex.x - (hex.y + (hex.y&1))/2;
            res.z = hex.y;
            res.y = -hex.x - hex.y;
        return res;
    }
    public static Coordenada cubeToOffset(Cube cube){
        Coordenada c = new Coordenada();
            c.x = cube.x + (cube.z + (cube.z&1)) / 2;
            c.y = cube.z;
        return c;
    }
    public static double cubeManhattan(Cube destino, Cube inicio){
        double res=0;
            res = (Math.abs(destino.x-inicio.x)+Math.abs(destino.y-inicio.y)+Math.abs(destino.z-inicio.z)) / 2;
        return res;
    }
    public static double cubeEuclidea(Cube destino, Cube inicio){
        double res = 0;
        
        return res;
    }
}
