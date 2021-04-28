package utilitaires;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JFileChooser;

/**
 * Classe utilitaires pour la gestion de fichiers
 *
 * @author Cédric Gagnon
 */
public class FichierUtilitaires
{

	/**
	 * Enregistrer un message (une chaîne) dans un fichier (PrintWriter)
	 *
	 * @param message: le message à enregistrer
	 * @param nomFichier: un objet File, le fichier dans lequel il faut
	 *            enregistrer le message
	 *
	 * @return vrai si le message a été enregistré.
	 */
	// TODO enregistrerMessage - Compléter le code de la méthode
	public static boolean enregistrerMessage(String message, File nomFichier)
	{
		boolean success=true;
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream(nomFichier,true),true);
			output.println(message);
			output.close();
		}
		catch(Exception e) {
			success=false;
		}
		
		return(success);
	}

	/**
	 * Lire seulement la première ligne (une chaîne) du fichier reçu
	 *
	 * @param nomFichier, un File dans lequel lire.
	 *
	 * @return la ligne lue
	 */
	// TODO lireMessage - Compléter le code de la méthode
	public static String lireMessage(File nomFichier)
	{
		String out="";
		try {
			FileReader input = new FileReader(nomFichier);
			char curr=' ';
			int code=0;
			while (code!=-1 && code!=10) {
				code=input.read();
				curr=(char)code;
				out+=curr;
			}
			input.close();
		}
		catch(Exception e) {
		}
		out=out.length()>0?out.substring(0,out.length()-1):out;
		return out;
	}

	/**
	 * Lire un fichier de mots. Chaque mot est sur une ligne différente. Chaque
	 * mot doit être mis en minuscule et on doit enlever les espaces de chaque
	 * bout (voir la classe String). Il faut aussi éliminer les doublons.
	 *
	 * @param nomFichier le nom du fichier dictionnaire
	 *
	 * @return un SortedSet des mots du dictionnaire ou null s'il n'y a pas de mot
	 *         dans le fichier.
	 */
	// TODO lireDictionnaire - Compléter le code de la méthode
	public static SortedSet<String> lireDictionnaire(File nomDic)
	{
		SortedSet<String> out=new TreeSet<String>();
		try {
			StreamTokenizer input = new StreamTokenizer(new BufferedReader(new FileReader(nomDic)));
			while(true) {
				input.nextToken();
				if(input.sval==null) {
					//oui je sais terrible façon de sortir de la loop, mais ça marche
					throw new Exception("sortie");
				}
				out.add(input.sval.toLowerCase());
			}
		}
		catch(Exception e) {}
		if(out.size()==0){
			out=null;
		}
		return out;
	}

	/**
	 * Obtenir le nom du fichier de l'utilisateur à partir d'une boîte de
	 * dialogue graphique.
	 * 
	 * @param option: le nom du bouton principal
	 * 
	 * @return un File, le fichier sélectionné ou null
	 */
	// TODO obtenirNomFichier - Compléter le code de la méthode
	public static File obtenirNomFichier(String option)
	{
		String value=InputUtilitaires.saisirString(option);
		File out=null;
		if(value!="")
			out=new File(value);
		return out;
	}

	/**
	 * Obtenir le nom du fichier de l'utilisateur à partir d'une boîte de
	 * dialogue graphique.
	 *
	 * @param option: le nom du bouton principal
	 * @param le nom du fichier pré-sélectionné
	 *
	 * @return un File, le fichier sélectionné ou null
	 */
	public static File obtenirNomFichier(String option, File fichier)
	{
		File f = null;
		JFileChooser chooser = new JFileChooser(".");
		chooser.setSelectedFile(fichier);

		if (chooser.showDialog(null, option) == JFileChooser.APPROVE_OPTION)
			f = chooser.getSelectedFile();

		return f;
	}
	
	public static void main(String[] args)
	{
		//FichierUtilitaires.enregistrerMessage("hello world",new File("test.txt"));
		//System.out.println(FichierUtilitaires.lireMessage(new File("test.txt")));
		//System.out.println(FichierUtilitaires.lireDictionnaire(new File("dictionnaire.txt")));
		System.out.println(obtenirNomFichier("Entrez le nom du fichier:"));
	}
}
