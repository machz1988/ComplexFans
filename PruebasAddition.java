public class PruebasAddition{
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

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
}
