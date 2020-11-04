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
public enum Direction {
    //x columnas, y filas
    //even odd row
    //y xPar xImpar
    NW(-1,0,-1),
    NE(-1,1,0),
    W(0,-1,-1),
    E(0,1,1),
    SW(1,0,-1),
    SE(1,1,0),
    C(0,0,0);
    
    private final int incY;
    private final int incXEven;
    private final int incXOdd;
    private Direction(final int incI, final int incJEven, final int incJOdd) {
        this.incY = incI;
        this.incXEven = incJEven;
        this.incXOdd = incJOdd;
    }

    public int getIncRow() {
        return incY;
    }

    public int getIncColumnEven() {
        return incXEven;
    }

    public int getIncColumnOdd() {
        return incXOdd;
    }
    //probar funcio
    //agafa la coordenada y si es par suma la columna 0 i si es impar la columna 1;
    public Coordenada getNeighborCoordinates(Coordenada coor){
        int col= coor.x+(Util.isEven(coor.y) ? getIncColumnEven(): getIncColumnOdd());
        int row= coor.y+getIncRow();
        return new Coordenada(col,row);
    }
}
