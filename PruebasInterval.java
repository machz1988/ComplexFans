/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package complexfan;

/**
 * Clase para realizar pruebas a la clase Interval
 * @author machz
 */
public class PruebasInterval {
    /**
     * 
     * @param args los parametros de la linea de comandos
     */
    public static void main(String[] args){
        Interval in1 = new Interval(180,270,'[',']');
        //in1.normalize();
        //in1.byConstant(-5);
        Interval in2 = new Interval(295,110,'(',']');
        //in2.normalize();
        Interval res = Interval.intersection(in1,in2);
        in1.print();
        in2.print();
        res.print();
        //Interval in3 = new Interval(8,8,'(',']');
        if (res.isEmpty()){
            System.out.println("Esta vacío!");
        }
        
        Interval in3 = Interval.subtraction(in1,in2);
        in3.print();
    }
}
