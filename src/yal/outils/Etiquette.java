package yal.outils;

import java.util.ArrayList;

public class Etiquette {

	private static Etiquette etiquette = new Etiquette();
	private int indexNbVariables;
	private int nbEtiquetteSi;
	private int nbTant;
	private int nbPrint;
	private ArrayList<String> affiche;
	private boolean divPar0;
	private boolean ecrireBool;
	
	private Etiquette() {
		nbEtiquetteSi = 0;
		nbPrint = 0;
		nbTant=0;
		divPar0= false;
		ecrireBool = false;
		affiche = new ArrayList<String>();
		indexNbVariables = 0;
	};
	
	/**
	 * @return L'instance de l'Etiquette
	 */
	public static Etiquette getInstance() {
		return etiquette;
	}

	
	/**
	 * @return le nombre de fois qu'on utilise si (sinon alors)
	 */
	public int getNbEtiquetteSi() {
		return nbEtiquetteSi;
	}
	
	/**
	 * Accrémente nbEtiquetteSi
	 */
	public void setNbEtiquetteSi() {
		nbEtiquetteSi++;
	}
	
	/**
	 * @return Le nombre de fois qu'on utilise tant que
	 */
	public int getNbTant() {
		return nbTant;
	}
	
	/**
	 *  Accrémente nbTant
	 */
	public void setNbTant() {
		nbTant++;
	}
	
	/**
	 * @return Le nombre de fois q'on utlise print
	 */
	public int getNbPrint() {
		return nbPrint;
	}
	
	/**
	 * Accrémente nbPrint
	 */
	public void setNbPrint() {
		nbPrint++;
	}
	
	/**
	 * ajouter a la liste affiche la nouvelle chaine que l'utilisateur souhaite afficher
	 * @param string
	 */
	public void ajouterAffiche(String string){
		affiche.add(string);
		setNbPrint();
	}

	/**
	 * ecrir le code mips du test de la division par 0
	 * @return le code ou une chaine vide
	 */
	public String ecrireTestDiv0() {
		if (divPar0) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("# Gerer la division par 0\n");
			stringBuilder.append("divisionParZero:\n");
			stringBuilder.append("li $v0, 4\n");
			stringBuilder.append("la $a0, errDiv0\n");
			stringBuilder.append("syscall\n");
			stringBuilder.append("b end\n");
			return stringBuilder.toString();
		} else
			return "";
	}
	
	/**
	 * Met ecrireBool à vrai
	 */
	public void setEcrireBool( ) {
		if (!ecrireBool) {
			this.ecrireBool = true;
			ajouterAffiche("chaineVrai: .asciiz \"vrai\"\n");
			ajouterAffiche("chaineFaux: .asciiz \"faux\"\n");
		}
	}
	
	/**
	 * Ecrit les chaines de caractères à afficher
	 * @return les chaines a écrire
	 */
	public String ecrireChaines() {
		if (affiche.isEmpty())
			return "";
		else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(".data\n");
			for (String chaine : affiche) {
				stringBuilder.append(chaine);
			}
			return stringBuilder.toString();
		}
	}


	/**
	 * @return nb de variables
	 */
	public String getNBVar() {
		String resultat = "iterations: " + indexNbVariables;
		indexNbVariables++;
		return resultat;
	}
	/**
	 * met a vrai divPar0
	 */
	public void setDivPar0() {
		if (!divPar0) {
			this.divPar0 = true;
			ajouterAffiche("errDiv0: .asciiz \" ERREUR EXECUTION : Division par 0 interdite\\n\"\n");
		}
	}

}
