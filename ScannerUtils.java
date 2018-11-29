package studentdatabaseapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
	
	public static int readInt(String message) {
		System.out.println(message);
		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				return in.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Podana wartosc powinna byc liczba!");
				
			}
		}
	}

}