package net.lecnam.puissance4.sitayeb;
/**
 * stop le jeu si l'utilisateur n'a pas respecter les regle du jeu
 * @see Partie
 * @see Joueur
 * @see Couleur
 * @see PasTaille
 * @see Programme
 * @author Si-tayeb sofiane
	 */
public class PasTaille extends Exception {
	
	private static final long serialVersionUID = 1L;
	/**
	 * la taille de la grille est un entier dans[8,256] et Nombres de pions est entier dans[4,N] tel que N est inferieur a la taille de la grille et 16
	 */
	public PasTaille() {
		super("la taille de la grille est un entier dans[8,256] et Nombres de pions est entier dans[4,N] tel que N est inferieur a la taille de la grille et 16 ");
	}

}
