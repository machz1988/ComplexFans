/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package complexfan;

/**
 * Clase para realizar pruebas a la Clase AngleInterval
 * @author machz
 */
public class PruebasAngleInterval {
    /**
     * 
     * @param args los parametros de la linea de comandos
     */
    public static void main(String[] args){
        AngleInterval ai1 = new AngleInterval(179,180,'[',')');
        AngleInterval ai2 = new AngleInterval(180,270,'[',')');
		AngleInterval ai3 = new AngleInterval(270,280,'[',']');
		AngleInterval []lais = new AngleInterval[3];
		lais[0] = ai1;
		lais[1] = ai2;
		lais[2] = ai3;
        AngleInterval res = AngleInterval.unionAIs(lais);
        ai1.print();
        ai2.print();
		ai3.print();
        res.print();
        ai1.normalize();
        ai2.normalize();
        res = AngleInterval.subtraction(ai1, ai2);
        ai1.print();
        ai2.print();
        //res.subtractAngleIntervals(ai1,ai2);
        res.print();
        ai3 = AngleInterval.add180toAI(ai2);
        ai3.print();
        AngleInterval ai4 = new AngleInterval(0,360,'[',']');
        if(ai4.VerifyCase0to360()){
            System.out.println("Abarca de 0 a 360");
        }else{
            System.out.println("No abarca de 0 a 360");
        }
    }
}
