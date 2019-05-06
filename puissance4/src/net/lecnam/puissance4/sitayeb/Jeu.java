package net.lecnam.puissance4.sitayeb;
/**
 * <p>
 * <b>Un jeu</b> est caractérisé par les informations suivantes :
 * <ul>
 * <li>Une taille de la grille carrée qui vaut 8 par defaut .</li>
 * <li>Un nombre de pions a aligner pour gagner une partie qui doit toujour etre inferieur ou egal a la taille de la grille et Superieur a 4 par defaut vaut 4.</li>
 * <li>la grille une array a deux dimention carré.</li>
 * </ul>
 * @see Partie
 * @see Joueur
 * @see Couleur
 * @see PasTaille
 * @see Programme
 * @author Si-tayeb sofiane
 */


public class Jeu {
	private int tailleGrille;
	private int nbrAligner;
	private char[][] grille;
	/**
	 * constructor par default initialize le jeu taille 8 et pions a aligner 4
	 */
	public Jeu() {
		this.tailleGrille=8;
		this.nbrAligner=4;
		grille=new char[8][8];
	}
	/**
	 * 
	 * @param nbrAligner  number pions a aligner
	 * @param tailleGrille la taille de la grille
	 * @throws PasTaille si jamais l'utilisateur n'a pas compris le jeu et introduit les mauvais chiffre de taille et nbr pions a aligner
	 */
	public Jeu(int nbrAligner,int tailleGrille) throws PasTaille {
		if(nbrAligner>tailleGrille )
			throw new PasTaille();
		else {
		setNbrAligner(nbrAligner);
		setTailleGrille(tailleGrille);
		grille=new char[getTailleGrille()][getTailleGrille()];
		}
	}
	/**
	 * 
	 * @return taille Grille
	 */
	public int getTailleGrille() {
		return this.tailleGrille;
	}
	/**
	 * 
	 * @param tailleGrille fixe la taille de la grille 
	 * @throws PasTaille si jamais l'utilisateur n'a pas compris le jeu et introduit les mauvais chiffre de taille et nbr pions a aligner
	 */
	public void setTailleGrille(int tailleGrille)throws PasTaille {
		if(tailleGrille<8||tailleGrille>256)
			throw new PasTaille();
		else
		this.tailleGrille = tailleGrille;
	}
	/**
	 * cette methode permer de remplir la grille d'etoile pour initialiser le jeu
	 */
	public void vider() {
	for (int i = 0; i < getTailleGrille(); i++) {
		for (int j = 0; j < getTailleGrille(); j++) {
			grille[i][j]='*';
			
				}
			}
	}
	/**
	 * 
	 * @param numeroColone permet d'introduire le numero de colone on lui soustrait 1  pour corespendre a la matrix de la grille
	 * @param couleur corespond au symbole d'un joueur dans la class jeu
	 * @return <b>true</b> si le coup est passé <b>false</b> si le numero de colone pas bon ou si la colone est plein c'est dire plus d'étoile dans le numero de colone fournie
	 */
	public boolean joueCoup(int numeroColone,char couleur) {
		if(numeroColone<1 || numeroColone>getTailleGrille())
				return false;
		else {
		int rangee=getTailleGrille()-1;
			while(grille[rangee][numeroColone-1]!='*') {
				if(rangee==0)
					return false;
				rangee--;
			}		
				grille[rangee][numeroColone-1]=couleur;
				return true;
			}
		}
	
		
	/**
	 * elle verifier dans un array de  des character si il ya pas char qui sont alignés au nombres indiquer par la methode getNbrAligner()
	 * @see getNbrAligner()
	 */
	public int verifier(char[]tab ) {
		int nb=1;
		for (int i = 0; i < tab.length-1; i++) {
			if(nb==getNbrAligner())
				break;
			if(tab[i]==tab[i+1] && tab[i]!='*') {
				nb++;
			}else {
				nb=1;
			}			
		}
		return nb;	
	}
	/**
	 * verifie la grille d'une facon oblique si il ya pas le nombre de pios a aligner
	 * @param grille prend un tableu 2 dimention
	 * @return <b>true</b> si il ya un getNbrAligner() de caracter aligner de droite a gauche obliquemet
	 */
	public boolean oblique(char [][] grille) {
		char [] tab;
		for (int i = 0; i < grille.length; i++) {
			//creation tab temporaire
			 tab= new char[grille.length-i];
			//on remplie le tableau et on verifie
			for (int j = 0; j < tab.length; j++) {
				tab[j]=grille[i+j][j];
			}
			for (int j = 0; j < tab.length; j++) {
				if(verifier(tab)==getNbrAligner()) {
				return true;
				}					
			}
			//on remplie encor une fois le tableau et on verifie
			for (int j = 0; j < tab.length; j++) {
				tab[j]=grille[j][j+i];
			}
			for (int j = 0; j < tab.length; j++) {
				if(verifier(tab)==getNbrAligner()) {
				return true;
				}					
			}			
		}		
		return false;		
	}
	/**
	 * 
	 * @return <b>true</b> si il ya victoire 
	 */
	
	public boolean cherche4() {
		boolean gagnant=false;
		//verification horizontale
		for (int i = 0; i < getTailleGrille(); i++) {
			if(verifier(grille[i])==getNbrAligner()) {		
			gagnant=true;
			}
		}
		// verification verticale
		char [] tabTemp=new char [getTailleGrille()];
		for (int i = 0; i < getTailleGrille(); i++) {
			for (int j = 0; j < getTailleGrille(); j++) {
				// on remplie le tableau temporaire verticalement
				tabTemp[j]=grille[j][i];
			}
			//on verifie si il ya victoire 
			for (int i1 = 0; i1 < tabTemp.length; i1++) {
				if(verifier(tabTemp)==getNbrAligner()) {
					gagnant=true;				
				}					
			}
		}
			//verification oblique de la grille
			if(gagnant==false)
				gagnant=oblique(grille);
			//on fait la meme chose dans l'autre sens da la grille
			//on crie une autre grille en symytrie par rapport a la rangée du milieu de la grille d'origine
			char [][]grille2= new char [getTailleGrille()][getTailleGrille()];
			for (int i = 0; i < grille2.length; i++) {
				for (int j = 0; j < grille2.length; j++) {
					grille2[i][j]=grille[i][(getTailleGrille()-1)-j];
				}
			}
			//verification oblique pour de la grille inverser par rapport a la rangé du milieu
			if(gagnant==false)
				gagnant=oblique(grille2);
		
		return gagnant;
	}
	/**
	 * affiche le jeu
	 */
	public void afficher() {		
	for (int i = 0; i < grille.length; i++) {
		System.out.println(grille[i]);
	}
	for (int i = 0; i < grille.length; i++) {
		System.out.print("-");
	}
	System.out.println();
	for (int i = 0; i < grille.length; i++) {
		System.out.print(i+1);
	}
	System.out.println();
	}
	/**
	 * 
	 * @return nombre de pions a aligné
	 */
	public int getNbrAligner() {
		return nbrAligner;
	}
	/**
	 * 
	 * @param nbrAligner fixe nombre de pions a aligner
	 * @throws PasTaille  si jamais l'utilisateur n'a pas compris le jeu et introduit les mauvais chiffre de taille et nbr pions a aligner
	 */
	public void setNbrAligner(int nbrAligner) throws PasTaille {
		if(nbrAligner<4||nbrAligner>16)
			throw new PasTaille();
		else
		this.nbrAligner = nbrAligner;
	}
	/**
	 * 
	 * @return la matrix du jeu 
	 */
	public char[][] getGrille() {
		return grille;
	}
	/**
	 * fixe la matrix
	 * @param grille matrix
	 */
	public void setGrille(char[][] grille) {
		this.grille = grille;
	}
	/**
	 * 
	 * @return vrai si la grille est plein
	 */
	 public boolean estPlein() {
		    // On cherche une case '*'. S'il n'ya pas, le tableau est plein
		    for (int i = 0; i< getTailleGrille(); i++) {
		      for (int j = 0; j<getTailleGrille(); j++) {
		        if (grille[i][j] =='*') {
		          return false;
		        }
		      }
		    }

		    return true;
		  }
}
