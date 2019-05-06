package net.lecnam.puissance4.sitayeb;
/**
 * niveau 1 programme
 * @author sofiane
 *
 */
public class PcNiveau1 extends Joueur {
	/**
	 * 
	 * @param couleur caracter qui symbolise la couleur de l'ordinateur
	 */
	public PcNiveau1(char couleur) {
		super("Programme", couleur);
	}
	/**
	 * la methode jouer du niveau 1
	 * @throws PasNiveau3 
	 */
	public boolean  jouer(Jeu jeu) throws PasNiveau3 {		
		for (int i = jeu.getTailleGrille()-1; i>=0; i--) {
			for (int j =0; j<jeu.getTailleGrille(); j++) {
				if(jeu.getGrille()[i][j]=='*') {
					jeu.getGrille()[i][j]=getCouleur();
					System.out.println(getNom()+" a jouer a la colone "+(j+1));
					return true;
				}					
			}
		}
		return true;		 
	}
}