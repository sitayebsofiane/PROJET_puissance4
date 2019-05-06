package net.lecnam.puissance4.sitayeb;
/**
 * lorsque le jouer ne respecte les regle de joue de niveau 3
 * @author sofiane
 *
 */
@SuppressWarnings("serial")
public class PasNiveau3 extends Exception {

	public PasNiveau3() {
		super("il faut que la taille du jeu soit impaire et egal au  'double de pions a aligner -1'");
	}
}
