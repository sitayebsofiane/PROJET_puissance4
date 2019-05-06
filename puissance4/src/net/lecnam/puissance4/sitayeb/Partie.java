package net.lecnam.puissance4.sitayeb;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
/**
 * <p>
 * <b>Une Partie</b> est caractérisé par les informations suivantes :
 * <ul>
 * <li> deux objects joueur de la class Joueur ou de la class Pc car la class Pc herite de la class des joueurs.</li>
 * <li>Un jeu qui comporte la matrix du jeu.</li>
 * </ul>
 * @see Jeu
 * @see Joueur
 * @see Couleur
 * @see PasTaille
 * @see Programme
 * @author Si-tayeb sofiane
 *
 */
public class Partie {
	 private Joueur joueur1,joueur2;
	  private Jeu jeu;
	 protected Scanner sc1= new Scanner(System.in);
	  /**
	   * Constructor par default initialize la matrix par des etoile via la methode vider du jeu
	   * @param joueur1 le premier joueur 
	   * @param joueur2 le second joueur
	   *  
	   */
	  public Partie(Joueur joueur1, Joueur joueur2) {
	   this.setJoueur1(joueur1);
	   this.setJoueur2(joueur2);
	    jeu = new Jeu();
	    jeu.vider();

	  }
	/**
	 *  Constructor parameter
	 *@param joueur1 le premier joueur 
	 *@param joueur2 le second joueur
	 * @param nbrAligner nbr pions a aligner 
	 * @param tailleGrille taille de la matrix
	 * @throws PasTaille si jamais l'utilisateur n'a pas compris le jeu et introduit les mauvais chiffre de taille et nbr pions a aligner
	 */
	  public Partie(Joueur joueur1,Joueur joueur2,int nbrAligner,int tailleGrille) throws PasTaille {
		this(joueur1,joueur2);
		jeu= new Jeu(nbrAligner,tailleGrille);
		jeu.vider();
	}
	/**
	   * cette methode fait tourner le jeu a tour de role et verifie si le jeu n'est pas plein et si il ya pas de winner et si l'utilisateur veut continuer a jouer
	   * si le joueur quite les resulat sont enristré automatiqument dans un fichier statistique
	 * @throws PasNiveau3 
	 * @throws IOException pour le fichier des statistique
	 * 
	   */
	  public void jouer() throws PasNiveau3, IOException{
		  int nbrPartie=0;
		  do {
		  jeu.vider();
		  boolean tour;
		  int nbrTour=0;
		  while(!jeu.cherche4()) {
			  if(jeu.estPlein() && !jeu.cherche4()) {
				  break;
			  }
			  if(nbrTour%2==0) {
				  // si le joueur1 entre dans la ligne plein le jeu va lui proposer jusqu'a a ce que il entre dans une autre ligne
				  do {
				  tour=joueur1.jouer(jeu);
				  if(tour)
				  nbrTour++;
				  }while(!tour);
			  }else {
				// si le joueur2 entre dans la ligne plein le jeu va lui proposer jusq'a a ce que il entre dans une autre ligne
				  do {
				  tour=joueur2.jouer(jeu);
				  if(tour)
				  nbrTour++;
				  }while(!tour);
			  }
		  	}
		  		//ensuite j'affiche soit le gagant soit match null
		  if(nbrTour%2==0 && jeu.cherche4()) {
			  System.out.println("le joueur "+joueur2.getNom()+" de couleur "+joueur2.getCouleur()+" a gagner");
			  joueur2.ajouter1PourStatistique();
			  jeu.afficher();
		  }
		  else if(jeu.cherche4()){
			  System.out.println("le joueur "+joueur1.getNom()+" de couleur "+joueur1.getCouleur()+" a gagner");
			  joueur1.ajouter1PourStatistique();
		  	  jeu.afficher();
		  }else {
			  System.out.println("match nul ");
		  }
		  nbrPartie++;
		  }while(quiter());
		  String resultat1="le joueur "+joueur1.getNom()+" de couleur "+joueur1.getCouleur()+" a gagner "+joueur1.getStatistique()+" parties sur "+nbrPartie;
		  String resultat2="le joueur "+joueur2.getNom()+" de couleur "+joueur2.getCouleur()+" a gagner "+joueur2.getStatistique()+" parties sur "+nbrPartie;
		  System.out.println(resultat1); 
		  System.out.println(resultat2);
		  Path stat= Paths.get("statistique.txt");
		  Files.write(stat, (resultat1+"\n"+resultat2+"\n").getBytes(),StandardOpenOption.APPEND);
		  System.out.println("ces statistique sont saved dans ce fichier text: \n"+stat.toRealPath(LinkOption.NOFOLLOW_LINKS));
	  }
	  /**
	   * 
	   * @return true si l'utilisateur veut quiter le jeu ou false si il souhaite une une autre partie du jeu
	   */
	  public boolean quiter() {
		  System.out.println("taper 'oui' pour rejouer sinon taper Entrée ");
		  String repense=sc1.nextLine();
		  if(repense.toLowerCase().equals("oui"))
			  return true;
		  return false;
		  
	  }
	  /**
	   * 
	   * @param joueur1 fixe le joueur 1
	   */
	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}
	/**
	 * 
	 * @param joueur2 fixe le joueur 2
	 */
	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}
}
