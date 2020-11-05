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
            case 'd':
                res=1;
                break;
            case 'k':
                res=0;
                break;
            default:
                res=1;
                break;
        }
        return res;
    }
    public static double manhattan(Coordenada destino, Coordenada inicio){
        double res=0.0;
            res=Math.abs(destino.x-inicio.x)+Math.abs(destino.y-inicio.y);
        return res;
    }
    public static int manhattanI(Coordenada destino, Coordenada inicio){
        int res=0;
            res=Math.abs(destino.x-inicio.x)+Math.abs(destino.y-inicio.y);
        return res;
    }
    public static double euclidea(Coordenada destino, Coordenada inicio){
        double res=0.0;
            res=Math.sqrt(Math.pow(destino.x-inicio.x,2)+Math.pow(destino.y-inicio.y,2));
        return res;
    }
    public static int trivial(){
        return 1;
    }
    public static Cube offsetToCubeEvenQ(Coordenada hex){
        int x, y, z;
        x = hex.x;
        z = hex.y - (hex.x + (hex.y&1))/2;
        y = -hex.x - z;
        return new Cube(x ,y ,z );
    }
    public static Cube offsetToCubeOddQ(Coordenada hex){
        int x, y, z;
        x = hex.x;
        z = hex.y - (hex.x - (hex.y&1))/2;
        y = -hex.x - z;
        return new Cube(x ,y ,z );
    }
    public static Cube offsetToCubeEven(Coordenada hex){
        Cube res= new Cube();
            res.y = hex.x - (hex.y + (hex.y&1))/2;
            res.z = hex.y;
            res.x = -hex.x - res.z;
        return res;
    }
    public static Cube offsetToCubeOdd(Coordenada hex){
        Cube res= new Cube();
            res.x = hex.x - (hex.y - (hex.y&1))/2;
            res.z = hex.y;
            res.y = -hex.x - res.z;
        return res;
    }
    public static Coordenada cubeToOffset(Cube cube){
        Coordenada c = new Coordenada();
            c.x = cube.x + (cube.z + (cube.z&1)) / 2;
            c.y = cube.z;
        return c;
    }
    public static Cube evenr_to_cube(Coordenada hex){
    int x = hex.x - (hex.y + (hex.y&1)) / 2;
    int z = hex.y;
    int y = -x-z;
    return new Cube(x, y, z);
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
    public static double cubeDistance(Cube destino, Cube inicio){
        return Math.max(Math.max(Math.abs(destino.x-inicio.x),Math.abs(destino.y-inicio.y)),Math.abs(destino.z-inicio.z));
    }
}
