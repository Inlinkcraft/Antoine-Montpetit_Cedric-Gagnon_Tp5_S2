package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ConstructeurException;
import structures.ListeMatricesChiffrement;
import utilitaires.MatriceUtilitaires;

public class ListeMatricesChiffrementTest
{
	ListeMatricesChiffrement l1;

	@Before
	public void before()
	{
		l1 = new ListeMatricesChiffrement(1, 12, 3, 23);
	}

	@Test
	public void testListeMatricesChiffrement()
	{
		try
		{
			new ListeMatricesChiffrement(-1, 2, 1, 1); // min<0
			fail("Constructeur invalide est passé");
		}
		catch (ConstructeurException e)
		{
		}
		try
		{
			new ListeMatricesChiffrement(-1, -2, 1, 1); // max<0
			fail("Constructeur invalide est passé");
		}
		catch (ConstructeurException e)
		{
		}
		try
		{
			new ListeMatricesChiffrement(2, 1, 1, 1); // max<min
			fail("Constructeur invalide est passé");
		}
		catch (ConstructeurException e)
		{
		}
		try
		{
			new ListeMatricesChiffrement(1, 2, 0, 1); // dim<0
			fail("Constructeur invalide est passé");
		}
		catch (ConstructeurException e)
		{
		}
		try
		{
			new ListeMatricesChiffrement(1, 2, 1, 0); // coef<0
			fail("Constructeur invalide est passé");
		}
		catch (ConstructeurException e)
		{
		}
	}

	@Test
	public void testChoisirMatriceCourante()
	{
		l1.choisirMatriceCourante();
		assertEquals(l1.getCopieMatriceCourante()[0].length, 3);
		assertEquals(l1.getCopieMatriceCourante().length, 3);
		assertTrue(l1.getCopieMatriceCourante() != null);
		// comment autre sommes-nous supposés de tester la fonction, vraiment...
		// impossible d'accéder à la liste de matrices pour s'assurer qu'elle en
		// fait partie
	}

	@Test
	public void testChoisirMatriceCouranteInt()
	{
		l1.choisirMatriceCourante(2);
		assertTrue(l1.getCopieMatriceCourante() != null);
		l1.choisirMatriceCourante(-1);
		assertTrue(l1.getCopieMatriceCourante() == null);
		l1.choisirMatriceCourante(1000);
		assertTrue(l1.getCopieMatriceCourante() == null);
	}

	@Test
	public void testGetCopieMatriceCourante()
	{
		assertEquals(l1.getCopieMatriceCourante()[0].length, 3);
		assertEquals(l1.getCopieMatriceCourante().length, 3);
		assertTrue(l1.getCopieMatriceCourante() != null);
		// idem à testChoisirMatriceCourante, comment s'assurer que la copie est
		// pareille à la courante sans accès à la courante
	}

	@Test
	public void testGetMatriceCouranteInverseHill()
	{
		int det = MatriceUtilitaires.getDeterminantInverseHill(
				MatriceUtilitaires.getDeterminant(l1.getCopieMatriceCourante()),
				l1.getCoefDansZ());
		int[][] expected1 = MatriceUtilitaires.getMatModuloX(
				MatriceUtilitaires.getMatMultScalaire(MatriceUtilitaires
						.getMatAdjointe(l1.getCopieMatriceCourante()), det),
				l1.getCoefDansZ());
		for (int i = 0; i < l1.getMatriceCouranteInverseHill().length; i++)
		{
			for (int j = 0; j < l1
					.getMatriceCouranteInverseHill()[i].length; j++)
				assertEquals(expected1[i][j],
						l1.getMatriceCouranteInverseHill()[i][j]);
		}
	}

}
