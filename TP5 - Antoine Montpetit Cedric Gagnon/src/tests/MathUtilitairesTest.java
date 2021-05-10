package tests;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

import utilitaires.MathUtilitaires;

public class MathUtilitairesTest
{

	@Test
	public void testFact()
	{
		assertTrue(MathUtilitaires.fact(2) == 2);
		assertTrue(MathUtilitaires.fact(3) == 6.0);
		assertTrue(MathUtilitaires.fact(4) == 24.0);
		assertTrue(MathUtilitaires.fact(5) == 120.0);
		assertTrue(MathUtilitaires.fact(6) == 720.0);
		assertTrue(MathUtilitaires.fact(7) == 5040.0);
		assertTrue(MathUtilitaires.fact(8) == 40320.0);
	}

	@Test
	public void testModulo()
	{
		assertEquals(MathUtilitaires.modulo(30, 2), 0);
		assertEquals(MathUtilitaires.modulo(20, 15), 5);
		assertEquals(MathUtilitaires.modulo(10, -6), -2);
		assertEquals(MathUtilitaires.modulo(-10, -6), -4);
		assertEquals(MathUtilitaires.modulo(-20, 15), 10);
		assertEquals(MathUtilitaires.modulo(-30, 2), 0);

		try
		{
			MathUtilitaires.modulo(0, 0);
			fail("Aucune éreur pour le modulo");
		}
		catch (ArithmeticException e)
		{
		}

	}

	@Test
	public void testDiviseursDe()
	{
		TreeSet<Integer> t1 = new TreeSet<Integer>();
		t1.add(1);
		t1.add(2);
		assertTrue(
				t1.equals((TreeSet<Integer>) MathUtilitaires.diviseursDe(2)));

		TreeSet<Integer> t2 = new TreeSet<Integer>();
		t2.add(1);
		t2.add(2);
		t2.add(5);
		t2.add(10);
		assertTrue(
				t2.equals((TreeSet<Integer>) MathUtilitaires.diviseursDe(10)));

		TreeSet<Integer> t3 = new TreeSet<Integer>();
		t3.add(1);
		t3.add(2);
		t3.add(3);
		t3.add(4);
		t3.add(6);
		t3.add(8);
		t3.add(12);
		t3.add(24);
		assertTrue(
				t3.equals((TreeSet<Integer>) MathUtilitaires.diviseursDe(24)));

	}

	@Test
	public void testEstPremier()
	{
		assertTrue(MathUtilitaires.estPremier(2));
		assertTrue(MathUtilitaires.estPremier(3));
		assertTrue(MathUtilitaires.estPremier(5));
		assertTrue(MathUtilitaires.estPremier(7));
		assertTrue(MathUtilitaires.estPremier(2633));
		assertTrue(MathUtilitaires.estPremier(5737));
		assertTrue(MathUtilitaires.estPremier(2147483647));
	}

	@Test
	public void testXPremier()
	{
		TreeSet<Integer> t1 = new TreeSet<Integer>();
		t1.add(2);
		t1.add(3);
		t1.add(5);
		assertTrue(t1.equals((TreeSet<Integer>) MathUtilitaires.xPremier(6)));

		TreeSet<Integer> t2 = new TreeSet<Integer>();
		t2.add(2);
		t2.add(3);
		t2.add(5);
		t2.add(7);
		assertTrue(t2.equals((TreeSet<Integer>) MathUtilitaires.xPremier(10)));

		TreeSet<Integer> t3 = new TreeSet<Integer>();
		t3.add(2);
		t3.add(3);
		t3.add(5);
		t3.add(7);
		t3.add(11);
		t3.add(13);
		t3.add(17);
		t3.add(19);
		assertTrue(t3.equals((TreeSet<Integer>) MathUtilitaires.xPremier(20)));
	}

	@Test
	public void testPGCD()
	{
		assertEquals(MathUtilitaires.PGCD(50, 90), 10);
		assertEquals(MathUtilitaires.PGCD(57, 63), 3);
		assertEquals(MathUtilitaires.PGCD(80, 4504), 8);
		assertEquals(MathUtilitaires.PGCD(5412, 632), 4);
		assertEquals(MathUtilitaires.PGCD(8792, 15), 1);

	}

	@Test
	public void testXPremierEntreEux()
	{

		TreeSet<Integer> t1 = new TreeSet<Integer>();
		t1.add(7);
		t1.add(9);
		t1.add(11);
		t1.add(13);
		t1.add(17);
		t1.add(19);
		assertTrue(t1.equals(
				(TreeSet<Integer>) MathUtilitaires.xPremierEntreEux(5, 20)));

		TreeSet<Integer> t2 = new TreeSet<Integer>();
		t2.add(11);
		t2.add(13);
		t2.add(17);
		t2.add(19);
		t2.add(21);
		t2.add(23);
		t2.add(27);
		t2.add(29);
		t2.add(31);
		t2.add(33);
		t2.add(37);
		t2.add(39);
		t2.add(41);
		t2.add(43);
		t2.add(47);
		t2.add(49);
		assertTrue(t2.equals(
				(TreeSet<Integer>) MathUtilitaires.xPremierEntreEux(10, 50)));

		TreeSet<Integer> t3 = new TreeSet<Integer>();
		t3.add(97);
		t3.add(99);
		t3.add(101);
		t3.add(103);
		t3.add(107);
		t3.add(109);
		t3.add(111);
		t3.add(113);
		t3.add(117);
		t3.add(121);
		t3.add(123);
		t3.add(127);
		t3.add(129);
		t3.add(121);
		t3.add(123);
		t3.add(127);
		t3.add(129);
		t3.add(131);
		t3.add(137);
		t3.add(139);
		assertTrue(t3.equals(
				(TreeSet<Integer>) MathUtilitaires.xPremierEntreEux(97, 140)));
	}

	@Test
	public void testAlea()
	{
		int pareil = 0;
		int min = 5;
		int max = 20;
		int[] chiffreAleo1 = new int[1000];
		int[] chiffreAleo2 = new int[1000];

		for (int i = 0; i < chiffreAleo1.length; i++)
		{
			chiffreAleo1[i] = min + (i % (max - min));
		}

		for (int i = 0; i < chiffreAleo2.length; i++)
		{
			chiffreAleo2[i] = MathUtilitaires.alea(min, max);
		}

		for (int i = 0; i < chiffreAleo2.length; i++)
		{
			if (chiffreAleo2[i] == chiffreAleo1[i])
			{
				pareil++;
			}
		}

		if (pareil / chiffreAleo1.length > 0.1)
		{
			fail("Les chiffre ne sont pas assé aléatoire");
		}

	}

}
