package net.lecnam.puissance4.sitayeb;
import java.util.Scanner;
/**
 <p>
 *la class des joueurs et superclasse des Pc
 * <b>Un joueur</b> est caractérisé par les informations suivantes :
 * <ul>
 * <li> sa couleur qui fixer par enum .</li>
 * <li>son nom.</li>
 * <li> statistique qui calcule le nombre de partie gagner dans un jeu</li>
 * </ul>
 * @see Jeu
 * @see Couleur
 * @see PasTaille
 * @see Programme
 * @author Si-tayeb sofiane
 *
 */
public class Joueur {
	protected Scanner sc=new Scanner(System.in);
	private char couleur;
	private String nom;
	private int statistique;
	/**
	 * Constructor
	 * @param nom
	 * @param couleur
	 */
	public Joueur(String nom,char couleur) {	
		setNom(nom);
		setCouleur(couleur);
		statistique=0;
	}
	/**
	 * 
	 * @return couleur du joueur
	 */
	public char getCouleur() {
		return couleur;
	}
	/**
	 * affiche le jeu et effectue le coup du jeu
	 * @param jeu prend un jeu en paramter
	 * @return vrai si le jeu est effectuer
	 * @throws PasNiveau3 
	 */
	public boolean  jouer(Jeu jeu) throws PasNiveau3 {
		  jeu.afficher();;
		  boolean effectuer;
		  System.out.println("veillez entrez le numero de la ligne: "+this.getNom()+" de Couleur "+getCouleur());
		  int colone=sc.nextInt();
		  effectuer=jeu.joueCoup(colone, this.getCouleur());
		  if(effectuer)
		  System.out.println("le joueur "+this.getNom()+" a jouer a la colone "+colone);
		  return effectuer;
	}
	public void setCouleur(char couleur){
		this.couleur = couleur;
	}
	/**
	 * 
	 * @return nom du joueur
	 */
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 * @return nombre partie gagner par le joueur
	 */
	public int getStatistique() {
		return statistique;
	}
	/**
	 * ajoute 1 au statistique en cas de victoire
	 */
	public void ajouter1PourStatistique() {
		statistique++;		
	}
	
}
