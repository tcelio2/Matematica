package br.com.matematica.matrizes;

public class MatrizResolucoes {

	static int dimensao = 3;
	static int left = 0;
	static int somatoria = 0;
	
	public static void main(String[] args) {

		
		//BigDecimal num = new BigDecimal("12.0");
		
		//System.out.println("->"+num.toString().replace(".0", ""));
		//System.out.println("->"+num);
		int[][] matrix = new int[dimensao][dimensao];
		
		matrix[0][0] = 3;
		matrix[0][1] = 4;
		matrix[0][2] = 2;
		
		matrix[1][0] = 5;
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		
		matrix[2][0] = 1;
		matrix[2][1] = 4;
		matrix[2][2] = 8;
		// 00 01 02
		// 10 11 12
		// 20 21 22
		
//		resolverMatrizLeft(matrix);
//		resolverMatrizRight(matrix);
//		System.out.println("Result:"+somatoria);
		
		transformarTransposta(matrix);
	}
	
	public static void transformarTransposta(int[][] matrix) {
		int[][] matrixTemp = new int[dimensao][dimensao];
		for (int i = 0; i < dimensao; i++) {
			for (int j = 0; j < dimensao; j++) {
				matrixTemp[i][j] = matrix[j][i];
			}
		}								
		
		System.out.println(matrix);
		System.out.println("\n\n");
		System.out.println(matrixTemp);
	}
	
}
