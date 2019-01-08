package br.com.matematica.matrizes;

public class MatrixArray {

	static int dimensao = 2;
	static int[][] matrix = new int[3][3];
	static int[][] matrixResult = new int[3][3];
	
	static int[][] matrixIdentidade; 
	public static void main(String[] args) {
		
		matrix[0][0] = 3;
		matrix[0][1] = 2;
		matrix[0][2] = 7;
		matrix[1][0] = 9;
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		matrix[2][0] = 2;
		matrix[2][1] = 2;
		matrix[2][2] = 5;

		gerarIdentidade(matrix);
		somar(matrix, matrixIdentidade);
		//incrementarComOutraMatriz(matrix);
		//multiplicacao(matrix, matrix);
		//resolverMatrix(matrix);
		//mostrar(matrixResult);
		
		
	}
	
	// a b c 100
	// d e f 010
	// g h i 001
	
	private static void gerarIdentidade(int[][] matrix2) {
		
		matrixIdentidade = new int[matrix2.length][matrix2.length];
		
		System.out.println("-->dimensao da matrix"+matrix2.length);
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				if(j == i){
					matrixIdentidade[i][j] = 1;
				}else {
					matrixIdentidade[i][j] = 0;
				}
				System.out.println(matrixIdentidade[i][j]);
			}
		}
		
	}

	private static void multiplicacao(int[][] matrixA, int[][] matrixB) {

		for (int i = 0; i <= dimensao; i++) {
			for (int j = 0; j <= dimensao; j++) {
				for (int k = 0; k <= dimensao; k++) {
					matrixResult[i][j] += (matrixA[i][k] * matrixB[k][j]);
				}
				
			}
		}
	}
	
	private static void mostrar(int[][] matrixResult2) {
		
		for (int i = 0; i <= dimensao; i++) {
			for (int j = 0; j <= dimensao; j++) {
				System.out.println("-->"+matrixResult2[i][j]);
			}
		}
		
	}


	private static void somar(int[][] matrixA, int[][] matrixB) {
	
		for (int i = 0; i <= dimensao; i++) {
			for (int j = 0; j <= dimensao; j++) {
				matrixResult[i][j] = matrixA[i][j] + matrixB[i][j];
				System.out.println(matrixResult[i][j]);
			}
		}
	}
	
	private static void incrementarComOutraMatriz(int[][] matrixAdicional) {
		
		for (int i = 0; i <= dimensao; i++) {
			for (int j = 0; j <= dimensao; j++) {
				matrixResult[i][j] = matrixResult[i][j] + matrixAdicional[i][j];
			}
		}
	}
	
	
	private static void subtrair(int[][] matrixA, int[][] matrixB) { //A - B
		
		for (int i = 0; i <= dimensao; i++) {
			for (int j = 0; j <= dimensao; j++) {
				matrixResult[i][j] = matrixA[i][j] - matrixB[i][j];
			}
		}
	}
	
	private static void dividirTudoPor(int dividendo, int[][] matrix) {
		for (int i = 0; i <= dimensao; i++) {
			for (int j = 0; j <= dimensao; j++) {
				matrixResult[i][j] = matrixResult[i][j] - dividendo;
			}
		}
	}
	
	static int leftSomatoria = 0;
	static int leftValue = 0;
	private static void resolverMatrix(int[][] matrix) {
		int leftResult = 0;
		
		int value = 0;
		//int flag = 0;
		for (int i = 0; i <= dimensao; i++) {
			//flag = 0;
			for (int j = 0; j <= dimensao; j++) {
				if(value > dimensao ) {
					value = 0;
				}
				leftResult = matrix[j][j];
				System.out.println("->"+leftResult);
				//flag++;
			}
		    value++;
		}	
	}
//	3  2  7 | 3  2 
//	9  1  0 | 9  1
//	2  2  5 | 2  2
//	
//	l = 3*1*5 + 2*0*2 + 7*9*5 
	
	private static void multiplicaLeft(int value) {
		if(leftSomatoria == 0) {
			leftSomatoria = value;
		} else {
			//leftSomatoria 
		}
	}
	
	
	
	

	
	
}
