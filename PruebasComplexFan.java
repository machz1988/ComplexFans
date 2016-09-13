/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package complexfan;

/**
 * Clase para realizar pruebas a la Clase ComplexFan
 * @author machz
 */
public class PruebasComplexFan {
    /**
     * Funcion para realizar algunas pruebas a la funcion part() de la Clase ComplexFan
     */
    public static void probarPart(){
        System.out.println("--------------Pruebas de particionado de CFs----------------");
        ComplexFan cf1 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(90,360,'(',']'));
	System.out.println("-----------------------------------");
	cf1.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf1 = cf1.part();
        if (pcf1!=null){
            for (ComplexFan cf : pcf1) {
                cf.print();
            }
        }
        ComplexFan cf2 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(90,270,'[',']'));
        System.out.println("-----------------------------------");
	cf2.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf2 = cf2.part();
        if (pcf2!=null){
            for (ComplexFan cf : pcf2){
                cf.print();
            }
        }
	ComplexFan cf3 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(10,89,'[',']'));
        System.out.println("-----------------------------------");
	cf3.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf3 = cf3.part();
        if (pcf3!=null){
            for (ComplexFan cf : pcf3){
                cf.print();
            }
        }
        ComplexFan cf4 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(15,160,'[',']'));
        System.out.println("-----------------------------------");
	cf4.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf4 = cf4.part();
        if (pcf4!=null){
            for (ComplexFan cf : pcf4){
                cf.print();
            }
        }
	ComplexFan cf5 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(56,250,'(',']'));
        System.out.println("-----------------------------------");
	cf5.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf5 = cf5.part();
        if (pcf5!=null){
            for (ComplexFan cf : pcf5){
                cf.print();
            }
        }
        ComplexFan cf6 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(37,340,'[',']'));
        System.out.println("-----------------------------------");
	cf6.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf6 = cf6.part();
        if (pcf6!=null){
            for (ComplexFan cf : pcf6){
                cf.print();
            }
        }
	ComplexFan cf7 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(80,30,'(',']'));
        System.out.println("-----------------------------------");
	cf7.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf7 = cf7.part();
        if (pcf7!=null){
            for (ComplexFan cf : pcf7){
                cf.print();
            }
        }
        ComplexFan cf8 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(99,170,'[',']'));
        System.out.println("-----------------------------------");
	cf8.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf8 = cf8.part();
        if (pcf8!=null){
            for (ComplexFan cf : pcf8){
                cf.print();
            }
        }
	ComplexFan cf9 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(110,230,'[',']'));
        System.out.println("-----------------------------------");
	cf9.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf9 = cf9.part();
        if (pcf9!=null){
            for (ComplexFan cf : pcf9){
                cf.print();
            }
        }
        ComplexFan cf10 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(130,320,'[',']'));
        System.out.println("-----------------------------------");
	cf10.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf10 = cf10.part();
        if (pcf10!=null){
            for (ComplexFan cf : pcf10){
                cf.print();
            }
        }
	ComplexFan cf11 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(139,70,'(',']'));
        System.out.println("-----------------------------------");
	cf11.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf11 = cf11.part();
        if (pcf11!=null){
            for (ComplexFan cf : pcf11){
                cf.print();
            }
        }
        ComplexFan cf12 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(120,110,'[',']'));
        System.out.println("-----------------------------------");
	cf12.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf12 = cf12.part();
        if (pcf12!=null){
            for (ComplexFan cf : pcf12){
                cf.print();
            }
        }
	ComplexFan cf13 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(200,260,'(',']'));
        System.out.println("-----------------------------------");
	cf13.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf13 = cf13.part();
        if (pcf13!=null){
            for (ComplexFan cf : pcf13){
                cf.print();
            }
        }
        ComplexFan cf14 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(190,330,'[',']'));
        System.out.println("-----------------------------------");
	cf14.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf14 = cf14.part();
        if (pcf14!=null){
            for (ComplexFan cf : pcf14){
                cf.print();
            }
        }
	ComplexFan cf15 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(210,27,'[',']'));
        System.out.println("-----------------------------------");
	cf15.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf15 = cf15.part();
        if (pcf15!=null){
            for (ComplexFan cf : pcf15){
                cf.print();
            }
        }
        ComplexFan cf16 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(194,130,'[',']'));
        System.out.println("-----------------------------------");
	cf16.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf16 = cf16.part();
        if (pcf16!=null){
            for (ComplexFan cf : pcf16){
                cf.print();
            }
        }
	ComplexFan cf17 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(250,210,'(',']'));
        System.out.println("-----------------------------------");
	cf17.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf17 = cf17.part();
        if (pcf17!=null){
            for (ComplexFan cf : pcf17){
                cf.print();
            }
        }
        ComplexFan cf18 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(290,340,'[',']'));
        System.out.println("-----------------------------------");
	cf18.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf18 = cf18.part();
        if (pcf18!=null){
            for (ComplexFan cf : pcf18){
                cf.print();
            }
        }
	ComplexFan cf19 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(298,27,'(',']'));
        System.out.println("-----------------------------------");
	cf19.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf19 = cf19.part();
        if (pcf19!=null){
            for (ComplexFan cf : pcf19){
                cf.print();
            }
        }
        ComplexFan cf20 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(343,136,'[',']'));
        System.out.println("-----------------------------------");
	cf20.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf20 = cf20.part();
        if (pcf20!=null){
            for (ComplexFan cf : pcf20){
                cf.print();
            }
        }
	ComplexFan cf21 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(290,220,'[',']'));
        System.out.println("-----------------------------------");
	cf21.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf21 = cf21.part();
        if (pcf21!=null){
            for (ComplexFan cf : pcf21){
                cf.print();
            }
        }
        ComplexFan cf22 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(346,274,'[',']'));
        System.out.println("-----------------------------------");
	cf22.print();
	System.out.println("-----partes-----");
        ComplexFan []pcf22 = cf22.part();
        if (pcf22!=null){
            for (ComplexFan cf : pcf22){
                cf.print();
            }
        }
    }
    
    /**
     * Funcion para realizar algunas pruebas a la funcion addition() de la Clase ComplexFan
     */
    public static void probarAddition(){
        System.out.println("-----------Pruebas Addition-----------");
        ComplexFan cf1 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(0,40,'[',']'));
        ComplexFan cf2 = new ComplexFan(new Interval(4,6,'[',']'), new AngleInterval(50,90,'[',']'));
        cf1.print();
        cf2.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr1 = ComplexFan.addition(cf1,cf2);
        cfr1.print();

        System.out.println("-----------Pruebas Addition-----------");
        ComplexFan cf3 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(0,70,'[',']'));
        ComplexFan cf4 = new ComplexFan(new Interval(4,6,'[',']'), new AngleInterval(30,70,'[',']'));
        cf3.print();
        cf4.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr2 = ComplexFan.addition(cf3,cf4);
        cfr2.print();

        System.out.println("-----------Pruebas Addition-----------");
        ComplexFan cf5 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(0,2,'[',']'));
        ComplexFan cf6 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(120,150,'[',']'));
        cf5.print();
        cf6.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr3 = ComplexFan.addition(cf5,cf6);
        cfr3.print();

        System.out.println("-----------Pruebas Addition-----------");
        ComplexFan cf7 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(0,1,'[',']'));
        ComplexFan cf8 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(180,270,'[',']'));
        cf7.print();
        cf8.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr4 = ComplexFan.addition(cf7,cf8);
        cfr4.print();

        System.out.println("-----------Pruebas Addition-----------");
        ComplexFan cf9 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(0,360,'[',']'));
        ComplexFan cf10 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(90,270,'[',']'));
        cf9.print();
        cf10.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr5 = ComplexFan.addition(cf9,cf10);
        cfr5.print();

        System.out.println("-----------Prueba Addition 6----------");
        ComplexFan cf11 = new ComplexFan(new Interval(22,24,'[',']'), new AngleInterval(180,90,'[',')'));
        ComplexFan cf12 = new ComplexFan(new Interval(2,4,'[',']'), new AngleInterval(90,180,'[',')'));
        cf11.print();
        cf12.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr6 = ComplexFan.addition(cf11,cf12);
        cfr6.print();

        System.out.println("-----------Prueba Addition 7----------");
        ComplexFan cf14 = new ComplexFan(new Interval(10,25,'[',']'), new AngleInterval(0,135,'[',']'));
        ComplexFan cf15 = new ComplexFan(new Interval(1,3,'[',']'), new AngleInterval(150,285,'[',')'));
        cf14.print();
        cf15.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr7 = ComplexFan.addition(cf14,cf15);
        cfr7.print();

        System.out.println("-----------Prueba Addition 8----------");
        ComplexFan cf16 = new ComplexFan(new Interval(10,25,'[',']'), new AngleInterval(0,135,'[',']'));
        ComplexFan cf17 = new ComplexFan(new Interval(13,15,'[',']'), new AngleInterval(150,285,'[',')'));
        cf16.print();
        cf17.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr8 = ComplexFan.addition(cf16,cf17);
        cfr8.print();

        System.out.println("-----------Prueba Addition 9----------");
        ComplexFan cf18 = new ComplexFan(new Interval(10,25,'[',']'), new AngleInterval(60,30,'[',']'));
        ComplexFan cf19 = new ComplexFan(new Interval(13,15,'[',']'), new AngleInterval(150,125,'[',')'));
        cf18.print();
        cf19.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr9 = ComplexFan.addition(cf18,cf19);
        cfr9.print();

        System.out.println("-----------Prueba Addition 10----------");
        ComplexFan cf20 = new ComplexFan(new Interval(10,25,'[',']'), new AngleInterval(30,80,'[',']'));
        ComplexFan cf21 = new ComplexFan(new Interval(7,18,'[',']'), new AngleInterval(110,175,'[',')'));
        cf20.print();
        cf21.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr10 = ComplexFan.addition(cf20,cf21);
        cfr10.print();

        System.out.println("-----------Prueba Addition 11----------");
        ComplexFan cf22 = new ComplexFan(new Interval(1,4,'[',']'), new AngleInterval(30,80,'[',']'));
        ComplexFan cf23 = new ComplexFan(new Interval(7,12,'[',']'), new AngleInterval(190,245,'[',')'));
        cf22.print();
        cf23.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfr11 = ComplexFan.addition(cf22,cf23);
        cfr11.print();
    }

    /**
     * Funcion para realizar algunas pruebas de aritmetica de ComplexFans
     */
    public static void probarAritmetica(){
        System.out.println("-----------Prueba Negacion-----------");
        ComplexFan V0 = new ComplexFan(new Interval('[',3,9,']'), new AngleInterval('[',90,180,']'));
        V0.print();
        System.out.println("-------Resultado-------");
        ComplexFan V0n = ComplexFan.negation(V0);
        V0n.print();

        System.out.println("-----------Prueba Producto-----------");
        ComplexFan V1 = new ComplexFan(new Interval('[',4,11,']'), new AngleInterval('[',90,180,']'));
        ComplexFan V2 = new ComplexFan(new Interval('[',7,15,']'), new AngleInterval('[',270,300,']'));
        V1.print();
        V2.print();
        System.out.println("-------Resultado-------");
        ComplexFan VR1 = ComplexFan.product(V1,V2);
        VR1.print();

        System.out.println("-----------Prueba Division-----------");
        ComplexFan V3 = new ComplexFan(new Interval('[',2,7,']'), new AngleInterval('[',35,78,']'));
        ComplexFan V4 = new ComplexFan(new Interval('[',1,5,']'), new AngleInterval('[',289,356,']'));
        V3.print();
        V4.print();
        System.out.println("-------Resultado-------");
        ComplexFan VR2 = ComplexFan.division(V3,V4);
        VR2.print();

        System.out.println("-----------Prueba Adicion 1-----------");
        ComplexFan V5 = new ComplexFan(new Interval('[',14,19,']'), new AngleInterval('[',0,44,']'));
        ComplexFan V6 = new ComplexFan(new Interval('[',11,17,']'), new AngleInterval('[',11,55,']'));
        V5.print();
        V6.print();
        System.out.println("-------Resultado-------");
        ComplexFan VR3 = ComplexFan.addition(V5,V6);
        VR3.print();

        System.out.println("-----------Prueba Addition 2-----------");
        ComplexFan V7 = new ComplexFan(new Interval('[',14,19,']'), new AngleInterval('[',0,44,']'));
        ComplexFan V8 = new ComplexFan(new Interval('[',11,17,']'), new AngleInterval('[',101,145,']'));
        V7.print();
        V8.print();
        System.out.println("-------Resultado-------");
        ComplexFan VR4 = ComplexFan.addition(V7,V8);
        VR4.print();

        System.out.println("-----------Prueba Addition 3-----------");
        ComplexFan V9 = new ComplexFan(new Interval('[',14,19,']'), new AngleInterval('[',0,44,']'));
        ComplexFan V10 = new ComplexFan(new Interval('[',11,17,']'), new AngleInterval('[',191,235,']'));
        V9.print();
        V10.print();
        System.out.println("-------Resultado-------");
        ComplexFan VR5 = ComplexFan.addition(V9,V10);
        VR5.print();

        System.out.println("-----------Prueba Sustraccion----------");
        ComplexFan V11 = new ComplexFan(new Interval('[',34,40,']'), new AngleInterval('[',123,213,']'));
        ComplexFan V12 = new ComplexFan(new Interval('[',24,45,']'), new AngleInterval('[',13,99,']'));
        V11.print();
        V12.print();
        System.out.println("-------Resultado-------");
        ComplexFan VR6 = ComplexFan.subtraction(V11,V12);
        VR6.print();
    }

    /**
     * Funcion para realizar algunas pruebas de aplicaciones fisicas de ComplexFans
     */

    public static void probarAplicaciones(){
        System.out.println("-----------Suma de A, B y C-----------");
        ComplexFan A = new ComplexFan(new Interval('[',50,50,']'), new AngleInterval('[',0,0,']'));
        ComplexFan B = new ComplexFan(new Interval('[',30,30,']'), new AngleInterval('[',90,90,']'));
        ComplexFan C = new ComplexFan(new Interval('[',25,25,']'), new AngleInterval('[',60,60,']'));
        A.print();
        B.print();
        C.print();
        System.out.println("-------Resultado-------");
        ComplexFan R = ComplexFan.addition(A,B);
        R = ComplexFan.addition(R,C);
        R.print();

        System.out.println("-----------Suma de cfA, cfB y cfC-----------");
        ComplexFan cfA = new ComplexFan(new Interval('[',49,51,']'), new AngleInterval('[',-3,3,']'));
        ComplexFan cfB = new ComplexFan(new Interval('[',29.4,30.6,']'), new AngleInterval('[',87,93,']'));
        ComplexFan cfC = new ComplexFan(new Interval('[',24.5,25.5,']'), new AngleInterval('[',57,63,']'));
        cfA.print();
        cfB.print();
        cfC.print();
        System.out.println("-------Resultado-------");
        ComplexFan cfR = ComplexFan.addition(cfA,cfB);
        cfR = ComplexFan.addition(cfR,cfC);
        cfR.print();
    }

    public static void analizarCircuito(){
        System.out.println("-----------Datos-----------");
        ComplexFan V = new ComplexFan(new Interval('[',20,20,']'), new AngleInterval('[',345,345,']'));
        ComplexFan ZR = new ComplexFan(new Interval('[',57,63,']'), new AngleInterval('[',0,0,']'));
        ComplexFan ZC = new ComplexFan(new Interval('[',24.2718, 25.7732,']'), new AngleInterval('[',270,270,']'));
        ComplexFan ZL = new ComplexFan(new Interval('[',19.6, 20.4,']'), new AngleInterval('[',90,90,']'));
        System.out.println("V = "+V.toString());
        System.out.println("ZR = "+ZR.toString());
        System.out.println("ZC = "+ZC.toString());
        System.out.println("ZL = "+ZL.toString());
        System.out.println("-------Resultados-------");
        ComplexFan Z1 = ComplexFan.division(ComplexFan.product(ZL,ZC),ComplexFan.addition(ZL,ZC));
        ComplexFan Z = ComplexFan.addition(ZR,Z1);
        ComplexFan I = ComplexFan.division(V,Z);
        System.out.println("Z1 = "+Z1.toString());
        System.out.println("Z = "+Z.toString());
        System.out.println("I = "+I.toString());
        ComplexFan VZ1 = ComplexFan.product(I,Z1);
        ComplexFan VZR = ComplexFan.product(I,ZR);
        ComplexFan VZC = new ComplexFan(VZ1);
        ComplexFan VZL = new ComplexFan(VZ1);
        System.out.println("VZR = "+VZR.toString());
        System.out.println("VZ1 = VZC = VZL = "+VZ1.toString());
        ComplexFan IZR = new ComplexFan(I);
        ComplexFan IZC = ComplexFan.division(VZ1,ZC);
        ComplexFan IZL = ComplexFan.division(VZ1,ZL);
        System.out.println("IZR = I = "+IZR.toString());
        System.out.println("IZC = "+IZC.toString());
        System.out.println("IZL = "+IZL.toString());
    }

    /**
     * @param args los parametros de la linea de comandos
     */
    public static void main(String[] args) {
        // Realizar pruebas a la funcion part()
    	//PruebasComplexFan.probarPart();
        // Realizar pruebas a la funcion addition()
        //PruebasComplexFan.probarAddition();
        // Probar aritmetica de complex fans
        PruebasComplexFan.probarAritmetica();
        //PruebasComplexFan.probarAplicaciones();
        //PruebasComplexFan.analizarCircuito();
    }
}
