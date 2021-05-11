package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import structures.ListeMatricesChiffrement;
import structures.MessageChiffrerDechiffrer;
import structures.VecteurDeCaracteres;
import utilitaires.FichierUtilitaires;
import utilitaires.MathUtilitaires;

public class MessageChiffrerDechiffrerTest
{

	MessageChiffrerDechiffrer mCD1, mCD2, mCD3;
	
	@Before
	public void beforeMessageChiffrerDechiffrer()
	{
		mCD1 = new MessageChiffrerDechiffrer(new VecteurDeCaracteres(), new ListeMatricesChiffrement(1, 15, 3, 28),FichierUtilitaires.lireDictionnaire(new File("dictionnaire.txt")));
		mCD2 = new MessageChiffrerDechiffrer(new VecteurDeCaracteres(), new ListeMatricesChiffrement(1, 16, 3, 28),FichierUtilitaires.lireDictionnaire(new File("dictionnaire.txt")));
		mCD3 = new MessageChiffrerDechiffrer(new VecteurDeCaracteres(), new ListeMatricesChiffrement(1, 17, 3, 28),FichierUtilitaires.lireDictionnaire(new File("dictionnaire.txt")));
	}
	
	@After
	public void afterMessageChiffrerDechiffrer()
	{
		mCD1 = null;
		mCD2 = null;
		mCD3 = null;
	}

	@Test
	public void testGetMatriceCourante()
	{
		assertTrue(mCD1.getMatriceCourante() != null);
		assertTrue(mCD2.getMatriceCourante() != null);
		assertTrue(mCD3.getMatriceCourante() != null);
		assertTrue(mCD1.getMatriceCourante().length == 3 && mCD1.getMatriceCourante()[0].length == 3 );
		assertTrue(mCD2.getMatriceCourante().length == 3 && mCD2.getMatriceCourante()[0].length == 3 );
		assertTrue(mCD3.getMatriceCourante().length == 3 && mCD3.getMatriceCourante()[0].length == 3 );
	}

	@Test
	public void testValiderMessageSelonDico()
	{
		assertTrue(mCD1.validerMessageSelonDico("IL EST LE MEILLEUR AU MONDE", 0.1f));
		assertTrue(mCD2.validerMessageSelonDico("MAIS LUI LES TOUS AUSSI", 0.1f));
		assertTrue(mCD3.validerMessageSelonDico("JE CROIT QUE CES PHRASE FONCTIONNE", 0.1f));
		assertFalse(mCD1.validerMessageSelonDico("IMA BREAK YOU", 0.1f));
		assertFalse(mCD2.validerMessageSelonDico("ENGLIDH IS NOT ITS STRONG POINT", 0.1f));
		assertFalse(mCD3.validerMessageSelonDico("WELL WELL A LEGAL PLACE FOR ENGLISH XD", 0.1f));
	}

	@Test
	public void testAjusterMessageBrute()
	{
		
		assertEquals(mCD1.ajusterMessageBrute("Hello", 6), "Hello      ");
		assertEquals(mCD2.ajusterMessageBrute("Hello", 10), "Hello          ");
		assertEquals(mCD3.ajusterMessageBrute("Hum", 4), "Hum    ");
		assertEquals(mCD2.ajusterMessageBrute("Antoine", 10), "Antoine          ");
		assertEquals(mCD1.ajusterMessageBrute("Cedric", 12), "Cedric            ");
	}

	@Test
	public void testEncoder()
	{
		
		/*
		 * 
		 * Cette méthode ne peut être testé de façons rigoureuse
		 * car nous n'avons pas acces a la liste de matrice candidate
		 * qui ce trouve a l'intérieur du messageChiffrerDéchiffrer
		 * 
		 * j'ai alors écrit ce code qui ne fait que comparer si la sortie 
		 * etait suffisament différente
		 * 
		 */
		
		String m1 = "banane de carrote";
		String cm1 = mCD1.encoder(m1);
		int same1 = 0;
		for (int i = 0; i < m1.length(); i++)
		{
			if(m1.charAt(i) == cm1.charAt(i)) {
				same1 ++;
			}
		}
		assertTrue(same1/cm1.length() < 0.1f);
		
		String m2 = "ces pas bon des banane";
		String cm2 = mCD2.encoder(m2);
		int same2 = 0;
		for (int i = 0; i < m2.length(); i++)
		{
			if(m2.charAt(i) == cm2.charAt(i)) {
				same2 ++;
			}
		}
		assertTrue(same2/cm2.length() < 0.1f);
		
		String m3 = "pourquoi je parle de fruit et de crudité";
		String cm3 = mCD3.encoder(m3);
		int same3 = 0;
		for (int i = 0; i < m3.length(); i++)
		{
			if(m3.charAt(i) == cm3.charAt(i)) {
				same3 ++;
			}
		}
		assertTrue(same3/cm3.length() < 0.1f);
	}

	@Test
	public void testDecoder()
	{
		String m1 = "CBESLB";
		assertEquals(mCD1.decoder(m1), "HELLO ");
		String m2 = "ZMW-WLMUK";
		assertEquals(mCD2.decoder(m2), "BANANE   ");
		String m3 = "B-ZYOYQEW";
		assertEquals(mCD3.decoder(m3), "GARAGE   ");
	}

}
