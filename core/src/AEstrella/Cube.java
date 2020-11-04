/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEstrella;

/**
 *
 * @author mirse
 */
public class Cube {
    int x;
    int y;
    int z;
    
    public Cube(){
        x = 0;
        y = 0;
        z = 0;
    }
    
    public Cube(int coordx, int coordy, int coordz){
        x = coordx;
        y = coordy;
        z = coordz;
    }
    
    public Cube(Cube c){
        x = c.x;
        y = c.y;
        z = c.z;
    }
    
    public void set(Cube c){
        x = c.x;
        y = c.y;
        z = c.z;
    }
    
    public void set(int coordx, int coordy, int coordz){
        x = coordx;
        y = coordy;
        z = coordz;
    }
   
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    public int getZ(){
        return z;
    }
    
}
