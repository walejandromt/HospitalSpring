package fechaMX;


public class Dias{
	private int dia;
	private String odia;
	private int mes;
	private String oMes;
	
	public Dias(){}

	public String cOrdina(int dia){
		//System.out.println("dia " + dia);
		 String[] a;
 			   a = new String[31];
	    a[0] = "1ro"; a[1] = "2do"; a[2] = "3ro"; a[3] = "4to"; a[4] = "5to"; a[5] = "6to"; a[6] = "7mo"; a[7] = "8vo"; a[8] = "9no"; a[9] = "10mo";
        a[10] = "11vo"; a[11] = "12do"; a[12] = "13vo"; a[13] = "14vo"; a[14] = "15vo"; a[15] = "16vo"; a[16] = "17vo"; a[17] = "18vo"; a[18] = "19vo"; 
        a[19] = "20mo";
        a[20] = "21vo"; a[21] = "22vo"; a[22] = "23vo"; a[23] = "24vo"; a[24] = "25vo"; a[25] = "26vo"; a[26] = "27vo"; a[27] = "28vo"; a[28] = "29vo";
    	a[29] = "30ma"; a[30] = "31vo";
    	 odia = a[dia-1] + " ";
    	return odia;
	}

	public String coMes(int mes){
		//System.out.println("mes " + mes);
		String[] a;
 		a = new String[12];
	    a[0] = "Enero"; a[1] = "Febrero"; a[2] = "Marzo"; a[3] = "Abril"; a[4] = "Mayo"; a[5] = "Junio"; a[6] = "Julio"; 
	    a[7] = "Agosto"; a[8] = "Septiembre"; a[9] = "Octubre"; a[10] = "Noviembre"; a[11] = "Diciembre";
       
    	return a[mes-1] + " ";
	}
}