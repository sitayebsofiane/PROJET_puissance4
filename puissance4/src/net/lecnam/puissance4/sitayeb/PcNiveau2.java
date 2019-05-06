package net.lecnam.puissance4.sitayeb;

public class PcNiveau2 extends PcNiveau1 {

	public PcNiveau2(char couleur) {
		super(couleur);
	}
	/**
	 * la methode jouer de niveau 2 un peu aleatoir
	 */
	public boolean  jouer(Jeu jeu) {		
		int colone=0,range=jeu.getTailleGrille()-1;
		while(range>=0) {
			for (int j = 0; j < jeu.getTailleGrille(); j++) {
				if(jeu.getGrille()[range][j]=='*') {
					do {
						colone=(int) (Math.random()*jeu.getTailleGrille());
						if(jeu.getGrille()[range][colone]=='*') {
							jeu.getGrille()[range][colone]=getCouleur();
							System.out.println("le programme a joué a la colone "+(colone+1));
							return true;
						}
					}while(jeu.getGrille()[range][colone]!='*');
				}
			}
			range--;
		}
		return true;	 
}
}
