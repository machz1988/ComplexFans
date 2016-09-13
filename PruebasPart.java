public class PruebasPart{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
} 
