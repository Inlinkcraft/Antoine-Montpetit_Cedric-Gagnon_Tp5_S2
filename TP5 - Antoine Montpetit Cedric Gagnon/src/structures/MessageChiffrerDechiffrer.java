package structures;

import java.io.File;
import java.util.Scanner;
import java.util.SortedSet;

import exceptions.ConstructeurException;
import utilitaires.FichierUtilitaires;
import utilitaires.MathUtilitaires;

public class MessageChiffrerDechiffrer implements iCrypto
{
	// Si le caractère de remplacement est un espace on peut mettre au moins 80%
	public static final float POURCENTAGE_ACCEPTABLE = 0.8f;
	public static final char CAR_DE_COMPLEMENT = ' ';

	private VecteurDeCaracteres vecCaracteres = null;
	private ListeMatricesChiffrement listeMatricesCandidates = null;
	private SortedSet<String> dico = null;

	/**
	 * Constructeur, permet d'affecter les différents attributs à partir des
	 * objets reçus en entrée. Avant d'affecter les attributs de la classe avec
	 * les objets reçus en entrée, il faut valider ces derniers (&lt;&gt; null et pas
	 * vide).
	 *
	 * @param vecCars la table de caractères pour la correspondance lors de
	 *            l'encodage et du décodage.
	 * @param listeMats liste des matrices candidates.
	 * @param _dico liste des mots pour la validation lors du décodage.
	 *
	 * @throws ConstructeurException
	 */
	public MessageChiffrerDechiffrer(VecteurDeCaracteres vecCars,
			ListeMatricesChiffrement listeMats, SortedSet<String> _dico)
			throws ConstructeurException
	{

		if (validerVecCaracteres(vecCars) && validerMatsEncodage(listeMats)
				&& validerDico(_dico))
		{
			vecCaracteres = vecCars;
			listeMatricesCandidates = listeMats;
			dico = _dico;
		}
		else
		{
			throw new ConstructeurException(
					"Les paramètres du constructeur sont invalide");
		}

	}

	@SuppressWarnings("unused")
	private void setVecCaracteres(VecteurDeCaracteres pVec)
	{
		if (validerVecCaracteres(pVec))
		{
			this.vecCaracteres = pVec;
		}
	}

	@SuppressWarnings("unused")
	private void setMatsEncodage(ListeMatricesChiffrement listeMats)
	{
		if (validerMatsEncodage(listeMats))
		{
			this.listeMatricesCandidates = listeMats;
		}
	}

	@SuppressWarnings("unused")
	private void setDico(SortedSet<String> dico)
	{
		if (validerDico(dico))
		{
			this.dico = dico;
		}
	}

	private static boolean validerVecCaracteres(VecteurDeCaracteres pVec)
	{
		return ((pVec != null) && (pVec.getTaille() > 0));
	}

	private static boolean validerMatsEncodage(
			ListeMatricesChiffrement listeMats)
	{
		return ((listeMats != null)
				&& (listeMats.getNombreMatricesCandidates() > 0));
	}

	private static boolean validerDico(SortedSet<String> dico)
	{
		return ((dico != null) && !dico.isEmpty());
	}

	/**
	 * Obtenir la matrice courante qui a été utilisée par l'encodage ou le
	 * décodage. Très utile pour les tests.
	 *
	 * @return la matrice courante utilisée à partir de l'objet
	 *         "listeMatricesCandidates".
	 */
	public int[][] getMatriceCourante()
	{
		return listeMatricesCandidates.getCopieMatriceCourante();
	}

	@Override
	public boolean validerMessageSelonDico(String message,
			float pourcentageDeReussite)
	{
		String[] allWords = message.split(" ");
		int wordsFound = 0;
		int totalWords = 0;
		for (String word : allWords)
		{
			if (!word.equals(" "))
			{
				totalWords++;

				if (dico.contains(word.toLowerCase()))
				{
					wordsFound++;
					// System.out.println("added");
				}
			}
			// if(wordsFound!=0 || allWords[0].equals("SALUT"))
			// System.out.println(wordsFound);
		}
		return (wordsFound / totalWords) >= pourcentageDeReussite;
	}

	@Override
	public String ajusterMessageBrute(String message, int longVoulue)
	{

		for (int i = 0; i < longVoulue; i++)
		{
			message += CAR_DE_COMPLEMENT;
		}

		return message;
	}

	@Override
	public String encoder(String message)
	{

		listeMatricesCandidates.choisirMatriceCourante();
		message = ajusterMessageBrute(message, listeMatricesCandidates
				.getDimension()
				- (message.length() % listeMatricesCandidates.getDimension()));
		int[][] mat = getMatriceCourante();
		// int[][] mat = {{1,3,4},{5,6,7},{8,9,10}};
		String[] cuts = new String[message.length()
				/ listeMatricesCandidates.getDimension()];
		for (int i = 0; i < cuts.length; i++)
		{
			cuts[i] = message.substring(
					i * listeMatricesCandidates.getDimension(),
					(i + 1) * listeMatricesCandidates.getDimension());
		}
		String encode = "";

		for (int i = 0; i < cuts.length; i++)
		{
			for (int row = 0; row < listeMatricesCandidates
					.getDimension(); row++)
			{
				int charIndex = 0;
				for (int col = 0; col < listeMatricesCandidates
						.getDimension(); col++)
				{
					charIndex += mat[row][col] * vecCaracteres
							.getIndice(cuts[i].toUpperCase().charAt(col));
				}
				charIndex = MathUtilitaires.modulo(charIndex,
						vecCaracteres.getTaille());
				encode += vecCaracteres.getCaractere(charIndex);
			}
		}

		return encode;
	}

	@Override
	// TODO decoder - Compléter le code de la méthode
	public String decoder(String message)
	{
		String decode = "";
		boolean found = false;
		for (int j = 0; j < listeMatricesCandidates
				.getNombreMatricesCandidates() && found == false; j++)
		{
			listeMatricesCandidates.choisirMatriceCourante(j);
			int[][] inverseMat = listeMatricesCandidates
					.getMatriceCouranteInverseHill();
			String[] cuts = new String[message.length()
					/ listeMatricesCandidates.getDimension()];
			// if(inverseMat[0][0]==27 && inverseMat[0][1]==2 &&
			// inverseMat[1][0]==2)
			// System.out.println(MatriceUtilitaires.toStringMat(inverseMat));

			for (int i = 0; i < cuts.length; i++)
			{
				cuts[i] = message.substring(
						i * listeMatricesCandidates.getDimension(),
						(i + 1) * listeMatricesCandidates.getDimension());
			}

			decode = "";
			for (int i = 0; i < cuts.length; i++)
			{
				for (int row = 0; row < listeMatricesCandidates
						.getDimension(); row++)
				{
					int charIndex = 0;
					for (int col = 0; col < listeMatricesCandidates
							.getDimension(); col++)
					{
						charIndex += inverseMat[row][col]
								* vecCaracteres.getIndice(cuts[i].charAt(col));
					}

					charIndex = charIndex % vecCaracteres.getTaille();
					decode += vecCaracteres.getCaractere(charIndex);
				}
			}

			found = validerMessageSelonDico(decode, POURCENTAGE_ACCEPTABLE);
			// if(inverseMat[0][0]==27 && inverseMat[0][1]==2 &&
			// inverseMat[1][0]==2)
			// System.out.println(decode);
		}
		// System.out.println(MatriceUtilitaires.toStringMat(getMatriceCourante())+found);
		return decode;
	}

	public static void main(String[] args)
	{
		Scanner sn = new Scanner(System.in);
		MessageChiffrerDechiffrer MS = new MessageChiffrerDechiffrer(
				new VecteurDeCaracteres(),
				new ListeMatricesChiffrement(1, 15, 3, 28), FichierUtilitaires
						.lireDictionnaire(new File("dictionnaire.txt")));

		String message = sn.nextLine();
		System.out.println();

		String encode = MS.encoder(message);
		System.out.println(encode);
		System.out.println();
		sn.nextLine();

		String decode = MS.decoder(encode);
		System.out.println(decode);
		System.out.println("-------------------");
		sn.close();

	}
}
