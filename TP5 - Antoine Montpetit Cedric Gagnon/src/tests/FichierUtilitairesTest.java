package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import utilitaires.FichierUtilitaires;

public class FichierUtilitairesTest
{
	public static String MESSAGE_TEST;
	public static File TEST_FILE;
	public static final File NOM_FAUX_DICT = new File("JUnit/faux_dict.txt");

	@Before
	public void Before()
	{
		MESSAGE_TEST = "Ceci est le message de test";
		TEST_FILE = new File(
				"JUnit/" + (int) (Math.random() * 100000000) + ".txt");
	}

	@Test
	public void testEnregistrerMessage()
	{
		FichierUtilitaires.enregistrerMessage(MESSAGE_TEST, TEST_FILE);
		String result = FichierUtilitaires.lireMessage(TEST_FILE);
		if (!result.equals(MESSAGE_TEST))
			fail("Écriture ou lecture fautive");
	}

	@Test
	public void testLireMessage()
	{
		FichierUtilitaires.enregistrerMessage(MESSAGE_TEST, TEST_FILE);
		String result = FichierUtilitaires.lireMessage(TEST_FILE);
		if (!result.equals(MESSAGE_TEST))
			fail("Écriture ou lecture fautive");
	}

	@Test
	public void testLireDictionnaire()
	{
		final String[] faux_dict =
		{ "abcde", "fghij", "klmno", "pqrts", "uvwxy", "z1234" };
		SortedSet<String> result = FichierUtilitaires
				.lireDictionnaire(NOM_FAUX_DICT);
		int i = 0;
		for (String val : result)
		{
			assertEquals(val, faux_dict[i]);
			i++;
		}

	}
}
