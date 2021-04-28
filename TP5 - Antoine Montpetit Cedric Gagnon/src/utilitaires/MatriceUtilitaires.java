package utilitaires;

import java.util.Iterator;
import java.util.SortedSet;
import utilitaires.MathUtilitaires;

/**
 * Classe utilitaires pour la gestion des matrices carrées
 *
 * @author Vos noms
 */
public class MatriceUtilitaires
{

	/**
	 * Permet de produire une chaîne de caractères pour l'affichage d'une
	 * matrice N X M dans la console. Très utile pour faire des tests.
	 *
	 * <pre>
	 *  Exemple d'affichage voulu:
	 *
	 *  [6, 1, -5]
	 *  [-2, -5, 4]
	 *  [-3, 3, -1]
	 * </pre>
	 *
	 * @param mat la matrice N X M à afficher
	 *
	 * @return la chaîne de caractères
	 */
	public static String toStringMat(int[][] mat)
	{
		String matriceString = "";
		for (int i = 0; i < mat.length; i++)
		{
			matriceString += "[";

			for (int j = 0; j < mat[i].length; j++)
			{
				matriceString += mat[i][j]
						+ (mat[i].length - 1 == j ? "" : ", ");
			}

			matriceString += "]\n";
		}

		return matriceString;
	}

	/**
	 * Retourne la matrice carrée M X N transposée à partir d'une matrice carrée
	 * N X M reçue.
	 *
	 * La matrice transposée d'une matrice est obtenue en échangeant les lignes
	 * et les colonnes.
	 *
	 * @param mat la matrice d'origine
	 *
	 * @return la matrice carrée M X N transposée
	 */
	public static int[][] getMatTranspose(int[][] mat)
	{

		int[][] newMat = null;

		if (mat.length == mat[0].length)
		{
			newMat = new int[mat[0].length][mat.length];
			for (int i = 0; i < newMat.length; i++)
			{
				for (int j = 0; j < newMat[i].length; j++)
				{
					newMat[i][j] = mat[j][i];
				}
			}
		}

		return newMat;
	}

	/**
	 * Retourne la matrice carrée (N-1) X (N-1) mineure d'une matrice carrée N X
	 * N reçue.
	 *
	 * Est la matrice carrée résultante, lorsque l'on supprime toutes les
	 * valeurs de la ligne et de la colonne reçues, à partir la matrice
	 * d'origine reçue.
	 *
	 * @param mat la matrice d'origine
	 * @param ligne la ligne de valeurs à supprimer
	 * @param col la colonne de valeurs à supprimer
	 *
	 * @return la matrice carrée (N-1) X (N-1) mineure résultante
	 *
	 */
	private static int[][] getMatMineur(int[][] mat, int ligne, int col)
	{

		int[][] newMat = null;
		int curCol = 0;
		int curLigne = 0;

		if (mat.length == mat[0].length)
		{
			newMat = new int[mat.length - 1][mat[0].length - 1];

			for (int i = 0; i < mat.length; i++)
			{
				if (i != ligne)
				{

					for (int j = 0; j < mat[i].length; j++)
					{
						if (j != col)
						{
							newMat[curLigne][curCol] = mat[i][j];
							curCol++;
						}
					}

					curCol = 0;
					curLigne++;

				}
			}
		}

		return newMat;
	}

	/**
	 * Retourne une matrice N X M résultant de la multiplication d'un scalaire
	 * reçu avec chaque élément d'une matrice N X M reçue. Pas d'arrondi (partie
	 * entière)
	 *
	 * @param mat la matrice d'origine
	 * @param scalaire le scalaire
	 *
	 * @return la matrice résultante de la multiplication avec un scalaire
	 */
	public static int[][] getMatMultScalaire(int[][] mat, float scalaire)
	{

		int[][] newMat = new int[mat.length][mat[0].length];

		for (int i = 0; i < newMat.length; i++)
		{
			for (int j = 0; j < newMat[0].length; j++)
			{
				newMat[i][j] = (int) (mat[i][j] * scalaire);
			}
		}

		return newMat;
	}

	/**
	 * Retourne une matrice N X M résultant de l'application d'un modulo reçu,
	 * sur chaque élément d'une matrice N X M reçue. Utilise la méthode modulo
	 * de MathUtilitaires.
	 *
	 * @param mat la matrice d'origine
	 * @param mod le modulo à appliquer
	 *
	 * @return la matrice résultante de l'application d'un modulo
	 */
	public static int[][] getMatModuloX(int[][] mat, int mod)
	{
		int[][] newMat = new int[mat.length][mat[0].length];

		for (int i = 0; i < newMat.length; i++)
		{
			for (int j = 0; j < newMat[0].length; j++)
			{
				newMat[i][j] = MathUtilitaires.modulo(mat[i][j], mod);
			}
		}

		return newMat;
	}

	/**
	 * Calcule le déterminant d'une matrice carrée de N X N.
	 *
	 * ATTENTION ; Il existe plusieurs façons de calculer un déterminant, il
	 * faut faire de la recherche.
	 *
	 * Devrait être une méthode récursive...
	 *
	 * @param mat la matrice carrée pour les calculs.
	 *
	 * @return le déterminant de la matrice.
	 */
	public static int getDeterminant(int[][] mat)
	{

		int determinant = 0;

		if (mat.length == mat[0].length)
		{
			if (mat.length == 1)
			{
				determinant = mat[0][0];
			}
			else if (mat.length == 2)
			{
				determinant = (mat[0][0] * mat[1][1]) - (mat[1][0] * mat[0][1]);
			}
			else
			{
				for (int i = 0; i < mat[0].length; i++)
				{
					int sing = i % 2 == 1 ? -1 : 1;
					determinant += sing * mat[0][i]
							* getDeterminant(getMatMineur(mat, 0, i));
				}
			}
		}

		return determinant;
	}

	/**
	 * Retourne la matrice carrée des cofacteurs N X N d'une matrice carrée N X
	 * N reçue, utile pour déterminer la matrice adjointe.
	 *
	 * @param mat la matrice d'origine
	 *
	 * @return la matrice carrée des cofacteurs de la matrice d'origine
	 */
	public static int[][] getMatCofacteurs(int[][] mat)
	{
		int[][] cofMat = null;

		if (mat.length == mat[0].length)
		{
			cofMat = new int[mat.length][mat[0].length];
			if (cofMat.length == 1)
			{
				cofMat[0][0] = mat[0][0];
			}
			else if (mat.length == 2)
			{
				cofMat[0][0] = mat[1][1];
				cofMat[1][1] = mat[0][0];
				cofMat[0][1] = -mat[1][0];
				cofMat[1][0] = -mat[0][1];
			}
			else
			{
				for (int i = 0; i < mat.length; i++)
				{
					for (int j = 0; j < mat[0].length; j++)
					{
						int sing = (int) Math.pow(-1, i + j);
						cofMat[i][j] = sing
								* getDeterminant(getMatMineur(mat, i, j));
					}
				}
			}
		}

		return cofMat;
	}

	/**
	 * Retourne la matrice N X N adjointe à partir d'une matrice N X N reçue.
	 *
	 * Est la matrice transposée des cofacteurs de la matrice d'origine.
	 *
	 * @param mat la matrice d'origine
	 *
	 * @return la matrice carrée N X N adjointe
	 */
	public static int[][] getMatAdjointe(int[][] mat)
	{
		return getMatTranspose(getMatCofacteurs(mat));
	}

	/**
	 * Calcule le déterminant inverse du chiffre de Hill selon la force brute.
	 *
	 * @param valDet déterminant de la matrice d'origine
	 * @param valMod la valeur du modulo pour le calcul
	 *
	 * @return la valeur du déterminant inverse ou 0
	 */
	public static int getDeterminantInverseHill(int valDet, int valMod)
	{
		int detInv = 0;
		SortedSet<Integer> premierEntreEux = MathUtilitaires.xPremierEntreEux(0,
				valMod);

		Iterator<Integer> it = premierEntreEux.iterator();
		Integer nb = 0;

		while (it.hasNext() && (detInv == 0))
		{
			nb = it.next();
			if (MathUtilitaires.modulo((valDet * nb), valMod) == 1)
			{
				detInv = nb;
			}
		}

		return detInv;
	}

}
