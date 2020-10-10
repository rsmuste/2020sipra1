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
    NE(0,1,1),
    NW(-1,0,1),
    E(1,1,0),
    SE(0,1,-1),
    SW(-1,0,1),
    W(-1,-1,0),
    C(0,0,0);
    
    private final int incRow;
    private final int incColumnEven;
    private final int incColumnOdd;
    private Direction(final int incJEven, final int incJOdd,final int incI) {
        this.incRow = incI;
        this.incColumnEven = incJEven;
        this.incColumnOdd = incJOdd;
    }

    public int getIncRow() {
        return incRow;
    }

    public int getIncColumnEven() {
        return incColumnEven;
    }

    public int getIncColumnOdd() {
        return incColumnOdd;
    }
    //probar funcio
    //agafa la coordenada y si es par suma la columna 0 i si es impar la columna 1;
    public Coordenada getNeighborCoordinates(Coordenada coor){
        int col= coor.x+(Util.isEven(coor.x) ? getIncColumnEven(): getIncColumnOdd());
        int row= coor.y+getIncRow();
        return new Coordenada(col,row);
    }
}
