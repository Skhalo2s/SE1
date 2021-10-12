package uebung1.control;

/**
 * Das Translator Interface. Die Anzahl der Methoden ist fix
 * und darf NICHT erweitert werden. Sichtbarkeiten der Methoden koennen
 * unter Umstaenden angepasst werden.
 *
 * @author saschaalda
 *
 */

public interface Translator {

	// Konstante Variable
	double version = 1.0; // Version des Interface.
	
	/*
	 * Uebersetzt eine numerische Zahl in eine String-basierte
	 * Repraesentation gemaess der Spezifikation in der Aufgabe 1-2 
	 */
	String translateNumber(int number);

} 







