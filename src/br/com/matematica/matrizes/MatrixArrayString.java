package br.com.matematica.matrizes;

public class MatrixArrayString {

	private static final String MULTIPLICACAO = "*"; 
	private static final String VARIAVEL = "x"; 
	static int dimensao = 2;

	static String[][] matrix = new String[3][3];
	static String[][] matrixResult1 = new String[3][3];
	static String[][] matrixResult2 = new String[3][3];

	static String[][] matrixIdentidade; 


	public static void main(String[] args) {
		matrix[0][0] = "3";
		matrix[0][1] = "2";
		matrix[0][2] = "7";
		matrix[1][0] = "9";
		matrix[1][1] = "1";
		matrix[1][2] = "0";
		matrix[2][0] = "2";
		matrix[2][1] = "2";
		matrix[2][2] = "5";
		
		int x = 0; //importante!
		String a = "-5";
		String b = "5+4x";
		
		//----antes de tudo
		String[] a1Value = a.split("-");
		String[] a2Value = a.split("\\+");
		int tamanhoA = a1Value.length + a2Value.length;
		if( (a1Value[0].matches("") || a1Value[1].matches("")) ||
				(a2Value[0].matches("") || a2Value[1].matches(""))){
			tamanhoA--;
		}

		String[] b1Value = b.split("-");
		String[] b2Value = b.split("\\+");
		int tamanhoB = b1Value.length + b2Value.length;
		if((b1Value[0].isEmpty() || b1Value[1].isEmpty()) ||
				(b2Value[0].isEmpty() || b2Value[1].isEmpty())) {
			tamanhoB--;
		}
		
		if(tamanhoA > 2) { //significa q é um numero apenas (c/ ou s/ "x")
			if(!a.startsWith("+") && !a.startsWith("-")){
				a = "+"+a;
			}			
		}
		
		if(tamanhoB > 2) { //significa q é um numero apenas (c/ ou s/ "x")
			if(!b.startsWith("+") && !b.startsWith("-")){
				b = "+"+b;
			}			
		}	
		
		//-----fim do antes de tudo
		String replaceA = a.replace("-", "|-").replace("+", "|+");
		String replaceB = b.replace("-", "|-").replace("+", "|+");
		
		System.out.println(replaceA);
		
		String[] splitA = replaceA.split("\\|");
		String valorA1 = splitA[0];
		String valorA2 = splitA[1];
	
		String[] splitB = replaceB.split("\\|");
		String valorB1 = splitB[0];
		String valorB2 = splitB[1];
		
		if(valorA1.isEmpty()) {	valorA1 = "0"; }
		if(valorA2.isEmpty()) {	valorA2 = "0"; }
		if(valorB1.isEmpty()) {	valorB1 = "0"; }
		if(valorB2.isEmpty()) {	valorB2 = "0"; }
		
		Boolean existVariavelA1 = false;
		Boolean existVariavelA2 = false;
		Boolean existVariavelB1 = false;
		Boolean existVariavelB2 = false;
		System.out.println(splitA[0]);

		if(valorA1.contains(VARIAVEL)){	existVariavelA1 = true;	}
		if(valorA2.contains(VARIAVEL)){	existVariavelA2 = true;	}
		if(valorB1.contains(VARIAVEL)){	existVariavelB1 = true;	}
		if(valorB2.contains(VARIAVEL)){	existVariavelB2 = true;	}

		System.out.println(valorA1.replace(VARIAVEL, ""));
		
		int a1 = Integer.parseInt(valorA1.replace(VARIAVEL, ""));
		int a2 = Integer.parseInt(valorA2.replace(VARIAVEL, ""));
		int b1 = Integer.parseInt(valorB1.replace(VARIAVEL, ""));
		int b2 = Integer.parseInt(valorB2.replace(VARIAVEL, ""));
		
		System.out.println("->"+a1+"-"+a2+"-"+b1+"-"+b2);
		
		int c1a = (a1 * b1);
		int c1b = (a1 * b2); 
		int c2a = (a2 * b1);
		int c2b = (a2 * b2); 
		
		String c1a_str = null;
		String c1b_str = null;
		String c2a_str = null;
		String c2b_str = null;

		String ca_str = null;
		String cb_str = null;
		//String a = "2x";
		//String b = "5+4x";
		
		// a1 x b1 => 2x * 5
		if(existVariavelA1 && existVariavelB1){
			c1a_str = Integer.toString(c1a)+"x2";
		}
		if((existVariavelA1 && !existVariavelB1) || (!existVariavelA1 && existVariavelB1)){
			c1a_str = Integer.toString(c1a)+"x";
		}
		if(!existVariavelA1 && !existVariavelB1){
			c1a_str = Integer.toString(c1a);
		}
		
		// a1 x b2 => 2x *4x
		if(existVariavelA1 && existVariavelB2){
			c1b_str = Integer.toString(c1b)+"x2";
		}
		if((existVariavelA1 && !existVariavelB2) || (!existVariavelA1 && existVariavelB2)){
			c1b_str = Integer.toString(c1b)+"x";
		}
		if(!existVariavelA1 && !existVariavelB2){
			c1b_str = Integer.toString(c1b);
		}
		
		//--------sintetizacao-----
		if(c1a_str.matches("0") || c1a_str.matches("0x") || c1a_str.matches("0x2"))
			c1a_str = "";
		if(c1b_str.matches("0") || c1b_str.matches("0x") || c1b_str.matches("0x2"))
			c1b_str = "";
		
		ca_str = c1a_str +c1b_str;
		//------------------------------
		
		// a2 x b1 => 2x *4x
		if(existVariavelA2 && existVariavelB1){
			c2a_str = Integer.toString(c2a)+"x2";
		}
		if((existVariavelA2 && !existVariavelB1) || (!existVariavelA2 && existVariavelB1)){
			c2a_str = Integer.toString(c2a)+"x";
		}
		if(!existVariavelA2 && !existVariavelB1){
			c2a_str = Integer.toString(c2a);
		}
		
		// a2 x b1 => 2x *4x
		if(existVariavelA2 && existVariavelB2){
			c2b_str = Integer.toString(c2b)+"x2";
		}
		if((existVariavelA2 && !existVariavelB2) || (!existVariavelA2 && existVariavelB2)){
			c2b_str = Integer.toString(c2b)+"x";
		}
		if(!existVariavelA2 && !existVariavelB2){
			c2b_str = Integer.toString(c2b);
		}
		
		
		
		
		if(existVariavelA1){
			
		}
		if(existVariavelA1){
			
		}
		if(existVariavelA1){
			
		}
		//System.out.println(c1 +" -- "+c2);
		
		//Integer.parseInt(valorA1.replace(VARIAVEL, ""));
		//(0 - 4 )* (5 + 4x) => 0 + 0 - 20 - 16x
		int j = 3*x;
//		gerarIdentidade(matrix);
//		somar(matrix, matrixIdentidade);
//		multiplicacao(matrixResult1, matrixResult1);
	}

	private static void multiplicacao(String[][] matrix2, String[][] matrixResult2) {

		for (int i = 0; i <= dimensao; i++) {
			for (int j = 0; j <= dimensao; j++) {
				for (int k = 0; k <= dimensao; k++) {
					//matrixResult[i][j] += (matrix2[i][k] * matrixResult2[k][j]);
					//System.out.println(matrix2[i][k] +"*"+ matrixResult2[k][j]);
					resolverAritmetica(matrix2[i][k]+"*"+matrixResult2[k][j], i, j);
				}

			}
		}
	}

	private static void resolverAritmetica(String equacao, int i, int j) {
		
		String a = ""; 
		String b = "";
		Boolean ax = false; Boolean bx = false;
		String resultado = null;
		String[] split = equacao.split("\\*");
		if(split[0].equals("0") || split[1].equals("0")) {
			resultado = "0";
		}else {
			
			if (split[0].contains("-")) {
				a = "-";
			}
			if (split[0].contains("+")) {
				a = "+";
			}
			if (split[1].contains("+")) {
				b = "+";
			}
			if (split[1].contains("-")) {
				b = "-";
			}
			
			if (split[0].contains(VARIAVEL)) {
				ax = true;
			}
			if (split[1].contains(VARIAVEL)) {
				bx = true;
			}
			
			if(!a.isEmpty()){
				split[0].split(a);
			}
			
			
			
			
			//devolve(split[0], split[1], a, b, ax, bx);
			
		}
			
		
		System.out.println("->"+split[0]+"-"+split[1]);
		
		matrixResult2[i][j] = resultado;
	}

	
	private static String devolve(String a, String b, 
			char sinalA, char sinalB, 
			Boolean containXA, Boolean containXB) {
		
		if(containXA && containXB) {
			if(sinalA == '+'){
				
			}
		}
		
		
		//a+b * c-d
		if((a.contains("+") || a.contains("-")) 
				&& (b.contains("+") || b.contains("-"))){
			String[] splitA = null;
			String[] splitB = null;
			if(a.contains("+")) {
				splitA = a.split("+");
			}
			if(a.contains("-")) {
				splitA = a.split("-");
			}
			if(b.contains("+")) {
				splitB = b.split("+");
			}
			if(b.contains("-")) {
				splitB = b.split("-");
			}
			
		//	if(splitA[0].contains(VARIAVEL) && splitB[])
			
		}
		//a * (x+y)
		if((!a.contains("+") && !a.contains("-")) 
				&& (b.contains("+") || b.contains("-"))){
			
		}
		//(x+y) * b
		if((a.contains("+") || a.contains("-")) 
				&& (!b.contains("+") && !b.contains("-"))){
			
		}
		//a * b
		if(!(a.contains("+") && !a.contains("-")) 
				&& (!b.contains("+") && !b.contains("-"))){
			
		}
		
		return null;
	}
	
	// a b c 100
	// d e f 010
	// g h i 001

	private static void gerarIdentidade(String[][] matrix2) {

		matrixIdentidade = new String[matrix2.length][matrix2.length];

		System.out.println("-->dimensao da matrix"+matrix2.length);
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				if(j == i){
					matrixIdentidade[i][j] = "x";
				}else {
					matrixIdentidade[i][j] = "0";
				}
				System.out.println(matrixIdentidade[i][j]);
			}
		}

	}

	private static void somar(String[][] matrixA, String[][] matrixB) {

		for (int i = 0; i <= dimensao; i++) {
			for (int j = 0; j <= dimensao; j++) {
				if(matrixA[i][j] == "0"){
					matrixResult1[i][j] = matrixB[i][j];					
				}
				if(matrixB[i][j] == "0"){
					matrixResult1[i][j] = matrixA[i][j];					
				}
				if(matrixA[i][j] != "0" && matrixB[i][j] != "0"){
					matrixResult1[i][j] = matrixA[i][j] +"+"+ matrixB[i][j];										
				}
				System.out.println(matrixResult1[i][j]);
			}
		}
	}
}
