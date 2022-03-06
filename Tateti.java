/**
 * Consigna Trabajo Practico para entregar en git:
1. Juego del TaTeTi (X ficha 1 y O ficha 2)
(matriz de 3x3, hay una jugada por turno, se tienen que ubicar tres fichas iguales en linea diagonal o horizonal o vertical 
hasta que llene el tablero o alguien gane)
Despues de cada jugada mostrar el tablero con las fichas
  0  1  2
0( )( )( ) fila 1
1( )( )( ) fila 2
2( )( )( ) fila 3
 */
package hello;

import java.util.Scanner;

public class Tateti {

	private static int FILAS = 3;
	private static int COLUMNAS = 3;

	public static void main(String[] args) {
		String tateti[][] = new String[FILAS][COLUMNAS];
		Scanner scanner = new Scanner(System.in);
		int fila = 0;
		int columna = 0;
		// repasar estructuras de control, programacion estructurada
		int contador = 0;
		String jugadorActual = "X";
		boolean hayEspacios = false;

		iniciaMatriz(tateti);

		imprimirMatriz(tateti);

		while (contador != 9 && !(hayUnGanadorEnFilas(tateti) || hayUnGanadorEnColumnas(tateti)
				|| hayUnGanadorEnDiagonales(tateti))) {

			turno(fila, columna, tateti, jugadorActual);
			if (jugadorActual == "X") {
				jugadorActual = "O";
			} else {
				jugadorActual = "X";
			}

			contador++;

		}

		if (contador == 9) {

			System.out.println("Empate");
		} else {
			System.out.println("Partida ganada");
			System.out.println("Gracias por jugar (/n_n)/");
		}

	}

	private static boolean hayUnGanadorEnDiagonales(String tateti[][]) {

		boolean primeraDiagonal = tateti[0][0].equals(tateti[1][1]) && tateti[1][1].equals(tateti[2][2])
				&& !tateti[0][0].equals("_");
		boolean segundaDiagonal = tateti[2][0].equals(tateti[1][1]) && tateti[1][1].equals(tateti[0][2])
				&& !tateti[2][0].equals("_");
		return primeraDiagonal || segundaDiagonal;
	}

	private static boolean hayUnGanadorEnColumnas(String tateti[][]) {
		boolean primeraColumna = tateti[0][0].equals(tateti[1][0]) && tateti[1][0].equals(tateti[2][0])
				&& !tateti[0][0].equals("_");
		boolean segundaColumna = tateti[0][1].equals(tateti[1][1]) && tateti[1][1].equals(tateti[2][1])
				&& !tateti[1][1].equals("_");
		boolean terceraColumna = tateti[0][2].equals(tateti[1][2]) && tateti[1][2].equals(tateti[2][2])
				&& !tateti[0][2].equals("_");

		return primeraColumna || segundaColumna || terceraColumna;
	}

	private static boolean hayUnGanadorEnFilas(String tateti[][]) {
		boolean primeraFila = tateti[0][0].equals(tateti[0][1]) && tateti[0][1].equals(tateti[0][2])
				&& !tateti[0][0].equals("_");
		boolean segundaFila = tateti[1][0].equals(tateti[1][1]) && tateti[1][1].equals(tateti[1][2])
				&& !tateti[1][0].equals("_");
		boolean terceraFila = tateti[2][0].equals(tateti[2][1]) && tateti[2][1].equals(tateti[2][2])
				&& !tateti[2][0].equals("_");
		return primeraFila || segundaFila || terceraFila;

	}

	private static void imprimirMatriz(String tateti[][]) {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				tateti[i][j] = "_";
				System.out.print(tateti[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void iniciaMatriz(String tateti[][]) {
		System.out.println("A continuación jugarás al TaTeTi/Gato/La vieja");
		System.out.println(
				"Las reglas son: con la ficha X o la ficha O debes hacer una fila seguida, columna o diagonal para ganar, suerte");
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {

				tateti[i][j] = "_";

			}
		}
	}

	private static void turno(int fila, int columna, String tateti[][], String jugadorActual) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingresa tu coordenada del 0 al 2 en la fila se marcará con la ficha ");
		fila = scanner.nextInt();
		System.out.println("Ingresa tu coordenada del 0 al 2 en la columna se marcará con la ficha ");
		columna = scanner.nextInt();
		while (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
			System.out.println("Incorrecto ingrese la coordenada del 0 al 2:");
			columna = scanner.nextInt();
			fila = scanner.nextInt();
		}
		if (tateti[fila][columna] == "_") {
			tateti[fila][columna] = jugadorActual;
		} else {
			System.out.println("Esta coordenada no está disponible, ingrese otra por favor.");
			System.out.println("Ingresa tu coordenada del 0 al 2 en la fila se marcará con la ficha");
			fila = scanner.nextInt();
			System.out.println("Ingresa tu coordenada del 0 al 2 en la columna se marcará con la ficha");
			columna = scanner.nextInt();
		}

		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				System.out.print(tateti[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}
