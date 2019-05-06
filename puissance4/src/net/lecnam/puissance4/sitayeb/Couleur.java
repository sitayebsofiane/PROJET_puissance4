package net.lecnam.puissance4.sitayeb;
/**
 * les couleurs des joueurs sont predifnie dans cette class enum
 * @author sofiane
 *
 */
public enum Couleur {
	ORDINATEUR1('Y'),ORDINATEUR2('G'),JOUEUR1('B'),JOUEUR2('N');
	private char nom ;
	  //Constructor
	  Couleur(char nom){
	    this.setNom(nom);
	  }
	  /**
	   * 
	   * @return le caracter qui simbolise la couleur du joueur
	   */
	public char getNom() {
		return nom;
	}
	public void setNom(char nom) {
		this.nom = nom;
	}
	
}
