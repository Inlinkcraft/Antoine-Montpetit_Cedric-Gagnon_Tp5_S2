package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilitaires.MatriceUtilitaires;

public class MatriceUtilitairesTest
{

	int[][] m1, m2, m3, m4, m5, m6;
	
	@Before
	public void matricesInitialization() {
		
		int[][] _m1 = {
				{1,2},
				{-5,3}
		};
		m1 = _m1;
		
		int[][] _m2 = {
				{0,0},
				{0,0}
		};
		m2 = _m2;
		
		int[][] _m3 = {
				{2,5,-7},
				{5,2,9},
				{3,7,-8}
		};
		m3 = _m3;
		
		int[][] _m4 = {
				{-9,2,2,0},
				{0,4,-9,3},
				{7,5,2,1},
				{3,-8,5,9}
		};
		m4 = _m4;
		
		int[][] _m5 = {
				{-9,7,3,4,-5},
				{1,2,-9,-9,5},
				{4,-6,0,2,-9},
				{1,9,3,7,-4},
				{7,0,-3,4,8}
		};
		m5 = _m5;
		
		int[][] _m6 = {
				{-9,7,3,4,-5},
				{1,2,-5,-9,1},
				{4,6,9,2,-9},
				{1,-9,3,0,-4},
				{4,0,3,9,8}
		};
		m6 = _m6;
	}
	
	@After
	public void afterMatice() {
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		m5 = null;
		m6 = null;
	}
	
	@Test
	public void testToStringMat()
	{
		assertEquals(MatriceUtilitaires.toStringMat(m1),"[1, 2]\n[-5, 3]\n");
		assertEquals(MatriceUtilitaires.toStringMat(m2),"[0, 0]\n" + "[0, 0]\n");
		assertEquals(MatriceUtilitaires.toStringMat(m3),"[2, 5, -7]\n" + "[5, 2, 9]\n" + "[3, 7, -8]\n");
		assertEquals(MatriceUtilitaires.toStringMat(m4),"[-9, 2, 2, 0]\n" + "[0, 4, -9, 3]\n" + "[7, 5, 2, 1]\n" + "[3, -8, 5, 9]\n");
		assertEquals(MatriceUtilitaires.toStringMat(m5),"[-9, 7, 3, 4, -5]\n" + "[1, 2, -9, -9, 5]\n" + "[4, -6, 0, 2, -9]\n" + "[1, 9, 3, 7, -4]\n" + "[7, 0, -3, 4, 8]\n");
		assertEquals(MatriceUtilitaires.toStringMat(m6),"[-9, 7, 3, 4, -5]\n" + "[1, 2, -5, -9, 1]\n" + "[4, 6, 9, 2, -9]\n" + "[1, -9, 3, 0, -4]\n" + "[4, 0, 3, 9, 8]\n");
	}


	@Test
	public void testGetMatTranspose()
	{
		
		int[][] _m1 = {{1,-5},{2,3}};
		m1 = MatriceUtilitaires.getMatTranspose(m1);
		for (int x = 0; x < m1.length; x++)
		{
			for (int y = 0; y < m1.length; y++)
			{
				assertEquals(m1[x][y], _m1[x][y]); 
			}
		}
		
		int[][] _m2 = {{0, 0},{0, 0}};
		m2 = MatriceUtilitaires.getMatTranspose(m2);
		for (int x = 0; x < m2.length; x++)
		{
			for (int y = 0; y < m2.length; y++)
			{
				assertEquals(m2[x][y], _m2[x][y]); 
			}
		}
		
		int[][] _m3 = {{2,5,3},{5,2,7},{-7,9,-8}};
		m3 = MatriceUtilitaires.getMatTranspose(m3);
		for (int x = 0; x < m3.length; x++)
		{
			for (int y = 0; y < m3.length; y++)
			{
				assertEquals(m3[x][y], _m3[x][y]); 
			}
		}
		
		int[][] _m4 = {{-9,0,7,3},{2,4,5,-8},{2,-9,2,5},{0,3,1,9}};
		m4 = MatriceUtilitaires.getMatTranspose(m4);
		for (int x = 0; x < m4.length; x++)
		{
			for (int y = 0; y < m4.length; y++)
			{
				assertEquals(m4[x][y], _m4[x][y]); 
			}
		}
		
		int[][] _m5 = {{-9,1,4,1,7},{7,2,-6,9,0},{3,-9,0,3,-3},{4,-9,2,7,4},{-5,5,-9,-4,8}};
		m5 = MatriceUtilitaires.getMatTranspose(m5);
		for (int x = 0; x < m5.length; x++)
		{
			for (int y = 0; y < m5.length; y++)
			{
				assertEquals(m5[x][y], _m5[x][y]); 
			}
		}
		
		int[][] _m6 = {{-9,1,4,1,4},{7,2,6,-9,0},{3,-5,9,3,3},{4,-9,2,0,9},{-5,1,-9,-4,8}};
		m6 = MatriceUtilitaires.getMatTranspose(m6);
		for (int x = 0; x < m6.length; x++)
		{
			for (int y = 0; y < m6.length; y++)
			{
				assertEquals(m6[x][y], _m6[x][y]); 
			}
		}
		
	}

	@Test
	public void testGetMatMultScalaire()
	{
		int[][] _m1 = {{10,20},{-50,30}};
		m1 = MatriceUtilitaires.getMatMultScalaire(m1,10);
		for (int x = 0; x < m1.length; x++)
		{
			for (int y = 0; y < m1.length; y++)
			{
				assertEquals(m1[x][y], _m1[x][y]); 
			}
		}
		
		int[][] _m2 = {{0, 0},{0, 0}};
		m2 = MatriceUtilitaires.getMatMultScalaire(m2,10);
		for (int x = 0; x < m2.length; x++)
		{
			for (int y = 0; y < m2.length; y++)
			{
				assertEquals(m2[x][y], _m2[x][y]); 
			}
		}
		
		int[][] _m3 = {{18,45,-63},{45,18,81},{27,63,-72}};
		m3 = MatriceUtilitaires.getMatMultScalaire(m3, 9);
		for (int x = 0; x < m3.length; x++)
		{
			for (int y = 0; y < m3.length; y++)
			{
				assertEquals(m3[x][y], _m3[x][y]); 
			}
		}
		
		int[][] _m4 = {{-18,4,4,0},{0,8,-18,6},{14,10,4,2},{6,-16,10,18}};
		m4 = MatriceUtilitaires.getMatMultScalaire(m4,2);
		for (int x = 0; x < m4.length; x++)
		{
			for (int y = 0; y < m4.length; y++)
			{
				assertEquals(m4[x][y], _m4[x][y]); 
			}
		}
		
		int[][] _m5 = {{9,-7,-3,-4,5},{-1,-2,9,9,-5},{-4,6,0,-2,9},{-1,-9,-3,-7,4},{-7,-0,3,-4,-8}};
		m5 = MatriceUtilitaires.getMatMultScalaire(m5,-1);
		for (int x = 0; x < m5.length; x++)
		{
			for (int y = 0; y < m5.length; y++)
			{
				assertEquals(m5[x][y], _m5[x][y]); 
			}
		}
		
		int[][] _m6 = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		m6 = MatriceUtilitaires.getMatMultScalaire(m6,0);
		for (int x = 0; x < m6.length; x++)
		{
			for (int y = 0; y < m6.length; y++)
			{
				assertEquals(m6[x][y], _m6[x][y]); 
			}
		}
	}

	@Test
	public void testGetMatModuloX()
	{
		
		int[][] _m1 = {{1,2},{0,3}};
		m1 = MatriceUtilitaires.getMatModuloX(m1,5);
		for (int x = 0; x < m1.length; x++)
		{
			for (int y = 0; y < m1.length; y++)
			{
				assertEquals(m1[x][y], _m1[x][y]); 
			}
		}
		
		int[][] _m2 = {{0, 0},{0, 0}};
		m2 = MatriceUtilitaires.getMatModuloX(m2,10);
		for (int x = 0; x < m2.length; x++)
		{
			for (int y = 0; y < m2.length; y++)
			{
				assertEquals(m2[x][y], _m2[x][y]); 
			}
		}
		
		int[][] _m3 = {{2,5,8},{5,2,9},{3,7,7}};
		m3 = MatriceUtilitaires.getMatModuloX(m3, 15);
		for (int x = 0; x < m3.length; x++)
		{
			for (int y = 0; y < m3.length; y++)
			{
				assertEquals(m3[x][y], _m3[x][y]); 
			}
		}
		
		int[][] _m4 = {{11,2,2,0},{0,4,11,3},{7,5,2,1},{3,12,5,9}};
		m4 = MatriceUtilitaires.getMatModuloX(m4,20);
		for (int x = 0; x < m4.length; x++)
		{
			for (int y = 0; y < m4.length; y++)
			{
				assertEquals(m4[x][y], _m4[x][y]); 
			}
		}
		
		int[][] _m5 = {{16,7,3,4,20},{1,2,16,16,5},{4,19,0,2,16},{1,9,3,7,21},{7,0,22,4,8}};
		m5 = MatriceUtilitaires.getMatModuloX(m5,25);
		for (int x = 0; x < m5.length; x++)
		{
			for (int y = 0; y < m5.length; y++)
			{
				assertEquals(m5[x][y], _m5[x][y]); 
			}
		}
		
		int[][] _m6 = {{21,7,3,4,25},{1,2,25,21,1},{4,6,9,2,21},{1,21,3,0,26},{4,0,3,9,8}};
		m6 = MatriceUtilitaires.getMatModuloX(m6,30);
		for (int x = 0; x < m6.length; x++)
		{
			for (int y = 0; y < m6.length; y++)
			{
				assertEquals(m6[x][y], _m6[x][y]); 
			}
		}
	}

	@Test
	public void testGetDeterminant()
	{
		assertEquals(MatriceUtilitaires.getDeterminant(m1), 13);
		assertEquals(MatriceUtilitaires.getDeterminant(m2), 0);
		assertEquals(MatriceUtilitaires.getDeterminant(m3), -26);
		assertEquals(MatriceUtilitaires.getDeterminant(m4), -8028);
		assertEquals(MatriceUtilitaires.getDeterminant(m5), 69366);
		assertEquals(MatriceUtilitaires.getDeterminant(m6), 30291);
	}

	@Test
	public void testGetMatCofacteurs()
	{
		
		int[][] _m1 = {{3,5},{-2,1}};
		m1 = MatriceUtilitaires.getMatCofacteurs(m1);
		for (int x = 0; x < m1.length; x++)
		{
			for (int y = 0; y < m1.length; y++)
			{
				assertEquals(m1[x][y], _m1[x][y]); 
			}
		}
		
		int[][] _m2 = {{0, 0},{0, 0}};
		m2 = MatriceUtilitaires.getMatCofacteurs(m2);
		for (int x = 0; x < m2.length; x++)
		{
			for (int y = 0; y < m2.length; y++)
			{
				assertEquals(m2[x][y], _m2[x][y]); 
			}
		}
		
		int[][] _m3 = {{-79,67,29},{-9,5,1},{59,-53,-21}};
		m3 = MatriceUtilitaires.getMatCofacteurs(m3);
		for (int x = 0; x < m3.length; x++)
		{
			for (int y = 0; y < m3.length; y++)
			{
				assertEquals(m3[x][y], _m3[x][y]); 
			}
		}
		
		int[][] _m4 = {{652,-627,-453,-523},{80,-237,597,-569},{-312,-882,-522,-390},{8,177,-141,-659}};
		m4 = MatriceUtilitaires.getMatCofacteurs(m4);
		for (int x = 0; x < m4.length; x++)
		{
			for (int y = 0; y < m4.length; y++)
			{
				assertEquals(m4[x][y], _m4[x][y]); 
			}
		}
	}

	@Test
	public void testGetMatAdjointe()
	{
		
		int[][] _m1 = {{3,-2},{5,1}};
		m1 = MatriceUtilitaires.getMatAdjointe(m1);
		for (int x = 0; x < m1.length; x++)
		{
			for (int y = 0; y < m1.length; y++)
			{
				assertEquals(m1[x][y], _m1[x][y]); 
			}
		}
		
		int[][] _m2 = {{0, 0},{0, 0}};
		m2 = MatriceUtilitaires.getMatAdjointe(m2);
		for (int x = 0; x < m2.length; x++)
		{
			for (int y = 0; y < m2.length; y++)
			{
				assertEquals(m2[x][y], _m2[x][y]); 
			}
		}
		
		int[][] _m3 = {{-79,-9,59},{67,5,-53},{29,1,-21}};
		m3 = MatriceUtilitaires.getMatAdjointe(m3);
		for (int x = 0; x < m3.length; x++)
		{
			for (int y = 0; y < m3.length; y++)
			{
				assertEquals(m3[x][y], _m3[x][y]); 
			}
		}
		
		int[][] _m4 = {{652,80,-312,8},{-627,-237,-882,177},{-453,597,-522,-141},{-523,-569,-390,-659}};
		m4 = MatriceUtilitaires.getMatAdjointe(m4);
		for (int x = 0; x < m4.length; x++)
		{
			for (int y = 0; y < m4.length; y++)
			{
				assertEquals(m4[x][y], _m4[x][y]); 
			}
		}
	}

}
