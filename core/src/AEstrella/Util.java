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
            case 'b':
                res=-1;
                break;
            case 'c':
                res=1;
                break;
            case 'h':
                res=2;
                break;
            case 'a':
                res=3;
                break;
            case 'p':
                res=-1;
                break;
            default:
                res=-1;
                break;
        }
        return res;
    }
}
