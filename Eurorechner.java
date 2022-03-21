package dud;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Klasse zur Umrechnung von Dollar in Euro und von Euro in Dollar
 * 
 * @author Wiebke Berlin 
 * @version 1.0
 */

public class Eurorechner {
	private double 	betrag;
	private String	waehrung;
	private final double 	KURS = 1.11;
	private final String zeitpunktkurswertfestellung = "20.03.2022";
	private boolean 	keineZahl = false;
	
	/**
     * Konstruktor ohne Parameter
     */
	public Eurorechner() {
	}

	/**
     * main-Methode der Klasse Eurorechner
     * 
     * @param args
     * @throws IOException
     */
	public static void main(String[] args) throws IOException  {

		Eurorechner eurorechner = new Eurorechner();
		eurorechner.umrechnenDollarEuro();
	}
	
	
	/**
     * Methode zur Umrechnung von US Dollar Euro.
     */
	private double betragEuro() {
		return betrag * KURS;
	}
	
	/**
     * Methode zur Umrechnung von Euro in US Dollar.
     */
	private double betragDollar() {
		return betrag / KURS;
	}
	
	/**
     * Methode zur Abfrage der eingegeben Waehrung und der auszugebenden Waehrung
     *
     * @throws IOException
     */
	
	public void umrechnenDollarEuro() throws IOException {
		String antwort = "j";
		
		// erzeugen des Eingabestroms
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		do {
		    // Abfrage der Ausgangswaehrung
			System.out.println("Eingabe der Ausgangswaehrung (E)uro oder (U)S Dollar ? : ");
			waehrung = bReader.readLine();
			
			// Abfrage, ob Euro eingegeben wurde
			if (waehrung.equals("E") || waehrung.equals("e")) {
				
				do {
					try {
						System.out.println("Bitte geben Sie den Betrag in Euro ein, der in Dollar umgerechnet werden soll: ");
						betrag = Double.parseDouble(bReader.readLine());
						
						// Ausgabe der umgerechneten W�hrung
						System.out.println(betrag + " Euro sind " + betragDollar() + " US-Dollar Stand: " + zeitpunktkurswertfestellung);
						
						System.out.println("Wollen Sie noch einmal j/n? :");
				        
				        antwort = bReader.readLine();
				        
				        keineZahl = false;
				        
					} catch (NumberFormatException e) {
						System.out.println("Falsche Eingabe bitte nochmal!");
						keineZahl = true;
					}
				} while (keineZahl);
			
			// Abfrage, ob Dollar eingegeben wurde
				
			} else if (waehrung.equals("U") || waehrung.equals("u")) {
				
				do {
					try {
						System.out.println("Bitte geben Sie den Betrag in Dollar ein der in Euro umgerechnet werden soll: ");
					
						betrag = Double.parseDouble(bReader.readLine());
						
						// Ausgabe der umgerechneten W�hrung
						System.out.println(betrag + " US Dollar sind " + betragEuro() + " Euro Stand: " + zeitpunktkurswertfestellung);
						
						System.out.println("Wollen Sie noch einmal j/n? : ");
				        
				        antwort = bReader.readLine();
				        
				        keineZahl = false;
				        
					} catch (NumberFormatException e) {
						System.out.println("Falsche Eingabe bitte nochmal! ");
						keineZahl = true;
					}
				} while (keineZahl);
				
			} else { 
					System.out.println("Sie haben eine unbekannte Waehrung eingegeben. Bitte geben Sie nochmal entweder E f�r Euro oder U f�r US-Dollar ein! ");
				}
		} while (antwort.equals("j"));
	}
	
	
}
