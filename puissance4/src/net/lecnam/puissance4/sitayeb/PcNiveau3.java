package net.lecnam.puissance4.sitayeb;
/**
 * avec cette classe on gagne jamais contre l'ordinateur <b>il faut respecter:</b> la taille de la grille toujour nbr impaire qui vaut nombre pions aligner*2-1
 * l'odinateur joue toujour en premier au milieu
 */
public class PcNiveau3 extends PcNiveau1 {
	
	public PcNiveau3(char couleur) {
		super(couleur);
	}
	/**
	 * cette methode permet a ce que a chaque fois le jour joueur joue ,l'ordinateur joue au dessu,il perd jamais avec cette methode !
	 */
	public boolean  jouer(Jeu jeu) throws PasNiveau3 {
		jeu.afficher();
		//je verifie par securité que l'utilisateur ne rentre pas une taille defernte du double nombre a aliger  fois 2 au quel on retir 1
		if(jeu.getTailleGrille()!=jeu.getNbrAligner()*2-1)
			throw new PasNiveau3();
		else {
			System.out.println("si tu veut gagner cette partie vous devez aligner : "+jeu.getNbrAligner()+" pions pour une grille qui fait "+jeu.getTailleGrille()+" sur "+jeu.getTailleGrille());
			if(jeu.getGrille()[jeu.getTailleGrille()-1][jeu.getTailleGrille()/2]=='*') {
				jeu.getGrille()[jeu.getTailleGrille()-1][jeu.getTailleGrille()/2]=getCouleur();
				return true;
			}else {
				//dans cette loop il va toujour metter au deçu de l'adversaire dans un cas echeant il tombe sur la deuxiemme boucle
		  for (int i=1;i<jeu.getTailleGrille(); i++) {
			  for (int j = 0; j < jeu.getTailleGrille(); j++) {
				if(jeu.getGrille()[i][j]!='*'&&jeu.getGrille()[i][j]!=getCouleur()&&jeu.getGrille()[i-1][j]=='*') {
					jeu.getGrille()[i-1][j]=getCouleur();
					System.out.println("le programe a jouer a la colone "+(j+1));
					return true;
					}
				}
			}
		  for (int i=jeu.getTailleGrille()-1;i>=0; i--) {
			  for (int j = 0; j < jeu.getTailleGrille(); j++) {
				if((jeu.getGrille()[i][j]==getCouleur()||(jeu.getGrille()[i][j]!=getCouleur()&&jeu.getGrille()[i][j]!='*'))&&jeu.getGrille()[i-1][j]=='*') {
					jeu.getGrille()[i-1][j]=getCouleur();
					System.out.println("le programe a jouer a la colone "+(j+1));
					return true;
					}
				}
			}
			return true;		
			}
		}
	}
}

