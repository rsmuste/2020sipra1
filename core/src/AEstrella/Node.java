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
public class Node implements Comparable{
    Coordenada cor;
    Node pare= null;
    double f;
    double h;
    double g;
    //revisar si es necesario aqui.

    public Node(Coordenada c, Node p, double g, double h, int w){
    cor=c;
    pare=p;
    this.h=h;
    this.g=g+w;
    this.f=this.g+this.h;
    }
    @Override
    public int compareTo(Object o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //comprobar que o es un node.
        Node n;
        int res=0;
        if(o instanceof Node){
            n= (Node)o;
            if(n.f==this.f){
                res=0;
            }
            else if(n.f>this.f){
                res=-1;
            }
            else{
                res=1;
            }
        }
        return res;
        
    }
    @Override
    public boolean equals(Object o){
        boolean b=false;
        if(o==this){
            return true;
        }
        if(!(o instanceof Node)||o==null){
            return false;
        }
        Node n = (Node)o;
        //boolean nCode = ( this.)
        return n.cor.getX()==this.cor.getX() && n.cor.getY()==this.cor.getY();
        //return b;
        
    }
    
    //Formula de de distancias para h. Crearlas estaticas en util.
    
}
