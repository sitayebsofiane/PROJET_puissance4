package net.lecnam.puissance4.sitayeb;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 * cette classe represente le menu des differentes partie du jeu
 * @author sofiane
 *
 */

public class Menu {
	protected String tout;
	protected Scanner chaine=new Scanner(System.in),nombre=new Scanner(System.in);
	protected Path chemin1=Paths.get("statistique.txt");
	/**
	 * 
	 * @throws PasNiveau3 en cas d'erreur pour la les condition du niveau 3
	 * @throws PasTaille si la taille et les piuons a aliger ne sont pas respecter
	 * @throws IOException si le fichier statistique n'existe pas
	 */
	public void commencer() throws PasNiveau3, PasTaille, IOException {
		int choix=0;
		do {
		System.out.println("pour une partie :Between 2 joueur avec une grille parametré taper-->1,\nBetween deux ordinateurs taper-->2,"
				+ "Between joueur et ordinateur : \"niveau1 taper-->3,niveau2 taper-->4,niveau3-->5 \npartie standard taper-->6\":");
		choix=nombre.nextInt();
		switch (choix) {
		case 5:
			System.out.println("veuillez entrer votre nom pour joueur 1");
			String nom7=chaine.nextLine();
			Partie pJoueurPc3=new Partie(new PcNiveau3(Couleur.ORDINATEUR1.getNom()),new Joueur(nom7,Couleur.JOUEUR1.getNom()),5,9);
			try {
				pJoueurPc3.jouer();
			} catch (IOException e4) {
				System.err.println("le fichier statistique n'existe pas ");
			}
			break;
		case 4:
			System.out.println("veuillez entrer votre nom pour joueur 1");
			String nom6=chaine.nextLine();
			Partie pJoueurPc2=new Partie(new PcNiveau2(Couleur.ORDINATEUR1.getNom()),new Joueur(nom6,Couleur.JOUEUR1.getNom()));
			try {
				pJoueurPc2.jouer();
			} catch (IOException e3) {
				System.err.println("le fichier statistique n'existe pas ");
			}
			break;
		case 3:
			System.out.println("veuillez entrer votre nom pour joueur 1");
			String nom5=chaine.nextLine();
			Partie	pJoueurPc1 = new Partie(new PcNiveau1(Couleur.ORDINATEUR1.getNom()),new Joueur(nom5,Couleur.JOUEUR1.getNom()));
			try {
				pJoueurPc1.jouer();
			} catch (IOException e2) {
				System.err.println("le fichier statistique n'existe pas ");
			}
			break;
		case 2:
			Partie	p2Pc = new Partie(new PcNiveau2(Couleur.ORDINATEUR1.getNom()),new PcNiveau1(Couleur.ORDINATEUR2.getNom()));
			try {
				p2Pc.jouer();
			} catch (IOException e1) {
				System.err.println("le fichier statistique n'existe pas ");
			}
			break;
		case 1:
			System.out.println("entrez le nombre pions a aligner ");
			int n1=nombre.nextInt();
			System.out.println("entrez la taille de la grille");
			int n2= nombre.nextInt();
			System.out.println("veuillez entrer votre nom pour joueur 1");
			String nom4=chaine.nextLine();
			System.out.println("veuillez entrer votre nom pour joueur 2");
			String nom3=chaine.nextLine();
			Partie	pParametr = new Partie(new Joueur(nom3,Couleur.JOUEUR1.getNom()),new Joueur(nom4,Couleur.JOUEUR2.getNom()),n1,n2);
			try {
				pParametr.jouer();
			} catch (IOException e) {
				System.err.println("le fichier statistique n'existe pas ");
			}
			break;
		default:
			System.out.println("veuillez entrer votre nom pour joueur 1");
			String nom2=chaine.nextLine();
			System.out.println("veuillez entrer votre nom pour joueur 2");
			String nom1=chaine.nextLine();
			Partie	pDefault = new Partie(new Joueur(nom1,Couleur.JOUEUR1.getNom()),new Joueur(nom2,Couleur.JOUEUR2.getNom()));
			try {
				pDefault.jouer();
			} catch (IOException e) {
			System.err.println("le fichier statistique n'exite pas");
			}
			break;
		}
		System.out.println("taper \"oui\" pour continuer");
	}while(chaine.nextLine().toLowerCase().equals("oui"));
		
	}
}
