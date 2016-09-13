class PruebasMI{
	public static void main(String []args){
		Interval mi = new Interval(-10,-15,'[',']');
		AngleInterval ai = new AngleInterval(45,80,'[',']');
		mi.print();
		ai.print();
		ComplexFan cf = new ComplexFan(mi,ai);
		cf.print();

		Interval mi2 = new Interval(-10,-15,'[',']');
		AngleInterval ai2 = new AngleInterval(225,260,'[',']');
		mi2.print();
		ai2.print();
		ComplexFan cf2 = new ComplexFan(mi2,ai2);
		cf2.print();
	}

}