package structures;

import java.util.*;

import exceptions.ConstructeurException;

/**
 * Classe qui permet de produire une liste de caractères selon une constante ou
 * selon un tableau de caractères reçu.
 *
 * @author Cédric Gagnon
 *
 */

public class VecteurDeCaracteres
{

	private static final char[] TAB_CHAR_DEFAUT =
	{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '-' };

	private List<Character> tableCaracteres = null;

	/**
	 * Constructeur sans paramètre. Permet de remplir un tableau indexé de
	 * caractères avec les caractères de A à Z, l'espace et le "-". Met tous les
	 * caractères en majuscule.
	 *
	 * Utilise le constructeur avec paramètres
	 *
	 * @throws ConstructeurException
	 */
	// TODO VecteurDeCaracteres - Compléter le code de la méthode
	public VecteurDeCaracteres() throws ConstructeurException
	{
		this(TAB_CHAR_DEFAUT);
	}

	/**
	 * Constructeur avec paramètre. Permet d'instancier et de remplir l'attribut
	 * tableCaracteres, un tableau indexé de caractères à partir du tableau de
	 * "char" reçu. Met tous les caractères en majuscule. Il faut que le tableau
	 * de caractères contienne au moins 1 caractère.
	 * 
	 * @param tabChar : tableau de caractères à utiliser
	 * 
	 * @throws ConstructeurException si tabChar est invalide
	 */
	// TODO VecteurDeCaracteres - Compléter le code de la méthode
	public VecteurDeCaracteres(char[] tabChar) throws ConstructeurException
	{
		if (tabChar == null || tabChar.length == 0)
			throw new ConstructeurException("Tableau de caractères vide");
		tableCaracteres = new ArrayList<Character>();
		for (int i = 0; i < tabChar.length; i++)
		{
			tableCaracteres.add(Character.toUpperCase(tabChar[i]));
		}
	}

	/**
	 * Retourne le caractère selon l'index
	 *
	 * @param index: l'index du caractère
	 *
	 * @return le caractère selon l'index
	 *
	 * @throws ArrayIndexOutOfBoundsException
	 */
	// TODO getCaractere - Compléter le code de la méthode
	public char getCaractere(int index) throws ArrayIndexOutOfBoundsException
	{
		return tableCaracteres.get(index);
	}

	/**
	 * Retourne l'indice, dans le vecteur de caractères, du caractère reçu
	 *
	 * @param car le caractère à trouver
	 *
	 * @return l'indice du caractère ou -1 si le caractère n'est pas trouvé
	 */
	// TODO getIndice - Compléter le code de la méthode
	public int getIndice(char car)
	{
		int index = -1;
		for (int i = 0; i < tableCaracteres.size() && index == -1; i++)
		{
			if (tableCaracteres.get(i).equals(car))
				index = i;
		}
		return index;
	}

	/**
	 * La taille du vecteur de caractères
	 *
	 * @return la taille
	 */
	// TODO getTaille - Compléter le code de la méthode
	public int getTaille()
	{
		return tableCaracteres.size();
	}

	/**
	 * Permet de construire une chaîne de caractères structurée pour afficher
	 * les infos d'un objet VecteurDeCaracteres
	 *
	 * <pre>
	 * Exemple de sortie voulue:
	 *
	 * TableDeCorrespondance = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -]
	 * </pre>
	 */
	@Override
	public String toString()
	{
		return "Table de correspondance = " + this.tableCaracteres;
	}

	public static void main(String[] args)
	{
		// VecteurDeCaracteres test = new VecteurDeCaracteres(new
		// char[]{'a','1','√'});
	}
}
