/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package complexfan;

/**
 * Esta clase modela un ComplexFan, implementa atributos, metodos y funciones para su manejo.
 * @author machz
 */
public class ComplexFan {
    private Interval magnitudeInterval;
    private AngleInterval angleInterval;
    
    /**
     * Constructor que inicializa el intervalo de magnitud y 
     * el intervalo de angulo con valores por default
     */
    public ComplexFan(){
        magnitudeInterval = new Interval();
        angleInterval = new AngleInterval();
    }
    /**
     * Constructor que inicializa el intervalo de magnitud y el intervalo de angulo
     * de acuerdo con los intervalos que recibe
     * @param mi el intervalo de magnitud a asignar
     * @param ai el intervalo de angulo a asignar
     */
    public ComplexFan(Interval mi, AngleInterval ai){
        magnitudeInterval = new Interval(mi);
        angleInterval = new AngleInterval(ai);
        /* cambios 30 de agosto
        if (mi.getFirstExtreme()<0&&mi.getSecondExtreme()<0){
            angleInterval = AngleInterval.add180toAI(ai);
        }
        else{
            angleInterval = new AngleInterval(ai);
        }
        fin cambios 30 de agosto */
        magnitudeInterval.normalize();
        angleInterval.normalize();
    }
    
    /**
     * Constructor que inicializa un ComplexFan a partir de otro ComplexFan
     * @param cf complex fan a copiar
     */
    public ComplexFan(ComplexFan cf){
        magnitudeInterval = new Interval(cf.getMagnitudeInterval());
        angleInterval = new AngleInterval(cf.getAngleInterval());
    }
    
    /**
     * Funcion para asignar el valor del atributo magnitudeInterval
     * @param mi el intervalo de magnitud que sera usado
     */
    public void setMagnitudeInterval(Interval mi){
        magnitudeInterval = new Interval(mi);
        magnitudeInterval.normalize();
    }
    
    /**
     * Funcion para asignar el valor del atributo angleInterval
     * @param ai el intervalo de angulo que sera usado
     */
    public void setAngleInterval(AngleInterval ai){
        angleInterval = new AngleInterval(ai);
        angleInterval.normalize();
    }
    
    /**
     * Funcion para obtener el intervalo de magnitud
     * @return el intervalo de magnitud
     */
    public Interval getMagnitudeInterval(){
        return magnitudeInterval;
    }
    
    /**
     * Funcion para obtener el intervalo de angulo
     * @return el intervalo de angulo
     */
    public AngleInterval getAngleInterval(){
        return angleInterval;
    }
    
    /**
     * Funcion para calcular la negacion de un ComplexFan
     * @param cf el ComplexFan que va a ser negado
     * @return el resultado de la negacion
     */
    public static ComplexFan negation(ComplexFan cf){
        return new ComplexFan(cf.getMagnitudeInterval(),AngleInterval.add180toAI(cf.getAngleInterval()));
    }
    
    /**
     * Funcion para calcular el producto entre dos ComplexFans
     * @param cf1 el primer operando para el producto
     * @param cf2 el segundo operando para el producto
     * @return el resultado del producto
     */
    public static ComplexFan product(ComplexFan cf1, ComplexFan cf2){
        return new ComplexFan(Interval.product(cf1.getMagnitudeInterval(), cf2.getMagnitudeInterval()), AngleInterval.addition(cf1.getAngleInterval(), cf2.getAngleInterval()));        
    } 
 
    /**
     * Funcion para calcular la division entre dos ComplexFans
     * @param cf1 el primer operando de la division
     * @param cf2 el segunto operando de la division
     * @return el resultado de la division
     */
    public static ComplexFan division(ComplexFan cf1, ComplexFan cf2){
        return new ComplexFan(Interval.division(cf1.getMagnitudeInterval(), cf2.getMagnitudeInterval()), AngleInterval.subtraction(cf1.getAngleInterval(), cf2.getAngleInterval()));
    }
    
    /**
     * Funcion para calcular la suma de dos complex fans
     * @param cf1 el primer operando de la suma
     * @param cf2 el segundo operando de la suma
     * @return el resultado de la suma
     */
    public static ComplexFan addition(ComplexFan cf1, ComplexFan cf2){
        AngleInterval ai1 = new AngleInterval(cf1.getAngleInterval());
        AngleInterval ai2 = new AngleInterval(cf2.getAngleInterval());
        ComplexFan acf1 = new ComplexFan(cf1);
        ComplexFan acf2 = new ComplexFan(cf2);
        double rotation = ai1.getFirstExtreme();
        if (rotation!=0.0){
            ai1.setFirstExtreme(ai1.getFirstExtreme()-rotation);
            ai1.setSecondExtreme(ai1.getSecondExtreme()-rotation);
            ai2.setFirstExtreme(ai2.getFirstExtreme()-rotation);
            ai2.setSecondExtreme(ai2.getSecondExtreme()-rotation);
            ai1.normalize();
            ai2.normalize();
            acf1.setAngleInterval(ai1);
            acf2.setAngleInterval(ai2);
        }
        ComplexFan []pcf1 = acf1.part();
        ComplexFan []pcf2 = acf2.part();
        if (pcf1==null){
            System.out.println("No se puede realizar la suma, ComplexFan no valido!: "+cf1.toString());
            System.exit(1);
        }
        if (pcf2==null){
            System.out.println("No se puede realizar la suma, ComplexFan no valido!: "+cf2.toString());
            System.exit(1);
        }
        ComplexFan res[] = new ComplexFan[pcf1.length*pcf2.length];
        for(int i=0; i<pcf1.length*pcf2.length; i++){
            res[i] = new ComplexFan();
        }
        int k=0;
		ComplexFan V1, V2;
        for(int i=0;i<pcf1.length;i++){
			
			for(int j=0;j<pcf2.length;j++){
				V1 = new ComplexFan(pcf1[i]);
				V2 = new ComplexFan(pcf2[j]);
                Interval mi1 = new Interval(V1.getMagnitudeInterval());
                Interval mi2 = new Interval(V2.getMagnitudeInterval());
                ai1 = new AngleInterval(V1.getAngleInterval());
                ai2 = new AngleInterval(V2.getAngleInterval());
                double rot1 = ai1.getFirstExtreme();
                if (rot1!=0.0){
                    ai1.setFirstExtreme(ai1.getFirstExtreme()-rot1);
                    ai1.setSecondExtreme(ai1.getSecondExtreme()-rot1);
                    ai2.setFirstExtreme(ai2.getFirstExtreme()-rot1);
                    ai2.setSecondExtreme(ai2.getSecondExtreme()-rot1);
                    ai1.normalize();
                    ai2.normalize();
                    V1.setAngleInterval(ai1);
                    V2.setAngleInterval(ai2);
                }
                int caso = V1.verifyCase(V2.getAngleInterval().getFirstExtreme(),V2.getAngleInterval().getSecondExtreme());
				ComplexFan aux = new ComplexFan();
                switch (caso) {
                    case 1:
                        aux = aux.additionCase1(V1, V2);
                        break;
                    case 2:
                        aux = aux.additionCase2(V1, V2);
                        break;
                    case 3:
                        aux = aux.additionCase3(V1, V2);
                        break;
                    default:
                        ai1 = V1.getAngleInterval();
                        ai2 = V2.getAngleInterval();
                        double rot2 = ai2.getFirstExtreme();
                        ai1.setFirstExtreme(ai1.getFirstExtreme()-rot2);
                        ai1.setSecondExtreme(ai1.getSecondExtreme()-rot2);
                        ai2.setFirstExtreme(ai2.getFirstExtreme()-rot2);
                        ai2.setSecondExtreme(ai2.getSecondExtreme()-rot2);
                        ai1.normalize();
                        ai2.normalize();
                        V1.setAngleInterval(ai1);
                        V2.setAngleInterval(ai2);
						aux = aux.additionCase2(V2, V1);
                        AngleInterval auxai = aux.getAngleInterval();
                        if (!auxai.VerifyCase0to360()){
                            auxai.setFirstExtreme(auxai.getFirstExtreme()+rot2);
                            auxai.setSecondExtreme(auxai.getSecondExtreme()+rot2);
                            auxai.normalize();
                            aux.setAngleInterval(auxai);
                        }
                        break;
                }
                AngleInterval auxai = aux.getAngleInterval();
                if (rot1!=0 && !auxai.VerifyCase0to360()){
                    auxai.setFirstExtreme(auxai.getFirstExtreme()+rot1);
                    auxai.setSecondExtreme(auxai.getSecondExtreme()+rot1);
                    auxai.normalize();
                    aux.setAngleInterval(auxai);
                }
                res[k] = aux;
                k++;
            }
        }
        ComplexFan total = unionOfResults(res);
        ai1 = total.getAngleInterval();
        if (rotation!=0 && !ai1.VerifyCase0to360()){
            ai1.setFirstExtreme(ai1.getFirstExtreme()+rotation);
            ai1.setSecondExtreme(ai1.getSecondExtreme()+rotation);
            ai1.normalize();
            total.setAngleInterval(ai1);
        }
        return total;
    }
    
    /**
     * Funcion para restar dos complex fans, notese que la resta
     * depende de la negacion del segundo complex fan y su suma con el primer complex fan
     * @param cf1 el primer operando de la resta
     * @param cf2 el segundo operando de la resta
     * @return el resultado de la resta
     */
    public static ComplexFan subtraction(ComplexFan cf1, ComplexFan cf2){
        ComplexFan negatedcf2 = ComplexFan.negation(cf2);
        return ComplexFan.addition(cf1, negatedcf2);
    }
    
    /**
     * Funcion para la union de los resultados parciales
     * @param acf la lista de complex fans resultantes
     * @return la union de los resultados parciales
     */
    private static ComplexFan unionOfResults(ComplexFan []acf){
        Interval []mis = new Interval[acf.length];
		for (int i=0; i<acf.length; i++){
            mis[i] = acf[i].getMagnitudeInterval();
        }
        Interval mi = unionOfMIs(mis);
        AngleInterval ai = unionOfAIs(acf);
		return new ComplexFan(mi, ai);
    }
    
    /**
     * Esta funcion realiza la union de los intervalos de angulo del arreglo
     * de complex fans que recibe
     * @param acf el arreglo de complex fans
     * @return el intervalo de angulo resultante
     */
    private static AngleInterval unionOfAIs(ComplexFan []acf){
		if (acf.length==1){
            return acf[0].getAngleInterval();
        }
        ComplexFan res[] = acf[0].part();
        ComplexFan rest[] = new ComplexFan[acf.length-1];
        for (int i=0; i<rest.length; i++){
            rest[i] = acf[i+1];
        }
        ComplexFan []pcf1;
        ComplexFan []pcf2;
        boolean union = false;
		while(true){
            for(int k=0; k<rest.length; k++){
				pcf1 = res;
                pcf2 = rest[k].part();
				AngleInterval c1 = new AngleInterval(0,90,'[',')');
                AngleInterval c2 = new AngleInterval(90,180,'[',')');
                AngleInterval c3 = new AngleInterval(180,270,'[',')');
                AngleInterval c4 = new AngleInterval(270,360,'[',']');
                boolean inters = false;
                int i, j;
                for(i=0; i<pcf1.length; i++){
                    for(j=0; j<pcf2.length; j++){

                        if (!Interval.intersection(pcf1[i].getAngleInterval(), pcf2[j].getAngleInterval()).isEmpty()){
                            inters = true;
                            break;
                        }
                    }
                    if (inters){
                        AngleInterval aux = new AngleInterval(Interval.union(pcf1[i].getAngleInterval(), pcf2[j].getAngleInterval()));
						ComplexFan []auxpcf1 = new ComplexFan[pcf1.length-1];
                        System.arraycopy(pcf1, 0, auxpcf1, 0, i);
                        System.arraycopy(pcf1, i+1, auxpcf1, i, auxpcf1.length-i);
                        
                        ComplexFan []auxpcf2 = new ComplexFan[pcf2.length-1];
                        System.arraycopy(pcf2, 0, auxpcf2, 0, j);
                        System.arraycopy(pcf2, j+1, auxpcf2, j, auxpcf2.length-j);
                        i = -1;
                        union = true;
                        inters = false;
                        pcf1 = auxpcf1;
                        System.arraycopy(auxpcf2, 0, pcf2, 0, auxpcf2.length);
                        pcf2[pcf2.length-1] = new ComplexFan(new Interval(), aux);
                    }
                }
                if (union){
                    res = new ComplexFan[pcf1.length+pcf2.length];
                    System.arraycopy(pcf1, 0, res, 0, pcf1.length);
                    System.arraycopy(pcf2, 0, res, pcf1.length, pcf2.length);
                    ComplexFan []auxrest = rest;
                    rest = new ComplexFan[auxrest.length-1];
                    System.arraycopy(auxrest, 0, rest, 0, k);
                    System.arraycopy(auxrest, k+1, rest, k, auxrest.length-k-1);
                    k = -1; 
                    union = false;
                    AngleInterval []lais = new AngleInterval[res.length];
                    for(int r=0; r<lais.length; r++){
                        lais[r] = res[r].getAngleInterval();
                    }
					if (AngleInterval.verifyCase0to360ofList(lais)){
                        return new AngleInterval(0.0, 360.0, '[', ']');
                    }
                }
                if (rest.length==0){
                    break;
                }
            }
            if (rest.length>0){
                ComplexFan aux2 = rest[0];
                ComplexFan auxrest[] = new ComplexFan[rest.length-1];
                System.arraycopy(rest, 1, auxrest, 0, auxrest.length);
                AngleInterval []lais = new AngleInterval[res.length];
                for(int r=0; r<lais.length; r++){
                    lais[r] = res[r].getAngleInterval();
                }
                AngleInterval auxai = AngleInterval.unionAIs(lais);
                System.arraycopy(auxrest, 0, rest, 0, auxrest.length);
                rest[rest.length-1] = new ComplexFan(new Interval(), auxai);
                res=aux2.part();
            }
            if (rest.length==0){
                break;
            }
        }
        AngleInterval []lais = new AngleInterval[res.length];
        for(int r=0; r<lais.length; r++){
            lais[r] = res[r].getAngleInterval();
        }
        return AngleInterval.unionAIs(lais);
    } 
    
    /**
     * Esta funcion une los intervalos de magnitud que recibe como argumento
     * @param mis el arreglo de intervalos de magnitud a unir
     * @return el resultado de la union
     */
    private static Interval unionOfMIs(Interval []mis){
        if (mis.length==1){
            return mis[0];
        }
        Interval res = mis[0];
        Interval []rest = new Interval[mis.length-1];
        Interval mi;
        for(int i=0; i<rest.length; i++){
            rest[i] = mis[i+1];
        }
        while(true){
            for(int i=0; i<rest.length; i++){
                mi = rest[i];
                if (!Interval.intersection(res, mi).isEmpty()){
                    res = Interval.union(res, mi);
                    Interval intarray[] = new Interval[rest.length-1];
                    for (int j=0; j<intarray.length; j++){
                        if (j==i){
                            i++;
                        }
                        intarray[j] = rest[i];
                    }
                    rest = intarray;
                    i = 0;
                }
            }
            if (rest.length>0){
                Interval aux = res;
                res = rest[0];
                Interval auxarray[] = rest;
                for(int i=1; i<=rest.length; i++){
                    if (i!=rest.length){
                        rest[i-1] = auxarray[i];
                    }else{
                        rest[i-1] = aux;
                    }
                }
            }else{
                break;
            }
        }
        return res;
    } 
    
    /**
     * Funcion para calcular la suma de dos complex fans, caso 3
     * @param cf1 el primer operando para la suma
     * @param cf2 el segundo operando para la suma
     * @return el complex fan resultante
     */
    private ComplexFan additionCase3(ComplexFan cf1, ComplexFan cf2){
        Interval mi = magnitudeCase3(cf1, cf2);
        AngleInterval ai = angleCase3(cf1, cf2);
        return new ComplexFan(mi, ai);
    }
    
    /**
     * Funcion para calcular el intervalo de magnitud para la suma de dos
     * complex fans que cae dentro del caso 3
     * @param cf1 el primer complex fan
     * @param cf2 el segundo complex fan
     * @return el intervalo de magnitud resultante
     */
    private Interval magnitudeCase3(ComplexFan cf1, ComplexFan cf2){
        Interval mi1 = new Interval(cf1.getMagnitudeInterval());
        AngleInterval ai1 = new AngleInterval(cf1.getAngleInterval());
        Interval mi2 = new Interval(cf2.getMagnitudeInterval());
        AngleInterval ai2 = new AngleInterval(cf2.getAngleInterval());
        double a = mi1.getFirstExtreme();
        double b = mi1.getSecondExtreme();
        double alfa1 = ai1.getFirstExtreme();
        double alfa2 = ai1.getSecondExtreme();
        double c = mi2.getFirstExtreme();
        double d = mi2.getSecondExtreme();
        double alfa3 = ai2.getFirstExtreme();
        double alfa4 = ai2.getSecondExtreme();
		double angulo1 = alfa3-alfa2;
        double angulo2 = 360 - (alfa4-alfa1);
        double e, f;
        if (angulo1<angulo2){
            f = Math.max(
                Math.max(
                    Math.sqrt(Math.pow(c*Math.cos(Math.toRadians(alfa3))+a*Math.cos(Math.toRadians(alfa2)),2)+Math.pow(c*Math.sin(Math.toRadians(alfa3))+a*Math.sin(Math.toRadians(alfa2)),2)),
                    Math.sqrt(Math.pow(d*Math.cos(Math.toRadians(alfa3))+a*Math.cos(Math.toRadians(alfa2)),2)+Math.pow(d*Math.sin(Math.toRadians(alfa3))+a*Math.sin(Math.toRadians(alfa2)),2))
                ),
                Math.max(
                    Math.sqrt(Math.pow(c*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa2)),2)+Math.pow(c*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa2)),2)),
                    Math.sqrt(Math.pow(d*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa2)),2)+Math.pow(d*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa2)),2))
                )
            );
        }
        else{
            f = Math.max(
                Math.max(
                    Math.sqrt(Math.pow(c*Math.cos(Math.toRadians(alfa4))+a*Math.cos(Math.toRadians(alfa1)),2)+Math.pow(c*Math.sin(Math.toRadians(alfa4))+a*Math.sin(Math.toRadians(alfa1)),2)),
                    Math.sqrt(Math.pow(d*Math.cos(Math.toRadians(alfa4))+a*Math.cos(Math.toRadians(alfa1)),2)+Math.pow(d*Math.sin(Math.toRadians(alfa4))+a*Math.sin(Math.toRadians(alfa1)),2))
                ),
                Math.max(
                    Math.sqrt(Math.pow(c*Math.cos(Math.toRadians(alfa4))+b*Math.cos(Math.toRadians(alfa1)),2)+Math.pow(c*Math.sin(Math.toRadians(alfa4))+b*Math.sin(Math.toRadians(alfa1)),2)),
                    Math.sqrt(Math.pow(d*Math.cos(Math.toRadians(alfa4))+b*Math.cos(Math.toRadians(alfa1)),2)+Math.pow(d*Math.sin(Math.toRadians(alfa4))+b*Math.sin(Math.toRadians(alfa1)),2))
                )
            );
        }
		Interval V1m = new Interval(mi1);
        Interval V2m = new Interval(mi2);
        Interval interseccion = Interval.intersection(V1m,V2m);
		double xm = 0.0d, ym = 0.0d;
        if (!interseccion.isEmpty()){
            xm = interseccion.getFirstExtreme();
            ym = xm;
        }
        else if (a>d){
            xm = a;
            ym = d;
        }
        else if (b<c){
            xm = b;
            ym = c;
        }
		e = Math.sqrt(Math.pow(xm,2)+Math.pow(ym,2)-2*xm*ym);
		return new Interval(e, f, '[', ']');
    }

    /**
     * Funcion para calcular el intervalo de angulo para la suma de 
     * dos complex fans que cae en el caso 3
     * @param cf1 el primer operando para la suma
     * @param cf2 el segundo operando para la suma
     * @return el intervalo de angulo resultante
     */
    private AngleInterval angleCase3(ComplexFan cf1, ComplexFan cf2){
        Interval mi1 = new Interval(cf1.getMagnitudeInterval());
        AngleInterval ai1 = new AngleInterval(cf1.getAngleInterval());
        Interval mi2 = new Interval(cf2.getMagnitudeInterval());
        AngleInterval ai2 = new AngleInterval(cf2.getAngleInterval());
        double a = mi1.getFirstExtreme();
        double b = mi1.getSecondExtreme();
        double alfa1 = ai1.getFirstExtreme();
        double alfa2 = ai1.getSecondExtreme();
        double c = mi2.getFirstExtreme();
        double d = mi2.getSecondExtreme();
        double alfa3 = ai2.getFirstExtreme();
        double alfa4 = ai2.getSecondExtreme();
        double alfa5, alfa6;
		double anguloMax = 180;
        Interval V1m = new Interval(mi1);
        Interval V2m = new Interval(mi2);
        V2m.byConstant(Math.cos(Math.toRadians(anguloMax)));
        Interval MagDiff = Interval.addition(V1m,V2m);
        AngleInterval V1a = new AngleInterval(ai1);
        AngleInterval V2a = new AngleInterval(ai2);
        Interval in1 = Interval.intersection(new Interval(0, 0, '[', ']'),MagDiff);
        double anguloy1, anguloo1;
        if (!in1.isEmpty()){
            alfa5=0;
            alfa6=360;
        }
        else if(MagDiff.getFirstExtreme()>0 && MagDiff.getSecondExtreme()>0){
            alfa6 = angleFixer(d*Math.cos(Math.toRadians(alfa3))+a*Math.cos(Math.toRadians(alfa2)), d*Math.sin(Math.toRadians(alfa3))+a*Math.sin(Math.toRadians(alfa2)));
            if (alfa6>90){
                anguloy1 = Math.toDegrees(Math.asin(d/a))+alfa2;
                anguloo1 = anguloy1 + 90;
                AngleInterval in2 = new AngleInterval(Interval.intersection(new AngleInterval(anguloo1, anguloo1, '[', ']'),V2a));
                if (!in2.isEmpty()){
                    alfa6 = anguloy1;
                }
                else if (anguloo1<alfa3){
                    alfa6 = angleFixer(d*Math.cos(Math.toRadians(alfa3))+a*Math.cos(Math.toRadians(alfa2)),d*Math.sin(Math.toRadians(alfa3))+a*Math.sin(Math.toRadians(alfa2)));
                }
                else if (anguloo1>alfa4){
                    alfa6 = angleFixer(d*Math.cos(Math.toRadians(alfa4))+a*Math.cos(Math.toRadians(alfa2)),d*Math.sin(Math.toRadians(alfa4))+a*Math.sin(Math.toRadians(alfa2)));
                }
            }
            alfa5 = angleFixer(d*Math.cos(Math.toRadians(alfa4))+a*Math.cos(Math.toRadians(alfa1)), d*Math.sin(Math.toRadians(alfa4))+a*Math.sin(Math.toRadians(alfa1)));
            if (alfa5>270){
                anguloy1 = 360 - Math.toDegrees(Math.asin(d/a));
                anguloo1 = anguloy1 - 90;
                AngleInterval in2 = new AngleInterval(Interval.intersection(new AngleInterval(anguloo1, anguloo1, '[', ']'),V2a));
                if (!in2.isEmpty()){
                    alfa5 = anguloy1;
                }
                else if (anguloo1<alfa3){
                    alfa5 = angleFixer(d*Math.cos(Math.toRadians(alfa3))+a*Math.cos(Math.toRadians(alfa1)), d*Math.sin(Math.toRadians(alfa3))+a*Math.sin(Math.toRadians(alfa1)));
                }
                else if (anguloo1>alfa4){
                    alfa5 = angleFixer(d*Math.cos(Math.toRadians(alfa4))+a*Math.cos(Math.toRadians(alfa1)), d*Math.sin(Math.toRadians(alfa4))+a*Math.sin(Math.toRadians(alfa1)));
                }
            }
        }
        else{
            alfa6 = angleFixer(c*Math.cos(Math.toRadians(alfa4))+b*Math.cos(Math.toRadians(alfa1)), c*Math.sin(Math.toRadians(alfa4))+b*Math.sin(Math.toRadians(alfa1)));
            if (alfa6>270){
                anguloy1 = alfa4 + Math.toDegrees(Math.asin(b/c));
                anguloo1 = AngleInterval.modulo360(anguloy1 + 90);
                AngleInterval in2 = new AngleInterval(Interval.intersection(new AngleInterval(anguloo1, anguloo1, '[', ']'),V1a));
                if (!in2.isEmpty()){
                    alfa6 = anguloy1;
                }
                else if (anguloo1<alfa1){
                    alfa6 = angleFixer(c*Math.cos(Math.toRadians(alfa4))+b*Math.cos(Math.toRadians(alfa1)), c*Math.sin(Math.toRadians(alfa4))+b*Math.sin(Math.toRadians(alfa1)));
                }
                else if (anguloo1>alfa2){
                    alfa6 = angleFixer(c*Math.cos(Math.toRadians(alfa4))+b*Math.cos(Math.toRadians(alfa2)), c*Math.sin(Math.toRadians(alfa4))+b*Math.sin(Math.toRadians(alfa2)));
                }
            }
            alfa5 = angleFixer(c*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa2)), c*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa2)));
            if (alfa5<180){
                anguloy1 = alfa3 - Math.toDegrees(Math.asin(b/c));
                anguloo1 = anguloy1 - 90;
                AngleInterval in2 = new AngleInterval(Interval.intersection(new AngleInterval(anguloo1, anguloo1, '[', ']'),V1a));
                if (!in2.isEmpty()){
                    alfa5 = anguloy1;
                }
                else if (anguloo1<alfa1){
                    alfa5 = angleFixer(c*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa1)), c*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa1)));
                }
                else if (anguloo1>alfa2){
                    alfa5 = angleFixer(c*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa2)),c*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa2)));
                }
            }	
        }
        return new AngleInterval(alfa5, alfa6, '[', ']');
    }

    
    /**
     * Funcion para calcular la suma de dos complex fans, caso 2
     * @param cf1 el primer operando para la suma
     * @param cf2 el segundo operando para la suma
     * @return el resultado de la suma
     */
    private ComplexFan additionCase2(ComplexFan cf1, ComplexFan cf2){
        Interval mi = magnitudeCase2(cf1, cf2);
        AngleInterval ai = angleCase2(cf1, cf2);
        return new ComplexFan(mi, ai);
    }
    
    /**
     * Funcion para calcular el intervalo de magnitud para una suma 
     * entre dos complex fans que caen en el caso 2
     * @param cf1 el primer operando de la suma
     * @param cf2 el segundo operando de la suma
     * @return el intervalo de magnitud resultante
     */
    private Interval magnitudeCase2(ComplexFan cf1, ComplexFan cf2){
        Interval mi1 = cf1.getMagnitudeInterval();
        Interval mi2 = cf2.getMagnitudeInterval();
        AngleInterval ai1 = cf1.getAngleInterval();
        AngleInterval ai2 = cf2.getAngleInterval();
        double a = mi1.getFirstExtreme();
        double b = mi1.getSecondExtreme();
        double c = mi2.getFirstExtreme();
        double d = mi2.getSecondExtreme();
        double alfa1 = ai1.getFirstExtreme();
        double alfa2 = ai1.getSecondExtreme();
        double alfa3 = ai2.getFirstExtreme();
        double alfa4 = ai2.getSecondExtreme();
        double anguloMin = alfa3-alfa2;
        double anguloMax = alfa4-alfa1;
        double f;
        if (anguloMin<=90){
            f = Math.sqrt(Math.pow(b, 2)+Math.pow(d, 2)+2*b*d*Math.cos(Math.toRadians(anguloMin)));
        }else{
            f = Math.max(
                Math.max(
                    Math.sqrt(Math.pow(c*Math.cos(Math.toRadians(alfa3))+a*Math.cos(Math.toRadians(alfa2)),2)+Math.pow(c*Math.sin(Math.toRadians(alfa3))+a*Math.sin(Math.toRadians(alfa2)),2)),
                    Math.sqrt(Math.pow(d*Math.cos(Math.toRadians(alfa3))+a*Math.cos(Math.toRadians(alfa2)),2)+Math.pow(d*Math.sin(Math.toRadians(alfa3))+a*Math.sin(Math.toRadians(alfa2)),2))
                ),
                Math.max(
                    Math.sqrt(Math.pow(c*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa2)),2)+Math.pow(c*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa2)),2)),
                    Math.sqrt(Math.pow(d*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa2)),2)+Math.pow(d*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa2)),2))
                )
            );
        }
        Interval V1m = new Interval(mi1);
        Interval V2m = new Interval(mi2);
        V2m.byConstant(Math.cos(Math.toRadians(anguloMax)));
        V2m = Interval.negation(V2m);
        Interval interseccion = Interval.intersection(V1m,V2m);
        double xm = 0.0d, ym = 0.0d;
        if (!interseccion.isEmpty()){
            xm = interseccion.getFirstExtreme();
        }
        else if (a>-d*Math.cos(Math.toRadians(anguloMax))){
            xm = a;
        }
        else if (b<-c*Math.cos(Math.toRadians(anguloMax))){
            xm = b;
        }
        V2m = new Interval(mi2);
        V1m.byConstant(Math.cos(Math.toRadians(anguloMax)));
        V1m = Interval.negation(V1m);
        interseccion = Interval.intersection(V2m,V1m);
        if (!interseccion.isEmpty()){
                ym = interseccion.getFirstExtreme();
        }
        else if (c>-b*Math.cos(Math.toRadians(anguloMax))){
                ym = c;
        }
        else if (d<-a*Math.cos(Math.toRadians(anguloMax))){
            ym = d;
        }
        double e = Math.sqrt(Math.pow(xm,2)+Math.pow(ym,2)+2*xm*ym*Math.cos(Math.toRadians(anguloMax)));
        return new Interval(e,f,'[',']');
    }
    
    /**
     * Funcion para calcular el intervalo de angulo resultante en la suma de
     * dos complex fans que caen en el caso 2
     * @param cf1 el primer operando para la suma
     * @param cf2 el segundo operando para la suma
     * @return el intervalo de angulo resultante
     */
    private AngleInterval angleCase2(ComplexFan cf1, ComplexFan cf2){
        Interval mi1 = new Interval(cf1.getMagnitudeInterval());
        AngleInterval ai1 = new AngleInterval(cf1.getAngleInterval());
        Interval mi2 = new Interval(cf2.getMagnitudeInterval());
        AngleInterval ai2 = new AngleInterval(cf2.getAngleInterval());
        double a = mi1.getFirstExtreme();
        double b = mi1.getSecondExtreme();
        double alfa1 = ai1.getFirstExtreme();
        double alfa2 = ai1.getSecondExtreme();
        double c = mi2.getFirstExtreme();
        double d = mi2.getSecondExtreme();
        double alfa3 = ai2.getFirstExtreme();
        double alfa4 = ai2.getSecondExtreme();
        double alfa5, alfa6;
        double aux1 = angleFixer(c*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa1)),c*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa1)));
        double aux2 = angleFixer(c*Math.cos(Math.toRadians(alfa4))+b*Math.cos(Math.toRadians(alfa1)),c*Math.sin(Math.toRadians(alfa4))+b*Math.sin(Math.toRadians(alfa1)));
        alfa5=Math.min(aux1,aux2);
        aux1 = angleFixer(d*Math.cos(Math.toRadians(alfa4))+a*Math.cos(Math.toRadians(alfa1)),d*Math.sin(Math.toRadians(alfa4))+a*Math.sin(Math.toRadians(alfa1)));
        aux2 = angleFixer(d*Math.cos(Math.toRadians(alfa4))+a*Math.cos(Math.toRadians(alfa2)),d*Math.sin(Math.toRadians(alfa4))+a*Math.sin(Math.toRadians(alfa2)));
        alfa6=Math.max(aux1,aux2);
        AngleInterval V1a = new AngleInterval(ai1);
        AngleInterval V2a = new AngleInterval(ai2);
        double anguloy, anguloo;
        AngleInterval interseccion;
        if (alfa6<90){
            anguloy = alfa2+Math.toDegrees(Math.asin(d/a));
            anguloo = anguloy+90;
            interseccion = new AngleInterval(Interval.intersection(new AngleInterval(anguloo, anguloo, '[', ']'),V2a));
            if (!interseccion.isEmpty()){
                alfa6 = anguloy;
            }
            else if (anguloo<alfa3){
                alfa6 = angleFixer(d*Math.cos(Math.toRadians(alfa3))+a*Math.cos(Math.toRadians(alfa2)),d*Math.sin(Math.toRadians(alfa3))+a*Math.sin(Math.toRadians(alfa2)));
            }
            else if (anguloo>alfa4){
                alfa6 = angleFixer(d*Math.cos(Math.toRadians(alfa4))+a*Math.cos(Math.toRadians(alfa2)),d*Math.sin(Math.toRadians(alfa4))+a*Math.sin(Math.toRadians(alfa2)));
            }
        }
        if (alfa5>90){
            anguloy = alfa3-Math.toDegrees(Math.asin(b/c));
            anguloo = anguloy-90;
            interseccion = new AngleInterval(Interval.intersection(new AngleInterval(anguloo, anguloo, '[', ']'),V1a));
            if (!interseccion.isEmpty()){
                // correccion del algoritmo de alfa5=anguloo a alfa5=anguloy
                alfa5 = anguloy;
            }
            else if (anguloo<alfa1){
                alfa5 = angleFixer(c*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa1)), c*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa1)));
            }
            else if (anguloo>alfa2){
                alfa5 = angleFixer(c*Math.cos(Math.toRadians(alfa3))+b*Math.cos(Math.toRadians(alfa2)), c*Math.sin(Math.toRadians(alfa3))+b*Math.sin(Math.toRadians(alfa2)));
            }
        }
        return new AngleInterval(alfa5, alfa6, '[', ']');
    }
    
    /**
     * Funcion para calcular la suma de dos complex fans, caso 1
     * @param cf1 el primer operando para la suma
     * @param cf2 el segundo operando para la suma
     * @return el complex fan resultante de la suma
     */
    private ComplexFan additionCase1(ComplexFan cf1, ComplexFan cf2){
        Interval mi1 = cf1.getMagnitudeInterval();
        Interval mi2 = cf2.getMagnitudeInterval();
        AngleInterval ai1 = cf1.getAngleInterval();
        AngleInterval ai2 = cf2.getAngleInterval();
        double a = mi1.getFirstExtreme();
        double b = mi1.getSecondExtreme();
        double c = mi2.getFirstExtreme();
        double d = mi2.getSecondExtreme();
        double alfa1 = ai1.getFirstExtreme();
        double alfa2 = ai1.getSecondExtreme();
        double alfa3 = ai2.getFirstExtreme();
        double alfa4 = ai2.getSecondExtreme();
		double anguloMin;
        if (alfa2>=alfa3){
            anguloMin = 0;
        }else{
            anguloMin = alfa2-alfa3;
        }
        double anguloMax = Math.max(alfa4-alfa1, alfa2-alfa3);
        double e = Math.sqrt(Math.pow(a, 2)+Math.pow(c, 2)+2*a*c*Math.cos(Math.toRadians(anguloMax)));
        double f = Math.sqrt(Math.pow(b, 2)+Math.pow(d, 2)+2*b*d*Math.cos(Math.toRadians(anguloMin)));
        double alfa5 = Math.atan((b*Math.sin(Math.toRadians(alfa1))+c*Math.sin(Math.toRadians(alfa3)))/(b*Math.cos(Math.toRadians(alfa1))+c*Math.cos(Math.toRadians(alfa3))));
        alfa5 = Math.toDegrees(alfa5);
        double alfa6;
        if (alfa2<alfa4){
            alfa6 = Math.atan((a*Math.sin(Math.toRadians(alfa2))+d*Math.sin(Math.toRadians(alfa4)))/(a*Math.cos(Math.toRadians(alfa2))+d*Math.cos(Math.toRadians(alfa4))));
        }
        else if (alfa2>alfa4){
            alfa6 = Math.atan((b*Math.sin(Math.toRadians(alfa2))+c*Math.sin(Math.toRadians(alfa4)))/(b*Math.cos(Math.toRadians(alfa2))+c*Math.cos(Math.toRadians(alfa4))));
        }
        else{
            alfa6 = Math.toRadians(alfa2);
        }
        alfa6 = Math.toDegrees(alfa6);
        return new ComplexFan(new Interval(e, f, '[', ']'), new AngleInterval(alfa5, alfa6, '[', ']'));
    }
    
    /**
     * Funcion para la correccion del angulo resultante cuando se suman dos vectores
     * @param x la componente en x
     * @param y la componente en y
     * @return el angulo resultante
     */
    private double angleFixer(double x, double y){
        double theta = 0.0d;
        if (x>=0&&y>0){
            if (x==0){
                theta = 90;
            }
            else{
                theta = Math.toDegrees(Math.atan(y/x));
            }
        }
        else if (x>=0&&y==0){
            //if (x==0){
            //    System.out.println("Division por cero!");
            //    System.exit(1);
            //}
            //else{
                theta = 0;
            //}
        }
        else if (x>=0&&y<0){
            if (x==0){
                theta = 270;
            }
            else{
                theta = 360-Math.toDegrees(Math.atan(Math.abs(y)/x));
            }
        }
        else if (x<0&&y>0){
            theta = 180-Math.toDegrees(Math.atan(y/Math.abs(x)));
        }
        else if (x<0&&y==0){
            theta = 180;
        }
        else if (x<0&&y<0){
            theta = 180+Math.toDegrees(Math.atan(Math.abs(y)/Math.abs(x)));
        }
        return theta;
    }
    
    /**
     * Funcion para verificar en que caso cae la suma de dos complex fans
     * @param alfa3 el primer extremo del intervalo de angulo del segundo ComplexFan
     * @param alfa4 el segundo extremo del intervalo de angulo del segundo ComplexFan
     * @return el numero de caso al cual cae la suma
     */
    public int verifyCase(double alfa3, double alfa4){
        if (alfa3>=0 && alfa4<=90){
            return 1;
        }
        else if (alfa3>=90 && alfa4<=180){
            return 2;
        }
        else if (alfa3>=180 && alfa4<=270){
            return 3;
        }
        else{
            return 4;
        }
    }
    
    /**
     * Esta funcion particiona un Complex Fan de acuerdo a su interseccion con el plano cartesiano
     * @return el vector de partes que componen el complex fan
     */
    public ComplexFan[] part(){
        double alfa1 = angleInterval.getFirstExtreme();
        double alfa2 = angleInterval.getSecondExtreme();
        char p1 = angleInterval.getFEincluded();
        char p2 = angleInterval.getSEincluded();
        ComplexFan c1 = new ComplexFan(magnitudeInterval,new AngleInterval(0,90,'[',')'));
        ComplexFan c2 = new ComplexFan(magnitudeInterval,new AngleInterval(90,180,'[',')'));
        ComplexFan c3 = new ComplexFan(magnitudeInterval,new AngleInterval(180,270,'[',')'));
        ComplexFan c4 = new ComplexFan(magnitudeInterval,new AngleInterval(270,360,'[',']'));
        ComplexFan []res = new ComplexFan[5];
        res[0] = new ComplexFan();
        res[1] = new ComplexFan();
        res[2] = new ComplexFan();
        res[3] = new ComplexFan();
        res[4] = new ComplexFan();
        if (alfa1<=90 && alfa2<=90 && alfa1>=0 && alfa2>=0){
            if (alfa2<alfa1){
                if (alfa2==90){
                    res[0] = new ComplexFan(magnitudeInterval,new AngleInterval(90,180,p1,')'));
                    res[1] = new ComplexFan(c3);
                    res[2] = new ComplexFan(c4);
                    res[3] = new ComplexFan(magnitudeInterval,new AngleInterval(0,alfa2,'[',p2));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval,new AngleInterval(alfa1,90,p1,')'));
                    res[1] = new ComplexFan(c2);
                    res[2] = new ComplexFan(c3);
                    res[3] = new ComplexFan(c4);
                    res[4] = new ComplexFan(magnitudeInterval,new AngleInterval(0,alfa2,'[',p2));
                }
            }
            else if (alfa2==alfa1){
                if (p1=='[' && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval,new AngleInterval(alfa1,alfa1,'[',']'));
                }
            }
            else{
                if (alfa2==90 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval,new AngleInterval(alfa1,90,p1,')'));
                    res[1] = new ComplexFan(magnitudeInterval,new AngleInterval(90,90,'[',']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval,new AngleInterval(alfa1,alfa2,p1,p2));
                }
            }
        }
        else if (alfa1<=180 && alfa2<=180 && alfa1>=90 && alfa2>=90){
            if (alfa2<alfa1){
                if (alfa1==180){
                    res[0] = new ComplexFan(magnitudeInterval,new AngleInterval(180,270,p1,')'));
                    res[1] = new ComplexFan(c4);
                    res[2] = new ComplexFan(c1);
                    res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(90,alfa2,'[',p2));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 180, p1, ')'));
                    res[1] = new ComplexFan(c3);
                    res[2] = new ComplexFan(c4);
                    res[3] = new ComplexFan(c1);
                    res[4] = new ComplexFan(magnitudeInterval, new AngleInterval(90,alfa2,'[',p2));
                 }
            }
            else if (alfa2==alfa1){
                if (p1=='[' && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, alfa1, '[', ']'));
                }
            }
            else{
                if (alfa2==180 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 180, p1, ')'));
                    res[1] = new ComplexFan(magnitudeInterval, new AngleInterval(180, 180, '[', ']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, alfa2, p1, p2));
                }
            }
        }
        else if (alfa1<=270 && alfa2<=270 && alfa1>=180 && alfa2>=180){
            if (alfa2<alfa1){
                if (alfa1==270){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(270, 360, p1, ']'));
                    res[1] = new ComplexFan(c1);
                    res[2] = new ComplexFan(c2);
                    res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(180, alfa2, '[',p2));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 270, p1, ')'));
                    res[1] = new ComplexFan(c4);
                    res[2] = new ComplexFan(c1);
                    res[3] = new ComplexFan(c2);
                    res[4] = new ComplexFan(magnitudeInterval, new AngleInterval(180, alfa2, '[', p2));
                }
            } else if (alfa2==alfa1){
                if (p1=='[' && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, alfa1, '[', ']'));
                }
            }else{
                if (alfa2==270 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 270, p1, ')'));
                    res[1] = new ComplexFan(magnitudeInterval, new AngleInterval(270, 270, '[', ']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, alfa2, p1, p2));
                }
            }
        }
        else if(alfa1<=360 && alfa2<=360 && alfa1>=270 && alfa2>=270){
            if (alfa2<alfa1){
                if (alfa1==0){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(0, 90, p1, ')'));
                    res[1] = new ComplexFan(c2);
                    res[2] = new ComplexFan(c3);
                    res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(270, alfa2, '[', p2));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 360, p1, ']'));
                    res[1] = new ComplexFan(c1);
                    res[2] = new ComplexFan(c2);
                    res[3] = new ComplexFan(c3);
                    res[4] = new ComplexFan(magnitudeInterval, new AngleInterval(270, alfa2, '[', p2));
                }
            }
            else if(alfa2==alfa1){
                if (p1=='[' && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, alfa1, '[', ']'));
                }
            }
            else{
                res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, alfa2, p1, p2));
            }
        }
        else if (alfa1>=0 && alfa1<90){
            if (alfa2>90 && alfa2<=180){
                if (alfa2==180 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 90, p1, ')'));
                    res[1] = new ComplexFan(c2);
                    res[2] = new ComplexFan(magnitudeInterval, new AngleInterval(180, 180, '[', ']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 90, p1, ')'));
                    res[1] = new ComplexFan(magnitudeInterval, new AngleInterval(90, alfa2, '[', p2));
                }
            }
            else if (alfa2>180 && alfa2<=270){
                if (alfa2==270 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 90, p1, ')'));
                    res[1] = new ComplexFan(c2);
                    res[2] = new ComplexFan(c3);
                    res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(270, 270, '[', ']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 90, p1, ')'));
                    res[1] = new ComplexFan(c2);
                    res[2] = new ComplexFan(magnitudeInterval, new AngleInterval(180, alfa2, '[', p2));
                }
            }
            else if (alfa2>270 && alfa2<=360){
                res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 90, p1, ')'));
                res[1] = new ComplexFan(c2);
                res[2] = new ComplexFan(c3);
                res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(270, alfa2, '[', p2));
            }
        }
        else if (alfa1>=90 && alfa1<180){
            if (alfa2>180 && alfa2<=270){
                if (alfa2==270 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 180, p1, ')'));
                    res[1] = new ComplexFan(c3);
                    res[2] = new ComplexFan(magnitudeInterval, new AngleInterval(270, 270, '[', ']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 180, p1, ')'));
                    res[1] = new ComplexFan(magnitudeInterval, new AngleInterval(180, alfa2, '[', p2));
                }
            }
            else if (alfa2>270 && alfa2<=360) {
                res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 180, p1, ')'));
                res[1] = new ComplexFan(c3);
                res[2] = new ComplexFan(magnitudeInterval, new AngleInterval(270, alfa2, '[', p2));
            }
            else if (alfa2>0 && alfa2<90){
                res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 180, p1, ')'));
                res[1] = new ComplexFan(c3);
                res[2] = new ComplexFan(c4);
                res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(0, alfa2, '[', p2));
            }
        }
        else if (alfa1>=180 && alfa1<270){
            if (alfa2>270 && alfa2<=360){
                res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 270, p1, ')'));
                res[1] = new ComplexFan(magnitudeInterval, new AngleInterval(270, alfa2, '[', p2));
            }
            else if (alfa2>0 && alfa2<=90){
                if (alfa2==90 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 270, p1, ')'));
                    res[1] = new ComplexFan(c4);
                    res[2] = new ComplexFan(c1);
                    res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(90, 90, '[', ']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 270, p1, ')'));
                    res[1] = new ComplexFan(c4);
                    res[2] = new ComplexFan(magnitudeInterval, new AngleInterval(0, alfa2, '[', p2));
                }
            }
            else if (alfa2>90 && alfa2<180){
                res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 270, p1, ')'));
                res[1] = new ComplexFan(c4);
                res[2] = new ComplexFan(c1);
                res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(90, alfa2, '[', p2));
            }
        }
        else if (alfa1>=270 && alfa1<360){
            if (alfa2>0 && alfa2<=90){
                if(alfa2==90 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 360, p1, ']'));
                    res[1] = new ComplexFan(c1);
                    res[2] = new ComplexFan(magnitudeInterval, new AngleInterval(90, 90, '[', ']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 360, p1, ']'));
                    res[1] = new ComplexFan(magnitudeInterval, new AngleInterval(0, alfa2, '[', p2));
                }
            }
            else if (alfa2>90 && alfa2<=180){
                if (alfa2==180 && p2==']'){
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 360, p1, ']'));
                    res[1] = new ComplexFan(c1);
                    res[2] = new ComplexFan(c2);
                    res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(180, 180, '[', ']'));
                }else{
                    res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 360, p1, ']'));
                    res[1] = new ComplexFan(c1);
                    res[2] = new ComplexFan(magnitudeInterval, new AngleInterval(90, alfa2, '[', p2));
                }
            }
            else if (alfa2>180 && alfa2<270){
                res[0] = new ComplexFan(magnitudeInterval, new AngleInterval(alfa1, 360, p1, ']'));
                res[1] = new ComplexFan(c1);
                res[2] = new ComplexFan(c2);
                res[3] = new ComplexFan(magnitudeInterval, new AngleInterval(180, alfa2, '[', p2));
            }
        }
        int counter=0;
        ComplexFan partes[];
        for (int i=0; i<5; i++){
            if (!res[i].isEmpty())
                counter++;
        }
        if (counter==0)
            return null;
        else{
            partes = new ComplexFan[counter];
            System.arraycopy(res, 0, partes, 0, counter);
            return partes;
        }
    }
    
    /**
     * Esta funcion verifica si un complex fan esta vacio
     * @return verdadero si el complex fan esta vacio, falso en caso contrario
     */
    public boolean isEmpty(){
        return magnitudeInterval.isEmpty() && angleInterval.isEmpty();
    }
    
    /**
     * Esto imprime la cadena de caracteres que representa a un ComplexFan
     */
    public void print(){
	System.out.println(toString());
    }

    /**
    *  Esto calcula la cadena de caracteres que representa a un Complex Fan
     * @return la cadena de caracteres que representa a un Complex Fan
    */
    @Override
    public String toString(){
        return ""+magnitudeInterval.toString()+"\u2220 "+angleInterval.toString();
        //return ""+magnitudeInterval.toString()+" ∟ "+angleInterval.toString();
    }   
}
