package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ConstructeurException;
import structures.VecteurDeCaracteres;

public class VecteurDeCaracteresTest
{
	
	VecteurDeCaracteres v1,v2;

	
	@Before
	public void before() {
		v1 = new VecteurDeCaracteres();
		v2 = new VecteurDeCaracteres(new char[] {'a','b','c','√','π','∑'});
	}

	@Test
	public void testVecteurDeCaracteresCharArray()
	{
		try {
			new VecteurDeCaracteres(new char[]{});
			new VecteurDeCaracteres(null);
			fail("Constructeur invalide est passé");
		}
		catch(ConstructeurException e) {}
	}

	@Test
	public void testGetCaractere()
	{
		assertEquals(v1.getCaractere(0),'A');
		assertEquals(v2.getCaractere(3),'√');
		try {
			v1.getCaractere(-1);
			fail("Index oob non détecté");
		}
		catch(ArrayIndexOutOfBoundsException e) {}
	}

	@Test
	public void testGetIndice()
	{
		assertEquals(v1.getIndice('G'),6);
		assertEquals(v2.getIndice('Π'),4);
		assertEquals(v1.getIndice(' '),26);
		assertEquals(v2.getIndice('B'),1);
		
		assertEquals(v1.getIndice('∑'),-1);
		assertEquals(v2.getIndice('0'),-1);
	}

	@Test
	public void testGetTaille()
	{
		assertEquals(v1.getTaille(),28);
		assertEquals(v2.getTaille(),6);
	}

}
